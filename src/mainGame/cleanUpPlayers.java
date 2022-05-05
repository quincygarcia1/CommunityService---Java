package mainGame;

import java.util.ArrayList;

import javafx.animation.TranslateTransition;
import javafx.scene.image.Image;
import javafx.util.Duration;
import utils.Move;

public abstract class cleanUpPlayers extends Sprite implements Move{
	
	private double destructionRange;
	int currentAnimationNum = 0;
	private double translateTime;

	public cleanUpPlayers(ArrayList<Image> spriteImages, double x, double y, double translateTime, double destructionRange) {
		super(spriteImages, x, y);
		this.destructionRange = destructionRange;
		this.translateTime = translateTime;
	}

	@Override
	public double getLocation() {
		// TODO Auto-generated method stub
		return this.x;
	}
	
	public double getTime() {
		return this.translateTime;
	}
	
	public void setTime(double newTime) {
		this.translateTime = newTime;
	}

	public void setDestructionRange(double newRange) {
		this.destructionRange = newRange;
	}
	
	public double getDestructionRange() {
		return this.destructionRange;
	}
	
	public double distanceBetween(Sprite piece) {
		if (piece.y == this.y) {
			return Math.abs(piece.x - this.x);
		} else {
			double yDist = Math.abs(piece.y - this.y);
			double xDist = Math.abs(piece.x - this.x);
			yDist -= this.getH();
			xDist -= this.getW();
 			return Math.sqrt(Math.pow(xDist, 2)) + (Math.pow(yDist, 2));
		}
	}
	
	public void moveTo(double location) {
		TranslateTransition translate = new TranslateTransition();
		translate.setNode(this);
		translate.setDuration(Duration.millis(this.translateTime));
		translate.setByX(location);
		translate.play();
		this.x += location;
	}
	
	public boolean touches(Sprite otherObject) {
		if (distanceBetween(otherObject) <= this.destructionRange) {
			return true;
		}
		return false;
	}

	
}
