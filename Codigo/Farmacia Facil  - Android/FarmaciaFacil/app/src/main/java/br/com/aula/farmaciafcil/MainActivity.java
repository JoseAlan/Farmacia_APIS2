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

public class MainActivity extends FragmentActivity {
    private SupportMapFragment mapFrag;
    private GoogleMap map;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        GoogleMapOptions options = new GoogleMapOptions();
        options.zOrderOnTop(true);
        mapFrag = SupportMapFragment.newInstance(options);

        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();

        ft.replace(R.id.llContainer, mapFrag);
        ft.commit();


    }
    @Override
    public void onResume(){
        super.onResume();

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
    }

    public void configureMap(){
        map = mapFrag.getMap();
        map.setMapType(GoogleMap.MAP_TYPE_HYBRID);

        LatLng latLng = new LatLng(-7.2058717, -39.3131984);
        CameraPosition cameraPosition = new CameraPosition.Builder().target(latLng).zoom(18).build();
        CameraUpdate update = CameraUpdateFactory.newCameraPosition(cameraPosition);

        map.moveCamera(update);
    }
}
