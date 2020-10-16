package com.ard.agrocampo.ui.Noticias.Models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Articulo {

    @SerializedName("Fuente")
    @Expose
    private Source Fuente;

    @SerializedName("Autor")
    @Expose
    private String Autor;

    @SerializedName("Titulo")
    @Expose
    private String Titulo;

    @SerializedName("Descripcion")
    @Expose
    private String Descripcion;

    @SerializedName("url")
    @Expose
    private String url;

    @SerializedName("urlToImage")
    @Expose
    private String urlToImage;

    @SerializedName("status")
    @Expose
    private String status;

    @SerializedName("Publicado")
    @Expose
    private String Publicado;

    public Source getFuente() {
        return Fuente;
    }

    public void setFuente(Source fuente) {
        Fuente = fuente;
    }

    public String getAutor() {
        return Autor;
    }

    public void setAutor(String autor) {
        Autor = autor;
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

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUrlToImage() {
        return urlToImage;
    }

    public void setUrlToImage(String urlToImage) {
        this.urlToImage = urlToImage;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getPublicado() {
        return Publicado;
    }

    public void setPublicado(String publicado) {
        Publicado = publicado;
    }
}
