package com.example.cmpt276group05.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

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


    }





}