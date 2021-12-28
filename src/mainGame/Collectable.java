package mainGame;

import javafx.scene.image.Image;

public abstract class Collectable extends Sprite {

	private int hp;
	
	public Collectable(Image image, double x, double y, int hp) {
		super(image, x, y);
		this.hp = hp;
	}
	
	public int getHP() {
		return this.hp;
	}
	
	public void setHP(int newHP) {
		this.hp = newHP;
	}
	
}
