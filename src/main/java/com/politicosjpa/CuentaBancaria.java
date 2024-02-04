package com.politicosjpa;

import jakarta.persistence.*;

@Embeddable
public class CuentaBancaria {
    private int numCuentaBancaria;
    private int saldo;

    public CuentaBancaria() {
    }

    public CuentaBancaria(int numCuentaBancaria, int saldo) {
        this.numCuentaBancaria = numCuentaBancaria;
        this.saldo = saldo;
    }



    public int getNumCuentaBancaria() {
        return numCuentaBancaria;
    }

    public void setNumCuentaBancaria(int numCuentaBancaria) {
        this.numCuentaBancaria = numCuentaBancaria;
    }

    public int getSaldo() {
        return saldo;
    }

    public void setSaldo(int saldo) {
        this.saldo = saldo;
    }
}
