package com.example.abdallah.AndroidRestaurant;

import android.content.Context;
import android.widget.Toast;

public class Notification {

    public static void getNotification(Context context,String message){
        Toast.makeText(context,message,Toast.LENGTH_SHORT).show();
    }
}
