package mainGame;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import sprites.Collectable;
import sprites.GarbagePlayer;
import sprites.cleanUpPlayers;
import utils.TrashList;

public class Model {

	int hashSize = 40;
	int score = 0;
	int trashReciprocal = 6;
	int multiplier = 1;
	protected ArrayList<cleanUpPlayers> autonomousPlayers = new ArrayList<cleanUpPlayers>();
	protected ArrayList<TrashList> trashHash = new ArrayList<TrashList>(hashSize);
	protected ArrayList<Integer> occupiedBuckets = new ArrayList<Integer>(hashSize);
	protected int trashCount = 0;
	private Collectable oldestCollectable = null;
	private Collectable newestCollectable = null;
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
	
	public Thread startThread() {
		Thread thread = new Thread(movePlayer);
		thread.start();
		return thread;
	}
	
	public Thread startGarbageThread() {
		if (movePlayer.getTarget() == null) {
			return null;
		}
		Thread thread = new Thread(movePlayer.getTarget());
		thread.start();
		
		return thread;
	}
	
	public ArrayList<Integer> getBuckets() {
		return occupiedBuckets;
	}
	
	protected void registerTrash(TrashList newElement) {
		
		int hashVal = hash(newElement.getItem().getXCenter()) % hashSize;
		newElement.next = trashHash.get(hashVal);
		System.out.println(hashVal);
		trashHash.set(hashVal, newElement);
		occupiedBuckets.add(hashVal);
		trashCount ++;
	}
	
	private void targetAges() {
		//To do: revise this method to work with the hashtable
		Collectable max = null;
		Collectable min = null;
		for (int i = 0; i < this.occupiedBuckets.size(); i ++) {
			TrashList linkedList = trashHash.get(occupiedBuckets.get(i));
			TrashList temp = linkedList;
			while (temp != null) {
				if (max == null) {
					max = temp.getItem();
				}
				if (min == null) {
					min = temp.getItem();
				}
				if (temp.getItem().getTime() < min.getTime()) {
					min = temp.getItem();
				} else if (temp.getItem().getTime() > max.getTime()) {
					max = temp.getItem();
				}
				temp = temp.next;
			}
		}
		oldestCollectable = max;
		newestCollectable = min;
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
		if ((temp != null) && temp.getItem().getXCenter() <= (this.movePlayer.x + this.movePlayer.getDestructionRange()) && temp.getItem().x >= (this.movePlayer.x - this.movePlayer.getDestructionRange())) {
			TrashList returnValue = temp;
			trashHash.set(divisor, temp.next);
			return returnValue.getItem();
		}
		while (temp != null && temp.next != null) {
			if (temp.next.getItem().getXCenter() <= (this.movePlayer.x + this.movePlayer.getDestructionRange()) && temp.next.getItem().x >= (this.movePlayer.x - this.movePlayer.getDestructionRange())) {
				Collectable target = temp.next.getItem();
				temp.next = temp.next.next;
				return target;
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
