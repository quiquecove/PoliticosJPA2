package com.politicosjpa;

import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

@SpringBootApplication
public class PoliticosJpaApplication {

    public static void main(String[] args) {
        ApplicationContext ac = SpringApplication.run(PoliticosJpaApplication.class, args);

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("PoliticosJpaPU");
        EntityManager em = emf.createEntityManager();

        // Iniciar una transacción
        em.getTransaction().begin();

        // Crear un objeto Politico
        Politico politico = new Politico();
        politico.setNombreApe("PERRO SANXE");
        politico.setEdad(40);
        politico.setEstudios("Licenciatura en Ciencias Políticas");

        // Persistir el Politico en la base de datos
        em.persist(politico);

        // Commit de la transacción
        em.getTransaction().commit();

        // Cerrar el EntityManager y el EntityManagerFactory al finalizar
        em.close();
        emf.close();


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
