package system;

import java.util.Optional;

import javafx.scene.control.Alert;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ButtonType;

class Off {
	boolean show() {
		Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
		alert.setTitle("worning");
		alert.setContentText("Do You Want Exit System?");

		Optional<ButtonType> buttonTypeOptional = alert.showAndWait();
		return buttonTypeOptional.get().getButtonData().equals(ButtonBar.ButtonData.OK_DONE);
	}

}
