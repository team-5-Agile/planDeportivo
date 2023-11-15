/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dominio;

import java.io.Serializable;
import java.util.List;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

/**
 *
 * @author brawun
 */
@Entity
@Table(name = "entrenadores")
public class Entrenador implements Serializable {

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(name = "Nombre", nullable = true)
    public String nombre;
    
    @Column(name = "ApellidoPaterno", nullable = true)
    public String apellidoPaterno;
    
    @Column(name = "ApellidoMaterno", nullable = true)
    public String apellidoMaterno;
    
    @Column(name = "Contrasena", nullable = false, unique = false)
    public String contrasena;
    
    @Column(name = "Usuario", nullable = false, unique = true)
    public String usuario;
    
    // Un entrenador puede crear muchos macrociclos
    @OneToMany(mappedBy = "entrenadores")
    private List<Macrociclo> macrociclos;
    
    // Llave foránea
    // Muchos entrenadores pueden ser registrados por un administrador
    @ManyToOne()
    @JoinColumn(name = "idAdministrador", referencedColumnName = "ID", nullable = true)
    private Administrador administrador;

    public Entrenador() {
    }

    public Entrenador(Long id, String nombre, String apellidoPaterno, String apellidoMaterno, String contrasena, String usuario, List<Macrociclo> macrociclos, Administrador administrador) {
        this.id = id;
        this.nombre = nombre;
        this.apellidoPaterno = apellidoPaterno;
        this.apellidoMaterno = apellidoMaterno;
        this.contrasena = contrasena;
        this.usuario = usuario;
        this.macrociclos = macrociclos;
        this.administrador = administrador;
    }

    public Entrenador(Long id, String nombre, String apellidoPaterno, String apellidoMaterno, String contrasena, String usuario) {
        this.id = id;
        this.nombre = nombre;
        this.apellidoPaterno = apellidoPaterno;
        this.apellidoMaterno = apellidoMaterno;
        this.contrasena = contrasena;
        this.usuario = usuario;
    }

    public Entrenador(String nombre, String apellidoPaterno, String apellidoMaterno, String contrasena, String usuario) {
        this.nombre = nombre;
        this.apellidoPaterno = apellidoPaterno;
        this.apellidoMaterno = apellidoMaterno;
        this.contrasena = contrasena;
        this.usuario = usuario;
    } 

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidoPaterno() {
        return apellidoPaterno;
    }

    public void setApellidoPaterno(String apellidoPaterno) {
        this.apellidoPaterno = apellidoPaterno;
    }

    public String getApellidoMaterno() {
        return apellidoMaterno;
    }

    public void setApellidoMaterno(String apellidoMaterno) {
        this.apellidoMaterno = apellidoMaterno;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public List<Macrociclo> getMacrociclos() {
        return macrociclos;
    }

    public void setMacrociclos(List<Macrociclo> macrociclos) {
        this.macrociclos = macrociclos;
    }

    public Administrador getAdministrador() {
        return administrador;
    }

    public void setAdministrador(Administrador administrador) {
        this.administrador = administrador;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Entrenador)) {
            return false;
        }
        Entrenador other = (Entrenador) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entrenadores{" + "id=" + id + ", nombre=" + nombre + " apellidoPaterno=" + apellidoPaterno + " apellidoMaterno=" + apellidoMaterno + ", contrasena=" + contrasena + ", usuario=" + usuario + ", macrociclos=" + macrociclos + ", administrador=" + administrador.getId() + '}';
    }
    
}