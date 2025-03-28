package pruebas;

import java.util.ArrayList;

import Excepciones.DificultadNoValidaExcepcion;
import Excepciones.IntentoDeEliminarInfiltradoException;
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
 */

public class Prueba {

	
	private String nombre;
	private String desc;
	private ArrayList<Concursante> participantes;
	private ArrayList<Concursante> eliminados;
	private ArrayList<Concursante> vencedores;
	private PinkGuard responsable;
	
	
	//Constructor//
	/**
	 * Constructor básico de las pruebas
	 * @param nombre Nombre de la prueba
	 * @param desc Descripción de la prueba
	 * @param participantes Lista de concursantes que participan en la prueba
	 * @param responsable Manager al mando de la prueba
	 * @throws ResponsableNoEsManagerException Si el pink guard asignado no es del rango manager
	 */
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
	/**
	 * 
	 */
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
	
	/**
	 * Método que simula una prueba. Mantiene la lista de participantes intacta, para futuras consultas. Crea nuevas listas de vencedores y eliminados en
	 * base a la dificultad introducida.
	 * @param dificultad El porcentaje de supervivencia para los participantes.
	 * @throws DificultadNoValidaExcepcion Si la dificultad no está entre 0 y 100.
	 * @throws IntentoDeEliminarInfiltradoException Si en la prueba se elimina a un infiltrado
	 */
	public void simulacion(float dificultad) throws DificultadNoValidaExcepcion, IntentoDeEliminarInfiltradoException {
		if (dificultad < 0 || dificultad > 100) {
			throw new DificultadNoValidaExcepcion("La dificultad introducida está fuera de los parámetros aceptables (entre 0 y 100)");
		}
		
		int cantidadEliminados = (int) Math.round(this.participantes.size() * dificultad / 100);
		
		Concursante concursanteEliminado;
		for (int i = 1; i <= cantidadEliminados; i++) {
			concursanteEliminado = this.participantes.get((int) Math.floor(Math.random() * this.participantes.size()));
			if (!concursanteEliminado.esInfiltrado()) {
				eliminados.add(concursanteEliminado);
			} else {
				throw new IntentoDeEliminarInfiltradoException("No es posible eliminar a uno de los jugadores. Póngase en contacto de inmediato con su supervisor");
			}
			
		}
		
		for (Concursante concursante : participantes) {
			if (!eliminados.contains(concursante)) {
				vencedores.add(concursante);
			}
		}
		
		System.out.println(this.toString());
	}
	

	/**
	 * Método que calcula el porcentaje de éxito en una prueba
	 * @param dificultad Nivel de dificultad de la prueba
	 * @return El porcentaje de éxito calculado en base a la dificultad
	 * @throws DificultadNoValidaExcepcion Si el nivel de dificultad se sale de los límites establecidos

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
		
		return "Prueba: "+this.nombre+"\nDescripción: "+this.desc+"\nParticipantes: "+nombres_participantes+
				"\nVencedores: "+nombres_vencedores+"\nEliminados: "+nombres_eliminados+"\nManager: "+this.responsable.getNombre();
	}
	
}
