package br.com.aula.farmaciafcil;


import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.app.Activity;

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

        LatLng latLng = new LatLng(-7.2058717, -39.3131984);
        CameraPosition cameraPosition = new CameraPosition.Builder().target(latLng).zoom(18).build();
        CameraUpdate update = CameraUpdateFactory.newCameraPosition(cameraPosition);

        map.moveCamera(update);

        map.setOnCameraChangeListener(new GoogleMap.OnCameraChangeListener(){

            @Override
            public void onCameraChange(CameraPosition cameraPosition) {

                if(marker != null ){
                    marker.remove();
                }
                customAddMarker(new LatLng(cameraPosition.target.latitude,cameraPosition.target.longitude) , "Marcador Alterado", "O marcador foi redirecionado");
            }


        });
    }

    public void customAddMarker(LatLng latLng, String title, String snippet){
        MarkerOptions options = new MarkerOptions();
        options.position(latLng).title(title).snippet(snippet).draggable(true);

        marker = map.addMarker(options);


    }
}
