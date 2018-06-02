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


        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String user = userName.getText().toString();
                String pass = userPass.getText().toString();

                Log.d("USUARI", "Usuari: " + MainActivity.db.myDao().getAllUsers().get(0).getName());
                Log.d("CONTRA", "Contrasenya: "+ MainActivity.db.myDao().getAllUsers().get(0).tag);
                Log.d("USUARIS", "Num users: "+ MainActivity.db.myDao().numUsers());

                loginButton(user, pass);
            }
        });
    }

    private void loginButton(String user, String pass){

        int numUsers = MainActivity.db.myDao().numUsers();

        for(int i = 0; i < numUsers; i++){
            if(user.equals(MainActivity.db.myDao().getAllUsers().get(i).getName())){
                int index = i;
                if(pass.equals(MainActivity.db.myDao().getAllUsers().get(index).getTag())) {
                    Intent intent = new Intent(this, HomeUser.class);
                    intent.putExtra("ID", MainActivity.db.myDao().getAllUsers().get(i).getId());
                    intent.putExtra("User", user);
                    startActivity(intent);
                }
            }
        }
    }




}
