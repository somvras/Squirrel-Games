package pinkGuards;

import Excepciones.SupervisorNoValidoExcepcion;

public class Worker extends PinkGuard {
    private Departamento departamento;
    
    public Worker(int id, String nombre, Departamento departamento, PinkGuard supervisor) throws SupervisorNoValidoExcepcion {
        super(id, nombre);
        this.departamento = departamento;
        this.setSupervisor(supervisor);
    }
    
    @Override
    public Rango getRango() {
        return Rango.WORKER;
    }
    
    public Departamento getDepartamento() {
        return departamento;
    }
    
    public void setDepartamento(Departamento departamento) {
        this.departamento = departamento;
    }
    
    @Override
    public String toString() {
        return super.toString() + ", Departamento: " + departamento;
    }

	@Override
	public String getNombre() {
		return this.getNombre();
	}
}
