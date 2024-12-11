package edu.badpals;

import jakarta.persistence.*;

import static jakarta.persistence.GenerationType.IDENTITY;

@Entity
@Table(name="personal")
public class Personal {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name="DNI")
    private String DNI;
    @Column(name="NSS", unique = true)
    private String NSS;
    @Column(name="nombre")
    private int nombre;
    @Column(name="direccion")
    private String direccion;
    @Column(name="telefono")
    private String telefono;
}
