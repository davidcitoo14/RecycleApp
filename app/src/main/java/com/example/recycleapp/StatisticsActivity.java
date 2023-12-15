package com.example.recycleapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import com.example.recycleapp.models.Bateria;
import com.example.recycleapp.models.Paper;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class StatisticsActivity extends AppCompatActivity {
    private TableLayout tableLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_statistics);
        tableLayout = findViewById(R.id.myTableLayout);
        Intent intent = new Intent(this, HomeActivity.class);

        //Carga de los archivos
        File batteryFile = new File(getFilesDir(), "Battery.txt");
        File paperFile = new File(getFilesDir(), "Paper.txt");


        List<Bateria> listabateria= leerArchivobateria( batteryFile);
        List<Paper> listaPaper = leerArchivoPaper(paperFile);

        //Crear la Tabla
        addElementBateria(listabateria);
        addElementPaper(listaPaper);
        addPromediopapel(listaPaper);
        addPromediobateria(listabateria);



    }
    private void addPromediobateria(List<Bateria> ListBattery){
        // Obtén una referencia al TableLayout en tu actividad o fragmento

        float PromedioCantidad = calcularPromedioCantidadBateria(ListBattery);
        float promedioPreciobateria = calcularPromedioPreciobateria(ListBattery);

        TableRow row = new TableRow(this);
        //AÑADE LA INFORMACIÓN A LA CELDA 1
        TextView cell1 = new TextView(this);
        cell1.setText("Bateria");
        cell1.setPadding(10, 10, 10, 10);
        cell1.setBackgroundResource(R.color.white); // Cambia R.color.tableCellBackground por el
        // color deseado

        //AÑADE LA INFORMACIÓN A LA CELDA 2
        TextView cell2 = new TextView(this);
        cell2.setText("BATERIAS");
        cell2.setPadding(10, 10, 10, 10);
        cell2.setBackgroundResource(R.color.white); // Cambia R.color.tableCellBackground por el color


        //AÑADE LA INFORMACIÓN A LA CELDA 3
        TextView cell3 = new TextView(this);
        cell3.setText(String.valueOf(promedioPreciobateria));
        cell3.setPadding(10, 10, 10, 10);
        cell3.setBackgroundResource(R.color.white); // Cambia R.color.tableCellBackground por
        // el color

        //AÑADE LA INFORMACIÓN A LA CELDA 4
        TextView cell4 = new TextView(this);
        cell4.setText(String.valueOf(PromedioCantidad));
        cell4.setPadding(10, 10, 10, 10);
        cell4.setBackgroundResource(R.color.white); // Cambia R.color.tableCellBackground por
        // el color

        // Agrega las celdas a la fila
        row.addView(cell1);
        row.addView(cell2);
        row.addView(cell3);
        row.addView(cell4);
        // Agrega la fila al TableLayout
        tableLayout.addView(row);
    }

    private void addPromediopapel(List<Paper> Listpaper){
        // Obtén una referencia al TableLayout en tu actividad o fragmento

        float promedioCantidadPaper= calcularPromedioCantidadPaper(Listpaper);
        float promedioPrecioPapel = calcularPromedioPrecioPaper(Listpaper);

        TableRow row = new TableRow(this);
        //AÑADE LA INFORMACIÓN A LA CELDA 1
        TextView cell1 = new TextView(this);
        cell1.setText("Promedio");
        cell1.setPadding(10, 10, 10, 10);
        cell1.setBackgroundResource(R.color.white); // Cambia R.color.tableCellBackground por el
        // color deseado

        //AÑADE LA INFORMACIÓN A LA CELDA 2
        TextView cell2 = new TextView(this);
        cell2.setText("PAPEL");
        cell2.setPadding(10, 10, 10, 10);
        cell2.setBackgroundResource(R.color.white); // Cambia R.color.tableCellBackground por el color


        //AÑADE LA INFORMACIÓN A LA CELDA 3
        TextView cell3 = new TextView(this);
        cell3.setText(String.valueOf(promedioCantidadPaper));
        cell3.setPadding(10, 10, 10, 10);
        cell3.setBackgroundResource(R.color.white); // Cambia R.color.tableCellBackground por
        // el color

        //AÑADE LA INFORMACIÓN A LA CELDA 4
        TextView cell4 = new TextView(this);
        cell4.setText(String.valueOf(promedioPrecioPapel));
        cell4.setPadding(10, 10, 10, 10);
        cell4.setBackgroundResource(R.color.white); // Cambia R.color.tableCellBackground por
        // el color

        // Agrega las celdas a la fila
        row.addView(cell1);
        row.addView(cell2);
        row.addView(cell3);
        row.addView(cell4);
        // Agrega la fila al TableLayout
        tableLayout.addView(row);
    }

    private void addElementBateria(List<Bateria> ListaBateria){
        // Obtain una referencia al TableLayout en tu actividad o fragmento

        for (Bateria item: ListaBateria) {
            // Crea una nueva fila y agrega las celdas
            TableRow row = new TableRow(this);
            //AÑADE LA INFORMACIÓN A LA CELDA 1
            TextView cell1 = new TextView(this);
            cell1.setText(item.getTipo_bateria());

            cell1.setPadding(10, 10, 10, 10);
            cell1.setBackgroundResource(R.color.white); // Cambia R.color.tableCellBackground por el
            // color deseado

            //AÑADE LA INFORMACIÓN A LA CELDA 2
            TextView cell2 = new TextView(this);
            cell2.setText("bateria");
            cell2.setPadding(10, 10, 10, 10);
            cell2.setBackgroundResource(R.color.white); // Cambia R.color.tableCellBackground por el color


            //AÑADE LA INFORMACIÓN A LA CELDA 3
            TextView cell3 = new TextView(this);
            cell3.setText(String.valueOf((item.getCantidad())));
            cell3.setPadding(10, 10, 10, 10);
            cell3.setBackgroundResource(R.color.white); // Cambia R.color.tableCellBackground por
            // el color

            //AÑADE LA INFORMACIÓN A LA CELDA 4
            TextView cell4 = new TextView(this);
            cell4.setText(String.valueOf((item.getPrecio())));
            cell4.setPadding(10, 10, 10, 10);
            cell4.setBackgroundResource(R.color.white); // Cambia R.color.tableCellBackground por
            // el color

            // Agrega las celdas a la fila
            row.addView(cell1);
            row.addView(cell2);
            row.addView(cell3);
            row.addView(cell4);
            // Agrega la fila al TableLayout
            tableLayout.addView(row);
        }
    }

    private void addElementPaper(List<Paper> paperList){
        // Obtén una referencia al TableLayout en tu actividad o fragmento

        for (Paper item: paperList) {
            // Crea una nueva fila y agrega las celdas
            TableRow row = new TableRow(this);
            //AÑADE LA INFORMACIÓN A LA CELDA 1
            TextView cell1 = new TextView(this);
            cell1.setText(item.getTipo_papel());

            cell1.setPadding(10, 10, 10, 10);
            cell1.setBackgroundResource(R.color.white); // Cambia R.color.tableCellBackground por el
            // color deseado

            //AÑADE LA INFORMACIÓN A LA CELDA 2
            TextView cell2 = new TextView(this);

            cell2.setText("paper");
            cell2.setPadding(10, 10, 10, 10);
            cell2.setBackgroundResource(R.color.white); // Cambia R.color.tableCellBackground por el color


            //AÑADE LA INFORMACIÓN A LA CELDA 3
            TextView cell3 = new TextView(this);
            cell3.setText(String.valueOf((item.getCantidad())));
            cell3.setPadding(10, 10, 10, 10);
            cell3.setBackgroundResource(R.color.white); // Cambia R.color.tableCellBackground por
            // el color

            //AÑADE LA INFORMACIÓN A LA CELDA 4
            TextView cell4 = new TextView(this);
            cell4.setText(String.valueOf((item.getPrecio())));
            cell4.setPadding(10, 10, 10, 10);
            cell4.setBackgroundResource(R.color.white); // Cambia R.color.tableCellBackground por
            // el color

            // Agrega las celdas a la fila
            row.addView(cell1);
            row.addView(cell2);
            row.addView(cell3);
            row.addView(cell4);
            // Agrega la fila al TableLayout
            tableLayout.addView(row);
        }
    }

    private static List<Bateria> leerArchivobateria(File archivo) {
        List<Bateria> listaBateria = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] datos = linea.split(",");
                float cantidad = Float.parseFloat(datos[0]);
                float precio = Float.parseFloat(datos[1]);
                String Tipo_bateria = datos[2];

                Bateria bateria = new Bateria(cantidad, precio, Tipo_bateria);
                listaBateria.add(bateria);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return listaBateria;
    }

    private static List<Paper> leerArchivoPaper(File archivo) {
        List<Paper> listaPaper = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] datos = linea.split(",");
                float cantidad = Float.parseFloat(datos[0]);
                float precio = Float.parseFloat(datos[1]);
                String Tipo_Papel = datos[2];

                Paper paper = new Paper(cantidad, precio, Tipo_Papel);
                listaPaper.add(paper);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return listaPaper;
    }

    private float calcularPromedioCantidadPaper(List<Paper> Listpaper) {
        float sum = 0;
        for (Paper item : Listpaper) {
            sum += item.getCantidad();
        }
        return sum / Listpaper.size();
    }
    private float calcularPromedioPrecioPaper(List<Paper> Listpaper) {
        float sum = 0;
        for (Paper item : Listpaper) {
            sum += item.getPrecio();
        }
        return sum / Listpaper.size();
    }

    private float calcularPromedioCantidadBateria(List<Bateria> ListBattery) {
        float sum = 0;
        for (Bateria item : ListBattery) {
            sum += item.getCantidad();
        }
        return sum / ListBattery.size();
    }

    private float calcularPromedioPreciobateria(List<Bateria> Listbattery) {
        float sum = 0;
        for (Bateria item : Listbattery) {
            sum += item.getPrecio();
        }
        return sum / Listbattery.size();
    }
}














































































