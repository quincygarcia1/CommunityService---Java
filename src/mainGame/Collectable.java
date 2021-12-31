package mainGame;

import java.util.ArrayList;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public abstract class Collectable extends Sprite {

	private int hp;
	
	public Collectable(ImageView imageView, ArrayList<Image> spriteImages, double x, double y, int hp) {
		super(imageView, spriteImages, x, y);
		this.hp = hp;
	}
	
	public int getHP() {
		return this.hp;
	}
	
	public void setHP(int newHP) {
		this.hp = newHP;
	}
	
}
