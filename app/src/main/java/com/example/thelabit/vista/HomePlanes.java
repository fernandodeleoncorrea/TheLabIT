package com.example.thelabit.vista;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.example.thelabit.R;
import com.example.thelabit.modelo.DBTheLabIT;
import com.example.thelabit.modelo.Sesion;

import java.util.ArrayList;


public class HomePlanes extends AppCompatActivity {

    DBTheLabIT DB;
    ArrayList<String> listitem = new ArrayList<String>();
    ArrayAdapter adapter;
    ListView planes;
    Sesion sesion;

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
        setContentView(R.layout.activity_home_planes);

        planes = findViewById(R.id.listaPlanes);
        sharedpreferences = getSharedPreferences(SHARED_PREFS, Context.MODE_PRIVATE);

        String logueado = sharedpreferences.getString(USERNAME_KEY, null);
        Toast.makeText(HomePlanes.this, logueado, Toast.LENGTH_SHORT).show();
        viewPlanes();
        //sesion.getusername();
    }

    private void viewPlanes(){
        DB = new DBTheLabIT(this);
        Cursor c = DB.obtenerPlanes("4");

        while (c.moveToNext()) {
            String nombrePlan = c.getString(c.getColumnIndex("NOMBRE"));
            listitem.add(nombrePlan.toString());
        }

        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, listitem);
        planes.setAdapter(adapter);

    }
}