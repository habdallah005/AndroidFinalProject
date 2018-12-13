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
    Restaurant []resta;

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
        long result = db.insert(RestaurantContract.RestaurantEntity.TABLE_NAME,null,values);
        return result;

    }

    public ArrayList<String> viewData(SQLiteDatabase db) {

        String[] projection = {
                RestaurantContract.RestaurantEntity.column_name,
               /* RestaurantContract.RestaurantEntity.column_address,
                RestaurantContract.RestaurantEntity.column_phone,
                RestaurantContract.RestaurantEntity.column_description,
                RestaurantContract.RestaurantEntity.column_tags*/

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
            buffer.add(name+"");
            name="";
          /*  String phone = cursor.getString(cursor.getColumnIndexOrThrow(RestaurantContract.RestaurantEntity.column_phone));

            String address = cursor.getString(cursor.getColumnIndexOrThrow(RestaurantContract.RestaurantEntity.column_address));
            String description = cursor.getString(cursor.getColumnIndexOrThrow(RestaurantContract.RestaurantEntity.column_description));
            String tags = cursor.getString(cursor.getColumnIndexOrThrow(RestaurantContract.RestaurantEntity.column_tags));
            buffer.add(name+"");
            resta[i].setName(name);
            resta[i].setName(phone);
            resta[i].setName(address);
            resta[i].setName(description);
            resta[i].setName(tags);

            name = " ";
            phone = " ";
           i++;*/
        }
        return buffer;
    }

    public String find_DetailsRestaurant(SQLiteDatabase db, long id) {
        String fn="";
        String[] projection1 = {

                RestaurantContract.RestaurantEntity.column_name,
                RestaurantContract.RestaurantEntity.column_address,
                RestaurantContract.RestaurantEntity.column_phone,
               RestaurantContract.RestaurantEntity.column_description,
               RestaurantContract.RestaurantEntity.column_tags,
         };

        String selection = RestaurantContract.RestaurantEntity._ID +" = ? ";
        String[]  selectionArgs = {Long.toString(id)};


        Cursor cursor = db.query(RestaurantContract.RestaurantEntity.TABLE_NAME,
                projection1,
                selection,
                selectionArgs,
                null,
                null,
                null
        );

        if (cursor != null && cursor.getCount() > 0){
            cursor.moveToFirst();
            do {
                fn = " ";
                fn += "\n FirstName :"+ " " +
                        cursor.getString(cursor.getColumnIndexOrThrow(RestaurantContract.RestaurantEntity.column_name))
                        + "\n Address : " +
                        cursor.getString(cursor.getColumnIndexOrThrow(RestaurantContract.RestaurantEntity.column_address))
                        + " \n Phone : " +
                        cursor.getString(cursor.getColumnIndexOrThrow(RestaurantContract.RestaurantEntity.column_phone))
                        + "\n Description : " +
                        cursor.getString(cursor.getColumnIndexOrThrow(RestaurantContract.RestaurantEntity.column_description))
                        + "\n Tags : " +
                        cursor.getString(cursor.getColumnIndexOrThrow(RestaurantContract.RestaurantEntity.column_tags));

            } while (cursor.moveToNext());
        }


        cursor.close();
        return fn;
    }
/*
     public ArrayList<String> find_Search(String query) {

         ArrayList<String> buffer = new ArrayList<>();
         for (int i = 0; i < resta.length; i++) {
             if (resta[i].getName().equals(query)) {
                 String name = resta[i].getName();
                 buffer.add(name);
                 name = "";
             }

             if (resta[i].getTags().equals(query)) {
                 String name = resta[i].getName();
                 buffer.add(name);
                 name = "";
             }
         }
         return buffer;
     }
*/
}
