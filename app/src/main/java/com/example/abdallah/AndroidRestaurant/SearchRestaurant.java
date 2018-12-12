package com.example.abdallah.AndroidRestaurant;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SearchView;

import com.example.abdallah.Backend.helpers.DBHelper;
import com.example.abdallah.Backend.model.Restaurant;

import java.util.ArrayList;


public class SearchRestaurant extends Activity {
   /* ListView list;
    SearchView editSearch;
    ArrayList<String> data = new ArrayList<String>();
*/
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_restaurant);
/*
        editSearch = (findViewById(R.id.txtSearchView));

        editSearch.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                Search_Text(query);
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                Search_Text(newText);
                return false;
            }
        });

        ArrayAdapter<String> adapter =
                new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, data);
        ListView list = findViewById(R.id.lstSearch);
        list.setAdapter(adapter);

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

            }
        });

    }

    public void Search_Text(String text){
        DBHelper dbHelper = new DBHelper(this);
        data = dbHelper.find_Search(text);
*/
    }

}
