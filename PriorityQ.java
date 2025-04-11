/**
 * Ale Sierra #24405
 * Interfaz que define los métodos básicos para una cola de prioridad.
 * 
 * @param <E> comparable.
 */
public interface PriorityQ<E extends Comparable<E>> {

    void add(E item);
    E remove();
    E peek();
    boolean isEmpty();
}

