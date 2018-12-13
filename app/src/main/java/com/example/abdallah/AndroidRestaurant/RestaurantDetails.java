package com.example.abdallah.AndroidRestaurant;

//Android Final Project for December 2018 COMP3074 Przemyslaw Pawluk
//Done by Abdallahman Habyarimana, Christopher Haddock, Peter Bugden, Renata Moura

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.net.Uri;
import android.os.Build;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.io.IOException;
import java.lang.reflect.Array;
import java.util.List;


public class RestaurantDetails extends AppCompatActivity implements OnMapReadyCallback {

    TextView txtContainer;
    String details = "";
    FloatingActionButton share;
    FloatingActionButton direction;
    TextView txtAddress;

    private GoogleMap mMap;
    private LocationManager locationManager;


    private static final int LOCATION_CODE = 1;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_restaurant_details);
        Bundle extras = getIntent().getExtras();
        txtContainer = findViewById(R.id.txtContainer);
        share = findViewById(R.id.floatingActionShare);
        direction = findViewById(R.id.floatingActionLocation);


        if (extras != null) {
            details = extras.getString("key");
        }

        txtContainer.setText(details);


        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync((OnMapReadyCallback) this);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            requestPermissions(new String[]{Manifest.permission.ACCESS_COARSE_LOCATION, Manifest.permission.ACCESS_FINE_LOCATION}, LOCATION_CODE);
        }

        locationManager = (LocationManager) getSystemService(LOCATION_SERVICE);

        share.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(v.getContext(), ShareActivity.class);
                startActivity(i);

            }
        });

        //Peter starts Here

        direction.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Intent i = new Intent(v.getContext(), MapsActivity.class);
                //startActivity(i);

                //Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse("geo:" + latitude + " " + longitude + " to " + details.split(":")[2].split("Phone")[0]));
                //Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse("geo:" + latitude + " " + longitude));
                Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse("google.navigation:q="+details.split(":")[2].split("Phone")[0]));
                //Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse("geo:0,0?q=160+kendal+Ave+Toronto+to+34+risa+boulevard"));

                startActivity(i);
            }
        });

    }
    public LatLng getLocationFromAddress(Context context,String strAddress) {

        Geocoder coder = new Geocoder(context);
        List<Address> address;
        LatLng p1 = null;

        try {
            // May throw an IOException
            address = coder.getFromLocationName(strAddress, 5);
            if (address == null) {
                return null;
            }

            Address location = address.get(0);
            p1 = new LatLng(location.getLatitude(), location.getLongitude() );

        } catch (IOException ex) {

            ex.printStackTrace();
        }

        return p1;
    }
    @Override
    public void onMapReady(GoogleMap googleMap) {
        LocationManager lm = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return;
        }
        @SuppressLint("MissingPermission") Location location = lm.getLastKnownLocation(LocationManager.GPS_PROVIDER);
        final double longitude = location.getLongitude();
        final double latitude = location.getLatitude();
        mMap = googleMap;

        LatLng mylocation = new LatLng(latitude, longitude);
        mMap.addMarker(new MarkerOptions().position(mylocation).title("My Location"));



        LatLng test = getLocationFromAddress(this, details.split(":")[2].split("Phone")[0]);
        mMap.addMarker(new MarkerOptions().position(test).title(details.split(":")[1]));
        CameraUpdate yourLocation = CameraUpdateFactory.newLatLngZoom(test, 10);
        mMap.animateCamera(yourLocation);


    }



}
