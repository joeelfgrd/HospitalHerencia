package edu.badpals.hospital.entities;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "consultas")
public class Consulta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="num_consulta",unique=true)
    private int num_consulta;


    // Una consulta puede tener muchos médicos
    @OneToMany(mappedBy = "consulta")
    private List<Medico> medicos = new ArrayList<>();
    // Una consulta puede tener muchos enfermeros,o no tener ninguno
    @OneToMany(mappedBy = "consulta")
    private List<Enfermero> enfermeros = new ArrayList<>();

    // Relación N:1 con Planta, muchas consultas pueden estar en una planta
    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH})
    @JoinColumn(name = "planta_id", nullable = false)
    private Planta planta;

    public Consulta() {
    }

    public Consulta(int num_consulta, Planta planta) {
        this.num_consulta = num_consulta;
        this.planta = planta;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getNum_consulta() {
        return num_consulta;
    }

    public void setNum_consulta(int num_consulta) {
        this.num_consulta = num_consulta;
    }

    public List<Medico> getMedicos() {
        return medicos;
    }

    public void setMedicos(List<Medico> medicos) {
        this.medicos = medicos;
    }

    public List<Enfermero> getEnfermeros() {
        return enfermeros;
    }

    public void setEnfermeros(List<Enfermero> enfermeros) {
        this.enfermeros = enfermeros;
    }

    public Planta getPlanta() {
        return planta;
    }

    public void setPlanta(Planta planta) {
        this.planta = planta;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Consulta consulta)) return false;
        return num_consulta == consulta.num_consulta && Objects.equals(id, consulta.id) && Objects.equals(medicos, consulta.medicos) && Objects.equals(enfermeros, consulta.enfermeros) && Objects.equals(planta, consulta.planta);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, num_consulta, medicos, enfermeros, planta);
    }

    @Override
    public String toString() {
        return "Consulta{" +
                "id=" + id +
                ", num_consulta=" + num_consulta +
                ", medicos=" + medicos +
                ", enfermeros=" + enfermeros +
                ", planta=" + planta +
                '}';
    }
}
