 package com.example.thelabit.vista;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.Toast;

import com.example.thelabit.MainActivity;
import com.example.thelabit.R;
import com.example.thelabit.ViewIniciarActividad;
import com.example.thelabit.modelo.Actividad;
import com.example.thelabit.modelo.DBTheLabIT;

public class ViewDetalleActividadPend extends AppCompatActivity {

    Button btnFeedBack, btnIniciar, btnCargarArchivo;
    DBTheLabIT DB;
    TextView semana, dia, turno, descripcion;
    Boolean completada = true;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_detalle_actividad_pend);

        btnFeedBack   = (Button) findViewById(R.id.btnFeedback);
        btnIniciar   = (Button) findViewById(R.id.btnIniciar);
        btnCargarArchivo   = (Button) findViewById(R.id.btnCargarArchivo);
        semana = (TextView)findViewById(R.id.semana);
        dia = (TextView)findViewById(R.id.dia);
        turno = (TextView)findViewById(R.id.turno);
        descripcion = (TextView)findViewById(R.id.descripcion);

        Bundle b = getIntent().getExtras();
        String idActividad = b.getString("idActividad");
        String logueado = b.getString("logueado");
        completada = b.getBoolean("completada");

        btnIniciar.setEnabled(completada);
        btnCargarArchivo.setEnabled(completada);

        DB = new DBTheLabIT(this);
        Actividad actividad = new Actividad();
        actividad = DB.obtenerActividad(Integer.parseInt(idActividad));

        semana.setText("Semana : " + actividad.getSemana());
        dia.setText("Dia : " + actividad.getDia());
        turno.setText("Turno : " + actividad.getTurno());
        descripcion.setText("Detalle : " + actividad.getDescripcion());

        Toast.makeText(ViewDetalleActividadPend.this, "llegue", Toast.LENGTH_SHORT).show();


        btnIniciar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ViewDetalleActividadPend.this, ViewIniciarActividad.class);
                Bundle b = new Bundle();
                b.putString("logueado", logueado);
                b.putString("idActividad", idActividad);
                b.putBoolean("completada", true);
                intent.putExtras(b);
                startActivity(intent);
            }});

        btnFeedBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                LayoutInflater inflater = (LayoutInflater)
                        getSystemService(LAYOUT_INFLATER_SERVICE);
                View popupView = inflater.inflate(R.layout.activity_feedback, null);

                // create the popup window
                int width = LinearLayout.LayoutParams.WRAP_CONTENT;
                int height = LinearLayout.LayoutParams.WRAP_CONTENT;
                boolean focusable = true; // lets taps outside the popup also dismiss it
                final PopupWindow popupWindow = new PopupWindow(popupView, width, height, focusable);

                popupWindow.showAtLocation(v, Gravity.CENTER, 0, 0);


            }
        });



    }
}