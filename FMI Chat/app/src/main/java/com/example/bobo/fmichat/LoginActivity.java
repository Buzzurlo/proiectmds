package com.example.bobo.fmichat;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

/**
 * Created by H4ck1nt0sh on 08/06/2017.
 */

public class LoginActivity extends AppCompatActivity {

    private Button go;
    private String username;
    private String password;
    private ListView listView;

    @SuppressLint("MissingSuperCall")       // <-- Supress-ul trebuie scos cand se va pune in AndroidManifest.xml
                                           // LoginActivity ca LAUNCHER
    @Override
    protected void onCreate(Bundle savedInstanceState) {         //Zona incarcata la accesarea aplicatiei

        validate_user_pass();

        listView = (ListView) findViewById(R.id.ListView);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                intent.putExtra("username", username);
                intent.putExtra("password", password);
                startActivity(intent);
            }
        });
    }

    private void validate_user_pass() {                    //Trimite Username + Password

        final EditText email_text =  (EditText) findViewById(R.id.email);
        final EditText pass_text = (EditText) findViewById(R.id.password);
        username = email_text.getText().toString();
        password = pass_text.getText().toString();

    }
}
