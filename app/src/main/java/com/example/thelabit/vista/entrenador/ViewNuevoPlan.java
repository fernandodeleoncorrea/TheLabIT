package com.example.thelabit.vista.entrenador;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.thelabit.R;
import com.example.thelabit.modelo.DBTheLabIT;
import com.example.thelabit.modelo.PlanEntrenamiento;

public class ViewNuevoPlan extends AppCompatActivity {

    Button btnAceptarYContinuar;
    EditText idPlan, nombrePlan, distanciaPlan, objetivoPlan, comentarioPlan ;
    DBTheLabIT DB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_nuevo_plan);

        this.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);
        btnAceptarYContinuar    = (Button) findViewById(R.id.btnAceptarYContinuar);
        idPlan       = (EditText) findViewById(R.id.idPlan);
        nombrePlan       = (EditText) findViewById(R.id.nombrePlan);
        distanciaPlan       = (EditText) findViewById(R.id.distanciaPlan);
        objetivoPlan       = (EditText) findViewById(R.id.objetivoPlan);
        comentarioPlan       = (EditText) findViewById(R.id.comentarioPlan);
        DB = new DBTheLabIT(this);

        Bundle b = getIntent().getExtras();
        String logueado = b.getString("logueado");
        String nombreUsuario = b.getString("nombreUsuario");

     //   Toast.makeText(ViewNuevoPlan.this, logueado, Toast.LENGTH_SHORT).show();

        btnAceptarYContinuar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                PlanEntrenamiento plan = new PlanEntrenamiento(
                        Integer.parseInt(idPlan.getText().toString())
                        , nombrePlan.getText().toString()
                        , distanciaPlan.getText().toString()
                        , objetivoPlan.getText().toString()
                        , comentarioPlan.getText().toString());


                Boolean resultado = DB.insertNuevoPlan(plan, logueado);

                if (resultado){
                    Intent intent = new Intent(ViewNuevoPlan.this, ViewPlanesDetalle.class);
                    Bundle b = new Bundle();
                    b.putString("idPlan", idPlan.getText().toString());
                    b.putString("logueado", logueado);
                    b.putString("nombreUsuario", nombreUsuario);
                    intent.putExtras(b);
                    startActivity(intent);
                    finish();
                }

            }
        });
    }
}