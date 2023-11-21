/*
 * .java
 */
package Enumeradores;

/**
 * Alcance 
 * @author el_fr
 */
public enum Scope {
    PROD("produccion"), DEV("desarrollo"), TEST("test");
    
    private String scope;

    private Scope(String s) {
        this.scope = s;
    }

    public String getScope() {
        return scope;
    }

}
