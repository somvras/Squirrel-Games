package pinkGuards;

public enum WeaponType {
    GLOCK_17("Pistola Glock 17"),
    HECKLER_MP5("Rifle de asalto Heckler & Koch MP5"),
    HECKLER_G3("Rifle automático Heckler & Koch G3");

    private String descripcion;

    WeaponType(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getDescripcion() {
        return descripcion;
    }
}
