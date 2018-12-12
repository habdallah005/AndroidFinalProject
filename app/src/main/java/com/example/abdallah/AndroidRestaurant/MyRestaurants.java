package com.example.abdallah.AndroidRestaurant;

import com.example.abdallah.Backend.helpers.DBHelper;
import com.example.abdallah.R;

import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;



public class MyRestaurants extends AppCompatActivity {
    DBHelper db;

    ArrayList<String> listItem;
    ArrayAdapter adapter;
    ListView lvItems;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_restaurants);

        DBHelper db = new DBHelper(this);

        listItem = new ArrayList<>();
        lvItems = findViewById(R.id.ListRestos);

        db.insertData("Scaramouche", "One Benvenuto Place", "416 555 1234", "Old School", "tasty");


        viewData();

    }

    private void viewData() {
        Cursor cursor = db.viewData();

        while (cursor.moveToNext()) {
            listItem.add(cursor.getString(1));
        }
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, listItem);
        lvItems.setAdapter(adapter);
    }
}
