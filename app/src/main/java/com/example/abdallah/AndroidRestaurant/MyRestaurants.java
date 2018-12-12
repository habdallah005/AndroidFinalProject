package com.example.abdallah.AndroidRestaurant;

import com.example.abdallah.Backend.helpers.DBHelper;
import com.example.abdallah.R;

import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
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

       /*list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
           @Override
           public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

           }
       });*/
    }
}