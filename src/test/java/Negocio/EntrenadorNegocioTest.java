/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package Negocio;

import DAOs.EntrenadoresDAO;
import Dominio.Entrenador;
import Enumeradores.Scope;
import jakarta.persistence.EntityManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.TestMethodOrder;

/**
 *
 * @author el_fr
 */
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class EntrenadorNegocioTest {
    
    public static EntrenadoresDAO entrenadorDao;
    
    public EntrenadorNegocioTest() {
        entrenadorDao = new EntrenadoresDAO("AppPlanUTest");
    }
    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    @BeforeEach
    public void setUp() {
    }
    
    @AfterEach
    public void tearDown() {
    }
     @Test
     @Order(1)
    public void testResgistrar() {
                System.out.println("TestRegistrar");

        Entrenador entrenador = new Entrenador();
        entrenador.setNombre("Test Nombre");
        entrenador.setApellidoPaterno("Test ApellidoP");
        entrenador.setApellidoMaterno("Test ApellidoM");
        entrenador.setUsuario("Test Usuario");
        entrenador.setContrasena("TestContrasena");
        
        Entrenador reg = entrenadorDao.registrarEntrenador(entrenador);
        entrenador.setId(1L);
        assertEquals(entrenador, reg);
    }

    /**
     * Test of iniciarSesion method, of class EntrenadorNegocio.
     */
    @Test
    @Order(2)
    public void testIniciarSesion() throws Exception {
        System.out.println("iniciarSesion");
        String usuario = "Test Usuario";
        String contrasena = "TestContrasena";
        EntrenadorNegocio instance = new EntrenadorNegocio(Scope.TEST);
        Entrenador expResult = new Entrenador();
        expResult.setUsuario(usuario);
        expResult.setContrasena(contrasena);
        expResult.setId(1L);
        Entrenador result = instance.iniciarSesion(usuario, contrasena);
        assertEquals(expResult, result);
        
    }
    
   
    
}
