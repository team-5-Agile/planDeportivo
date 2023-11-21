/*
 * .java
 */
package DAOs;

import Interfaces.BaseDAO;
import Dominio.Administrador;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityNotFoundException;
import jakarta.persistence.NoResultException;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;

/**
 *
 * @author brawun
 */
public class AdministradorDAO implements BaseDAO {

    private String persitenceUnit;

    public AdministradorDAO(String persitenceUnit) {
        this.persitenceUnit = persitenceUnit;
    }
    
    public String getPersitenceUnit() {
        return persitenceUnit;
    }

    public void setPersitenceUnit(String persitenceUnit) {
        this.persitenceUnit = persitenceUnit;
    }
    
    @Override
    public EntityManager getEntityManager() {
        EntityManagerFactory managerFactory = Persistence.createEntityManagerFactory(this.persitenceUnit);
        EntityManager entityManager = managerFactory.createEntityManager();
        return entityManager;
    }

    // Métodos de acceso
    public Administrador registrarAdministrador(Administrador administrador) {
        EntityManager entityManager = this.getEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(administrador);
        entityManager.getTransaction().commit();
        entityManager.close();
        return administrador;
    }

    // Metodo de eliminacion
    public void eliminarAdministrador(Long id) {
        if (verificarAdministrador(id)) {
            EntityManager entityManager = this.getEntityManager();
            entityManager.getTransaction().begin();
            Administrador administrador = consultarAdministrador(id);
            entityManager.remove(administrador);
            entityManager.getTransaction().commit();
            entityManager.close();
        } else {
            throw new EntityNotFoundException("No se puede encontrar el administrador con ID: " + id);
        }
    }

    // Metodo de consultac
    public Administrador consultarAdministrador(Long id) {
        if (verificarAdministrador(id)) {
            EntityManager entityManager = this.getEntityManager();
            entityManager.getTransaction().begin();
            Administrador administrador = entityManager.find(Administrador.class, id);
            entityManager.getTransaction().commit();
            entityManager.close();
            return administrador;
        } else {
            throw new EntityNotFoundException("No se puede encontrar el administrador con ID: " + id);
        }
    }

    // Métodos de verificacion 
    public Boolean verificarAdministrador(Long id) {
        EntityManager entityManager = this.getEntityManager();
        entityManager.getTransaction().begin();
        Administrador administrador = entityManager.find(Administrador.class, id);
        entityManager.getTransaction().commit();
        entityManager.close();
        return administrador != null;
    }
    
    // Métodos de inicio de sesión
    public Administrador iniciarSesionAdministrador(String usuario, String contrasena) throws Exception {
        if (verificarUsuarioAdministrador(usuario)) {
            EntityManager entityManager = this.getEntityManager();
            entityManager.getTransaction().begin();
            // Administrador a regresar inicializado
            Administrador administrador = null;
            if (this.verificarContrasenaUsuario(usuario, contrasena)) {
                // Se busca administrador a regresar
                administrador = this.consultarAdministradoresUsuario(usuario);
            } else {
                return null;
            }
            entityManager.getTransaction().commit();
            entityManager.close();
            return administrador;
        } else {
            return null;
        }
    }

    // Verificar que exista en la base de datos, regresa verdadero si el usuario ha sido encontrado en la base de datos
    public boolean verificarUsuarioAdministrador(String usuario) throws Exception {
        EntityManager entityManager = this.getEntityManager();
        entityManager.getTransaction().begin();
        TypedQuery<Administrador> query;
        String jpql = "SELECT a FROM Administrador a WHERE a.usuario = :usuario";
        query = entityManager.createQuery(jpql, Administrador.class);
        query.setParameter("usuario", usuario);
        entityManager.getTransaction().commit();
        try {
            Administrador adminis = query.getSingleResult();
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
        // Consulta el administrador con el usuario dado de la base de datos
        Administrador administrador = this.consultarAdministradoresUsuario(usuario);
        entityManager.getTransaction().commit();
        entityManager.close();
        return administrador.getContrasena().equals(contrasena);
    }

    // Consulta de la base de datos un objeto de tipo Administrador, solamente solicitando el usuario, regresa un objeto si se halla un administrador en la base de datos con el usuario dado
    public Administrador consultarAdministradoresUsuario(String usuario) throws Exception {
        EntityManager entityManager = this.getEntityManager();
        entityManager.getTransaction().begin();
        TypedQuery<Administrador> query;
        String jpql = "SELECT a FROM Administrador a WHERE a.usuario = :usuario";
        query = entityManager.createQuery(jpql, Administrador.class);
        query.setParameter("usuario", usuario);
        Administrador administrador = query.getSingleResult();
        entityManager.getTransaction().commit();
        entityManager.close();
        return administrador;
    }
}
