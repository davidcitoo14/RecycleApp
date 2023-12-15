package com.example.recycleapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.recycleapp.models.Bateria;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Locale;

public class RegisterBatteryActivity extends AppCompatActivity {

    EditText numPilas, valorGanado;
    Button RegBate;
    EditText tipoBattery;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_battery);
        numPilas=findViewById(R.id.editTextCantidadBateria);
        valorGanado=findViewById(R.id.editTextValorBateria);
        RegBate=findViewById(R.id.btn_registrouser);
        tipoBattery=findViewById(R.id.editTexttipoPlast);
        Intent intent2 = new Intent(this, HomeActivity.class);

        RegBate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!numPilas.getText().toString().isEmpty() && !valorGanado.getText().toString().isEmpty() && !tipoBattery.getText().toString().isEmpty()) {

                    } else {
                        boolean datosGuardados = guardarDatos(numPilas.getText().toString(), valorGanado.getText().toString(), tipoBattery.getText().toString());
                        if (datosGuardados) {
                            // Se cambia de actividad
                            startActivity(intent2);
                        } else {
                            Toast.makeText(RegisterBatteryActivity.this, "Error al guardar el archivo",
                                    Toast.LENGTH_SHORT).show();
                        }
                    Toast.makeText(RegisterBatteryActivity.this, "Los campos no pueden estar vacíos", Toast.LENGTH_SHORT).show();
             }  }
            });
    }

            private boolean guardarDatos(String cantidad, String precio, String tipo_bateria) {
                File file = new File(getFilesDir(), "Battery.txt");
                tipo_bateria = tipo_bateria.toLowerCase();
                try {
                    // Verificar si el archivo existe
                    if (!file.exists()) {
                        file.createNewFile();
                    }

                    FileWriter writer = new FileWriter(file, true);
                    BufferedWriter bufferedWriter = new BufferedWriter(writer);

                    // Crear una instancia de bateria y escribir los datos en el archivo
                    Bateria bateria = new Bateria(Float.parseFloat(cantidad), Float.parseFloat(precio), tipo_bateria);
                    String linea = String.format(Locale.getDefault(), "%.2f,%.2f,%s", bateria.getCantidad(), bateria.getPrecio(), bateria.getTipo_bateria());
                    bufferedWriter.write(linea);
                    bufferedWriter.newLine();
                    bufferedWriter.close();
                    return true; // Los datos se guardaron correctamente
                } catch (IOException e) {
                    e.printStackTrace();
                }

                return false; // Error al guardar los datos
            }

    }








