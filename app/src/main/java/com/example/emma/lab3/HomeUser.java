package com.example.emma.lab3;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class HomeUser extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_user);

        Button historialButton = findViewById(R.id.historial_button);


    }

    public void historialButton(View view) {

        Intent intent = new Intent(this, HistorialActivity.class);
        startActivity(intent);
    }
}
