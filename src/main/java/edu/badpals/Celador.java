package edu.badpals;

import jakarta.persistence.*;

import static jakarta.persistence.GenerationType.IDENTITY;

@Entity
@Table(name="celadores")
@DiscriminatorValue(value="4")
public class Celador extends Personal {
    @ManyToOne
    @JoinColumn(name="turno_id")
    private Turno turno;

    public Celador() {}

    public Celador(String DNI, String NSS, String nombre, String direccion, String telefono, Turno turno) {
        super(DNI, NSS, nombre, direccion, telefono);
        this.turno = turno;
    }

    public Turno getTurno() {
        return turno;
    }

    public void setTurno(Turno turno) {
        this.turno = turno;
    }

    @Override
    public String toString() {
        return "Celador{" +
                "turno=" + turno +
                '}';
    }
}
