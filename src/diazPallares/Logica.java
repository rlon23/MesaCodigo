package diazPallares;

import processing.core.PApplet;

public class Logica {
	private PApplet app;
	private Comunicacion com;
	private Interfaz interfaz;
	private Alimento arroz;
	private String pesas[];
	private String guardar[];
	private int usuario;
	public Logica(PApplet p){
		app = p;
		usuario = 0;
		com = new Comunicacion(app);
		interfaz = new Interfaz(app);
		arroz = new Alimento(1);
		pesas = new String[7];
		guardar = new String[16];
	}

	public void draw() {
		com.leer();
		pesas=com.getPesas();
		//app.delay(1000);
		//System.out.println("Pesas" + Arrays.toString(pesas));
		arroz.Ejecutar(pesas[0]);
		guardaInfo();
		interfaz.Ejecutar(pesas);
		//System.out.println("Pesas" + Arrays.toString(pesas));
	}
	public void guardaInfo(){
		if(com.getCrearNuevo()==true){
			//guardar valores en txt.
			guardar[0]="usuario_"+Integer.toString(usuario);
			guardar[1]="hora_"+PApplet.hour()+":"+PApplet.minute();
			for(int i=0; i<7; i++){
				guardar[i+2]="gramos_"+pesas[i];
			}
			guardar[9]="calorias_"+Integer.toString(arroz.getCalorias());
			guardar[10]="calorias_";
			guardar[11]="calorias_";
			guardar[12]="calorias_";
			guardar[13]="calorias_";
			guardar[14]="calorias_";
			guardar[15]="calorias_";
			app.saveStrings("usuario_"+usuario+".txt", guardar);
			usuario++;
			com.setCrearNuevo(false);
		}
	}

	public void mousePressed(int mouseX, int mouseY) {
		com.enviar("reiniciar");		
	}
}
