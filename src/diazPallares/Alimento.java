package diazPallares;

public class Alimento {
	private int peso, tipo, calorias;
	public Alimento(int n) {
		calorias = 0;
	}
	public void Ejecutar(String p){
		if(p != null){
			peso = Integer.parseInt(p);
		}
		switch(tipo){
		case 0:
			//arroz
			calorias = (int) (peso*1.5);
			//calcula caloria de acuerdo al peso y tipo de alimento.
			break;
		case 1:
			//
			//calcula caloria de acuerdo al peso y tipo de alimento.
			break;
		case 2:
			//
			//calcula caloria de acuerdo al peso y tipo de alimento.
			break;
		case 3:
			//
			//calcula caloria de acuerdo al peso y tipo de alimento.
			break;
			
		}
	}
	public int getCalorias(){
		return calorias;
	}
	public int getPeso(){
		return peso;
	}
	

}
