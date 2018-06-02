package com.example.emma.lab3;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class HomeUser extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_user);

        TextView textview = findViewById(R.id.welcome_text);
        String user = getIntent().getStringExtra("User");
        textview.setText("Welcome User: "+ user);
    }
}
