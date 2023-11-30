package com.example.recycleapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

public class RegisterBatteryActivity extends AppCompatActivity {

    EditText numPilas, valorGanado;
    Button RegBate;
    Spinner month;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_battery);
        numPilas=findViewById(R.id.editTextCantidadBateria);
        valorGanado=findViewById(R.id.editTextValorBateria);
        RegBate=findViewById(R.id.btn_registroBat);
        ArrayList<RegisterBatteryActivity> Baterys= new ArrayList<>();

        RegBate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String cantidad= numPilas.getText().toString();
                String ganancia =valorGanado.getText().toString();

                if (cantidad.isEmpty()|| ganancia.isEmpty())
                    Toast.makeText(RegisterBatteryActivity.this, "Datos incompletos", Toast.LENGTH_LONG).show();
            }

        });


    }

}

