package edu.badpals;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name="limpiadores")
@DiscriminatorValue(value="2")
public class Limpiador extends Personal {
    public Limpiador() {
    }

    public Limpiador(String DNI, String NSS, String nombre, String direccion, String telefono) {
        super(DNI, NSS, nombre, direccion, telefono);
    }
}