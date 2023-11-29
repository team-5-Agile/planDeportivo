/*
 * Medio.java
 */
package Dominio;

import Enumeradores.TipoMedio;
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
 * Clase que representa un medio en el sistema.
 *
 * Atributos:
 * - id: Identificador único del medio.
 * - tipoMedio: Tipo del medio.
 * - tipo: Unidad del medio (enumeración).
 * - minimo: Valor mínimo del medio.
 * - maximo: Valor máximo del medio.
 * - promedio: Valor promedio del medio (auto-generado).
 * - insitaciones: Número de instancias del medio.
 * - volumenEtapa: Volumen del medio en una etapa.
 * - etapas: Etapa a la que pertenece el medio (clave foránea).
 *
 * @author Equipo #5 - Metodologías Ágiles de Desarrollo
 */
@Entity
@Table(name = "medios")
public class Medio implements Serializable {

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(name = "TipoMedio", nullable = true)
    @Enumerated(EnumType.STRING)
    private TipoMedio tipoMedio;

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
    // Muchos medios pueden pertenecer a una etapa
    @ManyToOne()
    @JoinColumn(name = "idEtapa", referencedColumnName = "ID", nullable = true)
    private Etapa etapas;

    /**
     * Constructor por defecto.
     */
    public Medio() {
    }

