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
		
		int hashVal = hash(newElement.getItem().x) % hashSize;
		newElement.next = trashHash.get(hashVal);
		trashHash.set(hashVal, newElement);
		trashCount ++;
	}
	
	private Collectable oldestTarget() {
		//To do: revise this method to work with the hashtable
		
		return null;
	}
	
	protected Collectable checkProximity() {
		double divisor = this.movePlayer.x/(double)this.movePlayer.getDestructionRange();
		if ((divisor - 0.5) == (int)divisor) {
			Collectable bottomBound = hashDivisor((int)(divisor - 0.5));
			Collectable upperBound = hashDivisor((int)(divisor + 0.5));
			if (bottomBound == null && upperBound != null) {
				return upperBound;
			} else if (bottomBound != null && upperBound == null) {
				return bottomBound;
			}
			if (Math.abs(this.movePlayer.x - bottomBound.x) > Math.abs(this.movePlayer.x - upperBound.x)) {
				return bottomBound;
			}
			return upperBound;
		} else {
			return hashDivisor((int)Math.round(divisor));
		}
	}
	
	private Collectable hashDivisor(int divisor) {
		// To do: Potentially delete the returned item from the linked list
		TrashList hash = trashHash.get(divisor);
		TrashList temp = hash;
		while (temp != null) {
			if (temp.getItem().x <= (this.movePlayer.x + this.movePlayer.getDestructionRange()) && temp.getItem().x >= (this.movePlayer.x - this.movePlayer.getDestructionRange())) {
				return temp.getItem();
			}
			temp = temp.next;
		}
		return null;
	}
	
	private int hash(double val) {
		double a = 0.45352364758429879433234;
		return (int)(a * (Math.round(val/movePlayer.getDestructionRange()) * movePlayer.getDestructionRange()));
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
