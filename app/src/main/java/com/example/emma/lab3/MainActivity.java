package com.example.emma.lab3;

import android.arch.persistence.room.Room;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import java.util.LinkedList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {

    public static MyDatabase db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //final String originIP = "192.168.2.110";
        //final String originIP = "localhost";
        final String originIP = "192.168.0.161";//ip del pc en cas d'utilitzar simulador
        final String destIP = "192.168.0.156";

        //Creating Database
        db = Room.databaseBuilder(getApplicationContext(),
                MyDatabase.class, "Database").allowMainThreadQueries().fallbackToDestructiveMigration().build();

        List<Stops> stopsList = new LinkedList<>();

        Stops stop1 = new Stops(0,"Vilassar de Mar", originIP);
        Stops stop2 = new Stops(0,"Barcelona Sants", destIP);

        stopsList.add(stop1);
        stopsList.add(stop2);

        db.myDao().insertStops(stopsList);
/*
        //TODO: Llegir usuaris de la UI
        User user1 = new User(1,"Emma","123");

        db.myDao().insertUsers(user1);

        Travel travel = new Travel(1,1,2,false,1.50,1);

        db.myDao().insertTravels(travel);

        Log.d("Test", "Stops: "+ db.myDao().getAllStops().get(0).getName());
        Log.d("Test", "User: "+db.myDao().getAllUsers().get(0).getName());
        Log.d("Test", "Cost: "+db.myDao().getAllTravels().get(0).getCost());
        */
        //Cada 5 segons crida a les tasques
        Timer timerAsync = new Timer();
        TimerTask timerTaskAsync = new TimerTask() {
            @Override
            public void run() {
                MyTaskOrigin taskorigin = new MyTaskOrigin(originIP);
                MyTaskDest taskdest = new MyTaskDest(destIP);
                taskorigin.execute();
                taskdest.execute();
            }
        };
        timerAsync.schedule(timerTaskAsync, 0, 5000);
    }

    public void loginActivity(View view){

        Intent intent = new Intent(this, LoginActivity.class);
        startActivity(intent);

    }

    public void registerActivity(View view){

        Intent intent = new Intent(this, RegisterActivity.class);
        startActivity(intent);

    }

}

