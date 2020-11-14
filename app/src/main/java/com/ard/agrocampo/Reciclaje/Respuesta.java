package com.ard.agrocampo.Reciclaje;

public class Respuesta {
    private String cuestion, respuesta;

    public Respuesta() {
    }

    public Respuesta(String cuestion, String respuesta) {
        this.cuestion = cuestion;
        this.respuesta = respuesta;
    }

    public String getCuestion() {
        return cuestion;
    }

    public String getRespuesta() {
        return respuesta;
    }
}
