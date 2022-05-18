package utils;

import java.util.ArrayList;
import java.util.List;

import mainGame.GameView;

public class IncreaseRangePowerUp extends PowerUp{

	private static IncreaseRangePowerUp instance;
	private List<Integer> costList = List.of(30, 150, 4000);
	private List<Integer> ranges = List.of(49, 59, 61);
	private int currentRange = 41;
	
	private IncreaseRangePowerUp(GameView view) {
		super(30, "", 100, 30, view);
		setTitle();
	}
	
	public static IncreaseRangePowerUp getInstance(GameView view) {
		if (instance == null) {
			synchronized(IncreaseRangePowerUp.class) {
				if (instance == null) {
					instance = new IncreaseRangePowerUp(view);
				}
			}
		}
		return instance;
	}

	@Override
	public void changeCost() {
		// TODO Auto-generated method stub
		if (usages != 2) {
			this.setCost(this.costList.get(usages + 1));
		}
		currentRange = ranges.get(usages); 
		usages ++;
		if (usages == 3) {
			this.setDisable(true);
		}
		setTitle();
	}
	
	private void setTitle() {
		this.setTitle("" + this.costList.get(usages));
	}
	
	public int getCurrentRange() {
		return this.currentRange;
	}
}
