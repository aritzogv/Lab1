import static org.junit.Assert.*;

import java.util.LinkedList;

import org.junit.Before;
import org.junit.Test;

import pack.BarBestial;
import pack.Carta;
import pack.Color;

public class BarBestialTest {
	
	private LinkedList<Carta> listaCartas;
	private Carta mono;
	private Carta cebra;
	private BarBestial mBar;
	@Before
	public void setUp() throws Exception {
		listaCartas = new LinkedList<>();
		listaCartas.add(mono);
		cebra = new Carta(Color.AZUL, 7);
		listaCartas.add(cebra);
	}

	@Test
	public void testUltimaCarta() {
		assertEquals(listaCartas.getLast(), cebra);
	}

}
