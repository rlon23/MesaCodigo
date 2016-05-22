package diazPallares;

import processing.core.PApplet;

public class Alimento {
	private PApplet app;
	private int tipo;
	private float pesoInicial, pesoFinal, peso, cal;
	public Alimento(PApplet app,int n) {
		this.app = app;
		cal = 0;
		pesoInicial =0;
		peso = 0;
		pesoFinal = 0;
		tipo=n;
	}
	public void ejecutar(String p){
		peso = Float.parseFloat(p);
		pesoFinal = pesoInicial-peso;
		System.out.println("pesoInicial: "+pesoInicial);
		switch(tipo){
		case 1:
			//pollo 1.34caloria x gramo			
			//calcula caloria de acuerdo al peso y tipo de alimento.
			cal = pesoFinal*1.34f;
			//poner condiciones de calorias
			if(cal<70f){
				app.fill(255,221,0);
			}
			if(cal>70f && cal<167.5f){
				app.fill(0,175,100);
			}
			if(cal>167.5f && cal<210f){
				app.fill(255,221,0);
			}
			if(cal>210f){
				app.fill(213,25,32);
			}
			//verde app.fill(0,175,100);
			//amarillo app.fill(255,221,0);
			//rojo app.fill(213,25,32);
			app.ellipse(325, 368, 177, 177);
			
			break;
		case 2:
			//papa 1.5caloria x gramo
			cal = pesoFinal*1.5f;
			//poner condiciones de calorias
			if(cal<90f){
				app.fill(255,221,0);
			}
			if(cal>90f && cal<180f){
				app.fill(255,221,0);
			}
			if(cal>180f){
				app.fill(213,25,32);
			}
			app.ellipse(446, 202, 177, 177);
			break;
		case 3:
			//ensalada 0.87 caloria x gramo
			cal = pesoFinal*0.87f;
			//poner condiciones de calorias
			if(cal<59.3f){
				app.fill(255,221,0);
			}
			if(cal>59.3f && cal<130f){
				app.fill(0,175,100);
			}
			if(cal>130f && cal<240f){
				app.fill(255,221,0);
			}
			if(cal>240f){
				app.fill(213,25,32);
			}
			app.ellipse(640, 138, 177, 177);
			break;
		case 4:
			//lenteja 3.36 caloria x gramo
			cal = pesoFinal*3.36f;
			//poner condiciones de calorias
			if(cal<150f){
				app.fill(255,221,0);
			}
			if(cal>150f && cal<201f){
				app.fill(0,175,100);
			}
			if(cal>201f && cal<300f){
				app.fill(255,221,0);
			}
			if(cal>300f){
				app.fill(213,25,32);
			}
			app.ellipse(831, 202, 177, 177);
			break;
		case 5:
			//arroz 3.54 caloria x gramo
			cal = pesoFinal*3.54f;
			//poner condiciones de calorias
			if(cal<30f){
				app.fill(255,221,0);
			}
			if(cal>30f && cal<70f){
				app.fill(0,175,100);
			}
			if(cal>70f && cal<100f){
				app.fill(255,221,0);
			}
			if(cal>100f){
				app.fill(213,25,32);
			}
			app.ellipse(953, 368, 177, 177);
			
			break;			
		}
	}
	public float getCalorias(){
		return cal;
	}
	public void setPesoInicial(String pI){
		pesoInicial = Float.parseFloat(pI);
	}
	public float getPesoF(){
		return pesoFinal;
	}

}
