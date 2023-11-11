/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAOs;

import Dominio.Administrador;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityNotFoundException;
import javax.persistence.Persistence;

/**
 *
 * @author brawun
 */
public class AdministradorDAO {
    
    // Métodos de acceso
    public Administrador registrarAdministrador(Administrador administrador) {
        EntityManagerFactory managerFactory = Persistence.createEntityManagerFactory("AppPlanU");
        EntityManager entityManager = managerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(administrador);
        entityManager.getTransaction().commit();
        entityManager.close();
        return administrador;
    }
    
    // Metodo de eliminacion
    public void eliminarAdministrador(Long id) {
        if (verificarAdministrador(id)) {
            EntityManagerFactory managerFactory = Persistence.createEntityManagerFactory("AppPlanU");
            EntityManager entityManager = managerFactory.createEntityManager();
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
            EntityManagerFactory managerFactory = Persistence.createEntityManagerFactory("AppPlanU");
            EntityManager entityManager = managerFactory.createEntityManager();
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
        EntityManagerFactory managerFactory = Persistence.createEntityManagerFactory("AppPlanU");
        EntityManager entityManager = managerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        Administrador administrador = entityManager.find(Administrador.class, id);
        entityManager.getTransaction().commit();
        entityManager.close();
        return administrador != null;
    }
}
