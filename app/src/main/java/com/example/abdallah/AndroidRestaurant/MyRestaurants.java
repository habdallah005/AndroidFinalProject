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
    private ArrayList<String> item;
    private ArrayAdapter<String> itemsAdapter;
    private ListView lvItems;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_restaurants);

        lvItems = findViewById(R.id.ListRestos);
        item = new ArrayList<>();

        DBHelper db = new DBHelper(this);

        db.insertData("Scaramouche", "One Benvenuto Place", "416 555 1234", "Old School", "tasty");


        Cursor res = db.getAllData();
        res.moveToFirst();
        item.add(res.getString(1) + " " + res.getString(2) + "\n");


        itemsAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, item);
        lvItems.setAdapter(itemsAdapter);
    }
}
