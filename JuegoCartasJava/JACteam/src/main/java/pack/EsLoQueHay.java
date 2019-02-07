package pack;

import java.util.LinkedList;
import java.util.Observable;

public class EsLoQueHay extends Observable{

	private static EsLoQueHay mEsLoQueHay;
	private LinkedList<Carta> listaCartas;

	private EsLoQueHay() {
		// TODO - implement EsLoQueHay.EsLoQueHay
		listaCartas = new LinkedList<Carta>();
	}

	public static EsLoQueHay getEsLoQueHay() {
		// TODO - implement EsLoQueHay.getEsLoQueHay
		if(mEsLoQueHay == null) {
			mEsLoQueHay = new EsLoQueHay();
		}
		return mEsLoQueHay;
	}

	/**
	 * 
	 * @param pCarta
	 */
	public void addCarta(Carta pCarta) {
		// TODO - implement EsLoQueHay.addCarta
		listaCartas.add(pCarta);
		setChanged();
		notifyObservers("EsLoQueHay");
	}
	public String ultimaCarta() {
		return listaCartas.getLast().getNombre();
	}

}