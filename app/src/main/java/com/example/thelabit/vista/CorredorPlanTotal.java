package com.example.thelabit.vista;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.thelabit.R;
import com.example.thelabit.modelo.DBTheLabIT;

import java.util.ArrayList;

public class CorredorPlanTotal extends AppCompatActivity {

    TextView tituloPlanTotal;
    ArrayList<String> listitem = new ArrayList<String>();
    ArrayAdapter adapter;
    ListView actividades;
    DBTheLabIT DB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_corredor_plan_total);

        this.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);

        actividades = findViewById(R.id.listaActividadesTotal);
        tituloPlanTotal = (TextView)findViewById(R.id.tituloPlanTotal);

        cargarActividadesTotal();

        actividades.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView <? > arg0, View view, int position, long id) {

                String nombreCorredor =(String)arg0.getItemAtPosition(position);

                Intent intent = new Intent(CorredorPlanTotal.this, ViewDetalleActividadPend.class);
                /*Bundle b = new Bundle();
                b.putString("nombreCorredor", nombreCorredor); //Your id
                b.putString("logueado", logueado);
                intent.putExtras(b);*/
                startActivity(intent);


                Toast.makeText(CorredorPlanTotal.this, "click", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void cargarActividadesTotal(){
        Bundle b = getIntent().getExtras();
        String logueado = b.getString("logueado");
        DB = new DBTheLabIT(this);
        Cursor c = DB.obtenerPlanTotal(logueado);

        while (c.moveToNext()) {
            Integer pid = c.getInt(c.getColumnIndex("ID"));
            String psemana = c.getString(c.getColumnIndex("SEMANA"));
            String pdia = c.getString(c.getColumnIndex("DIA"));
            String pturno = c.getString(c.getColumnIndex("TURNO"));
            String pdescripcion = c.getString(c.getColumnIndex("DESCRIPCION"));
            Integer pcompletada = c.getInt(c.getColumnIndex("COMPLETADA"));
            String pcompletadaStr;
            if(pcompletada == 0){
                pcompletadaStr = "NO";
            }else{
                pcompletadaStr = "SI";
            }
            listitem.add("DIA:"+ pdia +" "+ pdescripcion +" COMP:" +pcompletadaStr);
        }

        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, listitem);
        actividades.setAdapter(adapter);
    }
}