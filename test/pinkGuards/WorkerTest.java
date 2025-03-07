package pinkGuards;

import Excepciones.SupervisorNoValidoExcepcion;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Pruebas unitarias para la clase Worker.
 * Verifica la creación, la validación de supervisor y la representación en cadena.
 * 
 * @author Mikael
 * @version 1.0
 */
class WorkerTest {

    @Test
    void testWorkerCreationValid() {
        try {
            // Para un Worker, un supervisor válido puede ser un Manager.
            Manager manager = new Manager(30, "ManagerForWorker", 80);
            Worker worker = new Worker(31, "Worker1", Departamento.PREPARACION_JUEGOS, manager);
            assertEquals(31, worker.getId());
            assertEquals("Worker1", worker.getNombre());
            assertEquals(Rango.WORKER, worker.getRango());
            assertEquals(Departamento.PREPARACION_JUEGOS, worker.getDepartamento());
            assertEquals(manager, worker.getSupervisor());
        } catch (SupervisorNoValidoExcepcion e) {
            fail("Excepción inesperada: " + e.getMessage());
        }
    }

    @Test
    void testWorkerInvalidSupervisor() {
        try {
            // Para un Worker, asignar otro Worker (rango WORKER) como supervisor debe fallar.
            Worker worker1 = new Worker(32, "WorkerInvalid1", Departamento.LIMPIEZA_Y_MANTENIMIENTO, new Manager(33, "ManagerForWorker", 100));
            // Se espera que al asignar worker1 (rango WORKER) como supervisor a otro Worker se lance la excepción.
            assertThrows(SupervisorNoValidoExcepcion.class, () -> 
                new Worker(34, "WorkerInvalid2", Departamento.DISTRIBUCION_ALIMENTOS, worker1),
                "Se esperaba SupervisorNoValidoExcepcion al asignar un supervisor de igual rango.");
        } catch (SupervisorNoValidoExcepcion e) {
            // La excepción se espera; comprobamos que el mensaje es correcto.
            assertTrue(e.getMessage().contains("no tiene un rango superior"));
        }
    }

    @Test
    void testWorkerToString() {
        try {
            Manager manager = new Manager(35, "ManagerForWorkerToString", 90);
            Worker worker = new Worker(36, "Worker2", Departamento.LIMPIEZA_ELIMINADOS, manager);
            String str = worker.toString();
            assertTrue(str.contains("Worker2"));
            assertTrue(str.contains("LIMPIEZA_ELIMINADOS"));
        } catch (SupervisorNoValidoExcepcion e) {
            fail("Excepción inesperada: " + e.getMessage());
        }
    }
}
