package mainGame;

import java.util.ArrayList;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

public class Sprite {
	
	public double x;
	public double y;
	private ImageView imageView;
	private ArrayList<Image> spriteImages;
	private double width;
	private double height;

	public Sprite(ImageView imageView, ArrayList<Image> spriteImages, double x, double y) {
		// TODO Auto-generated constructor stub
		this.imageView = imageView;
		this.x = x;
		this.y = y;
		this.setImage(spriteImages.get(0));
		this.width = imageView.getImage().getWidth();
		this.height = imageView.getImage().getHeight();
		
	}
	
	public double getX() {
		return this.x;
	}
	
	public double getY() {
		return this.y;
	}
	
	public Image getImage() {
		return this.imageView.getImage();
	}
	
	public void setImage(Image image) {
		this.imageView.setImage(image);
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
