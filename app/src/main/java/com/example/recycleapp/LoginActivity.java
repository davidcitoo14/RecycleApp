package com.example.recycleapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.recycleapp.models.User;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class LoginActivity extends AppCompatActivity {

    Button login;
    EditText email,password;
   TextView registerUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        login = findViewById(R.id.btn_ingreso);
        registerUser = findViewById(R.id.textViewRegistrarUser);
        email = findViewById(R.id.editTextCorreo);
        password = findViewById(R.id.editTextTextContraseña);
        Intent registrarUsuario = new Intent(getApplicationContext(), UserRegisterActivity.class);
        Intent home = new Intent(getApplicationContext(), HomeActivity.class);

        File fileUser= new File(getFilesDir(),"usuario.txt");

       // ArrayList<User> users= listUser(fileUser);
        //File file = new File(getFilesDir(), "usuario.txt");
        ArrayList<User> usuarios = new ArrayList<>();
        try {
            BufferedReader reader = new BufferedReader(new FileReader(fileUser));
            String line;
            while ((line = reader.readLine()) != null) {
                // Dividir la línea en los datos del usuario separados por comas
                String[] userData = line.split(",");
                String nombre = userData[0];
                String correo = userData[1];
                String passwordData = userData[2];
                // Crear un objeto Usuario y añadirlo a la lista de usuarios
                User nuevoUsuario = new User(nombre, correo, passwordData);
                usuarios.add(nuevoUsuario);
            }
            reader.close();

            // Imprimir información de los usuarios leídos en el archivo
            for (User usuario : usuarios) {
                Log.d("Usuarios",
                        "Nombre: " + usuario.getName() + ", Correo: " + usuario.getEmail() +
                                  "Password: " + usuario.getPassword());
            }                             
        } catch (IOException e) {
            e.printStackTrace();
        }

        registerUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(registrarUsuario);
            }
        });

       login.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               if (!email.getText().toString().isEmpty() && !password.getText().toString().isEmpty()) {
                   String inputUsuario = email.getText().toString();
                   String inputPassword = password.getText().toString();

                   // Buscar el usuario coincidente en la lista de usuarios
                   for (User usuario : usuarios) {
                       if (usuario.getPassword().equals(inputPassword)) {
                           if ( usuario.getEmail().equals(inputUsuario) || usuario.getName().equals(inputUsuario)) {
                               // Si se encuentra una coincidencia, iniciar la actividad principal y salir del bucle
                               startActivity(home);
                               return;
                           }
                       }
                   }
                   // Si no se encontró una coincidencia, mostrar un mensaje de error utilizando Toast
                   Toast.makeText(getApplicationContext(), "Usuario y/o contraseña incorrectos", Toast.LENGTH_SHORT).show();
               }else{
                   Toast.makeText(getApplicationContext(), "Los campos no pueden estar vacíos",
                           Toast.LENGTH_SHORT).show();
               }
           }
       });


    }


}

