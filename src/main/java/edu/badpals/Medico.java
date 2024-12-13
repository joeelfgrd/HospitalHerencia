package edu.badpals;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name="medicos")
@DiscriminatorValue(value="1")
public class Medico extends Personal {
    public Medico() {
    }

    public Medico(String DNI, String NSS, String nombre, String direccion, String telefono) {
        super(DNI, NSS, nombre, direccion, telefono);
    }
}
