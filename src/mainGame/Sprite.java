package mainGame;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

public class Sprite {
	
	private double x;
	private double y;
	private Image image;
	private ImageView imageView;
	private double width;
	private double height;
	Pane layer;

	public Sprite(Pane layer, Image image, double x, double y) {
		// TODO Auto-generated constructor stub
		this.image = image;
		this.x = x;
		this.y = y;
		this.imageView = new ImageView(image);
		this.width = image.getWidth();
		this.height = image.getHeight();
		this.layer = layer;
		addToLayer();
		
	}
	
	public double getX() {
		return this.x;
	}
	
	public double getY() {
		return this.y;
	}
	
	public void addToLayer() {
		this.layer.getChildren().add(this.imageView);
	}
	
	public Pane getLayer() {
		return this.layer;
	}
	
	public ImageView getImageView() {
		return this.imageView;
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
