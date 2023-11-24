/*
 * AdministradorDAO.java
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
 * Clase que implementa operaciones CRUD (Crear, Leer, Actualizar, Eliminar)
 * para la entidad Administrador en la base de datos.
 *
 * @author Equipo #5 - Metodologías Ágiles de Desarrollo
 */
public class AdministradorDAO implements BaseDAO {

    private String persistenceUnit;

    /**
     * Constructor que recibe la unidad de persistencia.
     *
     * @param persistenceUnit La unidad de persistencia a utilizar.
     */
    public AdministradorDAO(String persistenceUnit) {
        this.persistenceUnit = persistenceUnit;
    }

    /**
     * Obtiene la unidad de persistencia actual.
     *
     * @return La unidad de persistencia actual.
     */
    public String getPersistenceUnit() {
        return persistenceUnit;
    }

    /**
     * Establece la unidad de persistencia.
     *
     * @param persistenceUnit La unidad de persistencia a establecer.
     */
    public void setPersistenceUnit(String persistenceUnit) {
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
     * Registra un nuevo administrador en la base de datos.
     *
     * @param administrador El administrador a registrar.
     * @return El administrador registrado.
     */
    public Administrador registrarAdministrador(Administrador administrador) {
        EntityManager entityManager = this.getEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(administrador);
        entityManager.getTransaction().commit();
        entityManager.close();
        return administrador;
    }

    // Método de eliminación
    /**
     * Elimina un administrador de la base de datos por su ID.
     *
     * @param id El ID del administrador a eliminar.
     * @throws EntityNotFoundException Si no se encuentra el administrador con
     * el ID proporcionado.
     */
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

    // Método de consulta
    /**
     * Consulta un administrador de la base de datos por su ID.
     *
     * @param id El ID del administrador a consultar.
     * @return El administrador consultado.
     * @throws EntityNotFoundException Si no se encuentra el administrador con
     * el ID proporcionado.
     */
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

    // Métodos de verificación
    /**
     * Verifica la existencia de un administrador por su ID.
     *
     * @param id El ID del administrador a verificar.
     * @return True si el administrador existe, False en caso contrario.
     */
    public Boolean verificarAdministrador(Long id) {
        EntityManager entityManager = this.getEntityManager();
        entityManager.getTransaction().begin();
        Administrador administrador = entityManager.find(Administrador.class, id);
        entityManager.getTransaction().commit();
        entityManager.close();
        return administrador != null;
    }

    // Métodos de inicio de sesión
    /**
     * Inicia sesión para un administrador con el usuario y contraseña dados.
     *
     * @param usuario El nombre de usuario del administrador.
     * @param contrasena La contraseña del administrador.
     * @return El administrador si la autenticación es exitosa, null en caso
     * contrario.
     * @throws Exception Si ocurre un error durante el proceso de inicio de
     * sesión.
     */
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

    /**
     * Verifica la existencia de un usuario administrador por su nombre de
     * usuario.
     *
     * @param usuario El nombre de usuario a verificar.
     * @return True si el usuario existe, False en caso contrario.
     * @throws Exception Si ocurre un error durante la verificación.
     */
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

    /**
     * Verifica que el usuario y la contraseña proporcionados coincidan.
     *
     * @param usuario El nombre de usuario.
     * @param contrasena La contraseña.
     * @return True si el usuario y la contraseña coinciden, False en caso
     * contrario.
     * @throws Exception Si ocurre un error durante la verificación.
     */
    public boolean verificarContrasenaUsuario(String usuario, String contrasena) throws Exception {
        EntityManager entityManager = this.getEntityManager();
        entityManager.getTransaction().begin();
        // Consulta el administrador con el usuario dado de la base de datos
        Administrador administrador = this.consultarAdministradoresUsuario(usuario);
        entityManager.getTransaction().commit();
        entityManager.close();
        return administrador.getContrasena().equals(contrasena);
    }

    /**
     * Consulta un administrador de la base de datos por su nombre de usuario.
     *
     * @param usuario El nombre de usuario del administrador a consultar.
     * @return El administrador consultado.
     * @throws Exception Si ocurre un error durante la consulta.
     */
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
