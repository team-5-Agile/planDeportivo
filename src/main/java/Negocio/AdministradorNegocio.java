/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Negocio;

import DAOs.AdministradorDAO;
import Dominio.Administrador;
import Exceptions.InputException;
import Herramientas.Validaciones;
import javax.swing.JOptionPane;

/**
 *
 * @author brawun
 */
public class AdministradorNegocio {
    
    private AdministradorDAO dao;
    private Validaciones val;

    public AdministradorNegocio() {
        dao = new AdministradorDAO("AppPlanU");
        val = new Validaciones();
    }
    /**
     * Método que hace llamada a la capa DAO para iniciar sesión en el sistema
     * @param usuario representa el usuario a ingresar al sistema
     * @param contrasena representa la contraseña del usuario a ingresar al sistema
     * @return devuelve el usuario solo si es encontrado en la capa DAO
     * @throws Exception devuelve una excepción si ocurrió algún error
     */
    public Administrador iniciarSesion(String usuario, String contrasena) throws Exception  {
        try {
            Administrador administrador;
            if (usuario.isBlank()) {
                throw new InputException("Debe llenar el campo usuario", "usuario");
            }
            if (contrasena.isBlank()) {
                throw new InputException("Debe llenar el campo contraseña", "contrasena");
            }
            administrador = dao.iniciarSesionAdministrador(usuario, contrasena);
            return administrador;
        } catch (Exception ex) {
            // lanza InputExcepción si la excepción es de tipo InputExcepción 
            if(ex instanceof InputException)throw ex;
            // en caso contrario solo Excepción
            throw new Exception(ex.getMessage());
        }
    }
}
