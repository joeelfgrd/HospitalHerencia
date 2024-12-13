package edu.badpals;

import jakarta.persistence.*;

import static jakarta.persistence.GenerationType.IDENTITY;

@Entity
@Table(name="celadores")
@DiscriminatorValue(value="4")
public class Celador extends Personal {
    @Column
    private Turno turno;   //podriamos poner un enum(mañana/tarde/noche)
    public Celador() {}

    public Celador(String DNI, String NSS, String nombre, String direccion, String telefono, Turno turno) {
        super(DNI, NSS, nombre, direccion, telefono);
        this.turno = turno;
    }


}
