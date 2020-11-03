package com.example.cmpt276group05.model;

import android.content.Context;
import android.util.Log;

import com.example.cmpt276group05.R;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

/*
 * Manager for Restaurant objects. Has methods for sorting and adding/ deleting restaurants
 */


public class RestaurantManager implements Iterable<Restaurant>{

    private static List<Restaurant> restaurantList = new ArrayList<>();
    private static Context context;
    // Allows access to files

    @Override
    public Iterator<Restaurant> iterator() {
        return restaurantList.iterator();
    }


    // Singleton Support
    private static RestaurantManager instance;
    private RestaurantManager() {
        // Prevent anyone else from instantiating
    }

    public static RestaurantManager getInstance(Context ctx) {
        if (instance == null) {
            instance = new RestaurantManager();
            context = ctx.getApplicationContext();
            readRestaurantData();
        }
        sortArrayList();

        return instance;
    }



    public static void sortArrayList() {
        Collections.sort(restaurantList, (restaurant, t1) -> restaurant.getName().compareTo(t1.getName()));
    }

    public void add(Restaurant restaurant) {
        restaurantList.add(restaurant);
    }

    public Restaurant get(int index) {
        return restaurantList.get(index);
    }

    // Do not use unless you actually know tracking number
    public Restaurant getByTrackingNumber(String trackingNumber) {
        for (int x = 0; x < restaurantList.size(); x++) {
            if (restaurantList.get(x).getTrackingNumber().equals(trackingNumber)) {
                return restaurantList.get(x);
            }
        }
        return null;
    }

    public int getNumRestaurant() {
        return restaurantList.size();
    }

    public void removeAtIndex(int index) {
        restaurantList.remove(index);
    }

    private static void readRestaurantData() {
        InputStream is = context.getResources().openRawResource(R.raw.restaurants_itr1);
        BufferedReader reader = new BufferedReader(
                new InputStreamReader(is, StandardCharsets.UTF_8)
        );
        CSVReader csvReader = new CSVReader(reader);

        String[] line = new String[7];

        try {
            // Skip over header
            csvReader.readNext();

            while ((line = csvReader.readNext()) != null) {
                Restaurant sample = new Restaurant();
                sample.setTrackingNumber(line[0]);
                sample.setName(line[1]);
                sample.setAddress(line[2]);
                sample.setCity(line[3]);
                sample.setFacilityType(line[4]);
                sample.setLatitude(Double.parseDouble(line[5]));
                sample.setLongitude(Double.parseDouble(line[6]));

                restaurantList.add(sample);

                Log.d("Myactivity", "Just Created: " + sample);
            }
        } catch (IOException | CsvValidationException e) {
            Log.wtf("MyActivity", "Error reading data file on line " + line, e);
            e.printStackTrace();
        }

    }
}