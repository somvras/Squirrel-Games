package Excepciones;

/**
 * La clase SupervisorNoValidoExcepcion se lanza cuando se intenta asignar un supervisor que no tiene un rango superior al del empleado.
 * <p>
 * Esta excepción garantiza que la jerarquía de supervisión se mantenga correctamente.
 * </p>
 * 
 * @author Mikael
 * @version 1.0
 */
public class SupervisorNoValidoExcepcion extends Exception {
    private static final long serialVersionUID = -5451589440047408211L;

    /**
     * Crea una nueva excepción con el mensaje especificado.
     * 
     * @param mensaje El mensaje que describe el error de asignación de supervisor.
     */
    public SupervisorNoValidoExcepcion(String mensaje) {
        super(mensaje);
    }
}
