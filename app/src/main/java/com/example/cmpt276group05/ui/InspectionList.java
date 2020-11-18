package com.example.cmpt276group05.ui;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.cmpt276group05.R;
import com.example.cmpt276group05.callback.ParseFinishListener;
import com.example.cmpt276group05.constant.BusinessConstant;
import com.example.cmpt276group05.model.Inspection;
import com.example.cmpt276group05.model.InspectionManager;
import com.example.cmpt276group05.model.Restaurant;
import com.example.cmpt276group05.model.RestaurantManager;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

public class InspectionList extends AppCompatActivity {

    private RestaurantManager restaurantManager;
    private Restaurant res;
    private InspectionManager inspectionManager;
    private List<Inspection> myInspection=new ArrayList<Inspection>();

    Button backBtn;
    ListView listview;
    ArrayList<String> instype=new ArrayList<String>();
    int [] cricissues = new int[50] ;
    int [] noncricissues=new int[50];
    ArrayList<String> hazardlevel=new ArrayList<String>();
    int hazardimages []={R.drawable.high1,R.drawable.moderate1,R.drawable.low1};
    ArrayList<String> TDate= new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.displayinspectionlist);


        Intent intent = getIntent();
        String trackingnum=intent.getStringExtra("Tracking_Number");

        restaurantManager=RestaurantManager.getInstance(this);
        res=restaurantManager.getByTrackingNumber(trackingnum);

        TextView displayrestaurantname=(TextView) findViewById(R.id.restaurantnametextView);
        displayrestaurantname.setText(res.getName());

        TextView displayrestaurantaddress=(TextView) findViewById(R.id.addresstextView);
        displayrestaurantaddress.setText(res.getAddress() + ", " + res.getCity());

        TextView displayrestaurantGpscord=(TextView) findViewById(R.id.GPScordtextview);


//        displayrestaurantGpscord.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//            }
//        });


        displayrestaurantGpscord.setText(""+res.getLatitude()+" Latitude "+res.getLongitude()+" Longitude");

        listview=(ListView) findViewById(R.id.InspectionListview);

        MyAdapter adapter=new MyAdapter(this,instype);

        listview.setAdapter(adapter);

        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                DetailInspectionActivity.goToInspectionDetail(InspectionList.this,myInspection.get(position));
            }
        });

        inspectionManager=InspectionManager.getInstance(this);
        inspectionManager.initData(new ParseFinishListener() {
            @Override
            public void onFinish() {
                myInspection=inspectionManager.getList(trackingnum);
                for(int i=0; i<myInspection.size();i++){
                    try {
                        instype.add(myInspection.get(i).getInspectionType());
                        cricissues[i] = myInspection.get(i).getNumCritViolations();
                        noncricissues[i] = myInspection.get(i).getNumNonCritViolations();
                        hazardlevel.add(myInspection.get(i).getHazardRating());
                        TDate.add(myInspection.get(i).adjustTime());
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                adapter.notifyDataSetChanged();
                            }
                        });
                    }
                    catch (NullPointerException e){
                        instype.add("No Inspection Found");
                        cricissues[0]=0;
                        noncricissues[0]=0;
                        hazardlevel.add("Low");
                    }
                }

            }
        });

        //back button
        backBtn=findViewById(R.id.backbutton);

        backBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                finish();
            }
        });

    }

    class MyAdapter extends ArrayAdapter<String>{

        MyAdapter(Context c,ArrayList <String> type){
            super(c,R.layout.rowofinspection,R.id.instypetextview,type);
        }

        @NonNull
        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
            LayoutInflater layoutInflater=(LayoutInflater)getApplication().getSystemService(LAYOUT_INFLATER_SERVICE);
            View row=layoutInflater.inflate(R.layout.rowofinspection,parent,false);
            TextView typeofInspection=row.findViewById(R.id.instypetextview);
            TextView numberofcricviolations=row.findViewById(R.id.criticalissuetextview);
            TextView numberofnoncricviolations=row.findViewById(R.id.noncriticalissuetextview);
            TextView hazardl=row.findViewById(R.id.hazardlevltextview);
            ImageView HazardIcons =  row.findViewById(R.id.hazardicon);
            TextView dates = row.findViewById(R.id.datetextview);

            typeofInspection.setText(instype.get(position));
            numberofcricviolations.setText(""+cricissues[position]);
            numberofnoncricviolations.setText(""+noncricissues[position]);


            hazardl.setText(hazardlevel.get(position));
         //   hazardl.setTextColor(Color.parseColor("00ff00"));

            dates.setText(TDate.get(position));

            if(hazardlevel.get(position).equals("Low")){
                HazardIcons.setImageResource(hazardimages[2]);
            }else if (hazardlevel.get(position).equals("Moderate")){
                HazardIcons.setImageResource(hazardimages[1]);
            }else if(hazardlevel.get(position).equals("High")){
                HazardIcons.setImageResource(hazardimages[0]);
            }
            return row;
        }
    }
}