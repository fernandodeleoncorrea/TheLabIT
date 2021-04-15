 package com.example.thelabit.vista.corredor;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.thelabit.R;
import com.example.thelabit.modelo.Actividad;
import com.example.thelabit.modelo.DBTheLabIT;

public class ViewDetalleActividadPend extends AppCompatActivity {

    Button btnFeedBack, btnIniciar, btnCargarArchivo, btnFinalizar;
    DBTheLabIT DB;
    TextView semana, dia, turno, descripcion;
    Boolean completada = true;
    //SeekBar seekBarFreshness, seekBarDureza, seekBarRecuperacion;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_detalle_actividad_pend);

        btnFinalizar = (Button) findViewById(R.id.btnFinalizar);
        btnFeedBack   = (Button) findViewById(R.id.btnFeedback);
        btnIniciar   = (Button) findViewById(R.id.btnIniciar);
        btnCargarArchivo   = (Button) findViewById(R.id.btnCargarArchivo);
        semana = (TextView)findViewById(R.id.semana);
        dia = (TextView)findViewById(R.id.dia);
        turno = (TextView)findViewById(R.id.turno);
        descripcion = (TextView)findViewById(R.id.descripcion);
        //seekBarFreshness = (SeekBar)findViewById(R.id.seekBarFreshness);
        //seekBarDureza = (SeekBar)findViewById(R.id.seekBarDureza);
        //seekBarRecuperacion = (SeekBar)findViewById(R.id.seekBarRecuperacion);

        Bundle b = getIntent().getExtras();
        String idActividad = b.getString("idActividad");
        String logueado = b.getString("logueado");
        String nombreUsuario = b.getString("nombreUsuario");
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
                finish();
            }});

        btnFeedBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                LayoutInflater inflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                final View layout = inflater.inflate(R.layout.activity_feedback, (ViewGroup) findViewById(R.id.PopupFeedback));

                int width = LinearLayout.LayoutParams.WRAP_CONTENT;
                int height = LinearLayout.LayoutParams.WRAP_CONTENT;
                boolean focusable = true; // lets taps outside the popup also dismiss it
                final PopupWindow pw = new PopupWindow(layout, width, height, focusable);
                //final PopupWindow popupWindow = new PopupWindow(popupView, width, height, focusable);

                //popupWindow.showAtLocation(v, Gravity.CENTER, 0, 0);
                pw.showAtLocation(v, Gravity.CENTER, 0, 0);

                Button btnEnviarFeedback = (Button) layout.findViewById(R.id.btnEnviarFeedback);
                btnEnviarFeedback.setOnClickListener(new View.OnClickListener() {

                    public void onClick(View v) {
                        SeekBar seekBarFreshness = (SeekBar) layout.findViewById(R.id.seekBarFreshness);
                        SeekBar seekBarDureza = (SeekBar) layout.findViewById(R.id.seekBarDureza);
                        SeekBar seekBarRecuperacion = (SeekBar) layout.findViewById(R.id.seekBarRecuperacion);

                        TextView txtResultadoFreshness = (TextView) layout.findViewById(R.id.txtResultadoFreshness);
                        TextView txtResultadoDureza = (TextView) layout.findViewById(R.id.txtResultadoDureza);
                        TextView txtResultadoRecupero = (TextView) layout.findViewById(R.id.txtResultadoRecupero);

                        txtResultadoFreshness.setText(String.valueOf(seekBarFreshness.getProgress()));
                        txtResultadoDureza.setText(String.valueOf(seekBarDureza.getProgress()));
                        txtResultadoRecupero.setText(String.valueOf(seekBarRecuperacion.getProgress()));

                        String freshness = txtResultadoFreshness.getText().toString();
                        String dureza = txtResultadoDureza.getText().toString();
                        String recupero = txtResultadoRecupero.getText().toString();
                        Toast.makeText(ViewDetalleActividadPend.this, freshness+dureza+recupero, Toast.LENGTH_SHORT).show();

                        pw.dismiss();
                    }
                });
/*
                LayoutInflater inflater = (LayoutInflater)
                        getSystemService(LAYOUT_INFLATER_SERVICE);
                View popupView = inflater.inflate(R.layout.activity_feedback, null);

                // create the popup window
                int width = LinearLayout.LayoutParams.WRAP_CONTENT;
                int height = LinearLayout.LayoutParams.WRAP_CONTENT;
                boolean focusable = true; // lets taps outside the popup also dismiss it
                final PopupWindow popupWindow = new PopupWindow(popupView, width, height, focusable);

                popupWindow.showAtLocation(v, Gravity.CENTER, 0, 0);
*/
            }
        });

        btnFinalizar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(ViewDetalleActividadPend.this, HomeCorredor.class);
                Bundle b = new Bundle();
                b.putString("logueado", logueado);
                b.putString("idActividad", idActividad);
                b.putBoolean("completada", true);
                b.putString("nombreUsuario", nombreUsuario);
                intent.putExtras(b);
                startActivity(intent);
                finish();
            }
        });
    }

    public Boolean marcarActividad(String idActividad){
        DB = new DBTheLabIT(this);
        Boolean marca = DB.marcarActividadBD(idActividad);

        return marca;
    }
}