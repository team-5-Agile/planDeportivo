/*
 * MacrociclosDAO.java
 */
package DAOs;

import Dominio.Entrenador;
import Interfaces.BaseDAO;
import Dominio.Macrociclo;
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
 * para la entidad Macrociclo en la base de datos.
 *
 * @author Equipo #5 - Metodologías Ágiles de Desarrollo
 */
public class MacrociclosDAO implements BaseDAO {

    private String persistenceUnit;
    Fecha fecha = new Fecha();

    /**
     * Constructor que recibe la unidad de persistencia.
     *
     * @param persistenceUnit La unidad de persistencia a utilizar.
     */
    public MacrociclosDAO(String persistenceUnit) {
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
     * Registra un nuevo macrociclo en la base de datos.
     *
     * @param macrociclo El macrociclo a registrar.
     * @return El macrociclo registrado.
     */
    public Macrociclo registrarMacrociclo(Macrociclo macrociclo) {
        EntityManager entityManager = this.getEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(macrociclo);
        entityManager.getTransaction().commit();
        entityManager.close();
        return macrociclo;
    }

    /**
     * Inserta fechas en un macrociclo existente y lo actualiza en la base de
     * datos.
     *
     * @param macrociclo El macrociclo existente.
     * @param fechaInicio La nueva fecha de inicio.
     * @param fechaFin La nueva fecha de fin.
     * @return El macrociclo actualizado.
     */
    public Macrociclo insertarFechasMacrociclo(Macrociclo macrociclo, Calendar fechaInicio, Calendar fechaFin) {
        EntityManager entityManager = this.getEntityManager();
        // Obtener el Macrociclo actualizado desde la base de datos
        Macrociclo macrocicloActualizado = entityManager.find(Macrociclo.class, macrociclo.getId());
        if (macrocicloActualizado != null) {
            entityManager.getTransaction().begin();
            // Actualizar las fechas
            macrocicloActualizado.setFechaInicio(fechaInicio);
            macrocicloActualizado.setFechaFin(fechaFin);
            // Realizar la actualización en la base de datos
            entityManager.merge(macrocicloActualizado);
            entityManager.getTransaction().commit();
        }
        entityManager.close();
        // Devolver el Macrociclo actualizado
        return macrocicloActualizado;
    }

    /**
     * Elimina un macrociclo de la base de datos.
     *
     * @param id El identificador del macrociclo a eliminar.
     */
    public void eliminarMacrociclo(Long id) {
        if (verificarMacrociclo(id)) {
            EntityManager entityManager = this.getEntityManager();
            entityManager.getTransaction().begin();
            Macrociclo macrociclo = consultarMacrociclo(id);
            Macrociclo actual = entityManager.merge(macrociclo);
            entityManager.remove(actual);
            entityManager.getTransaction().commit();
            entityManager.close();
        } else {
            throw new EntityNotFoundException("No se puede encontrar el macrociclo con ID: " + id);
        }
    }

    /**
     * Edita un macrociclo existente en la base de datos.
     *
     * @param macrociclo El macrociclo actualizado.
     * @return El macrociclo actualizado.
     */
    public Macrociclo editarMacrociclo(Macrociclo macrociclo) {
        EntityManager entityManager = this.getEntityManager();
        entityManager.getTransaction().begin();
        entityManager.merge(macrociclo);
        entityManager.getTransaction().commit();
        entityManager.close();
        return macrociclo;
    }

    /**
     * Consulta un macrociclo por su identificador en la base de datos.
     *
     * @param id El identificador del macrociclo.
     * @return El macrociclo encontrado.
     */
    public Macrociclo consultarMacrociclo(Long id) {
        if (verificarMacrociclo(id)) {
            EntityManager entityManager = this.getEntityManager();
            entityManager.getTransaction().begin();
            Macrociclo macrociclo = entityManager.find(Macrociclo.class, id);
            entityManager.getTransaction().commit();
            entityManager.close();
            return macrociclo;
        } else {
            throw new EntityNotFoundException("No se puede encontrar el macrociclo con ID: " + id);
        }
    }

    // Métodos de verificación 
    /**
     * Verifica si un macrociclo con el ID proporcionado existe en la base de
     * datos.
     *
     * @param id El identificador del macrociclo.
     * @return `true` si el macrociclo existe, `false` en caso contrario.
     */
    public Boolean verificarMacrociclo(Long id) {
        EntityManager entityManager = this.getEntityManager();
        entityManager.getTransaction().begin();
        Macrociclo macrociclo = entityManager.find(Macrociclo.class, id);
        entityManager.getTransaction().commit();
        entityManager.close();
        return macrociclo != null;
    }

    // CONSULTAS TOMANDO EN CUENTA EL ENTRENADOR
    /**
     * Consulta todos los macrociclos vigentes asociados a un entrenador.
     *
     * @param entrenador El entrenador para el cual se consulta.
     * @return Lista de macrociclos vigentes asociados al entrenador.
     * @throws Exception Si hay algún error en la consulta.
     */
    public List<Macrociclo> consultarMacrociclosVigentes(Entrenador entrenador) throws Exception {
        EntityManager entityManager = this.getEntityManager();
        entityManager.getTransaction().begin();
        TypedQuery<Macrociclo> query;
        String jpql = "SELECT m FROM Macrociclo m WHERE m.entrenadores = :entrenador AND "
                + ":fechaActual BETWEEN m.fechaInicio AND m.fechaFin";
        query = entityManager.createQuery(jpql, Macrociclo.class);
        query.setParameter("entrenador", entrenador);
        query.setParameter("fechaActual", fecha.fechaAhora(), TemporalType.TIMESTAMP);
        List<Macrociclo> macrociclos = query.getResultList();
        entityManager.getTransaction().commit();
        entityManager.close();
        return macrociclos;
    }

    /**
     * Consulta todos los macrociclos no vigentes asociados a un entrenador.
     *
     * @param entrenador El entrenador para el cual se consulta.
     * @return Lista de macrociclos no vigentes asociados al entrenador.
     * @throws Exception Si hay algún error en la consulta.
     */
    public List<Macrociclo> consultarMacrociclosNoVigentes(Entrenador entrenador) throws Exception {
        EntityManager entityManager = this.getEntityManager();
        entityManager.getTransaction().begin();
        TypedQuery<Macrociclo> query;
        String jpql = "SELECT m FROM Macrociclo m WHERE m.entrenadores = :entrenador AND "
                + ":fechaActual NOT BETWEEN m.fechaInicio AND m.fechaFin";
        query = entityManager.createQuery(jpql, Macrociclo.class);
        query.setParameter("entrenador", entrenador);
        query.setParameter("fechaActual", fecha.fechaAhora(), TemporalType.TIMESTAMP);
        List<Macrociclo> macrociclos = query.getResultList();
        entityManager.getTransaction().commit();
        entityManager.close();
        return macrociclos;
    }

    /**
     * Consulta todos los macrociclos futuros asociados a un entrenador.
     *
     * @param entrenador El entrenador para el cual se consulta.
     * @return Lista de macrociclos futuros asociados al entrenador.
     * @throws Exception Si hay algún error en la consulta.
     */
    public List<Macrociclo> consultarMacrociclosFuturos(Entrenador entrenador) throws Exception {
        EntityManager entityManager = this.getEntityManager();
        entityManager.getTransaction().begin();
        TypedQuery<Macrociclo> query;
        String jpql = "SELECT m FROM Macrociclo m WHERE m.entrenadores = :entrenador AND "
                + "m.fechaInicio > :fechaActual";
        query = entityManager.createQuery(jpql, Macrociclo.class);
        query.setParameter("entrenador", entrenador);
        query.setParameter("fechaActual", fecha.fechaAhora(), TemporalType.TIMESTAMP);
        List<Macrociclo> macrociclos = query.getResultList();
        entityManager.getTransaction().commit();
        entityManager.close();
        return macrociclos;
    }

    /**
     * Consulta todos los macrociclos pasados asociados a un entrenador.
     *
     * @param entrenador El entrenador para el cual se consulta.
     * @return Lista de macrociclos pasados asociados al entrenador.
     * @throws Exception Si hay algún error en la consulta.
     */
    public List<Macrociclo> consultarMacrociclosPasados(Entrenador entrenador) throws Exception {
        EntityManager entityManager = this.getEntityManager();
        entityManager.getTransaction().begin();
        TypedQuery<Macrociclo> query;
        String jpql = "SELECT m FROM Macrociclo m WHERE m.entrenadores = :entrenador AND "
                + "m.fechaFin < :fechaActual";
        query = entityManager.createQuery(jpql, Macrociclo.class);
        query.setParameter("entrenador", entrenador);
        query.setParameter("fechaActual", fecha.fechaAhora(), TemporalType.TIMESTAMP);
        List<Macrociclo> macrociclos = query.getResultList();
        entityManager.getTransaction().commit();
        entityManager.close();
        return macrociclos;
    }

    /**
     * Consulta todos los macrociclos asociados a un entrenador en particular,
     * sin tener en cuenta la vigencia.
     *
     * @param entrenador El entrenador para el cual se consulta.
     * @return Lista de todos los macrociclos asociados al entrenador.
     * @throws Exception Si hay algún error en la consulta.
     */
    public List<Macrociclo> consultarTodosMacrociclosEntrenador(Entrenador entrenador) throws Exception {
        EntityManager entityManager = this.getEntityManager();
        entityManager.getTransaction().begin();
        TypedQuery<Macrociclo> query;
        String jpql = "SELECT m FROM Macrociclo m WHERE m.entrenadores = :entrenador";
        query = entityManager.createQuery(jpql, Macrociclo.class);
        query.setParameter("entrenador", entrenador);
        List<Macrociclo> macrociclos = query.getResultList();
        entityManager.getTransaction().commit();
        entityManager.close();
        return macrociclos;
    }

    // CONSULTAS SIN TOMAR EN CUENTA EL ENTRENADOR
    /**
     * Consulta todos los macrociclos registrados en el sistema.
     *
     * @return Lista de todos los macrociclos registrados en el sistema.
     * @throws Exception Si hay algún error en la consulta.
     */
    public List<Macrociclo> consultarTodosMacrociclos() throws Exception {
        EntityManager entityManager = this.getEntityManager();
        entityManager.getTransaction().begin();
        TypedQuery<Macrociclo> query;
        String jpql = "SELECT m FROM Macrociclo m";
        query = entityManager.createQuery(jpql, Macrociclo.class);
        List<Macrociclo> macrociclos = query.getResultList();
        entityManager.getTransaction().commit();
        entityManager.close();
        return macrociclos;
    }

    /**
     * Consulta todos los macrociclos vigentes registrados en el sistema.
     *
     * @return Lista de todos los macrociclos vigentes registrados en el
     * sistema.
     * @throws Exception Si hay algún error en la consulta.
     */
    public List<Macrociclo> consultarTodosMacrociclosVigentes() throws Exception {
        EntityManager entityManager = this.getEntityManager();
        entityManager.getTransaction().begin();
        TypedQuery<Macrociclo> query;
        String jpql = "SELECT m FROM Macrociclo m WHERE :fechaActual BETWEEN m.fechaInicio AND m.fechaFin";
        query = entityManager.createQuery(jpql, Macrociclo.class);
        query.setParameter("fechaActual", fecha.fechaAhora(), TemporalType.TIMESTAMP);
        List<Macrociclo> macrociclos = query.getResultList();
        entityManager.getTransaction().commit();
        entityManager.close();
        return macrociclos;
    }

    /**
     * Consulta todos los macrociclos no vigentes registrados en el sistema.
     *
     * @return Lista de todos los macrociclos no vigentes registrados en el
     * sistema.
     * @throws Exception Si hay algún error en la consulta.
     */
    public List<Macrociclo> consultarTodosMacrociclosNoVigentes() throws Exception {
        EntityManager entityManager = this.getEntityManager();
        entityManager.getTransaction().begin();
        TypedQuery<Macrociclo> query;
        String jpql = "SELECT m FROM Macrociclo m WHERE :fechaActual NOT BETWEEN m.fechaInicio AND m.fechaFin";
        query = entityManager.createQuery(jpql, Macrociclo.class);
        query.setParameter("fechaActual", fecha.fechaAhora(), TemporalType.TIMESTAMP);
        List<Macrociclo> macrociclos = query.getResultList();
        entityManager.getTransaction().commit();
        entityManager.close();
        return macrociclos;
    }

    /**
     * Consulta todos los macrociclos futuros registrados en el sistema.
     *
     * @return Lista de todos los macrociclos futuros registrados en el sistema.
     * @throws Exception Si hay algún error en la consulta.
     */
    public List<Macrociclo> consultarTodosMacrociclosFuturos() throws Exception {
        EntityManager entityManager = this.getEntityManager();
        entityManager.getTransaction().begin();
        TypedQuery<Macrociclo> query;
        String jpql = "SELECT m FROM Macrociclo m WHERE m.fechaInicio > :fechaActual";
        query = entityManager.createQuery(jpql, Macrociclo.class);
        query.setParameter("fechaActual", fecha.fechaAhora(), TemporalType.TIMESTAMP);
        List<Macrociclo> macrociclos = query.getResultList();
        entityManager.getTransaction().commit();
        entityManager.close();
        return macrociclos;
    }

    /**
     * Consulta todos los macrociclos pasados registrados en el sistema.
     *
     * @return Lista de todos los macrociclos pasados registrados en el sistema.
     * @throws Exception Si hay algún error en la consulta.
     */
    public List<Macrociclo> consultarTodosMacrociclosPasados() throws Exception {
        EntityManager entityManager = this.getEntityManager();
        entityManager.getTransaction().begin();
        TypedQuery<Macrociclo> query;
        String jpql = "SELECT m FROM Macrociclo m WHERE m.fechaFin < :fechaActual";
        query = entityManager.createQuery(jpql, Macrociclo.class);
        query.setParameter("fechaActual", fecha.fechaAhora(), TemporalType.TIMESTAMP);
        List<Macrociclo> macrociclos = query.getResultList();
        entityManager.getTransaction().commit();
        entityManager.close();
        return macrociclos;
    }
}
