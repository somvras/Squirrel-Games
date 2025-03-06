package juegos;

import java.util.ArrayList;

import Excepciones.IdRepetidoException;
import Excepciones.ResponsableNoEsManagerException;
import concursantes.Concursante;
import pinkGuards.PinkGuard;
import pruebas.Prueba;

public class Edicion {
	
	
	private int anio;
	private String ubicacion;
	private ArrayList<Concursante> participantesEdicion;
	private ArrayList<PinkGuard> empleados;
	private ArrayList<Prueba> pruebas;
	
	
	//Constructores//
	public Edicion(int anio, String ubicacion, ArrayList<Concursante> participantesEdicion) {
		this.anio = anio;
		this.ubicacion = ubicacion;
		this.participantesEdicion = participantesEdicion;
		this.empleados = new ArrayList<PinkGuard>();
		this.pruebas = new ArrayList<Prueba>();
	}
	
	public Edicion(int anio, String ubicacion) {
		this.anio = anio;
		this.ubicacion = ubicacion;
		this.participantesEdicion = new ArrayList<Concursante>();
		this.empleados = new ArrayList<PinkGuard>();
		this.pruebas = new ArrayList<Prueba>();
	}
	///////////
	

	//Getters//
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
	public void nuevoParticipante(Concursante participante) throws IdRepetidoException {
		for(int i=0; i<this.participantesEdicion.size(); i++) {
			if(this.participantesEdicion.get(i).getId()==participante.getId()) {
				throw new IdRepetidoException("Id ya presente en la lista de participantes");
			}
		}
		this.participantesEdicion.add(participante);
	}
	
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
	public void nuevoEmpleado(PinkGuard empleado) throws IdRepetidoException {
		for(int i=0; i<this.empleados.size(); i++) {
			if(this.empleados.get(i).getId()==empleado.getId()) {
				throw new IdRepetidoException("Id ya presente en la lista de participantes");
			}
		}
		this.empleados.add(empleado);
	}
	
	//Pruebas
	public void nuevaPrueba(Prueba nuevaPrueba) {
		this.pruebas.add(nuevaPrueba);
	}
	
	public void nuevaPrueba(String nombre, String desc, ArrayList<Concursante> participantes, PinkGuard responsable) throws ResponsableNoEsManagerException {
		Prueba nuevaPrueba = new Prueba(nombre, desc, participantes, responsable);
		this.pruebas.add(nuevaPrueba);
	}

}
