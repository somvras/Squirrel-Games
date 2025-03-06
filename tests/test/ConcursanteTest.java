package test;

import org.junit.jupiter.api.Test;

import concursantes.Concursante;

public class ConcursanteTest {
	@BeforeAll
	Concursante c1 = new Concursante(001, "Gacela", "Thomson", "Cudeira", "2000-01-01", true, 20000);
	
	@Test 
	@DisplayName ("Creador de concursante normal")
	void ConcursanteNormalTest {
		assertEquals(c1.toString(), """
				Participante nº: 001
				Nombre: Gacela
				Apellidos: Thomson
				Fecha de nacimiento: 01/01/2000
				Nacionalidad: Cudeira
				Sexo: V
				Deuda acumulada: 20000.00
				""");
	}
}
