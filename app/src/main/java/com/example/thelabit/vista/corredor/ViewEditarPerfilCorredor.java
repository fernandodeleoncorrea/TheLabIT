package com.example.thelabit.vista.corredor;

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

public class ViewEditarPerfilCorredor extends AppCompatActivity {

    EditText nombre, fechaNacimiento, ciudad, pais, email, comentario, peso, genero, altura, FCreposo, FCmaxima, objetivo, tiempoEstimado;
    Button btnFinalizar;
    DBTheLabIT DB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_editar_perfil_corredor);

        this.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);
        btnFinalizar   = (Button) findViewById(R.id.btnFinalizar);
        nombre = (EditText)findViewById(R.id.nombre);
        fechaNacimiento = (EditText)findViewById(R.id.fechaNacimiento);
        ciudad = (EditText)findViewById(R.id.ciudad);
        pais = (EditText)findViewById(R.id.pais);
        email = (EditText)findViewById(R.id.email);
        comentario = (EditText)findViewById(R.id.comentario);
        peso = (EditText)findViewById(R.id.peso);
        genero = (EditText)findViewById(R.id.genero);
        altura = (EditText)findViewById(R.id.altura);
        FCreposo = (EditText)findViewById(R.id.FCreposo);
        FCmaxima = (EditText)findViewById(R.id.FCmaxima);
        objetivo = (EditText)findViewById(R.id.objetivo);
        tiempoEstimado = (EditText)findViewById(R.id.tiempoEstimado);

        Bundle b = getIntent().getExtras();
        String logueado = b.getString("logueado");
        String nombreUsuario = b.getString("nombreUsuario");
        DB = new DBTheLabIT(this);
        Cursor c = DB.obtenerDatosCorredor(logueado);

        while (c.moveToNext()) {
            nombre.setText(c.getString(c.getColumnIndex("NOMBRE")));
            fechaNacimiento.setText(c.getString(c.getColumnIndex("FECHANACIMIENTO")));
            ciudad.setText(c.getString(c.getColumnIndex("CIUDAD")));
            pais.setText(c.getString(c.getColumnIndex("PAIS")));
            email.setText(c.getString(c.getColumnIndex("EMAIL")));
            comentario.setText(c.getString(c.getColumnIndex("COMENTARIO")));
            peso.setText(c.getString(c.getColumnIndex("PESO")));
            genero.setText(c.getString(c.getColumnIndex("GENERO")));
            altura.setText(c.getString(c.getColumnIndex("ALTURA")));
            FCreposo.setText(c.getString(c.getColumnIndex("FCREPOSO")));
            FCmaxima.setText(c.getString(c.getColumnIndex("FCMAXIMA")));
            objetivo.setText(c.getString(c.getColumnIndex("OBJETIVO")));
            tiempoEstimado.setText(c.getString(c.getColumnIndex("TIEMPOESTIMADO")));
        }

        btnFinalizar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Corredor corredor = new Corredor();
                corredor.setIdUsuario(logueado);
                corredor.setNombre(nombre.getText().toString());
                corredor.setFechaNacimiento(fechaNacimiento.getText().toString());
                corredor.setCiudad(ciudad.getText().toString());
                corredor.setPais(pais.getText().toString());
                corredor.setEmail(email.getText().toString());
                corredor.setComentario(comentario.getText().toString());
                corredor.setPeso(peso.getText().toString());
                corredor.setGenero(genero.getText().toString());
                corredor.setAltura(altura.getText().toString());
                corredor.setFCReposo(FCreposo.getText().toString());
                corredor.setFCMaxima(FCmaxima.getText().toString());
                corredor.setDistanciaObjetivo(objetivo.getText().toString());
                corredor.setTiempoEstimado(tiempoEstimado.getText().toString());

                Boolean guardar = false;
                guardar = DB.guardarDatosCorredor(corredor);
                if(guardar){
                    Intent intent = new Intent(ViewEditarPerfilCorredor.this, HomeCorredor.class);
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