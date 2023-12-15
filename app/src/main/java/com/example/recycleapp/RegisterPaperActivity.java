package com.example.recycleapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.recycleapp.models.Bateria;
import com.example.recycleapp.models.Paper;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Locale;

public class RegisterPaperActivity extends AppCompatActivity {
    EditText pesoPaper, valorGanado;
    Button RegPaper;
    EditText tipoPaper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_paper);
        pesoPaper=findViewById(R.id.editTextCantidadPapel);
        valorGanado=findViewById(R.id.editTextValorPapel);
        RegPaper=findViewById(R.id.btn_registrouser);
        tipoPaper=findViewById(R.id.editTexttipoPaper);
        Intent intent2 = new Intent(this, HomeActivity.class);

        RegPaper.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!pesoPaper.getText().toString().isEmpty() && !valorGanado.getText().toString().isEmpty() && !tipoPaper.getText().toString().isEmpty()) {
                    String mesBuscado = tipoPaper.getText().toString();
                    // boolean mesExiste = verificarMes(mesBuscado);

                } else {
                    boolean datosGuardados = guardarDatos(pesoPaper.getText().toString(), valorGanado.getText().toString(), tipoPaper.getText().toString());
                    if (datosGuardados) {
                        // Se cambia de actividad
                        startActivity(intent2);
                    } else {
                        Toast.makeText(RegisterPaperActivity.this, "Error al guardar el archivo",
                                Toast.LENGTH_SHORT).show();
                    }
                    Toast.makeText(RegisterPaperActivity.this, "Los campos no pueden estar vacíos", Toast.LENGTH_SHORT).show();
                }  }
        });
    }

    private boolean guardarDatos(String cantidad, String precio, String tipo_paper) {
        File file = new File(getFilesDir(), "Paper.txt");
        tipo_paper = tipo_paper.toLowerCase();
        try {
            // Verificar si el archivo existe
            if (!file.exists()) {
                file.createNewFile();
            }

            FileWriter writer = new FileWriter(file, true);
            BufferedWriter bufferedWriter = new BufferedWriter(writer);

            // Crear una insta escribir los datos en el archivo
            Paper paper = new Paper(Float.parseFloat(cantidad), Float.parseFloat(precio), tipo_paper);
            String linea = String.format(Locale.getDefault(), "%.2f,%.2f,%s", paper.getCantidad(), paper.getPrecio(), paper.getTipo_papel());
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