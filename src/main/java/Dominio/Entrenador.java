/*
 * Entrenador.java
 */
package Dominio;

import jakarta.persistence.CascadeType;
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
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import java.util.Calendar;
import java.util.Objects;

/**
 * Descripción general de la clase: Esta clase representa a un Entrenador en el
 * sistema. Un Entrenador puede crear y gestionar macrociclos.
 *
 * Atributos: - id: Identificador único del entrenador. - nombre: Nombre del
 * entrenador. - apellidoPaterno: Apellido paterno del entrenador. -
 * apellidoMaterno: Apellido materno del entrenador. - contrasena: Contraseña
 * asociada al entrenador. - usuario: Nombre de usuario del entrenador. -
 * fechaRegistro: Fecha de registro del entrenador en el sistema. - macrociclos:
 * Lista de macrociclos creados por el entrenador. - administrador:
 * Administrador que registró al entrenador (clave foránea).
 *
 * Autor: Equipo #5 - Metodologías Ágiles de Desarrollo
 */
@Entity
@Table(name = "entrenadores")
public class Entrenador implements Serializable {

    /**
     * Identificador único del entrenador.
     */
    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * Nombre del entrenador.
     */
    @Column(name = "Nombre", nullable = true)
    public String nombre;

    /**
     * Apellido paterno del entrenador.
     */
    @Column(name = "ApellidoPaterno", nullable = true)
    public String apellidoPaterno;

    /**
     * Apellido materno del entrenador.
     */
    @Column(name = "ApellidoMaterno", nullable = true)
    public String apellidoMaterno;

    /**
     * Contraseña asociada al entrenador.
     */
    @Column(name = "Contrasena", nullable = false, unique = false)
    public String contrasena;

    /**
     * Nombre de usuario del entrenador.
     */
    @Column(name = "Usuario", nullable = false, unique = true)
    public String usuario;

    /**
     * Fecha de registro del entrenador en el sistema.
     */
    @Column(name = "FechaRegistro", nullable = true)
    @Temporal(TemporalType.DATE)
    private Calendar fechaRegistro;

    /**
     * Lista de macrociclos creados por el entrenador.
     */
    @OneToMany(mappedBy = "entrenadores", cascade = CascadeType.REMOVE)
    private List<Macrociclo> macrociclos;

    /**
     * Administrador que registró al entrenador (clave foránea).
     */
    @ManyToOne()
    @JoinColumn(name = "idAdministrador", referencedColumnName = "ID", nullable = true)
    private Administrador administrador;

    /**
     * Constructor predeterminado.
     */
    public Entrenador() {
    }

    /**
     * Constructor con parámetros.
     *
     * @param id Identificador único del entrenador.
     * @param nombre Nombre del entrenador.
     * @param apellidoPaterno Apellido paterno del entrenador.
     * @param apellidoMaterno Apellido materno del entrenador.
     * @param contrasena Contraseña asociada al entrenador.
     * @param usuario Nombre de usuario del entrenador.
     * @param fechaRegistro Fecha de registro del entrenador en el sistema.
     * @param macrociclos Lista de macrociclos creados por el entrenador.
     * @param administrador Administrador que registró al entrenador (clave
     * foránea).
     */
    public Entrenador(Long id, String nombre, String apellidoPaterno, String apellidoMaterno, String contrasena, String usuario, Calendar fechaRegistro, List<Macrociclo> macrociclos, Administrador administrador) {
        this.id = id;
        this.nombre = nombre;
        this.apellidoPaterno = apellidoPaterno;
        this.apellidoMaterno = apellidoMaterno;
        this.contrasena = contrasena;
        this.usuario = usuario;
        this.fechaRegistro = fechaRegistro;
        this.macrociclos = macrociclos;
        this.administrador = administrador;
    }

    /**
     * Constructor con parámetros.
     *
     * @param id Identificador único del entrenador.
     * @param nombre Nombre del entrenador.
     * @param apellidoPaterno Apellido paterno del entrenador.
     * @param apellidoMaterno Apellido materno del entrenador.
     * @param contrasena Contraseña asociada al entrenador.
     * @param usuario Nombre de usuario del entrenador.
     */
    public Entrenador(Long id, String nombre, String apellidoPaterno, String apellidoMaterno, String contrasena, String usuario) {
        this.id = id;
        this.nombre = nombre;
        this.apellidoPaterno = apellidoPaterno;
        this.apellidoMaterno = apellidoMaterno;
        this.contrasena = contrasena;
        this.usuario = usuario;
    }

    /**
     * Constructor con parámetros.
     *
     * @param nombre Nombre del entrenador.
     * @param apellidoPaterno Apellido paterno del entrenador.
     * @param apellidoMaterno Apellido materno del entrenador.
     * @param contrasena Contraseña asociada al entrenador.
     * @param usuario Nombre de usuario del entrenador.
     */
    public Entrenador(String nombre, String apellidoPaterno, String apellidoMaterno, String contrasena, String usuario) {
        this.nombre = nombre;
        this.apellidoPaterno = apellidoPaterno;
        this.apellidoMaterno = apellidoMaterno;
        this.contrasena = contrasena;
        this.usuario = usuario;
    }

