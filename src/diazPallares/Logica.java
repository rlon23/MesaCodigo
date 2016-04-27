package diazPallares;

import java.util.Arrays;

import processing.core.PApplet;

public class Logica {
	private Comunicacion com;
	private int pesas[];
	public Logica(PApplet p){
		com = new Comunicacion(p);
		pesas = new int[6];
	}

	public void draw() {
		com.leer();
		pesas=com.getPesas();
		//System.out.println("Pesas" + Arrays.toString(pesas));
	}

	public void mousePressed(int mouseX, int mouseY) {
		com.enviar("reiniciar");		
	}
}
