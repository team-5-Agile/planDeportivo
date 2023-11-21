/*
 * .java
 */
package DAOs;

import Interfaces.BaseDAO;
import Dominio.Entrenador;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityNotFoundException;
import jakarta.persistence.NoResultException;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;
import java.util.List;

/**
 *
 * @author brawun
 */
public class EntrenadoresDAO implements BaseDAO {

    private String persitenceUnit;

    public EntrenadoresDAO(String persitenceUnit) {
        this.persitenceUnit = persitenceUnit;
    }

    @Override
    public EntityManager getEntityManager() {
        EntityManagerFactory managerFactory = Persistence.createEntityManagerFactory(this.persitenceUnit);
        EntityManager entityManager = managerFactory.createEntityManager();
        return entityManager;
    }

    // Métodos de acceso
    public Entrenador registrarEntrenador(Entrenador entrenador) {
        EntityManager entityManager = this.getEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(entrenador);
        entityManager.getTransaction().commit();
        entityManager.close();
        return entrenador;
    }

    // Metodo de eliminacion
    public void eliminarEntrenador(Long id) {
        if (verificarEntrenador(id)) {
            EntityManager entityManager = this.getEntityManager();
            entityManager.getTransaction().begin();
            Entrenador entrenador = consultarEntrenador(id);
            Entrenador actual = entityManager.merge(entrenador);
            entityManager.remove(actual);
            entityManager.getTransaction().commit();
            entityManager.close();
        } else {
            throw new EntityNotFoundException("No se puede encontrar el entrenador con ID: " + id);
        }
    }

    // Metodo de consultac
    public Entrenador consultarEntrenador(Long id) {
        if (verificarEntrenador(id)) {
            EntityManager entityManager = this.getEntityManager();
            entityManager.getTransaction().begin();
            Entrenador entrenador = entityManager.find(Entrenador.class, id);
            entityManager.getTransaction().commit();
            entityManager.close();
            return entrenador;
        } else {
            throw new EntityNotFoundException("No se puede encontrar el entrenador con ID: " + id);
        }
    }

    // Métodos de verificacion 
    public Boolean verificarEntrenador(Long id) {
        EntityManager entityManager = this.getEntityManager();
        entityManager.getTransaction().begin();
        Entrenador entrenador = entityManager.find(Entrenador.class, id);
        entityManager.getTransaction().commit();
        entityManager.close();
        return entrenador != null;
    }

    // Métodos de inicio de sesión
    public Entrenador iniciarSesionEntrenador(String usuario, String contrasena) throws Exception {
        if (verificarUsuarioEntrenador(usuario)) {
            EntityManager entityManager = this.getEntityManager();
            entityManager.getTransaction().begin();
            // Entrenador a regresar inicializado
            Entrenador entrenador = null;
            if (this.verificarContrasenaUsuario(usuario, contrasena)) {
                // Se busca entrenador a regresar
                entrenador = this.consultarEntrenadoresUsuario(usuario);
            } else {
                return null;
            }
            entityManager.getTransaction().commit();
            entityManager.close();
            return entrenador;
        } else {
            return null;
        }
    }

    // Verificar que exista en la base de datos, regresa verdadero si el usuario ha sido encontrado en la base de datos
    public boolean verificarUsuarioEntrenador(String usuario) throws Exception {
        EntityManager entityManager = this.getEntityManager();
        entityManager.getTransaction().begin();
        TypedQuery<Entrenador> query;
        String jpql = "SELECT e FROM Entrenador e WHERE e.usuario = :usuario";
        query = entityManager.createQuery(jpql, Entrenador.class);
        query.setParameter("usuario", usuario);
        entityManager.getTransaction().commit();
        try {
            query.getSingleResult();
        } catch (NoResultException e) {
            entityManager.close();
            return false;
        }
        entityManager.close();
        return true;
    }

    // Verifica que el usuario dado y la contrasena dado correspondan entre si, regresa verdadero si el usuario y la contrasena corresponden
    public boolean verificarContrasenaUsuario(String usuario, String contrasena) throws Exception {
        EntityManager entityManager = this.getEntityManager();
        entityManager.getTransaction().begin();
        // Consulta el entrenador con el usuario dado de la base de datos
        Entrenador entrenador = this.consultarEntrenadoresUsuario(usuario);
        entityManager.getTransaction().commit();
        entityManager.close();
        return entrenador.getContrasena().equals(contrasena);
    }

    // Consulta de la base de datos un objeto de tipo Entrenador, solamente solicitando el usuario, regresa un objeto si se halla un entrenador en la base de datos con el usuario dado
    public Entrenador consultarEntrenadoresUsuario(String usuario) throws Exception {
        EntityManager entityManager = this.getEntityManager();
        entityManager.getTransaction().begin();
        TypedQuery<Entrenador> query;
        String jpql = "SELECT e FROM Entrenador e WHERE e.usuario = :usuario";
        query = entityManager.createQuery(jpql, Entrenador.class);
        query.setParameter("usuario", usuario);
        Entrenador entrenador = query.getSingleResult();
        entityManager.getTransaction().commit();
        entityManager.close();
        return entrenador;
    }

    // Metodo que regresa una lista con todos los entrenadores registrados en la base de datos
    public List<Entrenador> consultarTodosEntrenadores() throws Exception {
        EntityManager entityManager = this.getEntityManager();
        entityManager.getTransaction().begin();
        TypedQuery<Entrenador> query;
        String jpql = "SELECT e FROM Entrenador e";
        query = entityManager.createQuery(jpql, Entrenador.class);
        List<Entrenador> entrenador = query.getResultList();
        entityManager.getTransaction().commit();
        entityManager.close();
        return entrenador;
    }
}
