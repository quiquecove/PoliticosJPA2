package com.politicosjpa;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Partido {

    @Id
    @JoinColumn(name = "partido", referencedColumnName = "partido")
    private String nombre;

    @Column
    private int escannos;

    @OneToOne(cascade = CascadeType.PERSIST)
    private Politico presidente;

    @OneToMany(mappedBy = "partido", cascade = CascadeType.PERSIST)
    private List<Afiliado> afiliados;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
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
        this.nombre = nombre;
        this.escannos = escannos;
        this.presidente = presidente;
        this.afiliados = afiliados;
    }
}
