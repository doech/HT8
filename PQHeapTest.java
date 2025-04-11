import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class PQHeapTest {

    private PQueueHeap<Pacientes> heap;

    @Before
    public void setUp() {
        heap = new PQueueHeap<>();
    }

    @Test
    public void testAddAndPeek() {
        Pacientes paciente1 = new Pacientes("Maria", "Gripe", "B");
        Pacientes paciente2 = new Pacientes("Carlos", "Fractura", "A");
        Pacientes paciente3 = new Pacientes("Ana", "Migraña", "C");
        heap.add(paciente1);
        heap.add(paciente2);
        heap.add(paciente3);
        assertEquals("Carlos", heap.peek().getNombre());
    }

    @Test
    public void testRemove() {
        Pacientes paciente1 = new Pacientes("Maria", "Gripe", "B");
        Pacientes paciente2 = new Pacientes("Carlos", "Fractura", "A");
        Pacientes paciente3 = new Pacientes("Ana", "Migraña", "C");

        heap.add(paciente1);
        heap.add(paciente2);
        heap.add(paciente3);
        assertEquals("Carlos", heap.remove().getNombre());
        assertEquals("Maria", heap.remove().getNombre());
        assertEquals("Ana", heap.remove().getNombre());
        assertTrue(heap.isEmpty());
    }

    @Test
    public void testIsEmpty() {
        assertTrue(heap.isEmpty());

        Pacientes paciente = new Pacientes("Maria", "Gripe", "B");
        heap.add(paciente);
        assertFalse(heap.isEmpty());
        heap.remove();
        assertTrue(heap.isEmpty());
    }
}