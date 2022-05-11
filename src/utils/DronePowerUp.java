package utils;

import java.util.ArrayList;
import java.util.List;

public class DronePowerUp extends PowerUp{
	
	private static DronePowerUp instance;
	private int usages = 0;
	private ArrayList<Integer> costList = (ArrayList<Integer>) List.of(100, 700, 4000, 14000); 

	private DronePowerUp() {
		super(100, "Get Drone", 100, 30);
		// TODO Auto-generated constructor stub
	}
	
	public static DronePowerUp getInstance() {
		if (instance == null) {
			synchronized(DronePowerUp.class) {
				if (instance == null) {
					instance = new DronePowerUp();
				}
			}
		}
		return instance;
	}
	
	public void changeCost() {
		this.setCost(this.costList.get(usages + 1));
		this.usages ++;
		if (usages == 4) {
			this.setDisable(true);
		}
	}


}
