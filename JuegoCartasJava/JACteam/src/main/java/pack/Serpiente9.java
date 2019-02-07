package pack;

import java.util.Collections;
import java.util.Comparator;

public class Serpiente9 implements Animalada{
	public Serpiente9() {
		
	}
	public void realizarAnimalada() {
		Comparator<Carta> comparador =  new Comparator<Carta>(){
			@Override
			public int compare(Carta c1, Carta c2) {
				return c2.getNum() - c1.getNum();
			}
		};
		Collections.sort(ColaEntrada.getColaEntrada().getListaCartas(), comparador);;
	}
}
