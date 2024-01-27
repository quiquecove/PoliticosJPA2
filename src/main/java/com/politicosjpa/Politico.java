package com.politicosjpa;

import jakarta.persistence.*;

//add unique
@Entity
public class Politico {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String dni;

    @Column
    private String nombreApe;

    @Column
    private int edad;

    @Column
    private String estudios;

    @OneToOne(mappedBy = "nombre")
    private Partido partido;  // Agregamos la relación a la clase Partido



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


}
