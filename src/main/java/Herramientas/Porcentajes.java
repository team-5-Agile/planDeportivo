/*
 * Porcentajes.java
 */
package Herramientas;

/**
 * Clase que proporciona herramientas para el cálculo de porcentajes.
 * 
 *  @author Equipo #5 - Metodologías Ágiles de Desarrollo
 */
public class Porcentajes {

    /**
     * Calcula el porcentaje del porcentaje inicial.
     *
     * @param strPorcentajeInicial El porcentaje inicial (por ejemplo, 100%).
     * @param strPorcentajeDividido El porcentaje que se está dividiendo del
     * porcentaje inicial.
     * @return El porcentaje resultante del porcentaje dividido con respecto al
     * porcentaje inicial.
     */
    public static Double calcularPorcentaje(String strPorcentajeInicial, String strPorcentajeDividido) {
        Double porcentajeInicial = Double.valueOf(strPorcentajeInicial);
        Double porcentajeDividido = Double.valueOf(strPorcentajeDividido);
        
        // Verifica que los porcentajes estén en el rango [0, 100].
        if (porcentajeInicial < 0 || porcentajeInicial > 100 || porcentajeDividido < 0 || porcentajeDividido > 100) {
            throw new IllegalArgumentException("Los porcentajes deben estar en el rango [0, 100].");
        }

        // Calcula el porcentaje resultante.
        Double resultado = (porcentajeDividido / 100) * porcentajeInicial;
        return resultado;
    }
}
