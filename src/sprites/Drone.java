package sprites;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Drone extends cleanUpPlayers implements Runnable {

	static Random rand = new Random();
	
	public Drone() {
		
		super(new ArrayList<Image>(Arrays.asList(new Image("file:Images/drone_r2.png"), new Image("file:Images/drone_r3.png"),
				new Image("file:Images/drone_r1.png"), new Image("file:Images/drone_l2.png"),
				new Image("file:Images/drone_l3.png"), new Image("file:Images/drone_l1.png"))), rand.nextInt(1200), 390, 10, 25);
		this.spriteImages = new ArrayList<Image>(Arrays.asList(new Image("file:Images/drone_r2.png"), new Image("file:Images/drone_r3.png"),
				new Image("file:Images/drone_r1.png"), new Image("file:Images/drone_l2.png"),
				new Image("file:Images/drone_l3.png"), new Image("file:Images/drone_l1.png")));
		this.setTarget(null);
	}
	
	public void move(Collectable location) throws InterruptedException {
		if (location == null) {
			return;
		}
		if (location.x < this.x) {
			this.currentAnimationNum = 3;
			changeAnimation();
		}
		while (Math.abs(this.x - location.x) > this.getDestructionRange()) {
			if (location.x < this.x) {
				moveTo(-5);
				if (currentAnimationNum == 5) {
					currentAnimationNum = 3;
				} else {
					currentAnimationNum ++;
				}
			} else {
				moveTo(5);
				if (currentAnimationNum == 2) {
					currentAnimationNum = 0;
				} else {
					currentAnimationNum ++;
				}
			}
			changeAnimation();
			Thread.sleep(170);
		}
		currentAnimationNum = 0;
		changeAnimation();
		if (this.getTarget() != null) {
			this.getTarget().changeStatus();
		}
		
	}
	
	private void changeAnimation() {
		this.setImage(this.spriteImages.get(currentAnimationNum));
	}
	


	@Override
	public void run() {
		// TODO Auto-generated method stub
		if (this.getTarget() == null) {
			return;
		}
		this.getTarget().setAssigned();
		try {
			move(this.getTarget());
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			this.setTarget(null);
			return;
		}
		Thread thread = new Thread(this.getTarget());
		thread.start();
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		this.setTarget(null);
		
	}
}
