package com.example.weatherapp;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import androidx.appcompat.app.AppCompatActivity;

public class TelaInicialActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_inicial);

        new Handler().postDelayed(() -> {
            startActivity(new Intent(TelaInicialActivity.this, MainActivity.class));
            finish();
        }, 3000); // 3 segundos
    }
}
