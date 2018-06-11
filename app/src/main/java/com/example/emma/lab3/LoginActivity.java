package com.example.emma.lab3;

/*
* Usuari inicia sessio, login = true del camp d'usuari.
*
* */
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

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

                loginButton(user, pass);
            }
        });
    }

    private void loginButton(String user, String pass){

        boolean state = true;
        int numUsers = MainActivity.db.myDao().numUsers();

        for(int i = 0; i < numUsers; i++){
            if(user.equals(MainActivity.db.myDao().getAllUsers().get(i).getName())){
                int index = i;
                if(pass.equals(MainActivity.db.myDao().getAllUsers().get(index).getPassword())) {
                    Log.d("login","user to log: "+MainActivity.db.myDao().getAllUsers().get(index).getLogin());
                    MainActivity.db.myDao().getAllUsers().get(index).setLogin(1);
                    Log.d("LOGIN", "Usuari: " + MainActivity.db.myDao().getAllUsers().get(index).getLogin());
                    Intent intent = new Intent(this, HomeUser.class);
                    intent.putExtra("ID", MainActivity.db.myDao().getAllUsers().get(index).getId());
                    intent.putExtra("User", user);
                    startActivity(intent);
                }else{
                    Context context = getApplicationContext();
                    CharSequence text = "Contrasenya erronia!";
                    int duration = Toast.LENGTH_SHORT;

                    Toast toast = Toast.makeText(context, text, duration);
                    toast.show();
                }
            }
        }
    }
}
