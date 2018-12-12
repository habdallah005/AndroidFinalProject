package com.example.abdallah.AndroidRestaurant;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Context;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Button;
import android.content.Intent;
import android.net.Uri;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

public class ShareActivity extends AppCompatActivity {

    EditText etEmail;
    EditText etSubject;
    EditText etMessage;
    Button Send;
    Button Maps1;
    String email;
    String subject;
    String message;

    Uri URI = null;
    Context context;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_share);
        context = getApplicationContext();

        etEmail = (EditText) findViewById(R.id.etEmail);
        etSubject = (EditText) findViewById(R.id.etSubject);
        etMessage = (EditText) findViewById(R.id.etMessage);
        Send = (Button) findViewById(R.id.btnSendEmail);


        // send Email button Listener
        Send.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                sendEmail();

            }

            private void sendEmail() {

                try {
                    email = etEmail.getText().toString();
                    subject = etSubject.getText().toString();
                    message = etMessage.getText().toString();

                    final Intent emailIntent =
                            new Intent(Intent.ACTION_SEND);

                    emailIntent.setType("plain/text");

                    emailIntent.putExtra(Intent.EXTRA_EMAIL, new String[]{email});

                    emailIntent.putExtra(Intent.EXTRA_SUBJECT, subject);
                    if (URI != null) {
                        emailIntent.putExtra(Intent.EXTRA_STREAM, URI);
                    }
                    emailIntent.putExtra(Intent.EXTRA_TEXT, message);
                    startActivity(Intent.createChooser(emailIntent, "Sending email..."));


                } catch (Throwable t) {
                    Toast.makeText(context, "Request failed try again: " + t.toString(), Toast.LENGTH_LONG).show();
                }
            }

        });
    }
}
