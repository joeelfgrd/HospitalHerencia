import edu.badpals.*;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import javax.swing.text.html.parser.Entity;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("default");
        EntityManager em = emf.createEntityManager();

        Medico medico1 = new Medico("12345678A","111111111","Soyun Medico","Mi casa","666111666");
        Medico medico2 = new Medico("12345BBBB","222222222","Otro Medicorl","Mi garaje","777888999");
        Enfermero enfermero1 = new Enfermero("00000000A","333333333","Este enfermero","Un box","980888777");
        Celador celador = new Celador("00000000B","444444444","Este celador","Un sala de escobas","999888777", Turno.MANHANA);
        Celador celador2 = new Celador("00000000H","666666666","Este celador","Un sala de escobas","111222333", Turno.NOCHE);
        Limpiador limpiador = new Limpiador("00000000C","555555555","Un Limpiador","Otra sala de escobas","777888999");

        em.getTransaction().begin();
        em.persist(medico1);
        em.persist(medico2);
        em.persist(enfermero1);
        em.persist(celador);
        em.persist(celador2);
        em.persist(limpiador);
        em.getTransaction().commit();

        em.close();
        emf.close();

    }
}
