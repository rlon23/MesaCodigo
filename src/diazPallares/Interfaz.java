package diazPallares;

import java.util.ArrayList;
import java.util.Arrays;

import processing.core.PApplet;
import processing.core.PConstants;


public class Interfaz {
	private PApplet app;
	private int totalGramos, totalCalorias;
	private int uno, dos, tres, cuatro, cinco, seis, siete;
	private float pUno, pDos, pTres, pCuatro, pCinco, pSeis, pSiete;
	public Interfaz(PApplet app) {
		this.app = app;
		totalGramos = 0;
		totalCalorias = 0;
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
	}

	public void Ejecutar(String[] pesos) {
		if (pesos[0] != null) {
			uno = Integer.parseInt(pesos[0]);
			dos = Integer.parseInt(pesos[1]);
			tres = Integer.parseInt(pesos[2]);
			cuatro = Integer.parseInt(pesos[3]);
			cinco = Integer.parseInt(pesos[4]);
			seis = Integer.parseInt(pesos[5]);
			siete = Integer.parseInt(pesos[6]);
			totalGramos = uno + dos + tres + cuatro + cinco + seis + siete;
			calcularPorcentajes();
			segmento();
			System.out.println("totalGramos: " + totalGramos);
		}

	}

	public void calcularPorcentajes() {

		pUno = PApplet.map(uno, 0, totalGramos, 0, 360);
		pDos = PApplet.map(dos, 0, totalGramos, 0, 360);
		pTres = PApplet.map(tres, 0, totalGramos, 0, 360);
		pCuatro = PApplet.map(cuatro, 0, totalGramos, 0, 360);
		pCinco = PApplet.map(cinco, 0, totalGramos, 0, 360);
		pSeis = PApplet.map(seis, 0, totalGramos, 0, 360);
		pSiete = PApplet.map(siete, 0, totalGramos, 0, 360);

	}	

	public void segmento() {
		int[] colores = {app.color(255,0,0),app.color(0,255,0),app.color(0,0,255),app.color(255,255,0),app.color(0,255,255),app.color(255,0,255), app.color(255)};
		//int[] angles = {30, 10, 45, 35, 60, 38, 75, 67 };
		float[] angles = { pUno, pDos, pTres, pCuatro, pCinco, pSeis, pSiete };
		//System.out.println(Arrays.toString(angles));
		float lastAngle = 0;
		  for (int i = 0; i < angles.length; i++) {
		    app.fill(colores[i]);
		    app.arc(640, 360, 500, 500, lastAngle, lastAngle+PApplet.radians(angles[i]), PConstants.PIE);
		    lastAngle += PApplet.radians(angles[i]);
		  }
	}
}
