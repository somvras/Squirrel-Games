package pinkGuards;

import Excepciones.SupervisorNoValidoExcepcion;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Pruebas unitarias para la clase Manager.
 * Verifica la creación, la gestión del equipo y la validación de supervisión.
 * 
 * @author Mikael
 * @version 1.0
 */
class ManagerTest {

    @Test
    void testManagerCreationAndProperties() {
        Manager manager = new Manager(10, "Manager1", 100);
        assertEquals(10, manager.getId());
        assertEquals("Manager1", manager.getNombre());
        assertEquals(Rango.MANAGER, manager.getRango());
        assertEquals(100, manager.getMunicion());
        assertEquals("Smith & Wesson Model 10", manager.getArma());
        assertTrue(manager.getEquipo().isEmpty());
    }

    @Test
    void testManagerTeamManagement() {
        Manager manager = new Manager(11, "Manager2", 50);
        try {
            // Para probar la gestión del equipo, se crea un Worker como subordinado.
            Worker worker = new Worker(12, "Worker1", Departamento.LIMPIEZA_ELIMINADOS, new Manager(13, "ManagerSub", 80));
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
    void testManagerCannotHaveSupervisor() {
        Manager m1 = new Manager(14, "Manager3", 70);
        Manager m2 = new Manager(15, "Manager4", 90);
        assertThrows(SupervisorNoValidoExcepcion.class, () -> m1.setSupervisor(m2),
                "Un Manager no debe poder tener un supervisor de igual rango.");
    }

    @Test
    void testManagerToString() {
        Manager manager = new Manager(16, "ManagerTest", 75);
        String str = manager.toString();
        assertTrue(str.contains("ManagerTest"));
        assertTrue(str.contains("MANAGER"));
        assertTrue(str.contains("Smith & Wesson Model 10"));
    }
}
