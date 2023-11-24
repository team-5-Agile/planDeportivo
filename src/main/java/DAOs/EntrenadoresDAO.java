/*
 * EntrenadoresDAO.java
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
import java.util.ArrayList;
import java.util.List;

/**
 * Clase que implementa operaciones CRUD (Crear, Leer, Actualizar, Eliminar)
 * para la entidad Entrenador en la base de datos.
 *
 * @author Equipo #5 - Metodologías Ágiles de Desarrollo
 */
public class EntrenadoresDAO implements BaseDAO {

    private String persistenceUnit;

    /**
     * Constructor que recibe la unidad de persistencia.
     *
     * @param persistenceUnit La unidad de persistencia a utilizar.
     */
    public EntrenadoresDAO(String persistenceUnit) {
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
     * Registra un nuevo entrenador en la base de datos.
     *
     * @param entrenador El entrenador a registrar.
     * @return El entrenador registrado.
     */
    public Entrenador registrarEntrenador(Entrenador entrenador) {
        EntityManager entityManager = this.getEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(entrenador);
        entityManager.getTransaction().commit();
        entityManager.close();
        return entrenador;
    }

    // Método de eliminación
    /**
     * Elimina un entrenador de la base de datos por su ID.
     *
     * @param id El ID del entrenador a eliminar.
     * @throws EntityNotFoundException Si no se encuentra el entrenador con el
     * ID proporcionado.
     */
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

    // Métodos de edición
    /**
     * Edita un entrenador en la base de datos.
     *
     * @param entrenador El entrenador a editar.
     * @return El entrenador editado.
     */
    public Entrenador editarEntrenador(Entrenador entrenador) {
        EntityManager entityManager = this.getEntityManager();
        entityManager.getTransaction().begin();
        entityManager.merge(entrenador);
        entityManager.getTransaction().commit();
        entityManager.close();
        return entrenador;
    }

    // Método de consulta
    /**
     * Consulta un entrenador de la base de datos por su ID.
     *
     * @param id El ID del entrenador a consultar.
     * @return El entrenador consultado.
     * @throws EntityNotFoundException Si no se encuentra el entrenador con el
     * ID proporcionado.
     */
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

    // Métodos de verificación
    /**
     * Verifica la existencia de un entrenador por su ID.
     *
     * @param id El ID del entrenador a verificar.
     * @return True si el entrenador existe, False en caso contrario.
     */
    public Boolean verificarEntrenador(Long id) {
        EntityManager entityManager = this.getEntityManager();
        entityManager.getTransaction().begin();
        Entrenador entrenador = entityManager.find(Entrenador.class, id);
        entityManager.getTransaction().commit();
        entityManager.close();
        return entrenador != null;
    }

    // Métodos de inicio de sesión
    /**
     * Inicia sesión para un entrenador con el usuario y contraseña dados.
     *
     * @param usuario El nombre de usuario del entrenador.
     * @param contrasena La contraseña del entrenador.
     * @return El entrenador si la autenticación es exitosa, null en caso
     * contrario.
     * @throws Exception Si ocurre un error durante el proceso de inicio de
     * sesión.
     */
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

    /**
     * Verifica la existencia de un usuario entrenador por su nombre de usuario.
     *
     * @param usuario El nombre de usuario a verificar.
     * @return True si el usuario existe, False en caso contrario.
     * @throws Exception Si ocurre un error durante la verificación.
     */
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
        // Consulta el entrenador con el usuario dado de la base de datos
        Entrenador entrenador = this.consultarEntrenadoresUsuario(usuario);
        entityManager.getTransaction().commit();
        entityManager.close();
        return entrenador.getContrasena().equals(contrasena);
    }

    /**
     * Consulta de la base de datos un objeto de tipo Entrenador por su nombre
     * de usuario.
     *
     * @param usuario El nombre de usuario del entrenador a consultar.
     * @return El entrenador consultado.
     * @throws Exception Si ocurre un error durante la consulta.
     */
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

    /**
     * Consulta la base de datos para obtener una lista de todos los
     * entrenadores registrados.
     *
     * @return Lista de todos los entrenadores registrados.
     * @throws Exception Si ocurre un error durante la consulta.
     */
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
    
   

    /**
     * Consulta la base de datos para obtener una lista de nombres completos de
     * todos los entrenadores registrados.
     *
     * @return Lista de nombres completos de todos los entrenadores registrados.
     * @throws Exception Si ocurre un error durante la consulta.
     */
    public List<String[]> consultarNombresEntrenadores() throws Exception {
        EntityManager entityManager = this.getEntityManager();
        entityManager.getTransaction().begin();
        TypedQuery<Object[]> query;
        // Modificar la JPQL para seleccionar solo los campos necesarios
        String jpql = "SELECT e.nombre, e.apellidoPaterno, e.apellidoMaterno FROM Entrenador e";
        query = entityManager.createQuery(jpql, Object[].class);
        List<Object[]> resultados = query.getResultList();
        entityManager.getTransaction().commit();
        entityManager.close();
        // Convertir los resultados en lista de String[]
        List<String[]> nombresCompletos = new ArrayList<>();
        for (Object[] resultado : resultados) {
            String nombre = (String) resultado[0];
            String apellidoPaterno = (String) resultado[1];
            String apellidoMaterno = (String) resultado[2];

            // Concatenar los campos en un solo String y agregar a la lista
            String nombreCompleto = nombre + " " + apellidoPaterno + " " + apellidoMaterno;
            nombresCompletos.add(new String[]{nombreCompleto});
        }
        return nombresCompletos;
    }
}
