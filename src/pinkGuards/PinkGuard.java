package pinkGuards;
import Excepciones.SupervisorNoValidoExcepcion;

public abstract class PinkGuard {
	protected int id;
    protected String nombre;
    protected PinkGuard supervisor;
    
    public PinkGuard(int id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }
    
    // Cada subclase define su rango
    public abstract Rango getRango();
    
    public PinkGuard getSupervisor() {
        return supervisor;
    }
    
    /**
     * Asigna un supervisor validando que tenga un rango superior.
     * Si el supervisor es nulo, se asigna sin comprobación.
     */
    public void setSupervisor(PinkGuard supervisor) throws SupervisorNoValidoExcepcion {
        if (supervisor != null) {
            if (supervisor.getRango().ordinal() <= this.getRango().ordinal()) {
                throw new SupervisorNoValidoExcepcion("El supervisor asignado (" + supervisor.getRango() + ") no tiene un rango superior al de " + this.getRango() + ".");
            }
        }
        this.supervisor = supervisor;
    }
    
    @Override
    public String toString() {
        String info = "ID: " + id + ", Nombre: " + nombre + ", Rango: " + getRango();
        if (supervisor != null) {
            info += ", Supervisor: [" + supervisor.nombre + " - " + supervisor.getRango() + "]";
        }
        return info;
    }
	
}

