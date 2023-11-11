/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dominio;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 *
 * @author brawun
 */
@Entity
public class Administrador implements Serializable {
    
    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(name = "Contrasena", nullable = false, unique = false)
    public String contrasena;
    
    @Column(name = "Usuario", nullable = false, unique = true)
    public String usuario;
    
    // Un administrador puede registrar muchos entrenadores
    @OneToMany(mappedBy = "administrador")
    private List<Entrenadores> entrenadores;

    public Administrador() {
    }

    public Administrador(Long id, String contrasena, String usuario, List<Entrenadores> entrenadores) {
        this.id = id;
        this.contrasena = contrasena;
        this.usuario = usuario;
        this.entrenadores = entrenadores;
    }

    public Administrador(Long id, String contrasena, String usuario) {
        this.id = id;
        this.contrasena = contrasena;
        this.usuario = usuario;
    }

    public Administrador(String contrasena, String usuario) {
        this.contrasena = contrasena;
        this.usuario = usuario;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public List<Entrenadores> getEntrenadores() {
        return entrenadores;
    }

    public void setEntrenadores(List<Entrenadores> entrenadores) {
        this.entrenadores = entrenadores;
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
        if (!(object instanceof Administrador)) {
            return false;
        }
        Administrador other = (Administrador) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Administrador{" + "id=" + id + ", contrasena=" + contrasena + ", usuario=" + usuario + ", entrenadores=" + entrenadores + '}';
    }
}
