package com.example.weatherapp;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiService {
    @GET("weather")
    Call<WeatherResponse> getWeather(@Query("key") String key, @Query("city_name") String city);
}
