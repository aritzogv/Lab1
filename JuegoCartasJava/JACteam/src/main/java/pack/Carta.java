package pack;
public class Carta {

	private int num;
	private Color color;
	private Animal animal;
	private String nombre;
	private boolean ultimaJugada = true;
	private Animalada animalada;
	/**
	 * 
	 * @param pColor
	 * @param pNum
	 */
	public Carta(Color pColor, int pNum) {
		color = pColor;
		num = pNum;
		switch(pNum) {
		case 1:
			animal = Animal.MOFETA;
			animalada = new Mofeta1();
			break;
		case 2:
			animal = Animal.LORO;
			animalada = new Loro2();
			break;
		case 3:
			animal = Animal.CANGURO;
			animalada = new Canguro3();
			break;
		case 4:
			animal = Animal.MONO;
			animalada = new Mono4();
			break;
		case 5:
			animal = Animal.CAMALEON;
			animalada = new Camaleon5(this);
			break;
		case 6:
			animal = Animal.FOCA;
			animalada = new Foca6();
			break;
		case 7:
			animal = Animal.CEBRA;
			animalada = null;
			break;
		case 8:
			animal = Animal.JIRAFA;
			animalada = new Jirafa8(this);
			break;	
		case 9:
			animal = Animal.SERPIENTE;
			animalada = new Serpiente9();
			break;
		case 10:
			animal = Animal.COCODRILO;
			animalada = new Cocodrilo10(this);
			break;
		case 11:
			animal = Animal.HIPOPOTAMO;
			animalada = new Hipopotamo11(this);
			break;
		case 12:
			animal = Animal.LEON;
			animalada = new Leon12();
			break;
		}
		nombre="/"+animal+color+".png";
		// TODO - implement Carta.Carta
	}
	public int getNum(){
		return num;
	}
	public Color getColor(){
		return color;
	}
	public boolean getUltimaJugada() {
		return ultimaJugada;
	}
	public void noUltimaJugada() {
		ultimaJugada = false;
	}
	public void realizarAnimalada() {
		if(animal!=Animal.CEBRA){
		animalada.realizarAnimalada();
		}
	}
	public String getNombre() {
		return nombre;
	}

}