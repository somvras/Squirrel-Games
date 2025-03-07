package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import Excepciones.SupervisorNoValidoExcepcion;
import pinkGuards.Departamento;
import pinkGuards.Manager;
import pinkGuards.Rango;
import pinkGuards.Worker;

/**
 * Pruebas unitarias para la clase Worker.
 * 
 * @author Mikael
 * @version 1.0
 */
@Tag("Worker")
@DisplayName("Pruebas de la clase Worker")
class WorkerTest {

    @Test
    @DisplayName("Crear Worker con supervisor válido")
    void testCrearWorker() {
        try {
            Manager manager = new Manager(20, "ManagerForWorker", 100);
            Worker worker = new Worker(21, "Worker", Departamento.PREPARACION_JUEGOS, manager);
            assertEquals(21, worker.getId());
            assertEquals("Worker", worker.getNombre());
            assertEquals(Rango.WORKER, worker.getRango());
            assertEquals(Departamento.PREPARACION_JUEGOS, worker.getDepartamento());
            assertEquals(manager, worker.getSupervisor());
            String esperado = "ID: 21, Nombre: Worker, Rango: WORKER, Supervisor: [ManagerForWorker - MANAGER], Departamento: PREPARACION_JUEGOS";
            assertEquals(esperado, worker.toString());
        } catch (SupervisorNoValidoExcepcion e) {
            fail("No se esperaba excepción: " + e.getMessage());
        }
    }

    @Test
    @DisplayName("Crear Worker con supervisor inválido")
    void testWorkerSupervisorInvalido() {
        try {
            Manager manager = new Manager(22, "ManagerForWorker", 100);
            Worker worker1 = new Worker(23, "Worker1", Departamento.LIMPIEZA_Y_MANTENIMIENTO, manager);
            assertThrows(SupervisorNoValidoExcepcion.class, () ->
                new Worker(24, "Worker2", Departamento.DISTRIBUCION_ALIMENTOS, worker1));
        } catch (SupervisorNoValidoExcepcion e) {
            fail("No se esperaba excepción al crear el primer Worker: " + e.getMessage());
        }
    }
}