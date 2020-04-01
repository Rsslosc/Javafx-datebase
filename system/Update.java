package system;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Update {
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

    @FXML
    void SearchButtonAction(ActionEvent event) throws SQLException {
        if (Number.getText().length() == 0) {
            new MassageError().show("Search Error!", "Student Number Is Not Null,Please Input Student Number.");
        } else {
            SearchSQL(Number.getText());
        }
    }

    private void SearchSQL(String text) throws SQLException {
        Statement statement = new ConnectSQL().connectSQL();
        assert statement != null;
        final String sql = "select * from student where id = '" + Number.getText() + "';";
        ResultSet resultSet = statement.executeQuery(sql);
        if (resultSet.next()) {
            Name.setText(resultSet.getString("name"));
            Gender.setText(resultSet.getString("gender"));
            Address.setText(resultSet.getString("address"));
            Phone.setText(resultSet.getString("phone"));
            Major.setText(resultSet.getString("major"));
            statement.getConnection().close();
        } else {
            new MassageError().show("Search Error!", Number.getText() + " is Not Exist!");
            statement.getConnection().close();
        }
    }

    @FXML
    void UpdateButtonAction(ActionEvent event) throws SQLException {
        Statement statement = new ConnectSQL().connectSQL();
        assert statement != null;
        final String sql = "update student set name = '" + Name.getText() + "', gender = '" + Gender.getText() + "', address = '" + Address.getText() + "', phone = '" + Phone.getText() + "', major = '" + Major.getText() + "' where id = '" + Number.getText() + "';";
        System.out.println(sql);
        if (statement.executeUpdate(sql) > 0) {
            new MassageInformation().show("update Successfully!", sql);
        } else {
            new MassageError().show("update Error!", "Insert Error,Maybe The Table Is Restricted");
        }
        statement.getConnection().close();
        clearText();
    }

    private void clearText() {
        Number.clear();
        Name.clear();
        Gender.clear();
        Address.clear();
        Phone.clear();
        Major.clear();
    }

    Parent createNode() throws IOException {
        return FXMLLoader.load(getClass().getResource("../source/UpdateFxml.fxml"));
    }
}
