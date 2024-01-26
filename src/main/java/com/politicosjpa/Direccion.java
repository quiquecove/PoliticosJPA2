package com.politicosjpa;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
@Embeddable
public class Direccion {
    @Column
    private String tipoVia;
    @Id
    private String nombreVia;
    @Column
    private int numero;


}


