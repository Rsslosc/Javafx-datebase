package system;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.sql.SQLException;
import java.sql.Statement;

public class Entry {
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

    //不能写构造函数

    @FXML
    void SignInButtonAction(ActionEvent event) throws SQLException {
        if(Number.getText().length() == 0){
            new MassageError().show("Entry Error!","Student Number Is Not Null,Please Input Student Number.");
        }
        else {
            entrySQL(Number.getText(),Name.getText(),Gender.getText(),Address.getText(),Phone.getText(),Major.getText());
        }
    }
    @FXML
    void ResetButtonAction(ActionEvent event){
        clearText();
    }
    private void entrySQL(String Number, String Name, String Gender, String Address, String Phone, String Major) throws SQLException {
        Statement statement = new ConnectSQL().connectSQL();
        assert statement != null;
        final String sql = "insert into student values('" + Number + "','" + Name + "','" + Gender + "','" + Address + "','" + Phone + "','" + Major + "');";
        if(statement.executeUpdate(sql) > 0){
           new MassageInformation().show("Entry Successfully!",sql);
        }else{
            new MassageError().show("Entry Error!","Insert Error,Maybe The Table Is Restricted");
        }
        statement.getConnection().close();
        clearText();
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
        return FXMLLoader.load(getClass().getResource("../source/EntryFxml.fxml"));
    }
}
