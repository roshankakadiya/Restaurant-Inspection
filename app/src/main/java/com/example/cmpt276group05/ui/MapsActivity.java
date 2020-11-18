package com.example.cmpt276group05.ui;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentActivity;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.location.Location;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.cmpt276group05.R;
import com.example.cmpt276group05.adapter.CustomInfoWindowAdapter;
import com.example.cmpt276group05.model.Inspection;
import com.example.cmpt276group05.model.InspectionManager;
import com.example.cmpt276group05.model.Restaurant;
import com.example.cmpt276group05.model.RestaurantManager;
import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptor;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

/*
 * UI for mapsActivity
 */


public class MapsActivity extends AppCompatActivity implements OnMapReadyCallback {

    private List<Marker> markers = new ArrayList<>();
    private RestaurantManager restaurantManager;
    private InspectionManager inspectionManager;

    // Src: CodingWithMitch Tutorial - https://youtu.be/Vt6H9TOmsuo
    private static final String FINE_LOCATION = Manifest.permission.ACCESS_FINE_LOCATION;
    private static final String COURSE_LOCATION = Manifest.permission.ACCESS_COARSE_LOCATION;
    private static final int LOCATION_PERMISSION_REQUEST_CODE = 1234;
    private static final float DEFAULT_ZOOM = 12.5f;

    //vars
    private Boolean mLocationPermissionsGranted = false;
    private GoogleMap mMap;
    private FusedLocationProviderClient mLocation;

    @Override
    public void onBackPressed() {
        finishAffinity();
    }


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        Toolbar toolbar = findViewById(R.id.map_toolbar);
        setSupportActionBar(toolbar);

        restaurantManager = RestaurantManager.getInstance(getApplicationContext());
        inspectionManager = InspectionManager.getInstance(getApplicationContext());

