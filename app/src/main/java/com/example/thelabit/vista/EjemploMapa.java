package com.example.thelabit.vista;

import android.content.Context;
import android.graphics.Color;
import android.location.Location;
import android.os.Bundle;
import android.os.Environment;
import android.widget.Toast;

import androidx.fragment.app.FragmentActivity;

import com.example.thelabit.R;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Polyline;
import com.google.android.gms.maps.model.PolylineOptions;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

public class EjemploMapa extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;

    // below are the latitude and longitude of 4 different locations.
    //LatLng TamWorth = new LatLng(-34.8994235634112, -56.146923351021535);
    //LatLng NewCastle = new LatLng(-34.90087381940635, -56.152679284578724);
    LatLng Brisbane = new LatLng(-34.9003114782847, -56.159716319335146);
    LatLng Inicio;
    //File gpxFile = new File(Environment.getDataDirectory().toString() + "/data/com.example.thelabit/prueba.gpx");
    //List<Location> gpxList = decodeGPX(gpxFile);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ejemplo_mapa);

        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        File gpxFile = new File(Environment.getDataDirectory().toString() + "/data/com.example.thelabit/prueba.gpx");
        List<Double> gpxListele = decodeGPXele(gpxFile);

    }

    private List<LatLng> decodeGPX(File file){
        List<LatLng> list = new ArrayList<LatLng>();

        DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
        try {
            DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
            FileInputStream fileInputStream = new FileInputStream(file);
            Document document = documentBuilder.parse(fileInputStream);
            Element elementRoot = document.getDocumentElement();

            NodeList nodelist_trkpt = elementRoot.getElementsByTagName("trkpt");

            for(int i = 0; i < nodelist_trkpt.getLength(); i++){

                Node node = nodelist_trkpt.item(i);
                NamedNodeMap attributes = node.getAttributes();

                String newLatitude = attributes.getNamedItem("lat").getTextContent();
                Double newLatitude_double = Double.parseDouble(newLatitude);

                //Toast.makeText(EjemploMapa.this, newLatitude, Toast.LENGTH_SHORT).show();

                String newLongitude = attributes.getNamedItem("lon").getTextContent();
                Double newLongitude_double = Double.parseDouble(newLongitude);

                String newLocationName = newLatitude + ":" + newLongitude;
                LatLng punto = new LatLng(newLatitude_double, newLongitude_double);
                //Location newLocation = new Location(newLocationName);
                //newLocation.setLatitude(newLatitude_double);
                //newLocation.setLongitude(newLongitude_double);

                if(i==0){
                    Inicio = punto;
                }
                list.add(punto);

            }

            fileInputStream.close();

        } catch (ParserConfigurationException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (SAXException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return list;
    }


    private List<Double> decodeGPXele(File file){
        List<Double> list = new ArrayList<>();

        DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
        try {
            DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
            FileInputStream fileInputStream = new FileInputStream(file);
            Document document = documentBuilder.parse(fileInputStream);
            Element elementRoot = document.getDocumentElement();

            NodeList nodelist_ele = elementRoot.getElementsByTagName("ele");

            for(int i = 0; i < nodelist_ele.getLength(); i++){

                String valor = nodelist_ele.item(i).getChildNodes().item(0).getNodeValue();
                Double ele = Double.parseDouble(valor);

                list.add(ele);
            }
            fileInputStream.close();
        } catch (ParserConfigurationException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (SAXException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return list;
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

        File gpxFile = new File(Environment.getDataDirectory().toString() + "/data/com.example.thelabit/prueba.gpx");

        List<LatLng> gpxList = decodeGPX(gpxFile);

        mMap = googleMap;
        mMap.addPolyline(( new PolylineOptions()).addAll(gpxList).width(5).color(Color.RED).geodesic(true));

        googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(Inicio, 13));
    }




}
