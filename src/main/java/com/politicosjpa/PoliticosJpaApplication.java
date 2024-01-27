package com.politicosjpa;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

@SpringBootApplication
public class PoliticosJpaApplication {

    public static void main(String[] args) {
        SpringApplication.run(PoliticosJpaApplication.class, args);
    }

//    @Bean
//    public CommandLineRunner demo(PoliticoDao politicoRepository) {
//        return (args) -> {
//            // Crear una instancia de Politico
//            Politico politico = new Politico();
//            politico.setNombreApe("Nombre Apellido");
//            politico.setEdad(40);
//            politico.setEstudios("Licenciatura en Ciencias Políticas");
//
//            // Guardar el político en la base de datos
//            politicoRepository.save(politico);
//
//            System.out.println("Político guardado exitosamente con ID: " + politico.getDni());
//        };
//    }
}
