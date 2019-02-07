package pack;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Observable;

public class ColaEntrada extends Observable{

	private static ColaEntrada mCola;
	private LinkedList<Carta> listaCartas;

	private ColaEntrada() {
		listaCartas = new LinkedList<Carta>();
	}

	public static ColaEntrada getColaEntrada() {
		if(mCola==null) {
			mCola= new ColaEntrada();
		}
		return mCola;
	}

	/**
	 * 
	 * @param pCarta
	 */
	public void addCarta(Carta pCarta) {
		listaCartas.add(pCarta);
		setChanged();
		notifyObservers("ColaEntrada");
		realizarAnimaladas();
		setChanged();
		notifyObservers("ColaEntrada");
		realizarAnimaladasRecurrentes();
		notifyObservers("ColaEntrada");
		listaCartas.stream().forEach(Carta::noUltimaJugada);
		revisarCola();
	}

	public void realizarAnimaladas() {
		listaCartas.getLast().realizarAnimalada();
	}

	public void realizarAnimaladasRecurrentes() {
		// TODO - implement ColaEntrada.realizarAnimaladasRecurrentes
		for (int i = listaCartas.size()-1; i >= 0; i--) {
			Carta esta = listaCartas.get(i);
			if(!esta.getUltimaJugada()) {
				if(esta.getNum() == 11 || esta.getNum() == 10 || esta.getNum() == 8) {
					esta.realizarAnimalada();
				}
			}
			
		}
	}

	public void revisarCola() {
		// TODO - implement ColaEntrada.revisarCola
		if(listaCartas.size() == 5) {
			BarBestial.getBarBestial().addCarta(listaCartas.getFirst());
			listaCartas.removeFirst();
			setChanged();
			notifyObservers("ColaEntrada");
			BarBestial.getBarBestial().addCarta(listaCartas.getFirst());
			listaCartas.removeFirst();
			setChanged();
			notifyObservers("ColaEntrada");
			EsLoQueHay.getEsLoQueHay().addCarta(listaCartas.getLast());
			listaCartas.removeLast();
			setChanged();
			notifyObservers("ColaEntrada");
		}
	}
	public Carta buscarCarta(int fuerza){
		boolean encontrado = false;
		Carta buscada = null;
		Iterator<Carta> itr = listaCartas.iterator();
		while(encontrado == false && itr.hasNext()){
			Carta siguiente = itr.next();
			if(siguiente.getNum() == fuerza){
				buscada = siguiente;
				encontrado = true;
			}
		}
		return buscada;
	}
	public LinkedList<Carta> getListaCartas(){
		return listaCartas;
	}
	public ListIterator<Carta> getIterador(){
		return listaCartas.listIterator();
	}
}