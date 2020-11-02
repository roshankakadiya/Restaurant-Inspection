package com.example.cmpt276group05.ui;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.text.DynamicLayout;
import android.text.style.DynamicDrawableSpan;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;

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
    private RestaurantManager restaurantManager;
    private InspectionManager inspectionManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ActionBar actionbar1 = getSupportActionBar();
        actionbar1.setTitle("Surrey Restaurant Inspection");

        restaurantManager = RestaurantManager.getInstance(this);

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

        LinearLayout linearL = new LinearLayout(this);
        ListView listV = new ListView(this);

        final String[] DynamicListElements = new String[] {
                "Android",
                "PHP",
                "Android Studio",
                "PhpMyAdmin"
        };




        //create list View
        ArrayAdapter<String> newarray = new ArrayAdapter<String>(MainActivity.this, android.R.layout.simple_list_item_1, DynamicListElements);
        listV.setAdapter(newarray);
        linearL.addView(listV);

//        this.setContentView(linearL,new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT));



    }





}