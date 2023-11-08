/**
 * ComboBoxUtils.java
 */
package Herramientas;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JComboBox;

public class ComboBoxUtils {

    /**
     * Llena una JComboBox con los elementos de un arreglo de tipo String.
     *
     * @param comboBox JComboBox que se va a llenar
     * @param datos Arreglo de datos de tipo String que se utilizarán para
     * llenar la JComboBox
     */
    public static void llenarComboBox(JComboBox comboBox, String[] datos) {
        comboBox.removeAllItems(); // Elimina los elementos existentes en la JComboBox
        for (String dato : datos) {
            comboBox.addItem(dato); // Agrega cada elemento del arreglo a la JComboBox
        }
    }

    public static String[] arregloJefes() {
        List<String> listaDePalabras = new ArrayList<>(); // Crea una lista de palabras
        listaDePalabras.add("");
        // ... Puedes agregar más palabras aquí

        String[] arreglo = listaDePalabras.toArray(new String[0]); // Convierte la lista en un arreglo de strings

        return arreglo; // Devuelve el arreglo de palabras recién creado
    }

    public static String[] arregloDeportes() {
        List<String> listaDePalabras = new ArrayList<>(); // Crea una lista de palabras
        listaDePalabras.add("Beisbol");
        listaDePalabras.add("Softbol");
        listaDePalabras.add("Tenis");
        listaDePalabras.add("Tenis de Mesa");
        listaDePalabras.add("Voleibol Playa");
        listaDePalabras.add("Ajedrez");
        listaDePalabras.add("Atletismo Lanzamiento");
        listaDePalabras.add("Atletismo Pista");
        listaDePalabras.add("Atletismo Saltos");
        listaDePalabras.add("Baloncesto");
        listaDePalabras.add("Balonmano");
        listaDePalabras.add("Boxeo Universitario");
        listaDePalabras.add("Escalada Deportiva");
        listaDePalabras.add("Esgrima");
        listaDePalabras.add("Natación");
        listaDePalabras.add("Gimnasia aerobica");
        listaDePalabras.add("Halterofilia");
        listaDePalabras.add("Judo");
        listaDePalabras.add("Karate do");
        listaDePalabras.add("Lucha Universitaria");
        listaDePalabras.add("Rugby Seven");
        listaDePalabras.add("Futbol Americano");
        listaDePalabras.add("Tae Kwon Do");
        listaDePalabras.add("Futbol Bardas");
        listaDePalabras.add("Tochito");
        listaDePalabras.add("Triatlon");
        listaDePalabras.add("Voleibol Sala");
        listaDePalabras.add("Futbol Soccer");

        String[] arreglo = listaDePalabras.toArray(new String[0]); // Convierte la lista en un arreglo de strings

        return arreglo; // Devuelve el arreglo de palabras recién creado
    }

    public static String[] arregloRamas() {
        List<String> listaDePalabras = new ArrayList<>(); // Crea una lista de palabras
        listaDePalabras.add("Varonil");
        listaDePalabras.add("Femenil");
        listaDePalabras.add("Mixto");

        String[] arreglo = listaDePalabras.toArray(new String[0]); // Convierte la lista en un arreglo de strings

        return arreglo; // Devuelve el arreglo de palabras recién creado
    }

    public static String[] arregloPreparadores() {
        List<String> listaDePalabras = new ArrayList<>(); // Crea una lista de palabras
        listaDePalabras.add("Aaron Leal");
        listaDePalabras.add("Abraham Torres");
        listaDePalabras.add("Adrian Romero");
        listaDePalabras.add("Alfredo Osuna");
        listaDePalabras.add("Alfredo Sillas");
        listaDePalabras.add("Ana Nayeli Leon");
        listaDePalabras.add("Benjamin Murrieta");
        listaDePalabras.add("Carlos Lara");
        listaDePalabras.add("Carlos Lugo");
        listaDePalabras.add("Cristian Arreola");
        listaDePalabras.add("Cristian Garcia");
        listaDePalabras.add("Francisco Amavizca");
        listaDePalabras.add("Francisco Solis");
        listaDePalabras.add("Hugo Avendaño");
        listaDePalabras.add("Ivan Bracamontes");
        listaDePalabras.add("Jesús Borquez");
        listaDePalabras.add("Jorge Aguilar");
        listaDePalabras.add("Juan Cardenas");
        listaDePalabras.add("Luis Andres Cuadras Alaniz");
        listaDePalabras.add("Luis Lopez");
        listaDePalabras.add("Mario Cardona");
        listaDePalabras.add("Miguel Ayon");
        listaDePalabras.add("Moises Soto");
        listaDePalabras.add("Oscar Marquina");
        listaDePalabras.add("Rafael Felix");
        listaDePalabras.add("Ramon Andres Romero");
        listaDePalabras.add("Raul Hernandez");
        listaDePalabras.add("Raul Velazquez");
        listaDePalabras.add("Rene Molina");
        listaDePalabras.add("Ricardo Saavedra");
        listaDePalabras.add("Luis Gerardo Miranda");
        listaDePalabras.add("Rosa Guzman");
        listaDePalabras.add("Sergio Alejandro Castro Félix");
        listaDePalabras.add("Victor Ortiz");
        listaDePalabras.add("Wendy Guizar");

        String[] arreglo = listaDePalabras.toArray(new String[0]); // Convierte la lista en un arreglo de strings

        return arreglo; // Devuelve el arreglo de palabras recién creado
    }

    public static String[] arregloMetodologos() {
        List<String> listaDePalabras = new ArrayList<>(); // Crea una lista de palabras
        listaDePalabras.add("Benjamin Murrieta");
        listaDePalabras.add("Jesus Borquez");

        String[] arreglo = listaDePalabras.toArray(new String[0]); // Convierte la lista en un arreglo de strings

        return arreglo; // Devuelve el arreglo de palabras recién creado
    }
}
