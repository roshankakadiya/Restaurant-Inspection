package com.example.cmpt276group05.ui;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.example.cmpt276group05.R;
import com.example.cmpt276group05.model.Inspection;
import com.example.cmpt276group05.model.InspectionManager;
import com.example.cmpt276group05.model.Restaurant;
import com.example.cmpt276group05.model.RestaurantManager;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    //private RestaurantManager restaurantManager;
    private InspectionManager inspectionManager;
    private ArrayList<Inspection> inspectionList;
    private List<Inspection> myInspection= new ArrayList<Inspection>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
       /* restaurantManager = RestaurantManager.getInstance(this);

        // Testing restaurant manager
        for (int x = 0; x < restaurantManager.getNumRestaurant(); x++) {
            Log.d("Restaurant", restaurantManager.get(x).toString());
        }

        // Testing inspection manager
        inspectionManager = InspectionManager.getInstance(this);
        for (int x = 0; x < inspectionManager.getNumInspection(); x++) {
            Log.d("Inspection", inspectionManager.get(x).toString());
        }

        List<Inspection> inspection;
        inspection = inspectionManager.getList("SWOD-AHZUMF");
        for (int x = 0; x < inspection.size(); x++) {
            Log.d("LIST", inspection.get(x).toString());
        }
        Log.d("SIZE", String.valueOf(inspection.size()));

        Log.d("numberOfissues", String.valueOf(inspectionManager.numOfIssuesFound("SWOD-AHZUMF")));
       */

        //list of inspection
        populateInspectionList();

        populateListView();

    }

    private void populateListView() {
        ArrayAdapter<Inspection> adapter =new MyListAdapter();
        ListView list=(ListView) findViewById(R.id.inspectionlistview);
        list.setAdapter(adapter);


    }

    private class MyListAdapter extends ArrayAdapter<Inspection>{
        public MyListAdapter(){
            super(MainActivity.this,R.layout.list_of_inspectioin,myInspection);
        }

        @Override
        public View getView(int position,  View convertView,  ViewGroup parent) {

            View itemView=convertView;
            if(itemView==null){
                itemView=getLayoutInflater().inflate(R.layout.list_of_inspectioin,parent,false);
            }

            Inspection currentInspection=myInspection.get(position);

            //number of critical issue
            TextView criticalText=(TextView) itemView.findViewById(R.id.criticaltextview);
            criticalText.setText( ""+ currentInspection.getNumCritViolations());


            //number of non critical issue
            TextView makeText2=(TextView) itemView.findViewById(R.id.noncriticaltextview);
            makeText2.setText( ""+ currentInspection.getNumNonCritViolations());

            //level of hazard
            TextView makeText3=(TextView) itemView.findViewById(R.id.hazardleveltextview);
            makeText3.setText(currentInspection.getHazardRating());


            //how long

            return itemView;
            //return super.getDropDownView(position, convertView, parent);
        }
    }

    private void populateInspectionList() {
        myInspection=inspectionManager.getList("SWOD-AHZUMF");
    }



}