package pinkGuards;

/**
 * Enumerado que representa las armas utilizadas por los Pink Guards.
 * <p>
 * Cada constante del enumerado representa un arma con su descripción correspondiente.
 * </p>
 * 
 * @author Mikael
 * @version 1.0
 * @see Soldier
 */
public enum Arma {
    GLOCK17("Pistola Glock 17"),
    MP5("Rifle de asalto Heckler & Koch MP5"),
    G3("Rifle automático Heckler & Koch G3");
    
    private final String descripcion;
    
    /**
     * Constructor del enumerado Arma.
     * 
     * @param descripcion La descripción del arma.
     */
    Arma(String descripcion) {
        this.descripcion = descripcion;
    }
    
    /**
     * Devuelve la descripción del arma.
     * 
     * @return La descripción del arma.
     */
    @Override
    public String toString() {
        return descripcion;
    }
}
