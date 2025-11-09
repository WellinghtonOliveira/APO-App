package com.example.weatherapp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class WeatherAdapter extends RecyclerView.Adapter<WeatherAdapter.Holder> {
    private List<Item> list;

    // Construtor que recebe a lista de itens
    public WeatherAdapter(List<Item> list) {
        this.list = list;
    }

    // Criação da ViewHolder para o item de clima
    @NonNull
    @Override
    public Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_weather_card, parent, false);
        return new Holder(v);
    }

    // Bind dos dados no item de clima
    @Override
    public void onBindViewHolder(@NonNull Holder h, int pos) {
        Item it = list.get(pos);
        h.tvCity.setText(it.city);
        h.tvTemp.setText(it.temp + " ºC");
        h.tvDesc.setText(it.desc);
    }

    // Retorna a quantidade de itens na lista
    @Override
    public int getItemCount() {
        return list.size();
    }

    // Método para adicionar um item na lista
    public void addItem(Item item) {
        list.add(item);
        notifyItemInserted(list.size() - 1);  // Notifica que o item foi inserido na última posição
    }

    // Método para limpar a lista
    public void clearList() {
        list.clear();
        notifyDataSetChanged();  // Notifica que a lista foi limpa
    }

    // ViewHolder que representa cada item de clima
    static class Holder extends RecyclerView.ViewHolder {
        ImageView img;
        TextView tvCity, tvTemp, tvDesc;

        Holder(View v) {
            super(v);
            img = v.findViewById(R.id.imgWeather);
            tvCity = v.findViewById(R.id.tvCity);
            tvTemp = v.findViewById(R.id.tvTemp);
            tvDesc = v.findViewById(R.id.tvDesc);
        }
    }

    // Classe para representar um item de clima (cidade, temperatura e descrição)
    static class Item {
        String city, temp, desc;

        Item(String c, String t, String d) {
            city = c;
            temp = t;
            desc = d;
        }
    }
}
