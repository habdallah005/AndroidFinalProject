package com.example.abdallah.AndroidRestaurant;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;


import com.example.abdallah.R;



public class WelcomePage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome_page);

        findViewById(R.id.txtTitle);

        findViewById(R.id.btnTakeMeIn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(v.getContext(), MainMenu.class);
                startActivity(i);
            }
        });


        findViewById(R.id.btnAboutUs).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(v.getContext(), AboutUs.class);
                startActivity(i);
            }
        });
    }
}
