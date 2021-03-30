package com.example.thelabit.vista;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.thelabit.R;
import com.example.thelabit.modelo.DBTheLabIT;
import com.example.thelabit.modelo.Entrenador;

public class RegistrarEntrenador extends AppCompatActivity {

    Button btnRegistro;
    EditText Rusername, nombre, email, nacimiento;
    DBTheLabIT DB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrar_entrenador);


        btnRegistro    = (Button) findViewById(R.id.btnRegistro);
        Rusername    = (EditText) findViewById(R.id.Rusername);
        nombre    = (EditText) findViewById(R.id.nombre);
        nacimiento    = (EditText) findViewById(R.id.nacimiento);
        email    = (EditText) findViewById(R.id.email);
        DB = new DBTheLabIT(this);

        btnRegistro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                String PRuser = Rusername.getText().toString();
                String Pnombre = nombre.getText().toString();
                String Pnacimiento = nacimiento.getText().toString();  //YYYYMMDD
                String Pciudad = null;
                String Ppais = null;
                String Pemail = email.getText().toString();
                String Pcomentario = null;
                String Pformacion = null;

                Entrenador entrenador = new Entrenador(PRuser, Pnombre, Pnacimiento, Pciudad, Ppais, Pemail, Pcomentario, Pformacion);

                //Toast.makeText(RegistrarEntrenador.this, Ppais.toString(), Toast.LENGTH_SHORT).show();

                Boolean resultado = DB.insertEntrenador(entrenador);

                if (resultado == true) {
                    Toast.makeText(RegistrarEntrenador.this, "exito", Toast.LENGTH_SHORT).show();

                    Intent intent = new Intent(getApplicationContext(), HomeEntrenador.class);
                    startActivity(intent);

                }else{
                    Toast.makeText(RegistrarEntrenador.this, "error", Toast.LENGTH_SHORT).show();
                }

            }
        });
    }
}