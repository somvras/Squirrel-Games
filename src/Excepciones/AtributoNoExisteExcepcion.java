package Excepciones;
/**
 * La clase AtributoNoExisteExcepcion construye las excepciones lanzadas al tratar de obtener un atributo no inicializado en un participante.
 * @author Alberto
 * @version 1.0
 * @see Concursante
 */
public class AtributoNoExisteExcepcion extends Exception{
	private static final long serialVersionUID = -4389301539151223328L;

	/**
	 * Constructor que permite crear las excepciones lanzadas al tratar de obtener un parámentro que no ha sido inicializado;
	 * @param mensaje El mensaje que describirá el tipo de excepción.
	 */
	public AtributoNoExisteExcepcion(String mensaje) {
		super(mensaje);
	}
}
