package juegos;

import java.util.ArrayList;

import pruebas.Prueba;

public class Edicion {
	
	private int anio;
	private String ubicacion;
	private ArrayList<Object> participantesEdicion; //Participante
	private ArrayList<Object> empleados; //Pink Guard
	private ArrayList<Prueba> pruebas;
	
	public Edicion(int anio, String ubicacion, ArrayList<Object> participantesEdicion) { //Participante
		this.anio = anio;
		this.ubicacion = ubicacion;
		this.participantesEdicion = participantesEdicion;
		this.empleados = new ArrayList<Object>(); //Pink Guard
		this.pruebas = new ArrayList<Prueba>();
	}
	
	public Edicion(int anio, String ubicacion) {
		this.anio = anio;
		this.ubicacion = ubicacion;
		this.participantesEdicion = new ArrayList<Object>(); //Participante
		this.empleados = new ArrayList<Object>(); //Pink Guard
		this.pruebas = new ArrayList<Prueba>();
	}
	
	//GetSet

}
