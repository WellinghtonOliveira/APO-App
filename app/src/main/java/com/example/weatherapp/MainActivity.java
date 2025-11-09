package com.example.weatherapp;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.content.Intent;
import android.view.Menu;
import android.view.MenuItem;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.viewpager2.widget.ViewPager2;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.journeyapps.barcodescanner.ScanOptions;
import com.journeyapps.barcodescanner.ScanContract;

public class MainActivity extends AppCompatActivity {
    private ViewPager2 viewPager;
    private TabLayout tabLayout;
    private FloatingActionButton fabScan;
    // Declare the ActivityResultLauncher for the barcode scanning
    private ActivityResultLauncher<ScanOptions> barcodeLauncher;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        viewPager = findViewById(R.id.viewPager);
        tabLayout = findViewById(R.id.tabLayout);
        fabScan = findViewById(R.id.fabScan);

        // Initialize the barcode scanner launcher
        barcodeLauncher = registerForActivityResult(new ScanContract(), result -> {
            if (result.getContents() != null) {
                String scanned = result.getContents(); // ex.: "São Paulo,BR"
                // Save the scanned city code in SharedPreferences
                SharedPreferences preferences = getSharedPreferences("app_prefs", MODE_PRIVATE);
                preferences.edit().putString("city_code", scanned).apply();

                // Recreate the activity to refresh the fragments with the new data
                recreate();
            }
        });

        // Set up ViewPager and TabLayout
        ViewPagerAdapter adapter = new ViewPagerAdapter(this);
        viewPager.setAdapter(adapter);
        new TabLayoutMediator(tabLayout, viewPager,
                (tab, position) -> tab.setText(position == 0 ? "Previsão" : "Mapa")
        ).attach();

        // Set up FloatingActionButton click to launch the barcode scanner
        fabScan.setOnClickListener(v -> {
            // Create scan options for QR code scanning
            ScanOptions options = new ScanOptions();
            options.setDesiredBarcodeFormats(ScanOptions.QR_CODE);
            options.setPrompt("Escaneie o QR com o código da cidade (ex.: São Paulo,BR)");
            options.setBeepEnabled(true);
            // Launch the scanner
            barcodeLauncher.launch(options);
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.menu_about) {
            startActivity(new Intent(this, AboutActivity.class));
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
