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
}
