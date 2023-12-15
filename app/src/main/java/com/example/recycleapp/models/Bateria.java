package com.example.recycleapp.models;

public class Bateria {

    private float cantidad;
    private float precio;
    private String Tipo_bateria;
    public Bateria(float cantidad, float precio, String Tipo_bateria) {
        this.cantidad = cantidad;
        this.precio = precio;
        this.Tipo_bateria = Tipo_bateria;
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

    public String getTipo_bateria() {
        return Tipo_bateria;
    }

    public void setTipo_bateria(String Tipo_bateria) {
        this.Tipo_bateria = Tipo_bateria;
    }


}
