package diazPallares;

import java.util.ArrayList;
import java.util.Arrays;

import processing.core.PApplet;
import processing.core.PConstants;

public class Interfaz {
	private PApplet app;
	private int totalCalorias, escena;
	private int uno, dos, tres, cuatro, cinco, seis, siete;
	private float pUno, pDos, pTres, pCuatro, pCinco, pSeis, pSiete, totalGramos;
	private String guardar[];
	private String usuario;
	private Alimento aUno, aDos, aTres, aCuatro, aCinco;
	private boolean inicial;
	public Interfaz(PApplet app) {
		this.app = app;
		escena = 0;
		totalGramos = 0;
		totalCalorias = 0;
		inicial = true;
		aUno = new Alimento(1);
		aDos = new Alimento(2);
		aTres = new Alimento(3);
		aCuatro = new Alimento(4);
		aCinco = new Alimento(5);
		uno = 0;
		dos = 0;
		tres = 0;
		cuatro = 0;
		cinco = 0;
		seis = 0;
		siete = 0;
		pUno = 0;
		pDos = 0;
		pTres = 0;
		pCuatro = 0;
		pCinco = 0;
		pSeis = 0;
		pSiete = 0;
		usuario ="";
		guardar = new String[16];
	}

	public void Ejecutar(String[] pesos, int escena) {
		this.escena = escena;
		switch (escena) {
		case 0:
			break;
		case 1:
			calcularPorcentajes(pesos);
			break;

		}
	}
	public void calcularPorcentajes(String[] pesos) {
		if (pesos[0] != null) {
			/*uno = Integer.parseInt(pesos[0]);
			dos = Integer.parseInt(pesos[1]);
			tres = Integer.parseInt(pesos[2]);
			cuatro = Integer.parseInt(pesos[3]);
			cinco = Integer.parseInt(pesos[4]);
			seis = Integer.parseInt(pesos[5]);//plato
			siete = Integer.parseInt(pesos[6]);//no
			totalGramos = uno + dos + tres + cuatro + cinco;*/			
			// System.out.println("totalGramos: " + totalGramos);
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
		//valores para torta
		pUno = PApplet.map(aUno.getPesoF(), 0, totalGramos, 0, 360);
		pDos = PApplet.map(aDos.getPesoF(), 0, totalGramos, 0, 360);
		pTres = PApplet.map(aTres.getPesoF(), 0, totalGramos, 0, 360);
		pCuatro = PApplet.map(aCuatro.getPesoF(), 0, totalGramos, 0, 360);
		pCinco = PApplet.map(aCinco.getPesoF(), 0, totalGramos, 0, 360);
		torta();

	}	
	public void guardarInfo() {
		//guardar valores en txt.
		guardar[0]="usuario_"+usuario;
		guardar[1]="hora_"+PApplet.hour()+":"+PApplet.minute();
		/*for(int i=0; i<7; i++){
			guardar[i+2]="gramos_"+pesas[i];
		}*/
		//guardar[9]="calorias_"+Float.toString(arroz.getCalorias());
		guardar[10]="calorias_";
		guardar[11]="calorias_";
		guardar[12]="calorias_";
		guardar[13]="calorias_";
		guardar[14]="calorias_";
		guardar[15]="calorias_";
		app.saveStrings("usuario_"+usuario+".txt", guardar);
	}
	public void setInicial(boolean b){
		inicial=true;
	}
	public void torta() {
		int[] colores = { app.color(255, 0, 0), app.color(0, 255, 0), app.color(0, 0, 255), app.color(255, 255, 0),	app.color(0, 255, 255)};
		// int[] angles = {30, 10, 45, 35, 60, 38, 75, 67 };
		float[] angles = { pUno, pDos, pTres, pCuatro, pCinco };
		// System.out.println(Arrays.toString(angles));
		float lastAngle = 0;
		for (int i = 0; i < angles.length; i++) {
			app.noStroke();
			app.fill(colores[i]);
			app.arc(640, 360, 500, 500, lastAngle, lastAngle + PApplet.radians(angles[i]), PConstants.PIE);
			lastAngle += PApplet.radians(angles[i]);
		}
	}

}
