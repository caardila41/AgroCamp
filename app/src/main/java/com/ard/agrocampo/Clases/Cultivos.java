package com.ard.agrocampo.Clases;

import java.io.Serializable;

public class Cultivos extends Proceso implements Serializable {


    private  double area;
    private Fecha fechainicio;
    private String proyectoNombre;

    public Cultivos(String nombre, String descripcion, String tipo, int Foto, double area, Fecha fechainicio, String proyectoNombre) {
        super(nombre, descripcion, tipo, Foto);
        this.area = area;
        this.fechainicio = fechainicio;
        this.proyectoNombre = proyectoNombre;
    }

    public Cultivos(String nombre, String descripcion, String tipo, int Foto) {
        super(nombre, descripcion, tipo, Foto);
    }



    public String getProyectoNombre() {
        return proyectoNombre;
    }


    public double getArea() {
        return area;
    }



    public Fecha getFechainicio() {
        return fechainicio;
    }


    public void setArea(double area) {
        this.area = area;
    }

    public void setFechainicio(Fecha fechainicio) {
        this.fechainicio = fechainicio;
    }

    public void setProyectoNombre(String proyectoNombre) {
        this.proyectoNombre = proyectoNombre;
    }
}
