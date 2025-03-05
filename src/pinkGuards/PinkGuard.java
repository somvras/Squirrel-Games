package pinkGuards;

import Excepciones.SupervisorNoValidoExcepcion;

/**
 * Clase abstracta que representa un PinkGuard.
 * <p>
 * Los Pink Guards son el personal encargado de tareas en los juegos, y esta clase define atributos y comportamientos comunes a todas sus subclases.
 * </p>
 * 
 * @author Mikael
 * @version 1.0
 * @see Worker
 * @see Soldier
 * @see Manager
 */
public abstract class PinkGuard {
    protected int id;
    protected String nombre;
    protected PinkGuard supervisor;
    
    /**
     * Crea una instancia de PinkGuard con un identificador y nombre.
     * 
     * @param id El identificador único del PinkGuard.
     * @param nombre El nombre del PinkGuard.
     */
    public PinkGuard(int id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }
    
    public int getId() {
		return id;
	}

	/**
     * Devuelve el rango del PinkGuard.
     * <p>
     * Este método debe ser implementado por cada subclase.
     * </p>
     * 
     * @return El rango del PinkGuard.
     */
    public abstract Rango getRango();
    
    /**
     * Obtiene el supervisor del PinkGuard.
     * 
     * @return El supervisor asignado o null si no se ha asignado ninguno.
     */
    public PinkGuard getSupervisor() {
        return supervisor;
    }
    
    /**
     * Devuelve el nombre del PinkGuard.
     * <p>
     * Este método debe ser implementado por las subclases para retornar correctamente el nombre.
     * </p>
     * 
     * @return El nombre del PinkGuard.
     */
    public abstract String getNombre();

    /**
     * Asigna un supervisor validando que tenga un rango superior.
     * <p>
     * Si el supervisor es nulo, se asigna sin comprobación.
     * </p>
     * 
     * @param supervisor El PinkGuard a asignar como supervisor.
     * @throws SupervisorNoValidoExcepcion Si el supervisor no tiene un rango superior.
     */
    public void setSupervisor(PinkGuard supervisor) throws SupervisorNoValidoExcepcion {
        if (supervisor != null) {
            if (supervisor.getRango().ordinal() <= this.getRango().ordinal()) {
                throw new SupervisorNoValidoExcepcion("El supervisor asignado (" + supervisor.getRango() + ") no tiene un rango superior al de " + this.getRango() + ".");
            }
        }
        this.supervisor = supervisor;
    }
    
    /**
     * Representa el objeto en forma de cadena.
     * 
     * @return Una cadena que contiene el ID, nombre y rango del PinkGuard, y la información del supervisor si existe.
     */
    @Override
    public String toString() {
        String info = "ID: " + id + ", Nombre: " + nombre + ", Rango: " + getRango();
        if (supervisor != null) {
            info += ", Supervisor: [" + supervisor.nombre + " - " + supervisor.getRango() + "]";
        }
        return info;
    }
}


