package edu.badpals;

import jakarta.persistence.*;

@Entity
@Table(name="enfermeros")
@DiscriminatorValue(value="3")
public class Enfermero extends Personal {
public Enfermero(){}

    public Enfermero(String DNI, String NSS, String nombre, String direccion, String telefono) {
        super(DNI, NSS, nombre, direccion, telefono);
    }

    @OneToOne
    private Medico medico;

    public Medico getMedico() {
        return medico;
    }

    public void setMedico(Medico medico) {
        this.medico = medico;
    }


}