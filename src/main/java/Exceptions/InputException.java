/*
 * InputException.java
 */
package Exceptions;

/**
 * Clase de excepción personalizada para manejar errores de entrada.
 * 
 * @author Equipo #5 - Metodologías Ágiles de Desarrollo
 */
public class InputException extends Exception {

    private String textField;

    /**
     * Constructor de InputException.
     * 
     * @param message Mensaje de la excepción.
     * @param textField Nombre del campo de texto donde ocurrió el error.
     */
    public InputException(String message, String textField) {
        super(message);
        this.textField = textField;
    }

    /**
     * Obtiene el nombre del campo de texto donde ocurrió el error.
     * 
     * @return Nombre del campo de texto.
     */
    public String getTextField() {
        return textField;
    }

}
