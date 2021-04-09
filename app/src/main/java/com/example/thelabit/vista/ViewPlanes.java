package com.example.thelabit.vista;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.thelabit.R;
import com.example.thelabit.modelo.DBTheLabIT;
import com.example.thelabit.modelo.PlanEntrenamiento;

public class ViewPlanes extends AppCompatActivity {

    Button btnModificar;
    DBTheLabIT DB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_planes);

        btnModificar    = (Button) findViewById(R.id.btnModificar);
        DB = new DBTheLabIT(this);
        Bundle b = getIntent().getExtras();
        String nombrePlan = b.getString("nombrePlan");
        String logueado = b.getString("logueado");

        //PlanEntrenamiento plan = new PlanEntrenamiento();
        //Boolean algo = DB.obtenerPlan("1", "nombrePlan");

        //String objetivo = plan.getObjetivo();
        Toast.makeText(ViewPlanes.this, nombrePlan, Toast.LENGTH_SHORT).show();
        Toast.makeText(ViewPlanes.this, logueado, Toast.LENGTH_SHORT).show();

        btnModificar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Toast.makeText(MainActivity.this, "error", Toast.LENGTH_SHORT).show();
                Boolean algo = DB.obtenerPlan("a", "b");
                Intent intent = new Intent(getApplicationContext(), ViewPlanesDetalle.class);
                startActivity(intent);
            }
        });
    }

}