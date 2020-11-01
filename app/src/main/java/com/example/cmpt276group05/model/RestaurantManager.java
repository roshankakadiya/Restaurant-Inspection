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
        for (int x = 0; x < instance.getNumRestaurant(); x++) {
            Log.d("Restaurant", instance.get(x).toString());
        }
        return instance;
    }



    public void add(Restaurant restaurant) {
        restaurantSamples.add(restaurant);
    }

    private static void sort() {

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

//    private static void readRestaurantData() {
//        InputStream is = ctx.getResources().openRawResource(R.raw.restaurants_itr1);
//        BufferedReader reader = new BufferedReader(
//                new InputStreamReader(is, StandardCharsets.UTF_8)
//        );
//        CSVReader csvReader = new CSVReader(reader);
//
//        String line = "";
//
//        try {
//            // Skip over header
//            csvReader.readNext();
//
//            while ((line = reader.readLine()) != null) {
//                String[] tokens = line.split(",");
//
//                Restaurant sample = new Restaurant();
//                sample.setTrackingNumber(tokens[0]);
//                sample.setName(tokens[1]);
//                sample.setAddress(tokens[2]);
//                sample.setCity(tokens[3]);
//                sample.setFacilityType(tokens[4]);
//                sample.setLatitude(Double.parseDouble(tokens[5]));
//                sample.setLongitude(Double.parseDouble(tokens[6]));
//
//                restaurantSamples.add(sample);
//
//                Log.d("Myactivity", "Just Created: " + sample);
//            }
//        } catch (IOException | CsvValidationException e) {
//            Log.wtf("MyActivity", "Error reading data file on line " + line, e);
//            e.printStackTrace();
//        }
//
//    }




    private static void readRestaurantData() {
        InputStream is = context.getResources().openRawResource(R.raw.restaurants_itr1);
        BufferedReader reader = new BufferedReader(
                new InputStreamReader(is, StandardCharsets.UTF_8)
        );

        String line = "";

        try {
            // Skip over header
            reader.readLine();

            while ((line = reader.readLine()) != null) {
                String[] tokens = line.split(",");

                Restaurant sample = new Restaurant();
                sample.setTrackingNumber(tokens[0]);
                sample.setName(tokens[1]);
                sample.setAddress(tokens[2]);
                sample.setCity(tokens[3]);
                sample.setFacilityType(tokens[4]);
                sample.setLatitude(Double.parseDouble(tokens[5]));
                sample.setLongitude(Double.parseDouble(tokens[6]));

                restaurantSamples.add(sample);

                Log.d("Myactivity", "Just Created: " + sample);
            }
        } catch (IOException e) {
            Log.wtf("MyActivity", "Error reading data file on line " + line, e);
            e.printStackTrace();
        }

    }
}
