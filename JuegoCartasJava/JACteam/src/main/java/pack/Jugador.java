package pack;

import java.util.Observable;

public abstract class Jugador extends Observable{

	private Color color;
	protected Mano mano;
	protected Mazo mazo;

	/**
	 * 
	 * @param pColor
	 */
	public Jugador(Color pColor) {
		color = pColor;
		mazo= new Mazo(color);
		mano= new Mano();
		for (int i = 1; i < 5; i++) {
			robarCarta();
		}
	
	}

	/**
	 * 
	 * @param pCarta
	 */
	public void jugarCarta(int pCarta) {
		ColaEntrada.getColaEntrada().addCarta(mano.jugarCarta(pCarta));
	}

	public void robarCarta() {
		if(mazo.hayCartas()==true) {
			mano.addCarta(mazo.robarCarta());
		}
	}

	public boolean tienesCartas() {
		return mano.hayCartas();
	}
	public void jugarTurno(int pCarta) {
		jugarCarta(pCarta);
		setChanged();
		notifyObservers("ManoJugador");
		robarCarta();
		if(!mazo.hayCartas()) {
			setChanged();
			notifyObservers("MazoJugador");
		}
	}
	public Mano getMano() {
		return mano;
	}
	public Mazo getMazo() {
		return mazo;
	}
}