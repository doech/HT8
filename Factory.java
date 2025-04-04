import java.util.PriorityQueue;

public class Factory<E extends Comparable<E>> {

    public PriorityQueue<E> getPriorityQueue(String tipo) {
        if (tipo.equalsIgnoreCase("heap")) {
            return new PriorityQueue<>();
        } else if (tipo.equalsIgnoreCase("jcf")) {
            return new PriorityQueue<>();
        } else {
            System.out.println ("Tipo no válido: " + tipo);
        }
    }
}

