package mx.edu.itson.plan.negocio;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * <b>Validaciones Clase que contiene métodos para realizar validaciones
 * necesarias en el paquete negocio.</b>
 * @author José Alfredo Núñez
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
     */
    public boolean isFechaValida(String strFecha) {
        try {
            Pattern pattern = Pattern.compile(FORMATO_FECHA, Pattern.CASE_INSENSITIVE);
            Matcher matcher = pattern.matcher(strFecha);
            
            if (!matcher.matches()) {
                throw new Exception("Error, La Fecha debe ser en formato dd/mm/yyyy");
            }
            
            convertirFecha(strFecha);
            return true;
        } catch (Exception e) {
            System.err.println(e.getMessage());
            return false;
        }

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
     */
    public boolean isNumSemanaValido(String strSemanas, Integer min, Integer max) {
        boolean isValida = false;
        try {
            Pattern pattern = Pattern.compile(FORMATO_NUMSEMANAS, Pattern.CASE_INSENSITIVE);
            Matcher matcher = pattern.matcher(strSemanas);

            if (!matcher.matches()) {
                throw new Exception("Error, El formato para número de semanas debe ser de 2 digitos: 00");
            }
            if (Integer.valueOf(strSemanas) < min || Integer.valueOf(strSemanas) > max) {
                throw new Exception("Error, El número de semanas no puede ser menor a " + min + " ni mayor a " + max);
            }

            return true;

        } catch (Exception e) {
            System.out.println(e.getMessage() + " ");
            return false;
        }
      
    }
    /**
     * Método qué válida si la fecha ingresada es anterior a la fecha actual
     * @param strFecha Representa la fecha como cadena en formato dd/MM/yyyy
     * @return devuelve verdadero si la fecha es anterior y falso en caso contrario
     */
    public boolean isFechaAnterior(String strFecha) {

        try {
            LocalDate hoy = LocalDate.now();
            LocalDate fecha = convertirFecha(strFecha);
            return hoy.isBefore(fecha);
        } catch (Exception e) {
            System.err.println(e.getMessage());
            return true;
        }
    }
    /**
     * Método qué válida si la fecha Inicio es anterior a la fecha Fin
     * @param strFechaInicio Representa la fecha inicial en una cadena en formato dd/MM/yyyy
     * @param strFechaFin Representa la fecha Fin en una cadena en formato dd/MM/yyyy
     * @return devuelve verdadero si la fecha Inicio es anterior a Fin y dalso en caso contrario
     */
    public boolean isFechaAnterior(String strFechaInicio,String strFechaFin) {

        try {
            LocalDate fechaInicio = convertirFecha(strFechaInicio);
            LocalDate fechaFin = convertirFecha(strFechaFin);
            return fechaInicio.isBefore(fechaFin);
        } catch (Exception e) {
            System.err.println(e.getMessage());
            return true;
        }
    }
    
    
    //TODO: Mover a otra clase
    /**
     *  Método qué convierte una fecha ingresada en un cadena con formato dd/MM/yyyy
     * @param strFecha Representa la fecha inicial en una cadena en formato dd/MM/yyyy
     * @return devuelve la fecha convertida a un objeto LocalDate
     * @throws Exception si la cadena no cuenta con un formato valido lanza una excepción
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
}
