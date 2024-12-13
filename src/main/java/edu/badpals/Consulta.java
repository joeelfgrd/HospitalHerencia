package edu.badpals;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "consultas")
public class Consulta {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "consulta_seq")
    @SequenceGenerator(name = "consulta_seq", initialValue = 1, allocationSize = 1)
    private Long id;
    // Una consulta puede tener muchos médicos
    @OneToMany(mappedBy = "consulta")
    private List<Medico> medicos;
    // Una consulta puede tener muchos enfermeros,o no tener ninguno
    @OneToMany(mappedBy = "consulta")
    private List<Enfermero> enfermeros;

    // Relación N:1 con Planta, muchas consultas pueden estar en una planta
    @ManyToOne
    @JoinColumn(name = "planta_id", nullable = false)
    private Planta planta;
}
