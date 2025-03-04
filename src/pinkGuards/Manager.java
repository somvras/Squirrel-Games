package pinkGuards;

import java.util.ArrayList;
import java.util.List;

/**
 * Representa a un Manager de los Pink Guards, encargado de supervisar al personal y de dirigir las pruebas.
 * <p>
 * Un Manager es la entidad de mayor rango, porta siempre una Smith & Wesson Model 10 y tiene un equipo de Pink Guards bajo su supervisión.
 * </p>
 * 
 * @author Mikael
 * @version 1.0
 * @see PinkGuard
 * @see Soldier
 * @see Worker
 */
public class Manager extends PinkGuard {
    /**
     * Arma constante asignada a todos los Managers.
     */
    private static final String ARMA_CONSTANTE = "Smith & Wesson Model 10";
    private int municion;
    private List<PinkGuard> equipo;
    
    /**
     * Crea un nuevo Manager.
     * 
     * @param id El identificador único del Manager.
     * @param nombre El nombre del Manager.
     * @param municion La cantidad inicial de munición.
     */
    public Manager(int id, String nombre, int municion) {
        super(id, nombre);
        this.municion = municion;
        this.equipo = new ArrayList<>();
    }
    
    /**
     * Devuelve el rango del PinkGuard.
     * 
     * @return El rango {@link Rango#MANAGER} de este Manager.
     */
    @Override
    public Rango getRango() {
        return Rango.MANAGER;
    }
    
    /**
     * Obtiene la cantidad de munición del Manager.
     * 
     * @return La cantidad de munición.
     */
    public int getMunicion() {
        return municion;
    }
    
    /**
     * Establece la cantidad de munición del Manager.
     * 
     * @param municion La nueva cantidad de munición.
     */
    public void setMunicion(int municion) {
        this.municion = municion;
    }
    
    /**
     * Obtiene el arma asignada al Manager, que es siempre la Smith & Wesson Model 10.
     * 
     * @return El arma asignada al Manager.
     */
    public String getArma() {
        return ARMA_CONSTANTE;
    }
    
    /**
     * Obtiene el equipo de Pink Guards supervisado por este Manager.
     * 
     * @return Una lista de los Pink Guards en el equipo.
     */
    public List<PinkGuard> getEquipo() {
        return equipo;
    }
    
    /**
     * Agrega un PinkGuard al equipo de supervisión.
     * 
     * @param pg El PinkGuard a agregar.
     */
    public void addTeamMember(PinkGuard pg) {
        equipo.add(pg);
    }
    
    /**
     * Elimina un PinkGuard del equipo de supervisión.
     * 
     * @param pg El PinkGuard a eliminar.
     */
    public void removeTeamMember(PinkGuard pg) {
        equipo.remove(pg);
    }
    
    /**
     * Representa el Manager en forma de cadena.
     * 
     * @return Una cadena que contiene la información del Manager, incluyendo su arma, munición y equipo.
     */
    @Override
    public String toString() {
        return super.toString() + ", Arma: " + ARMA_CONSTANTE + ", Munición: " + municion + ", Equipo: " + equipo;
    }

    /**
     * Devuelve el nombre del Manager.
     * 
     * @return El nombre del Manager.
     */
    @Override
    public String getNombre() {
        return this.nombre;
    }
}
