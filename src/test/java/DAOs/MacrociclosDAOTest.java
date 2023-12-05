/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package DAOs;

import Dominio.Macrociclo;
import Enumeradores.Ramas;
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
