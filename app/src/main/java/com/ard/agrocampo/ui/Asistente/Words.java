package com.ard.agrocampo.ui.Asistente;

public class Words {

    String Palabra, Numerobusqueda;

    public Words(String palabra, String numerobusqueda) {
        Palabra = palabra;
        Numerobusqueda = numerobusqueda;
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
}
