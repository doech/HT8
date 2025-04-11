import java.util.PriorityQueue;

/**
 * Ale Sierra #24405
 * Implementación de una cola de prioridad utilizando la clase PriorityQueue de Java.
 * 
 * @param <E> comparable.
 */
public class JCFQueue<E extends Comparable<E>> implements PriorityQ<E> {
    private PriorityQueue<E> queue;

    public JCFQueue() {
        queue = new PriorityQueue<>();
    }

    @Override
    public void add(E item) {
        queue.add(item);
    }

    @Override
    public E remove() {
        return queue.poll();
    }

    @Override
    public E peek() {
        return queue.peek();
    }
    
    @Override
    public boolean isEmpty() {
        return queue.isEmpty();
    }
}