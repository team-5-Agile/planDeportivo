/*
 * AdministradorNegocio.java
 */
package Negocio;

// Importaciones
import DAOs.AdministradorDAO;
import Dominio.Administrador;
import Enumeradores.Scope;
import Exceptions.InputException;
import Herramientas.Validaciones;

/**
 * Clase que representa la lógica de negocio para la gestión de Administradores en el sistema.
 *
 * Atributos:
 * - dao: Instancia de AdministradorDAO para interactuar con la capa de acceso a datos.
 * - val: Instancia de Validaciones para realizar validaciones en la lógica de negocio.
 *
 * @author Equipo #5 - Metodologías Ágiles de Desarrollo
 */

public class AdministradorNegocio {

    private AdministradorDAO dao; // Acceso a operaciones de base de datos para Administradores.
    private Validaciones val; // Herramientas de validación.

    /**
     * Constructor predeterminado que inicializa las instancias de AdministradorDAO y Validaciones.
     */
    public AdministradorNegocio() {
        dao = new AdministradorDAO("AppPlanU"); // Inicializa el DAO con el nombre de la aplicación.
        val = new Validaciones(); // Inicializa las herramientas de validación.
    }

    /**
     * Constructor que permite definir el alcance de la instancia, utilizado para testing.
     *
     * @param scope Define el alcance de la instancia (TEST o DEV).
     */
    public AdministradorNegocio(Scope scope) {
        if (scope == null) {
            return;
        }
        if (scope.equals(Scope.TEST)) {
            this.dao = new AdministradorDAO("AppPlanUTest"); // Inicializa el DAO de prueba si el ámbito es TEST.
        }
        if (scope.equals(Scope.DEV)) {
            this.dao = new AdministradorDAO("AppPlanU"); // Inicializa el DAO de desarrollo si el ámbito es DEV.
        }
        val = new Validaciones(); // Inicializa las herramientas de validación.
    }

    /**
     * Método que hace llamada a la capa DAO para iniciar sesión en el sistema.
     *
     * @param usuario Representa el usuario a ingresar al sistema.
     * @param contrasena Representa la contraseña del usuario a ingresar al sistema.
     * @return Devuelve el objeto Administrador si es encontrado en la capa DAO.
     * @throws Exception Devuelve una excepción si ocurre algún error.
     */
    public Administrador iniciarSesion(String usuario, String contrasena) throws Exception {
        try {
            Administrador administrador;
            if (usuario.isBlank()) {
                throw new InputException("Debe llenar el campo usuario", "usuario"); // Valida entrada de usuario.
            }
            if (contrasena.isBlank()) {
                throw new InputException("Debe llenar el campo contraseña", "contrasena"); // Valida entrada de contraseña.
            }
            administrador = dao.iniciarSesionAdministrador(usuario, contrasena); // Llama a la capa DAO para iniciar sesión.
            return administrador;
        } catch (Exception ex) {
            // Lanza InputException si la excepción es de tipo InputException.
            if (ex instanceof InputException) {
                throw ex;
            }
            // En caso contrario, lanza una excepción general.
            throw new Exception(ex.getMessage());
        }
    }
}
