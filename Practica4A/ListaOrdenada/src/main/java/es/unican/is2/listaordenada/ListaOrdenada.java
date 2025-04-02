package es.unican.is2.listaordenada;

import java.util.ArrayList;
import java.util.List;

/**
 * Clase que implementa el ADT ListaOrdenada
 */
public class ListaOrdenada<E extends Comparable<E>> implements IListaOrdenada<E> {

	private List<E> lista = new ArrayList<E>();

	public E get(int indice) {
		if (indice < 0 || indice >= lista.size()) {
            throw new IndexOutOfBoundsException("Índice fuera de rango: " + indice);
        }
        return lista.get(indice);
	}

	public void add(E elemento) {
		int indice = 0;
		while (indice < lista.size() && elemento.compareTo(lista.get(indice)) > 0) {
				indice++;
		}
		lista.add(indice, elemento);
	}

	public E remove(int indice) {
		if (indice < 0 || indice >= lista.size()) {
            throw new IndexOutOfBoundsException("Índice fuera de rango: " + indice);
        }
        return lista.remove(indice);
	}

	public int size() {
		return lista.size();
	}

	public void clear() {
		lista.clear();
	}
}