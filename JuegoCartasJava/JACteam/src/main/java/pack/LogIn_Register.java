package pack;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.table.TableModel;

import pack.LogIn_Register;

public class LogIn_Register extends JDialog {

	/**
	 * 
	 */
	private JPanel panel;
	private JLabel lblNombre;
	private JTextField textField;
	private JLabel lblContraseña;
	private JPasswordField passwordField;
	private JButton btnAceptar;
	private JButton btnBorrar;
	private JPanel panelBotones;
	private TableModel modeloDatosTabla;
	private Controlador mControlador;
	private static LogIn_Register dialog;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					dialog = new LogIn_Register();
					dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
					dialog.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});

	}

	/**
	 * Create the dialog.
	 */
	public LogIn_Register() {
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		Dimension windowSize = this.getSize();
		if (windowSize.height > screenSize.height) {
			windowSize.height = screenSize.height;
		}
		if (windowSize.width > screenSize.width) {
			windowSize.width = screenSize.width;
		}
		setLocation((screenSize.width - windowSize.width) / 2, (screenSize.height - windowSize.height) / 2);
		initialize();
	}

	private void initialize() {
		setTitle("Bienvenid@ a BarBestial");
		setBounds(100, 100, 450, 300);
		getContentPane().add(getPanel(), BorderLayout.CENTER);
		getContentPane().add(getPanelBotones(), BorderLayout.SOUTH);
	}

	private JPanel getPanel() {
		if (panel == null) {
			panel = new JPanel();
			panel.setLayout(new GridLayout(2, 2, 0, 0));
			panel.add(getLblNombre());
			panel.add(getTextField());
			panel.add(getLblContraseña());
			panel.add(getPasswordField());
		}
		return panel;
	}

	private JLabel getLblNombre() {
		if (lblNombre == null) {
			lblNombre = new JLabel("Nombre:");
		}
		return lblNombre;
	}

	private JTextField getTextField() {
		if (textField == null) {
			textField = new JTextField();
			textField.setColumns(10);
		}
		return textField;
	}

	private JLabel getLblContraseña() {
		if (lblContraseña == null) {
			lblContraseña = new JLabel("Contrase\u00F1a:");
		}
		return lblContraseña;
	}

	private JPasswordField getPasswordField() {
		if (passwordField == null) {
			passwordField = new JPasswordField();
		}
		return passwordField;
	}

	private JButton getBtnAceptar() {
		if (btnAceptar == null) {
			btnAceptar = new JButton("Iniciar sesion");
			btnAceptar.setActionCommand("iniciar sesion");
			btnAceptar.addActionListener(getControlador());
		}
		return btnAceptar;
	}

	private JButton getBtnBorrar() {
		if (btnBorrar == null) {
			btnBorrar = new JButton("Registrar");
			btnBorrar.setActionCommand("Registrar");
			btnBorrar.addActionListener(getControlador());
		}
		return btnBorrar;
	}

	private JPanel getPanelBotones() {
		if (panelBotones == null) {
			panelBotones = new JPanel();
			panelBotones.add(getBtnAceptar());
			panelBotones.add(getBtnBorrar());
		}
		return panelBotones;
	}

	private TableModel getModeloDatosTabla() {
		if (modeloDatosTabla == null) {
			modeloDatosTabla = new BDModeloDatosTabla();
		}
		return modeloDatosTabla;
	}

	private Controlador getControlador() {
		if (mControlador == null) {
			mControlador = new Controlador();
		}
		return mControlador;
	}

	public class Controlador extends WindowAdapter implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			if (e.getActionCommand().equalsIgnoreCase("Registrar")) {
				BDInfoUsuario nuevoUsu = new BDInfoUsuario();
				// nuevoUsu.addDato(getTextField().getText());
				// nuevoUsu.addDato(new String(getPasswordField().getPassword()));
				// ((BDModeloDatosTabla) getModeloDatosTabla()).addUsuario(nuevoUsu);
				BDbarbestialDAO.getbarbestialDAO().resgistrar(getTextField().getText(),
						new String(getPasswordField().getPassword()));
				JOptionPane.showMessageDialog(LogIn_Register.this, "A continuación inicie sesión para empezar a jugar",
						"Usuario registrado", JOptionPane.PLAIN_MESSAGE);
			} else if (e.getActionCommand().equalsIgnoreCase("iniciar sesion")) {
				if (!BDbarbestialDAO.getbarbestialDAO().existeUsuario(getTextField().getText())) {
					JOptionPane.showMessageDialog(LogIn_Register.this,
							"El nombre de usuario introducido aún no está registrado", "Cuidado",
							JOptionPane.ERROR_MESSAGE);
				} else {
					if (!BDbarbestialDAO.getbarbestialDAO().contraseñaCorrecta(getTextField().getText(),
							new String(getPasswordField().getPassword()))) {
						JOptionPane.showMessageDialog(LogIn_Register.this, "La contraseña es incorrecta", "Cuidado",
								JOptionPane.ERROR_MESSAGE);

					} else {
						Partida.getPartida().setNombre(getTextField().getText());
						Interfaz1.main(null);
						dialog.setVisible(false);
					}
				}
			}
		}

	}
}