    /**
     * Constructor con parámetros completo.
     *
     * @param id Identificador único del medio.
     * @param tipoMedio Tipo del medio.
     * @param tipo Unidad del medio.
     * @param minimo Valor mínimo del medio.
     * @param maximo Valor máximo del medio.
     * @param promedio Valor promedio del medio.
     * @param insitaciones Número de instancias del medio.
     * @param volumenEtapa Volumen del medio en una etapa.
     * @param etapa Etapa a la que pertenece el medio.
     */
    public Medio(Long id, TipoMedio tipoMedio, Unidades tipo, Integer minimo, Integer maximo, Float promedio, Integer insitaciones, Float volumenEtapa, Etapa etapa) {
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

    /**
     * Constructor con parámetros (sin la referencia a la etapa).
     *
     * @param id Identificador único del medio.
     * @param tipoMedio Tipo del medio.
     * @param tipo Unidad del medio.
     * @param minimo Valor mínimo del medio.
     * @param maximo Valor máximo del medio.
     * @param promedio Valor promedio del medio.
     * @param insitaciones Número de instancias del medio.
     * @param volumenEtapa Volumen del medio en una etapa.
     */
    public Medio(Long id, TipoMedio tipoMedio, Unidades tipo, Integer minimo, Integer maximo, Float promedio, Integer insitaciones, Float volumenEtapa) {
        this.id = id;
        this.tipoMedio = tipoMedio;
        this.tipo = tipo;
        this.minimo = minimo;
        this.maximo = maximo;
        this.promedio = promedio;
        this.insitaciones = insitaciones;
        this.volumenEtapa = volumenEtapa;
    }

    /**
     * Constructor con parámetros (sin la referencia a la etapa y sin el id).
     *
     * @param tipoMedio Tipo del medio.
     * @param tipo Unidad del medio.
     * @param minimo Valor mínimo del medio.
     * @param maximo Valor máximo del medio.
     * @param promedio Valor promedio del medio.
     * @param insitaciones Número de instancias del medio.
     * @param volumenEtapa Volumen del medio en una etapa.
     */
    public Medio(TipoMedio tipoMedio, Unidades tipo, Integer minimo, Integer maximo, Float promedio, Integer insitaciones, Float volumenEtapa) {
        this.tipoMedio = tipoMedio;
        this.tipo = tipo;
        this.minimo = minimo;
        this.maximo = maximo;
        this.promedio = promedio;
        this.insitaciones = insitaciones;
        this.volumenEtapa = volumenEtapa;
    }

    /**
     * Constructor con parámetros básicos.
     *
     * @param tipoMedio Tipo del medio.
     * @param tipo Unidad del medio.
     * @param minimo Valor mínimo del medio.
     * @param maximo Valor máximo del medio.
     * @param insitaciones Número de instancias del medio.
     */
    public Medio(TipoMedio tipoMedio, Unidades tipo, Integer minimo, Integer maximo, Integer insitaciones) {
        this.tipoMedio = tipoMedio;
        this.tipo = tipo;
        this.minimo = minimo;
        this.maximo = maximo;
        this.insitaciones = insitaciones;
    }

    // Getters y Setters

    /**
     * Obtiene el identificador único del medio.
     *
     * @return Identificador único del medio.
     */
    public Long getId() {
        return id;
    }

    /**
     * Establece el identificador único del medio.
     *
     * @param id Identificador único del medio.
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Obtiene el tipo del medio.
     *
     * @return Tipo del medio.
     */
    public TipoMedio getTipoMedio() {
        return tipoMedio;
    }

    /**
     * Establece el tipo del medio.
     *
     * @param tipoMedio Tipo del medio.
     */
    public void setTipoMedio(TipoMedio tipoMedio) {
        this.tipoMedio = tipoMedio;
    }

    /**
     * Obtiene la unidad del medio.
     *
     * @return Unidad del medio.
     */
    public Unidades getTipo() {
        return tipo;
    }

    /**
     * Establece la unidad del medio.
     *
     * @param tipo Unidad del medio.
     */
    public void setTipo(Unidades tipo) {
        this.tipo = tipo;
    }

    /**
     * Obtiene el valor mínimo del medio.
     *
     * @return Valor mínimo del medio.
     */
    public Integer getMinimo() {
        return minimo;
    }

    /**
     * Establece el valor mínimo del medio.
     *
     * @param minimo Valor mínimo del medio.
     */
    public void setMinimo(Integer minimo) {
        this.minimo = minimo;
    }

    /**
     * Obtiene el valor máximo del medio.
     *
     * @return Valor máximo del medio.
     */
    public Integer getMaximo() {
        return maximo;
    }

    /**
     * Establece el valor máximo del medio.
     *
     * @param maximo Valor máximo del medio.
     */
    public void setMaximo(Integer maximo) {
        this.maximo = maximo;
    }

    /**
     * Obtiene el valor promedio del medio.
     *
     * @return Valor promedio del medio.
     */
    public Float getPromedio() {
        return promedio;
    }

    /**
     * Establece el valor promedio del medio.
     *
     * @param promedio Valor promedio del medio.
     */
    public void setPromedio(Float promedio) {
        this.promedio = promedio;
    }

    /**
     * Obtiene el número de instancias del medio.
     *
     * @return Número de instancias del medio.
     */
    public Integer getInsitaciones() {
        return insitaciones;
    }

    /**
     * Establece el número de instancias del medio.
     *
     * @param insitaciones Número de instancias del medio.
     */
    public void setInsitaciones(Integer insitaciones) {
        this.insitaciones = insitaciones;
    }

    /**
     * Obtiene el volumen del medio en una etapa.
     *
     * @return Volumen del medio en una etapa.
     */
    public Float getVolumenEtapa() {
        return volumenEtapa;
    }

    /**
     * Establece el volumen del medio en una etapa.
     *
     * @param volumenEtapa Volumen del medio en una etapa.
     */
    public void setVolumenEtapa(Float volumenEtapa) {
        this.volumenEtapa = volumenEtapa;
    }

    /**
     * Obtiene la etapa a la que pertenece el medio.
     *
     * @return Etapa a la que pertenece el medio.
     */
    public Etapa getEtapas() {
        return etapas;
    }

    /**
     * Establece la etapa a la que pertenece el medio.
     *
     * @param etapas Etapa a la que pertenece el medio.
     */
    public void setEtapas(Etapa etapas) {
        this.etapas = etapas;
    }

    // Métodos Overrides

    /**
     * Obtiene el código hash del medio.
     *
     * @return Código hash del medio.
     */
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    /**
     * Compara el medio con otro objeto para verificar si son iguales.
     *
     * @param object Objeto a comparar.
     * @return True si los objetos son iguales, false en caso contrario.
     */
    @Override
    public boolean equals(Object object) {
        if (!(object instanceof Medio)) {
            return false;
        }
        Medio other = (Medio) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    /**
     * Convierte el medio a una cadena de texto.
     *
     * @return Cadena que representa el medio.
     */
    @Override
    public String toString() {
        return "Medio{" +
                "id=" + id +
                ", tipoMedio='" + tipoMedio + '\'' +
                ", tipo=" + tipo +
                ", minimo=" + minimo +
                ", maximo=" + maximo +
                ", promedio=" + promedio +
                ", insitaciones=" + insitaciones +
                ", volumenEtapa=" + volumenEtapa +
                ", etapa=" + (etapas != null ? etapas.getId() : null) + // Evitar NullPointerException
                '}';
    }
}
