package com.example.emma.lab3;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.LinkedList;
import java.util.List;

public class HistorialActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_historial);

        int userID = MainActivity.db.myDao().getUserLogged();
        Log.d("historial", String.valueOf(userID));
        List<Integer> travelById = MainActivity.db.myDao().getAllTravelsByUser(userID);
        Log.d("historial", String.valueOf(travelById));

        ArrayAdapter<String> adaptador = new ArrayAdapter(this, android.R.layout.simple_expandable_list_item_1, travelById);

        final ListView historial = findViewById(R.id.historial);
        historial.setAdapter(adaptador);

    }
}
