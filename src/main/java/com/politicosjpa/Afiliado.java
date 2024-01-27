package com.politicosjpa;

import jakarta.persistence.*;

@Entity
public class Afiliado {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String dni;


    @ManyToOne
    @JoinColumn(name = "partido", referencedColumnName = "nombre")
    private Partido partido;

    @Column
    private int salarioAnual;

    @Column
    private int aportacionAnual;

    @Embedded
    private CuentaBancaria cuentaBancaria;
    @Embedded
    private Direccion direccion;

    public Afiliado() {
    }

    public Afiliado(String dni, Partido partido, int salarioAnual, int aportacionAnual, CuentaBancaria cuentaBancaria, Direccion direccion) {
        this.dni = dni;
        this.partido = partido;
        this.salarioAnual = salarioAnual;
        this.aportacionAnual = aportacionAnual;
        this.cuentaBancaria = cuentaBancaria;
        this.direccion = direccion;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public Partido getPartido() {
        return partido;
    }

    public void setPartido(Partido partido) {
        this.partido = partido;
    }

    public int getSalarioAnual() {
        return salarioAnual;
    }

    public void setSalarioAnual(int salarioAnual) {
        this.salarioAnual = salarioAnual;
    }

    public int getAportacionAnual() {
        return aportacionAnual;
    }

    public void setAportacionAnual(int aportacionAnual) {
        this.aportacionAnual = aportacionAnual;
    }

    public CuentaBancaria getCuentaBancaria() {
        return cuentaBancaria;
    }

    public void setCuentaBancaria(CuentaBancaria cuentaBancaria) {
        this.cuentaBancaria = cuentaBancaria;
    }

    public Direccion getDireccion() {
        return direccion;
    }

    public void setDireccion(Direccion direccion) {
        this.direccion = direccion;
    }
}
