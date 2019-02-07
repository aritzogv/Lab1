package pack;
import java.util.ArrayList;
import java.util.List;

public class BDInfoUsuario {
	private List<String> info;
	
	public BDInfoUsuario() {
		info = new ArrayList<>();
	}
	
	public void addDato(String pDato) {
		info.add(pDato);
	}
	
	public String getDato(int pPos) {
		return info.get(pPos);
	}

}
