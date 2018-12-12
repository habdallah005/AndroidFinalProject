package com.example.abdallah.Backend.helpers;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteException;
import android.util.Log;

import com.example.abdallah.AndroidRestaurant.Notification;
import com.example.abdallah.Backend.model.Restaurant;

import java.util.ArrayList;

public class DBHelper extends SQLiteOpenHelper {
    private Context context;
    public static final int DB_VERSION = 2; // Database version
    public static final String DB_NAME = "rGuide.db";


    public DBHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        try {
            db.execSQL(RestaurantContract.RestaurantEntity.SQL_CREATE_TABLE);
        } catch (Exception e) {
            // e.printStackTrace();
            Notification.getNotification(context, "" + e);
        }


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        if (oldVersion == 1 && newVersion > 2) {
            try {
                db.execSQL(RestaurantContract.RestaurantEntity.SQL_DROP_TABLE);
                onCreate(db);
            } catch (Exception e) {
                // e.printStackTrace();
                Notification.getNotification(context, "" + e);
            }

        }
        Log.d("DB-TEST", "DB-re-created");
    }

    /*
    public boolean insertData(String name, String address, String phone, String description, String tags) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(RestaurantContract.RestaurantEntity.column_name,name);
        contentValues.put(RestaurantContract.RestaurantEntity.column_address,address);
        contentValues.put(RestaurantContract.RestaurantEntity.column_phone,phone);
        contentValues.put(RestaurantContract.RestaurantEntity.column_description,description);
        contentValues.put(RestaurantContract.RestaurantEntity.column_tags,tags);
        long result = db.insert(RestaurantContract.RestaurantEntity.TABLE_RESTAURANT,null,contentValues);
        return result !=-1;
    }*/

    public long insertData(SQLiteDatabase db, Restaurant restaurant) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(RestaurantContract.RestaurantEntity.column_name, restaurant.getName());
        contentValues.put(RestaurantContract.RestaurantEntity.column_address, restaurant.getAddress());
        contentValues.put(RestaurantContract.RestaurantEntity.column_phone, restaurant.getPhoneNumber());
        contentValues.put(RestaurantContract.RestaurantEntity.column_description, restaurant.getDescription());
        contentValues.put(RestaurantContract.RestaurantEntity.column_tags, restaurant.getTags());

        long result = db.insert(RestaurantContract.RestaurantEntity.TABLE_RESTAURANT, null, contentValues);

        return result;
    }

    public ArrayList<String> get_Restaurant(SQLiteDatabase db) {
        String[] projection = {
                RestaurantContract.RestaurantEntity.column_name,
                RestaurantContract.RestaurantEntity.column_address,
                RestaurantContract.RestaurantEntity.column_phone,
                RestaurantContract.RestaurantEntity.column_description,
                RestaurantContract.RestaurantEntity.column_tags
        };

        /*
        public Cursor viewData () {
            SQLiteDatabase db = this.getReadableDatabase();

            Cursor cursor = db.rawQuery("select * from " + RestaurantContract.RestaurantEntity.TABLE_RESTAURANT, null);
            return cursor;
        }*/

        Cursor cursor = db.query(RestaurantContract.RestaurantEntity.TABLE_RESTAURANT,
                projection,
                null,
                null,
                null,
                null,
                null);

        ArrayList<String> buffer = new ArrayList<>();

        int i=0;

        while (cursor.moveToNext()){

            String name = cursor.getString(cursor.getColumnIndexOrThrow(RestaurantContract.RestaurantEntity.column_name));
            String address = cursor.getString(cursor.getColumnIndexOrThrow(RestaurantContract.RestaurantEntity.column_address));
            String phone = cursor.getString(cursor.getColumnIndexOrThrow(RestaurantContract.RestaurantEntity.column_phone));
            String description = cursor.getString(cursor.getColumnIndexOrThrow(RestaurantContract.RestaurantEntity.column_description));
            String tags = cursor.getString(cursor.getColumnIndexOrThrow(RestaurantContract.RestaurantEntity.column_tags));

            buffer.add(name + " " + address+ " " + phone + " " + description + " " + tags);

            name = " ";
            address= " ";
            phone= " ";
            description= " ";
            tags= " ";
        }
        return buffer;
    }
    public String find_DetailsRestaurant(SQLiteDatabase db, long id){
        String name ="";
        String[] projection1={
                RestaurantContract.RestaurantEntity._ID,
                RestaurantContract.RestaurantEntity.column_name,
                RestaurantContract.RestaurantEntity.column_address,
                RestaurantContract.RestaurantEntity.column_phone,
                RestaurantContract.RestaurantEntity.column_description,
                RestaurantContract.RestaurantEntity.column_tags

        };


        String selection = RestaurantContract.RestaurantEntity._ID +" =? ";
        String[] selectionArgs = {Long.toString(id)};
        Cursor cursor = db.query(RestaurantContract.RestaurantEntity.TABLE_RESTAURANT,
                projection1,
                selection,
                selectionArgs,
                null,
                null,
                null);
        if(cursor !=null && cursor.getCount() > 0){
            cursor.moveToFirst();
            do {
                name=" ";
                name += "\n Name:  " +
                        cursor.getString(cursor.getColumnIndexOrThrow(RestaurantContract.RestaurantEntity.column_name))
                        + "\n Address: " +
                        cursor.getString(cursor.getColumnIndexOrThrow(RestaurantContract.RestaurantEntity.column_address))
                        + "\n Phone: "+
                        cursor.getString(cursor.getColumnIndexOrThrow(RestaurantContract.RestaurantEntity.column_phone))
                        + "\n Description: "+
                        cursor.getString(cursor.getColumnIndexOrThrow(RestaurantContract.RestaurantEntity.column_description))
                        + "\n Tags: "+
                        cursor.getString(cursor.getColumnIndexOrThrow(RestaurantContract.RestaurantEntity.column_tags));
            } while (cursor.moveToNext());
        }
        cursor.close();
        return name;
    }
    // Delete all records
    public void deleteRestaurant (Context context){
        DBHelper dbHelper = new DBHelper(context);
        SQLiteDatabase db = dbHelper.getReadableDatabase();

        try {
            db.delete(RestaurantContract.RestaurantEntity.TABLE_RESTAURANT,null,null);
            dbHelper.onCreate(db);
            db.close();
        }catch (SQLiteException e){
            db.close();
            e.printStackTrace();
        }
    }
}
