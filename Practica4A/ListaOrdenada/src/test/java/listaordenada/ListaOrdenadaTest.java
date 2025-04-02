package listaordenada;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

import es.unican.is2.listaordenada.ListaOrdenada;

public class ListaOrdenadaTest {
	private ListaOrdenada<Integer> lista;

    @Before
    public void setUp() {
        lista = new ListaOrdenada<>();
    }

    // Pruebas para get
    @Test
    public void testGetElementoValido() {
        lista.add(5);
        lista.add(3);
        lista.add(7);
        assertEquals(Integer.valueOf(3), lista.get(0));
        assertEquals(Integer.valueOf(5), lista.get(1));
        assertEquals(Integer.valueOf(7), lista.get(2));
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testGetIndiceNegativo() {
        lista.get(-1);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testGetIndiceFueraDeRango() {
        lista.add(1);
        lista.get(1);
    }

    // Pruebas para add
    @Test
    public void testAddListaVacia() {
        lista.add(5);
        assertEquals(1, lista.size());
        assertEquals(Integer.valueOf(5), lista.get(0));
    }

    @Test
    public void testAddElementosOrdenados() {
        lista.add(5);
        lista.add(3);
        lista.add(7);
        lista.add(4);
        assertEquals(4, lista.size());
        assertEquals(Integer.valueOf(3), lista.get(0));
        assertEquals(Integer.valueOf(4), lista.get(1));
        assertEquals(Integer.valueOf(5), lista.get(2));
        assertEquals(Integer.valueOf(7), lista.get(3));
    }

    @Test
    public void testAddElementosDuplicados() {
        lista.add(5);
        lista.add(5);
        assertEquals(2, lista.size());
        assertEquals(Integer.valueOf(5), lista.get(0));
        assertEquals(Integer.valueOf(5), lista.get(1));
    }

    // Pruebas para remove
    @Test
    public void testRemoveElementoValido() {
        lista.add(5);
        lista.add(3);
        assertEquals(Integer.valueOf(3), lista.remove(0));
        assertEquals(1, lista.size());
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testRemoveIndiceNegativo() {
        lista.remove(-1);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testRemoveIndiceFueraDeRango() {
        lista.add(1);
        lista.remove(1);
    }

    // Pruebas para size
    @Test
    public void testSizeListaVacia() {
        assertEquals(0, lista.size());
    }

    @Test
    public void testSizeListaConElementos() {
        lista.add(5);
        lista.add(3);
        assertEquals(2, lista.size());
    }

    // Pruebas para clear
    @Test
    public void testClearListaVacia() {
        lista.clear();
        assertEquals(0, lista.size());
    }

    @Test
    public void testClearListaConElementos() {
        lista.add(5);
        lista.add(3);
        lista.clear();
        assertEquals(0, lista.size());
    }
    
}
