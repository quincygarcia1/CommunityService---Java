package mainGame;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Model {

	public ArrayList<cleanUpPlayers> autonomousPlayers = new ArrayList<cleanUpPlayers>();
	public TrashList garbageUnits;
	int trashCount = 0;
	Random rand;
	
	protected GarbagePlayer movePlayer = new GarbagePlayer();
	
	private Collectable findClosestToPlayer() {
		if (garbageUnits == null) {
			return null;
		}
		Collectable max = garbageUnits.item;
		TrashList temp = garbageUnits;
		while (temp.next != null) {
			if (movePlayer.distanceBetween(temp.next.item) > movePlayer.distanceBetween(max)) {
				max = temp.next.item;
			}
			temp = temp.next; 
		}
		return max;
	}
	
	public void startThread() {
		Thread thread = new Thread(movePlayer);
		thread.start();
	}
	
	private void spawnTrash() {
		if (trashCount > 40) {
			return;
		}
		TrashList newElement = null;
		int garbageType = rand.nextInt(3);
		if (garbageType == 0) {
			newElement = new TrashList(new PileItem(), trashCount);
		} else if (garbageType > 0) {
			newElement = new TrashList(new garbageItem(), trashCount);
		}
		trashCount ++;
		if (garbageUnits == null) {
			garbageUnits = newElement;
		} else {
			newElement.next = garbageUnits;
			garbageUnits = newElement;
		}
	}
	
	private Collectable oldestTarget() {
		TrashList temp = garbageUnits;
		while (temp != null) {
			if (temp.assigned) {
				return null;
			} else if (temp.next.assigned) {
				return temp.item;
			}
			temp = temp.next;
		}
		return null;
	}
	
}
