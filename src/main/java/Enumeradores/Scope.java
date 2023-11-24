/*
 * Scope.java
 */
package Enumeradores;

/**
 * Enumeración que representa los posibles alcances (scope) de un sistema.
 * 
 * @author Equipo #5 - Metodologías Ágiles de Desarrollo
 */
public enum Scope {
    PROD("produccion"), DEV("desarrollo"), TEST("test");
    
    private String scope;

    /**
     * Constructor privado de Scope.
     *
     * @param s Nombre del alcance.
     */
    private Scope(String s) {
        this.scope = s;
    }

    /**
     * Obtiene el nombre del alcance.
     *
     * @return Nombre del alcance.
     */
    public String getScope() {
        return scope;
    }
}
