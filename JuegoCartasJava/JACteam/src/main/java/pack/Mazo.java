package pack;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Stack;

public class Mazo{

	private Stack<Carta> cartasMazo;
	private Color color;
	public Mazo(Color pCol) {
		// TODO - implement Mazo.Mazo
		cartasMazo = new Stack<Carta>();
		color = pCol;
		ArrayList<Carta> mazoProv = new ArrayList<Carta>();
		for (int i = 1; i < 13; i++) {
			mazoProv.add(new Carta(color,i));
		}
		Collections.shuffle(mazoProv);
		for (int i = 0; i <= mazoProv.size()-1; i++) {
			cartasMazo.push(mazoProv.get(i));
		}
	}

	public Carta robarCarta() {
		// TODO - implement Mazo.robarCarta
		Carta carta= cartasMazo.pop();
		return carta;
		
	}
	public boolean hayCartas() {
		if(cartasMazo.isEmpty()) {
			return false;
		}else {
			return true;
		}
	}
}