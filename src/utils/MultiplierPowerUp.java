package utils;

import java.util.ArrayList;
import java.util.List;

public class MultiplierPowerUp extends PowerUp{

	private static MultiplierPowerUp instance;
	private ArrayList<Integer> costList = (ArrayList<Integer>) List.of(20, 80, 500, 3000);
	private ArrayList<Integer> multipliers = (ArrayList<Integer>) List.of(1, 4, 16, 64, 256);
	
	private int currentMultiplier = multipliers.get(0);
	
	private MultiplierPowerUp() {
		super(20, "", 100, 30);
		// TODO Auto-generated constructor stub
		setTitle();
	}
	
	public static MultiplierPowerUp getInstance() {
		if (instance == null) {
			synchronized(DronePowerUp.class) {
				if (instance == null) {
					instance = new MultiplierPowerUp();
				}
			}
		}
		return instance;
	}
	
	private void setTitle() {
		this.setTitle("x" + this.multipliers.get(usages + 1) + " points");
	}

	@Override
	public void changeCost() {
		// TODO Auto-generated method stub
		this.setCost(this.costList.get(usages + 1));
		currentMultiplier = multipliers.get(usages + 1); 
		usages ++;
		if (usages == 4) {
			this.setDisable(true);
		}
		
	}
	
	public int getMultiplier() {
		return this.currentMultiplier;
	}
	
}
