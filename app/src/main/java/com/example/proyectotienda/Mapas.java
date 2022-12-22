package com.example.proyectotienda;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.widget.Toast;

import com.google.android.gms.maps.MapView;
import com.google.firebase.firestore.GeoPoint;

import java.util.ArrayList;

public class Mapas extends AppCompatActivity {
    private MapView mapView;
   // private MapController mapController;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mapas);

        /*Context ctx = getApplicationContext();
        Configuration.getInstance().load(ctx, PreferenceManager.getDefaultSharedPreferences(ctx));

        GeoPoint madrid = new GeoPoint(40.416775, -3.70379);
        mapView = (MapView) findViewById(R.id.map);
        mapView.setBuiltInZoomControls(true);
        mapController = (MapController) mapView.getController();
        mapController.setCenter(madrid);
        mapController.setZoom(8);

        mapView.setMultiTouchControls(true);

        Intent intentIN = getIntent();
        ArrayList<String> latitudes = intentIN.getStringArrayListExtra("latitudes");
        ArrayList<String> longitudes = intentIN.getStringArrayListExtra("longitudes");

        for(int i=0; i<latitudes.size(); i++){
            GeoPoint geoPoint = new GeoPoint(Double.parseDouble(latitudes.get(i)), Double.parseDouble(longitudes.get(i)));
            Marker marker = new Marker(mapView);
            marker.setPosition(geoPoint);
            mapView.getOverlays().add(marker);
        }

        MapEventsReceiver mapEventsReceiver = new MapEventsReceiver() {
            @Override
            public boolean singleTapConfirmedHelper(GeoPoint p) {
                Toast.makeText(getApplicationContext(),p.getLatitude() + " - " + p.getLongitude(), Toast.LENGTH_SHORT).show();

                return false;
            }

            @Override
            public boolean longPressHelper(GeoPoint p) {
                return false;
            }
        };
        MapEventsOverlay eventsOverlay = new MapEventsOverlay(getApplicationContext(), mapEventsReceiver);
        mapView.getOverlays().add(eventsOverlay);*/

    }
}