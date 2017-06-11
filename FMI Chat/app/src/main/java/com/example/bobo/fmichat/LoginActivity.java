package com.example.bobo.fmichat;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Toast;
import android.widget.Button;
import android.widget.EditText;

/**
 * Created by H4ck1nt0sh on 08/06/2017.
 */

public class LoginActivity extends AppCompatActivity {

    private Button go;                // Butonul De Trimitere
    private EditText add_user;       // Initializare Zona Text User
    private EditText add_pass;      // Initializare Zona Text Password


    private String username;
    private String password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {         //Zona incarcata la accesarea aplicatiei

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        add_user = (EditText) findViewById(R.id.email);
        add_pass = (EditText) findViewById(R.id.password);
        go = (Button) findViewById(R.id.email_sign_in_button);

        go.setOnClickListener(new OnClickListener() {
            public void onClick(View arg0) {

                username = add_user.getText().toString();              //Input Username
                password = add_pass.getText().toString();             //Input Password

                if (username.equals("") && password.equals("")) {   //Form-ul NU trebuie sa fie gol
                    Toast.makeText(getApplicationContext(),
                            "Please complete the sign up form . . .",
                            Toast.LENGTH_LONG).show();

                } else {

                    Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                    intent.putExtra("name", username);
                    intent.putExtra("password", password);
                    startActivity(intent);                  //Trimite datele catre MainActivity

                }

            }
        });
    }
}
