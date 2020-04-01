package system;

import javafx.scene.control.Alert;

public class MassageInformation {
    void show(String HeaderText,String ContentText){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("information");
        alert.setHeaderText(HeaderText);
        alert.setContentText(ContentText);
        alert.show();
    }
}
