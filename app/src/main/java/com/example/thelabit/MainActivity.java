package com.example.thelabit;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.thelabit.modelo.DBTheLabIT;
import com.example.thelabit.modelo.Login;
import com.example.thelabit.vista.EjemploMapa;
import com.example.thelabit.vista.HomeCorredor;
import com.example.thelabit.vista.HomeEntrenador;
import com.example.thelabit.vista.RegistrarUsuario;

public class MainActivity extends AppCompatActivity {
    //API KEY AIzaSyCcekE7ZB5tACXfm6SJ9uDnfDbcX3IBd7E
    EditText username;
    EditText password;
    Button btnlogin;
    Button btnSignUp, btnMapa;
    DBTheLabIT DB;

    // creating constant keys for shared preferences.
    public static final String SHARED_PREFS = "shared_prefs";

    // key for storing email.
    public static final String USERNAME_KEY = "username_key";

    // key for storing password.
    public static final String PASSWORD_KEY = "password_key";

    // variable for shared preferences.
    SharedPreferences sharedpreferences;
    String SPusername, SPpassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        username    = (EditText) findViewById(R.id.username);
        password    = (EditText) findViewById(R.id.password);
        btnlogin    = (Button) findViewById(R.id.btnLogin);
        btnSignUp   = (Button) findViewById(R.id.btnSignUp);
        btnMapa   = (Button) findViewById(R.id.btnMapa);
        DB = new DBTheLabIT(this);
        // getting the data which is stored in shared preferences.
        sharedpreferences = getSharedPreferences(SHARED_PREFS, Context.MODE_PRIVATE);


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
                    SPusername = sharedpreferences.getString(USERNAME_KEY, null);
                    SPpassword = sharedpreferences.getString(PASSWORD_KEY, null);
                    SharedPreferences.Editor editor = sharedpreferences.edit();

                    // below two lines will put values for
                    // email and password in shared preferences.
                    editor.putString(USERNAME_KEY, user);
                    editor.putString(PASSWORD_KEY, pass);

                    // to save our data with key and value.
                    editor.apply();

                    Intent intent = new Intent(getApplicationContext(), HomeCorredor.class);
                    startActivity(intent);
                }else if (tipo == "entrenador"){
                    SPusername = sharedpreferences.getString(USERNAME_KEY, null);
                    SPpassword = sharedpreferences.getString(PASSWORD_KEY, null);

                    SPusername = sharedpreferences.getString(USERNAME_KEY, null);
                    SPpassword = sharedpreferences.getString(PASSWORD_KEY, null);
                    SharedPreferences.Editor editor = sharedpreferences.edit();

                    // below two lines will put values for
                    // email and password in shared preferences.
                    editor.putString(USERNAME_KEY, user);
                    editor.putString(PASSWORD_KEY, pass);

                    // to save our data with key and value.
                    editor.apply();

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
                //Toast.makeText(MainActivity.this, "error", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(getApplicationContext(), RegistrarUsuario.class);
                startActivity(intent);
            }
        });

        btnMapa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Toast.makeText(MainActivity.this, "error", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(getApplicationContext(), EjemploMapa.class);
                startActivity(intent);
            }
        });
    }
}