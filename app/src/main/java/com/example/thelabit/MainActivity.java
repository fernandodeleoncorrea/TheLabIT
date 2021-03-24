package com.example.thelabit;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText username;
    EditText password;
    Button btnlogin;
    DBTheLabIT DB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        username    = (EditText) findViewById(R.id.username);
        password    = (EditText) findViewById(R.id.password);
        btnlogin    = (Button) findViewById(R.id.btnLogin);
        DB = new DBTheLabIT(this);


        btnlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String user = username.getText().toString();
                String pass = password.getText().toString();

                Boolean ok = DB.chequearUsuarioPassword(user, pass);

                if (ok){
                    Intent intent = new Intent(getApplicationContext(), Ingreso.class);
                    startActivity(intent);
                } else {
                    Toast.makeText(MainActivity.this, "nooo", Toast.LENGTH_SHORT).show();
                    Toast.makeText(MainActivity.this, "nooo2", Toast.LENGTH_SHORT).show();
                }

            }
        });
    }
}