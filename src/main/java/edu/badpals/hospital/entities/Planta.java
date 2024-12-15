package edu.badpals.hospital.entities;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "plantas")
public class Planta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "numero_planta", nullable = false)
    private int numeroPlanta;

    // Relación 1:N con Consulta una planta puede tener muchas consultas
    @OneToMany(mappedBy = "planta")
    private List<Consulta> consultas;

    public Planta(int numeroPlanta) {
        this.numeroPlanta = numeroPlanta;
    }

    public Planta() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getNumeroPlanta() {
        return numeroPlanta;
    }

    public void setNumeroPlanta(int numeroPlanta) {
        this.numeroPlanta = numeroPlanta;
    }

    public List<Consulta> getConsultas() {
        return consultas;
    }

    public void setConsultas(List<Consulta> consultas) {
        this.consultas = consultas;
    }
}
