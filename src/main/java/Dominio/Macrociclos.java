/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dominio;

import Enumeradores.Ramas;
import java.io.Serializable;
import java.util.Calendar;
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
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

/**
 *
 * @author brawun
 */
@Entity
@Table(name = "macrociclos")
public class Macrociclos implements Serializable {

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(name = "Deporte", nullable = true)
    public String deporte;
    
    @Column(name = "JefeRama", nullable = true)
    public String jefeRama;
    
    @Column(name = "Rama", nullable = true)
    @Enumerated(EnumType.STRING)
    private Ramas rama;
    
    @Column(name = "Metodologo", nullable = true)
    public String metodologo;
    
    @Column(name = "PreparadorFisico", nullable = true)
    public String preparadorFisico;
    
    @Column(name = "FechaInicio", nullable = true)
    @Temporal(TemporalType.DATE)
    private Calendar fechaInicio;
    
    @Column(name = "FechaFin", nullable = true)
    @Temporal(TemporalType.DATE)
    private Calendar fechaFin;
    
    // Un macrociclo puede tener muchas etapas
    @OneToMany(mappedBy = "macrociclos")
    private List<Etapas> etapas;
    
    // Llave foránea
    // Muchos macrociclos pueden ser creados por un entrenadores
    @ManyToOne()
    @JoinColumn(name = "idEntrenador", referencedColumnName = "ID", nullable = true)
    private Entrenadores entrenadores;

    public Macrociclos() {
    }

    public Macrociclos(Long id, String deporte, String jefeRama, Ramas rama, String metodologo, String preparadorFisico, Calendar fechaInicio, Calendar fechaFin, List<Etapas> etapas, Entrenadores entrenador) {
        this.id = id;
        this.deporte = deporte;
        this.jefeRama = jefeRama;
        this.rama = rama;
        this.metodologo = metodologo;
        this.preparadorFisico = preparadorFisico;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.etapas = etapas;
        this.entrenadores = entrenador;
    }

    public Macrociclos(Long id, String deporte, String jefeRama, Ramas rama, String metodologo, String preparadorFisico, Calendar fechaInicio, Calendar fechaFin) {
        this.id = id;
        this.deporte = deporte;
        this.jefeRama = jefeRama;
        this.rama = rama;
        this.metodologo = metodologo;
        this.preparadorFisico = preparadorFisico;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
    }

    public Macrociclos(String deporte, String jefeRama, Ramas rama, String metodologo, String preparadorFisico, Calendar fechaInicio, Calendar fechaFin) {
        this.deporte = deporte;
        this.jefeRama = jefeRama;
        this.rama = rama;
        this.metodologo = metodologo;
        this.preparadorFisico = preparadorFisico;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDeporte() {
        return deporte;
    }

    public void setDeporte(String deporte) {
        this.deporte = deporte;
    }

    public String getJefeRama() {
        return jefeRama;
    }

    public void setJefeRama(String jefeRama) {
        this.jefeRama = jefeRama;
    }

    public Ramas getRama() {
        return rama;
    }

    public void setRama(Ramas rama) {
        this.rama = rama;
    }

    public String getMetodologo() {
        return metodologo;
    }

    public void setMetodologo(String metodologo) {
        this.metodologo = metodologo;
    }

    public String getPreparadorFisico() {
        return preparadorFisico;
    }

    public void setPreparadorFisico(String preparadorFisico) {
        this.preparadorFisico = preparadorFisico;
    }

    public Calendar getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Calendar fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Calendar getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(Calendar fechaFin) {
        this.fechaFin = fechaFin;
    }

    public List<Etapas> getEtapas() {
        return etapas;
    }

    public void setEtapas(List<Etapas> etapas) {
        this.etapas = etapas;
    }

    public Entrenadores getEntrenadores() {
        return entrenadores;
    }

    public void setEntrenadores(Entrenadores entrenadores) {
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
        if (!(object instanceof Macrociclos)) {
            return false;
        }
        Macrociclos other = (Macrociclos) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Macrociclos{" + "id=" + id + ", deporte=" + deporte + ", jefeRama=" + jefeRama + ", rama=" + rama + ", metodologo=" + metodologo + ", preparadorFisico=" + preparadorFisico + ", fechaInicio=" + fechaInicio.toString() + ", fechaFin=" + fechaFin.toString() + ", etapas=" + etapas + ", entrenador=" + entrenadores.getId() + '}';
    }
}
