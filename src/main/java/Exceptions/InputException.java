/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Exceptions;

/**
 *
 * @author el_fr
 */
public class InputException extends Exception {

    private String textField;

    // indicamos en que textField ocurrio el error
    public InputException(String message, String textField) {
        super(message);
        this.textField = textField;
    }

    public String getTextField() {
        return textField;
    }

}
