package Excepciones;

/**
* La clase DificultadNoValidaExcepcion construye las excepciones lanzadas al tratar de introducir una dificultad en una prueba que no puede ser una cantidad porcentual.
* @author Alberto
* @version 1.0
* @see Prueba
*/
public class DificultadNoValidaExcepcion extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 6403182114230278306L;

	/**
	 * Constructor que permite crear las excepciones lanzadas al tratar de introducir una dificultad no válida en una prueba;
	 * @param mensaje El mensaje que describirá el tipo de excepción.
	 */
	public DificultadNoValidaExcepcion(String mensaje) {
		super(mensaje);
	}
}
