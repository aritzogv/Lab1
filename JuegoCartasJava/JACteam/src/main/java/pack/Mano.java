package pack;

import java.util.LinkedList;
import java.util.ListIterator;

public class Mano{

	private LinkedList<Carta> cartasMano;

	public Mano() {
		cartasMano = new LinkedList<>();
	}

	/**
	 * 
	 * @param pCarta
	 */
	public void addCarta(Carta pCarta) {
		cartasMano.add(pCarta);
	}

	/**
	 * 
	 * @param pCarta
	 */
	public Carta jugarCarta(int pCarta) {
		Carta carta = cartasMano.get(pCarta);
		cartasMano.remove(pCarta);
		return carta;
	}
	public boolean hayCartas() {
		if(cartasMano.isEmpty()) {
			return false;
		}
		return true;
	}
	public int getSize() {
		return cartasMano.size();
	}
	public ListIterator<Carta> getIterador(){
		return cartasMano.listIterator();
	}
}