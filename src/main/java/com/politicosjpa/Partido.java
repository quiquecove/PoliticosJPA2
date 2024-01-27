package com.politicosjpa;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Partido {

    @Id
    @JoinColumn(name = "partido", referencedColumnName = "partido")
    private String nombreApe;

    @Column
    private int escannos;

    @OneToOne
    private Politico presidente;

    @OneToMany(mappedBy = "partido")
    private List<Afiliado> afiliados;

    public String getNombreApe() {
        return nombreApe;
    }

    public void setNombreApe(String nombre) {
        this.nombreApe = nombre;
    }

    public int getEscannos() {
        return escannos;
    }

    public void setEscannos(int escannos) {
        this.escannos = escannos;
    }

    public Politico getPresidente() {
        return presidente;
    }

    public void setPresidente(Politico presidente) {
        this.presidente = presidente;
    }

    public List<Afiliado> getAfiliados() {
        return afiliados;
    }

    public void setAfiliados(List<Afiliado> afiliados) {
        this.afiliados = afiliados;
    }

    public Partido() {
    }

    public Partido(String nombre, int escannos, Politico presidente, List<Afiliado> afiliados) {
        this.nombreApe = nombre;
        this.escannos = escannos;
        this.presidente = presidente;
        this.afiliados = afiliados;
    }
}
