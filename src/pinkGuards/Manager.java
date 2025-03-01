package pinkGuards;

import java.util.ArrayList;
import java.util.List;

public class Manager extends PinkGuard {
    // El arma es siempre la Smith & Wesson Model 10
    private static final String ARMA_CONSTANTE = "Smith & Wesson Model 10";
    private int municion;
    private List<PinkGuard> equipo;
    
    public Manager(int id, String nombre, int municion) {
        super(id, nombre);
        this.municion = municion;
        this.equipo = new ArrayList<>();
    }
    
    @Override
    public Rango getRango() {
        return Rango.MANAGER;
    }
    
    public int getMunicion() {
        return municion;
    }
    
    public void setMunicion(int municion) {
        this.municion = municion;
    }
    
    public String getArma() {
        return ARMA_CONSTANTE;
    }
    
    public List<PinkGuard> getEquipo() {
        return equipo;
    }
    
    /**
     * Agrega un PinkGuard al equipo de supervisión.
     */
    public void addTeamMember(PinkGuard pg) {
        equipo.add(pg);
    }
    
    public void removeTeamMember(PinkGuard pg) {
        equipo.remove(pg);
    }
    
    @Override
    public String toString() {
        return super.toString() + ", Arma: " + ARMA_CONSTANTE + ", Munición: " + municion + ", Equipo: " + equipo;
    }
}