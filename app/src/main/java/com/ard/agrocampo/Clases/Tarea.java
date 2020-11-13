package com.ard.agrocampo.Clases;

import android.text.Editable;

public class Tarea {

    private  String nombre,descripcion;
    private Fecha fechaDesde,fechaHasta;


    public Tarea(String nombre, String descripcion, Fecha fechaDesde, Fecha fechaHasta) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.fechaDesde = fechaDesde;
        this.fechaHasta = fechaHasta;

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

    public Fecha getFechaDesde() {
        return fechaDesde;
    }

    public void setFechaDesde(Fecha fechaDesde) {
        this.fechaDesde = fechaDesde;
    }

    public Fecha getFechaHasta() {
        return fechaHasta;
    }

    public void setFechaHasta(Fecha fechaHasta) {
        this.fechaHasta = fechaHasta;
    }




}
