/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package DAOs;

import Dominio.Etapa;
import Enumeradores.TipoEtapa;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author el_fr
 */
public class EtapasDAOTest {
    public static final EtapasDAO etapasDAO=new EtapasDAO("AppPlanUTest");
    public EtapasDAOTest() {
    }
    
    @BeforeAll
    public static void setUpClass() {
        Etapa etapa = new Etapa(TipoEtapa.GENERAL, 24, 20.0);
        etapasDAO.registrarEtapa(etapa);
    }
    
    
    /**
     * Test of registrarEtapa method, of class EtapasDAO.
     */
    @Test
    public void testRegistrarEtapa() {
        System.out.println("registrarEtapa");
        Etapa etapa = null;
        etapa =etapasDAO.consultarEtapa(1L);
        assertNotNull(etapa);
    }

  
    
}
