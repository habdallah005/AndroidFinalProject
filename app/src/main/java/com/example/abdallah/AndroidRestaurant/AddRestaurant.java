package com.example.abdallah.AndroidRestaurant;

import android.content.Context;
import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.abdallah.Backend.helpers.DBHelper;
import com.example.abdallah.R;

import java.util.ArrayList;


public class AddRestaurant extends Activity {

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
    }
}
