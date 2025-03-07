package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import Excepciones.SupervisorNoValidoExcepcion;
import pinkGuards.PinkGuard;
import pinkGuards.Rango;

/**
 * Pruebas unitarias para la clase abstracta PinkGuard utilizando una clase Dummy.
 * 
 * @author Mikael
 * @version 1.0
 */
@Tag("PinkGuard")
@DisplayName("Pruebas de la clase PinkGuard")
class PinkGuardTest {

    /**
     * Clase Dummy para instanciar PinkGuard.
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
         * @return El rango.
         */
        @Override
        public Rango getRango() {
            return rango;
        }

        /**
         * Retorna el nombre asignado.
         * 
         * @return El nombre.
         */
        @Override
        public String getNombre() {
            return nombre;
        }
    }

    @Test
    @DisplayName("Verificar getId y getNombre en DummyPinkGuard")
    void testGetIdAndNombre() {
        DummyPinkGuard dummy = new DummyPinkGuard(1, "Dummy", Rango.WORKER);
        assertEquals(1, dummy.getId());
        assertEquals("Dummy", dummy.getNombre());
    }

    @Test
    @DisplayName("Asignar supervisor válido")
    void testSetSupervisorValido() {
        DummyPinkGuard worker = new DummyPinkGuard(2, "Worker", Rango.WORKER);
        DummyPinkGuard soldier = new DummyPinkGuard(3, "Soldier", Rango.SOLDIER);
        try {
            worker.setSupervisor(soldier);
            assertEquals(soldier, worker.getSupervisor());
        } catch (SupervisorNoValidoExcepcion e) {
            fail("No se esperaba excepción para asignación válida.");
        }
    }

    @Test
    @DisplayName("Asignar supervisor inválido")
    void testSetSupervisorInvalido() {
        DummyPinkGuard worker1 = new DummyPinkGuard(4, "Worker1", Rango.WORKER);
        DummyPinkGuard worker2 = new DummyPinkGuard(5, "Worker2", Rango.WORKER);
        assertThrows(SupervisorNoValidoExcepcion.class, () -> worker1.setSupervisor(worker2));
    }
}
