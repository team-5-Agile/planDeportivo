/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dominio;

import Enumeradores.Unidades;
import java.io.Serializable;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

/**
 *
 * @author brawun
 */
@Entity
@Table(name = "medios")
public class Medio implements Serializable {

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(name = "TipoMedio", nullable = true)
    public String tipoMedio;
    
    @Column(name = "Unidades", nullable = true)
    @Enumerated(EnumType.STRING)
    private Unidades tipo;
    
    @Column(name = "Minimo", nullable = false)
    private Integer minimo = 0;
    
    @Column(name = "Maximo", nullable = false)
    private Integer maximo = 0;
    
    // AUTOGENERADA
    @Column(name = "Promedio", nullable = false)
    private Float promedio = (float) 0;
    
    @Column(name = "Insitaciones", nullable = false)
    private Integer insitaciones = 0;
    
    @Column(name = "VolumenEtapa", nullable = false)
    private Float volumenEtapa = (float) 0;
    
    // Llave foránea
    // Muchos medios pueden pertenecer a una etapas
    @ManyToOne()
    @JoinColumn(name = "idEtapa", referencedColumnName = "ID", nullable = true)
    private Etapa etapas;

    public Medio() {
    }
    
    public Medio(Long id, String tipoMedio, Unidades tipo, Integer minimo, Integer maximo, Float promedio, Integer insitaciones, Float volumenEtapa, Etapa etapa) {
        this.id = id;
        this.tipoMedio = tipoMedio;
        this.tipo = tipo;
        this.minimo = minimo;
        this.maximo = maximo;
        this.promedio = promedio;
        this.insitaciones = insitaciones;
        this.volumenEtapa = volumenEtapa;
        this.etapas = etapa;
    }

    public Medio(Long id, String tipoMedio, Unidades tipo, Integer minimo, Integer maximo, Float promedio, Integer insitaciones, Float volumenEtapa) {
        this.id = id;
        this.tipoMedio = tipoMedio;
        this.tipo = tipo;
        this.minimo = minimo;
        this.maximo = maximo;
        this.promedio = promedio;
        this.insitaciones = insitaciones;
        this.volumenEtapa = volumenEtapa;
    }
    
    public Medio(String tipoMedio, Unidades tipo, Integer minimo, Integer maximo, Float promedio, Integer insitaciones, Float volumenEtapa) {
        this.tipoMedio = tipoMedio;
        this.tipo = tipo;
        this.minimo = minimo;
        this.maximo = maximo;
        this.promedio = promedio;
        this.insitaciones = insitaciones;
        this.volumenEtapa = volumenEtapa;
    }
    
    public Medio(String tipoMedio, Unidades tipo, Integer minimo, Integer maximo, Integer insitaciones) {
        this.tipoMedio = tipoMedio;
        this.tipo = tipo;
        this.minimo = minimo;
        this.maximo = maximo;
        this.insitaciones = insitaciones;
    }
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTipoMedio() {
        return tipoMedio;
    }

    public void setTipoMedio(String tipoMedio) {
        this.tipoMedio = tipoMedio;
    }

    public Unidades getTipo() {
        return tipo;
    }

    public void setTipo(Unidades tipo) {
        this.tipo = tipo;
    }

    public Integer getMinimo() {
        return minimo;
    }

    public void setMinimo(Integer minimo) {
        this.minimo = minimo;
    }

    public Integer getMaximo() {
        return maximo;
    }

    public void setMaximo(Integer maximo) {
        this.maximo = maximo;
    }

    public Float getPromedio() {
        return promedio;
    }

    public void setPromedio(Float promedio) {
        this.promedio = promedio;
    }

    public Integer getInsitaciones() {
        return insitaciones;
    }

    public void setInsitaciones(Integer insitaciones) {
        this.insitaciones = insitaciones;
    }

    public Float getVolumenEtapa() {
        return volumenEtapa;
    }

    public void setVolumenEtapa(Float volumenEtapa) {
        this.volumenEtapa = volumenEtapa;
    }

    public Etapa getEtapas() {
        return etapas;
    }

    public void setEtapas(Etapa etapas) {
        this.etapas = etapas;
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
        if (!(object instanceof Medio)) {
            return false;
        }
        Medio other = (Medio) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Medios{" + "id=" + id + ", tipoMedio=" + tipoMedio + ", tipo=" + tipo + ", minimo=" + minimo + ", maximo=" + maximo + ", promedio=" + promedio + ", insitaciones=" + insitaciones + ", volumenEtapa=" + volumenEtapa + ", etapa=" + etapas.getId() + '}';
    }
}
