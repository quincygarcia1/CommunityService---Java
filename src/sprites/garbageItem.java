package sprites;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import javafx.scene.image.Image;
import utils.ObserverPickup;

public class garbageItem extends Collectable implements Runnable{
	
	static Random rand = new Random();
	private int animationSet;
	private ObserverPickup view;

	public garbageItem() {
		super(new ArrayList<Image>(Arrays.asList(new Image("file:Images/Garbage1-Undamaged.png"), new Image("file:Images/Garbage1-SlightDamage.png"),
				new Image("file:Images/Garbage1-Destroyed.png"), new Image("file:Images/Garbage2-Undamaged.png"), 
				new Image("file:Images/Garbage2-Destroyed.png"))), rand.nextInt(3) + 2, 390);
		// TODO Auto-generated constructor stub
		chooseSprite();
	}
	
	public int getSet() {
		return this.animationSet;
	}
	
	private void chooseSprite() {
		int boxNum = rand.nextInt(2);
		if (boxNum == 0) {
			this.currentAnimationNum = 3;
			changeAnimation();
			animationSet = 1;
			return;
		}
		animationSet = 0;
	}
	
	public void destroy() {
		if (animationSet == 0) {
			if (this.currentAnimationNum == 2) {
				this.currentAnimationNum = 0;
				changeAnimation();
				return;
			}
		} else if (animationSet == 1) {
			if (this.currentAnimationNum == 4) {
				this.currentAnimationNum = 3;
				
				changeAnimation();
				return;
			}
		}
		this.currentAnimationNum ++;
		changeAnimation();
		return;
	}
	
	public void changeAnimation() {
		System.out.println(this.currentAnimationNum);
		this.setImage(this.spriteImages.get(currentAnimationNum));
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		int time = (this.getHP() + rand.nextInt((this.getHP()/2) + 1)) * 900;
		if (this.animationSet == 0){
			try {
				Thread.sleep(2*(time/5));
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				return;
			}
			System.out.println("reached1");
			destroy();
			try {
				Thread.sleep(2*(time/5));
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				return;
			}
			System.out.println("reached2");
			destroy();
			try {
				Thread.sleep(time/5);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				return;
			}
		} else if (this.animationSet == 1) {
			try {
				Thread.sleep(2*(time/3));
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				return;
			}
			System.out.println("reached3");
			destroy();
			try {
				Thread.sleep(time/3);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				return;
			}
		}
		System.out.print("finished");
		notifyObserver();
	}

	@Override
	public void setObservingView(ObserverPickup op) {
		// TODO Auto-generated method stub
		this.view = op;
	}

	@Override
	public void notifyObserver() {
		// TODO Auto-generated method stub
		this.view.update(this);
	}

	@Override
	public void removeObservingView(ObserverPickup op) {
		// TODO Auto-generated method stub
		this.view = null;
	}
	

}
