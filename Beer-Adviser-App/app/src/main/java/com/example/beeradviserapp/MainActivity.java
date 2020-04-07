package com.example.beeradviserapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.solver.LinearSystem;

import android.os.Bundle;
import android.view.View;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private BeerExpert beerExpert = new BeerExpert();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    // This function will get call when the button pressed
    public void find_beer(View view) {
        TextView brands = findViewById(R.id.brands);
        Spinner spinner = findViewById(R.id.spinner);

        // Get list of brands from beerExpert class
        List<String> brandList = beerExpert.get_brands(spinner.getSelectedItem().toString());

        StringBuilder brandFormatted = new StringBuilder();
        for(String brand: brandList) brandFormatted.append(brand).append("\n");

        brands.setText(brandFormatted);
    }
}
