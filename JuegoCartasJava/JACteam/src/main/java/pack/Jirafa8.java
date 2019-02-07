package pack;

public class Jirafa8 implements Animalada{
	private Carta carta;
	public Jirafa8(Carta pCarta) {
		carta= pCarta;
	}
	public void realizarAnimalada() {
		int pos =ColaEntrada.getColaEntrada().getListaCartas().indexOf(carta)-1;
		if(pos >= 0 &&ColaEntrada.getColaEntrada().getListaCartas().get(pos).getNum() < 8 && pos>=0) {
			ColaEntrada.getColaEntrada().getListaCartas().remove(carta);
			ColaEntrada.getColaEntrada().getListaCartas().add(pos, carta);//a
			
		}
	
	}
}
