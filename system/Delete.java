package system;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Optional;

public class Delete {

	@FXML
	TextField Number;
	@FXML
	TextField Name;
	@FXML
	TextField Gender;
	@FXML
	TextField Address;
	@FXML
	TextField Phone;
	@FXML
	TextField Major;

	private boolean studentExist = false;
	@FXML
	void SearchButtonAction(ActionEvent event) throws SQLException {
		if(Number.getText().length() == 0){
			new MassageError().show("Search Error!","Student Number Is Not Null,Please Input Student Number.");
		}
		else {
			studentExist = SearchSQL(Number.getText());
		}
	}

	private boolean SearchSQL(String text) throws SQLException {
		Statement statement = new ConnectSQL().connectSQL();
		assert statement != null;
		final String sql = "select * from student where id = '" + Number.getText() + "';";
		ResultSet resultSet = statement.executeQuery(sql);
		if(resultSet.next()){
			Name.setText(resultSet.getString("name"));
			Gender.setText(resultSet.getString("gender"));
			Address.setText(resultSet.getString("address"));
			Phone.setText(resultSet.getString("phone"));
			Major.setText(resultSet.getString("major"));
			statement.getConnection().close();
			return true;
		}else {
			new MassageError().show("Search Error!",Number.getText() + " is Not Exist!");
			statement.getConnection().close();
			return false;
		}
	}

	@FXML
	void DeleteButtonAction(ActionEvent event) throws SQLException {
		if(!studentExist){
			new MassageError().show("Delete Error!","Student is Not Exist!");
			return;
		}

		Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
		alert.setTitle("worning");
		alert.setContentText("Do You Want Delete this Student?");
		Optional<ButtonType> buttonTypeOptional = alert.showAndWait();
		if(buttonTypeOptional.get().getButtonData().equals(ButtonBar.ButtonData.OK_DONE)){
			Statement statement = new ConnectSQL().connectSQL();
			assert statement != null;
			final String sql = "delete from student where id = '" + Number.getText() + "';";

			if(statement.executeUpdate(sql) > 0){
				new MassageInformation().show("Delete Successfully", sql);
				clearText();
			}else{
				new MassageError().show("Delete Error!","Delete Error,Maybe The Table Is Restricted");
			}
		}

	}
	private void clearText(){
		Number.clear();
		Name.clear();
		Gender.clear();
		Address.clear();
		Phone.clear();
		Major.clear();
	}
	Parent createNode() throws IOException {
		return FXMLLoader.load(getClass().getResource("../source/DeleteFxml.fxml"));
	}


}
