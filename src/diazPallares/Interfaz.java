package diazPallares;

import controlP5.ControlP5;
import controlP5.Textfield;
import processing.core.PApplet;
import processing.core.PConstants;
import processing.core.PFont;
import processing.core.PImage;

public class Interfaz {
	private PApplet app;
	private int escena;
	private float pUno, pDos, pTres, pCuatro, pCinco, plato, totalGramos, totalCalorias;
	private String guardar[];
	private Alimento aUno, aDos, aTres, aCuatro, aCinco;
	private boolean inicial;
	private ControlP5 cp5;
	private PFont font;
	private PImage fondoUno, fondoDos;
	private String usuario;
	public Interfaz(PApplet app) {
		this.app = app;
		escena = 0;
		totalGramos = 0f;
		totalCalorias = 0f;
		inicial = true;
		aUno = new Alimento(this.app,1);
		aDos = new Alimento(this.app,2);
		aTres = new Alimento(this.app,3);
		aCuatro = new Alimento(this.app,4);
		aCinco = new Alimento(this.app,5);
		pUno = 0;
		pDos = 0;
		pTres = 0;
		pCuatro = 0;
		pCinco = 0;
		plato = 0;
		usuario = "";
		guardar = new String[10];
		fondoUno = app.loadImage("../data/fondoUno.png");
		fondoDos = app.loadImage("../data/fondoDos.png");
		font = app.createFont("arial", 48);
		cp5 = new ControlP5(app);
		cp5.addTextfield("usuario")
		.setPosition(340, 449)
		.setSize(600,60)
		.setFocus(true)
		.setFont(font)
		.setCaptionLabel("")
		.setColor(app.color(0))
		.setColorBackground(app.color(200))
		.setAutoClear(false)
		;
	}

	public void Ejecutar(String[] pesos, int escena) {
		this.escena = escena;
		switch (this.escena) {
		case 0:
			app.image(fondoUno,0,0);
			break;
		case 1:
			app.image(fondoDos,0,0);
			cp5.get("usuario").hide();
			calcularPorcentajes(pesos);
			break;
		}
	}
	public void calcularPorcentajes(String[] pesos) {
		
		if (pesos[0] != null) {
			if(inicial==true){//guarda el peso inicial
				aUno.setPesoInicial(pesos[0]);
				aDos.setPesoInicial(pesos[1]);
				aTres.setPesoInicial(pesos[2]);
				aCuatro.setPesoInicial(pesos[3]);
				aCinco.setPesoInicial(pesos[4]);
				inicial = false;
			}
			aUno.ejecutar(pesos[0]);
			aDos.ejecutar(pesos[1]);
			aTres.ejecutar(pesos[2]);
			aCuatro.ejecutar(pesos[3]);
			aCinco.ejecutar(pesos[4]);
			totalGramos = aUno.getPesoF()+aDos.getPesoF()+aTres.getPesoF()+aCuatro.getPesoF()+aCinco.getPesoF();
		}

		plato = Float.parseFloat(pesos[5]);
		totalCalorias = aUno.getCalorias()+aDos.getCalorias()+aTres.getCalorias()+aCuatro.getCalorias()+aCinco.getCalorias();
		//valores para torta
		pUno = PApplet.map(PApplet.abs(aUno.getCalorias()), 0, totalCalorias, 0, 360);
		pDos = PApplet.map(PApplet.abs(aDos.getCalorias()), 0, totalCalorias, 0, 360);
		pTres = PApplet.map(PApplet.abs(aTres.getCalorias()), 0, totalCalorias, 0, 360);
		pCuatro = PApplet.map(PApplet.abs(aCuatro.getCalorias()), 0, totalCalorias, 0, 360);
		pCinco = PApplet.map(PApplet.abs(aCinco.getCalorias()), 0, totalCalorias, 0, 360);
		torta();

	}	
	public void guardarInfo() {
		//guardar valores en txt.
		String hora=PApplet.hour()+"_"+PApplet.minute();		
		guardar[0]="usuario: "+usuario;
		guardar[1]="hora: "+PApplet.hour()+"-"+PApplet.minute();
		guardar[2]="pesoTotal: "+totalGramos;
		guardar[3]="pollo: "+aUno.getPesoF()+"g cal: "+aUno.getCalorias();
		guardar[4]="papa: "+aDos.getPesoF()+"g cal: "+aDos.getCalorias();
		guardar[5]="ensalada: "+aTres.getPesoF()+"g cal: "+aTres.getCalorias();
		guardar[6]="lenteja: "+aCuatro.getPesoF()+"g cal: "+aCuatro.getCalorias();;
		guardar[7]="arroz: "+aCinco.getPesoF()+"g cal: "+aCinco.getCalorias();
		guardar[8]="caloriasTotal: "+totalCalorias;
		guardar[9]="pesoEnPlato "+plato;
		app.saveStrings("../data/"+hora+"-"+usuario+".txt", guardar);
	}
	public void reiniciar(){
		inicial=true;
		cp5.get(Textfield.class,"usuario").clear();
		cp5.get(Textfield.class,"usuario").show();
	}
	public boolean usuario(){
		usuario=cp5.get(Textfield.class,"usuario").getText();
		if(!usuario.isEmpty()){
			return true;
		}
		return false;
	}
	public void torta() {
		int[] colores = { app.color(224, 80, 76), app.color(235, 111, 36), app.color(30, 101, 80), app.color(107, 75, 44),	app.color(251, 227, 169)};
		// int[] angles = {30, 10, 45, 35, 60, 38, 75, 67 };
		float[] angles = { pUno, pDos, pTres, pCuatro, pCinco };
		// System.out.println(Arrays.toString(angles));
		float lastAngle = 0;
		for (int i = 0; i < angles.length; i++) {
			app.noStroke();
			app.fill(colores[i]);
			app.arc(640, 468, 445, 445, lastAngle, lastAngle + PApplet.radians(angles[i]), PConstants.PIE);
			lastAngle += PApplet.radians(angles[i]);
		}
	}

}
