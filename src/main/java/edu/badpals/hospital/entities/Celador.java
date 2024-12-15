package edu.badpals.hospital.entities;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name="celadores")
@DiscriminatorValue(value="4")
public class Celador extends Personal {
    @ManyToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @JoinTable(name = "celadores_turnos",
            joinColumns = @JoinColumn(name = "idcelador"),
            inverseJoinColumns = @JoinColumn(name = "idturno"))
    private List<Turno> turnos = new ArrayList();

    public Celador() {}

    public Celador(String DNI, String NSS, String nombre, Direccion direccion, String telefono) {
        super(DNI, NSS, nombre, direccion, telefono);
    }

    public List<Turno> getTurnos() {
        return turnos;
    }

    public void setTurnos(List<Turno> turnos) {
        this.turnos = turnos;
    }

    public void addTurno(Turno turno) {
        if(!turnos.contains(turno)){
            turnos.add(turno);
        }
    }

    public void removeTurno(Turno turno) {
        if(turnos.contains(turno)){
            turnos.remove(turno);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Celador celador)) return false;
        if (!super.equals(o)) return false;
        return Objects.equals(turnos, celador.turnos);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), turnos);
    }

    @Override
    public String toString() {
        return "Celador{" +
                "turnos=" + turnos +
                '}';
    }
}
