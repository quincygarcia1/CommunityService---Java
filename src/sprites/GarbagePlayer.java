package sprites;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

import javafx.scene.image.Image;

public class GarbagePlayer extends cleanUpPlayers implements Runnable {
	
	ArrayList<Image> spriteImages;
	private boolean direction;
	private boolean activeAnimation = false;
	private boolean collecting = false;
	private Collectable tempItem; //used to keep the target item if the thread sets the target to null early
	private int multiplier = 900;
	private int movementSpeed = 4;
	Random rand = new Random();
	
	public GarbagePlayer() {
		super(new ArrayList<Image>(Arrays.asList(new Image("file:Images/player_r2.png"), new Image("file:Images/player_r3.png"),
				new Image("file:Images/player_r1.png"), new Image("file:Images/player_l2.png"), new Image("file:Images/player_l3.png"),
				new Image("file:Images/player_l1.png"))), 500, 375, 15, 41);
		// TODO Auto-generated constructor stub
		this.spriteImages = new ArrayList<Image>(Arrays.asList(new Image("file:Images/player_r2.png"), new Image("file:Images/player_r3.png"),
				new Image("file:Images/player_r1.png"), new Image("file:Images/player_l2.png"), new Image("file:Images/player_l3.png"),
				new Image("file:Images/player_l1.png")));
	}
	
	public void moveRight() throws InterruptedException {
		if (activeAnimation || collecting || this.getFront() >= 1200) {
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
		if (activeAnimation || collecting || this.x <= 0) {
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
	
	private void collectTarget() throws InterruptedException {
		try {
			int time = (this.tempItem.getHP() + rand.nextInt((this.tempItem.getHP()/2) + 1)) * this.multiplier;
			Thread.sleep(time);
			
		} catch(IllegalArgumentException e) {
			System.out.print("sleep error");
			collecting = false;
			return;
		}
		collecting = false;
	}
	
	public void setDirection(boolean goingRight) {
		this.direction = goingRight;
	}
	
	public void setCollecting(boolean status) {
		this.collecting = status;
	}
	
	public boolean isCollecting() {
		return this.collecting;
	}
	
	public void setMultiplier(int newVal) {
		this.multiplier = newVal;
	}
	
	public void setTarget(Collectable target) {
		super.setTarget(target);
		if (target == null) {
			return;
		}
		tempItem = target;
		this.tempItem.setHP(target.getHP());
	}
	
	
	
	private void changeAnimation() {
		this.setImage(this.spriteImages.get(currentAnimationNum));
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		if (collecting) {
			try {
				collectTarget();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				return;
			}
			return;
		}
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
