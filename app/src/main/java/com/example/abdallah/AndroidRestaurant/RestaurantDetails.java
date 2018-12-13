package com.example.abdallah.AndroidRestaurant;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.net.Uri;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.lang.reflect.Array;


public class RestaurantDetails extends AppCompatActivity {

    TextView txtContainer;
    String details = "";
    FloatingActionButton share;
    FloatingActionButton direction;
    TextView txtAddress;



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

}
