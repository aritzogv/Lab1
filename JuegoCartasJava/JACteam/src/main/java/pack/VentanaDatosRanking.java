package pack;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.TableModel;
import javax.swing.JPanel;
import javax.swing.JButton;

public class VentanaDatosRanking extends JFrame {
	private static final long serialVersionUID = 7098079791618926224L;
	private JScrollPane scrollPane;
	private JTable table;
	private TableModel modeloDatosTabla;
	private JPanel panel;
	private JButton btnNewButton;

	/**
	 * Create the frame.
	 * 
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaDatosRanking frame = new VentanaDatosRanking();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public VentanaDatosRanking() {

		initialize();
	}

	private void initialize() {
		setTitle("Ranking general");
		setBounds(100, 100, 450, 300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().add(getScrollPane(), BorderLayout.CENTER);
		// getContentPane().add(getTable(), BorderLayout.NORTH);
		getContentPane().add(getPanel(), BorderLayout.SOUTH);

	}

	private JScrollPane getScrollPane() {
		if (scrollPane == null) {
			scrollPane = new JScrollPane();
			scrollPane.setViewportView(getTable());
		}
		return scrollPane;
	}

	private JTable getTable() {
		if (table == null) {

			table = new JTable(getModeloDatosTabla());
			table.setFillsViewportHeight(true);
		}
		return table;
	}

	private TableModel getModeloDatosTabla() {
		if (modeloDatosTabla == null) {
			modeloDatosTabla = new BDModeloDatosTabla();
		}
		return modeloDatosTabla;
	}

	private JPanel getPanel() {
		if (panel == null) {
			panel = new JPanel();
		}
		return panel;
	}

}
