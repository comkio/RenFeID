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

        //Travel travel1 = new Travel(0,1,2,true,0.5,1);
        //Travel travel2 = new Travel(2,1,2,true,0.5,1);
        //MainActivity.db.myDao().insertTravels(travel1);
        //MainActivity.db.myDao().insertTravels(travel2);

        int userID = MainActivity.db.myDao().getUserLogged();
        List<Integer> travelById = MainActivity.db.myDao().getAllTravelsByUser(userID);

        ArrayAdapter<String> adaptador = new ArrayAdapter(this, android.R.layout.simple_expandable_list_item_1, travelById);

        final ListView historial = findViewById(R.id.historial);
        historial.setAdapter(adaptador);

    }
}
