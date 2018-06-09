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

        travelInfo.add("Origen: Vilassar ---> Destí: Sants");
        travelInfo.add("Origen: Sants ---> Destí: Barcelona");
        travelInfo.add("Origen: Vilassar ---> Destí: Sants");
        travelInfo.add("Origen: Sants ---> Destí: Barcelona");
        travelInfo.add("Origen: Vilassar ---> Destí: Sants");
        travelInfo.add("Origen: Sants ---> Destí: Barcelona");
        travelInfo.add("Origen: Vilassar ---> Destí: Sants");
        travelInfo.add("Origen: Sants ---> Destí: Barcelona");
        travelInfo.add("Origen: Vilassar ---> Destí: Sants");
        travelInfo.add("Origen: Sants ---> Destí: Barcelona");

        Log.d("historial", String.valueOf(userID));

        for(int i = 0; i < travelById.size(); i++) {
            String info = "Estació Origen: " + travelById.get(i).getIdFrom() + "--->" + "Estació Destí: " + travelById.get(i).getIdTo();
            travelInfo.add(info);
            Log.d("historial:", String.valueOf(travelById));
        }
        ArrayAdapter<String> adaptador = new ArrayAdapter(this, android.R.layout.simple_expandable_list_item_1, travelInfo);

        historial.setAdapter(adaptador);

    }
}
