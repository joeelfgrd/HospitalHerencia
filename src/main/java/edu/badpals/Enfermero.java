package edu.badpals;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name="enfermeros")
@DiscriminatorValue(value="3")
public class Enfermero extends Personal {
public Enfermero(){}

    public Enfermero(String DNI, String NSS, String nombre, String direccion, String telefono) {
        super(DNI, NSS, nombre, direccion, telefono);
    }
}