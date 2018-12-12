package com.example.abdallah.AndroidRestaurant;

import com.example.abdallah.Backend.helpers.DBHelper;


import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import java.util.ArrayList;


public class MyRestaurants extends AppCompatActivity {
    private ArrayList<String> data = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_restaurants);

        DBHelper dbHelper = new DBHelper(this);
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        data = dbHelper.viewData(db);

        ArrayAdapter<String> adapter =
                new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, data);
        ListView list = findViewById(R.id.ListRestos);
        list.setAdapter(adapter);

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                long d = parent.getItemIdAtPosition(position);
                find_Details(view, d+1);

            }
        });

        findViewById(R.id.floatingActionAdd).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(v.getContext(), AddRestaurant.class);
                startActivity(i);
            }
        });

    }

    // This will be called by on ItemClick
    //
    public void find_Details(View view,long id){

        DBHelper dbHelper = new DBHelper(this);
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        Intent i = new Intent(view.getContext(), RestaurantDetails.class);
        i.putExtra("key", dbHelper.find_DetailsRestaurant(db,id));
        startActivity(i);

    }
}