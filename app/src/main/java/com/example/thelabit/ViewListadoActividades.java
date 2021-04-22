package com.example.thelabit;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.thelabit.modelo.DBTheLabIT;
import com.example.thelabit.vista.entrenador.ViewPlanesDetalleUpdate;

import java.util.ArrayList;

public class ViewListadoActividades extends AppCompatActivity {

    DBTheLabIT DB;
    ArrayList<String> listitem = new ArrayList<String>();
    ArrayList<String> listitemID = new ArrayList<String>();
    ArrayAdapter adapter;
    ListView planes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_listado_actividades);

        planes = findViewById(R.id.listadoActividades);
;
        Bundle b = getIntent().getExtras();
        String idPlan = b.getString("idPlan");
        String logueado = b.getString("logueado");
        String pnombrePlan = b.getString("pnombrePlan");

        viewPlanes();

        planes.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView <? > arg0, View view, int position, long id) {

                String idActividad = listitemID.get(position);

                Intent intent = new Intent(ViewListadoActividades.this, ViewPlanesDetalleUpdate.class);
                Bundle b = new Bundle();
                b.putString("idActividad", idActividad); //Your id
                b.putString("pnombrePlan", pnombrePlan);
                b.putString("logueado", logueado);
                intent.putExtras(b);
                startActivity(intent);
                finish();
            }
        });
    }

    private void viewPlanes(){
        Bundle b = getIntent().getExtras();
        String idPlan = b.getString("idPlan");
        String logueado = b.getString("logueado");
        DB = new DBTheLabIT(this);
        Cursor c = DB.obtenerListadoActividades(Integer.parseInt(idPlan));

        while (c.moveToNext()) {
            String idActividad = c.getString(c.getColumnIndex("ID"));
            String diaPlan = c.getString(c.getColumnIndex("DIA"));
            String nombrePlan = c.getString(c.getColumnIndex("DESCRIPCION"));
            listitem.add("DIA: "+ diaPlan + " - " + nombrePlan.toString());
            listitemID.add(idActividad);
        }

        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, listitem);
        planes.setAdapter(adapter);
    }
}