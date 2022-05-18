package mainGame;

import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;
import utils.DronePowerUp;
import utils.GameButton;
import utils.IncreaseRangePowerUp;
import utils.MovementPowerUp;
import utils.MultiplierPowerUp;
import utils.PowerUp;
import utils.Resources;
import utils.SpawnRatePowerUp;

public class ShopPane extends GridPane{
	private GameView view;
	protected GameButton exitButton;
	
	public ShopPane(GameView view) {
		this.view = view;
		this.setPrefSize(1200, 700);
		this.setMinSize(1200, 700);
		this.setMaxSize(1200, 700);
		this.setStyle("-fx-background-color: #ffc15e");
		this.setVgap(20);
		exitButton = new GameButton("Exit", 78, 8, 30);
		HBox exitBox = createCollection(Pos.TOP_RIGHT, exitButton, 40);
		this.add(exitBox, 0, this.getRowCount());
		this.setVgap(100);
		setUp();
	}
	
	private void setUp() {
		Text title = Resources.getTitleText("Shop");
		HBox titleBox = createCollection(Pos.TOP_CENTER, title, 100);
		
		this.add(titleBox, 0, this.getRowCount());
		
		addSection("Drones", "Get a drone that will automatically seek out and destroy garbage. Limit of 4.", "drone");
		addSection("Collection Range", "Increase the range in which you can collect garbage. 3 tiers.", "range");
		addSection("Movement Speed", "Increases the movement speed of the player character. 4 tiers", "move");
		addSection("Score Multiplier", "Increase your multiplier when you collect garbage. 4 tiers", "multiplier");
		addSection("Spawn Rate", "Garbage spawns at a faster rate. 3 tiers", "spawn");

		this.setVgap(10);
		
	}
	
	private void addSection(String labelName, String labelDescription, String powerUpType) {
		PowerUp button;
		Text label = Resources.getLargerText("\t" + labelName, 0, 0);
		Text description = Resources.getRegularText("\t" + labelDescription, 0, 0);
		HBox titleBox = createCollection(Pos.BOTTOM_LEFT, label, 0);
		HBox descriptionBox = createCollection(Pos.TOP_LEFT, description, 0);
		if (powerUpType == "move") {
			button = MovementPowerUp.getInstance(this.view);
		} else if (powerUpType == "drone") {
			button = DronePowerUp.getInstance(this.view);
		} else if (powerUpType == "range") {
			button = IncreaseRangePowerUp.getInstance(this.view);
		} else if (powerUpType == "multiplier") {
			button = MultiplierPowerUp.getInstance(this.view);
		} else {
			button = SpawnRatePowerUp.getInstance(this.view);
		}
		HBox buttonBox = createCollection(Pos.CENTER_RIGHT, button, 100);
		int currentRow = this.getRowCount();
		this.add(descriptionBox, 0, currentRow);
		this.add(titleBox, 0, currentRow);
		this.add(buttonBox, 0, currentRow);
	}
	
	private HBox createCollection(Pos location, Node e, int distUnder) {
		HBox collection = new HBox(e);
		collection.setAlignment(location);
		collection.setMaxWidth(1100);
		collection.setMinWidth(1100);
		collection.setPrefWidth(1200);
		collection.setMaxHeight(distUnder);
		collection.setMinHeight(distUnder);
		collection.setPrefHeight(distUnder);
		return collection;
	}
}
