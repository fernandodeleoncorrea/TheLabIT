package com.example.thelabit;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;

import com.example.thelabit.modelo.DBTheLabIT;

public class ViewContactarCorredor extends AppCompatActivity {

    EditText nombre, fechaNacimiento, ciudad, pais, comentario, peso, genero, altura, fcreposo, fcmaxima, objetivo, tiempo, entrenador;
    Button btnContactar;
    DBTheLabIT DB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_contactar_corredor);

        this.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);
        btnContactar   = (Button) findViewById(R.id.btnContactar);
        nombre = (EditText)findViewById(R.id.nombre);
        ciudad = (EditText)findViewById(R.id.ciudad);
        pais = (EditText)findViewById(R.id.pais);
        comentario = (EditText)findViewById(R.id.comentario);
        fechaNacimiento = (EditText)findViewById(R.id.fechaNacimiento);
        peso = (EditText)findViewById(R.id.peso);
        genero = (EditText)findViewById(R.id.genero);
        altura = (EditText)findViewById(R.id.altura);
        fcreposo = (EditText)findViewById(R.id.fcreposo);
        fcmaxima = (EditText)findViewById(R.id.fcmaxima);
        objetivo = (EditText)findViewById(R.id.objetivo);
        tiempo = (EditText)findViewById(R.id.tiempo);
        entrenador = (EditText)findViewById(R.id.entrenador);

        Bundle b = getIntent().getExtras();
        String logueado = b.getString("logueado");
        String idCorredor = b.getString("idCorredor");
        String nombreUsuario = b.getString("nombreUsuario");
        DB = new DBTheLabIT(this);
        Cursor c = DB.obtenerDatosBusquedaCorr(idCorredor);

        while (c.moveToNext()) {
            nombre.setText(c.getString(c.getColumnIndex("NOMBRE")));
            fechaNacimiento.setText(c.getString(c.getColumnIndex("T1.FECHANACIMIENTO")));
            ciudad.setText(c.getString(c.getColumnIndex("CIUDAD")));
            pais.setText(c.getString(c.getColumnIndex("PAIS")));
            comentario.setText(c.getString(c.getColumnIndex("COMENTARIO")));
            peso.setText(c.getString(c.getColumnIndex("PESO")));
            genero.setText(c.getString(c.getColumnIndex("GENERO")));
            altura.setText(c.getString(c.getColumnIndex("ALTURA")));
            fcreposo.setText(c.getString(c.getColumnIndex("FCREPOSO")));
            fcmaxima.setText(c.getString(c.getColumnIndex("FCMAXIMA")));
            objetivo.setText(c.getString(c.getColumnIndex("OBJETIVO")));
            tiempo.setText(c.getString(c.getColumnIndex("TIEMPOESTIMADO")));
            entrenador.setText(c.getString(c.getColumnIndex("ENTRENADOR_ACTUAL")));
        }
    }
}