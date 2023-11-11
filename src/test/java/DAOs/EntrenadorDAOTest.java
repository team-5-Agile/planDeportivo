/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package DAOs;

import Dominio.Entrenador;
import jakarta.persistence.EntityManager;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author el_fr
 */
public class EntrenadorDAOTest {

    private static EntrenadorDAO instance;

    public EntrenadorDAOTest() {
    }

    @BeforeAll
    public static void setUpClass() {
        instance = new EntrenadorDAO("AppPlanUTest");
         EntityManager em= instance.getEntityManager();
         em.getTransaction().begin();
         em.createNativeQuery("SET foreign_key_checks = 0").executeUpdate();
         em.createNativeQuery("truncate  table entrenadores")
                 .executeUpdate();
         em.createNativeQuery("SET foreign_key_checks = 1").executeUpdate();
          em.getTransaction().commit();
         em.close();
    }

    @AfterAll
    public static void tearDownClass() {
         EntityManager em= instance.getEntityManager();
         em.getTransaction().begin();
         em.createNativeQuery("SET foreign_key_checks = 0").executeUpdate();
         em.createNativeQuery("truncate  table entrenadores")
                 .executeUpdate();
         em.createNativeQuery("SET foreign_key_checks = 1").executeUpdate();
          em.getTransaction().commit();
         em.close();
         
    }

    @BeforeEach
    public void setUp() {
    }

    @AfterEach
    public void tearDown() {
    }

    /**
     * Test of registrarEntrenador method, of class EntrenadorDAO.
     */
    @Test
    public void testRegistrarEntrenador() {
        try{
            
        System.out.println("registrarEntrenador");
        Entrenador entrenador = new Entrenador();
        entrenador.setUsuario("test");
        entrenador.setContrasena("contrasena");
        Entrenador result = instance.registrarEntrenador(entrenador);
        Entrenador a =new Entrenador();
        a.setId(1L);
        assertEquals(a.getId(),result.getId());
        }catch(Exception e){
            fail("falló test registrarEntrenador(args)");
        }
        
    }
    
     @Test
    public void testConsultarEntrenador() {
        try {
            System.out.println("ConsultarEntrenador");
            
            Entrenador result = instance.consultarEntrenadoresUsuario("test");
            assertEquals("test",result.getUsuario());
        } catch (Exception ex) {
            fail("falló test -> consultarEntrenadoresUsuario(args)");
        }

    }
    
      @Test
    public void testIniciarSesionEntrenador() {
        try {
            System.out.println("IniciarSesionEntrenador");
            
            Entrenador result = instance.iniciarSesionEntrenador("test","contrasena");
            assertEquals("test",result.getUsuario());
        } catch (Exception ex) {
             fail("falló test -> iniciarSesionEntrenador(args,args)");
        }

    }

}
