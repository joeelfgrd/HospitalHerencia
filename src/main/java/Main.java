import edu.badpals.*;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import javax.swing.text.html.parser.Entity;
import java.time.LocalDate;
import java.util.List;

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

        /****************************** MEDICOS **************************/

        Medico medico1 = new Medico("12345678A","111111111","Ana Médico","Su casa","666111666",consulta_1);
        Medico medico2 = new Medico("12345BBBB","222222222","Rosa Médico","Calle Alta","777888999",consulta_2);
        OperacionVisita apendicitis = new OperacionVisita("Cirugía de apendicitis", LocalDate.of(2024,6,20),medico1);
        OperacionVisita visitaPaciente = new OperacionVisita("Visitar a un paciente cualquiera", LocalDate.of(2024,3,12),medico1);

        /****************************** ENFERMEROS **************************/

        Enfermero enfermero1 = new Enfermero("00000000A","333333333","Paco Enfermero","Un box","980888777");
        EnfermeroPlantaTurno enfermero1_sotano_noche = new EnfermeroPlantaTurno(enfermero1,sotano_uno,turno_noche);

        Enfermero enfermero2 = new Enfermero("AAAAAAAA9","777777777","Toña Enfermero","Calle baja","980980980");
        enfermero2.setMedico(medico1);
        enfermero2.setConsulta(consulta_1);
        EnfermeroPlantaTurno enfermero2_planta0_turnoM = new EnfermeroPlantaTurno(enfermero2,planta_baja,turno_mañana);
        EnfermeroPlantaTurno enfermero2_planta1_turnoT = new EnfermeroPlantaTurno(enfermero2,planta_uno,turno_tarde);

        Enfermero enfermero3 = new Enfermero("00000000Z","888888888","Chus Enfermero","Calle del medio","980908908");
        enfermero3.setMedico(medico2);
        enfermero3.setConsulta(consulta_2);

        /****************************** CELADORES **************************/

        Celador celador = new Celador("00000000B","444444444","Juan Celador","Un sala de escobas","999888777");
        celador.addTurno(turno_mañana);
        Celador celador2 = new Celador("00000000H","666666666","Pepe Celador","Debajo del puente","111222333");
        celador2.addTurno(turno_noche);
        celador2.addTurno(turno_tarde);

        /****************************** LIMPIADORES **************************/
        Limpiador limpiador = new Limpiador("00000000C","555555555","Jose Limpiador","Otra sala de escobas","777888999");
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
