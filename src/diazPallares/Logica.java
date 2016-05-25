package diazPallares;

import java.util.Arrays;

import processing.core.PApplet;

public class Logica {
	private PApplet app;
	private Comunicacion com;
	private Interfaz interfaz;
	private String pesas[];
	public Logica(PApplet p){
		app = p;
		com = new Comunicacion(app);
		interfaz = new Interfaz(app);
		pesas = new String[6];
	}

	public void ejecutar() {
		com.leer();
		pesas=com.getPesas();		
		System.out.println("Pesas" + Arrays.toString(pesas));
		interfaz.Ejecutar(pesas);
	}	

	public void mousePressed(int mouseX, int mouseY) {
		interfaz.mousePressed(mouseX, mouseY);		
	}
}
