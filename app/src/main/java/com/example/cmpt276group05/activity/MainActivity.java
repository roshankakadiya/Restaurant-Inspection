package com.example.cmpt276group05.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.example.cmpt276group05.R;
import com.example.cmpt276group05.app.MyApplication;
import com.example.cmpt276group05.constant.BusinessConstant;
import com.google.gson.Gson;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Intent intent = new Intent(this,DetailInspectionActivity.class);
        intent.putExtra(BusinessConstant.INSPECTION_DATA, new Gson().toJson(MyApplication.getInstance().getInspectList().get(4)));
        startActivity(intent);
    }
}