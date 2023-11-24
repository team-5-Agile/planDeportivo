/*
 * Macrociclo.java
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
 * Descripción general de la clase: Esta clase representa un macrociclo en el
 * sistema, que puede ser creado por un entrenador y contener varias etapas.
 * Cada macrociclo tiene un deporte asociado, un jefe de rama, una rama, un
 * metodólogo, un preparador físico, una fecha de inicio y una fecha de fin.
 *
 * Atributos: - id: Identificador único del macrociclo. - deporte: Deporte
 * asociado al macrociclo. - jefeRama: Jefe de rama asociado al macrociclo. -
 * rama: Rama asociada al macrociclo. - metodologo: Metodólogo asociado al
 * macrociclo. - preparadorFisico: Preparador físico asociado al macrociclo. -
 * fechaInicio: Fecha de inicio del macrociclo. - fechaFin: Fecha de fin del
 * macrociclo. - etapas: Lista de etapas asociadas al macrociclo. - entrenador:
 * Entrenador que creó el macrociclo (clave foránea).
 *
 * Autor: Equipo #5 - Metodologías Ágiles de Desarrollo
 */
@Entity
@Table(name = "macrociclos")
public class Macrociclo implements Serializable {

    /**
     * Identificador único del macrociclo.
     */
    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * Deporte asociado al macrociclo.
     */
    @Column(name = "Deporte", nullable = true)
    public String deporte;

    /**
     * Jefe de rama asociado al macrociclo.
     */
    @Column(name = "JefeRama", nullable = true)
    public String jefeRama;

    /**
     * Rama asociada al macrociclo.
     */
    @Column(name = "Rama", nullable = true)
    @Enumerated(EnumType.STRING)
    private Ramas rama;

    /**
     * Metodólogo asociado al macrociclo.
     */
    @Column(name = "Metodologo", nullable = true)
    public String metodologo;

    /**
     * Preparador físico asociado al macrociclo.
     */
    @Column(name = "PreparadorFisico", nullable = true)
    public String preparadorFisico;

    /**
     * Fecha de inicio del macrociclo.
     */
    @Column(name = "FechaInicio", nullable = true)
    @Temporal(TemporalType.DATE)
    private Calendar fechaInicio;

    /**
     * Fecha de fin del macrociclo.
     */
    @Column(name = "FechaFin", nullable = true)
    @Temporal(TemporalType.DATE)
    private Calendar fechaFin;

    /**
     * Lista de etapas asociadas al macrociclo.
     */
    @OneToMany(mappedBy = "macrociclos")
    private List<Etapa> etapas;

    /**
     * Entrenador que creó el macrociclo (clave foránea).
     */
    @ManyToOne()
    @JoinColumn(name = "idEntrenador", referencedColumnName = "ID", nullable = true)
    private Entrenador entrenadores;

    /**
     * Constructor predeterminado.
     */
    public Macrociclo() {
    }

    /**
     * Constructor con parámetros.
     *
     * @param id Identificador único del macrociclo.
     * @param deporte Deporte asociado al macrociclo.
     * @param jefeRama Jefe de rama asociado al macrociclo.
     * @param rama Rama asociada al macrociclo.
     * @param metodologo Metodólogo asociado al macrociclo.
     * @param preparadorFisico Preparador físico asociado al macrociclo.
     * @param fechaInicio Fecha de inicio del macrociclo.
     * @param fechaFin Fecha de fin del macrociclo.
     * @param etapas Lista de etapas asociadas al macrociclo.
     * @param entrenadores Entrenador que creó el macrociclo (clave foránea).
     */
    public Macrociclo(Long id, String deporte, String jefeRama, Ramas rama, String metodologo, String preparadorFisico, Calendar fechaInicio, Calendar fechaFin, List<Etapa> etapas, Entrenador entrenadores) {
        this.id = id;
        this.deporte = deporte;
        this.jefeRama = jefeRama;
        this.rama = rama;
        this.metodologo = metodologo;
        this.preparadorFisico = preparadorFisico;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.etapas = etapas;
        this.entrenadores = entrenadores;
    }

