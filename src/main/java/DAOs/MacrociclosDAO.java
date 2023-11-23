/*
 * .java
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
 *
 * @author brawun
 */
public class MacrociclosDAO implements BaseDAO {

    private String persitenceUnit;
    Fecha Fecha = new Fecha();

    public MacrociclosDAO(String persitenceUnit) {
        this.persitenceUnit = persitenceUnit;
    }

    @Override
    public EntityManager getEntityManager() {
        EntityManagerFactory managerFactory = Persistence.createEntityManagerFactory(this.persitenceUnit);
        EntityManager entityManager = managerFactory.createEntityManager();
        return entityManager;
    }

    // Métodos de acceso
    public Macrociclo registrarMacrociclo(Macrociclo macrociclo) {
        EntityManager entityManager = this.getEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(macrociclo);
        entityManager.getTransaction().commit();
        entityManager.close();
        return macrociclo;
    }

    // Metodo de eliminacion
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

    // Métodos de edicion
    public Macrociclo editarMacrociclo(Macrociclo macrociclo) {
        EntityManager entityManager = this.getEntityManager();
        entityManager.getTransaction().begin();
        entityManager.merge(macrociclo);
        entityManager.getTransaction().commit();
        entityManager.close();
        return macrociclo;
    }

    // Metodo de consultac
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

    // Métodos de verificacion 
    public Boolean verificarMacrociclo(Long id) {
        EntityManager entityManager = this.getEntityManager();
        entityManager.getTransaction().begin();
        Macrociclo macrociclo = entityManager.find(Macrociclo.class, id);
        entityManager.getTransaction().commit();
        entityManager.close();
        return macrociclo != null;
    }
    
    // CONSULTAS TOMANDO EN CUENTA EL ENTRENADOR

    // Metodo que regresa una lista con todos los macrociclos registrados en el sistema por un entrenador en particular
    public List<Macrociclo> consultarMacrociclosVigentes(Entrenador entrenador) throws Exception {
        EntityManager entityManager = this.getEntityManager();
        entityManager.getTransaction().begin();
        TypedQuery<Macrociclo> query;
        Long idEntrenador = entrenador.getId();
        // Modificar la JPQL para incluir condiciones de fecha
        String jpql = "SELECT m FROM Macrociclo m WHERE m.idEntrenador = :idEntrenador AND "
                + ":fechaActual BETWEEN m.fechaInicio AND m.fechaFin";
        query = entityManager.createQuery(jpql, Macrociclo.class);
        query.setParameter("idEntrenador", idEntrenador);
        // Configurar el parámetro de fecha actual con TemporalType.TIMESTAMP
        query.setParameter("fechaActual", Fecha.fechaAhora(), TemporalType.TIMESTAMP);
        List<Macrociclo> macrociclos = query.getResultList();
        entityManager.getTransaction().commit();
        entityManager.close();
        return macrociclos;
    }

    // Metodo que regresa una lista con todos los macrociclos registrados en el sistema por un entrenador en particular
    public List<Macrociclo> consultarMacrociclosNoVigentes(Entrenador entrenador) throws Exception {
        EntityManager entityManager = this.getEntityManager();
        entityManager.getTransaction().begin();
        TypedQuery<Macrociclo> query;
        Long idEntrenador = entrenador.getId();
        // Modificar la JPQL para incluir condiciones de fecha
        String jpql = "SELECT m FROM Macrociclo m WHERE m.idEntrenador = :idEntrenador AND "
                + ":fechaActual NOT BETWEEN m.fechaInicio AND m.fechaFin";
        query = entityManager.createQuery(jpql, Macrociclo.class);
        query.setParameter("idEntrenador", idEntrenador);
        // Configurar el parámetro de fecha actual con TemporalType.TIMESTAMP
        query.setParameter("fechaActual", Fecha.fechaAhora(), TemporalType.TIMESTAMP);
        List<Macrociclo> macrociclos = query.getResultList();
        entityManager.getTransaction().commit();
        entityManager.close();
        return macrociclos;
    }

    // Metodo que regresa una lista con todos los macrociclos registrados en el sistema por un entrenador en particular
    public List<Macrociclo> consultarMacrociclosFuturos(Entrenador entrenador) throws Exception {
        EntityManager entityManager = this.getEntityManager();
        entityManager.getTransaction().begin();
        TypedQuery<Macrociclo> query;
        Long idEntrenador = entrenador.getId();
        // Modificar la JPQL para incluir condiciones de fecha
        String jpql = "SELECT m FROM Macrociclo m WHERE m.idEntrenador = :idEntrenador AND "
                + "m.fechaInicio > :fechaActual";
        query = entityManager.createQuery(jpql, Macrociclo.class);
        query.setParameter("idEntrenador", idEntrenador);
        // Configurar el parámetro de fecha actual con TemporalType.TIMESTAMP
        query.setParameter("fechaActual", Fecha.fechaAhora(), TemporalType.TIMESTAMP);
        List<Macrociclo> macrociclos = query.getResultList();
        entityManager.getTransaction().commit();
        entityManager.close();
        return macrociclos;
    }
    
    // Metodo que regresa una lista con todos los macrociclos registrados en el sistema por un entrenador en particular
    public List<Macrociclo> consultarMacrociclosPasados(Entrenador entrenador) throws Exception {
        EntityManager entityManager = this.getEntityManager();
        entityManager.getTransaction().begin();
        TypedQuery<Macrociclo> query;
        Long idEntrenador = entrenador.getId();
        // Modificar la JPQL para incluir condiciones de fecha
        String jpql = "SELECT m FROM Macrociclo m WHERE m.idEntrenador = :idEntrenador AND "
                + "m.fechaFin < :fechaActual";
        query = entityManager.createQuery(jpql, Macrociclo.class);
        query.setParameter("idEntrenador", idEntrenador);
        // Configurar el parámetro de fecha actual con TemporalType.TIMESTAMP
        query.setParameter("fechaActual", Fecha.fechaAhora(), TemporalType.TIMESTAMP);
        List<Macrociclo> macrociclos = query.getResultList();
        entityManager.getTransaction().commit();
        entityManager.close();
        return macrociclos;
    }

