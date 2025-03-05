package pruebas;

import java.util.ArrayList;

import Excepciones.DificultadNoValidaExcepcion;
import Excepciones.ResponsableNoEsManagerException;
import concursantes.Concursante;
import pinkGuards.PinkGuard;
import pinkGuards.Rango;

/**
 * La clase Prueba contiene el constructor de las pruebas en las que participan los concursante y métodos algunas funciones que atañen a éstas
 * @author Carolina, Alberto
 * @version 1.0
 * @see Concursante
 * @see PinkGuard
 * @see Edicion
 */

public class Prueba {

	
	private String nombre;
	private String desc;
	private ArrayList<Concursante> participantes;
	private ArrayList<Concursante> eliminados;
	private ArrayList<Concursante> vencedores;
	private PinkGuard responsable;
	
	
	//Constructor//
	public Prueba(String nombre, String desc, ArrayList<Concursante> participantes, PinkGuard responsable) throws ResponsableNoEsManagerException {
		if(!responsable.getRango().equals(Rango.MANAGER)) {
			throw new ResponsableNoEsManagerException("El responsable asignado no es del rango adecuado");
		}
		this.nombre = nombre;
		this.desc = desc;
		this.participantes = participantes;
		this.eliminados = new ArrayList<Concursante>();
		this.vencedores = new ArrayList<Concursante>();
		this.responsable = responsable;
	}
	///////////
	
	
	//Getters//
	public String getNombre() {
		return nombre;
	}

	public String getDesc() {
		return desc;
	}

	public ArrayList<Concursante> getParticipantes() {
		return participantes;
	}

	public ArrayList<Concursante> getEliminados() {
		return eliminados;
	}

	public ArrayList<Concursante> getVencedores() {
		return vencedores;
	}

	public PinkGuard getResponsable() {
		return responsable;
	}
	///////////
	
	
	//Metodos//
	
	/*
	 * Método que simula una prueba. Mantiene la lista de participantes intacta, para futuras consultas. Crea nuevas listas de vencedores y eliminados en
	 * base a la dificultad introducida.
	 * @param dificultad El porcentaje de supervivencia para los participantes.
	 * @throws DificultadNoValidaExcepcion Si la dificultad no está entre 0 y 100.
	 */
	
	public void simulacion(float dificultad) throws DificultadNoValidaExcepcion {
		if (dificultad < 0 || dificultad > 100) {
			throw new DificultadNoValidaExcepcion("La dificultad introducida está fuera de los parámetros aceptables (entre 0 y 100)");
		}
		
		int cantidadEliminados = (int) Math.round(this.participantes.size() * dificultad / 100);
		
		for (int i = 1; i <= cantidadEliminados; i++) {
			eliminados.add(this.participantes.get((int) Math.floor(Math.random() * this.participantes.size())));
		}
		
		for (Concursante concursante : participantes) {
			if (!eliminados.contains(concursante)) {
				vencedores.add(concursante);
			}
		}
		
		/* Versión del método que elimina según aptitud y no por porcentaje. No es lo que pide el enunciado
		for (Concursante concursante : participantes) {
			if (concursante.esInfiltrado() || porcentajeExito(concursante) > dificultad) {
				vencedores.add(concursante);
			} else {
				eliminados.add(concursante);
			}
		}
		*/
		System.out.println(this.toString());
	}
	
	/*
	public float porcentajeExito(Concursante concursante) {
		return (float)(Math.random()*concursante.getCoefAptitud());
	}
	*/
	
	public float porcentajeExito(float dificultad) throws DificultadNoValidaExcepcion {
		if (dificultad < 0 || dificultad > 100) {
			throw new DificultadNoValidaExcepcion("La dificultad introducida está fuera de los parámetros aceptables (entre 0 y 100)");
		}
		return 100 - dificultad;
	}
	

	@Override
	public String toString() {
		String nombres_participantes = "";
		for (Concursante concursante : this.participantes) {
			nombres_participantes += concursante.getNombre() + " " + concursante.getApellidos() + ", ";
		}
		
		String nombres_vencedores= "";
		for (Concursante concursante : this.vencedores) {
			nombres_vencedores+= concursante.getNombre() + " " + concursante.getApellidos() + ", ";
		}
		
		String nombres_eliminados= "";
		for (Concursante concursante : this.eliminados) {
			nombres_eliminados += concursante.getNombre() + " " + concursante.getApellidos() + ", ";
		}
		
		/*String info= """
				Nombre de la prueba: %s
				Descripción: %s
				Participantes: %s
				Vencedores: %s
				Eliminados: %s
				Manager: %s
				""";*/
		return "Prueba: "+this.nombre+"\nDescripción: "+this.desc+"\nParticipantes: "+nombres_participantes+
				"\nVencedores: "+nombres_vencedores+"\nEliminados: "+nombres_eliminados+"\nManager: "+this.responsable.getNombre();
		//return String.format(info, this.nombre, this.desc, nombres_participantes.substring(0, nombres_participantes.length() - 2), nombres_vencedores.substring(0, nombres_vencedores.length() - 2), nombres_eliminados.substring(0, nombres_eliminados.length() - 2), this.responsable.getNombre());
	}
	
}