    /**
     * Constructor con parámetros.
     *
     * @param id Identificador único del macrociclo.
     * @param deporte Deporte asociado al macrociclo.
     * @param jefeRama Jefe de rama asociado al macrociclo.
     * @param rama Rama asociada al macrociclo.
     * @param metodologo Metodólogo asociado al macrociclo.
     * @param preparadorFisico Preparador físico asociado al macrociclo.
     * @param fechaInicio Fecha de inicio del macrociclo.
     * @param fechaFin Fecha de fin del macrociclo.
     */
    public Macrociclo(Long id, String deporte, String jefeRama, Ramas rama, String metodologo, String preparadorFisico, Calendar fechaInicio, Calendar fechaFin) {
        this.id = id;
        this.deporte = deporte;
        this.jefeRama = jefeRama;
        this.rama = rama;
        this.metodologo = metodologo;
        this.preparadorFisico = preparadorFisico;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
    }

    /**
     * Constructor con parámetros.
     *
     * @param deporte Deporte asociado al macrociclo.
     * @param jefeRama Jefe de rama asociado al macrociclo.
     * @param rama Rama asociada al macrociclo.
     * @param metodologo Metodólogo asociado al macrociclo.
     * @param preparadorFisico Preparador físico asociado al macrociclo.
     * @param fechaInicio Fecha de inicio del macrociclo.
     * @param fechaFin Fecha de fin del macrociclo.
     */
    public Macrociclo(String deporte, String jefeRama, Ramas rama, String metodologo, String preparadorFisico, Calendar fechaInicio, Calendar fechaFin) {
        this.deporte = deporte;
        this.jefeRama = jefeRama;
        this.rama = rama;
        this.metodologo = metodologo;
        this.preparadorFisico = preparadorFisico;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
    }

    /**
     * Constructor con parámetros.
     *
     * @param deporte Deporte asociado al macrociclo.
     * @param jefeRama Jefe de rama asociado al macrociclo.
     * @param rama Rama asociada al macrociclo.
     * @param metodologo Metodólogo asociado al macrociclo.
     * @param preparadorFisico Preparador físico asociado al macrociclo.
     * @param entrenadores Entrenador que creó el macrociclo (clave foránea).
     */
    public Macrociclo(String deporte, String jefeRama, Ramas rama, String metodologo, String preparadorFisico, Entrenador entrenadores) {
        this.deporte = deporte;
        this.jefeRama = jefeRama;
        this.rama = rama;
        this.metodologo = metodologo;
        this.preparadorFisico = preparadorFisico;
        this.entrenadores = entrenadores;
    }

    /**
     * Método que devuelve el identificador único del macrociclo.
     *
     * @return Identificador único del macrociclo.
     */
    public Long getId() {
        return id;
    }

    /**
     * Método que establece el identificador único del macrociclo.
     *
     * @param id Identificador único del macrociclo.
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Método que devuelve el deporte asociado al macrociclo.
     *
     * @return Deporte asociado al macrociclo.
     */
    public String getDeporte() {
        return deporte;
    }

    /**
     * Método que establece el deporte asociado al macrociclo.
     *
     * @param deporte Deporte asociado al macrociclo.
     */
    public void setDeporte(String deporte) {
        this.deporte = deporte;
    }

    /**
     * Método que devuelve el jefe de rama asociado al macrociclo.
     *
     * @return Jefe de rama asociado al macrociclo.
     */
    public String getJefeRama() {
        return jefeRama;
    }

    /**
     * Método que establece el jefe de rama asociado al macrociclo.
     *
     * @param jefeRama Jefe de rama asociado al macrociclo.
     */
    public void setJefeRama(String jefeRama) {
        this.jefeRama = jefeRama;
    }

    /**
     * Método que devuelve la rama asociada al macrociclo.
     *
     * @return Rama asociada al macrociclo.
     */
    public Ramas getRama() {
        return rama;
    }

