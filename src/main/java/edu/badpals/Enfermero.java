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
    // Relación (1:1) con medico
    @OneToOne
    private Medico medico;
    // Relación opcional con consulta, un enfermero puede no estar asociado a una consulta por eso le puse el nullable
    @ManyToOne
    @JoinColumn(name = "consulta_id", nullable = true)
    private Consulta consulta;

    public Medico getMedico() {
        return medico;
    }

    public void setMedico(Medico medico) {
        this.medico = medico;
    }


}