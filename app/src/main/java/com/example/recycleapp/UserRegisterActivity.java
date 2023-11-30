package com.example.recycleapp;

import static java.lang.Thread.sleep;

import androidx.appcompat.app.AppCompatActivity;
import com.example.recycleapp.models.User;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;

public class UserRegisterActivity extends AppCompatActivity {

    EditText nameR, emailR, passwordR, confirm_passwordR;
    Button registarUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_register);

        nameR = findViewById(R.id.editTextNombreRegistro);
        emailR = findViewById(R.id.editTextEmailRegistro);
        passwordR = findViewById(R.id.editTextContraseñaRegistro);
        confirm_passwordR = findViewById(R.id.editTextContraseña_Confirmacion_Registro);
        registarUser = findViewById(R.id.btn_registroBat);

        Intent usuarioregistrado = new Intent(getApplicationContext(), LoginActivity.class);
        Intent login= new Intent(getApplicationContext(),
                MainActivity.class);
        registarUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(validateUser()){
                    User user=recyclerUser();
                    lookUser(user);
                    Toast.makeText(getApplicationContext(),
                            "Registro Exitoso",Toast.LENGTH_LONG).show();
                    try {
                        sleep(500);
                        startActivity(login);
                        finish();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }

                }else{
                    Toast.makeText(getApplicationContext(),
                            "Todos los campos deben estar diligenciados",Toast.LENGTH_LONG).show();
                }
            }

        });

    }

    public boolean validateUser() {
        boolean validate = true;
        if (nameR.getEditableText().toString().isEmpty()) {
            nameR.setBackgroundColor(Color.RED);
            validate = false;
        }
        if (emailR.getEditableText().toString().isEmpty()) {
            emailR.setBackgroundColor(Color.RED);
            validate = false;
        }
        if (passwordR.getEditableText().toString().isEmpty()) {
            passwordR.setBackgroundColor(Color.RED);
            validate = false;
        }
        if (confirm_passwordR.getEditableText().toString().isEmpty()) {
            confirm_passwordR.setBackgroundColor(Color.RED);
            validate = false;
        }
        return validate;
    }

    public User recyclerUser() {
        String nameUs, emailUs, passwordUs;
        nameUs = nameR.getEditableText().toString();
        emailUs = emailR.getEditableText().toString();
        passwordUs = passwordR.getEditableText().toString();
        User usuario = new User(nameUs, emailUs, passwordUs);

        return usuario;

    }
      public void lookUser (User usuario){
          File fileUser=new File(getFilesDir(), "usuario.txt");


          try {
              //Se define el FileWriter
              FileWriter writer=new FileWriter(fileUser,true);
              //BufferedWriter se utiliza para almacenar muchos datos (recomendado)
              //Buffer es un espacio de memoria temporal que nos permite realizar multiples transacciones de datos de forma má rápida
              BufferedWriter bufferedWriter= new BufferedWriter(writer);
              bufferedWriter.write(

                              usuario.getName()+","+
                              usuario.getEmail()+","+
                              usuario.getPassword()
              );
              bufferedWriter.newLine();
              bufferedWriter.close();
          }catch (Exception error){
              error.printStackTrace();
          }
      }

    }



