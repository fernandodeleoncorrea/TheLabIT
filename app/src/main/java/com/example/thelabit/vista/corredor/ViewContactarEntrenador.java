package com.example.thelabit.vista.corredor;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;

import com.example.thelabit.R;
import com.example.thelabit.modelo.DBTheLabIT;

public class ViewContactarEntrenador extends AppCompatActivity {

    EditText nombre, ciudad, pais, comentario, formacion, cantidadAlumnos;
    Button btnContactar;
    DBTheLabIT DB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_contactar_entrenador);

        this.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);
        btnContactar   = (Button) findViewById(R.id.btnContactar);
        nombre = (EditText)findViewById(R.id.nombre);
        ciudad = (EditText)findViewById(R.id.ciudad);
        pais = (EditText)findViewById(R.id.pais);
        comentario = (EditText)findViewById(R.id.comentario);
        formacion = (EditText)findViewById(R.id.formacion);
        cantidadAlumnos = (EditText)findViewById(R.id.cantidadAlumnos);

        Bundle b = getIntent().getExtras();
        String logueado = b.getString("logueado");
        String idEntrenador = b.getString("idEntrenador");
        String nombreUsuario = b.getString("nombreUsuario");
        DB = new DBTheLabIT(this);
        Cursor c = DB.obtenerDatosBusquedaEnt(idEntrenador);

        while (c.moveToNext()) {
            nombre.setText(c.getString(c.getColumnIndex("NOMBRE")));
            ciudad.setText(c.getString(c.getColumnIndex("CIUDAD")));
            pais.setText(c.getString(c.getColumnIndex("PAIS")));
            comentario.setText(c.getString(c.getColumnIndex("COMENTARIO")));
            formacion.setText(c.getString(c.getColumnIndex("FORMACION")));
            cantidadAlumnos.setText(c.getString(c.getColumnIndex("CANTIDAD")));
        }

        //b.putString("nombreUsuario", nombreUsuario);
    }
}