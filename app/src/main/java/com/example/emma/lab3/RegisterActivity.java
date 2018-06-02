package com.example.emma.lab3;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class RegisterActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);


        final EditText registerName = (EditText) findViewById(R.id.register_user);
        final EditText registerPass = findViewById(R.id.register_pass);

        final Button register = (Button) findViewById(R.id.register_button);

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String userName = registerName.getText().toString();
                String userPass = registerPass.getText().toString();

                registerButton(userName, userPass);
            }
        });
    }


    private void registerButton(String userName, String userPass){

        int numUsers = MainActivity.db.myDao().getAllUsers().size() - 1;

        Log.d("USER", "Print: " + MainActivity.db.myDao().numUsers());

        //comprova si la taula esta buida, si ho esta crea el primer registre
        if(MainActivity.db.myDao().numUsers() == 0) {

            User user = new User(1, userName, userPass);

            MainActivity.db.myDao().insertUsers(user);

        }else{//si la taula ja te registres agafa en crea un de nou amb el següent id

            User user = new User(MainActivity.db.myDao().getAllUsers().get(numUsers).getId() + 1,
                    userName, userPass);
            MainActivity.db.myDao().insertUsers(user);

        }

        finish();
    }

}
