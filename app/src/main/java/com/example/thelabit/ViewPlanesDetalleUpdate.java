package com.example.thelabit;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.thelabit.modelo.Actividad;
import com.example.thelabit.modelo.DBTheLabIT;
import com.example.thelabit.modelo.PlanEntrenamiento;
import com.example.thelabit.vista.entrenador.HomePlanes;
import com.example.thelabit.vista.entrenador.ViewPlanes;

public class ViewPlanesDetalleUpdate extends AppCompatActivity {
    Button btnModificarActividad;
    EditText semana, dia, turno, descripcion;
    DBTheLabIT DB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_planes_detalle_update);

        btnModificarActividad   = (Button) findViewById(R.id.btnModificarActividad);
        semana = (EditText)findViewById(R.id.semana);
        dia = (EditText)findViewById(R.id.dia);
        turno = (EditText)findViewById(R.id.turno);
        descripcion = (EditText)findViewById(R.id.descripcion);

        Bundle b = getIntent().getExtras();
        String logueado = b.getString("logueado");
        String idActividad = b.getString("idActividad");
        String pnombrePlan = b.getString("pnombrePlan");
        DB = new DBTheLabIT(this);
        Actividad actividad = new Actividad();
        actividad = DB.obtenerActividad(Integer.parseInt(idActividad));

        semana.setText(actividad.getSemana());
        dia.setText(actividad.getDia());
        turno.setText(actividad.getTurno());
        descripcion.setText(actividad.getDescripcion());
        Integer completada = actividad.getCompletada();
        Integer idPlan = actividad.getIdPlan();

        btnModificarActividad.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Actividad actividad2 = new Actividad();

                actividad2.setId(Integer.parseInt(idActividad));
                actividad2.setSemana(semana.getText().toString());
                actividad2.setDia(dia.getText().toString());
                actividad2.setTurno(turno.getText().toString());
                actividad2.setDescripcion(descripcion.getText().toString());
                actividad2.setCompletada(completada);
                actividad2.setCompletada(idPlan);

                Boolean modificoOK = DB.updateActividad(actividad2);

                Intent intent = new Intent(ViewPlanesDetalleUpdate.this, HomePlanes.class);
                Bundle b = new Bundle();
                b.putString("idPlan", idActividad);
                b.putString("pnombrePlan", pnombrePlan);
                b.putString("logueado", logueado);
                intent.putExtras(b);
                startActivity(intent);
                finish();
            }
        });
    }
}