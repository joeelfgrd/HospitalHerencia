package edu.badpals.hospital.entities;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name="limpiadores")
@DiscriminatorValue(value="2")
public class Limpiador extends Personal {
    @ManyToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @JoinTable(name = "limpiadores_plantas",
                joinColumns = @JoinColumn(name = "idlimpiador"),
                inverseJoinColumns = @JoinColumn(name = "idplanta"))
    private List<Planta> plantas = new ArrayList();

    @ManyToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @JoinTable(name = "limpiadores_turnos",
            joinColumns = @JoinColumn(name = "idlimpiador"),
            inverseJoinColumns = @JoinColumn(name = "idturno"))
    private List<Turno> turnos = new ArrayList();

    public Limpiador() {
    }

    public Limpiador(String DNI, String NSS, String nombre, String direccion, String telefono) {
        super(DNI, NSS, nombre, direccion, telefono);
    }

    public List<Planta> getPlantas() {
        return plantas;
    }

    public void setPlantas(List<Planta> plantas) {
        this.plantas = plantas;
    }

    public List<Turno> getTurnos() {
        return turnos;
    }

    public void setTurnos(List<Turno> turno) {
        this.turnos = turno;
    }

    public void addTurno(Turno turno) {
        if(!this.turnos.contains(turno)){
            this.turnos.add(turno);
        }
    }

    public void removeTurno(Turno turno) {
        if(this.turnos.contains(turno)){
            this.turnos.remove(turno);
        }
    }

    public void addPlanta(Planta planta) {
        if(!this.plantas.contains(planta)){
            this.plantas.add(planta);
        }
    }

    public void removePlanta(Planta planta) {
        if(this.plantas.contains(planta)){
            this.plantas.remove(planta);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Limpiador limpiador)) return false;
        if (!super.equals(o)) return false;
        return Objects.equals(plantas, limpiador.plantas) && Objects.equals(turnos, limpiador.turnos);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), plantas, turnos);
    }

    @Override
    public String toString() {
        return "Limpiador{" +
                "plantas=" + plantas +
                ", turno=" + turnos +
                '}';
    }
}