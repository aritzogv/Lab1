package pack;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class BDbarbestialDAO {
	private static BDbarbestialDAO mbarbestialDAO = new BDbarbestialDAO();
	private Connection con;

	private BDbarbestialDAO() {
		// TODO Auto-generated constructor stub
	}

	public static BDbarbestialDAO getbarbestialDAO() {
		return mbarbestialDAO;
	}

	private void ensureConnected() throws BDErrorConexion {
		if (con == null) {
			synchronized (this) {
				if (con == null) {
					try {
						Class.forName("org.sqlite.JDBC");
					} catch (ClassNotFoundException e1) {
					}
					;
					try {
						String url = "jdbc:sqlite:./barbestial.db";
						con = DriverManager.getConnection(url);
					} catch (SQLException e) {
						con = null;
						throw new BDErrorConexion(e);
					}
				}
			}
		}
	}

	public int getNumFilas() {
		try {
			ensureConnected();
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery("SELECT count(*) as numUsuarios from registro");
			return rs.getInt("numUsuarios");

		} catch (BDErrorConexion e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return 0;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return 0;
		}
	}

	public List<BDInfoUsuario> getInfoUsuarios() {
		List<BDInfoUsuario> result = new ArrayList<>();
		try {
			ensureConnected();
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery("SELECT usuario,puntuacion from registro");
			ResultSetMetaData metadata = rs.getMetaData();
			// Procesar el resultset y añadir los datos
			while (rs.next()) {
				BDInfoUsuario infousu = new BDInfoUsuario();
				for (int i = 1; i <= metadata.getColumnCount(); i++) {
					if (rs.getObject(i) != null) {
						infousu.addDato(rs.getObject(i).toString());
					}
					else {
						infousu.addDato("");
					}
				}
				// Añadir la información a la lista
				result.add(infousu);

			}

		} catch (BDErrorConexion e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
	public void resgistrar(String pUsu, String pContra) {
		try {
			ensureConnected();
			Statement st = con.createStatement();
			int rs = st.executeUpdate("Insert into registro values('" + pUsu + "','" + pContra + "', 0)");

		} catch (BDErrorConexion e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void registrarPuntuacion(String pUsu, int pPunt) {
		try {
			ensureConnected();
			Statement st = con.createStatement();
			int rs = st.executeUpdate("Update registro set puntuacion = '" + pPunt + "' where usuario = '" + pUsu + "'");
			System.out.println("Puntuaci�n actualizada correctamente");
		} catch (BDErrorConexion e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public boolean contrase�aCorrecta(String pUsu, String pContra) {
		boolean result = false;
		try {
			ensureConnected();
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery("SELECT * from registro where usuario = '" + pUsu +"'");
			if(pContra.equals(rs.getString("contrase�a"))){
				result = true;
			}
			return result;

		} catch (BDErrorConexion e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
	public boolean existeUsuario(String pUsu) {
		boolean result = false;
		try {
			ensureConnected();
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery("SELECT * from registro");
			while(rs.next()) {
				if(pUsu.equals(rs.getString("usuario"))) {
					result = true;
				}
			}
			return result;
		} catch (BDErrorConexion e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}

	public List<BDInfoColumna> getMetaDatosUsuarios() {
		List<BDInfoColumna> result = new ArrayList<>();
		try {
			ensureConnected();
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery("SELECT usuario,puntuacion from registro");
			ResultSetMetaData metadata = rs.getMetaData();
			// Processar el resultset y añadir los datos
			int columns = metadata.getColumnCount();
			for (int i = 1; i <= columns; i++) {
				BDInfoColumna infoColumna = new BDInfoColumna(metadata.getColumnName(i), metadata.getColumnTypeName(i));
				result.add(infoColumna);

			}
			return result;

		} catch (BDErrorConexion e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
}
