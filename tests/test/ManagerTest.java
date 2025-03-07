package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import Excepciones.SupervisorNoValidoExcepcion;
import pinkGuards.Manager;
import pinkGuards.PinkGuard;
import pinkGuards.Rango;
import pinkGuards.Worker;
import pinkGuards.Departamento;

/**
 * Pruebas unitarias para la clase Manager.
 * 
 * @author Mikael
 * @version 1.0
 */
@Tag("Manager")
@DisplayName("Pruebas de la clase Manager")
class ManagerTest {

    @Test
    @DisplayName("Crear Manager y verificar atributos")
    void testCrearManager() {
        Manager manager = new Manager(1, "Manager", 100);
        assertEquals(1, manager.getId());
        assertEquals("Manager", manager.getNombre());
        assertEquals(Rango.MANAGER, manager.getRango());
        assertEquals(100, manager.getMunicion());
        assertEquals("Smith & Wesson Model 10", manager.getArma());
        String esperado = "ID: 1, Nombre: Manager, Rango: MANAGER, Arma: Smith & Wesson Model 10, Munición: 100, Equipo: []";
        assertEquals(esperado, manager.toString());
    }

    @Test
    @DisplayName("Agregar y eliminar miembros del equipo")
    void testGestionEquipo() {
        Manager manager = new Manager(2, "Manager2", 50);
        try {
            Manager supervisorForWorker = new Manager(3, "Supervisor", 80);
            Worker worker = new Worker(4, "Worker1", Departamento.LIMPIEZA_ELIMINADOS, supervisorForWorker);
            manager.addTeamMember(worker);
            assertEquals(1, manager.getEquipo().size());
            assertTrue(manager.getEquipo().contains(worker));
            manager.removeTeamMember(worker);
            assertEquals(0, manager.getEquipo().size());
        } catch (SupervisorNoValidoExcepcion e) {
            fail("No se esperaba excepción: " + e.getMessage());
        }
    }

    @Test
    @DisplayName("No se puede asignar supervisor a un Manager de igual rango")
    void testManagerSupervisorInvalido() {
        Manager m1 = new Manager(5, "ManagerA", 70);
        Manager m2 = new Manager(6, "ManagerB", 80);
        assertThrows(SupervisorNoValidoExcepcion.class, () -> m1.setSupervisor(m2));
    }
}