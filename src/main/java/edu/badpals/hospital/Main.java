package edu.badpals.hospital;

import edu.badpals.hospital.entities.*;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("default");
        EntityManager em = emf.createEntityManager();

        /****************************** TURNOS **************************/

        Turno turno_mañana = new Turno(Horario.MAÑANA);
        Turno turno_tarde = new Turno(Horario.TARDE);
        Turno turno_noche = new Turno(Horario.NOCHE);

        /****************************** PLANTAS **************************/

        Planta planta_baja = new Planta(0);
        Planta planta_uno = new Planta(1);
        Planta sotano_uno = new Planta(-1);

        em.getTransaction().begin();
        em.persist(planta_baja);
        em.persist(planta_uno);
        em.persist(sotano_uno);
        em.getTransaction().commit();

        /****************************** CONSULTAS **************************/

        Consulta consulta_1 = new Consulta(60,planta_baja);
        Consulta consulta_2 = new Consulta(70,planta_uno);
        Consulta consulta_3 = new Consulta(50,sotano_uno);

        /****************************** DIRECCIONES **************************/
        Direccion direccion1 = new Direccion("Un sala de escobas", "Madrid", "28001", "España");
        Direccion direccion2 = new Direccion("Debajo del puente", "Sevilla", "41001", "España");

        /****************************** MEDICOS **************************/

        Medico medico1 = new Medico("12345678A","111111111","Ana Médico",direccion1,"666111666",consulta_1);
        Medico medico2 = new Medico("12345BBBB","222222222","Rosa Médico",direccion2,"777888999",consulta_2);
        OperacionVisita apendicitis = new OperacionVisita("Cirugía de apendicitis", LocalDate.of(2024,6,20),medico1);
        OperacionVisita visitaPaciente = new OperacionVisita("Visitar a un paciente cualquiera", LocalDate.of(2024,3,12),medico1);

        /****************************** ENFERMEROS **************************/

        Enfermero enfermero1 = new Enfermero("00000000A","333333333","Paco Enfermero",direccion1,"980888777");
        EnfermeroPlantaTurno enfermero1_sotano_noche = new EnfermeroPlantaTurno(enfermero1,sotano_uno,turno_noche);

        Enfermero enfermero2 = new Enfermero("AAAAAAAA9","777777777","Toña Enfermero",direccion2,"980980980");
        enfermero2.setMedico(medico1);
        enfermero2.setConsulta(consulta_1);
        EnfermeroPlantaTurno enfermero2_planta0_turnoM = new EnfermeroPlantaTurno(enfermero2,planta_baja,turno_mañana);
        EnfermeroPlantaTurno enfermero2_planta1_turnoT = new EnfermeroPlantaTurno(enfermero2,planta_uno,turno_tarde);

        Enfermero enfermero3 = new Enfermero("00000000Z","888888888","Chus Enfermero",direccion1,"980908908");
        enfermero3.setMedico(medico2);
        enfermero3.setConsulta(consulta_2);




        /****************************** CELADORES **************************/
        Celador celador = new Celador("00000000B", "444444444", "Juan Celador", direccion1, "999888777");
        celador.addTurno(turno_mañana);

        Celador celador2 = new Celador("00000000H", "666666666", "Pepe Celador", direccion2, "111222333");
        celador2.addTurno(turno_noche);
        celador2.addTurno(turno_tarde);

        /****************************** LIMPIADORES **************************/
        Limpiador limpiador = new Limpiador("00000000C","555555555","Jose Limpiador",direccion1,"777888999");
        limpiador.addTurno(turno_tarde);
        limpiador.addPlanta(sotano_uno);

        em.getTransaction().begin();
        em.persist(medico1);
        em.persist(medico2);
        em.persist(apendicitis);
        em.persist(visitaPaciente);
        em.persist(enfermero1);
        em.persist(enfermero1_sotano_noche);
        em.persist(enfermero2);
        em.persist(enfermero2_planta0_turnoM);
        em.persist(enfermero2_planta1_turnoT);
        em.persist(enfermero3);
        em.persist(celador);
        em.persist(celador2);
        em.persist(limpiador);

        em.getTransaction().commit();

        em.close();
        emf.close();

    }
}
