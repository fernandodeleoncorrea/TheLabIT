package com.example.thelabit;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Environment;
import android.view.View;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.EditText;
import android.widget.Toast;

import com.example.thelabit.modelo.DBTheLabIT;
import com.example.thelabit.vista.HomeCorredor;
import com.example.thelabit.vista.RegistrarUsuario;
import com.example.thelabit.vista.ViewDetalleActividadPend;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.PolylineOptions;

import java.io.File;
import java.util.List;

public class ViewIniciarActividad extends AppCompatActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    Button btnIniciar, btnFinalizar;
    Boolean start = false;
    DBTheLabIT DB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_iniciar_actividad);
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.mapView);
        mapFragment.getMapAsync(this);
        btnIniciar    = (Button) findViewById(R.id.btnIniciar);
        btnFinalizar    = (Button) findViewById(R.id.btnFinalizar);
        Chronometer tiempo = (Chronometer) findViewById(R.id.txtReloj);
        tiempo.setTextSize(20);

        Bundle b = getIntent().getExtras();
        String idActividad = b.getString("idActividad");


        btnIniciar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (start){
                    tiempo.stop();
                    btnIniciar.setText("Reanudar");
                    start = false;
                }else{
                    tiempo.start();
                    start = true;
                    btnIniciar.setText("Pausa");
                }
                Toast.makeText(ViewIniciarActividad.this, "error", Toast.LENGTH_SHORT).show();
            }
        });

        btnFinalizar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               Boolean resultado = marcarActividad(idActividad);

               if(resultado) {
                   Intent intent = new Intent(ViewIniciarActividad.this, ViewDetalleActividadPend.class);
                   Bundle b = new Bundle();
                   b.putString("idActividad", idActividad);
                   b.putBoolean("completada", false);
                   intent.putExtras(b);
                   startActivity(intent);

               }
            }
        });

    }

    public Boolean marcarActividad(String idActividad){
        DB = new DBTheLabIT(this);
        Boolean marca = DB.marcarActividadBD(idActividad);

        return marca;
    }

    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        LatLng Inicio = new LatLng(-34.9003114782847, -56.159716319335146);

        googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(Inicio, 13));
    }


}

