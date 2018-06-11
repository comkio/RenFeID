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
        final ListView historial = findViewById(R.id.historial);


        int userID = MainActivity.db.myDao().getUserLogged();
        List<Travel> travelById = MainActivity.db.myDao().getAllTravelsByUser(userID);
        List<String> travelInfo = new LinkedList<>();

        for(int i = 0; i < travelById.size(); i++) {
            Log.d("historial:","travel id to: "+travelById.get(i).getIdTo());
            String info = "Origen: " + travelById.get(i).getIdFrom() + " --> " + "Destí: " + travelById.get(i).getIdTo() + ". Preu: " + travelById.get(i).getCost();
            travelInfo.add(info);
        }
        ArrayAdapter<String> adaptador = new ArrayAdapter(this, android.R.layout.simple_expandable_list_item_1, travelInfo);

        historial.setAdapter(adaptador);

    }
}
