// Main Activity.java
//input data to a custom layout
//change the date format to better indicate the date and time period
//add icon for restaurant and Hazard indicators


package com.example.cmpt276group05.ui;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.example.cmpt276group05.R;
import com.example.cmpt276group05.callback.DownloadListener;
import com.example.cmpt276group05.constant.BusinessConstant;
import com.example.cmpt276group05.model.Inspection;
import com.example.cmpt276group05.model.InspectionEntry;
import com.example.cmpt276group05.model.InspectionManager;
import com.example.cmpt276group05.model.Restaurant;
import com.example.cmpt276group05.model.RestaurantEntry;
import com.example.cmpt276group05.model.RestaurantManager;
import com.example.cmpt276group05.net.ApiService;
import com.example.cmpt276group05.net.RetrofitManager;
import com.example.cmpt276group05.utils.FileUtils;
import com.example.cmpt276group05.widget.BaseDialog;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import okhttp3.Interceptor;
import okhttp3.ResponseBody;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class MainActivity extends AppCompatActivity {
    private RestaurantManager restaurantManager;
    private InspectionManager inspectionManager;
    private BaseDialog loadDialog;
    public static final String TAG = MainActivity.class.getName();

    int images[] = {R.drawable.one, R.drawable.two, R.drawable.three, R.drawable.four};
    ArrayList<String> TName = new ArrayList<String>();
    ArrayList<String> TIssue = new ArrayList<String>();
    ArrayList<String> THazardC = new ArrayList<String>();
    ArrayList<Integer> HazardSelection = new ArrayList<Integer>();
    int THazardI[] = {R.mipmap.low, R.mipmap.mid, R.mipmap.high};
    ArrayList<String> TDate = new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ActionBar actionbar1 = getSupportActionBar();
        actionbar1.setTitle("Surrey Restaurant Inspection");

        restaurantManager = RestaurantManager.getInstance(getApplicationContext());
        inspectionManager = InspectionManager.getInstance(getApplicationContext());

        ListView listview = (ListView) findViewById(R.id.list);


        for (int i = 0; i < restaurantManager.getNumRestaurant(); i++) {
            Restaurant res = restaurantManager.get(i);
            Log.d("print", String.valueOf(res));
            Inspection ins = inspectionManager.getMostRecentInspection(res.getTrackingNumber());
            Log.d("Print", String.valueOf(ins));
            TName.add(res.getName());
            // In case no inspections exist yet
            try {
                TIssue.add(String.valueOf(ins.getNumCritViolations() + ins.getNumNonCritViolations()));
                THazardC.add(ins.getHazardRating());
                TDate.add(ins.adjustTime());
            } catch (NullPointerException e) {
                THazardC.add("Low");
                TIssue.add("No Inspection found");
                TDate.add("No Inspection found");
            }

        }

        arrayAdapter adapter = new arrayAdapter(this, TName, TIssue, THazardC, HazardSelection, TDate);
        listview.setAdapter(adapter);

        //onClickListener

        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(MainActivity.this, "Selected", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(MainActivity.this, InspectionList.class);
                //please put your activities name on the class above!
                intent.putExtra("Tracking_Number", restaurantManager.get(position).getTrackingNumber());
                startActivity(intent);
            }
        });

        loadDialog = new BaseDialog(this,R.layout.dialog_loading);
        getUpdateData();
    }//onCreate


    class arrayAdapter extends ArrayAdapter<String> {
        Context context;
        String Name[];
        String issue[];
        String hazardC[];
        int hazardI[];
        String date[];

        arrayAdapter(Context cont, ArrayList<String> name, ArrayList<String> issue, ArrayList<String> hazardC, ArrayList<Integer> hazardI, ArrayList<String> date) {
            super(cont, R.layout.customview, R.id.name, name);
            this.context = cont;
            this.Name = TName.toArray(new String[0]);
            this.issue = TIssue.toArray(new String[0]);
            this.hazardC = THazardC.toArray(new String[0]);
            this.hazardI = THazardI;
            this.date = TDate.toArray(new String[0]);
        }

        @NonNull
        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
            LayoutInflater layoutinflater = (LayoutInflater) getApplicationContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);

            View view = layoutinflater.inflate(R.layout.customview, parent, false);
            DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");

            ImageView resIcon = view.findViewById(R.id.image);
            TextView name = view.findViewById(R.id.name);
            TextView dates = view.findViewById(R.id.date);
            TextView issues = view.findViewById(R.id.issue);
            TextView hazardcolors = view.findViewById(R.id.hazardcolor);
            ImageView HazardIcons = view.findViewById(R.id.hazardicon);

            resIcon.setImageResource(images[position%4]);
            name.setText(Name[position]);
            dates.setText("Latest inspection:\n" + date[position]);
            issues.setText("# of issues found: " + issue[position]);

            if (hazardC[position].equals("Low")) {
                HazardIcons.setImageResource(hazardI[0]);
            } else if (hazardC[position].equals("Moderate")) {
                HazardIcons.setImageResource(hazardI[1]);
            } else if (hazardC[position].equals("High")) {
                HazardIcons.setImageResource(hazardI[2]);
            }


            return view;
        }
    }//arrayAdapter

    //get updated data
    private void getUpdateData() {

        //restaurant data
        final Retrofit retrofit = RetrofitManager.getIntance(BusinessConstant.GET_BASE_URL);
        Call<RestaurantEntry> call = retrofit.create(ApiService.class).getData(BusinessConstant.API_RESTAURANT);
        call.enqueue(new Callback<RestaurantEntry>() {
            @Override
            public void onResponse(Call<RestaurantEntry> call, Response<RestaurantEntry> response) {
                if (response.body().getResult().getResources() != null && response.body().getResult().getResources().size() > 0) {
                    //get csv file
                    for (RestaurantEntry.ResultBean.ResourcesBean resourcesBean : response.body().getResult().getResources()) {
                        if (resourcesBean.getFormat().equals(BusinessConstant.CSV_FORMAT)) {
                            String url = resourcesBean.getUrl();
                            Log.i(TAG, url);

                            Retrofit retrofit1 = RetrofitManager.getIntance(BusinessConstant.GET_BASE_URL);

                            loadDialog.show();
                            int start = url.indexOf(BusinessConstant.DATA_SET);
                            if (start != -1) {
                                String param = url.substring(start);
                                Call<ResponseBody> csvCall = retrofit1.create(ApiService.class).download(param);
                                csvCall.enqueue(new Callback<ResponseBody>() {
                                    @Override
                                    public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                                        FileUtils.generateCsvFileFromStream(getExternalFilesDir(Environment.DIRECTORY_PICTURES)+BusinessConstant.RESTAURANT_CSV_FILE_PATH,
                                                response.body().byteStream(), response.body().contentLength(),
                                                new DownloadListener() {
                                                    @Override
                                                    public void onStart() {

                                                    }

                                                    @Override
                                                    public void onProgress(int progress) {

                                                    }

                                                    @Override
                                                    public void onFinish(String path) {
                                                        loadDialog.dismiss();
                                                    }

                                                    @Override
                                                    public void onFail(String errorInfo) {

                                                    }
                                                });
                                    }

                                    @Override
                                    public void onFailure(Call<ResponseBody> call, Throwable t) {

                                    }
                                });
                            }
                            break;
                        }
                    }
                }
            }

            @Override
            public void onFailure(Call<RestaurantEntry> call, Throwable t) {

            }
        });

        //inspection data
        Call<InspectionEntry> inspectionCall = retrofit.create(ApiService.class).getInspectionData(BusinessConstant.API_INSPECTION);
        inspectionCall.enqueue(new Callback<InspectionEntry>() {
            @Override
            public void onResponse(Call<InspectionEntry> call, Response<InspectionEntry> response) {
                if (response.body().getResult().getResources() != null && response.body().getResult().getResources().size() > 0) {
                    //get csv file
                    for (InspectionEntry.ResultBean.ResourcesBean resourcesBean : response.body().getResult().getResources()) {
                        if (resourcesBean.getFormat().equals(BusinessConstant.CSV_FORMAT)) {
                            String url = resourcesBean.getUrl();
                            Log.i(TAG, url);

                            Retrofit retrofit1 = RetrofitManager.getIntance(BusinessConstant.GET_BASE_URL);

                            loadDialog.show();
                            int start = url.indexOf(BusinessConstant.DATA_SET);
                            if (start != -1) {
                                String param = url.substring(start);
                                Call<ResponseBody> csvCall = retrofit1.create(ApiService.class).download(param);
                                csvCall.enqueue(new Callback<ResponseBody>() {
                                    @Override
                                    public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                                        FileUtils.generateCsvFileFromStream(getExternalFilesDir(Environment.DIRECTORY_PICTURES)+BusinessConstant.INSPECTION_CSV_FILE_PATH,
                                                response.body().byteStream(), response.body().contentLength(),
                                                new DownloadListener() {
                                                    @Override
                                                    public void onStart() {

                                                    }

                                                    @Override
                                                    public void onProgress(int progress) {

                                                    }

                                                    @Override
                                                    public void onFinish(String path) {
                                                        loadDialog.dismiss();
                                                    }

                                                    @Override
                                                    public void onFail(String errorInfo) {

                                                    }
                                                });
                                    }

                                    @Override
                                    public void onFailure(Call<ResponseBody> call, Throwable t) {

                                    }
                                });
                            }
                            break;
                        }
                    }
                }
            }

            @Override
            public void onFailure(Call<InspectionEntry> call, Throwable t) {

            }
        });
    }

    class LogCatInterceptor implements Interceptor {
        @Override
        public okhttp3.Response intercept(Chain chain) throws IOException {
            return new HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY).intercept(chain);
        }
    }
}//class
