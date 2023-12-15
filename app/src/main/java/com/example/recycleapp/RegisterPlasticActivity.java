package com.example.recycleapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.recycleapp.models.Bateria;
import com.example.recycleapp.models.Plastic;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Locale;

public class RegisterPlasticActivity extends AppCompatActivity {
    EditText cantPlast, valorGanado;
    Button RegPlast;
    EditText tipoPlastico;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_plastic);
        cantPlast=findViewById(R.id.editTextCantidadPlastico);
        valorGanado=findViewById(R.id.editTextValorPlastico);
        RegPlast=findViewById(R.id.btn_registrouser);
        tipoPlastico=findViewById(R.id.editTexttipoPlast);
        Intent intent2 = new Intent(this, HomeActivity.class);
        RegPlast.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!cantPlast.getText().toString().isEmpty() && !valorGanado.getText().toString().isEmpty() && !tipoPlastico.getText().toString().isEmpty()) {

                } else {
                    boolean datosGuardados = guardarDatos(cantPlast.getText().toString(), valorGanado.getText().toString(), tipoPlastico.getText().toString());
                    if (datosGuardados) {
                        // Se cambia de actividad
                        startActivity(intent2);
                    } else {
                        Toast.makeText(RegisterPlasticActivity.this, "Error al guardar el archivo",
                                Toast.LENGTH_SHORT).show();
                    }
                    Toast.makeText(RegisterPlasticActivity.this, "Los campos no pueden estar vacíos", Toast.LENGTH_SHORT).show();
                }  }
        });
    }

    private boolean guardarDatos(String cantidad, String precio, String Tipo_plastico) {
        File file = new File(getFilesDir(), "Plastic.txt");
        Tipo_plastico= Tipo_plastico.toLowerCase();
        try {
            // Verificar si el archivo existe
            if (!file.exists()) {
                file.createNewFile();
            }

            FileWriter writer = new FileWriter(file, true);
            BufferedWriter bufferedWriter = new BufferedWriter(writer);

            // Crear una instancia de plastic escribir los datos en el archivo
            Plastic plastico = new Plastic(Float.parseFloat(cantidad), Float.parseFloat(precio), Tipo_plastico);
            String linea = String.format(Locale.getDefault(), "%.2f,%.2f,%s", plastico.getCantidad(), plastico.getPrecio(),plastico.getTipo_plastico());
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
