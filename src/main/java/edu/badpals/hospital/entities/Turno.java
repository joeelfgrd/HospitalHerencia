package edu.badpals.hospital.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "turnos")
public class Turno {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Enumerated(EnumType.STRING)
    @Column(name = "horario", nullable = false)
    private Horario horario;

    public Turno() {
    }

    public Turno(Horario horario) {
        this.horario = horario;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Horario getHorario() {
        return horario;
    }

    public void setHorario(Horario horario) {
        this.horario = horario;
    }

    @Override
    public String toString() {
        return "Turno{" +
                "id=" + id +
                ", horario='" + horario + '\'' +
                '}';
    }
}
