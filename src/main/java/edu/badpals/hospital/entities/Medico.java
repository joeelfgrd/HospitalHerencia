package edu.badpals.hospital.entities;

import jakarta.persistence.*;

import java.util.List;
import java.util.Objects;

@Entity
@Table(name="medicos")
@DiscriminatorValue(value="1")
public class Medico extends Personal {
    public Medico() {
    }

    public Medico(String DNI, String NSS, String nombre, String direccion, String telefono, Consulta consulta) {
        super(DNI, NSS, nombre, direccion, telefono);
        this.consulta = consulta;
    }

    //Relacion (1:1) con enfermero
    @OneToOne(mappedBy = "medico",cascade = {CascadeType.PERSIST,CascadeType.MERGE, CascadeType.REFRESH})
    private Enfermero enfermero;
    //Relacion (1:N) con operaciones_visitas,un medico puede tener muchas operaciones_visitas pero una operacion_visita solo puede tener un medico
    @OneToMany(mappedBy = "medico", cascade = CascadeType.ALL)
    private List<OperacionVisita> operacionesVisitas;

    // Relacion (N:1) con consulta, un medico puede tener una consulta pero una consulta  puede tener muchos medicos
    @ManyToOne(cascade={CascadeType.PERSIST,CascadeType.MERGE, CascadeType.REFRESH})
    @JoinColumn(name = "consulta_id", nullable = false)
    private Consulta consulta;

    public Enfermero getEnfermero() {
        return enfermero;
    }

    public void setEnfermero(Enfermero enfermero) {
        this.enfermero = enfermero;
    }

    public List<OperacionVisita> getOperacionesVisitas() {
        return operacionesVisitas;
    }

    public void setOperacionesVisitas(List<OperacionVisita> operacionesVisitas) {
        this.operacionesVisitas = operacionesVisitas;
    }

    public Consulta getConsulta() {
        return consulta;
    }

    public void setConsulta(Consulta consulta) {
        this.consulta = consulta;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Medico medico1)) return false;
        if (!super.equals(o)) return false;
        return Objects.equals(enfermero, medico1.enfermero) && Objects.equals(operacionesVisitas, medico1.operacionesVisitas) && Objects.equals(consulta, medico1.consulta);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), enfermero, operacionesVisitas, consulta);
    }

    @Override
    public String toString() {
        return "Medico{" +
                "medico=" + enfermero +
                ", operacionesVisitas=" + operacionesVisitas +
                ", consulta=" + consulta +
                '}';
    }
}
