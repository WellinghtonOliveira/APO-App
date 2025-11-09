package com.example.weatherapp;

import com.google.gson.annotations.SerializedName;
import java.util.List;

public class WeatherResponse {
    @SerializedName("by")
    public String by;

    @SerializedName("results")
    public Results results;

    public static class Results {
        @SerializedName("city")
        public String city;

        @SerializedName("temp")
        public String temp;

        @SerializedName("description")
        public String description;

        @SerializedName("forecast")
        public List<Forecast> forecast;

        @SerializedName("img_id")
        public String img_id;

        @SerializedName("lat")
        public Double lat;

        @SerializedName("lon")
        public Double lon;
    }

    public static class Forecast {
        @SerializedName("date")
        public String date;
        @SerializedName("description")
        public String description;
        @SerializedName("max")
        public String max;
        @SerializedName("min")
        public String min;
    }
}
