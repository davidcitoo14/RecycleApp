package com.example.recycleapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.recycleapp.models.Bateria;
import com.example.recycleapp.models.Vidrio;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Locale;

public class RegisterVidrioActivity extends AppCompatActivity {
    EditText cantidadVidrioKG, valorGanado;
    Button RegVidrio;
    EditText tipoVidrio;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_vidrio);
        cantidadVidrioKG=findViewById(R.id.editTextCantidadVidrio);
        valorGanado=findViewById(R.id.editTextValorVidrio);
        RegVidrio=findViewById(R.id.btn_registrouser);
        tipoVidrio=findViewById(R.id.editTexttipoVidrio);
        Intent intent2 = new Intent(this, HomeActivity.class);
        RegVidrio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!cantidadVidrioKG.getText().toString().isEmpty() && !valorGanado.getText().toString().isEmpty() && !tipoVidrio.getText().toString().isEmpty()) {

                } else {
                    boolean datosGuardados = guardarDatos(cantidadVidrioKG.getText().toString(), valorGanado.getText().toString(), tipoVidrio.getText().toString());
                    if (datosGuardados) {
                        // Se cambia de actividad
                        startActivity(intent2);
                    } else {
                        Toast.makeText(RegisterVidrioActivity.this, "Error al guardar el archivo",
                                Toast.LENGTH_SHORT).show();
                    }
                    Toast.makeText(RegisterVidrioActivity.this, "Los campos no pueden estar vacíos", Toast.LENGTH_SHORT).show();
                }  }
        });
    }

    private boolean guardarDatos(String cantidadKG, String precio, String tipoVidrio) {
        File file = new File(getFilesDir(), "Battery.txt");
        tipoVidrio = tipoVidrio.toLowerCase();
        try {
            // Verificar si el archivo existe
            if (!file.exists()) {
                file.createNewFile();
            }

            FileWriter writer = new FileWriter(file, true);
            BufferedWriter bufferedWriter = new BufferedWriter(writer);

            // Crear una instancia de VIDRIO y escribir los datos en el archivo
            Vidrio vidrio = new Vidrio(Float.parseFloat(cantidadKG), Float.parseFloat(precio), tipoVidrio);
            String linea = String.format(Locale.getDefault(), "%.2f,%.2f,%s", vidrio.getCantidadKg(), vidrio.getPrecio(), vidrio.getTipo_Vidrio());
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
