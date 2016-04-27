package diazPallares;

import processing.core.PApplet;

@SuppressWarnings("serial")
public class Ejecutable extends PApplet{
	private Logica logica;
	public void setup(){
		size(1280, 720);
		logica = new Logica(this);
		
	}
	public void draw(){
		background(69);
		logica.draw();
	}
	public void mousePressed(){
		logica.mousePressed(mouseX, mouseY);
	}
	static public void main(String[] passedArgs) {
		String[] appletArgs = new String[] { "Ejecutable" };
		if (passedArgs != null) {
			PApplet.main(concat(appletArgs, passedArgs));
		} else {
			PApplet.main(appletArgs);
		}
	}

}
