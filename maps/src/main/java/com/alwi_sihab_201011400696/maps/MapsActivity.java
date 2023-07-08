package com.alwi_sihab_201011400696.maps;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.FrameLayout;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.internal.IGoogleMapDelegate;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    GoogleMap googleMap;
    FrameLayout map;
    float lat;
    float lng;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);

        map = findViewById(R.id.map);

        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager() .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        SharedPreferences sh = getSharedPreferences("MapsPref", MODE_PRIVATE);
        lat = sh.getFloat("Lat", 0);
        lng = sh.getFloat("Lng", 0);
    }

    @Override
    public void onMapReady(@NonNull GoogleMap googleMap) {
        this.googleMap = googleMap;

        LatLng mapIndonesia = new LatLng(lat, lng);
        this.googleMap.addMarker(new MarkerOptions().position(mapIndonesia).title("Marker on indonesia"));
        this.googleMap.moveCamera(CameraUpdateFactory.newLatLng(mapIndonesia));
        this.googleMap.animateCamera(CameraUpdateFactory.zoomTo(12.0f));

    }
}