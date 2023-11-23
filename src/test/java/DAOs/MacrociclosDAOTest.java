/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package DAOs;

import Dominio.Entrenador;
import Dominio.Macrociclo;
import Enumeradores.Ramas;
import jakarta.persistence.EntityManager;
import java.util.Calendar;
import java.util.List;
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
public class MacrociclosDAOTest {
    
    public static MacrociclosDAO instance = new MacrociclosDAO("AppPlanUTest");
    public MacrociclosDAOTest() {
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
    public void testRegistrarMacrociclo() {
        System.out.println("registrarMacrociclo");
        Macrociclo macrociclo = new Macrociclo();
                macrociclo.setDeporte("Futbol");
                macrociclo.setJefeRama("Jefe de Rama");
                macrociclo.setRama(Ramas.MIXTO);
                macrociclo.setMetodologo("Random");
                macrociclo.setPreparadorFisico("Random");
        Macrociclo result = instance.registrarMacrociclo(macrociclo);
        assertNotNull(result);
       
    }
    
}
