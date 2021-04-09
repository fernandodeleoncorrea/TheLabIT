package com.example.thelabit.vista;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
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
        setContentView(R.layout.activity_view_nuevo_plan);

        btnAceptarYContinuar    = (Button) findViewById(R.id.btnAceptarYContinuar);
        idPlan       = (EditText) findViewById(R.id.idPlan);
        nombrePlan       = (EditText) findViewById(R.id.nombrePlan);
        distanciaPlan       = (EditText) findViewById(R.id.distanciaPlan);
        objetivoPlan       = (EditText) findViewById(R.id.objetivoPlan);
        comentarioPlan       = (EditText) findViewById(R.id.comentarioPlan);
        DB = new DBTheLabIT(this);
        Bundle b = getIntent().getExtras();
        String logueado = b.getString("logueado");
        Toast.makeText(ViewNuevoPlan.this, logueado, Toast.LENGTH_SHORT).show();

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
                    intent.putExtras(b);
                    startActivity(intent);
                }

            }
        });
    }
}