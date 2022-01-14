package aux;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.PriorityQueue;

/**
 * Esta clase permite almacenamiento, inserción y eliminación de objetos con ID.
 */
public class IDList<T extends IDeable> {
    private ArrayList<T> data;
    private PriorityQueue<Integer> availableIDs;

    public IDList() {
        this.data = new ArrayList<>();
        this.availableIDs = new PriorityQueue<>();
    }

    /**
     * Regresa el elemento en el índice dado por a implementación de esta estructura,
     * El índice siempre es igual a la ID del elemento retornado.
     * @param index indice a buscar.
     * @return Elemento con la ID pasada como índice. Si este no existe, se regresa null.
     */
    public T get(int index) {
        return data.get(index);
    }

    /**
     * @return tamaño del contenedor.
     */
    public int size() {
        return data.size();
    }

    /**
     * Agrega el elemento dado y le asigna una ID.
     */
    public void add(T e) {
        if (availableIDs.isEmpty()) {
            e.setID(data.size());
            data.add(e);
        } else {
            int id = availableIDs.remove();
            e.setID(id);
            data.set(id, e);
        }
    }

    /**
     * Remueve el elemento con el índice dado y guarda el índice para su uso posterior.
     * @param index índice del elemento a remover.
     */
    public void remove(int index) {
        data.set(index, null);
        availableIDs.offer(index);
    }

    /**
     * Remueve el elemento dado de esta estructura.
     * @param e elemento a remover.
     */
    public void remove(T e) {
        int index = data.indexOf(e);
        if (index < 0) return;
        remove(index);
    }

    public Iterator<T> iterator() {
        return data.iterator();
    }
}
