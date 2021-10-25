package mainGame;

import javafx.scene.image.Image;

public class Sprite {
	
	private double x;
	private double y;
	private Image image;

	public Sprite(Image image, double x, double y) {
		// TODO Auto-generated constructor stub
		this.image = image;
		this.x = x;
		this.y = y;
	}
	
	public double getX() {
		return this.x;
	}
	
	public double getY() {
		return this.y;
	}

}
