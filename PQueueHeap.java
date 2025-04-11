import java.util.ArrayList;
import java.util.List;

/**
 * Ale Sierra #24405
 * Clase que representa una cola de prioridad utilizando un heap.
 * 
 * @param <E> comparable.
 */
public class PQueueHeap<E extends Comparable<E>> implements PriorityQ<E> {
    private List<E> elementos;

    public PQueueHeap() {
        elementos = new ArrayList<>();
    }

    @Override
    public void add(E valor) {
        elementos.add(valor);
        subir(elementos.size() - 1);
    }

    @Override
    public E remove() {
        if (isEmpty()) return null;

        E primero = elementos.get(0);
        E ultimo = elementos.remove(elementos.size() - 1);

        if (!elementos.isEmpty()) {
            elementos.set(0, ultimo);
            bajar(0);
        }

        return primero;
    }

    @Override
    public E peek() {
        return isEmpty() ? null : elementos.get(0);
    }

    @Override
    public boolean isEmpty() {
        return elementos.isEmpty();
    }

    /**
     * Sube un elemento en el heap para mantener el orden.
     * @param indice es el índice del elemento a subir.
     */

    private void subir(int indice) {
        while (indice > 0) {
            int padre = (indice - 1) / 2;
            if (!esMenor(indice, padre)) break;
            intercambiar(indice, padre);
            indice = padre;
        }
    }

    /**
     * Baja un elemento en el heap para mantener el orden.
     * @param indice es el índice del elemento a bajar.
     */

    private void bajar(int indice) {
        int tamaño = elementos.size();
        while (indice < tamaño) {
            int hijoIzq = 2 * indice + 1;
            int hijoDer = 2 * indice + 2;
            int menor = indice;

            if (hijoIzq < tamaño && esMenor(hijoIzq, menor)) {
                menor = hijoIzq;
            }
            if (hijoDer < tamaño && esMenor(hijoDer, menor)) {
                menor = hijoDer;
            }

            if (menor == indice) break;
            intercambiar(indice, menor);
            indice = menor;
        }
    }

    /**
     * Compara dos elementos en el heap.
     * @param i es el índice del primer elemento.
     * @param j es el índice del segundo elemento.
     * @return true si el elemento i es menor que el j, false en caso contrario.
     */
    private boolean esMenor(int i, int j) {
        return elementos.get(i).compareTo(elementos.get(j)) < 0;
    }

    /**
     * Intercambia dos elementos en el heap.
     * @param i es el índice del primer elemento.
     * @param j es el índice del segundo elemento.
     */
    private void intercambiar(int i, int j) {
        E temp = elementos.get(i);
        elementos.set(i, elementos.get(j));
        elementos.set(j, temp);
    }
}
