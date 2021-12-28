package mainGame;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

public class Sprite {
	
	public double x;
	public double y;
	private Image image;
	private double width;
	private double height;

	public Sprite(Image image, double x, double y) {
		// TODO Auto-generated constructor stub
		this.image = image;
		this.x = x;
		this.y = y;
		this.width = image.getWidth();
		this.height = image.getHeight();
		
	}
	
	public double getX() {
		return this.x;
	}
	
	public double getY() {
		return this.y;
	}
	
	public Image getImage() {
		return this.image;
	}
	
	public double getW() {
		return this.width;
	}
	
	public double getH() {
		return this.height;
	}
	
	public double getXCenter() {
		return this.x + this.width * 0.5;
	}
	
	public double getYCenter() {
		return this.y + this.height * 0.5;
	}
	
	public boolean touches(Sprite otherObject) {
		return (Math.abs(this.x - otherObject.x) <= this.getXCenter());
	}

}
