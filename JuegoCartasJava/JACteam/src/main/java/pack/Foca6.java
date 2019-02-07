package pack;

import java.util.Collections;

public class Foca6 implements Animalada{
	public Foca6() {
		
	}
	public void realizarAnimalada() {
		Collections.reverse(ColaEntrada.getColaEntrada().getListaCartas());
	}
}
