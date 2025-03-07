package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import concursantes.Concursante;

class ConcursanteTest {

	@Test
	@DisplayName ("Crear concursante normal")
	@Tag ("Concursante")
	void CrearConcursanteNormal() {
		Concursante c1 = new Concursante(001, "Gacela", "Thomson", "Cudeira", "01/01/2000", true, 20000);
		assertEquals(c1.toString(), """
				Participante nº: 1
				Nombre: Gacela
				Apellidos: Thomson
				Fecha de nacimiento: 01/01/2000
				Nacionalidad: Cudeira
				Sexo: V
				Deuda acumulada: 20000,00
				""");
	}
	
	@Test
	@DisplayName ("Crear concursante infiltrado")
	@Tag ("Concursante")
	void CrearConcursanteInfiltrado() {
		Concursante c2 = new Concursante(002, "Chino", "Cudeiro", "Takeshino", "01/01/2000", false, 40000, "Paquita", "Chocolatera");
		assertEquals(c2.toString(), """
				Participante nº: 2
				Nombre: Chino
				Apellidos: Cudeiro
				Fecha de nacimiento: 01/01/2000
				Nacionalidad: Takeshino
				Sexo: M
				Deuda acumulada: 40000,00
				INFILTRADO
				Nombre Real: Paquita
				Apellidos Reales: Chocolatera
				""");
	}

}
