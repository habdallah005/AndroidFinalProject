package com.example.abdallah.AndroidRestaurant;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.abdallah.R;


public class MainMenu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);

       /* findViewById(R.id.btnMyRestos).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(v.getContext(), MyRestaurants.class);
                startActivity(i);
            }
        });*/
        findViewById(R.id.btnAddRestos).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(v.getContext(), AddRestaurant.class);
                startActivity(i);
            }
        });
        findViewById(R.id.btnSearch).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(v.getContext(), SearchRestaurant.class);
                startActivity(i);
            }
        });


    }
}
