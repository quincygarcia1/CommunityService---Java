package mainGame;

import java.util.ArrayList;
import java.util.Arrays;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Drone extends cleanUpPlayers {
	
	ArrayList<Image> spriteImages = new ArrayList<Image>();
	int currentAnimationNum = 0;
	
	public Drone(ImageView imageView, double x) {
		
		super(imageView, new ArrayList<Image>(Arrays.asList(new Image("file:Images/drone_r2.png"), new Image("file:Images/drone_r3.png"),
				new Image("file:Images/drone_r1.png"), new Image("file:Images/drone_l2.png"),
				new Image("file:Images/drone_l3.png"), new Image("file:Images/drone_l1.png"))), x, 200.00);
		
	}
	
	public void moveTo(double location) throws InterruptedException {
		if (location < this.x) {
			currentAnimationNum = 3;
			changeAnimation();
		}
		while (Math.abs(this.x - location) <= 50) {
			if (location < this.x) {
				this.x -= 5;
				if (currentAnimationNum == 5) {
					currentAnimationNum = 3;
				} else {
					currentAnimationNum ++;
				}
			} else {
				this.x += 5;
				if (currentAnimationNum == 2) {
					currentAnimationNum = 0;
				} else {
					currentAnimationNum ++;
				}
			}
			changeAnimation();
			Thread.sleep(25);
		}
		currentAnimationNum = 0;
		changeAnimation();
	}
	
	private void changeAnimation() {
		this.setImage(this.spriteImages.get(currentAnimationNum));
	}
}
