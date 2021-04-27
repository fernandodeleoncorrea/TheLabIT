package com.example.thelabit.vista.entrenador;

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

public class ViewListarCorredores extends AppCompatActivity {

    ArrayList<String> listitem = new ArrayList<String>();
    ArrayList<String> listitemID = new ArrayList<String>();
    ArrayAdapter adapter;
    ListView listaCorredores;
    DBTheLabIT DB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_listar_corredores);

        listaCorredores = findViewById(R.id.listaCorredores);

        Bundle b = getIntent().getExtras();
        String logueado = b.getString("logueado");
        String nombreUsuario = b.getString("nombreUsuario");

        viewCorredores();

        listaCorredores.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView <? > arg0, View view, int position, long id) {

                String idCorredor = listitemID.get(position);

                Intent intent  = new Intent(ViewListarCorredores.this, ViewContactarCorredor.class);
                Bundle b = new Bundle();
                b.putString("logueado", logueado);
                b.putString("idCorredor", idCorredor);
                b.putString("nombreUsuario", nombreUsuario);
                intent.putExtras(b);
                startActivity(intent);

               // Toast.makeText(ViewListarCorredores.this, "click", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void viewCorredores(){
        Bundle b = getIntent().getExtras();
        String logueado = b.getString("logueado");
        DB = new DBTheLabIT(this);
        Cursor c = DB.obtenerListaCorredores();

        while (c.moveToNext()) {
            Integer pid = c.getInt(c.getColumnIndex("USERNAME"));
            String pnombre = c.getString(c.getColumnIndex("NOMBRE"));
            listitem.add(pnombre);
            listitemID.add(String.valueOf(pid));
        }

        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, listitem);
        listaCorredores.setAdapter(adapter);

    }
}