package juegos;

import java.util.ArrayList;

import Excepciones.IdRepetidoException;
import Excepciones.ResponsableNoEsManagerException;
import concursantes.Concursante;
import pinkGuards.PinkGuard;
import pruebas.Prueba;

/**
 * La clase Edición unifica todos las otras clases para simular una edición de los juegos del calamar.
 * Permite crear ediciones ya sean con listas preconcebidas o sin estas, además de añadir objetos correspondientes
 * a cada unan con un filtro de IDs.
 * @author Carolina
 * @version 1.0
 * @see Concursante
 * @see PinkGuard
 * @see Prueba
 */
public class Edicion {
	
	
	private int anio;
	private String ubicacion;
	private ArrayList<Concursante> participantesEdicion;
	private ArrayList<PinkGuard> empleados;
	private ArrayList<Prueba> pruebas;
	
	
	//Constructores//
	/**
	 * Constructor que permite importar tus listas anteriormente creadas a los juegos
	 * @param anio Identificador temporal de cada edición
	 * @param ubicacion Lugar donde sucede
	 * @param participantesEdicion Participantes de la edición
	 * @param empleados Empleados asignados a la edición
	 * @param pruebas Lista de las pruebas que tomarán lugar en esta edición
	 */
	public Edicion(int anio, String ubicacion, ArrayList<Concursante> participantesEdicion,
			ArrayList<PinkGuard> empleados, ArrayList<Prueba> pruebas) {
		this.anio = anio;
		this.ubicacion = ubicacion;
		this.participantesEdicion = participantesEdicion;
		this.empleados = empleados;
		this.pruebas = pruebas;
	}
	
	/**
	 * Constructor que inicializa las listas de participantes, empleados y pruebas a 0 para luego añadirlos
	 * @param anio Identificador temporal de cada edición
	 * @param ubicacion Lugar donde sucede
	 */
	public Edicion(int anio, String ubicacion) {
		this.anio = anio;
		this.ubicacion = ubicacion;
		this.participantesEdicion = new ArrayList<Concursante>();
		this.empleados = new ArrayList<PinkGuard>();
		this.pruebas = new ArrayList<Prueba>();
	}
	///////////
	

	//Getters//
	/**
	 * 
	 */
	public int getAnio() {
		return anio;
	}

	public String getUbicacion() {
		return ubicacion;
	}

	public ArrayList<Concursante> getParticipantesEdicion() {
		return participantesEdicion;
	}

	public ArrayList<PinkGuard> getEmpleados() {
		return empleados;
	}

	public ArrayList<Prueba> getPruebas() {
		return pruebas;
	}
	///////////
	
	
	//Metodos//
	
	//Concursantes
	/**
	 * Método que añade un participante ya existente
	 * @param participante Participante a añadir
	 * @throws IdRepetidoException Cuando se intenta añadir a un participante con el mismo id a otro en la lista
	 */
	public void nuevoParticipante(Concursante participante) throws IdRepetidoException {
		for(int i=0; i<this.participantesEdicion.size(); i++) {
			if(this.participantesEdicion.get(i).getId()==participante.getId()) {
				throw new IdRepetidoException("Id ya presente en la lista de participantes");
			}
		}
		this.participantesEdicion.add(participante);
	}
	/**
	 * Método que añade un nuevo participante
	 * @param id El identificador único del participante
	 * @param nombre El nombre del participante
	 * @param apellidos Los apellidos del participante
	 * @param nacionalidad La nacionalidad del participante
	 * @param fecha_nacim La fecha de nacimiento del participante
	 * @param sexo El sexo del participante
	 * @param deuda La deuda acumulada previa del participante
	 * @throws IdRepetidoException Cuando se intenta añadir a un participante con el mismo id a otro en la lista
	 */
	public void nuevoParticipante(int id, String nombre, String apellidos, String nacionalidad, String fecha_nacim, boolean sexo, double deuda) throws IdRepetidoException {
		for(int i=0; i<this.participantesEdicion.size(); i++) {
			if(this.participantesEdicion.get(i).getId()==id) {
				throw new IdRepetidoException("Id ya presente en la lista de participantes");
			}
		}
		Concursante participante=new Concursante(id, nombre, apellidos, nacionalidad, fecha_nacim, sexo, deuda);
		this.participantesEdicion.add(participante);
	}
	
	//Empleados
	/**
	 * Método que añade un empleado existente
	 * @param empleado Empleado a añadir
	 * @throws IdRepetidoException Cuando se intenta añadir a un empleado con el mismo id a otro en la lista
	 */
	public void nuevoEmpleado(PinkGuard empleado) throws IdRepetidoException {
		for(int i=0; i<this.empleados.size(); i++) {
			if(this.empleados.get(i).getId()==empleado.getId()) {
				throw new IdRepetidoException("Id ya presente en la lista de participantes");
			}
		}
		this.empleados.add(empleado);
	}
	
	//Pruebas
	/**
	 * Método que añade una prueba existente
	 * @param nuevaPrueba Prueba a añadir
	 */
	public void nuevaPrueba(Prueba nuevaPrueba) {
		this.pruebas.add(nuevaPrueba);
	}
	
	/**
	 * Método que añade una nueva prueba
	 * @param nombre Nombre de la prueba
	 * @param desc Descripción de la prueba
	 * @param participantes Lista de concursantes que participan en la prueba
	 * @param responsable Manager al mando de la prueba
	 * @throws ResponsableNoEsManagerException Si el pink guard asignado no es del rango manager
	 */
	public void nuevaPrueba(String nombre, String desc, ArrayList<Concursante> participantes, PinkGuard responsable) throws ResponsableNoEsManagerException {
		Prueba nuevaPrueba = new Prueba(nombre, desc, participantes, responsable);
		this.pruebas.add(nuevaPrueba);
	}

}
