package br.com.aula.farmaciafacil;


import android.support.v4.app.FragmentActivity;

import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.GoogleMapOptions;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

public class MainActivity extends FragmentActivity {
    private SupportMapFragment mapFrag;
    private GoogleMap map;
    private Marker marker;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        GoogleMapOptions options = new GoogleMapOptions();
        options.zOrderOnTop(true);
        mapFrag = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.fragment1);

        map = mapFrag.getMap();
        /*
        mapFrag = SupportMapFragment.newInstance(options);
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.llContainer, mapFrag);
        ft.commit();*/

        configureMap();
    }
    @Override
    public void onResume(){
        super.onResume();
/*
        new Thread() {
            public void run() {
                while (mapFrag.getMap() == null) {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        configureMap();
                    }
                });
            }
        }.start();
        */
    }

    public void configureMap(){
        map = mapFrag.getMap();
        map.setMapType(GoogleMap.MAP_TYPE_NORMAL);

        LatLng latLng = new LatLng(-7.205877, -39.3110097);
        CameraPosition cameraPosition = new CameraPosition.Builder().target(latLng).zoom(18).build();
        CameraUpdate update = CameraUpdateFactory.newCameraPosition(cameraPosition);

        map.moveCamera(update);
        customAddMarker(new LatLng(-7.205877, -39.3110097), "FAP", "A.K.A Sua localização");
        customAddMarker(new LatLng(-7.20495083, -39.31016296), "Farmácia Palestina", "7:00 até 22:00");
        customAddMarker(new LatLng(-7.2038593, -39.3180164), "Farmácia Pague Menos", "24h");
        customAddMarker(new LatLng(-7.2191748, -39.3095176), "Farmácia Mandacaru", "7:00 até 22:00");
        customAddMarker(new LatLng(-7.204598, -39.3142246), "Pharmapele", "9:00 até 22:00");

        //-7.20495083, -39.31016296;Farmacia palestina
        //-7.205877, -39.3110097;//Fap
        //-7.2038593, -39.3180164;//Farmácia pague menos
        //-7.2191748, -39.3095176;//Farmácia Mandacaru
        //-7.204598, -39.3142246;//Pharmapele
    }



    public void customAddMarker(LatLng latLng, String title, String snippet){
        MarkerOptions options = new MarkerOptions();
        options.position(latLng).title(title).snippet(snippet).draggable(true);

        marker = map.addMarker(options);


    }
}
