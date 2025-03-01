package pinkGuards;

import Excepciones.SupervisorNoValidoExcepcion;

public class Soldier extends PinkGuard {
    private Arma arma;
    private int municion;
    
    public Soldier(int id, String nombre, Arma arma, int municion, PinkGuard supervisor) throws SupervisorNoValidoExcepcion {
        super(id, nombre);
        this.arma = arma;
        this.municion = municion;
        this.setSupervisor(supervisor);
    }
    
    @Override
    public Rango getRango() {
        return Rango.SOLDIER;
    }
    
    public Arma getArma() {
        return arma;
    }
    
    public void setArma(Arma arma) {
        this.arma = arma;
    }
    
    public int getMunicion() {
        return municion;
    }
    
    public void setMunicion(int municion) {
        this.municion = municion;
    }
    
    @Override
    public String toString() {
        return super.toString() + ", Arma: " + arma + ", Munición: " + municion;
    }
}
