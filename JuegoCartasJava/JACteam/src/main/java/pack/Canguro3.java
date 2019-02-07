package pack;

import java.util.Random;

public class Canguro3 implements Animalada{
	private Random random;
	public Canguro3() {
		random = new Random();
	}
	public void realizarAnimalada() {
		int i;
		i = random.nextInt(2);
		
		if (i == 0 && ColaEntrada.getColaEntrada().getListaCartas().size()>2){
			Carta carta = ColaEntrada.getColaEntrada().getListaCartas().pollLast();
			ColaEntrada.getColaEntrada().getListaCartas().add(ColaEntrada.getColaEntrada().getListaCartas().size()-1, carta);
		}
		else if(i == 1 && ColaEntrada.getColaEntrada().getListaCartas().size()>3){
			Carta carta = ColaEntrada.getColaEntrada().getListaCartas().pollLast();
			ColaEntrada.getColaEntrada().getListaCartas().add(ColaEntrada.getColaEntrada().getListaCartas().size()-2, carta);
		}
	}
}
