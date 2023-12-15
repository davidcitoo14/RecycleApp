package com.example.recycleapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class HomeActivity extends AppCompatActivity {

    Button categories, statistics, recommendations;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        categories=findViewById(R.id.btn_categorias);
        statistics=findViewById(R.id.btn_estadisticas);
        recommendations=findViewById(R.id.btn_consejos);
        Intent receive= getIntent();
        String idUser= receive.getStringExtra("idUser");
        Intent RegisterBattery= new Intent(getApplicationContext(),RegisterBatteryActivity.class);
        RegisterBattery.putExtra("idUser",idUser);

        Intent statistics_view= new Intent(getApplicationContext(),
                StatisticsActivity.class);
        statistics_view.putExtra("idUser",idUser);

        Intent Categories_view= new Intent(getApplicationContext(),
                CategoriesActivity.class);
        Categories_view.putExtra("idUser",idUser);

        Intent Recommendations_view= new Intent(getApplicationContext(),
                RecommendationsActivity.class);
        Recommendations_view.putExtra("idUser",idUser);


        /*Intent ircategorias = new Intent(getApplicationContext(), CategoriesActivity.class);
        Intent irestadisticas = new Intent(getApplicationContext(), StatisticsActivity.class);
        Intent irconsejos = new Intent(getApplicationContext(), RecommendationsActivity.class);*/

        categories.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(Categories_view);
            }
        });

        statistics.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(statistics_view);
            }
        });

        recommendations.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(Recommendations_view);
            }
        });

    }
}