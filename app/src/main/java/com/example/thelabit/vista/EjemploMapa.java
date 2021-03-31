package com.example.thelabit.vista;

import android.graphics.Color;
import android.os.Bundle;

import androidx.fragment.app.FragmentActivity;

import com.example.thelabit.R;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.PolylineOptions;

public class EjemploMapa extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;

    // below are the latitude and longitude of 4 different locations.
    LatLng TamWorth = new LatLng(-34.8994235634112, -56.146923351021535);
    LatLng NewCastle = new LatLng(-34.90087381940635, -56.152679284578724);
    LatLng Brisbane = new LatLng(-34.9003114782847, -56.159716319335146);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ejemplo_mapa);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        // inside on map ready method
        // we will be displaying polygon on Google Maps.
        // on below line we will be adding polyline on Google Maps.
        mMap.addPolyline((new PolylineOptions()).add(TamWorth, NewCastle, Brisbane, TamWorth).
                // below line is use to specify the width of poly line.
                        width(5)
                // below line is use to add color to our poly line.
                .color(Color.RED)
                // below line is to make our poly line geodesic.
                .geodesic(true));
        // on below line we will be starting the drawing of polyline.
        googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(Brisbane, 13));
    }
}
