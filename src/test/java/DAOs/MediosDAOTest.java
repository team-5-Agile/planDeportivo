/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package DAOs;

import Dominio.Medio;
import Enumeradores.TipoMedio;
import Enumeradores.Unidades;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author el_fr
 */
public class MediosDAOTest {
    public static final MediosDAO mediosDAO=new MediosDAO("AppPlanUTest");

    public MediosDAOTest() {
    }
    
    @BeforeAll
    public static void setUpClass() {
        System.out.println("Setup Test Medios");
        Medio medio = new Medio(TipoMedio.FLEXIBILIDAD, Unidades.KM, 10, 10, 5);
        mediosDAO.registrarMedio(medio);
        Medio medio2 = new Medio(TipoMedio.COORD_TECN, Unidades.REP, 10, 10, 5);
        mediosDAO.registrarMedio(medio2);
    }
    
    @Test
    public void testEditarMedio() {
        System.out.println("editarMedio");
       
        Medio medio= mediosDAO.consultarMedio(1L);
        medio.setTipo(Unidades.MTROS);
        Medio result = mediosDAO.editarMedio(medio);
        assertEquals(Unidades.MTROS, result.getTipo());
        
    }
   
}
