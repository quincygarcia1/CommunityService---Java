package mainGame;

import javafx.geometry.Pos;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import utils.GameButton;
import utils.Resources;

public class StartMenu extends GridPane{
	
	private final GameView view;
	
	
	public StartMenu(GameView view) {
		this.view = view;
		this.setAlignment(Pos.CENTER);
		titling();
		createButtons();
	}
	
	private void titling() {
		Text title = Resources.getTitleText("Community Service");
		HBox box = new HBox(title);
		box.setAlignment(Pos.CENTER);
		this.setVgap(10);
		this.add(box, 0, this.getRowCount());
	}
	
	private void createButtons() {
		GameButton startButton = new GameButton("Start Game", 400, 100, 20);
		GameButton settingsButton = new GameButton("Settings", 400, 100, 20);
		GameButton quitButton = new GameButton("Quit Game", 400, 100, 20);
		
		quitButton.setOnAction(e -> System.exit(0));
		startButton.setOnAction(e -> {
			this.view.gameStarted = true;
			this.view.showGameScreen();
		});
		
		this.add(startButton, 0, this.getRowCount());
		this.add(settingsButton, 0, this.getRowCount());
		this.add(quitButton, 0, this.getRowCount());
	}
	

}
