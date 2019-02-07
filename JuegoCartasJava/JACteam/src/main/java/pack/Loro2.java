package pack;

import java.util.Random;

public class Loro2 implements Animalada{
	private Random random;
	public Loro2() {
		random = new Random();
	}
	public void realizarAnimalada() {
		int i;
		if(ColaEntrada.getColaEntrada().getListaCartas().size()-2 >= 0){
		i = random.nextInt(ColaEntrada.getColaEntrada().getListaCartas().size()-1);
		EsLoQueHay.getEsLoQueHay().addCarta(ColaEntrada.getColaEntrada().getListaCartas().get(i));
		ColaEntrada.getColaEntrada().getListaCartas().remove(i);
		}
	}
}
