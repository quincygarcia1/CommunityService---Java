package mainGame;

import java.util.ArrayList;

import javafx.scene.image.Image;

public abstract class garbageItem extends Collectable {

	public garbageItem(ArrayList<Image> spriteImages, double x, double y, int hp) {
		super(spriteImages, x, y, hp);
		// TODO Auto-generated constructor stub
	}
	
	public abstract void takeDamage(int damagePoints);

}
