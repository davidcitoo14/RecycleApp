package com.example.recycleapp.models;

public class Vidrio {
    private float cantidadKg;
    private float precio;
    private String Tipo_Vidrio;

    public Vidrio(float cantidadKg, float precio, String tipo_Vidrio) {
        this.cantidadKg = cantidadKg;
        this.precio = precio;
        Tipo_Vidrio = tipo_Vidrio;
    }

    public float getCantidadKg() {
        return cantidadKg;
    }

    public void setCantidadKg(float cantidadKg) {
        this.cantidadKg = cantidadKg;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    public String getTipo_Vidrio() {
        return Tipo_Vidrio;
    }

    public void setTipo_Vidrio(String tipo_Vidrio) {
        Tipo_Vidrio = tipo_Vidrio;
    }
}
