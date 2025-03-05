package pinkGuards;

import Excepciones.SupervisorNoValidoExcepcion;

/**
 * Representa a un Worker de los Pink Guards.
 * <p>
 * Un Worker realiza tareas logísticas y de mantenimiento y pertenece a un departamento específico.
 * </p>
 * 
 * @author Mikael
 * @version 1.0
 * @see PinkGuard
 * @see Departamento
 */
public class Worker extends PinkGuard {
    private Departamento departamento;
    
    /**
     * Crea un nuevo Worker.
     * 
     * @param id El identificador único del Worker.
     * @param nombre El nombre del Worker.
     * @param departamento El departamento al que pertenece.
     * @param supervisor El supervisor del Worker, que debe tener un rango superior.
     * @throws SupervisorNoValidoExcepcion Si el supervisor asignado no tiene un rango superior.
     */
    public Worker(int id, String nombre, Departamento departamento, PinkGuard supervisor) throws SupervisorNoValidoExcepcion {
        super(id, nombre);
        this.departamento = departamento;
        this.setSupervisor(supervisor);
    }
    
    /**
     * Devuelve el rango del Worker.
     * 
     * @return El rango {@link Rango#WORKER} de este Worker.
     */
    @Override
    public Rango getRango() {
        return Rango.WORKER;
    }
    
    /**
     * Obtiene el departamento al que pertenece el Worker.
     * 
     * @return El departamento del Worker.
     */
    public Departamento getDepartamento() {
        return departamento;
    }
    
    /**
     * Establece el departamento del Worker.
     * 
     * @param departamento El nuevo departamento a asignar.
     */
    public void setDepartamento(Departamento departamento) {
        this.departamento = departamento;
    }
    
    /**
     * Representa el Worker en forma de cadena.
     * 
     * @return Una cadena que contiene la información del Worker, incluyendo su departamento.
     */
    @Override
    public String toString() {
        return super.toString() + ", Departamento: " + departamento;
    }

    /**
     * Devuelve el nombre del Worker.
     * 
     * @return El nombre del Worker.
     */
    @Override
    public String getNombre() {
        return this.nombre;
    }
}
