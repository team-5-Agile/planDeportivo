/*
 * Etapa.java
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
 * Descripción general de la clase: Esta clase representa una etapa en el
 * sistema, que puede ser parte de un macrociclo. Cada etapa tiene un tipo, una
 * duración en semanas, una proporción y puede estar asociada a varios medios.
 *
 * Atributos: - id: Identificador único de la etapa. - tipo: Tipo de etapa (por
 * ejemplo, preparatoria, competencia). - duracionSemanas: Duración en semanas
 * de la etapa. - proporcion: Proporción de la etapa. - medios: Lista de medios
 * asociados a la etapa. - macrociclo: Macrociclo al que pertenece la etapa
 * (clave foránea).
 *
 * Autor: Equipo #5 - Metodologías Ágiles de Desarrollo
 */
@Entity
@Table(name = "etapas")
public class Etapa implements Serializable {

    /**
     * Identificador único de la etapa.
     */
    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * Tipo de etapa (por ejemplo, preparatoria, competencia).
     */
    @Column(name = "TipoEtapa", nullable = true)
    @Enumerated(EnumType.STRING)
    private TipoEtapa tipo;

    /**
     * Duración en semanas de la etapa.
     */
    @Column(name = "DuracionSemanas", nullable = true)
    private Integer duracionSemanas = 1;

    /**
     * Proporción de la etapa.
     */
    @Column(name = "Proporcion", nullable = true)
    private Double proporcion = 0.0;

    /**
     * Lista de medios asociados a la etapa.
     */
    @OneToMany(mappedBy = "etapas")
    private List<Medio> medios;

    /**
     * Macrociclo al que pertenece la etapa (clave foránea).
     */
    @ManyToOne()
    @JoinColumn(name = "idMacrociclo", referencedColumnName = "ID", nullable = true)
    private Macrociclo macrociclo;

    /**
     * Constructor predeterminado.
     */
    public Etapa() {
    }

    /**
     * Constructor con parámetros.
     *
     * @param id Identificador único de la etapa.
     * @param tipo Tipo de etapa.
     * @param duracionSemanas Duración en semanas de la etapa.
     * @param proporcion Proporción de la etapa.
     * @param medios Lista de medios asociados a la etapa.
     * @param macrociclo Macrociclo al que pertenece la etapa.
     */
    public Etapa(Long id, TipoEtapa tipo, Integer duracionSemanas, Double proporcion, List<Medio> medios, Macrociclo macrociclo) {
        this.id = id;
        this.tipo = tipo;
        this.duracionSemanas = duracionSemanas;
        this.proporcion = proporcion;
        this.medios = medios;
        this.macrociclo = macrociclo;
    }
    
    /**
     *
     * @param tipo Tipo de etapa.
     * @param duracionSemanas Duración en semanas de la etapa.
     * @param proporcion Proporción de la etapa.
     * @param macrociclo Macrociclo al que pertenece la etapa.
     */
    public Etapa(TipoEtapa tipo, Integer duracionSemanas, Double proporcion, Macrociclo macrociclo) {
        this.tipo = tipo;
        this.duracionSemanas = duracionSemanas;
        this.proporcion = proporcion;
        this.macrociclo = macrociclo;
    }

     /*
     * @param id Identificador único de la etapa.
     * @param tipo Tipo de etapa.
     * @param duracionSemanas Duración en semanas de la etapa.
     * @param proporcion Proporción de la etapa.
     */
    public Etapa(Long id, TipoEtapa tipo, Integer duracionSemanas, Double proporcion) {
        this.id = id;
        this.tipo = tipo;
        this.duracionSemanas = duracionSemanas;
        this.proporcion = proporcion;
    }

    /**
     * Constructor con parámetros.
     *
     * @param tipo Tipo de etapa.
     * @param duracionSemanas Duración en semanas de la etapa.
     * @param proporcion Proporción de la etapa.
     */
    public Etapa(TipoEtapa tipo, Integer duracionSemanas, Double proporcion) {
        this.tipo = tipo;
        this.duracionSemanas = duracionSemanas;
        this.proporcion = proporcion;
    }

    /**
     * Método que devuelve el identificador único de la etapa.
     *
     * @return Identificador único de la etapa.
     */
    public Long getId() {
        return id;
    }

    /**
     * Método que establece el identificador único de la etapa.
     *
     * @param id Identificador único de la etapa.
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Método que devuelve el tipo de etapa.
     *
     * @return Tipo de etapa.
     */
    public TipoEtapa getTipo() {
        return tipo;
    }

    /**
     * Método que establece el tipo de etapa.
     *
     * @param tipo Tipo de etapa.
     */
    public void setTipo(TipoEtapa tipo) {
        this.tipo = tipo;
    }

    /**
     * Método que devuelve la duración en semanas de la etapa.
     *
     * @return Duración en semanas de la etapa.
     */
    public Integer getDuracionSemanas() {
        return duracionSemanas;
    }

    /**
     * Método que establece la duración en semanas de la etapa.
     *
     * @param duracionSemanas Duración en semanas de la etapa.
     */
    public void setDuracionSemanas(Integer duracionSemanas) {
        this.duracionSemanas = duracionSemanas;
    }

    /**
     * Método que devuelve la proporción de la etapa.
     *
     * @return Proporción de la etapa.
     */
    public Double getProporcion() {
        return proporcion;
    }

    /**
     * Método que establece la proporción de la etapa.
     *
     * @param proporcion Proporción de la etapa.
     */
    public void setProporcion(Double proporcion) {
        this.proporcion = proporcion;
    }

    /**
     * Método que devuelve la lista de medios asociados a la etapa.
     *
     * @return Lista de medios asociados a la etapa.
     */
    public List<Medio> getMedios() {
        return medios;
    }

    /**
     * Método que establece la lista de medios asociados a la etapa.
     *
     * @param medios Lista de medios asociados a la etapa.
     */
    public void setMedios(List<Medio> medios) {
        this.medios = medios;
    }

    /**
     * Método que devuelve el macrociclo al que pertenece la etapa.
     *
     * @return Macrociclo al que pertenece la etapa.
     */
    public Macrociclo getMacrociclo() {
        return macrociclo;
    }

    /**
     * Método que establece el macrociclo al que pertenece la etapa.
     *
     * @param macrociclo Macrociclo al que pertenece la etapa.
     */
    public void setMacrociclo(Macrociclo macrociclo) {
        this.macrociclo = macrociclo;
    }

    /**
     * Método que genera un código hash basado en el identificador único de la
     * etapa.
     *
     * @return Código hash.
     */
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    /**
     * Método que compara el objeto actual con otro objeto.
     *
     * @param obj Objeto a comparar.
     * @return `true` si los objetos son iguales, `false` en caso contrario.
     */
    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Etapa other = (Etapa) obj;
        // Si los identificadores son nulos, los objetos no son iguales
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    /**
     * Método que devuelve una representación en cadena del objeto Etapa.
     *
     * @return Cadena que representa a la etapa.
     */
    @Override
    public String toString() {
        return "Etapa{"
                + "id=" + id
                + ", tipo=" + tipo + '\''
                + ", duracionSemanas=" + duracionSemanas + '\''
                + ", proporcion=" + proporcion + '\''
                + ", medios=" + medios + '\''
                + ", macrociclo=" + macrociclo.getId()
                + '}';
    }
}
