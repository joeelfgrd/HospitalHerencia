package edu.badpals;

import com.sun.istack.NotNull;
import jakarta.persistence.*;

import java.util.Objects;


@Entity
@Table(name="personal")
@Inheritance(strategy= InheritanceType.TABLE_PER_CLASS)
@DiscriminatorColumn(name="tipo_personal",discriminatorType=DiscriminatorType.INTEGER)
@DiscriminatorValue(value="0")
public class Personal {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_id")
    @SequenceGenerator(name = "seq_id",initialValue = 1, allocationSize = 1)
    private long id;

    @Column(name="DNI", unique = true, nullable = false)
    private String DNI;
    @Column(name="NSS", unique = true, nullable = false)
    private String NSS;
    @Column(name="nombre")
    private String nombre;
    @Column(name="direccion")
    private String direccion;
    @Column(name="telefono")
    private String telefono;

    public Personal() {
    }

    public Personal(String DNI, String NSS, String nombre, String direccion, String telefono) {
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

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
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
                ", direccion='" + direccion + '\'' +
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
