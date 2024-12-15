package edu.badpals.hospital.entities;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name="personal")
@Inheritance(strategy= InheritanceType.JOINED)
@DiscriminatorColumn(name="tipo_medico", discriminatorType=DiscriminatorType.INTEGER)
@DiscriminatorValue(value="0")
public class Personal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name="DNI", unique = true, nullable = false)
    private String DNI;
    @Column(name="NSS", unique = true, nullable = false)
    private String NSS;
    @Column(name="nombre")
    private String nombre;
    @Embedded
    private Direccion direccion;
    @Column(name="telefono")
    private String telefono;

    public Personal() {
    }

    public Personal(String DNI, String NSS, String nombre, Direccion direccion, String telefono) {
        this.DNI = DNI;
        this.NSS = NSS;
        this.nombre = nombre;
        this.direccion = direccion;
        this.telefono = telefono;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDNI() {
        return DNI;
    }

    public void setDNI(String DNI) {
        this.DNI = DNI;
    }

    public String getNSS() {
        return NSS;
    }

    public void setNSS(String NSS) {
        this.NSS = NSS;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Direccion getDireccion() {
        return direccion;
    }

    public void setDireccion(Direccion direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    @Override
    public String toString() {
        return "Personal{" +
                "id=" + id +
                ", DNI='" + DNI + '\'' +
                ", NSS='" + NSS + '\'' +
                ", nombre='" + nombre + '\'' +
                ", direccion=" + direccion +
                ", telefono='" + telefono + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Personal personal = (Personal) o;
        return id == personal.id && Objects.equals(DNI, personal.DNI);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, DNI);
    }
}
