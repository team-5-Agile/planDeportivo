/**
 * AppPlan.java
 */

package Main;

import DAOs.AdministradorDAO;
import Dominio.Administrador;
import GUI.Login;

/**
 * La clase AppPlan es la clase principal del programa.
 * Sirve como punto de entrada para la aplicación Plan Deportivo.
 * 
 * @author Equipo 5
 */
public class AppPlan {

    /**
     * Método principal que inicia la aplicación Plan.
     * 
     * @param args Los argumentos de la línea de comandos
     */
    public static void main(String[] args) throws Exception {
        // Se crea el usuario de tipo administrador en caso que no exista
        AdministradorDAO DAO = new AdministradorDAO("AppPlanU");
        if (!DAO.verificarUsuarioAdministrador("admin")) {
            Administrador admin = new Administrador("root", "admin");
            DAO.registrarAdministrador(admin);
        }
        
        // Se abre el formulario de inicio de sesión
        Login login = new Login();
        login.setVisible(true);
        
        // Administrador
        // Usuario: admin
        // Contraseña: root
        
        // Base de Datos
        // Nombre: appplan
        // Contraseña: u6$2{4/Cl
    }
}
