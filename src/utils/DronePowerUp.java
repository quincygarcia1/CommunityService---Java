package utils;

public class DronePowerUp extends PowerUp{
	
	private static DronePowerUp instance;
	private int multiplier = 1;
	private int usages = 0;

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
		this.setCost(this.getCost() * 75 * multiplier);
		this.multiplier *= 3;
		this.usages ++;
		if (usages == 4) {
			this.setDisable(true);
		}
	}


}
