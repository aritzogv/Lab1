package pack;
import java.util.List;

import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableModel;


public class BDModeloDatosTabla extends AbstractTableModel implements TableModel {
	/**
	 * 
	 */
	private static final long serialVersionUID = -888159143785688949L;
	private BDbarbestialDAO daoSocios = BDbarbestialDAO.getbarbestialDAO();
	private int numFilas;
	private int numColumnas;
	private List<BDInfoUsuario> infousuarios;
	private List<BDInfoColumna> infoCabecera;
	
	@Override
	public int getColumnCount() {
		ensureDataLoaded();
		return numColumnas;
	}

	@Override
	public int getRowCount() {
		ensureDataLoaded();
		return numFilas;
	}

	@Override
	public Object getValueAt(int arg0, int arg1) {
		ensureDataLoaded();
		if(arg0 < getRowCount() && arg1 < getColumnCount() && arg0 >= 0 && arg1 >= 0){
			return infousuarios.get(arg0).getDato(arg1);
		}else{
			return "--";
		}
		
	}
	@Override
	public String getColumnName(int column){
		ensureDataLoaded();
		if(column >= 0 && column < getColumnCount()){
			return infoCabecera.get(column).getNombre();
		} else{
			return "UNKNOWN";
		}
		
	}
	@Override
	public Class<?> getColumnClass(int columnIndex){
		if(columnIndex >= 0 && columnIndex < getColumnCount()){
			String tipo = infoCabecera.get(columnIndex).getTipo();
			if(tipo.equals("INT")){
				return Integer.class;
			}else{
				return String.class;
			}
		}else{
			return String.class;
		}
	}
	private void ensureDataLoaded(){
		if(infoCabecera == null){
			synchronized (this) {
				if(infoCabecera == null){
					infoCabecera = daoSocios.getMetaDatosUsuarios();
					infousuarios = daoSocios.getInfoUsuarios();
					numFilas = infousuarios.size();
					numColumnas = infoCabecera.size();
				}
			}
		}
	}
	public void addUsuario(BDInfoUsuario pUsu){
		infousuarios.add(pUsu);
		numFilas++;
		fireTableRowsInserted(numFilas -1,numFilas );
	}
}



	