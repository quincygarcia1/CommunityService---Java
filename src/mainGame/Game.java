package mainGame;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class Game extends Application{
	
	Pane startScreen;
	Pane gameScreen;
	Pane storeScreen;
	Scene startScene;
	Scene gameScene;
	
	
	private void createStart(Stage stage) {
		Label title = new Label("Community Service");
		startScreen.getChildren().addAll(title);
	}
	
	private Button createButton(String innerText, double x, double y, int w, int h) {
		Button btn = new Button(innerText);
		btn.setLayoutX(x);
		btn.setLayoutY(y);
		btn.setMaxSize(w, h);
		Font btnFont = Font.loadFont("file:ZenKurenaido-Regular.ttf", 20);
		btn.setFont(btnFont);
		btn.setStyle("-fx-background-color: #ff0000; ");
		return btn;
	}
	
	public void start(Stage stage) throws Exception {
		stage.setTitle("Community Service");
		
		startScreen = new Pane();
		gameScreen = new Pane();
		storeScreen = new Pane();
		
		createStart(stage);
		startScene = new Scene(startScreen, 700, 500);
		gameScene = new Scene(gameScreen, 1400, 700);
		
		Button startButton = createButton("Start", 300, 235, 100, 30);
		startButton.addEventHandler(ActionEvent.ACTION, (e) -> {
			stage.setScene(gameScene);
			stage.centerOnScreen();
		});
		startScreen.getChildren().add(startButton);

		stage.setScene(startScene);
		stage.show();
		
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		launch(args);
	}

}
