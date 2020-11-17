package com.ard.agrocampo.ui.Tienda;

import java.io.Serializable;

public class Catalogo implements Serializable {
    private String Nombreproducto;
    private String precio;
    private String categoria;
    private String descripcionproducto;
    private float calidad;
    private int fotoproducto;
    private String URL;

    public Catalogo() {
    }

    public Catalogo(String nombreproducto, String precio, String categoria, String descripcionproducto, float calidad, int fotoproducto , String URL) {
        Nombreproducto = nombreproducto;
        this.precio = precio;
        this.categoria = categoria;
        this.descripcionproducto = descripcionproducto;
        this.calidad = calidad;
        this.fotoproducto = fotoproducto;
        this.URL = URL;
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

    public String getDescripcionproducto() {
        return descripcionproducto;
    }

    public void setDescripcionproducto(String descripcionproducto) {
        this.descripcionproducto = descripcionproducto;
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

    public String getURL() {
        return URL;
    }

    public void setURL(String URL) {
        this.URL = URL;
    }
}