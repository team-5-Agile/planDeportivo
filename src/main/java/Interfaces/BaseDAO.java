/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Interfaces;

import jakarta.persistence.Entity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

/**
 * Interface base para clases concretas de acceso a datos
 * @author el_fr
 */
public interface BaseDAO {
    /**
     * Este método se utiliza para obtener una instancia de entity manager de
     * acuerdo al Persistence Unit Name configurado en el archivo persistence.xml <br>
     * <b>persistenceUnit</b> es un atributo qué es especificado en el constructor
     * de las clases que concretas que implementan esta interfaz.
     *
     * @return devuelve una instancia de EntityManager
     */
     EntityManager getEntityManager();
      

    /// Agregar métodos que pueden ser reutilizados.
}