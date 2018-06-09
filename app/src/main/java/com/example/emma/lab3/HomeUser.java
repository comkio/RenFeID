package com.example.emma.lab3;

/*
* Cal afegir un boto per a fer logout del usuari.
*
* */
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

public class HomeUser extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_user);

        Button historialButton = findViewById(R.id.historial_button);
        Button logoutButton = findViewById(R.id.log_out);
        TextView welcome = findViewById(R.id.welcome_text);
        int userID = MainActivity.db.myDao().getUserLogged();

        int ongoingTravel = MainActivity.db.myDao().getOngoingTravelByUser(userID);
        String ongoingStop = MainActivity.db.myDao().getStopNameById(ongoingTravel);
        welcome.setText("Benvingut " + getIntent().getStringExtra("User"));
        if(MainActivity.db.myDao().getAllTravels().size() != 0)
        ongoingStop = ongoingStop + MainActivity.db.myDao().getAllTravels().get(0).getIdFrom().toString();

        TextView textView = findViewById(R.id.textView);
        textView.setText(ongoingStop);

    }

    public void historialButton(View view) {

        Intent intent = new Intent(this, HistorialActivity.class);
        startActivity(intent);
    }

    public void logoutButton(View view){
        int userLogged = MainActivity.db.myDao().getUserLogged();
        User user = MainActivity.db.myDao().getAllUsers().get(userLogged);
        user.setLogin(false);
        finish();
    }
}
