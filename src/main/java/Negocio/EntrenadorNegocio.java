/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Negocio;

import DAOs.EntrenadoresDAO;
import Dominio.Entrenador;
import Enumeradores.Scope;
import Exceptions.InputException;
import Herramientas.Validaciones;

/**
 *
 * @author el_fr
 */
public class EntrenadorNegocio {

    private EntrenadoresDAO dao;
    private Validaciones val;

    public EntrenadorNegocio() {
        dao = new EntrenadoresDAO("AppPlanU");
        val = new Validaciones();
    }

    /**
     * Si
     *
     * @param scope
     */
    public EntrenadorNegocio(Scope scope) {
        if (scope == null) {
            return;
        }
        if (scope.equals(Scope.TEST)) {
            this.dao = new EntrenadoresDAO("AppPlanUTest");
        }
        if (scope.equals(Scope.DEV)) {
            this.dao = new EntrenadoresDAO("AppPlanU");
        }
        val = new Validaciones();
    }

    /**
     * Método que hace llamada a la capa DAO para iniciar sesión en el sistema
     *
     * @param usuario representa el usuario a ingresar al sistema
     * @param contrasena representa la contraseña del usuario a ingresar al
     * sistema
     * @return devuelve el usuario solo si es encontrado en la capa DAO
     * @throws Exception devuelve una excepción si ocurrió algún error
     */
    public Entrenador iniciarSesion(String usuario, String contrasena) throws Exception {
        try {
            Entrenador entrenador;
            if (usuario.isBlank()) {
                throw new InputException("Debe llenar el campo usuario", "usuario");
            }
            if (contrasena.isBlank()) {
                throw new InputException("Debe llenar el campo contraseña", "contrasena");
            }
            entrenador = dao.iniciarSesionEntrenador(usuario, contrasena);
            return entrenador;
        } catch (Exception ex) {
            // lanza InputExcepción si la excepción es de tipo InputExcepción 
            if (ex instanceof InputException) {
                throw ex;
            }
            // en caso contrario solo Excepción
            throw new Exception(ex.getMessage());
        }
    }
}
