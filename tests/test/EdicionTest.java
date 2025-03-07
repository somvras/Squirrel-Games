package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import Excepciones.IdRepetidoException;
import Excepciones.ResponsableNoEsManagerException;
import concursantes.Concursante;
import juegos.Edicion;
import pinkGuards.Manager;
import pinkGuards.PinkGuard;
import pruebas.Prueba;

class EdicionTest {

	private Edicion ej1 = new Edicion(2000, "Ubicacion");
	private Concursante ej2 = null;
	private PinkGuard ej3 = null;
	private Prueba ej4 = null;
	
	@Test
	@DisplayName ("Añadir un concursante")
	@Tag ("Participante")
	void nuevoConcursanteExistente() throws IdRepetidoException {
		ej1.nuevoParticipante(ej2);
		assertEquals(ej1.getParticipantesEdicion().size(),1);
	}
	
	@Test
	@DisplayName ("Crear un nuevo concursante")
	@Tag ("Participante")
	void nuevoConcursante() throws IdRepetidoException {
		ej1.nuevoParticipante(001, "Gacela", "Thomson", "Cudeira", "01/01/2000", true, 20000);
		assertEquals(ej1.getParticipantesEdicion().size(),1);
	}
	
	@Test
	@DisplayName ("Añadir un empleado")
	@Tag ("Empleado")
	void nuevoEmpleadoExistente() throws IdRepetidoException {
		ej1.nuevoEmpleado(ej3);
		assertEquals(ej1.getEmpleados().size(),1);
	}
	
	@Test
	@DisplayName ("Añadir una prueba")
	@Tag ("Prueba")
	void nuevaPruebaExistente() {
		ej1.nuevaPrueba(ej4);
		assertEquals(ej1.getPruebas().size(),1);
	}
	
	@Test
	@DisplayName ("Crear una nueva prueba")
	@Tag ("Prueba")
	void nuevaPrueba() throws ResponsableNoEsManagerException {
		Manager manager = new Manager(1, "Manager", 100);
		ej1.nuevaPrueba(null, null, null, manager);
		assertEquals(ej1.getPruebas().size(),1);
	}

}
