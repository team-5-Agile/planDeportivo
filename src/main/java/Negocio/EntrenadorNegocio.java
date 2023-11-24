/*
 * EntrenadorNegocio.java
 */
package Negocio;

// Importaciones
import DAOs.EntrenadoresDAO;
import Dominio.Entrenador;
import Enumeradores.Scope;
import Exceptions.InputException;
import Herramientas.Validaciones;

/**
 * Clase que gestiona la lógica de negocio relacionada con los entrenadores.
 *
 * Atributos:
 * - dao: Instancia de EntrenadoresDAO para realizar operaciones en la base de datos.
 * - val: Instancia de Validaciones para realizar validaciones de entrada.
 *
 * @author Equipo #5 - Metodologías Ágiles de Desarrollo
 */
public class EntrenadorNegocio {

    private EntrenadoresDAO dao; // Acceso a operaciones de base de datos para Entrenadores.
    private Validaciones val; // Herramientas de validación.

    /**
     * Constructor por defecto que inicializa las instancias de EntrenadoresDAO y Validaciones.
     */
    public EntrenadorNegocio() {
        dao = new EntrenadoresDAO("AppPlanU"); // Inicializa el DAO con el nombre de la aplicación.
        val = new Validaciones(); // Inicializa las herramientas de validación.
    }

    /**
     * Constructor que permite especificar el ámbito de la aplicación (TEST o DEV).
     *
     * @param scope El ámbito de la aplicación.
     */
    public EntrenadorNegocio(Scope scope) {
        if (scope == null) {
            return;
        }
        if (scope.equals(Scope.TEST)) {
            this.dao = new EntrenadoresDAO("AppPlanUTest"); // Inicializa el DAO de prueba si el ámbito es TEST.
        }
        if (scope.equals(Scope.DEV)) {
            this.dao = new EntrenadoresDAO("AppPlanU"); // Inicializa el DAO de desarrollo si el ámbito es DEV.
        }
        val = new Validaciones(); // Inicializa las herramientas de validación.
    }

    /**
     * Método que hace llamada a la capa DAO para iniciar sesión en el sistema.
     *
     * @param usuario El usuario a ingresar al sistema.
     * @param contrasena La contraseña del usuario a ingresar al sistema.
     * @return El entrenador si es encontrado en la capa DAO.
     * @throws Exception Excepción que indica un error durante la operación.
     */
    public Entrenador iniciarSesion(String usuario, String contrasena) throws Exception {
        try {
            Entrenador entrenador;
            if (usuario.isBlank()) {
                throw new InputException("Debe llenar el campo usuario", "usuario"); // Valida entrada de usuario.
            }
            if (contrasena.isBlank()) {
                throw new InputException("Debe llenar el campo contraseña", "contrasena"); // Valida entrada de contraseña.
            }
            entrenador = dao.iniciarSesionEntrenador(usuario, contrasena); // Llama a la capa DAO para iniciar sesión.
            return entrenador;
        } catch (Exception ex) {
            // Lanza InputException si la excepción es de tipo InputException.
            if (ex instanceof InputException) {
                throw ex;
            }
            // En caso contrario, lanza una Excepción general.
            throw new Exception(ex.getMessage());
        }
    }
}
