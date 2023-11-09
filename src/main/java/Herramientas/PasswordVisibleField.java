/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Herramientas;


import javax.swing.JCheckBox;
import javax.swing.JPasswordField;
import javax.swing.text.BadLocationException;

/**
 * <strong>PasswordVisibleField</strong> es un custom-component que utiliza un
 * checkbox que desencadena un evento para mostrar u ocultar el contenido del
 * JTextfield
 *
 * @author el_fr
 */
public class PasswordVisibleField extends JPasswordField {

    private JCheckBox checkbox;

    public PasswordVisibleField() {

    }

    public void setCheckBox(JCheckBox checkbox) {
        this.checkbox = checkbox;
        setEchoChar('*');
        configCheckBox();

    }

    public PasswordVisibleField(JCheckBox checkbox) {
        this.checkbox = checkbox;
    }

    /**
     * este metodo agrega el evento al checkbox
     */
    public void configCheckBox() {
        this.checkbox.addItemListener((e) -> {

            try {
                String txtContent = getDocument().getText(0, getDocument().getLength());
                setText(txtContent);
                requestFocus();
            } catch (BadLocationException ex) {
                System.err.println(ex.getMessage());
            }
        });

    }

    @Override
    public void setText(String t) {
        // si el checkBox es seleccionado no se muestra el contenido 
        if (!checkbox.isSelected()) {
            setEchoChar('*');
        } else {
            // en caso contrario se muestra
            setEchoChar('\u0000');
        }

        super.setText(t);

    }

}
