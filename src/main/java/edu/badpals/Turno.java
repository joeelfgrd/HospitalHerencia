package edu.badpals;

import jakarta.persistence.*;

@Entity
@Table(name = "turnos")
public class Turno {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_turno")
    @SequenceGenerator(name = "seq_turno", initialValue = 1)
    private long id;

    @Column(name = "horario")
    private String horario;


}
