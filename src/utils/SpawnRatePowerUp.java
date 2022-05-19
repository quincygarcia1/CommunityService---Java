package utils;

import java.util.ArrayList;
import java.util.List;

import mainGame.GameView;

public class SpawnRatePowerUp extends PowerUp {
	
	private static SpawnRatePowerUp instance;
	private List<Integer> costList = List.of(15, 300, 2000);
	private List<Integer> offsets = List.of(11, 10, 9);
	private int currentOffset = 12;
	
	private SpawnRatePowerUp(GameView view) {
		super(15, "", 100, 30, view);
		setTitle();
	}
	
	public static SpawnRatePowerUp getInstance(GameView view) {
		if (instance == null) {
			synchronized(SpawnRatePowerUp.class) {
				if (instance == null) {
					instance = new SpawnRatePowerUp(view);
				}
			}
		}
		return instance;
	}

	private void setTitle() {
		this.setTitle("" + this.costList.get(usages));
	}
	
	@Override
	public void changeCost() {
		// TODO Auto-generated method stub
		if (usages != 2) {
			this.setCost(this.costList.get(usages + 1));
		}
		currentOffset = offsets.get(usages); 
		usages ++;
		if (usages == 3) {
			this.setDisable(true);
		}
		setTitle();
	}
	
	public int getCurrentOffset() {
		return this.currentOffset;
	}

	@Override
	public void event() {
		// TODO Auto-generated method stub
		if (this.view.model.getScore() < this.getCost()) {
			return;
		}
		this.changeCost();
		this.view.timer.changeOffset(currentOffset);
	}

}
