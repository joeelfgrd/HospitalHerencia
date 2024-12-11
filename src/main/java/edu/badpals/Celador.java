package edu.badpals;

import jakarta.persistence.*;

import static jakarta.persistence.GenerationType.IDENTITY;

@Entity
@Table(name="celador")
public class Celador {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private int id_celador;
    @Column
    private String turno;   //podriamos poner un enum(mañana/tarde/noche)

}
