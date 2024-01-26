package com.politicosjpa;

import jakarta.persistence.*;

@Entity
public class Afiliado {

    @Id
    private String dni;

    private Partido partido;
    @Column
    private int salarioAnual;
    @Column
    private int aportacionAnual;
    @Column
    @Embedded
    private CuentaBancaria cuentaBancaria;
    @Column
    @Embedded
    private Direccion direccion;

}
