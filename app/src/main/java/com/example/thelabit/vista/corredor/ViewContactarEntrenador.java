package com.example.thelabit.vista.corredor;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.thelabit.R;
import com.example.thelabit.modelo.DBTheLabIT;
import com.example.thelabit.vista.entrenador.HomeEntrenador;
import com.example.thelabit.vista.entrenador.ViewContactarCorredor;

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
        String entrenador = DB.obtenerEntrenadorActual(logueado);

        while (c.moveToNext()) {
            nombre.setText(c.getString(c.getColumnIndex("NOMBRE")));
            ciudad.setText(c.getString(c.getColumnIndex("CIUDAD")));
            pais.setText(c.getString(c.getColumnIndex("PAIS")));
            comentario.setText(c.getString(c.getColumnIndex("COMENTARIO")));
            formacion.setText(c.getString(c.getColumnIndex("FORMACION")));
            cantidadAlumnos.setText(c.getString(c.getColumnIndex("CANTIDAD")));
        }

        nombre.setEnabled(false);
        ciudad.setEnabled(false);
        pais.setEnabled(false);
        comentario.setEnabled(false);
        formacion.setEnabled(false);
        cantidadAlumnos.setEnabled(false);

        if(idEntrenador.equals(entrenador)){
            btnContactar.setEnabled(false);
        }

        btnContactar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String mensaje = "El entrenador recibirá una notificación";
                Toast.makeText(ViewContactarEntrenador.this, mensaje, Toast.LENGTH_LONG).show();

                Intent intent = new Intent(ViewContactarEntrenador.this, HomeCorredor.class);
                Bundle b = new Bundle();
                b.putString("logueado", logueado);
                b.putString("nombreUsuario", nombreUsuario);
                intent.putExtras(b);
                startActivity(intent);
            }
        });
    }
}