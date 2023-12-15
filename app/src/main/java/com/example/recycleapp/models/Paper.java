package com.example.recycleapp.models;

public class Paper {
    private float cantidad;
    private float precio;
    private String Tipo_papel;

    public Paper(float cantidad, float precio, String tipo_papel) {
        this.cantidad = cantidad;
        this.precio = precio;
        Tipo_papel = tipo_papel;
    }

    public float getCantidad() {
        return cantidad;
    }

    public void setCantidad(float cantidad) {
        this.cantidad = cantidad;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    public String getTipo_papel() {
        return Tipo_papel;
    }

    public void setTipo_papel(String tipo_papel) {
        Tipo_papel = tipo_papel;
    }
}
