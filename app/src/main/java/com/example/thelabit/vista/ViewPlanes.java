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
import com.example.thelabit.modelo.PlanEntrenamiento;

public class ViewPlanes extends AppCompatActivity {

    Button btnModificar, btnEliminar;
    DBTheLabIT DB;
    EditText idPlan, nombrePlan, distanciaPlan, objetivoPlan, comentarioPlan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_planes);

        idPlan    = (EditText) findViewById(R.id.idPlan);
        nombrePlan    = (EditText) findViewById(R.id.nombrePlan);
        distanciaPlan    = (EditText) findViewById(R.id.distanciaPlan);
        objetivoPlan    = (EditText) findViewById(R.id.objetivoPlan);
        comentarioPlan    = (EditText) findViewById(R.id.comentarioPlan);
        btnModificar    = (Button) findViewById(R.id.btnModificar);
        btnEliminar    = (Button) findViewById(R.id.btnEliminar);
        DB = new DBTheLabIT(this);

        Bundle b = getIntent().getExtras();
        String pnombrePlan = b.getString("nombrePlan");
        String logueado = b.getString("logueado");

        //PlanEntrenamiento plan = new PlanEntrenamiento();
        PlanEntrenamiento plan = DB.obtenerPlan(logueado, pnombrePlan);

        idPlan.setText(String.valueOf(plan.getId()));
        idPlan.setEnabled(false);
        nombrePlan.setText(plan.getNombre());
        distanciaPlan.setText(plan.getDistancia());
        objetivoPlan.setText(plan.getObjetivo());
        comentarioPlan.setText(plan.getComentario());

        //Toast.makeText(ViewPlanes.this, pnombrePlan, Toast.LENGTH_SHORT).show();
        //Toast.makeText(ViewPlanes.this, logueado, Toast.LENGTH_SHORT).show();

        btnModificar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PlanEntrenamiento plan2 = new PlanEntrenamiento();

                plan2.setId(Integer.parseInt(idPlan.getText().toString()));
                plan2.setNombre(nombrePlan.getText().toString());
                plan2.setDistancia(distanciaPlan.getText().toString());
                plan2.setObjetivo(objetivoPlan.getText().toString());
                plan2.setComentario(comentarioPlan.getText().toString());

                Boolean modificoOK = DB.modificarPlanCabezal(plan2);

                Intent intent = new Intent(ViewPlanes.this, ViewPlanesDetalle.class);
                Bundle b = new Bundle();
                b.putString("idPlan", idPlan.getText().toString());
                b.putString("logueado", logueado);
                intent.putExtras(b);
                startActivity(intent);
            }
        });

        btnEliminar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Integer idPlanEliminar = Integer.parseInt(idPlan.getText().toString());

                Boolean modificoOK = DB.eliminarPlan(idPlanEliminar);

                Toast.makeText(ViewPlanes.this, "plan eliminado con exito", Toast.LENGTH_SHORT).show();
            }
        });
    }

}