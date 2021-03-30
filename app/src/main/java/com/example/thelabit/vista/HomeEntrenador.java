package com.example.thelabit.vista;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_entrenador);

        corredores = findViewById(R.id.listacorredores);

        viewdata();
    /*
        corredores.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView adapterView, View viewm, int i,  long l) {
                String text  = corredores.getItemAtPosition(i).toString();
                Toast.makeText(HomeEntrenador.this, "bieeen", Toast.LENGTH_SHORT).show();
            }});*/
    }

    private void viewdata(){
        DB = new DBTheLabIT(this);
        Cursor c = DB.obtenerCorredores("Fernando");

        //String algo = c.getString(c.getColumnIndex("USERNAME"));
        if (c.moveToFirst()) {
            c.getInt(c.getColumnIndex("USERNAME"));

            while (c.moveToNext()) {
                Integer algo = c.getInt(c.getColumnIndex("USERNAME"));
                listitem.add(algo.toString());
            }
        }


        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, listitem);
        corredores.setAdapter(adapter);

    }
}