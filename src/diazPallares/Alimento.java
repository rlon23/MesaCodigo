package diazPallares;

public class Alimento {
	private int tipo;
	private float pesoInicial, pesoFinal, peso, calorias;
	public Alimento(int n) {
		calorias = 0;
		pesoInicial =0;
		peso = 0;
		pesoFinal = 0;
	}
	public void ejecutar(String p){
		peso = Float.parseFloat(p);
		pesoFinal = pesoInicial-peso;
		System.out.println("pesoInicial: "+pesoInicial);
		switch(tipo){
		case 1:
			//arroz
			calorias = (float) (peso*1.5);
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
		case 4:
			//
			//calcula caloria de acuerdo al peso y tipo de alimento.
			break;
		case 5:
			//
			//calcula caloria de acuerdo al peso y tipo de alimento.
			break;			
		}
	}
	public float getCalorias(){
		return calorias;
	}
	public void setPesoInicial(String pI){
		pesoInicial = Float.parseFloat(pI);
	}
	public float getPesoF(){
		return pesoFinal;
	}

}
