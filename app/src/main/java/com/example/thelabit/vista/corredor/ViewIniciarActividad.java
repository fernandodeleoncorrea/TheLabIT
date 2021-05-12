package com.example.thelabit.vista.corredor;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.Toast;

import com.example.thelabit.vista.corredor.GpsTrackerCorredor;
import com.example.thelabit.R;
import com.example.thelabit.modelo.DBTheLabIT;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class ViewIniciarActividad extends AppCompatActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    private GpsTrackerCorredor gpsTracker;
    protected SupportMapFragment mapFragment;
    Button btnIniciar, btnFinalizar;
    Boolean start = false;
    DBTheLabIT DB;
    private long lastPause;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_iniciar_actividad);

        mapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.mapView);
        mapFragment.getMapAsync(this);


        btnIniciar    = (Button) findViewById(R.id.btnIniciar);
        btnFinalizar    = (Button) findViewById(R.id.btnFinalizar);
        Chronometer tiempo = (Chronometer) findViewById(R.id.txtReloj);
        tiempo.setBase(SystemClock.elapsedRealtime());//stop();
        tiempo.start();
        lastPause = SystemClock.elapsedRealtime();
        tiempo.stop();
        tiempo.setTextSize(20);

        Bundle b = getIntent().getExtras();
        String idActividad = b.getString("idActividad");
        String logueado = b.getString("logueado");
        String nombreUsuario = b.getString("nombreUsuario");
        Boolean completada = b.getBoolean("completada");


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
                   b.putString("logueado", logueado);
                   b.putString("nombreUsuario", nombreUsuario);
                   intent.putExtras(b);
                   startActivity(intent);
                   finish();

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

        mapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.mapView);
        mapFragment.getMapAsync(this);

        double latitude = -34.90022215086249;
        double longitude = -56.147232183794614;

        try {
            if (ContextCompat.checkSelfPermission(getApplicationContext(), android.Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED ) {
                ActivityCompat.requestPermissions(this, new String[]{android.Manifest.permission.ACCESS_FINE_LOCATION}, 101);
            }
        } catch (Exception e){
            e.printStackTrace();
        }


        gpsTracker = new GpsTrackerCorredor(ViewIniciarActividad.this);
        if(gpsTracker.canGetLocation()){
            //latitude = gpsTracker.getLatitude();
            //longitude = gpsTracker.getLongitude();
            String lat = String.valueOf(latitude);
            String lon = String.valueOf(longitude);

        }else{
            gpsTracker.showSettingsAlert();
        }

        mMap = googleMap;

        mMap.addMarker(new MarkerOptions().position(new LatLng(latitude, longitude)));
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(latitude, longitude), 15));

    }


}

