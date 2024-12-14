package edu.badpals;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class EnfermeroPlantaTurnoId implements Serializable {
    private static final long serialVersionUID = 1L;

    @Column(name = "idEnfermero", nullable = false)
    private long idEnfermero;
    @Column(name = "idPlanta", nullable = false)
    private long idPlanta;
    @Column(name = "idTurno", nullable = false)
    private long idTurno;

    public EnfermeroPlantaTurnoId() {
    }

    public EnfermeroPlantaTurnoId(Integer idEnfermero, Integer idPlanta, Integer idTurno) {
        this.idEnfermero = idEnfermero;
        this.idPlanta = idPlanta;
        this.idTurno = idTurno;
    }

    public EnfermeroPlantaTurnoId(Enfermero enfermero, Planta planta, Turno turno) {
        this.idEnfermero = enfermero.getId();
        this.idPlanta = planta.getId();
        this.idTurno = turno.getId();
    }

    public long getIdEnfermero() {
        return idEnfermero;
    }

    public void setIdEnfermero(Integer idEnfermero) {
        this.idEnfermero = idEnfermero;
    }

    public long getIdPlanta() {
        return idPlanta;
    }

    public void setIdPlanta(Integer idPlanta) {
        this.idPlanta = idPlanta;
    }

    public long getIdTurno() {
        return idTurno;
    }

    public void setIdTurno(Integer idTurno) {
        this.idTurno = idTurno;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof EnfermeroPlantaTurnoId that)) return false;
        return Objects.equals(idEnfermero, that.idEnfermero) && Objects.equals(idPlanta, that.idPlanta) && Objects.equals(idTurno, that.idTurno);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idEnfermero, idPlanta, idTurno);
    }

    @Override
    public String toString() {
        return "EnfermeroPlantaTurnoId{" +
                "idEnfermero=" + idEnfermero +
                ", idPlanta=" + idPlanta +
                ", idTurno=" + idTurno +
                '}';
    }
}
