package com.example.cmpt276group05.model;

import android.content.Context;
import android.util.Log;

import androidx.annotation.NonNull;

import com.example.cmpt276group05.R;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

/*
 * Manager for Restaurant objects. Has methods for sorting and adding/ deleting restaurants
 */


public class RestaurantManager implements Iterable<Restaurant>{

    private static List<Restaurant> restaurantSamples = new ArrayList<>();
    private static Context context;
    // Allows access to files

    @Override
    public Iterator<Restaurant> iterator() {
        return restaurantSamples.iterator();
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
        sort();

        return instance;
    }



    private static void sort() {

    }

    public void add(Restaurant restaurant) {
        restaurantSamples.add(restaurant);
    }

    public Restaurant get(int index) {
        return restaurantSamples.get(index);
    }

    public int getNumRestaurant() {
        return restaurantSamples.size();
    }

    public void removeAtIndex(int index) {
        restaurantSamples.remove(index);
    }

    private static void readRestaurantData() {
        InputStream is = context.getResources().openRawResource(R.raw.restaurants_itr1);
        BufferedReader reader = new BufferedReader(
                new InputStreamReader(is, StandardCharsets.UTF_8)
        );
        CSVReader csvReader = new CSVReader(reader);

        String line[] = new String[7];

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

                restaurantSamples.add(sample);

                Log.d("Myactivity", "Just Created: " + sample);
            }
        } catch (IOException | CsvValidationException e) {
            Log.wtf("MyActivity", "Error reading data file on line " + line, e);
            e.printStackTrace();
        }

    }
}
