package com.ard.agrocampo.ui.Tienda;

public class Catalogo {
    private String Nombreproducto;
    private String precio;
    private String categoria;
    private float calidad;
    private int fotoproducto;

    public Catalogo() {
    }

    public Catalogo(String nombreproducto, String precio, String categoria, float calidad, int fotoproducto) {
        Nombreproducto = nombreproducto;
        this.precio = precio;
        this.categoria = categoria;
        this.calidad = calidad;
        this.fotoproducto = fotoproducto;
    }

    public String getNombreproducto() {
        return Nombreproducto;
    }

    public void setNombreproducto(String nombreproducto) {
        Nombreproducto = nombreproducto;
    }

    public String getPrecio() {
        return precio;
    }

    public void setPrecio(String precio) {
        this.precio = precio;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public float getCalidad() {
        return calidad;
    }

    public void setCalidad(float calidad) {
        this.calidad = calidad;
    }

    public int getFotoproducto() {
        return fotoproducto;
    }

    public void setFotoproducto(int fotoproducto) {
        this.fotoproducto = fotoproducto;
    }
}