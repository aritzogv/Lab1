package pack;

public class JugadorReal extends Jugador{
	private static JugadorReal mJugador;
	private JugadorReal() {
		super(Color.AZUL);
		setChanged();
		notifyObservers("ManoJugador");
	}

	public void jugarTurno(int pCarta) {
		super.jugarTurno(pCarta);
		IA.getIA().ejecutarTurno();
	}
	public static JugadorReal getJugadorReal() {
		if(mJugador==null) {
			mJugador= new JugadorReal();
		}
		return mJugador;
	}
}
