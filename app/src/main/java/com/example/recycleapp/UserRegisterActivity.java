package com.example.recycleapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class UserRegisterActivity extends AppCompatActivity {

    EditText nameR, emailR,passwordR,confirm_passwordR;
    Button registarUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_register);

        nameR.findViewById(R.id.editTextNombreRegistro);
        emailR.findViewById(R.id.editTextEmailRegistro);
        passwordR.findViewById(R.id.editTextContraseñaRegistro);
        confirm_passwordR.findViewById(R.id.editTextContraseña_Confirmacion_Registro);
        registarUser.findViewById(R.id.btn_registro);

        Intent usuarioregistrado = new Intent(getApplicationContext(), LoginActivity.class);

        registarUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(usuarioregistrado);
            }
        });

    }
}