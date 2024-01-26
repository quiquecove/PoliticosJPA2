package com.politicosjpa;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Table(name = "politicos")//add unique
@Entity
public class Politico {
    @Id
    private String dni;
    @Column
    private String nombreApe;
    @Column
    private int edad;
    @Column
    private String estudios;

}
