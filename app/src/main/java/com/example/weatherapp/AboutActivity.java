package com.example.weatherapp;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

public class AboutActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);

        // você pode popular com seus dados reais
        TextView tvName = findViewById(R.id.tvName);
        TextView tvRA = findViewById(R.id.tvRA);
        TextView tvCourse = findViewById(R.id.tvCourse);
        // tvName.setText("Wellinghton");
    }
}
