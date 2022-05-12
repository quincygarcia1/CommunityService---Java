package sprites;

import java.util.ArrayList;
import java.util.Random;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import utils.ObservablePickup;

public abstract class Collectable extends Sprite implements Runnable, ObservablePickup {

	static Random rand = new Random();
	private int hp;
	private float time;
	
	
	public Collectable(ArrayList<Image> spriteImages, int hp, int y) {
		super(spriteImages, rand.nextInt(1200), y);
		this.hp = hp;
		this.time = 0;
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
	
	public float getTime() {
		return this.time;
	}
	
	public void addMillisecond() {
		this.time += 0.001;
	}
	
	public abstract void run();
	
	
}
