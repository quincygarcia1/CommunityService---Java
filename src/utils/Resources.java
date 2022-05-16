package utils;

import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class Resources {
	
	public static Font getMasterFont(int size) {
		return Font.loadFont("file:ZenKurenaido-Regular.ttf", size);
	}
	
	public static Text getLargerText(String text, int x, int y) {
		Text returnedText = new Text(x, y, text);
		returnedText.setFont(getMasterFont(30));
		return returnedText;
	}
	
	public static Text getRegularText(String text, int x, int y) {
		Text returnedText = new Text(x, y, text);
		returnedText.setFont(getMasterFont(15));
		return returnedText;
	}

}
