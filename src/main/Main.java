package main;

import java.time.LocalDate;
import java.util.ArrayList;

import Excepciones.DificultadNoValidaExcepcion;
import Excepciones.IntentoDeEliminarInfiltradoException;
import Excepciones.ResponsableNoEsManagerException;
import concursantes.Concursante;
import pinkGuards.Manager;
import pruebas.Prueba;

public class Main {

	public static void main(String[] args) throws ResponsableNoEsManagerException, DificultadNoValidaExcepcion {
	
		Concursante c1 = new Concursante(001, "Gacela", "Thomson", "Cudeira", "01/01/2000", true, 20000);
		System.out.println(c1);
		Concursante c2 = new Concursante(3, "Antonia", "Pepota", "Francesa", "28/04/1958", false, 10000, "maria", "pascuala");
		//System.out.println(c2);
		
		ArrayList<Concursante> concursantes = new ArrayList<Concursante>();
		concursantes.add(c1); concursantes.add(c2);
		Manager responsable = new Manager(000001, "Nombre", 500);
		
		Prueba ejemplo = new Prueba("Nombre","Descripción",concursantes,responsable);
		System.out.println(ejemplo+"\n");
		try {
			ejemplo.simulacion(50);
		} catch (DificultadNoValidaExcepcion e){
			System.out.println(e.getMessage());
		} catch (IntentoDeEliminarInfiltradoException e){
			System.out.println(e.getMessage());
		}
		
	}

}
