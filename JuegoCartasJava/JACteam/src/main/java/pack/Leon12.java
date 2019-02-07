package pack;

import java.util.LinkedList;

public class Leon12 implements Animalada {
	public Leon12() {
		
	}
	@Override
	public void realizarAnimalada() {
		// TODO Auto-generated method stub
		LinkedList<Carta> lista = ColaEntrada.getColaEntrada().getListaCartas();
		if(ColaEntrada.getColaEntrada().buscarCarta(12) != null && !ColaEntrada.getColaEntrada().buscarCarta(12).getUltimaJugada()){
			EsLoQueHay.getEsLoQueHay().addCarta(lista.getLast());
			lista.removeLast();
		}
		else{
			while(ColaEntrada.getColaEntrada().buscarCarta(4) !=null){
				Carta carta = ColaEntrada.getColaEntrada().buscarCarta(4);
				EsLoQueHay.getEsLoQueHay().addCarta(carta);
				lista.remove(carta);
			}
			lista.addFirst(lista.getLast());
			lista.removeLast();
		}
	}

}
