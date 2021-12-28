package mainGame;

import javafx.scene.image.Image;

public class cleanUpPlayers extends Sprite implements Move {

	public cleanUpPlayers(Image image, double x, double y) {
		super(image, x, y);
	}

	@Override
	public double getLocation() {
		// TODO Auto-generated method stub
		return this.x;
	}

	@Override
	public void moveTo(int location) {
		// TODO Auto-generated method stub
		this.x = location;
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
