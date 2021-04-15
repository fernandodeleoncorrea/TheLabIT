package com.example.thelabit.vista;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.example.thelabit.R;
import com.example.thelabit.modelo.DBTheLabIT;

import java.util.ArrayList;

public class ViewCorredorEntrenador extends AppCompatActivity {

    DBTheLabIT DB;
    ListView actividadesrecientes;
    ArrayList<String> listitem = new ArrayList<String>();
    ArrayAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_corredor_entrenador);

        actividadesrecientes = findViewById(R.id.actividadesrecientes);
        Bundle b = getIntent().getExtras();
        String nombreCorredor = b.getString("nombreCorredor");
        String logueado = b.getString("logueado");

        viewActividadesRecientes();
        Toast.makeText(ViewCorredorEntrenador.this, nombreCorredor, Toast.LENGTH_SHORT).show();

        actividadesrecientes.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView <? > arg0, View view, int position, long id) {

                String nombreActividad =(String)arg0.getItemAtPosition(position);

                Intent intent = new Intent(ViewCorredorEntrenador.this, ViewDetalleActividad.class);
                Bundle b = new Bundle();
                b.putString("NombreActividad", nombreActividad);
                b.putString("logueado", logueado);
                intent.putExtras(b);
                startActivity(intent);

                Toast.makeText(ViewCorredorEntrenador.this, nombreCorredor, Toast.LENGTH_SHORT).show();
            }
        });

    }

    private void viewActividadesRecientes(){
        Bundle b = getIntent().getExtras();
        String logueado = b.getString("logueado");
        String nombreCorredor = b.getString("nombreCorredor"); //Your id

        DB = new DBTheLabIT(this);
        Cursor c = DB.obtenerActividadesRecientes(nombreCorredor);

        while (c.moveToNext()) {
            String psemana = c.getString(c.getColumnIndex("SEMANA"));
            String pdia = c.getString(c.getColumnIndex("DIA"));
            String pturno = c.getString(c.getColumnIndex("TURNO"));
            String pdescripcion = c.getString(c.getColumnIndex("DESCRIPCION"));

            listitem.add(psemana+pdia+pturno+pdescripcion);
        }


        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, listitem);
        actividadesrecientes.setAdapter(adapter);

    }
}