/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package DAOs;

import Dominio.Administrador;
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
public class AdministradorDAOTest {
    public static final AdministradorDAO adminDao= new AdministradorDAO("AppPlanUTest");
    public AdministradorDAOTest() {
    }
    
    @BeforeAll
    public static void setUpClass() {
        System.out.println("Setup Test administrador");
       adminDao.registrarAdministrador(new Administrador(
                 "root", 
                "root"
        ));
          
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
    public void TestConsultarAdministrador(){
        System.out.println("Consultar Administrador");
       
        Administrador admin =adminDao.consultarAdministrador(1L);
        assertEquals("root", admin.getUsuario());
    }
    
    
    @Test 
    public void TestAgregarAdministrador(){
        System.out.println("Agregar Administrador");
        
        Administrador admin = new Administrador("root2","");
        Administrador result = adminDao.registrarAdministrador(admin);
        assertNotNull(result);
        
    }

}
