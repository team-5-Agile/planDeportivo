/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAOs;

import Dominio.Administrador;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityNotFoundException;
import jakarta.persistence.Persistence;

/**
 *
 * @author brawun
 */
public class AdministradorDAO implements BaseDAO {

    private String persitenceUnit;

    public AdministradorDAO(String persitenceUnit) {
        this.persitenceUnit = persitenceUnit;
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

    @Override
    public EntityManager getEntityManager() {
        EntityManagerFactory managerFactory = Persistence.createEntityManagerFactory(this.persitenceUnit);
        EntityManager entityManager = managerFactory.createEntityManager();
        return entityManager;
    }

    public String getPersitenceUnit() {
        return persitenceUnit;
    }

    public void setPersitenceUnit(String persitenceUnit) {
        this.persitenceUnit = persitenceUnit;
    }

}
