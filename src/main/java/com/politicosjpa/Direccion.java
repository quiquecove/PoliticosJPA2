package com.politicosjpa;

import jakarta.persistence.*;


@Embeddable
public class Direccion {
    private String tipoVia;

    private String nombreVia;
    @Column
    private int numero;

    public String getTipoVia() {
        return tipoVia;
    }

    public void setTipoVia(String tipoVia) {
        this.tipoVia = tipoVia;
    }

    public String getNombreVia() {
        return nombreVia;
    }

    public void setNombreVia(String nombreVia) {
        this.nombreVia = nombreVia;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public Direccion() {
    }

    public Direccion(String tipoVia, String nombreVia, int numero) {
        this.tipoVia = tipoVia;
        this.nombreVia = nombreVia;
        this.numero = numero;
    }
}


