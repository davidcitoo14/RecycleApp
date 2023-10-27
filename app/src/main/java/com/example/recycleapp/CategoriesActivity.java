package com.example.recycleapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class CategoriesActivity extends AppCompatActivity {

    Button paper, vidrio, plastico, bateria;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_categories);

        paper.findViewById(R.id.btn_papel);
        vidrio.findViewById(R.id.btn_vidrio);
        plastico.findViewById(R.id.btn_plastico);
        bateria.findViewById(R.id.btn_baterias);

        Intent irpapel = new Intent(getApplicationContext(), RegisterPaperActivity.class);
        Intent irvidrio = new Intent(getApplicationContext(), RegisterVidrioActivity.class);
        Intent irplastico = new Intent(getApplicationContext(), RegisterPlasticActivity.class);
        Intent irbateria = new Intent(getApplicationContext(), RegisterBatteryActivity.class);

        paper.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(irpapel);
            }
        });

        vidrio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(irvidrio);
            }
        });

        plastico.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(irplastico);
            }
        });

        bateria.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(irbateria);
            }
        });

    }
}