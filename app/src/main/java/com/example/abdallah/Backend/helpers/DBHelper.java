package com.example.abdallah.Backend.helpers;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.example.abdallah.Backend.model.Restaurant;

import java.util.ArrayList;

public class DBHelper extends SQLiteOpenHelper {



    public static final int DB_VERSION = 2; // Database version
    public static final String DB_NAME = "Restaurant.db";

    private Context context;

    public DBHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        try {
            db.execSQL(RestaurantContract.RestaurantEntity.SQL_CREATE_RESTAURANT);
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        if (oldVersion == 1 && newVersion > 2) {
            try {
                db.execSQL(RestaurantContract.RestaurantEntity.SQL_DROP_TABLE);
                onCreate(db);
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
    }
    // We created a model called Restaurant

    public long insertData(SQLiteDatabase db, Restaurant restaurant) {

        ContentValues values = new ContentValues();
        values.put(RestaurantContract.RestaurantEntity.column_name, restaurant.getName());
        values.put(RestaurantContract.RestaurantEntity.column_address,restaurant.getAddress());
        values.put(RestaurantContract.RestaurantEntity.column_phone,restaurant.getPhoneNumber());
        values.put(RestaurantContract.RestaurantEntity.column_description,restaurant.getDescription());
        values.put(RestaurantContract.RestaurantEntity.column_tags,restaurant.getTags());

        long d= db.insert(RestaurantContract.RestaurantEntity.TABLE_NAME,null,values);
        return d;

    }

    public ArrayList<String> viewData(SQLiteDatabase db) {

        String[] projection = {
                RestaurantContract.RestaurantEntity.column_name,
                RestaurantContract.RestaurantEntity.column_phone

        };


        Cursor cursor = db.query(RestaurantContract.RestaurantEntity.TABLE_NAME,
                projection,
                null,
                null,
                null,
                null,
                null
        );

        //int i =0;

        ArrayList<String> buffer = new ArrayList<>();
        int i = 0;

        while (cursor.moveToNext()) {
            String name = cursor.getString(cursor.getColumnIndexOrThrow(RestaurantContract.RestaurantEntity.column_name));
            String phone = cursor.getString(cursor.getColumnIndexOrThrow(RestaurantContract.RestaurantEntity.column_phone));

            buffer.add(name + " " + phone);

            name = " ";
            phone = " ";

        }
        return buffer;
    }



}
