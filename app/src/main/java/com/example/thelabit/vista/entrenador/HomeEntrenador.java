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
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.thelabit.R;
import com.example.thelabit.ViewEditarPerfilEntrenador;
import com.example.thelabit.ViewListarCorredores;
import com.example.thelabit.modelo.DBTheLabIT;
import com.example.thelabit.vista.ViewCorredorEntrenador;

import java.util.ArrayList;

public class HomeEntrenador extends AppCompatActivity {

    DBTheLabIT DB;
    ArrayList<String> listitem = new ArrayList<String>();
    ArrayAdapter adapter;
    ListView corredores;
    Button btnPlanes, btnEditarEntrenador, btnBuscarCorredor;
    ListView listacorredores;
    EditText txtTitulo;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_entrenador);
        this.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);

        corredores = findViewById(R.id.listacorredores);
        btnPlanes   = (Button) findViewById(R.id.btnPlanes);
        btnEditarEntrenador = (Button) findViewById(R.id.btnEditarEntrenador);
        btnBuscarCorredor = (Button) findViewById(R.id.btnBuscarCorredor);
        listacorredores = findViewById(R.id.listacorredores);
        txtTitulo = (EditText) findViewById(R.id.tituloEntrenador);

        Bundle b = getIntent().getExtras();
        String logueado = b.getString("logueado");
        String nombreUsuario = b.getString("nombreUsuario");
        TextView textView = new TextView(this);
        textView.setText("Lista Corredores");
        textView.setTextSize(20);
        txtTitulo.setText("Home Entrenador: " + nombreUsuario);
        listacorredores.addHeaderView(textView);

        Toast.makeText(HomeEntrenador.this, logueado, Toast.LENGTH_SHORT).show();
        viewCorredores();

        btnPlanes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(HomeEntrenador.this, HomePlanes.class);
                Bundle b = new Bundle();
                b.putString("logueado", logueado);
                b.putString("nombreUsuario", nombreUsuario);
                intent.putExtras(b);
                startActivity(intent);
            }
        });

        btnBuscarCorredor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(HomeEntrenador.this, ViewListarCorredores.class);
                Bundle b = new Bundle();
                b.putString("logueado", logueado);
                b.putString("nombreUsuario", nombreUsuario);
                intent.putExtras(b);
                startActivity(intent);
            }
        });

        btnEditarEntrenador.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(HomeEntrenador.this, ViewEditarPerfilEntrenador.class);
                Bundle b = new Bundle();
                b.putString("logueado", logueado);
                b.putString("nombreUsuario", nombreUsuario);
                intent.putExtras(b);
                startActivity(intent);
                finish();
            }
        });

        listacorredores.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView <? > arg0, View view, int position, long id) {

                String nombreCorredor =(String)arg0.getItemAtPosition(position);

                Intent intent = new Intent(HomeEntrenador.this, ViewCorredorEntrenador.class);
                Bundle b = new Bundle();
                b.putString("nombreCorredor", nombreCorredor); //Your id
                b.putString("logueado", logueado);
                intent.putExtras(b);
                startActivity(intent);

                Toast.makeText(HomeEntrenador.this, nombreCorredor, Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void viewCorredores(){
        Bundle b = getIntent().getExtras();
        String logueado = b.getString("logueado");
        DB = new DBTheLabIT(this);
        Cursor c = DB.obtenerCorredores(logueado);

        while (c.moveToNext()) {
            String nombreCorredor = c.getString(c.getColumnIndex("NOMBRE"));
            listitem.add(nombreCorredor);
        }

        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, listitem);
        corredores.setAdapter(adapter);

    }
}