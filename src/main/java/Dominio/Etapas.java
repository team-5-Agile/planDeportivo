/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dominio;

import Enumeradores.TipoEtapa;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author brawun
 */
@Entity
public class Etapas implements Serializable {

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "TipoEtapa", nullable = true)
    @Enumerated(EnumType.STRING)
    private TipoEtapa tipo;

    @Column(name = "DuracionSemanas", nullable = true)
    private Integer duracionSemanas = 1;

    @Column(name = "Proporcion", nullable = true)
    private Integer proporcion = 0;

    public Etapas() {
    }

    public Etapas(Long id, TipoEtapa tipo, Integer deudaTotal, Integer duracionSemanas, Integer proporcion) {
        this.id = id;
        this.tipo = tipo;
        this.duracionSemanas = duracionSemanas;
        this.proporcion = proporcion;
    }

    public Etapas(TipoEtapa tipo, Integer deudaTotal, Integer duracionSemanas, Integer proporcion) {
        this.tipo = tipo;
        this.duracionSemanas = duracionSemanas;
        this.proporcion = proporcion;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public TipoEtapa getTipo() {
        return tipo;
    }

    public void setTipo(TipoEtapa tipo) {
        this.tipo = tipo;
    }

    public Integer getDuracionSemanas() {
        return duracionSemanas;
    }

    public void setDuracionSemanas(Integer duracionSemanas) {
        this.duracionSemanas = duracionSemanas;
    }

    public Integer getProporcion() {
        return proporcion;
    }

    public void setProporcion(Integer proporcion) {
        this.proporcion = proporcion;
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
        if (!(object instanceof Etapas)) {
            return false;
        }
        Etapas other = (Etapas) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Etapas{" + "id=" + id + ", tipo=" + tipo + ", duracionSemanas=" + duracionSemanas + ", proporcion=" + proporcion + '}';
    }
}
