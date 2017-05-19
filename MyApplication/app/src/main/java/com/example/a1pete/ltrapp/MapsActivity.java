package com.example.a1pete.ltrapp;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Address;
import android.os.Build;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.view.View;
import android.widget.Button;

import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.security.KeyStore;
import java.security.Permission;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    GoogleMap mMap;
    public int  MY_PERMISSIONS_REQUEST_LOCATION;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        // Assume thisActivity is the current activity
        int permissionCheck = ContextCompat.checkSelfPermission(this,
                Manifest.permission.WRITE_CALENDAR);

        //set background
        getWindow().setBackgroundDrawableResource(R.drawable.ubcbackground);

        //set button to return
        Button btn3 = (Button) findViewById(R.id.returntomain);
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MapsActivity.this, MainActivity.class));
            }
        });

    }

    /*setting up the map*/
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        // requesting permission from the user to use their location **TAKEN FROM ANDROID_RESOURCES**
        if (ContextCompat.checkSelfPermission(this,
                Manifest.permission.ACCESS_FINE_LOCATION)
                != PackageManager.PERMISSION_GRANTED) {
            if(ActivityCompat.shouldShowRequestPermissionRationale(this,
                    Manifest.permission.ACCESS_FINE_LOCATION)) {
            } else {
                ActivityCompat.requestPermissions(this,
                        new String[]{Manifest.permission.ACCESS_FINE_LOCATION},
                        MY_PERMISSIONS_REQUEST_LOCATION);
            }
        }

        // Add a marker in Sydney and move the camera
        LatLng CTLToffice = new LatLng(49.267945, -123.252448);
        LatLng ScienceLTRoffice = new LatLng(49.266094, -123.253000);
        LatLng SauderLTRoffice = new LatLng(49.265681, -123.254551);
        LatLng MedLTRoffice = new LatLng(49.264927, -123.246678);
        LatLng ArtsLTRoffice = new LatLng(49.268925, -123.254317);
        LatLng EducationLTRoffice = new LatLng(49.264122, -123.252972);

        //show the user's location
        mMap.setMyLocationEnabled(true);

        //set LTR locations
        mMap.addMarker(new MarkerOptions().position(CTLToffice).title("Centre for Teaching, Learning and Technology, University of British Columbia-Irving K Barber Room 214"));
        mMap.addMarker(new MarkerOptions().position(ScienceLTRoffice).title("Science LTR Office-Chemistry Room D14"));
        mMap.addMarker(new MarkerOptions().position(SauderLTRoffice).title("Sauder LTR Office-Henry Angus Room 12"));
        mMap.addMarker(new MarkerOptions().position(MedLTRoffice).title("MedLTRoffice- IRC B4D"));
        mMap.addMarker(new MarkerOptions().position(ArtsLTRoffice).title("Arts LTR Office-Buchanan 105C"));
        mMap.addMarker(new MarkerOptions().position(EducationLTRoffice).title("EducationLTRoffice-Scarfe 1008"));

        //set as satellite
        mMap.setMapType(mMap.MAP_TYPE_SATELLITE);

        //set default location and zoom
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(49.267945, -123.252448),14.8f));

    }

}
