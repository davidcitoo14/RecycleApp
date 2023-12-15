package com.example.recycleapp;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

/** @noinspection MoveFieldAssignmentToInitializer*/
public class MainActivity extends AppCompatActivity {

    Button inicio;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        File file1 = new File(getFilesDir(), "usuario.txt");
        try {
            FileWriter writer = new FileWriter(file1);
            writer.append("root,root@root.com,toor,TOOR\n");
            writer.flush();
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        File file2 = new File(getFilesDir(), "Paper.txt");
        try {
            FileWriter writer = new FileWriter(file2);
            writer.append("15,150000,enero\n");
            writer.flush();
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        File file3 = new File(getFilesDir(), "Plastic.txt");
        try {
            FileWriter writer = new FileWriter(file3);
            writer.append("15,150000,enero\n");
            writer.flush();
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        File file4 = new File(getFilesDir(), "Battery.txt");
        try {
            FileWriter writer = new FileWriter(file3);
            writer.append("15,150000,enero\n");
            writer.flush();
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        File file5 = new File(getFilesDir(), "Vidrio.txt");
        try {
            FileWriter writer = new FileWriter(file3);
            writer.append("15,150000,enero\n");
            writer.flush();
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        inicio=findViewById(R.id.btn_inicio);

        Intent empezar = new Intent(getApplicationContext(), LoginActivity.class);

        inicio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(empezar);
            }

        });


       // Intent intent = new Intent(this, LoginActivity.class);
      //  startActivity(intent);
    }
}