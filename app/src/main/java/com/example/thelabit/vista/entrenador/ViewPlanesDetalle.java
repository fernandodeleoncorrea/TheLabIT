package com.example.thelabit.vista.entrenador;

import androidx.appcompat.app.AppCompatActivity;


import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.thelabit.R;
import com.example.thelabit.modelo.Actividad;
import com.example.thelabit.modelo.DBTheLabIT;
import com.google.android.material.snackbar.Snackbar;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.InputStream;
import java.nio.Buffer;
import java.util.ArrayList;
import java.util.List;

public class ViewPlanesDetalle extends AppCompatActivity {


    EditText descripcion;
    Button btnAceptarDia, btnFinalizar, btnImportarPlan;
    DBTheLabIT DB;
    Spinner spinnerSemana, spinnerDia, spinnerTurno;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_planes_detalle);


        spinnerSemana = findViewById(R.id.spinnerSemana);
        spinnerDia= findViewById(R.id.spinnerDia);
        spinnerTurno = findViewById(R.id.spinnerTurno);
        descripcion       = (EditText) findViewById(R.id.descripcion);
        btnAceptarDia   = (Button) findViewById(R.id.btnAceptarDia);
        btnFinalizar   = (Button) findViewById(R.id.btnFinalizar);
        btnImportarPlan   = (Button) findViewById(R.id.btnImportarPlan);
        DB = new DBTheLabIT(this);

        //cargo el spinner de semana
        String[] stringSemanas = new String[]{"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12"};
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, stringSemanas);
        spinnerSemana.setAdapter(adapter);

        //cargo el combo de turno
        String[] stringDias = new String[]{"1", "2", "3", "4", "5", "6", "7"};
        ArrayAdapter<String> adapter1 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, stringDias);
        spinnerDia.setAdapter(adapter1);

        //cargo el combo de turno
        String[] stringTurnos = new String[]{"Mañana", "Tarde", "Noche"};
        ArrayAdapter<String> adapter2 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, stringTurnos);
        spinnerTurno.setAdapter(adapter2);

        Bundle b = getIntent().getExtras();
        Integer idPlan = Integer.parseInt(b.getString("idPlan"));
        String logueado = b.getString("logueado");
        String nombreUsuario = b.getString("nombreUsuario");


        btnAceptarDia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Actividad actividad = new Actividad(
                        1
                        , spinnerSemana.getSelectedItem().toString()
                        , spinnerDia.getSelectedItem().toString()
                        , spinnerTurno.getSelectedItem().toString()
                        , descripcion.getText().toString()
                        , 0
                        , idPlan
                );


                Boolean resultado = DB.insertActividad(actividad);

                if (resultado){
                    String mensaje = "Actividad de la semana " + spinnerSemana.getSelectedItem().toString() + ", dia "
                            + spinnerDia.getSelectedItem().toString() + "cargada OK";
                    Toast.makeText(ViewPlanesDetalle.this, mensaje, Toast.LENGTH_LONG).show();
                    descripcion.getText().clear();
                }
            }
        });



        btnFinalizar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Boolean resultado = DB.insertDetallePlan(logueado, null, idPlan);

                if (resultado){
                    //Toast.makeText(ViewPlanesDetalle.this, "plan dado de alta", Toast.LENGTH_SHORT).show();
                    Snackbar.make(v, getResources().getString(R.string.alta_plan), Snackbar.LENGTH_LONG).show();
                    Intent intent = new Intent(ViewPlanesDetalle.this, HomeEntrenador.class);
                    Bundle b = new Bundle();
                    b.putString("logueado", logueado);
                    b.putString("nombreUsuario", nombreUsuario);
                    intent.putExtras(b);
                    startActivity(intent);
                    finish();

                }
            }
        });

        btnImportarPlan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(ViewPlanesDetalle.this, "Archivo CSV delimitado por coma", Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
                Uri uri = Uri.parse(""); // a directory
                intent.setDataAndType(uri, "*/*");
                startActivity(Intent.createChooser(intent, "Open folder"));
            }
        });
    }

}