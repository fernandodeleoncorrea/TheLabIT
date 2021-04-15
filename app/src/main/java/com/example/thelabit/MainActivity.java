package com.example.thelabit;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.thelabit.modelo.DBTheLabIT;
import com.example.thelabit.modelo.Login;
import com.example.thelabit.modelo.Sesion;
import com.example.thelabit.vista.ViewDetalleActividad;
import com.example.thelabit.vista.corredor.HomeCorredor;
import com.example.thelabit.vista.HomeEntrenador;
import com.example.thelabit.vista.RegistrarUsuario;
import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity {
    //API KEY AIzaSyCcekE7ZB5tACXfm6SJ9uDnfDbcX3IBd7E
    EditText username;
    EditText password;
    Button btnlogin;
    Button btnSignUp, btnMapa;
    DBTheLabIT DB;
    Boolean LoginOK = false;
    SharedPreferences sharedpreferences;
    String SPusername, SPpassword;
    private Sesion sesion;

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


        btnlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //esto es para iniciar la base de datos pero no sé si funciona
                DB.inicio();

                String user = username.getText().toString();
                String logueado = username.getText().toString();
                String pass = password.getText().toString();

                //creo un objeto Login para hacer el chequeo
                Login login = new Login(user, pass);

                String tipo = DB.chequearUsuarioPassword(login);

                //chequeo de los datos ingresados
                if (tipo == "corredor"){

                    String nombreUsuario = DB.obtenerNombre(user);
                    Intent intent = new Intent(getApplicationContext(), HomeCorredor.class);
                    Bundle b = new Bundle();
                    b.putString("logueado", logueado);
                    b.putString("nombreUsuario", nombreUsuario);
                    intent.putExtras(b);
                    startActivity(intent);
                    finish();

                }else if (tipo == "entrenador"){

                    Intent intent = new Intent(MainActivity.this, HomeEntrenador.class);
                    Bundle b = new Bundle();
                    b.putString("logueado", logueado);
                    intent.putExtras(b);
                    startActivity(intent);
                    finish();

                }else {
                    //Toast.makeText(MainActivity.this, "nooo", Toast.LENGTH_SHORT).show();
                    Snackbar.make(v, getResources().getString(R.string.mensaje), Snackbar.LENGTH_LONG).show();

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
                Intent intent = new Intent(getApplicationContext(), ViewDetalleActividad.class);
                //Intent intent = new Intent(getApplicationContext(), EjemploLocation.class);
                startActivity(intent);
            }
        });
    }
}