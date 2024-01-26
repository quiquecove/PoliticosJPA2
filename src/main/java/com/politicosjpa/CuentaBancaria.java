package com.politicosjpa;

import jakarta.persistence.*;

@Entity
@Embeddable
public class CuentaBancaria {
    @Id
    private int numCuentaBancaria;
    @Column
    private int saldo;
}
