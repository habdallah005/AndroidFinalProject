package com.example.abdallah.AndroidRestaurant;

//Android Final Project for December 2018 COMP3074 Przemyslaw Pawluk
//Done by Abdallahman Habyarimana, Christopher Haddock, Peter Bugden, Renata Moura

import android.os.Bundle;
import android.app.Activity;




public class AboutUs extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_us);

        findViewById(R.id.txtChris);
        findViewById(R.id.txtAbdal);
        findViewById(R.id.txtRenata);
        findViewById(R.id.txtPeter);
    }

}
