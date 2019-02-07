package pack;

import java.util.LinkedList;
import java.util.Observable;

public class BarBestial extends Observable {

	private static BarBestial mBar;
	private LinkedList<Carta> listaCartas;

	private  BarBestial() {
		// TODO - implement BarBestial.BarBestial
		listaCartas = new LinkedList<>();
	}

	public LinkedList<Carta> getListaCartas(){
		return listaCartas;
	}
	public static BarBestial getBarBestial() {
		// TODO - implement BarBestial.getBarBestial
		if(mBar ==null) {
			mBar = new BarBestial();
		}
		return mBar;
	}

	/**
	 * 
	 * @param pCarta
	 */
	public void addCarta(Carta pCarta) {
		// TODO - implement BarBestial.addCarta
		listaCartas.add(pCarta);
		setChanged();
		notifyObservers("BarBestial");
	}
	public String ultimaCarta() {
		return listaCartas.getLast().getNombre();
	}
}