package concursantes;

import java.time.LocalDate;

import Excepciones.AtributoNoExisteExcepcion;

/**
 * La clase Concursante contiene el constructor de los participantes del concurso y métodos algunas funciones que éstos podrán realizar
 * @author Alberto
 * @version 1.0
 * @see Edicion
 */
public class Concursante {
	 private int id;
	 private String nombre, apellidos, nacionalidad, nombreReal, apellidosReales;
	 private LocalDate fechaNacim;
	 private double deudaAcumulada;
	 private boolean sexo, esInfiltrado;
	 //private float coefAptitud, coefVoluntad;
	 
	 
	 /**
	  * Constructor que crea instancias de los participantes normales.
	  * @param id El identificador único del participante.
	  * @param nombre El nombre del participante
	  * @param apellidos Los apellidos del participante
	  * @param nacionalidad La nacionalidad del participante
	  * @param fecha_nacim La fecha de nacimiento del participante
	  * @param sexo El sexo del participante
	  * @param deuda La deuda acumulada previa del participante.
	  * @param esInfiltrado Indica si el participante es un topo de la organización
	  * @throws SexoNoValidoExcepcion Si el sexo introducido es diferente de "V" o "M"
	  */
	 public Concursante(int id, String nombre, String apellidos, String nacionalidad, String fecha_nacim, boolean sexo, double deuda){
		 this.id = id;
		 this.nombre = nombre;
		 this.apellidos = apellidos;
		 this.nacionalidad = nacionalidad;
		 this.fechaNacim = LocalDate.of(Integer.parseInt(fecha_nacim.substring(6)), Integer.parseInt(fecha_nacim.substring(3, 5)), Integer.parseInt(fecha_nacim.substring(0, 2)));
		 this.nacionalidad = nacionalidad;
		 this.sexo = sexo;
		this.deudaAcumulada = deuda;
		this.esInfiltrado = false; 
		 //this.coefAptitud = coefAptitud;
		//this.coefVoluntad = coefVoluntad;
	 }

	 /**
	  * Constructor que crea instancias de los participantes infiltrados de la organización. El nombre y los apellidos son falsos, 
	  * debe añadirse al final el nombre y los apellidos reales del participante.
	  * @param id El identificador único del participante.
	  * @param nombre El nombre falso del participante
	  * @param apellidos Los apellidos del participante
	  * @param nacionalidad La nacionalidad del participante
	  * @param fecha_nacim La fecha de nacimiento del participante
	  * @param sexo El sexo del participante
	  * @param deuda La deuda acumulada previa del participante.
	  * @param nombreReal. El nombre auténtico del participante
	  * @param apellidosReales. Los apellidos auténticos del participante.
	  * @throws SexoNoValidoExcepcion Si el sexo introducido es diferente de "V" o "M"
	  */
	 public Concursante(int id, String nombreFalso, String apellidosFalsos, String nacionalidad, String fecha_nacim, boolean sexo, double deuda, String nombreReal, String apellidosReales){
		 this.id = id;
		 this.nombre = nombreFalso;
		 this.apellidos = apellidosFalsos;
		 this.nacionalidad = nacionalidad;
		 this.fechaNacim = LocalDate.of(Integer.parseInt(fecha_nacim.substring(6)), Integer.parseInt(fecha_nacim.substring(3, 5)), Integer.parseInt(fecha_nacim.substring(0, 2)));
		 this.nacionalidad = nacionalidad;
		 this.sexo = sexo;
		this.deudaAcumulada = deuda;
		this.esInfiltrado = true;
		this.nombreReal = nombreReal;
		this.apellidosReales = apellidosReales;
		 //this.coefAptitud = coefAptitud;
		//this.coefVoluntad = coefVoluntad;
	 }

	public double getDeudaAcumulada() {
		return this.deudaAcumulada;
	}


	public void setDeudaAcumulada(double deudaAcumulada) {
		this.deudaAcumulada = deudaAcumulada;
	}


	public int getId() {
		return this.id;
	}


	public String getNombre() {
		return this.nombre;
	}


	public String getApellidos() {
		return this.apellidos;
	}


	public String getNacionalidad() {
		return this.nacionalidad;
	}


	public LocalDate getFechaNacim() {
		return this.fechaNacim;
	}


	public boolean getSexo() {
		return this.sexo;
	}

	public String getNombreReal() throws AtributoNoExisteExcepcion {
		if (this.nombreReal.equals("")) {
			throw new AtributoNoExisteExcepcion("El atributo que intentas conseguir no existe");
		}
		return this.nombreReal;
	}

	public String getApellidosReales() throws AtributoNoExisteExcepcion {
		if (this.apellidosReales.equals("")) {
			throw new AtributoNoExisteExcepcion("El atributo que intentas conseguir no existe");
		}
		return apellidosReales;
	}

	public boolean isEsInfiltrado() {
		return esInfiltrado;
	}
	
	@Override
	public String toString(){
		char sexoChar;
		if (sexo) {
			sexoChar = 'V';
		} else {
			sexoChar = 'M';
		}
		
		String fechaNacimientoS = this.fechaNacim.toString().substring(8) + "/" + this.fechaNacim.toString().substring(5,7) + "/" + this.fechaNacim.toString().substring(0,4);
		
		String info = """
				Participante nº: %d
				Nombre: %s
				Apellidos: %s
				Fecha de nacimiento: %s
				Nacionalidad: %s
				Sexo: %c
				Deuda acumulada: %.2f
				""";;
		if (!this.esInfiltrado) {
			return String.format(info, this.id, this.nombre, this.apellidos, fechaNacimientoS, this.nacionalidad, sexoChar, this.deudaAcumulada);
		} else {
			info += """
					INFILTRADO
					Nombre Real: %s
					Apellidos Reales: %s
					""";
			return String.format(info, this.id, this.nombre, this.apellidos, fechaNacimientoS, this.nacionalidad, sexoChar, this.deudaAcumulada, this.nombreReal, this.apellidosReales);
		}
		 
		
			
		
		
	}
	 
}
