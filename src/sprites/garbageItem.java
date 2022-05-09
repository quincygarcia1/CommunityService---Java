package sprites;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import javafx.scene.image.Image;

public class garbageItem extends Collectable {
	
	static Random rand = new Random();
	private int animationSet;

	public garbageItem() {
		super(new ArrayList<Image>(Arrays.asList(new Image("file:Images/Garbage1-Undamaged.png"), new Image("file:Images/Garbage1-SlightDamage.png"),
				new Image("file:Images/Garbage1-Destroyed.png"), new Image("file:Images/Garbage2-Undamaged.png"), 
				new Image("file:Images/Garbage2-Destroyed.png"))), rand.nextInt(3) + 2, 415);
		// TODO Auto-generated constructor stub
		chooseSprite();
	}
	
	private void chooseSprite() {
		int boxNum = rand.nextInt(2);
		if (boxNum == 0) {
			this.setImage(this.spriteImages.get(3));
			animationSet = 1;
		}
		animationSet = 0;
	}
	
	public void changeAnimation() {
		if (animationSet == 0) {
			if (this.currentAnimationNum < 2) {
				this.currentAnimationNum = 2;
			}
		}
	}
	

}
