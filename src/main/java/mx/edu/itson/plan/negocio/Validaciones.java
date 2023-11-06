package mx.edu.itson.plan.negocio;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * <b>Validaciones Clase que contiene métodos para realizar validaciones
 * necesarias en el paquete negocio.</b>
 *
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
            throw new Exception("La fecha fin: "+strFechaFin+" no puede ser anterior a"+ strFechaInicio );
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
}
