package com.example.thelabit.vista.corredor;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.thelabit.R;
import com.example.thelabit.modelo.DBTheLabIT;
import com.example.thelabit.vista.ViewDetalleActividad;

import java.util.ArrayList;

public class CorredorPlanTotal extends AppCompatActivity {

    TextView tituloPlanTotal;
    ArrayList<String> listitem = new ArrayList<String>();
    ArrayList<String> listitemID = new ArrayList<String>();
    ArrayList<String> listitemComp = new ArrayList<String>();
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

                String idActividad = listitemID.get(position);

                if(listitemComp.get(position).equals("SI")){
                    Intent intent = new Intent(CorredorPlanTotal.this, ViewDetalleActividad.class);
                    Bundle b = new Bundle();
                    b.putString("idActividad", idActividad); //Your id
                    intent.putExtras(b);
                    startActivity(intent);
                }else{
                    Intent intent = new Intent(CorredorPlanTotal.this, ViewDetalleActividadPend.class);
                    Bundle b = new Bundle();
                    b.putString("idActividad", idActividad); //Your id
                    b.putBoolean("completada", true);
                    intent.putExtras(b);
                    startActivity(intent);
                }


              //  Toast.makeText(CorredorPlanTotal.this, idActividad, Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void cargarActividadesTotal(){
        Bundle b = getIntent().getExtras();
        String logueado = b.getString("logueado");
        DB = new DBTheLabIT(this);
        Cursor c = DB.obtenerPlanTotal(logueado);
        String nombrePlan = DB.obtenerNombrePlan(logueado);
        tituloPlanTotal.setText(nombrePlan);

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
            listitem.add("DIA:"+ pid +" "+ pdescripcion);
            listitemID.add(String.valueOf(pid));
            listitemComp.add(pcompletadaStr);
        }

        //adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, listitem);
        //actividades.setAdapter(adapter);
        actividades.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, listitem) {
            @Override
            public View getView(int position, View convertView, ViewGroup parent) {
                View row = super.getView(position, convertView, parent);

                if(listitemComp.get(position).equals("SI"))
                {
                    row.setBackgroundColor (Color.rgb(102, 204, 102));
                }
                else
                {
                    row.setBackgroundColor (Color.WHITE); // default coloe
                }
                return row;
            }
        });

    }


}