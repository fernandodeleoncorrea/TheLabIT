package com.example.thelabit.vista;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.example.thelabit.MainActivity;
import com.example.thelabit.R;
import com.example.thelabit.modelo.DBTheLabIT;

import java.util.ArrayList;

public class HomeEntrenador extends AppCompatActivity {

    DBTheLabIT DB;
    ArrayList<String> listitem = new ArrayList<String>();
    ArrayAdapter adapter;
    ListView corredores;
    Button btnPlanes;
    ListView listacorredores;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_entrenador);
        this.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);

        corredores = findViewById(R.id.listacorredores);
        btnPlanes   = (Button) findViewById(R.id.btnPlanes);
        listacorredores = findViewById(R.id.listacorredores);

        Bundle b = getIntent().getExtras();
        String logueado = b.getString("logueado");


        //String logueado = sharedpreferences.getString(USERNAME_KEY, null);
        Toast.makeText(HomeEntrenador.this, logueado, Toast.LENGTH_SHORT).show();
        viewCorredores();

        btnPlanes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(HomeEntrenador.this, HomePlanes.class);
                Bundle b = new Bundle();
                b.putString("logueado", logueado);
                intent.putExtras(b);
                startActivity(intent);
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