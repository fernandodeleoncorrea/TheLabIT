package com.example.thelabit.vista;

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
import android.widget.TextView;
import android.widget.Toast;

import com.example.thelabit.R;
import com.example.thelabit.ViewDetalleActividadPend;
import com.example.thelabit.modelo.DBTheLabIT;

import java.util.ArrayList;

public class HomeCorredor extends AppCompatActivity {
    
    TextView tituloCorredor;
    Button btnDetallePlan, btnEditarCorredor;
    ArrayList<String> listitem = new ArrayList<String>();
    ArrayAdapter adapter;
    Button btnPlanes;
    ListView actividades;
    ListView listaActividades;
    DBTheLabIT DB;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_corredor);

        this.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);
        
        btnDetallePlan   = (Button) findViewById(R.id.btnDetallePlan);
        listaActividades = findViewById(R.id.listaActividades);
        actividades = findViewById(R.id.listaActividades);
        tituloCorredor = (TextView)findViewById(R.id.tituloCorredor);

        Bundle b = getIntent().getExtras();
        String logueado = b.getString("logueado");
        String Titulo = "Home Corredor : " + logueado;
        TextView textView = new TextView(this);
        textView.setText("Lista Actividades Pendientes");
        tituloCorredor.setText(Titulo.toString());
        listaActividades.addHeaderView(textView);

        //String logueado = sharedpreferences.getString(USERNAME_KEY, null);
        Toast.makeText(HomeCorredor.this, logueado, Toast.LENGTH_SHORT).show();
        
        viewActividades();

        btnDetallePlan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(HomeCorredor.this, HomePlanes.class);
                Bundle b = new Bundle();
                b.putString("logueado", logueado);
                intent.putExtras(b);
                startActivity(intent);
            }
        });

        listaActividades.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView <? > arg0, View view, int position, long id) {

                String nombreCorredor =(String)arg0.getItemAtPosition(position);

                Intent intent = new Intent(HomeCorredor.this, ViewDetalleActividadPend.class);
                Bundle b = new Bundle();
                b.putString("nombreCorredor", nombreCorredor); //Your id
                b.putString("logueado", logueado);
                intent.putExtras(b);
                startActivity(intent);


                Toast.makeText(HomeCorredor.this, "click", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void viewActividades(){
        Bundle b = getIntent().getExtras();
        String logueado = b.getString("logueado");
        DB = new DBTheLabIT(this);
        Cursor c = DB.obtenerActividadesPendientes(logueado);

        while (c.moveToNext()) {
            String psemana = c.getString(c.getColumnIndex("SEMANA"));
            String pdia = c.getString(c.getColumnIndex("DIA"));
            String pturno = c.getString(c.getColumnIndex("TURNO"));
            String pdescripcion = c.getString(c.getColumnIndex("DESCRIPCION"));
            listitem.add(psemana+pdia+pturno+pdescripcion);
        }


        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, listitem);
        //adapter = new ArrayAdapter<>(this, android.R.layout.activity_list_item, listitem);
        actividades.setAdapter(adapter);

    }
}