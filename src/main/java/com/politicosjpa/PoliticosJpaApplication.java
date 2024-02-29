package com.politicosjpa;

import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import jakarta.persistence.EntityManager;

@SpringBootApplication
public class PoliticosJpaApplication {

    public static void main(String[] args) {
        ApplicationContext ac = SpringApplication.run(PoliticosJpaApplication.class, args);

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("PoliticosJpaPU");
        EntityManager em = emf.createEntityManager();

        // Iniciar una transacción
        em.getTransaction().begin();


        // Crear un objeto Politico
//        Politico politico = new Politico();
//        politico.setNombreApe("PERRO SANXxxE");
//        politico.setEdad(40);
//        politico.setEstudios("Jovenes de jovenlandia");

        // Persistir el Politico en la base de datos
        //em.persist(politico);
        //crear partido
        Partido partido = new Partido();
        partido.setNombre("PSOE");
        partido.setPresidente(new Politico("Perro Xanchez", 40, "Jovenes de jovenlandia", partido));
        partido.setEscannos(100);
        //em.persist(partido);


        Partido partidoVox = new Partido();
        partidoVox.setNombre("VOX");
        partidoVox.setPresidente(new Politico("Santiago Abascal", 49, "Filologia hispanica", partidoVox));
        partidoVox.setEscannos(170);  // Ajusta el número de escaños según sea necesario

        //em.persist(partidoVox);

        Partido partidoPopular = new Partido();
        partidoPopular.setNombre("PP");
        partidoPopular.setPresidente(new Politico("Feijoo", 69, "Fariña", partidoPopular));
        partidoPopular.setEscannos(136);  // Ajusta el número de escaños según sea necesario

//        em.persist(partidoPopular);

        Partido partidoRestar = new Partido();
        partidoRestar.setNombre("Restar");
        partidoRestar.setPresidente(new Politico("Yoli", 39, "Welcome Jovenes de jovenlandia", partidoRestar));
        partidoRestar.setEscannos(0);  // Ajusta el número de escaños según sea necesario

        //em.persist(partidoRestar);

        Direccion direccion = new Direccion("Calle", "Calle si", 1);
        Afiliado ana = new Afiliado(partidoPopular, 13120, 1000, new CuentaBancaria(1234567890, 3000), direccion);
//        em.persist(ana);

        Afiliado beatriz = new Afiliado(partidoPopular, 30000, 1000, new CuentaBancaria(1234567890, 4), direccion);
//        em.persist(beatriz);
        // Commit de la transacción
//        em.getTransaction().commit();

//modificar afiliado

        // Buscar el afiliado que deseas modificar  el salario por su DNI
        String dniAfiliadoModificar = "429e4285-746f-45f0-81d3-8ad0a83a39e4";
        Afiliado afiliadoModificar = em.find(Afiliado.class, dniAfiliadoModificar);
        afiliadoModificar.setSalarioAnual(15120);//smi

        //em.merge(afiliadoModificar);

        //buscar afiliados del pp por su nombre
        String nombrePartido = "PP";
        Partido partidoAfiliados = em.createQuery("SELECT p FROM Partido p WHERE p.nombre = :nombre", Partido.class)
                .setParameter("nombre", nombrePartido)
                .getSingleResult();
        System.out.println("Afiliados del partido " + nombrePartido + ":");
        for (Afiliado afiliado : partidoAfiliados.getAfiliados()) {
            System.out.println(afiliado.toString());
        }


        // Crear un objeto Partido
        Partido nuevoPartido = new Partido();
        nuevoPartido.setNombre("Nuevo Partido");
        nuevoPartido.setPresidente(new Politico("Nombre Presidente", 50, "Estudios Presidente", nuevoPartido));
        nuevoPartido.setEscannos(50);

// Persistir el Partido en la base de datos
        em.getTransaction().begin();
        em.persist(nuevoPartido);
        em.getTransaction().commit();
        System.out.println("Nuevo partido creado: " + nuevoPartido.getNombre());


// Buscar el partido que deseas actualizar por su nombre
        String nombrePartidoActualizar = "PP";
        Partido partidoActualizar = em.createQuery("SELECT p FROM Partido p WHERE p.nombre = :nombre", Partido.class)
                .setParameter("nombre", nombrePartidoActualizar)
                .getSingleResult();

// Actualizar el partido
        em.getTransaction().begin();
        partidoActualizar.setEscannos(150); // Actualiza el número de escaños
        em.getTransaction().commit();
        System.out.println("Partido actualizado: " + partidoActualizar.getNombre());


// Buscar el partido que deseas eliminar por su nombre
        String nombrePartidoEliminar = "Restar";
        Partido partidoEliminar = em.createQuery("SELECT p FROM Partido p WHERE p.nombre = :nombre", Partido.class)
                .setParameter("nombre", nombrePartidoEliminar)
                .getSingleResult();

// Eliminar el partido
        em.getTransaction().begin();
        em.remove(partidoEliminar);
        em.getTransaction().commit();
        System.out.println("Partido eliminado: " + nombrePartidoEliminar);


        //borrar partido pp

//        String nombrePartidoEliminar = "PP";
//        Partido partidoEliminar = em.createQuery("SELECT p FROM Partido p WHERE p.nombre = :nombre", Partido.class)
//                .setParameter("nombre", nombrePartidoEliminar)
//                .getSingleResult();

        // Buscar el partido que deseas eliminar por su nombre
//        String nombrePartidoEliminar = "Restar";
//        Partido partidoEliminar = em.find(Partido.class, nombrePartidoEliminar);

//
        //em.remove(partidoEliminar);


//            System.out.println("Partido eliminado: " + nombrePartidoEliminar);


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
