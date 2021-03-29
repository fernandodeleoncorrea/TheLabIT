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
    EditText Rusername; //, nombre, nacimiento, ciudad, pais, email, comentario, formacion;
    EditText nombre;
    DBTheLabIT DB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrar_entrenador);


        btnRegistro    = (Button) findViewById(R.id.btnRegistro);
        Rusername    = (EditText) findViewById(R.id.Rusername);
        /*nombre    = (EditText) findViewById(R.id.nombre);
        nacimiento    = (EditText) findViewById(R.id.nacimiento);
        ciudad    = (EditText) findViewById(R.id.ciudad);
        pais    = (EditText) findViewById(R.id.pais);
        email    = (EditText) findViewById(R.id.email);
        comentario    = (EditText) findViewById(R.id.comentario);
        formacion    = (EditText) findViewById(R.id.formacion);*/
        DB = new DBTheLabIT(this);

        btnRegistro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                String PRuser = Rusername.getText().toString();
                String Pnombre = "FERNANDO";
                String Pnacimiento = "123456";
                String Pciudad = "Montevideo";
                String Ppais = "Uruguay";
                String Pemail = "algo@algo.com";
                String Pcomentario = "comentario";
                String Pformacion = "Formacion EDF";

                Entrenador entrenador = new Entrenador(PRuser, Pnombre, Pnacimiento, Pciudad, Ppais, Pemail, Pcomentario, Pformacion);

                Toast.makeText(RegistrarEntrenador.this, Ppais.toString(), Toast.LENGTH_SHORT).show();

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