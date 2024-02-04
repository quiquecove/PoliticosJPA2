package com.politicosjpa;

import jakarta.persistence.*;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

@Entity
public class Afiliado {

    @Id
    @GeneratedValue(generator = "uuid2", strategy = GenerationType.AUTO)
    @GenericGenerator(name = "uuid2", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(columnDefinition = "CHAR(36)")
    private String dni;


    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "nombre")
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

    public Afiliado(Partido partido, int salarioAnual, int aportacionAnual, CuentaBancaria cuentaBancaria, Direccion direccion) {
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

    @Override
    public String toString() {
        return "Afiliado{" +
                "dni='" + dni + '\'' +
                ", partido=" + partido +
                ", salarioAnual=" + salarioAnual +
                ", aportacionAnual=" + aportacionAnual +
                ", cuentaBancaria=" + cuentaBancaria +
                ", direccion=" + direccion +
                '}';
    }
}

