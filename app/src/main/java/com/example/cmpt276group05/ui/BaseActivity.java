package com.example.cmpt276group05.ui;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.concurrent.ScheduledThreadPoolExecutor;

/*
* base activty
*
* */
public abstract class BaseActivity extends AppCompatActivity {
    public ScheduledThreadPoolExecutor scheduledPool = new ScheduledThreadPoolExecutor(3);
    protected String TAG = this.getClass().getName();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutId());
        initView();
        initData();
        initEvent();
    }

    protected abstract int getLayoutId();

    protected void initView(){}

    protected void initData(){}

    protected void initEvent(){}

    protected void goActivity(Class cls){
        startActivity(new Intent(this,cls));
    }
}
