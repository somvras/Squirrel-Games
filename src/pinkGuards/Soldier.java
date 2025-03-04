package pinkGuards;

import Excepciones.SupervisorNoValidoExcepcion;

/**
 * Representa a un Soldier de los Pink Guards.
 * <p>
 * Un Soldier es responsable de mantener el orden y utiliza un arma específica con una cantidad de munición asignada.
 * </p>
 * 
 * @author Mikael
 * @version 1.0
 * @see PinkGuard
 * @see Arma
 */
public class Soldier extends PinkGuard {
    private Arma arma;
    private int municion;
    
    /**
     * Crea un nuevo Soldier.
     * 
     * @param id El identificador único del Soldier.
     * @param nombre El nombre del Soldier.
     * @param arma El arma asignada al Soldier.
     * @param municion La cantidad de munición disponible.
     * @param supervisor El supervisor del Soldier, que debe tener un rango superior.
     * @throws SupervisorNoValidoExcepcion Si el supervisor no tiene un rango superior.
     */
    public Soldier(int id, String nombre, Arma arma, int municion, PinkGuard supervisor) throws SupervisorNoValidoExcepcion {
        super(id, nombre);
        this.arma = arma;
        this.municion = municion;
        this.setSupervisor(supervisor);
    }
    
    /**
     * Devuelve el rango del PinkGuard.
     * 
     * @return El rango {@link Rango#SOLDIER} de este Soldier.
     */
    @Override
    public Rango getRango() {
        return Rango.SOLDIER;
    }
    
    /**
     * Obtiene el arma asignada al Soldier.
     * 
     * @return El arma del Soldier.
     */
    public Arma getArma() {
        return arma;
    }
    
    /**
     * Establece el arma del Soldier.
     * 
     * @param arma El arma a asignar.
     */
    public void setArma(Arma arma) {
        this.arma = arma;
    }
    
    /**
     * Obtiene la cantidad de munición del Soldier.
     * 
     * @return La cantidad de munición disponible.
     */
    public int getMunicion() {
        return municion;
    }
    
    /**
     * Establece la cantidad de munición del Soldier.
     * 
     * @param municion La cantidad de munición a asignar.
     */
    public void setMunicion(int municion) {
        this.municion = municion;
    }
    
    /**
     * Representa el Soldier en forma de cadena.
     * 
     * @return Una cadena que contiene la información del Soldier, incluyendo su arma y munición.
     */
    @Override
    public String toString() {
        return super.toString() + ", Arma: " + arma + ", Munición: " + municion;
    }

    /**
     * Devuelve el nombre del Soldier.
     * 
     * @return El nombre del Soldier.
     */
    @Override
    public String getNombre() {
        return this.nombre;
    }
}

