package com.example.abdallah.Backend.helpers;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.provider.BaseColumns;

public final class RestaurantContract {
    private RestaurantContract() {}

    // Create another class to define the base columns
    public static class RestaurantEntity implements BaseColumns {

        public static final String TABLE_RESTAURANT= "restaurant";
    //Define the column name
        public static final String _ID = "_ID";
        public static final String column_name = "Name";
        public static final String column_address = "Address";
        public static final String column_phone = "Phone";
        public static final String column_description = "Description";
        public static final String column_tags = "Tags";
        public static final String COL_TYPE = "TEXT";
    //CODE TO CREATE SQL COMMAND

    public static final String SQL_CREATE_TABLE =
            "CREATE TABLE "+RestaurantEntity.TABLE_RESTAURANT+" ("+
                    RestaurantEntity._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "+
                    RestaurantEntity.column_name + " " + RestaurantEntity.COL_TYPE+", "+
                    RestaurantEntity.column_address+", "+ RestaurantEntity.COL_TYPE+", "+
                    RestaurantEntity.column_phone + " " + RestaurantEntity.COL_TYPE+", "+
                    RestaurantEntity.column_description +", "+RestaurantEntity.COL_TYPE+", "+
                    RestaurantEntity.column_tags + " " + RestaurantEntity.COL_TYPE +", "+
                   ")";

        // This is how we dropped the database
    public static final String SQL_DROP_TABLE =
            "DROP TABLE IF EXISTS "+ RestaurantEntity.TABLE_RESTAURANT;
}
    }