    /**
     * Constructor con parámetros.
     *
     * @param nombre Nombre del entrenador.
     * @param apellidoPaterno Apellido paterno del entrenador.
     * @param apellidoMaterno Apellido materno del entrenador.
     * @param contrasena Contraseña asociada al entrenador.
     * @param usuario Nombre de usuario del entrenador.
     * @param fechaRegistro Fecha de registro del entrenador en el sistema.
     * @param administrador Administrador que registró al entrenador (clave
     * foránea).
     */
    public Entrenador(String nombre, String apellidoPaterno, String apellidoMaterno, String contrasena, String usuario, Calendar fechaRegistro, Administrador administrador) {
        this.nombre = nombre;
        this.apellidoPaterno = apellidoPaterno;
        this.apellidoMaterno = apellidoMaterno;
        this.contrasena = contrasena;
        this.usuario = usuario;
        this.fechaRegistro = fechaRegistro;
        this.administrador = administrador;
    }

    /**
     * Método que devuelve el identificador único del entrenador.
     *
     * @return Identificador único del entrenador.
     */
    public Long getId() {
        return id;
    }

    /**
     * Método que establece el identificador único del entrenador.
     *
     * @param id Identificador único del entrenador.
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Método que devuelve el nombre del entrenador.
     *
     * @return Nombre del entrenador.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Método que establece el nombre del entrenador.
     *
     * @param nombre Nombre del entrenador.
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Método que devuelve el apellido paterno del entrenador.
     *
     * @return Apellido paterno del entrenador.
     */
    public String getApellidoPaterno() {
        return apellidoPaterno;
    }

    /**
     * Método que establece el apellido paterno del entrenador.
     *
     * @param apellidoPaterno Apellido paterno del entrenador.
     */
    public void setApellidoPaterno(String apellidoPaterno) {
        this.apellidoPaterno = apellidoPaterno;
    }

    /**
     * Método que devuelve el apellido materno del entrenador.
     *
     * @return Apellido materno del entrenador.
     */
    public String getApellidoMaterno() {
        return apellidoMaterno;
    }

    /**
     * Método que establece el apellido materno del entrenador.
     *
     * @param apellidoMaterno Apellido materno del entrenador.
     */
    public void setApellidoMaterno(String apellidoMaterno) {
        this.apellidoMaterno = apellidoMaterno;
    }

    /**
     * Método que devuelve la contraseña asociada al entrenador.
     *
     * @return Contraseña asociada al entrenador.
     */
    public String getContrasena() {
        return contrasena;
    }

    /**
     * Método que establece la contraseña asociada al entrenador.
     *
     * @param contrasena Contraseña asociada al entrenador.
     */
    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    /**
     * Método que devuelve el nombre de usuario del entrenador.
     *
     * @return Nombre de usuario del entrenador.
     */
    public String getUsuario() {
        return usuario;
    }

    /**
     * Método que establece el nombre de usuario del entrenador.
     *
     * @param usuario Nombre de usuario del entrenador.
     */
    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    /**
     * Método que devuelve la fecha de registro del entrenador en el sistema.
     *
     * @return Fecha de registro del entrenador.
     */
    public Calendar getFechaRegistro() {
        return fechaRegistro;
    }

    /**
     * Método que establece la fecha de registro del entrenador en el sistema.
     *
     * @param fechaRegistro Fecha de registro del entrenador.
     */
    public void setFechaRegistro(Calendar fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    /**
     * Método que devuelve la lista de macrociclos creados por el entrenador.
     *
     * @return Lista de macrociclos del entrenador.
     */
    public List<Macrociclo> getMacrociclos() {
        return macrociclos;
    }

    /**
     * Método que establece la lista de macrociclos creados por el entrenador.
     *
     * @param macrociclos Lista de macrociclos del entrenador.
     */
    public void setMacrociclos(List<Macrociclo> macrociclos) {
        this.macrociclos = macrociclos;
    }

    /**
     * Método que devuelve el administrador que registró al entrenador.
     *
     * @return Administrador que registró al entrenador.
     */
    public Administrador getAdministrador() {
        return administrador;
    }

    /**
     * Método que establece el administrador que registró al entrenador.
     *
     * @param administrador Administrador que registró al entrenador.
     */
    public void setAdministrador(Administrador administrador) {
        this.administrador = administrador;
    }

    /**
     * Método que genera un código hash basado en el identificador único del
     * entrenador.
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
        final Entrenador other = (Entrenador) obj;
        // Si el entrenador no tiene la misma contraseña, entonces no son iguales
        if (!Objects.equals(this.contrasena, other.contrasena)) {
            return false;
        }
        // Si el entrenador no tiene el mismo nombre de usuario, entonces no son iguales
        if (!Objects.equals(this.usuario, other.usuario)) {
            return false;
        }
        // Devuelve verdadero si los ID son iguales y falso en caso contrario
        return Objects.equals(this.id, other.id);
    }

    /**
     * Método que devuelve una representación en cadena del objeto Entrenador.
     *
     * @return Cadena que representa al entrenador.
     */
    @Override
    public String toString() {
        return "Entrenador{"
                + "id=" + id
                + ", nombre='" + nombre + '\''
                + ", apellidoPaterno='" + apellidoPaterno + '\''
                + ", apellidoMaterno='" + apellidoMaterno + '\''
                + ", contrasena='" + contrasena + '\''
                + ", usuario='" + usuario + '\''
                + ", macrociclos=" + macrociclos
                + ", administrador=" + administrador.getId()
                + '}';
    }
}
