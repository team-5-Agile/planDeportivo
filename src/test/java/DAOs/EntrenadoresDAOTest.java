/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package DAOs;

import Dominio.Entrenador;
import jakarta.persistence.EntityManager;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
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
public class EntrenadoresDAOTest {

    public static final EntrenadoresDAO entrenadorDao=new EntrenadoresDAO("AppPlanUTest");

    public EntrenadoresDAOTest() {
    }

    @BeforeAll
    public static void setUpClass() {
    }

    /**
     * Test para metodo registrarEntrenador method
     */
    @Test
    @Order(1)
    public void testRegistrarEntrenador() {
        System.out.println("registrarEntrenador");
        Entrenador entrenador = new Entrenador("Random",
                "Real",
                "Ficticio",
                "random",
                "randomizer");
        Entrenador result = entrenadorDao.registrarEntrenador(entrenador);
        assertNotNull(result);

    }

    @Test
    public void testRegistrarEntrenadorFail() {
        System.out.println("registrarEntrenadorFail");
        Entrenador entrenador = new Entrenador("Random",
                "Real",
                "Ficticio",
                "random2",
                "randomizer3");
        Entrenador expResult = new Entrenador("Random",
                "Real",
                "Ficticio",
                "random2",
                "randomizer3");
        expResult.setId(4L);
        Entrenador result = entrenadorDao.registrarEntrenador(entrenador);
        assertNotEquals(expResult.getId(), result.getId());

    }

   
    @Test
    public void testConsultarEntrenador() {
        System.out.println("consultarEntrenador");
        Long id = 1L;
        Entrenador expResult = new Entrenador("Random",
                "Real",
                "Ficticio",
                "random",
                "randomizer");
        expResult.setId(id);
        Entrenador result = entrenadorDao.consultarEntrenador(id);
        assertEquals(expResult.getId(), result.getId());

    }

    static Stream<Entrenador> datosDb() {
        return Stream.<Entrenador>builder()
                .add(new Entrenador("Juan", "Gomez", "Perez",  "contrasena1","JuanGomez"))
                .add(new Entrenador("Maria", "Rodriguez", "Lopez",  "contrasena2","MariaRodriguez"))
                .add(new Entrenador("Carlos", "Martinez", "Fernandez",  "contrasena3","CarlosMartinez"))
                .add(new Entrenador("Laura", "Gonzalez", "Hernandez",  "contrasena4","LauraGonzalez"))
                .add(new Entrenador("Pedro", "Diaz", "Jimenez",  "contrasena5","PedroDiaz"))
                .add(new Entrenador("Ana", "Lopez", "Santos",  "contrasena6","AnaLopez"))
                .add(new Entrenador("Javier", "Sanchez", "Ortega",  "contrasena7","JavierSanchez"))
                .add(new Entrenador("Sara", "Perez", "Molina",  "contrasena8","SaraPerez"))
                .add(new Entrenador("Alejandro", "Fernandez", "Garcia",  "contrasena9","AlejandroFernandez"))
                .add(new Entrenador("Elena", "Jimenez", "Rios",  "contrasena10","ElenaJimenez"))
                .build();

    }

    @Test
    @Order(2)
    public void testRegistrarNEntrenadores() {
        System.out.println("Registrar Entrenadores");
        Stream<Entrenador> entrenadoresDb;
        Stream.Builder<Entrenador> builder = Stream.builder();
        // Convertir los Streams a List para la comparación
        List<Entrenador> listaDatosDb = datosDb().collect(Collectors.toList());
        listaDatosDb.forEach(entrenador -> {

            Entrenador entrenadorDb = entrenadorDao.registrarEntrenador(entrenador);
            builder.add(entrenadorDb);
            entrenador.setId(entrenadorDb.getId());
         

        });
        entrenadoresDb = builder.build();
        

        List<Entrenador> listaEntrenadoresDb = entrenadoresDb.collect(Collectors.toList());
        assertNotNull(listaEntrenadoresDb);
    }

   
    @Test
    public void testVerificarEntrenador() {
        System.out.println("verificarEntrenador");
        Long id = 2L;
        Boolean expResult = true;
        Boolean result = entrenadorDao.verificarEntrenador(id);
        assertEquals(expResult, result);

    }

    @Test
    public void testVerificarEntrenadorFail() {
        System.out.println("verificarEntrenador");
        Long id = 40L;
        Boolean expResult = false;
        Boolean result = entrenadorDao.verificarEntrenador(id);
        assertEquals(expResult, result);

    }

   
    @Test
    public void testVerificarUsuarioEntrenador() throws Exception {
        System.out.println("verificarUsuarioEntrenador");

        boolean expResult = true;
        boolean result = entrenadorDao.verificarUsuarioEntrenador("randomizer");
        assertEquals(expResult, result);

    }

   
    @Test
    public void testVerificarContrasenaUsuario() throws Exception {
        System.out.println("verificarContrasenaUsuario");

        boolean expResult = true;
        boolean result = entrenadorDao.verificarContrasenaUsuario( "ElenaJimenez","contrasena10");
        assertEquals(expResult, result);

    }
    
    @Test
    public void testVerificarContrasenaUsuarioFail() throws Exception {
        System.out.println("verificarContrasenaUsuario");

        boolean expResult = false;
        boolean result = entrenadorDao.verificarContrasenaUsuario("ElenaJimenez", "aaaaa");
        assertEquals(expResult, result);

    }
    @Test
    public void testConsultarTodosEntrenadores() throws Exception {
        System.out.println("consultarTodosEntrenadores");

        List<Entrenador> result = entrenadorDao.consultarTodosEntrenadores();
        assertNotSame(datosDb().count(), result.size());

    }

}
