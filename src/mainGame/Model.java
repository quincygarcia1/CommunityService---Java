package mainGame;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import utils.Collectable;
import utils.TrashList;

public class Model {

	int hashSize = 40;
	int score = 0;
	int trashReciprocal = 6;
	public ArrayList<cleanUpPlayers> autonomousPlayers = new ArrayList<cleanUpPlayers>();
	public ArrayList<TrashList> trashHash = new ArrayList<TrashList>(hashSize);
	private ArrayList<Integer> occupiedBuckets = new ArrayList<Integer>(hashSize);
	protected int trashCount = 0;
	Random rand;
	
	protected GarbagePlayer movePlayer = new GarbagePlayer();
	
	public void fillHash() {
		for (int i = 0; i < hashSize; i++) {
			trashHash.add(null);
		}
	}
	
	private Collectable findClosestToPlayer() {
		//To do: complete this method to find the closest and farthest
		//collectables from the player so that I can develop a scoring algorithm
		return null;
	}
	
	public void startThread() {
		Thread thread = new Thread(movePlayer);
		thread.start();
	}
	
	protected void registerTrash(TrashList newElement) {
		
		int hashVal = hash(newElement.getItem().getXCenter()) % hashSize;
		newElement.next = trashHash.get(hashVal);
		System.out.println(hashVal);
		trashHash.set(hashVal, newElement);
		occupiedBuckets.add(hashVal);
		trashCount ++;
	}
	
	private Collectable oldestTarget() {
		//To do: revise this method to work with the hashtable
		
		return null;
	}
	
	protected Collectable checkProximity() {
		double divisor = this.movePlayer.x/(double)this.movePlayer.getDestructionRange();
		
		if ((divisor - 0.5) == (int)divisor) {
			Collectable bottomBound = hashDivisor((int)((divisor - 0.5) * this.movePlayer.getDestructionRange()) % hashSize);
			Collectable upperBound = hashDivisor((int)((divisor + 0.5) * this.movePlayer.getDestructionRange()) % hashSize);
			if (bottomBound == null && upperBound == null) {
				return null;
			}
			if (bottomBound == null && upperBound != null) {
				return upperBound;
			} else if (bottomBound != null && upperBound == null) {
				System.out.println(bottomBound.x);
				return bottomBound;
			}
			if (Math.abs(this.movePlayer.x - bottomBound.x) > Math.abs(this.movePlayer.x - upperBound.x)) {
				System.out.println(bottomBound.x);
				return bottomBound;
			}
			System.out.println(upperBound.x);
			return upperBound;
		} else {
			return hashDivisor((int)(Math.round(divisor) * this.movePlayer.getDestructionRange()) % hashSize);
		}
	}
	
	private Collectable hashDivisor(int divisor) {
		System.out.println(divisor);
		TrashList hash = trashHash.get(divisor);
		TrashList temp = hash;
		while (temp != null) {
			if (temp.getItem().getXCenter() <= (this.movePlayer.x + this.movePlayer.getDestructionRange()) && temp.getItem().x >= (this.movePlayer.x - this.movePlayer.getDestructionRange())) {
				return temp.getItem();
			}
			temp = temp.next;
		}
		return null;
	}
	
	private int hash(double val) {
		return (int)(Math.round(val/movePlayer.getDestructionRange()) * movePlayer.getDestructionRange());
	}
	
	public void increaseScore(int increment) {
		score += increment;
	}
	
	public int getScore() {
		return this.score;
	}
	
	public void decreaseReciprocal() {
		this.trashReciprocal --;
	}
	
	public int getReciprocal() {
		return this.trashReciprocal;
	}
	
}
