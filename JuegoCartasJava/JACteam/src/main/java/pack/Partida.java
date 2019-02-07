package pack;

import java.util.Iterator;
import java.util.Observable;

public class Partida extends Observable{

	private static Partida mPartida;
	private Jugador jugador;
	private  String nombre;

	private Partida() {
		// TODO - implement Partida.Partida
		inicializar();
	}

	public static Partida getPartida() {
		// TODO - implement Partida.getPartida
		if(mPartida == null) {
			mPartida = new Partida();
		}
		return mPartida;
	}

	public void inicializar() {
		// TODO - implement Partida.inicializar
		ColaEntrada.getColaEntrada();
		BarBestial.getBarBestial();
		EsLoQueHay.getEsLoQueHay();
		jugador = JugadorReal.getJugadorReal();
		IA.getIA();
	}

	public void siguienteTurno(int pCarta) {
		// TODO - implement Partida.siguienteTurno
		jugador.jugarTurno(pCarta);
		terminarPartida();
		
		
		
	}
	private int calcularPuntuacion() {
		int punt = 0;
		Iterator<Carta> itr = BarBestial.getBarBestial().getListaCartas().iterator();
		while(itr.hasNext()) {
			Carta esta = itr.next();
			if(esta.getColor() == Color.AZUL) {
				punt  = punt + esta.getNum();
			}
		}
		return punt;
	}
	public void terminarPartida() {
		// TODO - implement Partida.terminarPartida
		if(!jugador.tienesCartas() && !IA.getIA().tienesCartas()) {
			BDbarbestialDAO.getbarbestialDAO().registrarPuntuacion(nombre, calcularPuntuacion());
			VentanaDatosRanking.main(null);
			Interfaz1.getFrame().setVisible(false);
		}
	}
	public void setNombre(String pNom) {
		nombre = pNom;
	}

}