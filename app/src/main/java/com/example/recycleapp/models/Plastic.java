package com.example.recycleapp.models;

public class Plastic {
    private float cantidad;
    private float precio;
    private String Tipo_plastico;
    public Plastic(float cantidad, float precio, String tipo_plastico) {
        this.cantidad = cantidad;
        this.precio = precio;
        Tipo_plastico = tipo_plastico;

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

    public String getTipo_plastico() {
        return Tipo_plastico;
    }

    public void setTipo_plastico(String tipo_plastico) {
        Tipo_plastico = tipo_plastico;
    }


}
