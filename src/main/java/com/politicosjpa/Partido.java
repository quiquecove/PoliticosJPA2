package com.politicosjpa;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Partido {
    @Id
    private String nombre;
    @Column
    private int escannos;
    @OneToOne
    @JoinColumn(name = "fk_id_cliente", referencedColumnName = "dni")
    private Politico presidente;
    @OneToMany
    @JoinColumn(name = "fk_id_cliente", referencedColumnName = "dni")
    private List<Afiliado> afiliados;

}
