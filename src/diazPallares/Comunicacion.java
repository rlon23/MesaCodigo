package diazPallares;

import java.util.Arrays;

import processing.core.PApplet;
import processing.serial.Serial;

public class Comunicacion {
	private Serial puerto;
	public Boolean enviar, crearNuevo;
	private PApplet app;
	private int pesas[];
	public Comunicacion(PApplet app){
		this.app = app;
		pesas = new int[6];
		String nombrePuerto = Serial.list()[1];
		puerto = new Serial(this.app, nombrePuerto, 9600);
	}
	public void leer(){
		if(puerto.available() > 0){
			String mensaje = puerto.readStringUntil('\n');
			if(mensaje != null){
				mensaje = mensaje.trim();
				if(mensaje.startsWith("reset")){
					crearNuevo = true;
					System.out.println("crearNuevo: " + crearNuevo);
				}
				if(mensaje.startsWith("pesas")){
					String[] partes = PApplet.split(mensaje, " ");
					//System.out.println(Arrays.toString(partes));
					for(int i=0; i< partes.length-1; i++){
						pesas[i] = Integer.parseInt(partes[i+1]);
					}
					System.out.println("Pesas" + Arrays.toString(pesas));					
				}
				
			}
		}
	}
	public void enviar(String s){
		puerto.write(s+"\n");
		app.delay(5000);
	}
	public Boolean getCrearNuevo(){
		return crearNuevo;
	}
	public void setCrearNuevo(Boolean b){
		crearNuevo = b;
	}
	public int[]getPesas(){
		return pesas;		
	}
}