package com.example.cmpt276group05.model.UI;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.cmpt276group05.R;
import com.example.cmpt276group05.model.Model.Inspection;
import com.example.cmpt276group05.model.Model.InspectionManager;
import com.example.cmpt276group05.model.Model.Restaurant;
import com.example.cmpt276group05.model.Model.RestaurantManager;

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
    int hazardimages []={R.drawable.high,R.drawable.moderate,R.drawable.low};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.displayinspectionlist);

        Intent intent = getIntent();
        String a="SWOD-APSP3X";
        //String trackingnum=intent.getStringExtra("Tracking Number",a);

        restaurantManager=RestaurantManager.getInstance(this);
        res=restaurantManager.getByTrackingNumber(a);

        TextView displayrestaurantname=(TextView) findViewById(R.id.restaurantnametextView);
        displayrestaurantname.setText(res.getName());

        TextView displayrestaurantaddress=(TextView) findViewById(R.id.addresstextView);
        displayrestaurantaddress.setText(res.getAddress());

        TextView displayrestaurantGpscord=(TextView) findViewById(R.id.GPScordtextview);
        displayrestaurantGpscord.setText(""+res.getLatitude()+","+res.getLongitude());


        inspectionManager=InspectionManager.getInstance(this);
        myInspection=inspectionManager.getList(a);

        listview=(ListView) findViewById(R.id.InspectionListview);

        for(int i=0; i<myInspection.size();i++){

            instype.add(myInspection.get(i).getInspectionType());
            cricissues[i]=myInspection.get(i).getNumCritViolations();
            noncricissues[i]=myInspection.get(i).getNumNonCritViolations();
            hazardlevel.add(myInspection.get(i).getHazardRating());

        }

        MyAdapter adapter=new MyAdapter(this,instype,cricissues,noncricissues,hazardlevel);


         listview.setAdapter(adapter);

    }

    class MyAdapter extends ArrayAdapter<String>{
        Context context;
        String inspectionType[];
        int cricviolations [];
        int noncricviolations[];
        String hazardlevels[];
        int hazarimg[];


        MyAdapter(Context c,ArrayList <String> type,int numcricviolations[],int numnoncricviolations[],ArrayList <String> hazardstring){
            super(c,R.layout.rowofinspection,R.id.instypetextview,type);
            this.context=c;
            this.inspectionType=type.toArray(new String[0]);
            this.cricviolations=cricissues;
            this.noncricviolations=noncricissues;
            this.hazardlevels=hazardstring.toArray(new String[0]);
            this.hazarimg=hazardimages;


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

            typeofInspection.setText(inspectionType[position]);
            numberofcricviolations.setText(""+cricviolations[position]);
            numberofnoncricviolations.setText(""+noncricviolations[position]);
            hazardl.setText(hazardlevels[position]);

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