package edu.badpals;

import jakarta.persistence.*;

import java.util.List;
import java.util.Objects;

@Entity
@Table(name="enfermeros")
@DiscriminatorValue(value="3")
public class Enfermero extends Personal {
public Enfermero(){}

    public Enfermero(String DNI, String NSS, String nombre, String direccion, String telefono) {
        super(DNI, NSS, nombre, direccion, telefono);
    }
    // Relación (1:1) con medico
    @OneToOne(cascade = {CascadeType.PERSIST,CascadeType.MERGE, CascadeType.REFRESH})
    @JoinColumn(name = "idmedico", nullable = true)
    private Medico medico;
    // Relación opcional con consulta, un enfermero puede no estar asociado a una consulta por eso le puse el nullable
    @ManyToOne(cascade = {CascadeType.PERSIST,CascadeType.MERGE, CascadeType.REFRESH})
    @JoinColumn(name = "consulta_id", nullable = true)
    private Consulta consulta;


    public Medico getMedico() {
        return medico;
    }

    public void setMedico(Medico medico) {
        this.medico = medico;
    }

    public Consulta getConsulta() {
        return consulta;
    }

    public void setConsulta(Consulta consulta){
        if(this.medico == null){
            throw new IllegalStateException("No hay médico asignado, no se puede asignar consulta.");
        }else{
            this.consulta = consulta;
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Enfermero enfermero)) return false;
        if (!super.equals(o)) return false;
        return Objects.equals(medico, enfermero.medico) && Objects.equals(consulta, enfermero.consulta);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), medico, consulta);
    }

    @Override
    public String toString() {
        return "Enfermero{" +
                "medico=" + medico +
                ", consulta=" + consulta +
                '}';
    }
}