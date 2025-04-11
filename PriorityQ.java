/**
 * Ale Sierra #24405
 * Interfaz que define los métodos básicos para una cola de prioridad.
 * 
 * @param <E> comparable.
 */
public interface PriorityQ<E extends Comparable<E>> {

    /**
     * Agrega un elemento a la cola de prioridad.
     * 
     * @param item Elemento a agregar.
     */
    void add(E item);

    /**
     * elimina y devuelve el elemento con mayor prioridad de la cola.
     * 
     * @return elemento de mayor prioridad 
     */
    E remove();

    /**
     * Devuelve el elemento con mayor prioridad sin eliminarlo de la cola.
     * 
     * @return elemento de mayor prioridad
     */
    E peek();

    /**
     * Verifica si la cola de prioridad está vacía.
     * 
     * @return true/false.
     */
    boolean isEmpty();
}

