/*
 * BaseDAO.java
 */
package Interfaces;

// Importaciones
import jakarta.persistence.Entity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

/**
 * Interface base para clases concretas de acceso a datos
 * @author Equipo #5 - Metodologías Ágiles de Desarrollo
 */
public interface BaseDAO {
    /**
     * Este método se utiliza para obtener una instancia de entity manager de
     * acuerdo al Persistence Unit Name configurado en el archivo persistence.xml <br>
     * <b>persistenceUnit</b> es un atributo qué es especificado en el constructor
     * de las clases que concretas que implementan esta interfaz.
     *
     * @return devuelve una instancia de EntityManager
     */
     EntityManager getEntityManager();
      
    /// Agregar métodos que pueden ser reutilizados.
}
