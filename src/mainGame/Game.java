package mainGame;

import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class Game extends Application{
	
	Stage window;
	Scene startScreen, settingsMenu, shop, game;
	
		
	public void start(Stage stage) throws Exception {
		window = stage;
		window.setTitle("Community Service");
		Pane root = new Pane();
		int width = 700;
		int height = 500;
		root.setPrefSize(width, height);
		Label title = new Label(String.valueOf(root.getLayoutX()));
		Button startButton = new Button("Start");
		startButton.setLayoutX(width/2 - 10);
		startButton.setLayoutY(height/2);
		root.getChildren().addAll(title, startButton);
		startScreen = new Scene(root);
		window.setScene(startScreen);
		window.show();
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		launch(args);
	}

}
