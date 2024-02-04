package com.politicosjpa;

import jakarta.persistence.*;
import org.hibernate.annotations.GenericGenerator;

//add unique
@Entity
public class Politico {
    @Id
    @GeneratedValue(generator = "uuid2", strategy = GenerationType.AUTO)
    @GenericGenerator(name = "uuid2", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(columnDefinition = "CHAR(36)")
    private String dni;


    private String nombreApe;

    @Column
    private int edad;

    @Column
    private String estudios;

    @OneToOne(mappedBy = "presidente",cascade = CascadeType.PERSIST)
    private Partido partido;  // Agregamos la relación a la clase Partido

    public Politico() {

    }


    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getNombreApe() {
        return nombreApe;
    }

    public void setNombreApe(String nombreApe) {
        this.nombreApe = nombreApe;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getEstudios() {
        return estudios;
    }

    public void setEstudios(String estudios) {
        this.estudios = estudios;
    }

    public Partido getPartido() {
        return partido;
    }

    public void setPartido(Partido partido) {
        this.partido = partido;
    }

    public Politico(String nombreApe, int edad, String estudios, Partido partido) {
        this.nombreApe = nombreApe;
        this.edad = edad;
        this.estudios = estudios;
        this.partido = partido;
    }
}
