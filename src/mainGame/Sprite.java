package mainGame;

import java.util.ArrayList;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

public class Sprite extends ImageView{
	
	public double x;
	public double y;
	private double width;
	private double height;
	public ArrayList<Image> spriteImages;

	public Sprite(ArrayList<Image> spriteImages, double x, double y) {
		// TODO Auto-generated constructor stub
		this.x = x;
		this.y = y;
		this.setX(this.x);
		this.setY(this.y);
		this.spriteImages = spriteImages;
		this.setImage(spriteImages.get(0));
		this.width = this.getImage().getWidth();
		this.height = this.getImage().getHeight();
		
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
