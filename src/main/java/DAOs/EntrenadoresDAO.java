/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAOs;

import Dominio.Entrenadores;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityNotFoundException;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

/**
 *
 * @author brawun
 */
public class EntrenadoresDAO {

    // Métodos de acceso
    public Entrenadores registrarEntrenador(Entrenadores entrenador) {
        EntityManagerFactory managerFactory = Persistence.createEntityManagerFactory("AppPlanU");
        EntityManager entityManager = managerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(entrenador);
        entityManager.getTransaction().commit();
        entityManager.close();
        return entrenador;
    }
    
    // Metodo de eliminacion
    public void eliminarEntrenador(Long id) {
        if (verificarEntrenador(id)) {
            EntityManagerFactory managerFactory = Persistence.createEntityManagerFactory("AppPlanU");
            EntityManager entityManager = managerFactory.createEntityManager();
            entityManager.getTransaction().begin();
            Entrenadores entrenador = consultarEntrenador(id);
            entityManager.remove(entrenador);
            entityManager.getTransaction().commit();
            entityManager.close();
        } else {
            throw new EntityNotFoundException("No se puede encontrar el entrenador con ID: " + id);
        }
    }

    // Metodo de consultac
    public Entrenadores consultarEntrenador(Long id) {
        if (verificarEntrenador(id)) {
            EntityManagerFactory managerFactory = Persistence.createEntityManagerFactory("AppPlanU");
            EntityManager entityManager = managerFactory.createEntityManager();
            entityManager.getTransaction().begin();
            Entrenadores entrenador = entityManager.find(Entrenadores.class, id);
            entityManager.getTransaction().commit();
            entityManager.close();
            return entrenador;
        } else {
            throw new EntityNotFoundException("No se puede encontrar el entrenador con ID: " + id);
        }
    }
    
    // Métodos de verificacion 
    public Boolean verificarEntrenador(Long id) {
        EntityManagerFactory managerFactory = Persistence.createEntityManagerFactory("AppPlanU");
        EntityManager entityManager = managerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        Entrenadores entrenador = entityManager.find(Entrenadores.class, id);
        entityManager.getTransaction().commit();
        entityManager.close();
        return entrenador != null;
    }

    // Métodos de inicio de sesión
    public Entrenadores iniciarSesionEntrenador(String usuario, String contrasena) throws Exception {
        if (verificarUsuarioEntrenador(usuario)) {
            EntityManagerFactory managerFactory = Persistence.createEntityManagerFactory("AppPlanU");
            EntityManager entityManager = managerFactory.createEntityManager();
            entityManager.getTransaction().begin();
            // Entrenador a regresar inicializado
            Entrenadores entrenador = null;
            if (this.verificarContrasenaUsuario(usuario, contrasena)) {
                // Se busca entrenador a regresar
                entrenador = this.consultarEntrenadoresUsuario(usuario);
            }
            entityManager.getTransaction().commit();
            entityManager.close();
            return entrenador;
        } else {
            // El usuario NO se encontro en la base de datos
            throw new EntityNotFoundException("No se puede encontrar el entrenador con usuario: " + usuario);
        }
    }

    // Verificar que exista en la base de datos, regresa verdadero si el usuario ha sido encontrado en la base de datos
    public boolean verificarUsuarioEntrenador(String usuario) throws Exception {
        EntityManagerFactory managerFactory = Persistence.createEntityManagerFactory("AppPlanU");
        EntityManager entityManager = managerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        TypedQuery<Entrenadores> query;
        String jpql = "SELECT o FROM Entrenadores o WHERE o.usuario = :usuario";
        query = entityManager.createQuery(jpql, Entrenadores.class);
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
        EntityManagerFactory managerFactory = Persistence.createEntityManagerFactory("AppPlanU");
        EntityManager entityManager = managerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        // Consulta el entrenador con el usuario dado de la base de datos
        Entrenadores entrenador = this.consultarEntrenadoresUsuario(usuario);
        entityManager.getTransaction().commit();
        entityManager.close();
        return entrenador.getContrasena().equals(contrasena);
    }

    // Consulta de la base de datos un objeto de tipo Entrenadores, solamente solicitando el usuario, regresa un objeto si se halla un entrenador en la base de datos con el usuario dado
    public Entrenadores consultarEntrenadoresUsuario(String usuario) throws Exception {
        EntityManagerFactory managerFactory = Persistence.createEntityManagerFactory("AppPlanU");
        EntityManager entityManager = managerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        TypedQuery<Entrenadores> query;
        String jpql = "SELECT o FROM Entrenadores o WHERE o.usuario = :usuario";
        query = entityManager.createQuery(jpql, Entrenadores.class);
        query.setParameter("usuario", usuario);
        Entrenadores entrenador = query.getSingleResult();
        entityManager.getTransaction().commit();
        entityManager.close();
        return entrenador;
    }
}
