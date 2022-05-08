package utils;

import java.util.ArrayList;
import java.util.Random;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public abstract class Collectable extends Sprite {

	static Random rand = new Random();
	private int hp;
	
	public Collectable(ArrayList<Image> spriteImages, int hp, int y) {
		super(spriteImages, rand.nextInt(1200), y);
		this.hp = hp;
	}
	
	public int getHP() {
		return this.hp;
	}
	
	public void setHP(int newHP) {
		this.hp = newHP;
	}
	
	public void remove() {
		this.setImage(null);
	}
	
	private void takeDamage(int damagePoints) {
		this.hp -= damagePoints;
	}
	
}
