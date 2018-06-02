package com.example.emma.lab3;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_activity);

        final EditText userName = findViewById(R.id.user_name);
        final EditText userPass = findViewById(R.id.user_password);

        Button login = findViewById(R.id.login_button);

        Log.d("USUARI", "Usuari: " + MainActivity.db.myDao().getAllUsers().get(1).getName());
        Log.d("CONTRA", "Contrasenya: "+ MainActivity.db.myDao().getAllUsers().get(1).tag);
        Log.d("USUARIS", "Num users: "+ MainActivity.db.myDao().numUsers());


        final String user = userName.getText().toString();
        final String pass = userPass.getText().toString();

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loginButton(user, pass);
            }
        });
    }

    private void loginButton(String user, String pass){

        int numUsers = MainActivity.db.myDao().numUsers();


        for(int i = 0; i < numUsers; i++){
            if(user == MainActivity.db.myDao().getAllUsers().get(i).getName()){
                    Log.d("HOLA", "HOLAAAA1111111");
                    int index = i;
                if(pass == MainActivity.db.myDao().getAllUsers().get(index).getTag());
                    Log.d("HOLA", "HOLAAAA2222222");
                    Intent intent = new Intent(this, HomeUser.class);
                    startActivity(intent);
            }
        }


    }




}
