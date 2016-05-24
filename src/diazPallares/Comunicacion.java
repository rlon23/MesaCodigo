package diazPallares;

import java.util.Arrays;

import processing.core.PApplet;
import processing.serial.Serial;

public class Comunicacion {
	private Serial puerto;
	public Boolean enviar, crearNuevo, nuevoPeso;
	private PApplet app;
	private String pesas[];
	public Comunicacion(PApplet app){
		this.app = app;
		pesas = new String[6];
		String nombrePuerto = Serial.list()[1];
		puerto = new Serial(this.app, nombrePuerto, 19200);
		crearNuevo = false;
		nuevoPeso = false;
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
					//System.out.println(Arrays.toString(pesas));
					pesas[0]=partes[1];
					pesas[1]=partes[2];
					pesas[2]=partes[3];
					pesas[3]=partes[4];
					pesas[4]=partes[5];
					pesas[5]=partes[6];
					/*for(int i=0; i< partes.length-1; i++){
						pesas[i] = partes[i+1];
					}*/
					System.out.println("Pesas" + Arrays.toString(pesas));					
				}
				if(mensaje.startsWith("nuevoPeso")){
					crearNuevo = true;
					System.out.println("nuevoPeso: " +nuevoPeso);
				}
				
			}
		}
	}
	public void enviar(String s){
		puerto.write(s+"\n");
		app.delay(500);
	}
	public Boolean getCrearNuevo(){
		return crearNuevo;
	}
	public Boolean getNuevoPeso(){
		return nuevoPeso;
	}
	public void setCrearNuevo(Boolean b){
		crearNuevo = b;
	}
	public String[]getPesas(){
		return pesas;		
	}
}
