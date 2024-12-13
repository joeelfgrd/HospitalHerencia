package edu.badpals;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name="medicos")
@DiscriminatorValue(value="1")
public class Medico extends Personal {
    public Medico() {
    }

    public Medico(String DNI, String NSS, String nombre, String direccion, String telefono) {
        super(DNI, NSS, nombre, direccion, telefono);
    }
    //Relacion (1:1) con enfermero
    @OneToOne(mappedBy = "enfermero")
    private Medico medico;
    //Relacion (1:N) con operaciones_visitas,un medico puede tener muchas operaciones_visitas pero una operacion_visita solo puede tener un medico
    @OneToMany(mappedBy = "medico")
    private List<OperacionVisita> operacionesVisitas;

    // Relacion (N:1) con consulta, un medico puede tener una consulta pero una consulta  puede tener muchos medicos
    @ManyToOne
    @JoinColumn(name = "consulta_id", nullable = false)
    private Consulta consulta;

    public Medico getMedico() {
        return medico;
    }

    public void setMedico(Medico medico) {
        this.medico = medico;
    }
}
