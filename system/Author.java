package system;

import javafx.scene.control.Alert;

public class Author{
	
	public void show() {
		Alert alert = new Alert(Alert.AlertType.INFORMATION);
		alert.setTitle("Author");
		alert.setHeaderText("Copyright (c) 2019, Rsslosc");
		alert.setContentText("DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.");
		alert.show();
	}
}
