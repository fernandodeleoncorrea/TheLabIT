package com.example.thelabit.vista;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.thelabit.MainActivity;
import com.example.thelabit.R;
import com.example.thelabit.ViewNuevoPlan;
import com.example.thelabit.modelo.Actividad;
import com.example.thelabit.modelo.DBTheLabIT;
import com.example.thelabit.modelo.PlanEntrenamiento;

public class ViewPlanesDetalle extends AppCompatActivity {

   // String[] Semanas = { "1", "2", "3", "4", "5", "6", "7", "8"};
    EditText semana, dia, turno, descripcion;
    Button btnAceptarDia, btnFinalizar;
    DBTheLabIT DB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_planes_detalle);

        semana       = (EditText) findViewById(R.id.semana);
        dia       = (EditText) findViewById(R.id.dia);
        turno       = (EditText) findViewById(R.id.turno);
        descripcion       = (EditText) findViewById(R.id.descripcion);
        btnAceptarDia   = (Button) findViewById(R.id.btnAceptarDia);
        btnFinalizar   = (Button) findViewById(R.id.btnFinalizar);
        DB = new DBTheLabIT(this);
        Bundle b = getIntent().getExtras();
        Integer idPlan = Integer.parseInt(b.getString("idPlan"));
        String logueado = b.getString("logueado");
        Toast.makeText(ViewPlanesDetalle.this, logueado, Toast.LENGTH_SHORT).show();
        btnAceptarDia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Toast.makeText(MainActivity.this, "error", Toast.LENGTH_SHORT).show();
                Actividad actividad = new Actividad(
                        1
                        , semana.getText().toString()
                        , dia.getText().toString()
                        , turno.getText().toString()
                        , descripcion.getText().toString());

                Boolean resultado = DB.insertActividad(actividad);

                if (resultado){
                    String mensaje = "Actividad de la semana " + semana.getText().toString() + ", dia "
                            + dia.getText().toString() + "cargada OK";
                    Toast.makeText(ViewPlanesDetalle.this, mensaje, Toast.LENGTH_SHORT).show();

                    semana.getText().clear();
                    dia.getText().clear();
                    turno.getText().clear();
                    descripcion.getText().clear();
                }


            }
        });

        btnFinalizar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Boolean resultado = DB.insertDetallePlan(logueado, null, idPlan);

                if (resultado){
                    Toast.makeText(ViewPlanesDetalle.this, "plan dado de alta", Toast.LENGTH_SHORT).show();

                }


            }
        });
    }
}