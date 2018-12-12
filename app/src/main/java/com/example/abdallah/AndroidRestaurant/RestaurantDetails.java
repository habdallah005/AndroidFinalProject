package com.example.abdallah.AndroidRestaurant;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;


public class RestaurantDetails extends AppCompatActivity {

    TextView txtContainer;
    String details ="";
    FloatingActionButton share;
    FloatingActionButton direction;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_restaurant_details);
        Bundle extras = getIntent().getExtras();
        txtContainer= findViewById(R.id.txtContainer);
        share = findViewById(R.id.floatingActionShare);
        direction = findViewById(R.id.floatingActionLocation);

        if (extras != null)
        {
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
                //Code
            }
        });
    }
}
