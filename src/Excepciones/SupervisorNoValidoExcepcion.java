package Excepciones;

public class SupervisorNoValidoExcepcion extends Exception {
    /**
	 * 
	 */
	private static final long serialVersionUID = -5451589440047408211L;

	public SupervisorNoValidoExcepcion(String mensaje) {
        super(mensaje);
    }
}
