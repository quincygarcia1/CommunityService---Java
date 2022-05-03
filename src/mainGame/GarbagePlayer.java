package mainGame;

import java.util.ArrayList;
import java.util.Arrays;

import javafx.scene.image.Image;

public class GarbagePlayer extends cleanUpPlayers implements Runnable {
	
	ArrayList<Image> spriteImages;
	int currentAnimationNum = 0;
	private boolean direction;
	private boolean activeAnimation = false;
	private int movementSpeed = 4;
	
	public GarbagePlayer() {
		super(new ArrayList<Image>(Arrays.asList(new Image("file:Images/player_r2.png"), new Image("file:Images/player_r3.png"),
				new Image("file:Images/player_r1.png"), new Image("file:Images/player_l2.png"), new Image("file:Images/player_l3.png"),
				new Image("file:Images/player_l1.png"))), 500, 400, 15, 15);
		// TODO Auto-generated constructor stub
		this.spriteImages = new ArrayList<Image>(Arrays.asList(new Image("file:Images/player_r2.png"), new Image("file:Images/player_r3.png"),
				new Image("file:Images/player_r1.png"), new Image("file:Images/player_l2.png"), new Image("file:Images/player_l3.png"),
				new Image("file:Images/player_l1.png")));
	}
	
	public void moveRight() throws InterruptedException {
		if (activeAnimation) {
			return;
		}
		activeAnimation = true;
		moveTo(movementSpeed);
		if (this.currentAnimationNum > 2 || this.currentAnimationNum == 2) {
			this.currentAnimationNum = 0;
		} else {
			this.currentAnimationNum ++;
		}
		changeAnimation();
		Thread.sleep(150);
		activeAnimation = false;
	}
	
	public void moveLeft() throws InterruptedException {
		if (activeAnimation) {
			return;
		}
		activeAnimation = true;
		moveTo(-movementSpeed);
		if (this.currentAnimationNum <= 2 || this.currentAnimationNum == 5) {
			this.currentAnimationNum = 3;
		} else {
			this.currentAnimationNum ++;
		}
		
		changeAnimation();
		Thread.sleep(150);
		activeAnimation = false;
	}
	
	public void setDirection(boolean goingRight) {
		this.direction = goingRight;
	}
	
	private void changeAnimation() {
		this.setImage(this.spriteImages.get(currentAnimationNum));
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		if (direction) {
			try {
				moveRight();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				return;
			}
		} else {
			try {
				moveLeft();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				return;
			}
		}
	}
	

}
