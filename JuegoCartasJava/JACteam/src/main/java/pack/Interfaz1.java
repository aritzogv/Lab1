package pack;

import java.awt.EventQueue;
import java.awt.Frame;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.ImageIcon;
import java.awt.Image;
import java.awt.Color;
import java.util.ArrayList;
import java.util.ListIterator;
import java.util.Observable;
import java.util.Observer;
import javax.swing.JLabel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Interfaz1 extends JFrame implements Observer {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8480461185431500376L;
	private JPanel contentPane;
	private JLabel label_18;
	private JLabel label_1;
	private JLabel label_2;
	private JLabel label_3;
	private JLabel label_4;
	private JLabel label_5;
	private JLabel label_6;
	private JLabel label_7;
	private JLabel label_8;
	private JLabel label_9;
	private JLabel label_10;
	private JLabel label_11;
	private JLabel label_12;
	private JLabel label_13;
	private JLabel label_14;
	private JLabel label_15;
	private JLabel label_16;
	private JLabel label_17;
	private ArrayList<JLabel> cola;
	private ArrayList<JLabel> manoR;
	private ArrayList<JLabel> manoIA;
	private static Frame frame;
	private JLabel label_cielo;
	private JLabel label_elqh;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new Interfaz1();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Interfaz1() {
		initialize();
		Partida.getPartida().addObserver(this);
		ColaEntrada.getColaEntrada().addObserver(this);
		JugadorReal.getJugadorReal().addObserver(this);
		IA.getIA().addObserver(this);
		BarBestial.getBarBestial().addObserver(this);
		EsLoQueHay.getEsLoQueHay().addObserver(this);
		update(null, "ManoJugador");
		update(null, "ManoIA");
	}

	private void initialize() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 801, 550);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(75, 0, 130));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.add(getLabel_elqh());
		contentPane.add(getLabel_cielo());
		contentPane.add(getLabel_18());
		contentPane.add(getLabel_17());
		contentPane.add(getLabel_16());
		contentPane.add(getLabel_15());
		contentPane.add(getLabel_14());
		contentPane.add(getLabel_13());
		contentPane.add(getLabel_12());
		contentPane.add(getLabel_11());
		contentPane.add(getLabel_10());
		contentPane.add(getLabel_9());
		contentPane.add(getLabel_8());
		contentPane.add(getLabel_7());
		contentPane.add(getLabel_6());
		contentPane.add(getLabel_5());
		contentPane.add(getLabel_4());
		contentPane.add(getLabel_3());
		contentPane.add(getLabel_2());
		contentPane.add(getLabel_1());
		cola = new ArrayList<>();
		cola.add(label_8);
		cola.add(label_9);
		cola.add(label_10);
		cola.add(label_11);
		cola.add(label_12);
		manoR = new ArrayList<>();
		manoR.add(label_14);
		manoR.add(label_15);
		manoR.add(label_16);
		manoR.add(label_17);
		manoIA = new ArrayList<>();
		manoIA.add(label_5);
		manoIA.add(label_4);
		manoIA.add(label_3);
		manoIA.add(label_2);

	}

	private JLabel getLabel_1() {
		if (label_1 == null) {
			Image imagen = new ImageIcon(this.getClass().getResource("/cielo.png")).getImage();
			label_1 = new JLabel(new ImageIcon(imagen.getScaledInstance(131, 80, 125)));
			label_1.setBounds(10, 11, 131, 80);// J
		}
		return label_1;
	}

	private JLabel getLabel_2() {
		if (label_2 == null) {
			Image imagen = new ImageIcon(this.getClass().getResource("/marco.png")).getImage();
			label_2 = new JLabel(new ImageIcon(imagen.getScaledInstance(100, 150, 125)));
			label_2.setBounds(183, 11, 100, 150);
		}
		return label_2;
	}

	private JLabel getLabel_3() {
		if (label_3 == null) {
			Image imagen = new ImageIcon(this.getClass().getResource("/marco.png")).getImage();
			label_3 = new JLabel(new ImageIcon(imagen.getScaledInstance(100, 150, 125)));
			label_3.setBounds(293, 11, 100, 150);
		}
		return label_3;
	}

	private JLabel getLabel_4() {
		if (label_4 == null) {
			Image imagen = new ImageIcon(this.getClass().getResource("/marco.png")).getImage();
			label_4 = new JLabel(new ImageIcon(imagen.getScaledInstance(100, 150, 125)));
			label_4.setBounds(403, 11, 100, 150);
		}
		return label_4;
	}

	private JLabel getLabel_5() {
		if (label_5 == null) {
			Image imagen = new ImageIcon(this.getClass().getResource("/marco.png")).getImage();
			label_5 = new JLabel(new ImageIcon(imagen.getScaledInstance(100, 150, 125)));
			label_5.setBounds(513, 11, 100, 150);
		}
		return label_5;
	}

	private JLabel getLabel_6() {
		if (label_6 == null) {
			Image imagen = new ImageIcon(this.getClass().getResource("/es lo que hay.png")).getImage();
			label_6 = new JLabel(new ImageIcon(imagen.getScaledInstance(131, 80, 125)));
			label_6.setBounds(654, 11, 131, 80);
		}
		return label_6;
	}

	private JLabel getLabel_7() {
		if (label_7 == null) {
			Image imagen = new ImageIcon(this.getClass().getResource("/entrada.png")).getImage();
			label_7 = new JLabel(new ImageIcon(imagen.getScaledInstance(100, 150, 125)));
			// lblNewLabel = new JLabel(new
			// ImageIcon(this.getClass().getResource("/entrada3.png")));
			label_7.setBounds(10, 181, 100, 150);
		}
		return label_7;
	}

	private JLabel getLabel_8() {
		if (label_8 == null) {
			Image imagen = new ImageIcon(this.getClass().getResource("/marco2.png")).getImage();
			label_8 = new JLabel(new ImageIcon(imagen.getScaledInstance(100, 150, 125)));
			label_8.setBounds(120, 181, 100, 150);
		}
		return label_8;
	}

	private JLabel getLabel_9() {
		if (label_9 == null) {
			Image imagen = new ImageIcon(this.getClass().getResource("/marco2.png")).getImage();
			label_9 = new JLabel(new ImageIcon(imagen.getScaledInstance(100, 150, 125)));
			label_9.setBounds(230, 181, 100, 150);
		}
		return label_9;
	}

	private JLabel getLabel_10() {
		if (label_10 == null) {
			Image imagen = new ImageIcon(this.getClass().getResource("/marco2.png")).getImage();
			label_10 = new JLabel(new ImageIcon(imagen.getScaledInstance(100, 150, 125)));
			label_10.setBounds(340, 181, 100, 150);
		}
		return label_10;
	}

	private JLabel getLabel_11() {
		if (label_11 == null) {
			Image imagen = new ImageIcon(this.getClass().getResource("/marco2.png")).getImage();
			label_11 = new JLabel(new ImageIcon(imagen.getScaledInstance(100, 150, 125)));
			label_11.setBounds(450, 181, 100, 150);
		}
		return label_11;
	}

	private JLabel getLabel_12() {
		if (label_12 == null) {
			Image imagen = new ImageIcon(this.getClass().getResource("/marco2.png")).getImage();
			label_12 = new JLabel(new ImageIcon(imagen.getScaledInstance(100, 150, 125)));
			label_12.setBounds(560, 181, 100, 150);
		}
		return label_12;
	}

	private JLabel getLabel_13() {
		if (label_13 == null) {

			Image imagen = new ImageIcon(this.getClass().getResource("/patada.png")).getImage();
			label_13 = new JLabel(new ImageIcon(imagen.getScaledInstance(100, 150, 125)));
			label_13.setBounds(670, 181, 100, 150);
		}
		return label_13;
	}

	private JLabel getLabel_14() {
		if (label_14 == null) {
			Image imagen = new ImageIcon(this.getClass().getResource("/marco.png")).getImage();
			label_14 = new JLabel(new ImageIcon(imagen.getScaledInstance(100, 150, 125)));
			label_14.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent arg0) {
					Image imagen = new ImageIcon(this.getClass().getResource("/marco.png")).getImage();
					label_14.setIcon(new ImageIcon(imagen.getScaledInstance(100, 150, 125)));
					try {
						Partida.getPartida().siguienteTurno(0);
						update(null, "ManoJugador");
					} catch (Exception e) {
						label_14.removeMouseListener(this);
					}

				}
			});
			label_14.setBounds(183, 360, 100, 150);
		}
		return label_14;
	}

	private JLabel getLabel_15() {
		if (label_15 == null) {
			Image imagen = new ImageIcon(this.getClass().getResource("/marco.png")).getImage();
			label_15 = new JLabel(new ImageIcon(imagen.getScaledInstance(100, 150, 125)));
			label_15.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					Image imagen = new ImageIcon(this.getClass().getResource("/marco.png")).getImage();
					label_15.setIcon(new ImageIcon(imagen.getScaledInstance(100, 150, 125)));
					try {
						Partida.getPartida().siguienteTurno(1);
						update(null, "ManoJugador");
					} catch (Exception f) {
						label_15.removeMouseListener(this);
					}
				}
			});
			label_15.setBounds(293, 360, 100, 150);
		}
		return label_15;
	}

	private JLabel getLabel_16() {
		if (label_16 == null) {
			Image imagen = new ImageIcon(this.getClass().getResource("/marco.png")).getImage();
			label_16 = new JLabel(new ImageIcon(imagen.getScaledInstance(100, 150, 125)));
			label_16.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					Image imagen = new ImageIcon(this.getClass().getResource("/marco.png")).getImage();
					label_16.setIcon(new ImageIcon(imagen.getScaledInstance(100, 150, 125)));
					try {
						Partida.getPartida().siguienteTurno(2);
						update(null, "ManoJugador");
					} catch (Exception E) {
						label_16.removeMouseListener(this);
					}
				}
			});
			label_16.setBounds(403, 360, 100, 150);
		}
		return label_16;
	}

	private JLabel getLabel_17() {
		if (label_17 == null) {
			Image imagen = new ImageIcon(this.getClass().getResource("/marco.png")).getImage();
			label_17 = new JLabel(new ImageIcon(imagen.getScaledInstance(100, 150, 125)));
			label_17.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent arg0) {
					Image imagen = new ImageIcon(this.getClass().getResource("/marco.png")).getImage();
					label_17.setIcon(new ImageIcon(imagen.getScaledInstance(100, 150, 125)));
					try {
						Partida.getPartida().siguienteTurno(3);
						update(null, "ManoJugador");
					} catch (Exception e) {
						label_17.removeMouseListener(this);
					}
				}
			});
			label_17.setBounds(513, 360, 100, 150);
		}
		return label_17;
	}

	private JLabel getLabel_18() {
		if (label_18 == null) {
			Image imagen = new ImageIcon(this.getClass().getResource("/dorso.png")).getImage();
			label_18 = new JLabel(new ImageIcon(imagen.getScaledInstance(100, 150, 125)));
			label_18.setBounds(670, 342, 100, 150);
		}
		return label_18;
	}

	public static Frame getFrame() {
		return frame;
	}

	@Override
	public void update(Observable arg0, Object arg1) {
		// TODO Auto-generated method stub
		if (arg1 == "ColaEntrada") {
			ListIterator<Carta> itr = ColaEntrada.getColaEntrada().getIterador();
			ListIterator<JLabel> itr1 = cola.listIterator();
			while (itr.hasNext() && itr1.hasNext()) {
				Carta carta = itr.next();
				JLabel label = itr1.next();
				String s = (String) carta.getNombre();
				Image imagen = new ImageIcon(this.getClass().getResource(s)).getImage();
				label.setIcon(new ImageIcon(imagen.getScaledInstance(100, 150, 125)));
			}
			if (itr1.hasNext()) {
				while (itr1.hasNext()) {
					JLabel label = itr1.next();
					Image imagen = new ImageIcon(this.getClass().getResource("/marco2.png")).getImage();
					label.setIcon(new ImageIcon(imagen.getScaledInstance(100, 150, 125)));
				}
			}
		} else if (arg1 == "ManoJugador") {
			ListIterator<Carta> itr = JugadorReal.getJugadorReal().getMano().getIterador();
			ListIterator<JLabel> itr1 = manoR.listIterator();
			while (itr.hasNext() && itr1.hasNext()) {
				Carta carta = itr.next();
				JLabel label = itr1.next();
				String s = (String) carta.getNombre();
				Image imagen = new ImageIcon(this.getClass().getResource(s)).getImage();
				label.setIcon(new ImageIcon(imagen.getScaledInstance(100, 150, 125)));
			}
			while (itr1.hasNext()) {
				Image imagen = new ImageIcon(this.getClass().getResource("/marco.png")).getImage();
				itr1.next().setIcon(new ImageIcon(imagen.getScaledInstance(100, 150, 125)));
			}
		} else if (arg1 == "ManoIA") {
			ListIterator<Carta> itr = IA.getIA().getMano().getIterador();
			ListIterator<JLabel> itr1 = manoIA.listIterator();
			while (itr.hasNext() && itr1.hasNext()) {
				itr.next();
				JLabel label = itr1.next();
				Image imagen = new ImageIcon(this.getClass().getResource("/dorso.png")).getImage();
				label.setIcon(new ImageIcon(imagen.getScaledInstance(100, 150, 125)));
			}
			while (itr1.hasNext()) {
				Image imagen = new ImageIcon(this.getClass().getResource("/marco.png")).getImage();
				itr1.next().setIcon(new ImageIcon(imagen.getScaledInstance(100, 150, 125)));
			}
		} else if (arg1 == "MazoJugador") {
			Image imagen = new ImageIcon(this.getClass().getResource("/marco.png")).getImage();
			label_18.setIcon(new ImageIcon(imagen.getScaledInstance(100, 150, 125)));
		} else if (arg1 == "BarBestial") {
			String s = (String) BarBestial.getBarBestial().ultimaCarta();
			Image imagen = new ImageIcon(this.getClass().getResource(s)).getImage();
			label_cielo.setIcon(new ImageIcon(imagen.getScaledInstance(87, 125, 125)));
		} else if (arg1 == "EsLoQueHay") {
			String s = (String) EsLoQueHay.getEsLoQueHay().ultimaCarta();
			Image imagen = new ImageIcon(this.getClass().getResource(s)).getImage();
			label_elqh.setIcon(new ImageIcon(imagen.getScaledInstance(87, 125, 125)));
		}
	}

	private JLabel getLabel_cielo() {
		if (label_cielo == null) {
			label_cielo = new JLabel(new ImageIcon());
			label_cielo.setBounds(31, 49, 87, 125);
		}
		return label_cielo;
	}

	private JLabel getLabel_elqh() {
		if (label_elqh == null) {
			label_elqh = new JLabel();
			label_elqh.setBounds(677, 49, 87, 125);
		}
		return label_elqh;
	}
}
