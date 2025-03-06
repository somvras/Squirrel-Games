package pinkGuards;

import Excepciones.SupervisorNoValidoExcepcion;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Pruebas unitarias para la clase Soldier.
 * Verifica la creación, la asignación de supervisor y la representación en cadena.
 * 
 * @author Mikael
 * @version 1.0
 */
class SoldierTest {

    @Test
    void testSoldierCreationValid() {
        try {
            Manager manager = new Manager(20, "ManagerForSoldier", 100);
            Soldier soldier = new Soldier(21, "Soldier1", Arma.MP5, 30, manager);
            assertEquals(21, soldier.getId());
            assertEquals("Soldier1", soldier.getNombre());
            assertEquals(Rango.SOLDIER, soldier.getRango());
            assertEquals(Arma.MP5, soldier.getArma());
            assertEquals(30, soldier.getMunicion());
            assertEquals(manager, soldier.getSupervisor());
        } catch (SupervisorNoValidoExcepcion e) {
            fail("No se esperaba excepción: " + e.getMessage());
        }
    }

    @Test
    void testSoldierInvalidSupervisor() {
        try {
            // Para Soldier, un supervisor válido debe ser un Manager (rango MANAGER).
            Worker worker = new Worker(22, "WorkerForSoldier", Departamento.DISTRIBUCION_ALIMENTOS, new Manager(23, "ManagerForWorker", 100));
            assertThrows(SupervisorNoValidoExcepcion.class, () -> 
                new Soldier(24, "SoldierInvalid", Arma.G3, 20, worker),
                "Se esperaba excepción al asignar un supervisor inválido para Soldier.");
        } catch (SupervisorNoValidoExcepcion e) {
            fail("Excepción inesperada al crear el Worker: " + e.getMessage());
        }
    }

    @Test
    void testSoldierToString() {
        try {
            Manager manager = new Manager(25, "ManagerForSoldierString", 120);
            Soldier soldier = new Soldier(26, "Soldier2", Arma.GLOCK17, 40, manager);
            String str = soldier.toString();
            assertTrue(str.contains("Soldier2"));
            assertTrue(str.contains("Glock")); // Comprueba que incluye la descripción del arma GLOCK17
            assertTrue(str.contains("40"));
        } catch (SupervisorNoValidoExcepcion e) {
            fail("Excepción inesperada: " + e.getMessage());
        }
    }
}
