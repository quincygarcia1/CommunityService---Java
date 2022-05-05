package utils;

import javafx.scene.input.KeyCode;

public interface Action {
	
	public abstract void execute();
	public abstract KeyCode getKey();

}
