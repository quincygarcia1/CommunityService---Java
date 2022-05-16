package mainGame;

import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;

public class ShopPane extends StackPane{
	private GameView view;
	
	public ShopPane(GameView view) {
		this.view = view;
		this.setPrefSize(900, 600);
		this.setMinSize(900, 600);
		this.setMaxSize(900, 600);
		this.setStyle("-fx-background-color: #ffc15e");
	}
	
	private void setUp() {
		
	}
}
