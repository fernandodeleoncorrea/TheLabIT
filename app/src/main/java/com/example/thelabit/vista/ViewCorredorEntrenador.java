package com.example.thelabit.vista;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Toast;

import com.example.thelabit.R;

public class ViewCorredorEntrenador extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_corredor_entrenador);

        Bundle b = getIntent().getExtras();
        String nombreCorredor = b.getString("nombreCorredor");

        Toast.makeText(ViewCorredorEntrenador.this, nombreCorredor, Toast.LENGTH_SHORT).show();
    }
}