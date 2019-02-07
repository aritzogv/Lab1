package pack;

import java.util.Random;

public class IA extends Jugador{
	
	private Random random;
	private static IA mIA;

	private IA(Color pColor) {
		super(pColor);
		setChanged();
		notifyObservers("ManoIA");
		
		random = new Random();
	}
	public static IA getIA() {
		if(mIA == null) {
			mIA= new IA(Color.VERDE);
		}
		return mIA;
	}
	public void ejecutarTurno(){
		jugarCarta(random.nextInt(mano.getSize()));
		setChanged();
		notifyObservers("ManoIA");
		robarCarta();
		if(!getMazo().hayCartas()) {
			setChanged();
			notifyObservers("MazoIA");
		}
		setChanged();
		notifyObservers("ManoIA");
	}
}
