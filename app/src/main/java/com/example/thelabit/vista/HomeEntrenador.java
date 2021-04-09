package com.example.thelabit.vista;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
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


    // creating constant keys for shared preferences.
    public static final String SHARED_PREFS = "shared_prefs";
    // key for storing email.
    public static final String USERNAME_KEY = "username_key";
    // key for storing password.
    public static final String PASSWORD_KEY = "password_key";
    // variable for shared preferences.
    SharedPreferences sharedpreferences;
    String SPusername, SPpassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_entrenador);

        corredores = findViewById(R.id.listacorredores);
        sharedpreferences = getSharedPreferences(SHARED_PREFS, Context.MODE_PRIVATE);
        btnPlanes   = (Button) findViewById(R.id.btnPlanes);

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

    }

    private void viewCorredores(){
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