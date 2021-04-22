package com.example.thelabit.vista.entrenador;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;

import com.example.thelabit.R;
import com.example.thelabit.modelo.Corredor;
import com.example.thelabit.modelo.DBTheLabIT;
import com.example.thelabit.modelo.Entrenador;
import com.example.thelabit.vista.corredor.HomeCorredor;
import com.example.thelabit.vista.corredor.ViewEditarPerfilCorredor;

public class ViewEditarPerfilEntrenador extends AppCompatActivity {

    EditText nombre, fechaNacimiento, ciudad, pais, email, comentario, formacion;
    Button btnFinalizar;
    DBTheLabIT DB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_editar_perfil_entrenador);

        this.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);
        btnFinalizar   = (Button) findViewById(R.id.btnFinalizar);
        nombre = (EditText)findViewById(R.id.nombre);
        fechaNacimiento = (EditText)findViewById(R.id.fechaNacimiento);
        ciudad = (EditText)findViewById(R.id.ciudad);
        pais = (EditText)findViewById(R.id.pais);
        email = (EditText)findViewById(R.id.email);
        comentario = (EditText)findViewById(R.id.comentario);
        formacion = (EditText)findViewById(R.id.formacion);

        Bundle b = getIntent().getExtras();
        String logueado = b.getString("logueado");
        String nombreUsuario = b.getString("nombreUsuario");
        DB = new DBTheLabIT(this);
        Cursor c = DB.obtenerDatosEntrenador(logueado);

        while (c.moveToNext()) {
            nombre.setText(c.getString(c.getColumnIndex("NOMBRE")));
            fechaNacimiento.setText(c.getString(c.getColumnIndex("FECHANACIMIENTO")));
            ciudad.setText(c.getString(c.getColumnIndex("CIUDAD")));
            pais.setText(c.getString(c.getColumnIndex("PAIS")));
            email.setText(c.getString(c.getColumnIndex("EMAIL")));
            comentario.setText(c.getString(c.getColumnIndex("COMENTARIO")));
            formacion.setText(c.getString(c.getColumnIndex("FORMACION")));
        }

        btnFinalizar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Entrenador entrenador = new Entrenador();
                entrenador.setIdUsuario(logueado);
                entrenador.setNombre(nombre.getText().toString());
                entrenador.setFechaNacimiento(fechaNacimiento.getText().toString());
                entrenador.setCiudad(ciudad.getText().toString());
                entrenador.setPais(pais.getText().toString());
                entrenador.setEmail(email.getText().toString());
                entrenador.setComentario(comentario.getText().toString());
                entrenador.setFormacion(formacion.getText().toString());


                Boolean guardar = false;
                guardar = DB.guardarDatosEntrenador(entrenador);
                if(guardar){
                    Intent intent = new Intent(ViewEditarPerfilEntrenador.this, HomeEntrenador.class);
                    Bundle b = new Bundle();
                    b.putString("logueado", logueado);
                    b.putString("nombreUsuario", nombreUsuario);
                    intent.putExtras(b);
                    startActivity(intent);
                    finish();
                }
            }
        });
    }
}