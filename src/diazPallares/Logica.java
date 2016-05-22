package diazPallares;

import java.util.Arrays;

import processing.core.PApplet;

public class Logica {
	private PApplet app;
	private Comunicacion com;
	private Interfaz interfaz;
	private String pesas[];
	private int escena;
	public Logica(PApplet p){
		escena =0;
		app = p;
		com = new Comunicacion(app);
		interfaz = new Interfaz(app);
		pesas = new String[6];
	}

	public void ejecutar() {
		com.leer();
		pesas=com.getPesas();		
		System.out.println("Pesas" + Arrays.toString(pesas));
		interfaz.Ejecutar(pesas, escena);
		guardaInfo();
	}
	public void guardaInfo(){
		if(com.getCrearNuevo()==true){
			interfaz.guardarInfo();			
			com.setCrearNuevo(false);
		}
		//guardarPesos iniciales nuevos
		if(com.getNuevoPeso()==true){
			//asigna el peso en los sensores al valor pesoInicial de Alimentos.
		}
	}

	public void mousePressed(int mouseX, int mouseY) {
		if(escena==0 && interfaz.usuario()){
			escena = 1;
		}	
		if(escena == 1){
			interfaz.guardarInfo();
		}
	}
}
