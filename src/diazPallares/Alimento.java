package diazPallares;

import processing.core.PApplet;
import processing.core.PFont;

public class Alimento {//CARTON REVERSO BLANCO
	private PApplet app;
	private int tipo;
	private float pesoInicial, pesoFinal, peso, cal;
	private int amarillo, verde, rojo;
	private PFont fuente;
	public Alimento(PApplet app,int n) {
		fuente = app.loadFont("../data/MyriadPB.vlw");
		this.app = app;
		cal = 0;
		pesoInicial =0;
		peso = 0;
		pesoFinal = 0;
		tipo=n;
		amarillo = app.color(255,221,0);
		verde = app.color(0,175,100);
		rojo = app.color(213,25,32);
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
			if(cal<91.8f){
				app.fill(255);
			}
			if(cal>91.8f && cal<160.8f){
				app.fill(amarillo);
			}
			if(cal>160.8f && cal<183.7f){
				app.fill(verde);
			}
			if(cal>183.7f){
				app.fill(rojo);
			}
			app.ellipse(645, 548, 177, 177);
			app.textFont(fuente,24);
			app.fill(33);
			app.text(pesoFinal+"g", 617, 545);
			app.text((int)cal+" cal", 606, 578);
			
			break;
		case 2:
			//papa 1.5caloria x gramo
			cal = pesoFinal*1.5f;
			//poner condiciones de calorias
			if(cal<60f){
				app.fill(255);
			}
			if(cal>60f && cal<105f){
				app.fill(amarillo);
			}
			if(cal>105f && cal<120f){
				app.fill(verde);
			}
			if(cal>120f){
				app.fill(rojo);
			}
			app.ellipse(766, 382, 177, 177);
			app.fill(33);
			app.text(pesoFinal+"g", 737, 379);
			app.text((int)cal+" cal", 727, 412);
			break;
		case 3:
			//ensalada 0.87 caloria x gramo
			cal = pesoFinal*0.87f;
			//poner condiciones de calorias
			if(cal<69.6f){
				app.fill(255);
			}
			if(cal>69.6f && cal<121.8f){
				app.fill(amarillo);
			}
			if(cal>121.8f && cal<139.2f){
				app.fill(verde);
			}
			if(cal>139.2f){
				app.fill(rojo);
			}
			app.ellipse(960, 318, 177, 177);
			app.fill(33);
			app.text(pesoFinal+"g", 931, 315);
			app.text((int)cal+" cal", 921, 348);
			break;
		case 4:
			//lenteja 3.36 caloria x gramo
			cal = pesoFinal*3.36f;
			//poner condiciones de calorias
			if(cal<134.4f){
				app.fill(255);
			}
			if(cal>134.4f && cal<235.2f){
				app.fill(amarillo);				
			}
			if(cal>235.2f && cal<268.8f){
				app.fill(verde);
			}
			if(cal>268.8f){
				app.fill(rojo);
			}
			app.ellipse(1151, 382, 177, 177);
			app.fill(33);
			app.text(pesoFinal+"g", 1122, 379);
			app.text((int)cal+" cal", 1112, 412);
			break;
		case 5:
			//arroz 1.3 caloria x gramo
			cal = pesoFinal*1.3f;
			//poner condiciones de calorias
			if(cal<44.57f){
				app.fill(255);
			}
			if(cal>44.57f && cal<78f){
				app.fill(amarillo);
			}
			if(cal>78f && cal<89.14f){
				app.fill(verde);
			}
			if(cal>89.14f){
				app.fill(rojo);
			}
			app.ellipse(1273, 548, 177, 177);
			app.fill(33);
			app.text(pesoFinal+"g", 1244, 545);
			app.text((int)cal+" cal", 1234, 578);
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
