package pack;

import java.util.LinkedList;
import java.util.ListIterator;

public class Mono4 implements Animalada{
	public Mono4() {
		
	}

	@Override
	public void realizarAnimalada() {
		LinkedList<Carta> listaMonos = new LinkedList<Carta>();
		ListIterator<Carta> itr= ColaEntrada.getColaEntrada().getIterador();
		while(itr.hasNext()) {
			Carta carta=itr.next();
			if(carta.getNum()==4) {
				listaMonos.add(carta);
			}
		}
		Carta ultima=ColaEntrada.getColaEntrada().getListaCartas().getLast();
		ListIterator<Carta> itr1=listaMonos.listIterator();
		boolean encontrado= false;
		while(itr1.hasNext() && !encontrado) {
			if(itr1.next().equals(ultima)) {
				encontrado=true;
			}
		}
		if(!encontrado) {
			listaMonos.add(ultima);
		}
		itr1=listaMonos.listIterator();
		if(listaMonos.size()>=2) {
			itr= ColaEntrada.getColaEntrada().getIterador();
			while(itr.hasNext()) {
				Carta carta=itr.next();
				if(carta.getNum()==10||carta.getNum()==11) {
					itr.remove();
				}
			}
			while(itr1.hasNext()) {
				ColaEntrada.getColaEntrada().getListaCartas().remove(itr1.next());
			}
			itr1=listaMonos.listIterator();
			while(itr1.hasNext()) {
				ColaEntrada.getColaEntrada().getListaCartas().addFirst(itr1.next());
			}
		}
	}
	
}
