package pinkGuards;

public enum Arma {
	GLOCK17("Pistola Glock 17"),
    MP5("Rifle de asalto Heckler & Koch MP5"),
    G3("Rifle automático Heckler & Koch G3");
    
    private final String descripcion;
    
    Arma(String descripcion) {
        this.descripcion = descripcion;
    }
    
    @Override
    public String toString() {
        return descripcion;
    }
}
