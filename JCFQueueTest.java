import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class JCFQueueTest {

    private JCFQueue<Pacientes> queue;

    @Before
    public void setUp() {
        queue = new JCFQueue<>();
    }

    @Test
    public void testAddAndPeek() {
        Pacientes paciente1 = new Pacientes("Maria", "Gripe", "B");
        Pacientes paciente2 = new Pacientes("Carlos", "Fractura", "A");
        Pacientes paciente3 = new Pacientes("Ana", "Migraña", "C");
        queue.add(paciente1);
        queue.add(paciente2);
        queue.add(paciente3);
        assertEquals("Carlos", queue.peek().getNombre());
    }

    @Test
    public void testRemove() {
        Pacientes paciente1 = new Pacientes("Maria", "Gripe", "B");
        Pacientes paciente2 = new Pacientes("Carlos", "Fractura", "A");
        Pacientes paciente3 = new Pacientes("Ana", "Migraña", "C");
        queue.add(paciente1);
        queue.add(paciente2);
        queue.add(paciente3);
        assertEquals("Carlos", queue.remove().getNombre());
        assertEquals("Maria", queue.remove().getNombre());
        assertEquals("Ana", queue.remove().getNombre());
        assertTrue(queue.isEmpty());
    }

    @Test
    public void testIsEmpty() {
        assertTrue(queue.isEmpty());
        Pacientes paciente = new Pacientes("Maria", "Gripe", "B");
        queue.add(paciente);
        assertFalse(queue.isEmpty());
        queue.remove();
        assertTrue(queue.isEmpty());
    }
}