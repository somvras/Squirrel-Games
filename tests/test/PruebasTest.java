package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import Excepciones.DificultadNoValidaExcepcion;
import Excepciones.IntentoDeEliminarInfiltradoException;
import Excepciones.ResponsableNoEsManagerException;
import concursantes.Concursante;
import pinkGuards.Manager;
import pruebas.Prueba;

class PruebasTest {
	private Concursante c1 = new Concursante(001, "Gacela", "Thomson", "Cudeira", "01/01/2000", true, 20000);
	private Concursante c2 = new Concursante(002, "Chino", "Cudeiro", "Takeshino", "01/01/2000", false, 40000, "Paquita", "Chocolatera");
	private Manager m = new Manager(1, "Maloso", 50);
	private ArrayList<Concursante> participantes;
	private Prueba p1;
	
	
	@BeforeEach
	void setup() throws ResponsableNoEsManagerException {
		participantes = new ArrayList<Concursante>();
		participantes.add(c1);
		participantes.add(c2);	
		p1 = new Prueba("Prueba Piloto", "Prueba de prueba", participantes, m);
	}
	
	@Test
	@DisplayName ("Excepción para demasiada dificultad")
	@Tag ("Dificultad")
	void demasiadaDificultadTest() {
		DificultadNoValidaExcepcion excepcion = assertThrows(DificultadNoValidaExcepcion.class, () -> {p1.simulacion(101);});
	}

	@Test
	@DisplayName ("Excepción no lanzada para dificultad límite válida y lanzada execpcion de infiltrado")
	@Tag ("Dificultad")
	void dificultadValidaTest() {
		IntentoDeEliminarInfiltradoException excepcion = assertThrows(IntentoDeEliminarInfiltradoException.class, () -> {p1.simulacion(100);});
	}
	
	@Test
	@DisplayName ("Prueba exitosa")
	void pruebaExitosa() throws DificultadNoValidaExcepcion, IntentoDeEliminarInfiltradoException {
		p1.simulacion(50);		
		assertEquals(p1.getVencedores().isEmpty(), false);
		assertEquals(p1.getEliminados().isEmpty(), false);
	}
}
