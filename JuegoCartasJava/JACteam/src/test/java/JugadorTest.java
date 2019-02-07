import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import pack.Color;
import pack.Jugador;
import pack.Mano;
import pack.Mazo;

public class JugadorTest {
	private Jugador jug;
	@Before
	public void setUp() throws Exception {
		jug = new Jugador(Color.AZUL) {
		};
		
	}

	@Test
	public void testRobarCarta() {
		jug.robarCarta();
		assertTrue(jug.tienesCartas());
		
	}
	@Test
	public void testJugarCarta(){
		jug.jugarCarta(0);
		jug.jugarCarta(0);
		jug.jugarCarta(0);
		jug.jugarCarta(0);
		assertFalse(jug.tienesCartas());
		
	}

}