    // Metodo que regresa una lista con todos los macrociclos registrados en el sistema por un entrenador en particular
    public List<Macrociclo> consultarTodosMacrociclosEntrenador(Entrenador entrenador) throws Exception {
        EntityManager entityManager = this.getEntityManager();
        entityManager.getTransaction().begin();
        TypedQuery<Macrociclo> query;
        Long idEntrenador = entrenador.getId();
        String jpql = "SELECT m FROM Macrociclos m WHERE m.idEntrenador = :idEntrenador";
        query = entityManager.createQuery(jpql, Macrociclo.class);
        query.setParameter("idEntrenador", idEntrenador);
        List<Macrociclo> macrociclos = query.getResultList();
        entityManager.getTransaction().commit();
        entityManager.close();
        return macrociclos;
    }
    
    // CONSULTAS SIN TOMAR EN CUENTA EL ENTRENADOR

    // Metodo que regresa una lista con todos los macrociclos registrados en el sistema
    public List<Macrociclo> consultarTodosMacrociclos() throws Exception {
        EntityManager entityManager = this.getEntityManager();
        entityManager.getTransaction().begin();
        TypedQuery<Macrociclo> query;
        String jpql = "SELECT m FROM Macrociclos m";
        query = entityManager.createQuery(jpql, Macrociclo.class);
        List<Macrociclo> macrociclos = query.getResultList();
        entityManager.getTransaction().commit();
        entityManager.close();
        return macrociclos;
    }
    
    // Metodo que regresa una lista con todos los macrociclos registrados en el sistema por un entrenador en particular
    public List<Macrociclo> consultarTodosMacrociclosVigentes() throws Exception {
        EntityManager entityManager = this.getEntityManager();
        entityManager.getTransaction().begin();
        TypedQuery<Macrociclo> query;
        // Modificar la JPQL para incluir condiciones de fecha
        String jpql = "SELECT m FROM Macrociclo m WHERE :fechaActual BETWEEN m.fechaInicio AND m.fechaFin";
        query = entityManager.createQuery(jpql, Macrociclo.class);
        // Configurar el parámetro de fecha actual con TemporalType.TIMESTAMP
        query.setParameter("fechaActual", Fecha.fechaAhora(), TemporalType.TIMESTAMP);
        List<Macrociclo> macrociclos = query.getResultList();
        entityManager.getTransaction().commit();
        entityManager.close();
        return macrociclos;
    }

    // Metodo que regresa una lista con todos los macrociclos registrados en el sistema por un entrenador en particular
    public List<Macrociclo> consultarTodosMacrociclosNoVigentes() throws Exception {
        EntityManager entityManager = this.getEntityManager();
        entityManager.getTransaction().begin();
        TypedQuery<Macrociclo> query;
        // Modificar la JPQL para incluir condiciones de fecha
        String jpql = "SELECT m FROM Macrociclo m WHERE :fechaActual NOT BETWEEN m.fechaInicio AND m.fechaFin";
        query = entityManager.createQuery(jpql, Macrociclo.class);
        // Configurar el parámetro de fecha actual con TemporalType.TIMESTAMP
        query.setParameter("fechaActual", Fecha.fechaAhora(), TemporalType.TIMESTAMP);
        List<Macrociclo> macrociclos = query.getResultList();
        entityManager.getTransaction().commit();
        entityManager.close();
        return macrociclos;
    }

    // Metodo que regresa una lista con todos los macrociclos registrados en el sistema por un entrenador en particular
    public List<Macrociclo> consultarTodosMacrociclosFuturos() throws Exception {
        EntityManager entityManager = this.getEntityManager();
        entityManager.getTransaction().begin();
        TypedQuery<Macrociclo> query;
        // Modificar la JPQL para incluir condiciones de fecha
        String jpql = "SELECT m FROM Macrociclo m WHERE m.fechaInicio > :fechaActual";
        query = entityManager.createQuery(jpql, Macrociclo.class);
        // Configurar el parámetro de fecha actual con TemporalType.TIMESTAMP
        query.setParameter("fechaActual", Fecha.fechaAhora(), TemporalType.TIMESTAMP);
        List<Macrociclo> macrociclos = query.getResultList();
        entityManager.getTransaction().commit();
        entityManager.close();
        return macrociclos;
    }
    
    // Metodo que regresa una lista con todos los macrociclos registrados en el sistema por un entrenador en particular
    public List<Macrociclo> consultarTodosMacrociclosPasados() throws Exception {
        EntityManager entityManager = this.getEntityManager();
        entityManager.getTransaction().begin();
        TypedQuery<Macrociclo> query;
        // Modificar la JPQL para incluir condiciones de fecha
        String jpql = "SELECT m FROM Macrociclo m WHERE m.fechaFin < :fechaActual";
        query = entityManager.createQuery(jpql, Macrociclo.class);
        // Configurar el parámetro de fecha actual con TemporalType.TIMESTAMP
        query.setParameter("fechaActual", Fecha.fechaAhora(), TemporalType.TIMESTAMP);
        List<Macrociclo> macrociclos = query.getResultList();
        entityManager.getTransaction().commit();
        entityManager.close();
        return macrociclos;
    }
}
