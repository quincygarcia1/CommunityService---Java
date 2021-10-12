package mainGame;

import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class Game extends Application{

	private Pane root = new Pane();
	
	private Parent createContent() {
		root.setPrefSize(1400, 700);
		return root;
	}
	public void start(Stage stage) throws Exception {
		stage.setTitle("Community Service");
		stage.setScene(new Scene(createContent()));
		stage.show();
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		launch(args);
	}

}
