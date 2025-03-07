package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import Excepciones.SupervisorNoValidoExcepcion;
import pinkGuards.Arma;
import pinkGuards.Manager;
import pinkGuards.Rango;
import pinkGuards.Soldier;
import pinkGuards.Worker;
import pinkGuards.Departamento;

/**
 * Pruebas unitarias para la clase Soldier.
 * 
 * @author Mikael
 * @version 1.0
 */
@Tag("Soldier")
@DisplayName("Pruebas de la clase Soldier")
class SoldierTest {

    @Test
    @DisplayName("Crear Soldier con supervisor válido")
    void testCrearSoldier() {
        try {
            Manager manager = new Manager(10, "ManagerForSoldier", 100);
            Soldier soldier = new Soldier(11, "Soldier", Arma.MP5, 30, manager);
            assertEquals(11, soldier.getId());
            assertEquals("Soldier", soldier.getNombre());
            assertEquals(Rango.SOLDIER, soldier.getRango());
            assertEquals(Arma.MP5, soldier.getArma());
            assertEquals(30, soldier.getMunicion());
            assertEquals(manager, soldier.getSupervisor());
            String esperado = "ID: 11, Nombre: Soldier, Rango: SOLDIER, Supervisor: [ManagerForSoldier - MANAGER], Arma: Rifle de asalto Heckler & Koch MP5, Munición: 30";
            assertEquals(esperado, soldier.toString());
        } catch (SupervisorNoValidoExcepcion e) {
            fail("No se esperaba excepción: " + e.getMessage());
        }
    }

    @Test
    @DisplayName("Crear Soldier con supervisor inválido")
    void testSoldierSupervisorInvalido() {
        try {
            Manager supervisorForWorker = new Manager(12, "Manager", 100);
            Worker worker = new Worker(13, "Worker", Departamento.DISTRIBUCION_ALIMENTOS, supervisorForWorker);
            assertThrows(SupervisorNoValidoExcepcion.class, () ->
                new Soldier(14, "SoldierInvalid", Arma.G3, 20, worker));
        } catch (SupervisorNoValidoExcepcion e) {
            fail("No se esperaba excepción al crear Worker: " + e.getMessage());
        }
    }
}