        getLocationPermission();
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        Toast.makeText(MapsActivity.this, "Map is ready", Toast.LENGTH_SHORT).show();
        if (mLocationPermissionsGranted) {
            getGPSLocation();

            if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION)
                    != PackageManager.PERMISSION_GRANTED &&
                    ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION)
                            != PackageManager.PERMISSION_GRANTED) {

                return;
            }
            mMap.setMyLocationEnabled(true);
            mMap.getUiSettings().setMyLocationButtonEnabled(true);
            mMap.getUiSettings().setZoomControlsEnabled(true);

            populateMarkers();

        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        mLocationPermissionsGranted = false;

        if (requestCode == LOCATION_PERMISSION_REQUEST_CODE) {
            if (grantResults.length > 0) {
                for (int grantResult : grantResults) {
                    if (grantResult != PackageManager.PERMISSION_GRANTED) {
                        mLocationPermissionsGranted = false;
                        return;
                    }
                }
                mLocationPermissionsGranted = true;
                //initialize our map
                initMap();
            }
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_map, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.go_to_list) {
            startActivity(new Intent(this, MainActivity.class));
            return true;
        }
        return super.onOptionsItemSelected(item);
    }



    private void getGPSLocation() {
        mLocation = LocationServices.getFusedLocationProviderClient(this);
        try {
            if (mLocationPermissionsGranted) {
                Task location = mLocation.getLastLocation();
                location.addOnCompleteListener(task -> {
                    if (task.isSuccessful()) {
                        try {
                            // Checks for priority of setting location of restaurant if intent passes that information through
                            // If no information passes through, it'll default to gps camera view
                            String trackingNumber = getIntent().getExtras().getString("trackingNumber");

                            for (Marker marker : markers) {
                                if (marker.getTag().equals(trackingNumber)) {
                                    moveCamera(marker.getPosition(), DEFAULT_ZOOM);
                                    marker.showInfoWindow();
                                }
                            }
                        } catch (NullPointerException e) {
                            Location current = (Location) task.getResult();
                            if (current != null) {
                                moveCamera(new LatLng(current.getLatitude(), current.getLongitude()), DEFAULT_ZOOM);
                            }
                        }
                    } else {
                        Toast.makeText(MapsActivity.this, "Cannot get current location", Toast.LENGTH_SHORT).show();
                    }
                });
            }
        } catch (SecurityException e) {
            Log.e("Error", "SecurityException " + e.getMessage());
        }
    }

    private void moveCamera(LatLng latLng, float zoom) {
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(latLng,zoom));
    }


    private void initMap(){
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map);
        mapFragment.getMapAsync(MapsActivity.this);

    }

    private void populateMarkers() {
        for (int x = 0; x < restaurantManager.getNumRestaurant(); x++) {
            Restaurant restaurant = restaurantManager.get(x);
            String name = restaurant.getName();
            String address = restaurant.getAddress();

            double latitude = restaurant.getLatitude();
            double longitude = restaurant.getLongitude();
            mMap.setInfoWindowAdapter(new CustomInfoWindowAdapter(MapsActivity.this));

            String snippet;
            Marker marker;



            try {
                String hazardLevelMostRecent = inspectionManager
                        .getMostRecentInspection(restaurant.getTrackingNumber())
                        .getHazardRating();
                snippet = address + "\n" + "Hazard level of most recent inspection: " + hazardLevelMostRecent.toUpperCase();
                int resourceID = 0;
                switch (hazardLevelMostRecent) {
                    case "Low":
                        resourceID = R.drawable.low_bmp;
                        break;
                    case "Moderate":
                        resourceID = R.drawable.mid_bmp;
                        break;
                    case "High":
                        resourceID = R.drawable.high_bmp;
                        break;
                }

                Bitmap bitmap = BitmapFactory.decodeResource(getResources(), resourceID);
                BitmapDescriptor bitmapDescriptor = BitmapDescriptorFactory.fromBitmap(bitmap);
                marker = mMap.addMarker(new MarkerOptions()
                        .position(new LatLng(latitude,longitude))
                        .title(name)
                        .snippet(snippet)
                        .icon(bitmapDescriptor));
                markers.add(marker);
                // Null occurs when there is no inspection available - use a question mark icon instead of custom icon
            } catch (NullPointerException e) {
                Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.question_bmp);
                BitmapDescriptor bitmapDescriptor = BitmapDescriptorFactory.fromBitmap(bitmap);
                snippet = address + " - No inspection found";
                marker = mMap.addMarker(new MarkerOptions()
                        .position(new LatLng(latitude,longitude))
                        .title(name)
                        .snippet(snippet)
                        .icon(bitmapDescriptor));
                markers.add(marker);
            }

            String trackingNumber = restaurant.getTrackingNumber();
            marker.setTag(trackingNumber);
            mMap.setOnInfoWindowClickListener(marker1 -> {
                Intent intent = new Intent(MapsActivity.this, InspectionList.class);
                String trackingNumber1 = marker1.getTag().toString();
                intent.putExtra("Tracking_Number", trackingNumber1);
                startActivity(intent);
            });
        }
    }

    private void getLocationPermission(){
        String[] permissions = {Manifest.permission.ACCESS_FINE_LOCATION,
                Manifest.permission.ACCESS_COARSE_LOCATION};

        if(ContextCompat.checkSelfPermission(this.getApplicationContext(),
                FINE_LOCATION) == PackageManager.PERMISSION_GRANTED){
            if(ContextCompat.checkSelfPermission(this.getApplicationContext(),
                    COURSE_LOCATION) == PackageManager.PERMISSION_GRANTED){
                mLocationPermissionsGranted = true;
                initMap();
            }else{
                ActivityCompat.requestPermissions(this,
                        permissions,
                        LOCATION_PERMISSION_REQUEST_CODE);
            }
        }else{
            ActivityCompat.requestPermissions(this,
                    permissions,
                    LOCATION_PERMISSION_REQUEST_CODE);
        }
    }
}
