package mainGame;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Model {

	private ArrayList<cleanUpPlayers> autonomousPlayers = new ArrayList<cleanUpPlayers>();
	private ArrayList<Collectable> garbageUnits = new ArrayList<Collectable>();
	Random rand;
	
	protected GarbagePlayer movePlayer = new GarbagePlayer();
	
	
	private Collectable findClosestToPlayer() {
		Collectable max = garbageUnits.get(0);
		for (int i = 1; i < garbageUnits.size(); i++) {
			if (movePlayer.distanceBetween(garbageUnits.get(i)) > movePlayer.distanceBetween(max)) {
				max = garbageUnits.get(i);
			}
		}
		return max;
	}
	
	private void spawnTrash() {
		if (garbageUnits.size() > 40) {
			return;
		}
		int garbageType = rand.nextInt(2);
		if (garbageType == 0) {
			garbageUnits.add(new garbageItem);
		} else if (garbageType == 1) {
			garbageUnits.add(new PileItem);
		}
	}
	
}
