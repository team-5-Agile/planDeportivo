/*
 * EtapasDAO.java
 */
package DAOs;

import Interfaces.BaseDAO;
import Dominio.Etapa;
import Dominio.Macrociclo;
import Herramientas.Fecha;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityNotFoundException;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;
import java.util.List;

/**
 * Clase que implementa operaciones CRUD (Crear, Leer, Actualizar, Eliminar)
 * para la entidad Etapas en la base de datos.
 *
 * @author Equipo #5 - Metodologías Ágiles de Desarrollo
 */
public class EtapasDAO implements BaseDAO {

    private String persistenceUnit;
    Fecha fecha = new Fecha();

    /**
     * Constructor que recibe la unidad de persistencia.
     *
     * @param persistenceUnit La unidad de persistencia a utilizar.
     */
    public EtapasDAO(String persistenceUnit) {
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
     * Registra un nuevo etapa en la base de datos.
     *
     * @param etapa El etapa a registrar.
     * @return El etapa registrado.
     */
    public Etapa registrarEtapa(Etapa etapa) {
        EntityManager entityManager = this.getEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(etapa);
        entityManager.getTransaction().commit();
        entityManager.close();
        return etapa;
    }

    /**
     * Elimina un etapa de la base de datos.
     *
     * @param id El identificador del etapa a eliminar.
     */
    public void eliminarEtapa(Long id) {
        if (verificarEtapa(id)) {
            EntityManager entityManager = this.getEntityManager();
            entityManager.getTransaction().begin();
            Etapa etapa = consultarEtapa(id);
            Etapa actual = entityManager.merge(etapa);
            entityManager.remove(actual);
            entityManager.getTransaction().commit();
            entityManager.close();
        } else {
            throw new EntityNotFoundException("No se puede encontrar el etapa con ID: " + id);
        }
    }

    /**
     * Edita un etapa existente en la base de datos.
     *
     * @param etapa El etapa actualizado.
     * @return El etapa actualizado.
     */
    public Etapa editarEtapa(Etapa etapa) {
        EntityManager entityManager = this.getEntityManager();
        entityManager.getTransaction().begin();
        entityManager.merge(etapa);
        entityManager.getTransaction().commit();
        entityManager.close();
        return etapa;
    }

    /**
     * Consulta un etapa por su identificador en la base de datos.
     *
     * @param id El identificador del etapa.
     * @return El etapa encontrado.
     */
    public Etapa consultarEtapa(Long id) {
        if (verificarEtapa(id)) {
            EntityManager entityManager = this.getEntityManager();
            entityManager.getTransaction().begin();
            Etapa etapa = entityManager.find(Etapa.class, id);
            entityManager.getTransaction().commit();
            entityManager.close();
            return etapa;
        } else {
            throw new EntityNotFoundException("No se puede encontrar el etapa con ID: " + id);
        }
    }

    // Métodos de verificación 
    /**
     * Verifica si un etapa con el ID proporcionado existe en la base de
     * datos.
     *
     * @param id El identificador del etapa.
     * @return `true` si el etapa existe, `false` en caso contrario.
     */
    public Boolean verificarEtapa(Long id) {
        EntityManager entityManager = this.getEntityManager();
        entityManager.getTransaction().begin();
        Etapa etapa = entityManager.find(Etapa.class, id);
        entityManager.getTransaction().commit();
        entityManager.close();
        return etapa != null;
    } 
    
    /**
     * Consulta todos las etapas asociadas a un macrociclo en particular.
     *
     * @param macrociclo El macrociclo para el cual se consulta.
     * @return Lista de todos las etapas asociadas al macrociclo.
     * @throws Exception Si hay algún error en la consulta.
     */
    public List<Etapa> consultarEtapasMacrociclo(Macrociclo macrociclo) throws Exception {
        EntityManager entityManager = this.getEntityManager();
        entityManager.getTransaction().begin();
        TypedQuery<Etapa> query;
        String jpql = "SELECT e FROM Etapa e WHERE e.macrociclo = :macrociclo";
        query = entityManager.createQuery(jpql, Etapa.class);
        query.setParameter("macrociclo", macrociclo);
        List<Etapa> etapas = query.getResultList();
        entityManager.getTransaction().commit();
        entityManager.close();
        return etapas;
    }
}