    /**
     * Método que establece la rama asociada al macrociclo.
     *
     * @param rama Rama asociada al macrociclo.
     */
    public void setRama(Ramas rama) {
        this.rama = rama;
    }

    /**
     * Método que devuelve el metodólogo asociado al macrociclo.
     *
     * @return Metodólogo asociado al macrociclo.
     */
    public String getMetodologo() {
        return metodologo;
    }

    /**
     * Establece el metodólogo asociado al macrociclo.
     *
     * @param metodologo El nombre del metodólogo.
     */
    public void setMetodologo(String metodologo) {
        this.metodologo = metodologo;
    }

    /**
     * Obtiene el nombre del preparador físico asociado al macrociclo.
     *
     * @return El nombre del preparador físico.
     */
    public String getPreparadorFisico() {
        return preparadorFisico;
    }

    /**
     * Establece el nombre del preparador físico asociado al macrociclo.
     *
     * @param preparadorFisico El nombre del preparador físico.
     */
    public void setPreparadorFisico(String preparadorFisico) {
        this.preparadorFisico = preparadorFisico;
    }

    /**
     * Obtiene la fecha de inicio del macrociclo.
     *
     * @return La fecha de inicio.
     */
    public Calendar getFechaInicio() {
        return fechaInicio;
    }

    /**
     * Establece la fecha de inicio del macrociclo.
     *
     * @param fechaInicio La fecha de inicio.
     */
    public void setFechaInicio(Calendar fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    /**
     * Obtiene la fecha de fin del macrociclo.
     *
     * @return La fecha de fin.
     */
    public Calendar getFechaFin() {
        return fechaFin;
    }

    /**
     * Establece la fecha de fin del macrociclo.
     *
     * @param fechaFin La fecha de fin.
     */
    public void setFechaFin(Calendar fechaFin) {
        this.fechaFin = fechaFin;
    }

    /**
     * Obtiene la lista de etapas asociadas al macrociclo.
     *
     * @return La lista de etapas.
     */
    public List<Etapa> getEtapas() {
        return etapas;
    }

    /**
     * Establece la lista de etapas asociadas al macrociclo.
     *
     * @param etapas La lista de etapas.
     */
    public void setEtapas(List<Etapa> etapas) {
        this.etapas = etapas;
    }

    /**
     * Obtiene el entrenador asociado al macrociclo.
     *
     * @return El entrenador.
     */
    public Entrenador getEntrenador() {
        return entrenadores;
    }

    /**
     * Establece el entrenador asociado al macrociclo.
     *
     * @param entrenadores El entrenador.
     */
    public void setEntrenador(Entrenador entrenadores) {
        this.entrenadores = entrenadores;
    }

    /**
     * Genera un código hash único para el macrociclo.
     *
     * @return El código hash.
     */
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    /**
     * Compara si dos macrociclos son iguales basándose en su identificador
     * único.
     *
     * @param object El objeto a comparar.
     * @return `true` si los macrociclos son iguales, `false` en caso contrario.
     */
    @Override
    public boolean equals(Object object) {
        if (!(object instanceof Macrociclo)) {
            return false;
        }
        Macrociclo other = (Macrociclo) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    /**
     * Devuelve una representación en cadena del objeto Macrociclo.
     *
     * @return Cadena que representa al macrociclo.
     */
    @Override
    public String toString() {
        return "Macrociclo{"
                + "id=" + id
                + ", deporte='" + deporte + '\''
                + ", jefeRama='" + jefeRama + '\''
                + ", rama=" + rama
                + ", metodologo='" + metodologo + '\''
                + ", preparadorFisico='" + preparadorFisico + '\''
                + ", fechaInicio=" + fechaInicio.toString()
                + ", fechaFin=" + fechaFin.toString()
                + ", etapas=" + etapas
                + ", entrenadores=" + entrenadores.getId()
                + '}';
    }
}
