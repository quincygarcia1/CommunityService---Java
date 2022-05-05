package utils;

import javafx.scene.control.Button;
import javafx.scene.text.Font;

public class GameButton extends Button {
	
	public GameButton(String buttonName, int width, int height, int fontSize) {
		super(buttonName);
		Font btnFont = Font.loadFont("file:ZenKurenaido-Regular.ttf", fontSize);
		this.setFont(btnFont);
		this.setStyle("-fx-background-color: #882f2f; -fx-border-width: 5px; -fx-border-color: #4d1f1f; -fx-text-fill: #140202;");
		this.setPrefSize(width, height);
	}

}
