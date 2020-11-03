package com.example.cmpt276group05.ui;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.text.DynamicLayout;
import android.text.style.DynamicDrawableSpan;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Toast;

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

        showListView();

    }

    private void showListView() {
        ArrayList<String> inputRes = new ArrayList<>();
        ListView listview = null;

        for (int i = 0; i < restaurantManager.getNumRestaurant(); i++) {
            Restaurant temp = restaurantManager.get(i);
            inputRes.add(temp.getName() + "/kkkkkkkkkkkkk" );
//                    () + "/" + temp.()+  + "/" + + "/"
        }


        listview = (ListView) findViewById(R.id.list);
        ArrayAdapter arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, inputRes);
        listview.setAdapter(arrayAdapter);

        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                    Intent intent = makeLaunchIntent(MainActivity.this, position);
//                    startActivity(intent);
            }


        });
    }




}