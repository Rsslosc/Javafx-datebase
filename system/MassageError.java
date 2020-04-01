package system;

import javafx.scene.control.Alert;

class MassageError {
    void show(String HeaderText,String ContentText){
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("error");
        alert.setHeaderText(HeaderText);
        alert.setContentText(ContentText);
        alert.show();
    }

}
