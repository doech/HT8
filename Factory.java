/**
 * Ale Sierra #24405
 * Clase Factory para crear diferentes implementaciones de colas de prioridad.
 * 
 * @param <E> Tipo de elementos que implementan Comparable.
 */
public class Factory<E extends Comparable<E>> {

    /**
     * Devuelve una implementación de cola de prioridad según el tipo especificado.
     * 
     * @param tipo Tipo de cola ("heap" o "jcf").
     * @return objeto acorde al tipo o null si el tipo no es válido.
     */
    public PriorityQ<E> getPriorityQueue(String tipo) {
        if (tipo.equalsIgnoreCase("heap")) {
            return new PQueueHeap<>();
        } else if (tipo.equalsIgnoreCase("jcf")) {
            return new JCFQueue<>();
        } else {
            System.out.println("No válido: " + tipo);
            return null; 
        }
    }
}

