package pruebas;

import java.util.ArrayList;

public class Prueba {

	private String nombre;
	private String desc;
	private ArrayList<Object> participantes; //Participante
	private ArrayList<Object> eliminados; //Participante
	private ArrayList<Object> vencedores; //Participante
	private Object responsable; //Pink Guard
	
	public Prueba(String nombre, String desc, ArrayList<Object> participantes, Object responsable) { //Participante, Pink Guard
		this.nombre = nombre;
		this.desc = desc;
		this.participantes = participantes;
		this.eliminados = new ArrayList<Object>(); //Participante
		this.vencedores = new ArrayList<Object>(); //Participante
		this.responsable = responsable;
	}
	
	//GetSet
	
	//Metodos
	public void simulacion() {
		
	}
	
	public float porcentajeExito() {
		return 0;
	}
	
	@Override
	public String toString() {
		return "";
	}
	
}
