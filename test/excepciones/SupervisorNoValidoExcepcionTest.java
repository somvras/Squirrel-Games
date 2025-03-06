package Excepciones;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Pruebas unitarias para la excepción SupervisorNoValidoExcepcion.
 * Verifica que el mensaje proporcionado se retorne correctamente.
 * 
 * @author Mikael
 * @version 1.0
 */
public class SupervisorNoValidoExcepcionTest {

    /**
     * Verifica que al instanciar la excepción con un mensaje, getMessage() retorne dicho mensaje.
     */
    @Test
    public void testMensajeException() {
        String mensaje = "El supervisor asignado no tiene un rango superior.";
        SupervisorNoValidoExcepcion exception = new SupervisorNoValidoExcepcion(mensaje);
        assertEquals(mensaje, exception.getMessage(), "El mensaje de la excepción debería coincidir con el proporcionado.");
    }
}
