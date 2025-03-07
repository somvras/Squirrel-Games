package pinkGuards;

/**
 * Enumerado que define los rangos jerárquicos de los Pink Guards.
 * <p>
 * Los rangos disponibles son WORKER, SOLDIER y MANAGER, en orden ascendente de autoridad.
 * </p>
 * 
 * @author Mikael
 * @version 1.0
 * @see PinkGuard
 */
public enum Rango {
    /**
     * Representa el rango de Worker.
     */
    WORKER,
    /**
     * Representa el rango de Soldier.
     */
    SOLDIER,
    /**
     * Representa el rango de Manager.
     */
    MANAGER
}
