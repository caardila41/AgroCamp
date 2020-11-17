package com.ard.agrocampo.Clases;

import java.io.Serializable;

public class Fecha implements Serializable {

    private  int dia;
    private  int mes;
    private  int anno;


    public Fecha(int dia, int mes, int anno) {
        this.dia = dia;
        this.mes = mes;
        this.anno = anno;
    }

    public Fecha() {
    }

    public int getDia() {
        return dia;
    }

    public void setDia(int dia) {
        this.dia = dia;
    }

    public int getMes() {
        return mes;
    }

    public void setMes(int mes) {
        this.mes = mes;
    }

    public int getAnno() {
        return anno;
    }

    public void setAnno(int anno) {
        this.anno = anno;
    }


    @Override
    public String toString() {
        return  anno +"-" + mes + "-" + dia;
    }


    //Método privado para comprobar si el año es bisiesto
    //Este método lo utiliza el método fechaCorrecta
    private boolean esBisiesto() {
        return (anno % 4 == 0 && anno % 100 != 0 || anno % 400 == 0);
    }

    //Método para comprobar si la fecha es correcta
    public boolean fechaCorrecta() {
        boolean diaCorrecto, mesCorrecto, añoCorrecto;
        añoCorrecto = anno > 0;
        mesCorrecto = mes >= 1 && mes <= 12;
        switch (mes) {
            case 2:
                if (esBisiesto()) {
                    diaCorrecto = dia >= 1 && dia <= 29;
                } else {
                    diaCorrecto = dia >= 1 && dia <= 28;
                }
                break;
            case 4:
            case 6:
            case 9:
            case 11:
                diaCorrecto = dia >= 1 && dia <= 30;
                break;
            default:
                diaCorrecto = dia >= 1 && dia <= 31;
        }
        return diaCorrecto && mesCorrecto && añoCorrecto;
    }




    //Método que modifica la fecha cambiándola por la del día siguiente
    public void sumardias(int day) {
        dia=dia+day;
        if (!fechaCorrecta()) {
            dia = 1;
            mes++;
            if (!fechaCorrecta()) {
                mes = 1;
                anno++;
            }

        }
    }


}
