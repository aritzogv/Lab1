import static org.junit.Assert.*;

import java.util.LinkedList;

import org.junit.Before;
import org.junit.Test;

import pack.Carta;
import pack.Color;
import pack.Mano;

public class ManoTest {

	private Mano mano;
	private Carta mono;
	
	@Before
	public void setUp() throws Exception {
		mano = new Mano();
		mono = new Carta(Color.AZUL, 4);
	}

	@Test
	public void testAddCartas() {
		mano.addCarta(mono);
		assertTrue(mano.getIterador().next() == mono);
	}
	@Test
	public void testJugarCarta() {
		mano.addCarta(mono);
		mano.jugarCarta(0);
		assertTrue(mano.getSize() == 0);
	}
	@Test
	public void testHayCartas() {
		mano.addCarta(mono);
		if(mano.hayCartas()){
			assertTrue(mano.getSize() != 0);
		}
		else{
			assertTrue(mano.getSize() == 0);
		}
	}

}
