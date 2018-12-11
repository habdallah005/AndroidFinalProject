package com.example.abdallah.Backend.helpers;

import android.content.Context;
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
}
