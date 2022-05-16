package mainGame;

import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import utils.GameButton;

public class ShopPane extends Pane{
	private GameView view;
	protected GameButton exitButton;
	
	public ShopPane(GameView view) {
		this.view = view;
		this.setPrefSize(1200, 700);
		this.setMinSize(1200, 700);
		this.setMaxSize(1200, 700);
		this.setStyle("-fx-background-color: #ffc15e");
		exitButton = new GameButton("Exit", 78, 8, 10);
		exitButton.setLayoutX(1050);
		exitButton.setLayoutY(40);
		setUp();
	}
	
	private void setUp() {
		this.getChildren().add(exitButton);
		
	}
}
