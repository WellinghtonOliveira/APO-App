package com.example.weatherapp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;
import java.util.ArrayList;

public class WeatherAdapter extends RecyclerView.Adapter<WeatherAdapter.Holder> {
    private List<Item> list;
    public WeatherAdapter(List<Item> l){ this.list = l; }
    @NonNull
    @Override
    public Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType){
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_weather_card, parent, false);
        return new Holder(v);
    }
    @Override
    public void onBindViewHolder(@NonNull Holder h, int pos){
        Item it = list.get(pos);
        h.tvCity.setText(it.city);
        h.tvTemp.setText(it.temp + " ºC");
        h.tvDesc.setText(it.desc);
    }
    @Override public int getItemCount(){ return list.size(); }

    public void addExample(String city, String temp, String desc){
        list.add(new Item(city,temp,desc));
        notifyDataSetChanged();
    }

    static class Holder extends RecyclerView.ViewHolder{
        ImageView img; TextView tvCity, tvTemp, tvDesc;
        Holder(View v){
            super(v);
            img = v.findViewById(R.id.imgWeather);
            tvCity = v.findViewById(R.id.tvCity);
            tvTemp = v.findViewById(R.id.tvTemp);
            tvDesc = v.findViewById(R.id.tvDesc);
        }
    }

    static class Item {
        String city, temp, desc;
        Item(String c,String t,String d){ city=c;temp=t;desc=d;}
    }
}
