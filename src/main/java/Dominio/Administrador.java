/*
 * Administrador.java
 */
package Dominio;

import java.io.Serializable;
import java.util.List;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

/**
 * Descripción general de la clase: Esta clase representa a un Administrador en
 * el sistema. Un Administrador puede registrar y gestionar entrenadores.
 *
 * Atributos: - id: Identificador único del administrador. - contrasena:
 * Contraseña asociada al administrador. - usuario: Nombre de usuario del
 * administrador. - entrenadores: Lista de entrenadores registrados por el
 * administrador.
 *
 * Autor: Equipo #5 - Metodologías Ágiles de Desarrollo
 */
@Entity
@Table(name = "administrador")
public class Administrador implements Serializable {

    // Identificador único para cada administrador
    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Contraseña del administrador (no puede ser nula y no debe repetirse)
    @Column(name = "Contrasena", nullable = false, unique = false)
    public String contrasena;

    // Nombre de usuario del administrador (no puede ser nulo y debe ser único)
    @Column(name = "Usuario", nullable = false, unique = true)
    public String usuario;

    // Relación uno a muchos: un administrador puede registrar muchos entrenadores
    @OneToMany(mappedBy = "administrador")
    private List<Entrenador> entrenadores;

    /**
     * Constructor por defecto.
     */
    public Administrador() {
    }

    /**
     * Constructor con todos los atributos.
     *
     * @param id Identificador único del administrador.
     * @param contrasena Contraseña del administrador.
     * @param usuario Nombre de usuario del administrador.
     * @param entrenadores Lista de entrenadores asociados al administrador.
     */
    public Administrador(Long id, String contrasena, String usuario, List<Entrenador> entrenadores) {
        this.id = id;
        this.contrasena = contrasena;
        this.usuario = usuario;
        this.entrenadores = entrenadores;
    }

    /**
     * Constructor con ID, contraseña y usuario.
     *
     * @param id Identificador único del administrador.
     * @param contrasena Contraseña del administrador.
     * @param usuario Nombre de usuario del administrador.
     */
    public Administrador(Long id, String contrasena, String usuario) {
        this.id = id;
        this.contrasena = contrasena;
        this.usuario = usuario;
    }

    /**
     * Constructor sin ID.
     *
     * @param contrasena Contraseña del administrador.
     * @param usuario Nombre de usuario del administrador.
     */
    public Administrador(String contrasena, String usuario) {
        this.contrasena = contrasena;
        this.usuario = usuario;
    }

    /**
     * Obtiene el identificador único del administrador.
     *
     * @return Identificador único del administrador.
     */
    public Long getId() {
        return id;
    }

    /**
     * Establece el identificador único del administrador.
     *
     * @param id Identificador único del administrador.
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Obtiene la contraseña del administrador.
     *
     * @return Contraseña del administrador.
     */
    public String getContrasena() {
        return contrasena;
    }

    /**
     * Establece la contraseña del administrador.
     *
     * @param contrasena Contraseña del administrador.
     */
    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    /**
     * Obtiene el nombre de usuario del administrador.
     *
     * @return Nombre de usuario del administrador.
     */
    public String getUsuario() {
        return usuario;
    }

    /**
     * Establece el nombre de usuario del administrador.
     *
     * @param usuario Nombre de usuario del administrador.
     */
    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    /**
     * Obtiene la lista de entrenadores asociados al administrador.
     *
     * @return Lista de entrenadores asociados al administrador.
     */
    public List<Entrenador> getEntrenadores() {
        return entrenadores;
    }

    /**
     * Establece la lista de entrenadores asociados al administrador.
     *
     * @param entrenadores Lista de entrenadores asociados al administrador.
     */
    public void setEntrenadores(List<Entrenador> entrenadores) {
        this.entrenadores = entrenadores;
    }

    /**
     * Genera un código hash para el administrador.
     *
     * @return Código hash del administrador.
     */
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    /**
     * Compara el administrador con otro objeto para verificar su igualdad.
     *
     * @param object Objeto a comparar con el administrador.
     * @return true si los administradores son iguales, false en caso contrario.
     */
    @Override
    public boolean equals(Object object) {
        if (!(object instanceof Administrador)) {
            return false;
        }
        Administrador other = (Administrador) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    /**
     * Método que devuelve una representación en cadena del objeto
     * Administrador.
     *
     * @return Cadena que representa al administrador.
     */
    @Override
    public String toString() {
        return "Administrador{"
                + "id=" + id
                + ", contrasena='" + contrasena + '\''
                + ", usuario='" + usuario + '\''
                + ", entrenadores=" + entrenadores
                + '}';
    }

}
