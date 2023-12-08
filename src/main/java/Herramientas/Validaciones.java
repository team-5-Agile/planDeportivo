/*
 * Validaciones.java
 */
package Herramientas;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Calendar;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

/**
 * Validaciones Clase que contiene métodos para realizar validaciones necesarias
 * en el paquete negocio.
 *
 * @author Equipo #5 - Metodologías Ágiles de Desarrollo
 */
public class Validaciones {

    private static final String FORMATO_FECHA = "^([0-9]{2})/([0-9]{2})/([0-9]{4})$";
    private static final String FORMATO_NUMSEMANAS = "^([0-9]{2})$";

    /**
     * isFechaValida Método que valida que la fecha sea en formato
     * dd/mm/yyyy.<br>
     *
     * @param strFecha Representa una fecha en formato String.
     * @return devuelve verdadero si strFecha cumple con la validación.
     * @throws java.lang.Exception
     */
    public boolean isFechaValida(String strFecha) throws Exception {
        Pattern pattern = Pattern.compile(FORMATO_FECHA, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(strFecha);
        if (!matcher.matches()) {
            throw new Exception("Error, La Fecha debe ser en formato dd/mm/yyyy");
        }

        convertirFecha(strFecha);
        return true;

    }

    /**
     * Valida si el porcentaje dado no es mayor que 100.
     *
     * @param porcentaje El porcentaje a validar.
     * @return Verdadero si el porcentaje es válido, de lo contrario, se lanza
     * una excepción.
     * @throws Exception Si el porcentaje es mayor que 100.
     */
    public boolean isPorcentajeValido(double porcentaje) throws Exception {
        if (porcentaje > 100) {
            throw new Exception("Error, El número no debe superar el 100%");
        }
        return true;
    }

    /**
     * Valida si el número dado no es negativo.
     *
     * @param n El número a validar.
     * @return Verdadero si el número no es negativo, de lo contrario, se lanza
     * una excepción.
     * @throws Exception Si el número es negativo.
     */
    public boolean isNegativo(double n) throws Exception {
        if (0 > n) {
            throw new Exception("Error, El número no debe ser menor a 0%");
        }
        return true;
    }

    /**
     * Valida si el segundo parámetro no es mayor que el primer parámetro.
     *
     * @param semanas El primer parámetro.
     * @param n El segundo parámetro.
     * @return Verdadero si el segundo parámetro no es mayor que el primero, de
     * lo contrario, se lanza una excepción.
     * @throws Exception Si el segundo parámetro es mayor que el primero.
     */
    public boolean isMenor(int semanas, int n) throws Exception {
        if (n > semanas) {
            throw new Exception("Error, El número no debe ser menor a las semanas");
        }
        return true;
    }

    /**
     * isNumSemanaValido Método que valida el formato de la cadena str y el
     * número de semanas.
     *
     * @param strSemanas Representa el valor de número de semanas.
     * @param min Representa el valor mínimo aceptado.
     * @param max Representa el valor máximo aceptado.
     * @return devuelve verdadero si el valor pasa por todas las valifaciones y
     * falso en caso contrario.
     * @throws java.lang.Exception
     */
    public boolean isNumSemanaValido(String strSemanas, Integer min, Integer max) throws Exception {
        Pattern pattern = Pattern.compile(FORMATO_NUMSEMANAS, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(strSemanas);

        if (!matcher.matches()) {
            throw new Exception("Error, El formato para número de semanas debe ser de 2 digitos: 00");
        }
        if (Integer.valueOf(strSemanas) < min || Integer.valueOf(strSemanas) > max) {
            throw new Exception("Error, El número de semanas no puede ser menor a " + min + " ni mayor a " + max);
        }

        return true;

    }

    public static boolean esNumero(String str) {
        // Utiliza una expresión regular para verificar si la cadena contiene solo dígitos
        return str.matches("\\d+");
    }

    public static boolean validarMedio(int valor) throws Exception {
        if (esNumero(valor + "")) {
            if ((valor > 0 && valor < 999)) {
                return true;
            }
            throw new Exception("Error, Debe tener datos validos");
        }
        throw new Exception("Error, Debe tener datos validos");
    }

    /**
     * Elimina las filas vacías de una tabla.
     *
     * @param tabla La tabla (JTable) de la cual se eliminarán las filas vacías.
     */
    public void eliminarFilasVacias(JTable tabla) {
        DefaultTableModel modelo = (DefaultTableModel) tabla.getModel();

        int rowCount = modelo.getRowCount();

        // Iterar desde el final hacia el inicio para evitar problemas al eliminar filas
        for (int i = rowCount - 1; i >= 0; i--) {
            boolean filaVacia = true;

            // Verificar si todas las celdas de la fila están vacías
            for (int j = 0; j < modelo.getColumnCount(); j++) {
                if (modelo.getValueAt(i, j) != null && !modelo.getValueAt(i, j).toString().isEmpty()) {
                    filaVacia = false;
                    break;
                }
            }

            // Si la fila está vacía, eliminarla
            if (filaVacia) {
                modelo.removeRow(i);
            }
        }
    }

    /**
     * Método qué válida si la fecha ingresada es anterior a la fecha actual
     *
     * @param strFecha Representa la fecha como cadena en formato dd/MM/yyyy
     * @return devuelve verdadero si la fecha es anterior y falso en caso
     * contrario
     * @throws java.lang.Exception
     */
    public boolean isFechaAnterior(String strFecha) throws Exception {

        try {
            LocalDate hoy = LocalDate.now();
            LocalDate fecha = convertirFecha(strFecha);
            return hoy.isBefore(fecha);
        } catch (Exception e) {
            throw new Exception("La fecha no puede ser anterior al día de hoy");
        }
    }

    /**
     * Método qué válida si la fecha Inicio es anterior a la fecha Fin
     *
     * @param strFechaInicio Representa la fecha inicial en una cadena en
     * formato dd/MM/yyyy
     * @param strFechaFin Representa la fecha Fin en una cadena en formato
     * dd/MM/yyyy
     * @return devuelve verdadero si la fecha Inicio es anterior a Fin y dalso
     * en caso contrario
     * @throws java.lang.Exception
     */
    public boolean isFechaAnterior(String strFechaInicio, String strFechaFin) throws Exception {

        try {
            LocalDate fechaInicio = convertirFecha(strFechaInicio);
            LocalDate fechaFin = convertirFecha(strFechaFin);
            return fechaInicio.isBefore(fechaFin);
        } catch (Exception e) {
            throw new Exception("La fecha fin: " + strFechaFin + " no puede ser anterior a" + strFechaInicio);
        }
    }

    //TODO: Mover a otra clase
    /**
     * Método qué convierte una fecha ingresada en un cadena con formato
     * dd/MM/yyyy
     *
     * @param strFecha Representa la fecha inicial en una cadena en formato
     * dd/MM/yyyy
     * @return devuelve la fecha convertida a un objeto LocalDate
     * @throws Exception si la cadena no cuenta con un formato valido lanza una
     * excepción
     */
    public LocalDate convertirFecha(String strFecha) throws Exception {
        try {
            LocalDate fecha = LocalDate.parse(strFecha, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
            return fecha;
        } catch (DateTimeParseException e) {
            // Lanzar la excepción personalizada
            throw new Exception("Fecha inválida: " + strFecha);
        }
    }

    /**
     * Método qué convierte una fecha de tpo LocalDate a dd/MM/yyyy
     *
     * @param fecha Representa la fecha inicial cómo objeto LocalDate
     * @return devuelve la fecha convertida en String dd/MM/yyyy
     * @throws Exception si la cadena no cuenta con un formato valido lanza una
     * excepción
     */
    public String convertirFecha(LocalDate fecha) throws Exception {
        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            String fechaFormateada = fecha.format(formatter);
            return fechaFormateada;
        } catch (DateTimeParseException e) {
            // Lanzar la excepción personalizada
            throw new Exception("Fecha inválida: " + fecha);
        }

    }

    /**
     * Método que calcula el número de semanas de un periodo entre una fecha de
     * inicio y una fecha fin.
     *
     * @param strFechaInicio Representa la fecha inicial
     * @param strFechaFin Representa la fecha fin
     * @return devuelve el número de semanas en el periodo ingresado
     * @throws java.lang.Exception
     */
    public Long calcPeriodo(String strFechaInicio, String strFechaFin) throws Exception {
        LocalDate fechaInicio = convertirFecha(strFechaInicio);
        LocalDate fechaFin = convertirFecha(strFechaFin);

        if (!fechaInicio.getDayOfWeek().equals(DayOfWeek.MONDAY)) {
            throw new Exception("La fecha inicial debe ser Lunes");
        }
        if (!fechaFin.getDayOfWeek().equals(DayOfWeek.FRIDAY)) {
            throw new Exception("La fecha final debe ser viernes");
        }
        // se obtienen todas las fechas entre la fecha inicio y fin
        return fechaInicio.datesUntil(fechaFin)
                // se filtran los lunes
                .filter(e -> e.getDayOfWeek() == DayOfWeek.MONDAY)
                // se cuentan los inicio de semanas para obtener el total 
                // semanas
                .count();

    }

    /**
     * Método que calcula Fecha Fin de un periodo entre una fecha de inicio y un
     * número de semanas
     *
     * @param strFechaInicio Representa la fecha inicial del periodo
     * @param numSemanas Representa el número de semanas en el periodo
     * @return devuelve la fecha fin del periodo
     * @throws java.lang.Exception
     */
    public LocalDate calcPeriodo(String strFechaInicio, Integer numSemanas) throws Exception {

        LocalDate fechaInicio = convertirFecha(strFechaInicio);
        LocalDate fechaFin = fechaInicio.plusWeeks(numSemanas)
                // se le quitan 3 días ala fecha final, es decir se vuelve
                // viernes.
                .minusDays(3);
        // se valida si la fecha inicial es lunes,
        if (!fechaInicio.getDayOfWeek().equals(DayOfWeek.MONDAY)) {
            throw new Exception("La fecha inicial debe ser Lunes");
        }
        if (fechaFin == null) {
            throw new Exception("Ocurrio un error al calcular la fecha fin");
        }
        if (!fechaFin.getDayOfWeek().equals(DayOfWeek.FRIDAY)) {
            throw new Exception("La fecha final debe ser viernes");
        }

        return fechaFin;
    }

    /**
     * Método para validar que un teléfono cumpla con el formato de: (111)
     * 111-1111
     *
     * @param telefono Teléfono a validar
     * @return Verdadero si el teléfono tiene el formato correcto, falso en caso
     * contrario
     */
    public boolean validarTelefono(String telefono) {
        // Se remueven espacios en blanco
        CharSequence cadena = telefono.trim();
        // Expresión regular
        String patron = "^\\(?(\\d{3})\\)?[- ]?(\\d{3})[- ]?(\\d{4})$";
        // Se crea un objeto de tipo pattern para verificar patrones
        Pattern p = Pattern.compile(patron);
        // Objeto de verificación
        Matcher matcher = p.matcher(cadena);
        // Devuelve verdadero si la cadena coincide con el patrón
        return matcher.matches();
    }

    /**
     * Método para validar nombres y apellidos, verifica si una cadena contiene
     * solamente letras mayúsculas y minúsculas.
     *
     * @param nombre Nombre a validar.
     * @return Verdadero si el nombre tiene el formato correcto, falso en caso
     * contrario
     */
    public boolean validarNombre(String nombre) {
        // Se remueven espacios en blanco
        CharSequence cadena = nombre.trim();
        // Expresión regular
        String patron = "^[a-zA-Z]+$";
        // Se crea un objeto de tipo pattern para verificar patrones
        Pattern p = Pattern.compile(patron);
        // Objeto de verificación
        Matcher matcher = p.matcher(cadena);
        // Devuelve verdadero si la cadena coincide con el patrón
        return matcher.matches();
    }

    /**
     * Método para validar folios, se verifica que sean cadenas compuestas de
     * solamente números de una longuitud constante de 6 dígitos.
     *
     * @param folio Folio a validar.
     * @return Verdadero si el folio tiene el formato correcto, falso en caso
     * contrario
     */
    public boolean validarFolio(String folio) {
        // Se remueven espacios en blanco
        CharSequence cadena = folio.trim();
        // Expresión regular
        String patron = "^\\d{1,6}$";
        // Se crea un objeto de tipo pattern para verificar patrones
        Pattern p = Pattern.compile(patron);
        // Objeto de verificación
        Matcher matcher = p.matcher(cadena);
        // Devuelve verdadero si la cadena coincide con el patrón
        return matcher.matches();
    }

    /**
     * Método para validar flotantes, se verifica que sea un número de longuitud
     * indeterminada con un punto decimal, se utiliza para verificar montos,
     * salarios, costos, inversiones, etc. No se aceptan número negativos.
     *
     * @param flotante Flotante a validar.
     * @return Verdadero si el flotante tiene el formato correcto, falso en caso
     * contrario
     */
    public boolean validarFlotante(String flotante) {
        // Se remueven espacios en blanco
        CharSequence cadena = flotante.trim();
        // Expresión regular
        String patron = "^[0-9]*\\.[0-9]+([eE][-+]?[0-9]+)?$";
        // Se crea un objeto de tipo pattern para verificar patrones
        Pattern p = Pattern.compile(patron);
        // Objeto de verificación
        Matcher matcher = p.matcher(cadena);
        // Devuelve verdadero si la cadena coincide con el patrón
        return matcher.matches();
    }

    /**
     * Método para validar numeros, se verifica que sea un número de longuitud
     * indeterminada.
     *
     * @param numero Numero a validar.
     * @return Verdadero si el numero tiene el formato correcto, falso en caso
     * contrario
     */
    public boolean validarNumero(String numero) {
        // Se remueven espacios en blanco
        CharSequence cadena = numero.trim();
        // Expresión regular
        String patron = "^\\d*\\.?\\d+$";
        // Se crea un objeto de tipo pattern para verificar patrones
        Pattern p = Pattern.compile(patron);
        // Objeto de verificación
        Matcher matcher = p.matcher(cadena);
        // Devuelve verdadero si la cadena coincide con el patrón
        return matcher.matches();
    }

    /**
     * Método para validar enteros, se verifica que sea un número de longuitud
     * indeterminada sin un punto decimal, se utiliza para verificar dias, entre
     * otros campos.
     *
     * @param entero Entero a validar.
     * @return Verdadero si el entero tiene el formato correcto, falso en caso
     * contrario
     */
    public boolean validarEntero(String entero) {
        // Se remueven espacios en blanco
        CharSequence cadena = entero.trim();
        // Expresión regular
        String patron = "^\\d+$";
        // Se crea un objeto de tipo pattern para verificar patrones
        Pattern p = Pattern.compile(patron);
        // Objeto de verificación
        Matcher matcher = p.matcher(cadena);
        // Devuelve verdadero si la cadena coincide con el patrón
        return matcher.matches();
    }

    /**
     * Método para recortar el signo de + de una cadena.
     *
     * @param cadena Cadena a recortar signo.
     * @return Cadena sin el signo de más.
     */
    public String recortarSignoMas(String cadena) {
        if (cadena.startsWith("+")) {
            return cadena.substring(1);
        } else {
            return cadena;
        }
    }

    /**
     * Busca todas las ocurrencias de la cadena dada (en este caso, una coma) y
     * las reemplaza con la cadena de reemplazo especificada (en este caso, una
     * cadena vacía). Este método devuelve una nueva cadena que es la entrada
     * original sin todas las comas.
     *
     * @param entrada Cadena entrante a la que se le retirarán todas las comas.
     * @return Cadena sin comas.
     */
    public String recortarComas(String entrada) {
        return entrada.replace(",", "");
    }

    /**
     * Método para recortar guiones bajos (_) de una cadena dada.
     *
     * @param textoConGuiones Cadena que posiblemente contiene guiones bajos
     * @return Cadena sin guiones bajos
     */
    public String recortarGuiones(String textoConGuiones) {
        String textoSinGuiones = textoConGuiones.replaceAll("_", "");
        return textoSinGuiones;
    }

    /**
     * Método para corregir los puntos en una cadena dada, asegurando que solo
     * haya un punto consecutivo en la cadena.
     *
     * @param str Cadena con puntos
     * @return Cadena corregida con puntos consecutivos
     */
    public String corregirPuntos(String str) {
        return str.replaceAll("\\.+", ".");
    }

    /**
     * Método para obtener todos los números de una cadena dada, eliminando
     * cualquier otro carácter que no sea un número.
     *
     * @param cadena Cadena que posiblemente contiene números
     * @return Cadena que contiene solo los números de la cadena original
     */
    public String obtenerNumeros(String cadena) {
        // Utiliza una expresión regular para eliminar todo lo que no sean números
        String numeros = cadena.replaceAll("[^0-9]", "");
        return numeros;
    }

    /**
     * Método para validar que una cadena no tenga espacios.
     *
     * @param string Cadena a validar.
     * @return Verdadero si la cadena tiene el formato correcto, falso en caso
     * contrario
     */
    public boolean validarSinEspacios(String string) {
        // Se remueven espacios en blanco
        CharSequence cadena = string.trim();
        // Expresión regular
        String patron = "\\S+";
        // Se crea un objeto de tipo pattern para verificar patrones
        Pattern p = Pattern.compile(patron);
        // Objeto de verificación
        Matcher matcher = p.matcher(cadena);
        // Devuelve verdadero si la cadena coincide con el patrón
        return matcher.matches();
    }

    /**
     * El método "validarFechas" en Java toma dos parámetros de tipo Calendar:
     * "fechaInicial" y "fechaFinal". Utiliza el método "before" de la clase
     * Calendar para verificar si "fechaInicial" es anterior a "fechaFinal".
     *
     * @param fechaInicial Fecha inicial que tiene que ser antes
     * @param fechaFinal Fecha final que tiene que ser después
     * @return Si "fechaInicial" es anterior a "fechaFinal", el método devuelve
     * true; de lo contrario, devuelve false.
     */
    public boolean validarFechas(Calendar fechaInicial, Calendar fechaFinal) {
        return fechaInicial.before(fechaFinal);
    }

    /**
     * Método para centrar una tabla en la interfaz gráfica.
     *
     * @param tabla La tabla que se centrará en la interfaz gráfica
     */
    public void centrarTabla(JTable tabla) {
        DefaultTableCellRenderer rightRenderer = new DefaultTableCellRenderer();
        rightRenderer.setHorizontalAlignment(SwingConstants.CENTER);
        TableModel tableModel = tabla.getModel();
        for (int columnIndex = 0; columnIndex < tableModel.getColumnCount(); columnIndex++) {
            tabla.getColumnModel().getColumn(columnIndex).setCellRenderer(rightRenderer);
        }
    }

    /**
     * Método para corregir una cadena que representa un número flotante,
     * asegurando que tenga el formato adecuado.
     *
     * @param str La cadena que representa el número flotante
     * @return La cadena corregida que representa el número flotante
     */
    public String corregirFlotante(String str) {
        // Se verifica que no sea solamente un punto
        if (str.equals(".")) {
            return "1.0";
        }

        // Eliminar todos los espacios
        str = str.replaceAll("\\s+", "");

        // Eliminar todas las comas
        str = str.replaceAll(",", "");

        // Eliminar los signos +
        str = str.replaceAll("[+-]", "");

        // Reemplazar múltiples puntos por un solo punto
        str = str.replaceAll("(\\.)\\1+", "$1");

        // Si no hay ningún punto, insertar un ".0" al final
        if (!str.contains(".")) {
            str += ".0";
        }

        // Validar que la cadena es un número flotante
        return str;
    }

    /**
     * Elimina espacios en blanco consecutivos de una cadena, aplicando también
     * trim() para eliminar espacios al principio y al final.
     *
     * @param cadena La cadena de entrada.
     * @return La cadena resultante sin espacios en blanco consecutivos y sin
     * espacios al principio y al final.
     */
    public static String eliminarEspaciosRepetidos(String cadena) {
        // Aplica trim() para eliminar espacios en blanco al principio y al final de la cadena,
        // luego utiliza una expresión regular para reemplazar espacios en blanco consecutivos con un solo espacio.
        return cadena.trim().replaceAll("\\s+", " ");
    }
}
