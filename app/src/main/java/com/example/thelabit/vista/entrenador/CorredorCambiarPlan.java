package com.example.thelabit.vista.entrenador;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.widget.AbsListView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.example.thelabit.R;
import com.example.thelabit.modelo.DBTheLabIT;

import java.util.ArrayList;

public class CorredorCambiarPlan extends AppCompatActivity {

    TextView tituloPlan;
    ArrayList<String> listitemID = new ArrayList<String>();
    ArrayList<String> listitemNomb = new ArrayList<String>();
    ArrayAdapter adapter;
    ListView planes;
    Button btnCambiarPlan;
    DBTheLabIT DB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_corredor_cambiar_plan);

        planes = findViewById(R.id.listaTotalPlanes);
        tituloPlan = (TextView)findViewById(R.id.tituloPlan);
        btnCambiarPlan = (Button)findViewById(R.id.btnCambiarPlan);

        cargarTotalPlanes();
    }

    private void cargarTotalPlanes(){
        Bundle b = getIntent().getExtras();
        String idCorredor = b.getString("idCorredor");
        String logueado = b.getString("logueado");
        DB = new DBTheLabIT(this);

        Cursor c = DB.obtenerTotalPlanes(logueado, idCorredor);

        String nombrePlan = DB.obtenerNombrePlan(idCorredor);
        tituloPlan.setText(nombrePlan);

        while (c.moveToNext()) {
            Integer pid = c.getInt(c.getColumnIndex("ID"));
            String pnombre = c.getString(c.getColumnIndex("NOMBRE"));
            listitemID.add(String.valueOf(pid));
            listitemNomb.add(pnombre);
        }

        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_single_choice, listitemNomb);
        planes.setChoiceMode(AbsListView.CHOICE_MODE_SINGLE);
        planes.setAdapter(adapter);
    }
}