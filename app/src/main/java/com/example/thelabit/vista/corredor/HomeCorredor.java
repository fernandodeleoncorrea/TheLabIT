package com.example.thelabit.vista.corredor;

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
import com.example.thelabit.modelo.DBTheLabIT;

import java.util.ArrayList;

public class HomeCorredor extends AppCompatActivity {
    
    TextView tituloCorredor;
    Button btnDetallePlan, btnEditarCorredor, btnBuscarEntrenador;
    ArrayList<String> listitem = new ArrayList<String>();
    ArrayList<String> listitemID = new ArrayList<String>();
    ArrayAdapter adapter, adapterID;
    ListView actividades, actividadesID;
    DBTheLabIT DB;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_corredor);

        this.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);
        
        btnDetallePlan   = (Button) findViewById(R.id.btnDetallePlan);
        btnBuscarEntrenador   = (Button) findViewById(R.id.btnBuscarEntrenador);
        btnEditarCorredor   = (Button) findViewById(R.id.btnEditarCorredor);
        actividades = findViewById(R.id.listaActividades);
        tituloCorredor = (TextView)findViewById(R.id.tituloCorredor);

        Bundle b = getIntent().getExtras();
        String logueado = b.getString("logueado");
        String nombreUsuario = b.getString("nombreUsuario");
        String Titulo = "Home Corredor : " + nombreUsuario;
        TextView textView = new TextView(this);
        textView.setText("Lista Actividades Pendientes");
        textView.setTextSize(20);
        tituloCorredor.setText(Titulo.toString());
        tituloCorredor.setTextSize(20);
        actividades.addHeaderView(textView);

        //String logueado = sharedpreferences.getString(USERNAME_KEY, null);
        Toast.makeText(HomeCorredor.this, logueado, Toast.LENGTH_SHORT).show();
        
        viewActividades();

        btnDetallePlan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(HomeCorredor.this, CorredorPlanTotal.class);
                Bundle b = new Bundle();
                b.putString("logueado", logueado);
                b.putString("nombreUsuario", nombreUsuario);
                intent.putExtras(b);
                startActivity(intent);
            }
        });

        btnBuscarEntrenador.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(HomeCorredor.this, ViewListarEntrenadores.class);
                Bundle b = new Bundle();
                b.putString("logueado", logueado);
                b.putString("nombreUsuario", nombreUsuario);
                intent.putExtras(b);
                startActivity(intent);
            }
        });

        btnEditarCorredor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(HomeCorredor.this, ViewEditarPerfilCorredor.class);
                Bundle b = new Bundle();
                b.putString("logueado", logueado);
                b.putString("tipo", "C");
                b.putString("nombreUsuario", nombreUsuario);
                intent.putExtras(b);
                startActivity(intent);
            }
        });

        actividades.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView <? > arg0, View view, int position, long id) {

                String idActividad = listitemID.get(position-1);

                Intent intent  = new Intent(HomeCorredor.this, ViewDetalleActividadPend.class);
                Bundle b = new Bundle();
                b.putString("idActividad", idActividad);
                b.putString("logueado", logueado);
                b.putBoolean("completada", true);
                b.putString("nombreUsuario", nombreUsuario);
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
            Integer pid = c.getInt(c.getColumnIndex("ID"));
            String psemana = c.getString(c.getColumnIndex("SEMANA"));
            String pdia = c.getString(c.getColumnIndex("DIA"));
            String pturno = c.getString(c.getColumnIndex("TURNO"));
            String pdescripcion = c.getString(c.getColumnIndex("DESCRIPCION"));
            listitem.add(pid+pdescripcion);
            listitemID.add(String.valueOf(pid));
        }

        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, listitem);
        actividades.setAdapter(adapter);

    }
}