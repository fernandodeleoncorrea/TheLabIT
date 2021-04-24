package com.example.thelabit.vista.entrenador;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.thelabit.R;
import com.example.thelabit.modelo.DBTheLabIT;
import com.example.thelabit.vista.ViewDetalleActividad;
import com.example.thelabit.vista.corredor.CorredorPlanTotal;
import com.example.thelabit.vista.corredor.ViewEditarPerfilCorredor;

import java.util.ArrayList;

public class ViewCorredorEntrenador extends AppCompatActivity {

    DBTheLabIT DB;
    ListView actividadesrecientes;
    ArrayList<String> listitem = new ArrayList<String>();
    ArrayList<String> listitemID = new ArrayList<String>();
    ArrayAdapter adapter;
    Button btnHistorico, btnPerfil;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_corredor_entrenador);

        actividadesrecientes = findViewById(R.id.actividadesrecientes);
        btnHistorico = findViewById(R.id.btnHistorico);
        btnPerfil = findViewById(R.id.btnPerfil);
        TextView titulocorredor_entrenador = (TextView) findViewById(R.id.titulocorredor_entrenador);
        TextView tituloLista = (TextView) findViewById(R.id.tituloLista);


        Bundle b = getIntent().getExtras();
        String idCorredor = b.getString("idCorredor");
        String nombreCorredor = b.getString("nombreCorredor");
        String logueado = b.getString("logueado");

        titulocorredor_entrenador.setText("Alumno : " + nombreCorredor);

        //tituloLista.setText("Lista de Actividades Pendientes");
        //tituloLista.setTextSize(20);
        //actividadesrecientes.addHeaderView(tituloLista);

        viewActividadesRecientes();
      //  Toast.makeText(ViewCorredorEntrenador.this, nombreCorredor, Toast.LENGTH_SHORT).show();

        actividadesrecientes.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView <? > arg0, View view, int position, long id) {

                String idActividad = listitemID.get(position);

                Intent intent = new Intent(ViewCorredorEntrenador.this, ViewDetalleActividad.class);
                Bundle b = new Bundle();
                b.putString("idActividad", idActividad);
                b.putString("logueado", logueado);
                intent.putExtras(b);
                startActivity(intent);

             //   Toast.makeText(ViewCorredorEntrenador.this, nombreCorredor, Toast.LENGTH_SHORT).show();
            }
        });

        btnHistorico.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(ViewCorredorEntrenador.this, CorredorPlanTotal.class);
                Bundle b = new Bundle();
                //b.putString("logueado", logueado);
                b.putString("logueado", idCorredor);
                intent.putExtras(b);
                startActivity(intent);
            }
        });

        btnPerfil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(ViewCorredorEntrenador.this, ViewEditarPerfilCorredor.class);
                Bundle b = new Bundle();
                b.putString("tipo", "E");
                b.putString("logueado", idCorredor);
                intent.putExtras(b);
                startActivity(intent);
            }
        });

    }

    private void viewActividadesRecientes(){
        Bundle b = getIntent().getExtras();
        String idCorredor = b.getString("idCorredor");
        String nombreCorredor = b.getString("nombreCorredor");
        String logueado = b.getString("logueado");

        DB = new DBTheLabIT(this);
        Cursor c = DB.obtenerActividadesRecientes(idCorredor);

        while (c.moveToNext()) {
            String pIdActividad = c.getString(c.getColumnIndex("ID"));
            String psemana = c.getString(c.getColumnIndex("SEMANA"));
            String pdia = c.getString(c.getColumnIndex("DIA"));
            String pturno = c.getString(c.getColumnIndex("TURNO"));
            String pdescripcion = c.getString(c.getColumnIndex("DESCRIPCION"));

            listitem.add(pdescripcion);
            listitemID.add(pIdActividad);
        }


        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, listitem);
        actividadesrecientes.setAdapter(adapter);

    }
}