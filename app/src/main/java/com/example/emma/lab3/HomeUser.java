package com.example.emma.lab3;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import org.w3c.dom.Text;

public class HomeUser extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_user);

        TextView textView = findViewById(R.id.welcome_text);
        textView.setText("Benvingut" + getIntent().getStringExtra("user")
                + "amb id: " + (getIntent().getStringExtra("id")));

    }
}
