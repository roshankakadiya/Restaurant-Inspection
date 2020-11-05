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
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.cmpt276group05.R;
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
        displayrestaurantGpscord.setText(""+res.getLatitude()+" Latitude "+res.getLongitude()+" Longitude");


        inspectionManager=InspectionManager.getInstance(this);
        myInspection=inspectionManager.getList(trackingnum);

        listview=(ListView) findViewById(R.id.InspectionListview);

        for(int i=0; i<myInspection.size();i++){

            try {
                instype.add(myInspection.get(i).getInspectionType());
                cricissues[i] = myInspection.get(i).getNumCritViolations();
                noncricissues[i] = myInspection.get(i).getNumNonCritViolations();
                hazardlevel.add(myInspection.get(i).getHazardRating());
                TDate.add(myInspection.get(i).adjustTime());
            }
            catch (NullPointerException e){
                instype.add("No Inspection Found");
                cricissues[0]=0;
                noncricissues[0]=0;
                hazardlevel.add("Low");
            }
        }

        MyAdapter adapter=new MyAdapter(this,instype,cricissues,noncricissues,hazardlevel,TDate);


         listview.setAdapter(adapter);

        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                DetailInspectionActivity.goToInspectionDetail(InspectionList.this,InspectionManager.get(position));
            }
        });

    }

    class MyAdapter extends ArrayAdapter<String>{
        Context context;
        String inspectionType[];
        int cricviolations [];
        int noncricviolations[];
        String hazardlevels[];
        int hazarimg[];
        String date[];


        MyAdapter(Context c,ArrayList <String> type,int numcricviolations[],int numnoncricviolations[],ArrayList <String> hazardstring,ArrayList<String> date){
            super(c,R.layout.rowofinspection,R.id.instypetextview,type);
            this.context=c;
            this.inspectionType=type.toArray(new String[0]);
            this.cricviolations=cricissues;
            this.noncricviolations=noncricissues;
            this.hazardlevels=hazardstring.toArray(new String[0]);
            this.hazarimg=hazardimages;
            this.date = TDate.toArray(new String[0]);


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

            typeofInspection.setText(inspectionType[position]);
            numberofcricviolations.setText(""+cricviolations[position]);
            numberofnoncricviolations.setText(""+noncricviolations[position]);


            hazardl.setText(hazardlevels[position]);
         //   hazardl.setTextColor(Color.parseColor("00ff00"));

            dates.setText( date[position]);

            if(hazardlevels[position].equals("Low")){
                HazardIcons.setImageResource(hazarimg[2]);
            }else if (hazardlevels[position].equals("Moderate")){
                HazardIcons.setImageResource(hazarimg[1]);
            }else if(hazardlevels[position].equals("High")){
                HazardIcons.setImageResource(hazarimg[0]);
            }




            return row;
        }
    }
}