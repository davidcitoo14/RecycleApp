package com.example.recycleapp;

import static java.lang.Thread.sleep;

import androidx.appcompat.app.AppCompatActivity;
import com.example.recycleapp.models.User;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class UserRegisterActivity extends AppCompatActivity {

    EditText nameR, emailR, passwordR, confirm_passwordR;
    Button registarUser;
    String name,email,password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_register);

        nameR = findViewById(R.id.editTextNombreRegistro);
        emailR = findViewById(R.id.editTextEmailRegistro);
        passwordR = findViewById(R.id.editTextContraseñaRegistro);
        confirm_passwordR = findViewById(R.id.editTextContraseña_Confirmacion_Registro);
        registarUser = findViewById(R.id.btn_registrouser);

       Intent usuarioregistrado = new Intent(getApplicationContext(), LoginActivity.class);
       Intent logina= new Intent(getApplicationContext(),
                MainActivity.class);
        Intent Login1= new Intent(getApplicationContext(),
                LoginActivity.class);
        registarUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (!nameR.getText().toString().isEmpty() && !emailR.getText().toString().isEmpty() &&
                         !passwordR.getText().toString().isEmpty() &&
                        !confirm_passwordR.getText().toString().isEmpty()) {
                    // Revisar si las contraseñas coinciden
                    if (passwordR.getText().toString().equals(confirm_passwordR.getText().toString())) {
                        // Validar si los datos ya existen en el archivo
                        if (datosExisten(emailR.getText().toString(),  nameR.getText().toString())) {
                            // Los datos ya existen
                            Toast.makeText(getApplicationContext(), "El correo, usuario  ya existen", Toast.LENGTH_SHORT).show();
                        } else {
                            // Los datos no existen, realizar el registro
                            // Crear un nuevo objeto Usuario
                            User nuevoUsuario = new User(nameR.getText().toString(),
                                    emailR.getText().toString(),
                                    passwordR.getText().toString());
                            // Guardar los datos en el archivo
                            guardarRegistro(nuevoUsuario);
                            // Ir al activity de inicio de sesión
                            startActivity(Login1);
                        }
                    } else {
                        // Las contraseñas no coinciden
                        Toast.makeText(getApplicationContext(), "Las contraseñas no coinciden",
                                Toast.LENGTH_SHORT).show();
                    }
                } else {
                    // Los campos estan vacios
                    Toast.makeText(getApplicationContext(), "Los campos no pueden estar vacíos",
                            Toast.LENGTH_SHORT).show();
                }
            }
        });

    }

    private void guardarRegistro(User nuevoUsuario) {

        File file= new File(getFilesDir(), "usuario.txt");

        try {
            FileWriter writer = new FileWriter(file, true); // El segundo parámetro "true" indica que se agregará al final del archivo existente
            BufferedWriter bufferedWriter = new BufferedWriter(writer);
            String nuevoRegistro = nuevoUsuario.getName() + "," + nuevoUsuario.getEmail() + "," + nuevoUsuario.getPassword() + "\n";
            bufferedWriter.write(nuevoRegistro);
            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private boolean datosExisten(String email, String name) {
        File file = new File(getFilesDir(), "usuario.txt");

        try {
            FileReader reader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(reader);
            String line;
            List<String> existingEmails = new ArrayList<>();
            List<String> existingNombresUsuarios = new ArrayList<>();

            while ((line = bufferedReader.readLine()) != null) {
                String[] data = line.split(",");


                existingNombresUsuarios.add(data[0]);
                existingEmails.add(data[1]);
            }

            bufferedReader.close();

            return existingEmails.contains(email)  || existingNombresUsuarios.contains(name);

        } catch (IOException e) {
            e.printStackTrace();
        }

        return false;
    }

}














