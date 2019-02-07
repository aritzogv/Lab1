import static org.junit.Assert.*;

import java.util.LinkedList;

import org.junit.Before;
import org.junit.Test;

import pack.Carta;
import pack.ColaEntrada;

public class ColaEntradaTest {
	private static ColaEntrada mCola;
	private LinkedList<Carta> listaCartas;
	private Carta mono;
	@Before
	public void setUp() throws Exception {
		listaCartas = new LinkedList<>();
	}

	@Test
	public void testAddCarta() {
		if(listaCartas.size() < 4){
			int i = listaCartas.size();
			listaCartas.add(mono);
			assertTrue(listaCartas.size() == i+1);
			assertEquals(listaCartas.getLast(), mono);
		}
		
	}

}
