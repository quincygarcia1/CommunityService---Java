package utils;

import java.util.ArrayList;
import java.util.List;

public class IncreaseRangePowerUp extends PowerUp{

	private static IncreaseRangePowerUp instance;
	private List<Integer> costList = List.of(30, 150, 4000);
	private List<Integer> ranges = List.of(49, 59, 61);
	private int currentRange = 41;
	
	private IncreaseRangePowerUp() {
		super(30, "", 100, 30);
		setTitle();
	}
	
	public static IncreaseRangePowerUp getInstance() {
		if (instance == null) {
			synchronized(IncreaseRangePowerUp.class) {
				if (instance == null) {
					instance = new IncreaseRangePowerUp();
				}
			}
		}
		return instance;
	}

	@Override
	public void changeCost() {
		// TODO Auto-generated method stub
		if (usages != 3) {
			this.setCost(this.costList.get(usages + 1));
		}
		currentRange = ranges.get(usages); 
		usages ++;
		if (usages == 4) {
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
