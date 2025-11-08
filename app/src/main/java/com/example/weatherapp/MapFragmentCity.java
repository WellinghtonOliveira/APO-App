package com.example.weatherapp;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import com.google.android.gms.maps.*;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class MapFragmentCity extends Fragment implements OnMapReadyCallback {
    private MapView mapView;
    private GoogleMap gMap;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_map_city, container, false);
        mapView = v.findViewById(R.id.mapView);
        mapView.onCreate(savedInstanceState);
        mapView.getMapAsync(this);
        return v;
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        gMap = googleMap;
        LatLng cityPos = new LatLng(-23.55052, -46.633308); // São Paulo exemplo
        gMap.addMarker(new MarkerOptions().position(cityPos).title("Cidade"));
        gMap.moveCamera(CameraUpdateFactory.newLatLngZoom(cityPos,12f));
    }

    @Override public void onResume(){ super.onResume(); mapView.onResume(); }
    @Override public void onStart(){ super.onStart(); mapView.onStart(); }
    @Override public void onStop(){ super.onStop(); mapView.onStop(); }
    @Override public void onPause(){ mapView.onPause(); super.onPause(); }
    @Override public void onDestroy(){ mapView.onDestroy(); super.onDestroy(); }
    @Override public void onLowMemory(){ super.onLowMemory(); mapView.onLowMemory(); }
}
