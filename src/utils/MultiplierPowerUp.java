package utils;

public class MultiplierPowerUp extends PowerUp{

	private static MultiplierPowerUp instance;
	private int multiplier = 2;
	private int usages = 0;
	
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
		this.setTitle("x" + multiplier + " points");
	}
	
}
