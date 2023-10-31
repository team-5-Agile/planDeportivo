package io.github.jeomiturbe.appplan.negocio;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @class Validaciones Clase que contiene métodos para realizar validaciones
 * comunes en la capa de negocio.
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
        boolean isValida = false;
        try {
            Pattern pattern = Pattern.compile(FORMATO_FECHA, Pattern.CASE_INSENSITIVE);
            Matcher matcher = pattern.matcher(strFecha);

            if (!matcher.matches()) {
                throw new Exception("Error, La Fecha debe ser en formato dd/mm/yyyy");
            }

            isValida = true;
        } catch (Exception e) {
            System.out.print(e.getMessage() + " ");
        }
        return isValida;

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

            isValida = true;

        } catch (Exception e) {
            System.out.print(e.getMessage() + " ");
        }
        return isValida;

    }

}
