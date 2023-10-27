package com.example.recycleapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

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

        Intent home = new Intent(getApplicationContext(), HomeActivity.class);
        Intent registrarUsuario = new Intent(getApplicationContext(), UserRegisterActivity.class);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(home);
            }
        });

        registerUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(registrarUsuario);
            }
        });

    }
}