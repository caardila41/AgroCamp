package com.ard.agrocampo.ui.Asistente;

import java.io.Serializable;

public class Words implements Serializable {

    String Palabra, Numerobusqueda;
    int imagendetalle;
    String Titulo, Descripcion, Fuente, Nutrientes, Procesamiento;

    public Words() {
    }

    public Words(String palabra, String numerobusqueda, int imagendetalle, String titulo, String descripcion, String fuente, String nutrientes, String procesamiento) {
        Palabra = palabra;
        Numerobusqueda = numerobusqueda;
        this.imagendetalle = imagendetalle;
        Titulo = titulo;
        Descripcion = descripcion;
        Fuente = fuente;
        Nutrientes = nutrientes;
        Procesamiento = procesamiento;
    }

    public String getPalabra() {
        return Palabra;
    }

    public void setPalabra(String palabra) {
        Palabra = palabra;
    }

    public String getNumerobusqueda() {
        return Numerobusqueda;
    }

    public void setNumerobusqueda(String numerobusqueda) {
        Numerobusqueda = numerobusqueda;
    }

    public int getImagendetalle() {
        return imagendetalle;
    }

    public void setImagendetalle(int imagendetalle) {
        this.imagendetalle = imagendetalle;
    }

    public String getTitulo() {
        return Titulo;
    }

    public void setTitulo(String titulo) {
        Titulo = titulo;
    }

    public String getDescripcion() {
        return Descripcion;
    }

    public void setDescripcion(String descripcion) {
        Descripcion = descripcion;
    }

    public String getFuente() {
        return Fuente;
    }

    public void setFuente(String fuente) {
        Fuente = fuente;
    }

    public String getNutrientes() {
        return Nutrientes;
    }

    public void setNutrientes(String nutrientes) {
        Nutrientes = nutrientes;
    }

    public String getProcesamiento() {
        return Procesamiento;
    }

    public void setProcesamiento(String procesamiento) {
        Procesamiento = procesamiento;
    }
}

