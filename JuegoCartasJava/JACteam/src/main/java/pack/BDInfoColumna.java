package pack;

public class BDInfoColumna {
	private String nombre;
	private String tipo;
	
	public String getNombre() {
		return nombre;
	}

	public String getTipo() {
		return tipo;
	}

	public BDInfoColumna(String nombre, String tipo) {
		super();
		this.nombre = nombre;
		this.tipo = tipo;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return String.format("%1$s<%2$s>", getNombre(), getTipo());
	}
}
