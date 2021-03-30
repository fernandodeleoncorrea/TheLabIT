package com.example.thelabit;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.thelabit.modelo.Corredor;
import com.example.thelabit.modelo.DBTheLabIT;
import com.example.thelabit.modelo.Login;
import com.example.thelabit.vista.HomeCorredor;
import com.example.thelabit.vista.HomeEntrenador;
import com.example.thelabit.vista.RegistrarEntrenador;

public class MainActivity extends AppCompatActivity {

    EditText username;
    EditText password;
    Button btnlogin;
    Button btnSignUp, btnLista;
    DBTheLabIT DB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        username    = (EditText) findViewById(R.id.username);
        password    = (EditText) findViewById(R.id.password);
        btnlogin    = (Button) findViewById(R.id.btnLogin);
        btnSignUp   = (Button) findViewById(R.id.btnSignUp);
        btnLista   = (Button) findViewById(R.id.btnLista);

        DB = new DBTheLabIT(this);


        btnlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //esto es para iniciar la base de datos pero no sé si funciona
                DB.inicio();

                String user = username.getText().toString();
                String pass = password.getText().toString();

                //creo un objeto Login para hacer el chequeo
                Login login = new Login(user, pass);
                //Corredor corredor = new Corredor();

                String tipo = DB.chequearUsuarioPassword(login);

                //chequeo de los datos ingresados
                if (tipo == "corredor"){
                    Intent intent = new Intent(getApplicationContext(), HomeCorredor.class);
                    startActivity(intent);
                }else if (tipo == "entrenador"){
                    Intent intent = new Intent(getApplicationContext(), HomeEntrenador.class);
                    startActivity(intent);
                }else {
                    Toast.makeText(MainActivity.this, "nooo", Toast.LENGTH_SHORT).show();
                }

            }
        });

        btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "error", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(getApplicationContext(), RegistrarEntrenador.class);
                startActivity(intent);
            }
        });
    }
}