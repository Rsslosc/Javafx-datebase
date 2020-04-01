package system;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

class ConnectSQL {
    Statement connectSQL(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            new MassageError().show("Class Not Found!",e.getMessage());
        }
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/university?serverTimezone=CTT&useUnicode=true&characterEncoding=utf-8&allowMultiQueries=true",
                    "root","hadoop");
        } catch (SQLException e) {
            new MassageError().show("Connection Unavailable!",e.getMessage());
        }
        Statement statement = null;
        try {
            assert connection != null;
            statement = connection.createStatement();
        } catch (SQLException e) {
            new MassageError().show("Statement Unavailable!",e.getMessage());
        }
        return statement;
    }
}
