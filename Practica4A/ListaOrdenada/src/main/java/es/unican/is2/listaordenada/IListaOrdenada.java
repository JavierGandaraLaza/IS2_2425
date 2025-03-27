package es.unican.is2.listaordenada;

/** 
 * ADT ListaOrdenada  
 * Estructura de datos que almacena elementos ordenados de acuerdo 
 * a su orden natural 
 * @param <E> tipo de los elementos almacenados en la lista 
 */ 
public interface IListaOrdenada<E extends Comparable<E>> { 
 
    /** 
     * Retorna el elemento que ocupa la posicion indicada 
     * @param index Indice del elemento al que se accede 
     * @return Elemento en la posicion index 
     * @throws IndexOutOfBoundsException si el indice es incorrecto 
     */ 
	public E get(int index) throws IndexOutOfBoundsException; 
     
    /** 
     * Anhade un elemento a la posicion 
     * que le corresponda por orden natural 
     * @param elemento Elemento a anhadir 
     */ 
    public void add(E elemento); 
     
    /** 
     * Elimina el elemento que ocupa la posicion indicada 
     * @param index Indice del elemento que se quiere eliminar 
     * @return El elemento eliminado 
     * @throws IndexOutOfBoundsException si el indice es incorrecto 
     */ 
    public E remove(int index) throws IndexOutOfBoundsException; 
     
    /** 
     * Retorna el numero de elementos en la lista 
     */ 
    public int size(); 
     
    /** 
     * Elimina todos los elementos de la lista 
     */ 
    public void clear(); 
 
}