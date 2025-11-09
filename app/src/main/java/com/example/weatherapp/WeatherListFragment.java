package com.example.weatherapp;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import java.util.ArrayList;

public class WeatherListFragment extends Fragment {
    RecyclerView recycler;
    WeatherAdapter adapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_weather_list, container, false);

        recycler = v.findViewById(R.id.recyclerWeather);
        recycler.setLayoutManager(new LinearLayoutManager(getContext()));
        adapter = new WeatherAdapter(new ArrayList<>());
        recycler.setAdapter(adapter);

        // Adiciona exemplo estático (para testar)
        adapter.addItem(new WeatherAdapter.Item("São Paulo,BR", "25", "Ensolarado"));

        // Chama o método para carregar os dados da API
        loadWeatherFromApi();  // Aqui chamamos o método

        return v;
    }


    // Método para carregar os dados da API (não implementado no fragmento)
    private void loadWeatherFromApi() {
        ApiService api = NetworkClient.getRetrofit().create(ApiService.class);
        String chave = "6f6da666";  // Substitua pela sua chave real ou busque em SharedPreferences
        String cidade = "São Paulo,BR";  // Ou recupere de SharedPreferences

        api.getWeather(chave, cidade).enqueue(new retrofit2.Callback<WeatherResponse>() {
            @Override
            public void onResponse(@NonNull retrofit2.Call<WeatherResponse> call, @NonNull retrofit2.Response<WeatherResponse> response) {
                if (response.isSuccessful() && response.body() != null) {
                    WeatherResponse.Results r = response.body().results;
                    // Limpa a lista e adiciona os novos dados
                    adapter.clearList();
                    adapter.addItem(new WeatherAdapter.Item(r.city, r.temp, r.description));
                }
            }

            @Override
            public void onFailure(@NonNull retrofit2.Call<WeatherResponse> call, @NonNull Throwable t) {
                t.printStackTrace();  // Melhorar com um log adequado
            }
        });
    }
}
