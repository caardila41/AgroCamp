package com.ard.agrocampo.Clases;

public class Cultivos extends Proceso {


    private  double area;
    private Fecha fechainicio;
    private String proyectoNombre;

    public Cultivos(String nombre, String descripcion, String tipo, int Foto, double area, Fecha fechainicio, String proyectoNombre) {
        super(nombre, descripcion, tipo, Foto);
        this.area = area;
        this.fechainicio = fechainicio;
        this.proyectoNombre = proyectoNombre;
    }

    public Cultivos(double area, Fecha fechainicio, String proyectoNombre) {
        this.area = area;
        this.fechainicio = fechainicio;
        this.proyectoNombre = proyectoNombre;
    }

    public String getProyectoNombre() {
        return proyectoNombre;
    }

    public void setProyectoNombre(String proyectoNombre) {
        this.proyectoNombre = proyectoNombre;
    }

    public Cultivos(double area, Fecha fechainicio) {
        this.area = area;
        this.fechainicio = fechainicio;
    }

    public double getArea() {
        return area;
    }

    public void setArea(double area) {
        this.area = area;
    }

    public Fecha getFechainicio() {
        return fechainicio;
    }

    public void setFechainicio(Fecha fechainicio) {
        this.fechainicio = fechainicio;
    }
}
