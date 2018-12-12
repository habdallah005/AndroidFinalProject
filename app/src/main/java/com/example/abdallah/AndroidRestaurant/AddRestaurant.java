package com.example.abdallah.AndroidRestaurant;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.app.Activity;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.abdallah.Backend.helpers.DBHelper;
import com.example.abdallah.Backend.model.Restaurant;
import com.example.abdallah.R;



public class AddRestaurant extends Activity implements AdapterView.OnItemSelectedListener {

    TextView txtName;
    TextView txtAddress;
    TextView txtPhone;
    TextView txtDescription;
    String tTags;

    Spinner spin;

    int hold;
    //Create Spinner for the tags, this is the dropdown same as select in html
    String[] tags={"Vegetarian","Vegan","Organic","Italian","Thai","Japanese",
            "African", "Brazilian", "Portuguese", "Chinese", "Others"};

    DBHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_restaurant);


        spin = findViewById(R.id.txtTags);
        spin.setOnItemSelectedListener(this);
        ArrayAdapter adapter = new ArrayAdapter(this,android.R.layout.simple_spinner_item,tags);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        //Setting the ArrayAdapter data on the Spinner
        spin.setAdapter(adapter);
        spin.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                hold = spin.getSelectedItemPosition()+1;
                tTags = tags[hold];
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        Button btn = findViewById(R.id.btnAdd);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                add_Restaurant(v);
            }
        });

    }

    public void add_Restaurant(View view) {

        dbHelper = new DBHelper(this);
        //Get all the value from the xml
        // set the string
        txtName = findViewById(R.id.txtName);
        txtAddress = findViewById(R.id.txtAddress);
        txtPhone = findViewById(R.id.txtPhone);
        txtDescription = findViewById(R.id.txtDescription);

        String name = txtName.getText().toString();
        String address = txtAddress.getText().toString();
        String phone = txtPhone.getText().toString();
        String description = txtDescription.getText().toString();
        //String tags =txtTags.getText().toString();

        txtName.setError(null);
        txtAddress.setError(null);
        txtDescription.setError(null);
        txtPhone.setError(null);

        View focusView = null;
        boolean cancel = false;


        if (TextUtils.isEmpty(name)) {
            txtName.setError("Restaurant Name required");
            focusView = txtName;
            cancel = true;
        }

        if (TextUtils.isEmpty(address)) {
            txtAddress.setError("Address required");
            focusView = txtAddress;
            cancel = true;
        }

        if (TextUtils.isEmpty(phone)) {
            txtPhone.setError("Phone required");
            focusView = txtPhone;
            cancel = true;
        }


        if (TextUtils.isEmpty(description)) {
            txtDescription.setError("Descritpion required");
            focusView = txtDescription;
            cancel = true;
        }

        if (cancel) {
            focusView.requestFocus();
        } else {
            Restaurant restaurant = new Restaurant(name, address, phone, description, tTags);
            SQLiteDatabase db = dbHelper.getWritableDatabase();
            long d = dbHelper.insertData(db, restaurant);
        }
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}

