package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import Excepciones.SupervisorNoValidoExcepcion;

/**
 * Pruebas unitarias para la excepción SupervisorNoValidoExcepcion.
 * 
 * @author Mikael
 * @version 1.0
 */
@Tag("Excepciones")
@DisplayName("Pruebas de excepciones")
class ExceptionTest {

    @Test
    @DisplayName("Verificar mensaje de SupervisorNoValidoExcepcion")
    void testSupervisorNoValidoExcepcionMensaje() {
        String mensaje = "El supervisor asignado no tiene un rango superior.";
        SupervisorNoValidoExcepcion exception = new SupervisorNoValidoExcepcion(mensaje);
        assertEquals(mensaje, exception.getMessage());
    }
}