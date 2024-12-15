package edu.badpals.hospital.entities;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "enfermeros_plantas_turnos")
public class EnfermeroPlantaTurno {
    @EmbeddedId
    private EnfermeroPlantaTurnoId id;

    @MapsId(value = "idEnfermero")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "enfermero",nullable = false)
    private Enfermero enfermero;

    @MapsId(value = "idPlanta")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "planta",nullable = false)
    private Planta planta;

    @MapsId(value = "idTurno")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "turno",nullable = false)
    private Turno turno;

    public EnfermeroPlantaTurno(Enfermero enfermero, Planta planta, Turno turno) {
        this.id = new EnfermeroPlantaTurnoId(enfermero,planta,turno);
        this.enfermero = enfermero;
        this.planta = planta;
        this.turno = turno;
    }

    public EnfermeroPlantaTurno() {

    }

    public EnfermeroPlantaTurnoId getId() {
        return id;
    }

    public void setId(EnfermeroPlantaTurnoId id) {
        this.id = id;
    }

    public Enfermero getEnfermero() {
        return enfermero;
    }

    public void setEnfermero(Enfermero enfermero) {
        this.enfermero = enfermero;
    }

    public Planta getPlanta() {
        return planta;
    }

    public void setPlanta(Planta planta) {
        this.planta = planta;
    }

    public Turno getTurno() {
        return turno;
    }

    public void setTurno(Turno turno) {
        this.turno = turno;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof EnfermeroPlantaTurno that)) return false;
        return Objects.equals(id, that.id) && Objects.equals(enfermero, that.enfermero) && Objects.equals(planta, that.planta) && Objects.equals(turno, that.turno);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, enfermero, planta, turno);
    }

    @Override
    public String toString() {
        return "EnfermeroPlantaTurno{" +
                "id=" + id +
                ", enfermero=" + enfermero +
                ", planta=" + planta +
                ", turno=" + turno +
                '}';
    }
}
