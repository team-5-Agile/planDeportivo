/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Negocio;

import DAOs.EntrenadoresDAO;
import Dominio.Entrenadores;
import Exceptions.InputException;
import Herramientas.Validaciones;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author el_fr
 */
public class EntrenadorNegocio {

    private EntrenadoresDAO dao;
    private Validaciones val;

    public EntrenadorNegocio() {
        dao = new EntrenadoresDAO("AppPlanU");
        val=new Validaciones();
    }
    /**
     * Método que hace llamada a la capa DAO para iniciar sesión en el sistema
     * @param usuario representa el usuario a ingresar al sistema
     * @param contrasena representa la contraseña del usuario a ingresar al sistema
     * @return devuelve el usuario solo si es encontrado en la capa DAO
     * @throws Exception devuelve una excepción si ocurrió algún error
     */
    public Entrenadores iniciarSesion(String usuario, String contrasena) throws Exception  {
        try {
            Entrenadores entrenador;
            if (usuario == null ) {
                throw new InputException("Debe llenar el campo usuario","usuario");
            }
            if(contrasena == null){
                throw new InputException("Debe llenar el campo contraseña","contrasena");
            }
            if (!val.validarSinEspacios(usuario)) {
                throw new InputException("El campo usuario no debe estar vacio","usuario");
            }
            if (!val.validarSinEspacios(contrasena)) {
                throw new InputException("El campo contraseña no debe estar vacio","contrasena");
            }
            
            entrenador = dao.iniciarSesionEntrenador(usuario, contrasena);
            return entrenador;
        } catch (Exception ex) {
            // lanza InputExcepción si la excepción es de tipo InputExcepción 
            if(ex instanceof InputException)throw ex;
            // en caso contrario solo Excepción
            throw new Exception(ex.getMessage());
        }
    }
}
