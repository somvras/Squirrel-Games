package pinkGuards;

import Excepciones.SupervisorNoValidoExcepcion;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Pruebas unitarias para la clase abstracta PinkGuard.
 * Se utiliza una clase DummyPinkGuard para testear la funcionalidad común.
 * 
 * @author Mikael
 * @version 1.0
 */
class PinkGuardTest {

    /**
     * Clase dummy para instanciar PinkGuard con un rango definido.
     */
    private static class DummyPinkGuard extends PinkGuard {
        private final Rango rango;

        /**
         * Crea una instancia de DummyPinkGuard.
         *
         * @param id     Identificador único.
         * @param nombre Nombre del PinkGuard.
         * @param rango  Rango asignado.
         */
        public DummyPinkGuard(int id, String nombre, Rango rango) {
            super(id, nombre);
            this.rango = rango;
        }

        /**
         * Devuelve el rango asignado.
         *
         * @return El rango del PinkGuard.
         */
        @Override
        public Rango getRango() {
            return rango;
        }

        /**
         * Retorna el nombre del PinkGuard.
         *
         * @return El nombre asignado.
         */
        @Override
        public String getNombre() {
            return nombre;
        }
    }

    @Test
    void testGetIdAndNombre() {
        DummyPinkGuard pg = new DummyPinkGuard(1, "Dummy", Rango.WORKER);
        assertEquals(1, pg.getId());
        assertEquals("Dummy", pg.getNombre());
    }

    @Test
    void testSetSupervisorValid() {
        DummyPinkGuard worker = new DummyPinkGuard(2, "Worker", Rango.WORKER);
        DummyPinkGuard soldier = new DummyPinkGuard(3, "Soldier", Rango.SOLDIER);
        try {
            worker.setSupervisor(soldier);
            assertEquals(soldier, worker.getSupervisor(), "El supervisor debe asignarse correctamente.");
        } catch (SupervisorNoValidoExcepcion e) {
            fail("No se esperaba excepción para asignación válida.");
        }
    }

    @Test
    void testSetSupervisorInvalid() {
        DummyPinkGuard worker1 = new DummyPinkGuard(4, "Worker1", Rango.WORKER);
        DummyPinkGuard worker2 = new DummyPinkGuard(5, "Worker2", Rango.WORKER);
        assertThrows(SupervisorNoValidoExcepcion.class, () -> worker1.setSupervisor(worker2),
                "Se esperaba una excepción al asignar un supervisor con el mismo rango.");
    }
}
