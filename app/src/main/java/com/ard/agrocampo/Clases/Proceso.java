package com.ard.agrocampo.Clases;


import java.io.Serializable;

public class Proceso implements Serializable {

    private String nombre;
    private String descripcion;
    private String tipo;
    private int foto;



    public Proceso(String nombre, String descripcion, String tipo,int Foto) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.tipo = tipo;
        this.foto=Foto;
    }

    public Proceso() {

    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getFoto() {
        return foto;
    }

    public void setFoto(int foto) {
        this.foto = foto;
    }


}
