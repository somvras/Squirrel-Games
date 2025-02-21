package pinkGuards;

public abstract class PinkGuards {
	private String id;
	private String nombre;
	
	public PinkGuards(String id, String nombre) {
		this.id=id;
		this.nombre=nombre;
	}

	public String getId() {
		return id;
	}

	public String getNombre() {
		return nombre;
	}
	
}
