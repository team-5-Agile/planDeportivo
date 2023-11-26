/*
 * MediosDAO.java
 */
package DAOs;

import Dominio.Entrenador;
import Interfaces.BaseDAO;
import Dominio.Medio;
import Herramientas.Fecha;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityNotFoundException;
import jakarta.persistence.Persistence;
import jakarta.persistence.TemporalType;
import jakarta.persistence.TypedQuery;
import java.util.Calendar;
import java.util.List;

/**
 * Clase que implementa operaciones CRUD (Crear, Leer, Actualizar, Eliminar)
 * para la entidad Medios en la base de datos.
 *
 * @author Equipo #5 - Metodologías Ágiles de Desarrollo
 */
public class MediosDAO implements BaseDAO {

    private String persistenceUnit;
    Fecha fecha = new Fecha();

    /**
     * Constructor que recibe la unidad de persistencia.
     *
     * @param persistenceUnit La unidad de persistencia a utilizar.
     */
    public MediosDAO(String persistenceUnit) {
        this.persistenceUnit = persistenceUnit;
    }

    /**
     * Obtiene un EntityManager para realizar operaciones en la base de datos.
     *
     * @return EntityManager para la unidad de persistencia actual.
     */
    @Override
    public EntityManager getEntityManager() {
        EntityManagerFactory managerFactory = Persistence.createEntityManagerFactory(this.persistenceUnit);
        EntityManager entityManager = managerFactory.createEntityManager();
        return entityManager;
    }

    // Métodos de acceso
    /**
     * Registra un nuevo medio en la base de datos.
     *
     * @param medio El medio a registrar.
     * @return El medio registrado.
     */
    public Medio registrarMedio(Medio medio) {
        EntityManager entityManager = this.getEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(medio);
        entityManager.getTransaction().commit();
        entityManager.close();
        return medio;
    }

    /**
     * Elimina un medio de la base de datos.
     *
     * @param id El identificador del medio a eliminar.
     */
    public void eliminarMedio(Long id) {
        if (verificarMedio(id)) {
            EntityManager entityManager = this.getEntityManager();
            entityManager.getTransaction().begin();
            Medio medio = consultarMedio(id);
            Medio actual = entityManager.merge(medio);
            entityManager.remove(actual);
            entityManager.getTransaction().commit();
            entityManager.close();
        } else {
            throw new EntityNotFoundException("No se puede encontrar el medio con ID: " + id);
        }
    }

    /**
     * Edita un medio existente en la base de datos.
     *
     * @param medio El medio actualizado.
     * @return El medio actualizado.
     */
    public Medio editarMedio(Medio medio) {
        EntityManager entityManager = this.getEntityManager();
        entityManager.getTransaction().begin();
        entityManager.merge(medio);
        entityManager.getTransaction().commit();
        entityManager.close();
        return medio;
    }

    /**
     * Consulta un medio por su identificador en la base de datos.
     *
     * @param id El identificador del medio.
     * @return El medio encontrado.
     */
    public Medio consultarMedio(Long id) {
        if (verificarMedio(id)) {
            EntityManager entityManager = this.getEntityManager();
            entityManager.getTransaction().begin();
            Medio medio = entityManager.find(Medio.class, id);
            entityManager.getTransaction().commit();
            entityManager.close();
            return medio;
        } else {
            throw new EntityNotFoundException("No se puede encontrar el medio con ID: " + id);
        }
    }

    // Métodos de verificación 
    /**
     * Verifica si un medio con el ID proporcionado existe en la base de
     * datos.
     *
     * @param id El identificador del medio.
     * @return `true` si el medio existe, `false` en caso contrario.
     */
    public Boolean verificarMedio(Long id) {
        EntityManager entityManager = this.getEntityManager();
        entityManager.getTransaction().begin();
        Medio medio = entityManager.find(Medio.class, id);
        entityManager.getTransaction().commit();
        entityManager.close();
        return medio != null;
    }   
}
