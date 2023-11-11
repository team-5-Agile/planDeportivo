/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dominio;

import Enumeradores.TipoEtapa;
import java.io.Serializable;
import java.util.List;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
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
@Table(name = "etapas")
public class Etapa implements Serializable {

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
    
    // Una etapa puede tener muchos medios
    @OneToMany(mappedBy = "etapas")
    private List<Medio> medios;
    
    // Llave foránea
    // Muchas etapas pueden componer un macrociclo
    @ManyToOne()
    @JoinColumn(name = "idMacrociclo", referencedColumnName = "ID", nullable = true)
    private Macrociclo macrociclos;

    public Etapa() {
    }
    
    public Etapa(Long id, TipoEtapa tipo, Integer deudaTotal, Integer duracionSemanas, Integer proporcion, List<Medio> medios, Macrociclo macrociclo) {
        this.id = id;
        this.tipo = tipo;
        this.duracionSemanas = duracionSemanas;
        this.proporcion = proporcion;
        this.medios = medios;
        this.macrociclos = macrociclo;
    }

    public Etapa(Long id, TipoEtapa tipo, Integer deudaTotal, Integer duracionSemanas, Integer proporcion) {
        this.id = id;
        this.tipo = tipo;
        this.duracionSemanas = duracionSemanas;
        this.proporcion = proporcion;
    }

    public Etapa(TipoEtapa tipo, Integer deudaTotal, Integer duracionSemanas, Integer proporcion) {
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

    public List<Medio> getMedios() {
        return medios;
    }

    public void setMedios(List<Medio> medios) {
        this.medios = medios;
    }

    public Macrociclo getMacrociclo() {
        return macrociclos;
    }

    public void setMacrociclo(Macrociclo macrociclo) {
        this.macrociclos = macrociclo;
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
        if (!(object instanceof Etapa)) {
            return false;
        }
        Etapa other = (Etapa) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Etapas{" + "id=" + id + ", tipo=" + tipo + ", duracionSemanas=" + duracionSemanas + ", proporcion=" + proporcion + ", medios=" + medios + ", macrociclo=" + macrociclos.getId() + '}';
    }
}
