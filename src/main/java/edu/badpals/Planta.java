package edu.badpals;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "plantas")
public class Planta {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "planta_seq")
    @SequenceGenerator(name = "planta_seq", initialValue = 1, allocationSize = 1)
    private Long id;

    @Column(name = "numero_planta", nullable = false)
    private int numeroPlanta;

    // Relación 1:N con Consulta una planta puede tener muchas consultas
    @OneToMany(mappedBy = "planta")
    private List<Consulta> consultas;


    //NO ESTOY SEGURO DE QUE SEA ASÍ
    // Relación Muchos a Muchos con Enfermero: Una planta puede tener muchos enfermeros y un enfermero puede estar en varias plantas
    @ManyToMany
    @JoinTable(name = "planta_enfermero",joinColumns = @JoinColumn(name = "planta_id"),inverseJoinColumns = @JoinColumn(name = "enfermero_id"))
    private List<Enfermero> enfermeros;

}
