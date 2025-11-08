package com.example.weatherapp;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;

public class WeatherListFragment extends Fragment {
    RecyclerView recycler;
    WeatherAdapter adapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState){
        View v = inflater.inflate(R.layout.fragment_weather_list, container, false);
        recycler = v.findViewById(R.id.recyclerWeather);
        recycler.setLayoutManager(new LinearLayoutManager(getContext()));
        adapter = new WeatherAdapter(new ArrayList<>());
        recycler.setAdapter(adapter);

        // temporariamente adiciona exemplo estático (para testar)
        adapter.addExample("São Paulo,BR", "25", "Ensolarado");
        return v;
    }
}
