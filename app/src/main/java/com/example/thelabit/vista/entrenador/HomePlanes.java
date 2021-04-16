package com.example.thelabit.vista.entrenador;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.example.thelabit.R;
import com.example.thelabit.modelo.DBTheLabIT;
import com.example.thelabit.modelo.Sesion;
import com.example.thelabit.vista.ViewPlanes;

import java.util.ArrayList;


public class HomePlanes extends AppCompatActivity {

    DBTheLabIT DB;
    ArrayList<String> listitem = new ArrayList<String>();
    ArrayAdapter adapter;
    ListView planes;
    Sesion sesion;
    Button btnNuevoPlan;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_planes);

        this.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);
        btnNuevoPlan    = (Button) findViewById(R.id.btnNuevoPlan);
        planes = findViewById(R.id.listaPlanes);



        Bundle b = getIntent().getExtras();
        String logueado = b.getString("logueado");
        String nombreUsuario = b.getString("nombreUsuario");
        Toast.makeText(HomePlanes.this, logueado, Toast.LENGTH_SHORT).show();
        viewPlanes();

        planes.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView <? > arg0, View view, int position, long id) {

                String nombrePlan =(String)arg0.getItemAtPosition(position);

                Intent intent = new Intent(HomePlanes.this, ViewPlanes.class);
                Bundle b = new Bundle();
                b.putString("nombrePlan", nombrePlan); //Your id
                b.putString("logueado", logueado);
                intent.putExtras(b);
                startActivity(intent);


                Toast.makeText(HomePlanes.this, nombrePlan, Toast.LENGTH_SHORT).show();
            }
        });

        btnNuevoPlan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(HomePlanes.this, ViewNuevoPlan.class);
                Bundle b = new Bundle();
                b.putString("logueado", logueado);
                b.putString("nombreUsuario", nombreUsuario);
                intent.putExtras(b);
                startActivity(intent);
                finish();
            }
        });
    }


    private void viewPlanes(){
        Bundle b = getIntent().getExtras();
        String logueado = b.getString("logueado");
        DB = new DBTheLabIT(this);
        Cursor c = DB.obtenerPlanes(logueado);

        while (c.moveToNext()) {
            String nombrePlan = c.getString(c.getColumnIndex("NOMBRE"));
            listitem.add(nombrePlan.toString());
        }

        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, listitem);
        planes.setAdapter(adapter);
    }
}