package mainGame;

import java.util.ArrayList;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class cleanUpPlayers extends Sprite implements Move {

	public cleanUpPlayers(ImageView imageView, ArrayList<Image> spriteImages, double x, double y) {
		super(imageView, spriteImages, x, y);
	}

	@Override
	public double getLocation() {
		// TODO Auto-generated method stub
		return this.x;
	}

	
	public double distanceBetween(Sprite piece) {
		if (piece.y == this.y) {
			return Math.abs(piece.x - this.x);
		} else {
			double yDist = Math.abs(piece.y - this.y);
			double xDist = Math.abs(piece.x - this.x);
			return (Math.pow(xDist, 2)) + (Math.pow(yDist, 2));
		}
	}
	
}
