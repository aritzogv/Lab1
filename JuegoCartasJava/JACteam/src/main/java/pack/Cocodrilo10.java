package pack;

import java.util.LinkedList;
import java.util.ListIterator;

public class Cocodrilo10 implements Animalada {
	private Carta mCarta;
	public Cocodrilo10(Carta pCarta) {
		mCarta=pCarta;
	}
	@Override
	public void realizarAnimalada() {
		// TODO Auto-generated method stub
		LinkedList<Carta> lista = ColaEntrada.getColaEntrada().getListaCartas();
		ListIterator<Carta> it= lista.listIterator(ColaEntrada.getColaEntrada().getListaCartas().indexOf(mCarta));
		boolean encontrado= false;
		while(it.hasPrevious() && !encontrado){
			Carta carta= it.previous();
			if(carta.getNum()==7 || carta.getNum()>=10){
				encontrado=true;
			}
			else{
				EsLoQueHay.getEsLoQueHay().addCarta(carta);
				it.remove();;
			}
		}
	}

}
