package com.example.abdallah.Backend.helpers;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

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

    public boolean insertData(String name, String address, String phone, String description, String tags) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(RestaurantContract.RestaurantEntity.column_name,name);
        contentValues.put(RestaurantContract.RestaurantEntity.column_address,address);
        contentValues.put(RestaurantContract.RestaurantEntity.column_phone,phone);
        contentValues.put(RestaurantContract.RestaurantEntity.column_description,description);
        contentValues.put(RestaurantContract.RestaurantEntity.column_tags,tags);
        long result = db.insert(RestaurantContract.RestaurantEntity.TABLE_RESTAURANT,null,contentValues);
        return true;
    }

    public Cursor getAllData() {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res = db.rawQuery("select * from " +RestaurantContract.RestaurantEntity.TABLE_RESTAURANT,null);
        return res;
    }
}
