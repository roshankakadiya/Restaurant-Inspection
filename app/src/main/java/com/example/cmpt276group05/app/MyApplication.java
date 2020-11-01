package com.example.cmpt276group05.app;

import android.app.Application;

import com.example.cmpt276group05.R;
import com.example.cmpt276group05.model.BaseEntity;
import com.example.cmpt276group05.utils.FileUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ScheduledThreadPoolExecutor;

public class MyApplication extends Application {
    public ScheduledThreadPoolExecutor scheduledPool = new ScheduledThreadPoolExecutor(1);
    private static MyApplication myApplication;
    private List<BaseEntity> restaurantList = new ArrayList<>();
    private List<BaseEntity> inspectList = new ArrayList<>();
    @Override
    public void onCreate() {
        super.onCreate();
        if(myApplication==null){
            myApplication = this;
        }

        scheduledPool.execute(new Runnable() {
            @Override
            public void run() {
                restaurantList.addAll(FileUtils.readDataFromCsvFile(myApplication, R.raw.restaurants));
                inspectList.addAll(FileUtils.readDataFromCsvFile(myApplication, R.raw.inspectionreports));
            }
        });

    }

    public static MyApplication getInstance(){
        return myApplication;
    }

    public List<BaseEntity> getRestaurantList() {
        return restaurantList;
    }

    public void setRestaurantList(List<BaseEntity> restaurantList) {
        this.restaurantList = restaurantList;
    }

    public List<BaseEntity> getInspectList() {
        return inspectList;
    }

    public void setInspectList(List<BaseEntity> inspectList) {
        this.inspectList = inspectList;
    }
}
