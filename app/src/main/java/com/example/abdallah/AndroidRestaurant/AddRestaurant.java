package com.example.abdallah.AndroidRestaurant;

import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.app.Activity;
import android.text.TextUtils;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.abdallah.Backend.helpers.DBHelper;
import com.example.abdallah.Backend.model.Restaurant;


import java.util.ArrayList;


public class AddRestaurant extends Activity {
/*
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_restaurant);

        final DBHelper db = new DBHelper(this);

        Button btn = findViewById(R.id.btnAdd);
        final EditText text1 = findViewById(R.id.txtName);
        final EditText text2 =findViewById(R.id.txtAddress);
        final EditText text3 =findViewById(R.id.txtPhone);
        final EditText text4 =findViewById(R.id.txtDescription);
        final EditText text5 =findViewById(R.id.txtTags);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                {

                    String value1 = text1.getText().toString();
                    String value2 =text2.getText().toString();
                    String value3 =text3.getText().toString();
                    String value4 =text4.getText().toString();
                    String value5 =text5.getText().toString();

                    db.insertData(value1,value2,value3,value4,value5);



                    Context context = getApplicationContext();
                    CharSequence text = "Submitted... i think!";
                    int duration = Toast.LENGTH_SHORT;

                    Toast toast = Toast.makeText(context, text, duration);
                    toast.show();
                }
            }
        });
    }*/

    TextView txtName;
    TextView txtAddress;
    TextView txtPhone;
    TextView txtDescription;
    TextView txtTags;

    DBHelper dbHelper;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_restaurant);


/* ------ CHECK HERE PLEASE----
        Button btnAdd = findViewById(R.id.btnAdd);
        btnAdd.setOnClickListener((v){AddRestaurant(v);});
            @Override
            public void onClick(View v) {
                addRestaurant(v);
            }

            Button btnView = findViewById(R.id.btnView);
            btnView.setOnClickListener((v) {
                  Intent i = new Intent(v.getContext(), AddRestaurant.class);
                    startActivity(i);
                }

            });

        public void addRestaurant(View v){


        dbHelper = new DBHelper(this);
        txtName = findViewById(R.id.txtName);
        txtAddress = findViewById(R.id.txtAddress);
        txtPhone = findViewById(R.id.txtPhone);
        txtDescription = findViewById(R.id.txtDescription);
        txtTags = findViewById(R.id.txtTags);

        String name = txtName.getText().toString();
        String address =txtAddress.getText().toString();
        String phone =txtPhone.getText().toString();
        String description =txtDescription.getText().toString();
        String tags =txtTags.getText().toString();

        txtName.setError(null);
        txtAddress.setError(null);
        txtDescription.setError(null);
        txtPhone.setError(null);
        txtTags.setError(null);

        View focusView=null;
        boolean cancel=false;

        if(TextUtils.isEmpty(name)){
            txtName.setError("Restaurant Name required");
            focusView = txtName;
            cancel=true;
        }
            if(TextUtils.isEmpty(address)){
                txtAddress.setError("Address required");
                focusView = txtAddress;
                cancel=true;
            }
            if(TextUtils.isEmpty(phone)){
                txtPhone.setError("Phone required");
                focusView = txtPhone;
                cancel=true;
            }

            if(TextUtils.isEmpty(description)){
                txtDescription.setError("Descritpion required");
                focusView = txtDescription;
                cancel=true;
            }

            if(TextUtils.isEmpty(tags)){
                txtTags.setError("Restaurant Name required");
                focusView = txtTags;
                cancel=true;
            }

            if (cancel){
            focusView.requestFocus();
            }else {
                Restaurant restaurant = new Restaurant(name,address,phone, description,tags);
                SQLiteDatabase db =dbHelper.getWritableDatabase();
                long d = dbHelper.insertData(db,restaurant);

                Notification.getNotification(getApplicationContext(),"Successful Inserted");

        }
        }
        public void delete (View view){
        dbHelper = new DBHelper(this);
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        dbHelper.deleteRestaurant(this);
        Notification.getNotification(getApplicationContext(),"Deleted");
        }

         */
    }
}