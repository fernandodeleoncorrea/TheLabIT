package com.example.thelabit.vista;

import android.graphics.Color;
import android.os.Bundle;
import android.os.Environment;
import android.widget.TextView;
import android.widget.Toast;

import androidx.fragment.app.FragmentActivity;

import com.example.thelabit.R;
import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.charts.RadarChart;
import com.github.mikephil.charting.components.Description;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.data.RadarData;
import com.github.mikephil.charting.data.RadarDataSet;
import com.github.mikephil.charting.data.RadarEntry;
import com.github.mikephil.charting.formatter.IndexAxisValueFormatter;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
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

public class ViewDetalleActividad extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;

    LatLng Inicio;
    LineChart lineChartEle, lineChartHr, lineChartCAD;
    LineData lineDataEle, lineDataHr,  lineDataCAD;
    RadarChart aranaChart;
    RadarData aranaData;
    RadarDataSet aranaDataSet;
    ArrayList<RadarEntry> radarEntries = new ArrayList<RadarEntry>();
    ArrayList<Double> distancias = new ArrayList<Double>();
    String[] labels = {"Freshness", "Dureza", "Clima", "Intensidad", "Recuperacion"};
    Double sumaDistance = 0.0;
    Double lat1, lat2, lon1,lon2, el1, el2;
    TextView valuePulso, valueRitmo, valueTiempo, valueDistancia, valueComentario;
    String Distancia, Tiempo, Ritmo, Pulso, Comentario;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_detalle_actividad);

        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
        lineChartEle = findViewById(R.id.elevacionChart);
        lineChartHr = findViewById(R.id.pulsacionesChart);
        lineChartCAD = findViewById(R.id.cadenciaChart);
        aranaChart = findViewById(R.id.feedbackChart);

        valuePulso = findViewById(R.id.valuePulso);
        valueRitmo = findViewById(R.id.valueRitmo);
        valueTiempo = findViewById(R.id.valueTiempo);
        valueDistancia = findViewById(R.id.valueDistancia);
        valueComentario = findViewById(R.id.valueComentario);

        //textDistancia = findViewById(R.id.textDistancia);
        lat1 = 0.0;
        lat2= 0.0;
        lon1= 0.0;
        lon2= 0.0;
        el1= 0.0;
        el2= 0.0;

        Bundle b = getIntent().getExtras();
        String idActividad = b.getString("idActividad");

        File gpxFile = new File(Environment.getDataDirectory().toString() + "/data/com.example.thelabit/"+idActividad+".gpx");


        //GRAFICO DESNIVEL
        //------------------------------------------------------------------------------------------
        List<Entry> gpxListele = decodeGPXele(gpxFile);
        LineDataSet lineDataSet = new LineDataSet(gpxListele,"Elevacion");
        lineDataSet.setMode(LineDataSet.Mode.CUBIC_BEZIER);
        lineDataSet.setDrawFilled(true);
        lineDataSet.setDrawCircles(false);
        lineDataSet.setColors(Color.rgb(0, 51, 0));
        lineDataSet.setFillColor(Color.rgb(0, 128, 0));

        lineDataEle = new LineData(lineDataSet);
        lineChartEle.setData(lineDataEle);
        Description description = new Description();
        description.setText("");
        lineChartEle.setDescription(description);
        lineChartEle.getAxisRight().setEnabled(false);
        lineChartEle.invalidate();

        //GRAFICO PULSACIONES
        //------------------------------------------------------------------------------------------
        List<Entry> gpxListHR = decodeGPXhr(gpxFile);
        LineDataSet lineDataSet2 = new LineDataSet(gpxListHR,"Ritmo Cardiaco");
        lineDataSet2.setMode(LineDataSet.Mode.CUBIC_BEZIER);
        lineDataSet2.setDrawFilled(true);
        lineDataSet2.setDrawCircles(false);
        lineDataSet2.setColors(Color.rgb(153, 0, 0));
        lineDataSet2.setFillColor(Color.rgb(179, 0, 0));

        lineDataHr = new LineData(lineDataSet2);
        lineChartHr.setData(lineDataHr);
        Description description2 = new Description();
        description2.setText("");
        lineChartHr.setDescription(description2);
        lineChartHr.getAxisRight().setEnabled(false);
        lineChartHr.invalidate();

        //GRAFICO CADENCIA
        //------------------------------------------------------------------------------------------
        List<Entry> gpxListCAD = decodeGPXCAD(gpxFile);
        LineDataSet lineDataSet3 = new LineDataSet(gpxListCAD,"Cadencia");
        lineDataSet3.setMode(LineDataSet.Mode.CUBIC_BEZIER);
        lineDataSet3.setDrawFilled(true);
        lineDataSet3.setDrawCircles(false);
        lineDataSet3.setColors(Color.rgb(77, 0, 77));
        lineDataSet3.setFillColor(Color.rgb(128, 0, 128));

        lineDataCAD = new LineData(lineDataSet3);
        lineChartCAD.setData(lineDataCAD);
        Description description3 = new Description();
        description3.setText("");
        lineChartCAD.setDescription(description3);
        lineChartCAD.getAxisRight().setEnabled(false);
        lineChartCAD.invalidate();

        //GRAFICO FEEDBACK
        //------------------------------------------------------------------------------------------
        getEntries(idActividad);
        aranaDataSet = new RadarDataSet(radarEntries, "Estado General");

        aranaData = new RadarData(aranaDataSet);
        aranaChart.setData(aranaData);
        aranaChart.getDescription().setEnabled(false);
        aranaDataSet.setColor(Color.rgb(179, 89, 0));
        aranaDataSet.setDrawFilled(true);
        aranaDataSet.setDrawValues(false);
        aranaDataSet.setFillColor(Color.rgb(230, 115, 0));

        XAxis xaxis = aranaChart.getXAxis();
        xaxis.setValueFormatter(new IndexAxisValueFormatter(labels));
        xaxis.mAxisMinimum = 1;
        xaxis.mAxisMaximum = 100;
        aranaChart.invalidate();

        List<Double> decodeDistance = decodeDistance(gpxFile);



        valuePulso.setText(Pulso.toString());
        valueRitmo.setText(Ritmo.toString());
        valueTiempo.setText(Tiempo.toString());
        valueDistancia.setText(Distancia.toString());
        valueComentario.setText(Comentario.toString());
        /*
        Double sum = 0.0;
        for (int i = 0; i < decodeDistance.size(); i++) {
                sum = sum + decodeDistance.get(i);
            }

        Double suma = sum;
        textDistancia.setText(String.valueOf(suma));
        */


    }


    private void getEntries(String idActividad) {

        Integer freshness = 0;
        Integer dureza = 0;
        Integer clima = 0;
        Integer intensidad = 0;
        Integer recuperacion = 0;

        switch(idActividad) {
            case "1":
                freshness = 80;
                dureza = 65;
                clima = 34;
                intensidad = 50;
                recuperacion = 54;
                Distancia = "11.5 km";
                Tiempo = "49m:25s";
                Ritmo = "4:30m/km";
                Pulso = "155ppm";
                Comentario = "Me sentía descansado. Muy conforme en general";
                break;

            case "2":
                freshness = 48;
                dureza = 80;
                clima = 38;
                intensidad = 75;
                recuperacion = 51;
                Distancia = "9.3 km";
                Tiempo = "41m:45s";
                Ritmo = "4:46m/km";
                Pulso = "149ppm";
                Comentario = "Sesión bastante dura. Vamos por más!";
                break;
            case "3":
                freshness = 13;
                dureza = 77;
                clima = 44;
                intensidad = 38;
                recuperacion = 22;
                Distancia = "10.5 km";
                Tiempo = "53m:25s";
                Ritmo = "4:21m/km";
                Pulso = "167ppm";
                Comentario = "Muy cómodo seguimos progresando";
                break;
            case "4":
                freshness = 90;
                dureza = 98;
                clima = 25;
                intensidad = 89;
                recuperacion = 12;
                Distancia = "15.5 km";
                Tiempo = "1h:12m:02s";
                Ritmo = "4:53m/km";
                Pulso = "147ppm";
                Comentario = "Sesión muy dura, no creo soportar esto";
                break;
            default:
        }

        radarEntries = new ArrayList<>();
        radarEntries.add(new RadarEntry(freshness, "Freshness"));
        radarEntries.add(new RadarEntry(dureza, "Dureza"));
        radarEntries.add(new RadarEntry(clima, "Clima"));
        radarEntries.add(new RadarEntry(intensidad, "Intensidad"));
        radarEntries.add(new RadarEntry(recuperacion, "Recuperacion"));

    }

    private List<LatLng> decodeGPX(File file){
        List<LatLng> list = new ArrayList<LatLng>();
        distancias = new ArrayList<>();
        DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
        try {
            DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
            FileInputStream fileInputStream = new FileInputStream(file);
            Document document = documentBuilder.parse(fileInputStream);
            Element elementRoot = document.getDocumentElement();

            NodeList nodelist_trkpt = elementRoot.getElementsByTagName("trkpt");


            //esto
            NodeList nodelist_ele = elementRoot.getElementsByTagName("ele");

            for(int i = 0; i < nodelist_trkpt.getLength(); i++){

                Node node = nodelist_trkpt.item(i);
                NamedNodeMap attributes = node.getAttributes();

                String newLatitude = attributes.getNamedItem("lat").getTextContent();
                Double newLatitude_double = Double.parseDouble(newLatitude);


                String newLongitude = attributes.getNamedItem("lon").getTextContent();
                Double newLongitude_double = Double.parseDouble(newLongitude);

                String newLocationName = newLatitude + ":" + newLongitude;
                LatLng punto = new LatLng(newLatitude_double, newLongitude_double);

                //esto
                String valor = nodelist_ele.item(i).getChildNodes().item(0).getNodeValue();
                Double ele = Double.parseDouble(valor);

                if(i==0){
                    lat1 = newLatitude_double;
                    lon1 = newLongitude_double;
                    el1 = ele;
                }else{
                    lat2 = newLatitude_double;
                    lon2 = newLongitude_double;
                    el2 = ele;
                    distancias.add(distance(lat1, lat2, lon1,lon2, el1, el2));;
                    lat1 = newLatitude_double;
                    lon1 = newLongitude_double;
                    el1 = ele;
                }

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


    private List<Entry> decodeGPXele(File file){
        List<Entry> list = new ArrayList<>();

        DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
        try {
            DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
            FileInputStream fileInputStream = new FileInputStream(file);
            Document document = documentBuilder.parse(fileInputStream);
            Element elementRoot = document.getDocumentElement();

            NodeList nodelist_ele = elementRoot.getElementsByTagName("ele");

            for(int i = 0; i < nodelist_ele.getLength(); i++){

                String valor = nodelist_ele.item(i).getChildNodes().item(0).getNodeValue();
                Float ele = Float.parseFloat(valor);

                list.add(new Entry(i,ele));
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

    private List<Entry> decodeGPXhr(File file){
        List<Entry> list = new ArrayList<>();

        DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
        try {
            DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
            FileInputStream fileInputStream = new FileInputStream(file);
            Document document = documentBuilder.parse(fileInputStream);
            Element elementRoot = document.getDocumentElement();

            NodeList nodelist_hr = elementRoot.getElementsByTagName("gpxtpx:hr");

            for(int i = 0; i < nodelist_hr.getLength(); i++){

                String valor = nodelist_hr.item(i).getChildNodes().item(0).getNodeValue();
                Float hr = Float.parseFloat(valor);

                list.add(new Entry(i,hr));
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

    private List<Entry> decodeGPXCAD(File file){
        List<Entry> list = new ArrayList<>();

        DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
        try {
            DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
            FileInputStream fileInputStream = new FileInputStream(file);
            Document document = documentBuilder.parse(fileInputStream);
            Element elementRoot = document.getDocumentElement();

            NodeList nodelist_cad = elementRoot.getElementsByTagName("gpxtpx:cad");

            for(int i = 0; i < nodelist_cad.getLength(); i++){

                String valor = nodelist_cad.item(i).getChildNodes().item(0).getNodeValue();
                Float hr = Float.parseFloat(valor);

                list.add(new Entry(i,hr));
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

        Bundle b = getIntent().getExtras();
        String idActividad = b.getString("idActividad");

        File gpxFile = new File(Environment.getDataDirectory().toString() + "/data/com.example.thelabit/" + idActividad + ".gpx");

        List<LatLng> gpxList = decodeGPX(gpxFile);

        mMap = googleMap;
        mMap.addPolyline(( new PolylineOptions()).addAll(gpxList).width(6).color(Color.RED).geodesic(true));

        googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(Inicio, 13));
    }


    private List<Double> decodeDistance(File file){
        List<Double> distancia = new ArrayList<Double>();

        DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
        try {
            DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
            FileInputStream fileInputStream = new FileInputStream(file);
            Document document = documentBuilder.parse(fileInputStream);
            Element elementRoot = document.getDocumentElement();

            NodeList nodelist_trkpt = elementRoot.getElementsByTagName("trkpt");


            //esto
            NodeList nodelist_ele = elementRoot.getElementsByTagName("ele");

            for(int i = 0; i < nodelist_trkpt.getLength(); i++){

                Node node = nodelist_trkpt.item(i);
                NamedNodeMap attributes = node.getAttributes();

                String newLatitude = attributes.getNamedItem("lat").getTextContent();
                Double newLatitude_double = Double.parseDouble(newLatitude);


                String newLongitude = attributes.getNamedItem("lon").getTextContent();
                Double newLongitude_double = Double.parseDouble(newLongitude);

                String newLocationName = newLatitude + ":" + newLongitude;
                LatLng punto = new LatLng(newLatitude_double, newLongitude_double);

                //esto
                String valor = nodelist_ele.item(i).getChildNodes().item(0).getNodeValue();
                Double ele = Double.parseDouble(valor);

                if(i==0){
                    lat1 = newLatitude_double;
                    lon1 = newLongitude_double;
                    el1 = ele;
                }else{
                    lat2 = newLatitude_double;
                    lon2 = newLongitude_double;
                    el2 = ele;
                    distancia.add(distance(lat1, lat2, lon1,lon2, el1, el2));;
                    lat1 = newLatitude_double;
                    lon1 = newLongitude_double;
                    el1 = ele;
                }

                if(i==0){
                    Inicio = punto;
                }

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
        return distancia;
    }

    public static double distance(double lat1, double lat2, double lon1,
                                  double lon2, double el1, double el2) {

        final int R = 6371; // Radius of the earth

        double latDistance = Math.toRadians(lat2 - lat1);
        double lonDistance = Math.toRadians(lon2 - lon1);
        double a = Math.sin(latDistance / 2) * Math.sin(latDistance / 2)
                + Math.cos(Math.toRadians(lat1)) * Math.cos(Math.toRadians(lat2))
                * Math.sin(lonDistance / 2) * Math.sin(lonDistance / 2);
        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
        double distance = R * c * 1000; // convert to meters

        double height = el1 - el2;

        distance = Math.pow(distance, 2) + Math.pow(height, 2);

        return Math.sqrt(distance);
    }


}
