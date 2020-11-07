// Main Activity.java
//input data to a custom layout
//change the date format to better indicate the date and time period
//add icon for restaurant and Hazard indicators


package com.example.cmpt276group05.ui;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.DynamicLayout;
import android.text.Layout;
import android.text.style.DynamicDrawableSpan;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.cmpt276group05.R;
import com.example.cmpt276group05.model.Inspection;
import com.example.cmpt276group05.model.InspectionManager;
import com.example.cmpt276group05.model.Restaurant;
import com.example.cmpt276group05.model.RestaurantManager;

import org.w3c.dom.Text;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.chrono.ThaiBuddhistDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private RestaurantManager restaurantManager;
    private InspectionManager inspectionManager;

    int images[] = {R.drawable.one,R.drawable.two,R.drawable.three,R.drawable.four,R.drawable.one,R.drawable.two,R.drawable.three,R.drawable.four};
    ArrayList<String> TName= new ArrayList<String>();
    ArrayList<String> TIssue= new ArrayList<String>();
    ArrayList<String> THazardC= new ArrayList<String>();
    ArrayList<Integer> HazardSelection= new ArrayList<Integer>();
    int THazardI[] = {R.mipmap.low,R.mipmap.mid,R.mipmap.high};
    ArrayList<String> TDate= new ArrayList<String>();

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
             }
             catch (NullPointerException e) {
                 THazardC.add("Low");
                 TIssue.add("No Inspection found");
                 TDate.add("No Inspection found");
             }

        }

        arrayAdapter adapter = new arrayAdapter(this,TName,TIssue,THazardC,HazardSelection,TDate);
        listview.setAdapter(adapter );

        //onClickListener

        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(MainActivity.this,"Selected",Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(MainActivity.this,InspectionList.class);
                //please put your activities name on the class above!
                intent.putExtra("Tracking_Number",restaurantManager.get(position).getTrackingNumber());
                startActivity(intent);
            }
        });

        startActivity(new Intent(this, MapsActivity.class));

    }//onCreate






        class arrayAdapter extends ArrayAdapter<String> {


            Context context;
            String Name[];
            String issue[];
            String hazardC[];
            int hazardI[];
            String date[];

            arrayAdapter(Context cont, ArrayList<String> name, ArrayList<String> issue, ArrayList<String> hazardC, ArrayList<Integer> hazardI, ArrayList<String> date){
                 super(cont,R.layout.customview,R.id.name,name);
                  this.context = cont;
                  this.Name = TName.toArray(new String[0]);
                  this.issue = TIssue.toArray(new String[0]);
                  this.hazardC  = THazardC.toArray(new String[0]);
                  this.hazardI = THazardI;
                  this.date = TDate.toArray(new String[0]);
            }

            @NonNull
            @Override
            public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
                LayoutInflater layoutinflater =(LayoutInflater)getApplicationContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);

                View view = layoutinflater.inflate(R.layout.customview,parent,false);
                DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");

                ImageView resIcon =  view.findViewById(R.id.image);
                TextView name = view.findViewById(R.id.name);
                TextView dates = view.findViewById(R.id.date);
                TextView issues = view.findViewById(R.id.issue);
                TextView hazardcolors = view.findViewById(R.id.hazardcolor);
                ImageView HazardIcons =  view.findViewById(R.id.hazardicon);

                resIcon.setImageResource(images[position]);
                name.setText(Name[position]);
                dates.setText("Latest inspection:\n" + date[position]);
                issues.setText("# of issues found: " + issue[position]);

                if(hazardC[position].equals("Low")){
                    HazardIcons.setImageResource(hazardI[0]);
                }else if (hazardC[position].equals("Moderate")){
                    HazardIcons.setImageResource(hazardI[1]);
                }else if(hazardC[position].equals("High")){
                    HazardIcons.setImageResource(hazardI[2]);
                }


                return view;
            }
        }//arrayAdapter
}//class
