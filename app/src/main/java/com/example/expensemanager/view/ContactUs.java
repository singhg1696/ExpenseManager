package com.example.expensemanager.view;

import android.Manifest;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.core.app.ActivityCompat;

import com.example.expensemanager.R;

public class ContactUs extends AppCompatActivity {

    AppCompatButton btnCall, btnMessage, btnMail,btnsend;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activitycontactus);
        getSupportActionBar().setTitle("Contact Us");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);
        btnCall = findViewById(R.id.btncallaboutus);
        btnMessage = findViewById(R.id.btntextaboutus);
        btnsend = findViewById(R.id.btnsendmessage);

        btnCall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    Intent callIntent = new Intent(Intent.ACTION_CALL);
                    callIntent.setData(Uri.parse("tel:"+"6475259586"));
                    if (checkSelfPermission(Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                        // TODO: Consider calling
                        //    Activity#requestPermissions
                        // here to request the missing permissions, and then overriding
                        //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
                        //                                          int[] grantResults)
                        // to handle the case where the user grants the permission. See the documentation
                        // for Activity#requestPermissions for more details.
                        ActivityCompat.requestPermissions(ContactUs.this,
                                new String[]{Manifest.permission.CALL_PHONE},   //request specific permission from user
                                10);
                        startActivity(callIntent);
                        return;
                    } else {
                        startActivity(callIntent);
                    }
                } catch (ActivityNotFoundException activityException) {
                    Toast.makeText(ContactUs.this, "Error", Toast.LENGTH_SHORT).show();
                }
            }
        });

        btnMessage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                RelativeLayout relativeLayout = findViewById(R.id.btnBodyMessage);
                relativeLayout.setVisibility(View.VISIBLE);

                final EditText userInput = findViewById(R.id.edittextMessage);
                final String message = userInput.getText().toString();
                Log.d("messageMeTo", message);
                btnsend.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent = new Intent(Intent.ACTION_VIEW);
                        intent.putExtra("address", "6475259586");
                        intent.putExtra("sms_body", userInput.getText().toString());
                        intent.setType("vnd.android-dir/mms-sms");
                        startActivity(intent);
                    }
                });
            }
        });
    }
}
