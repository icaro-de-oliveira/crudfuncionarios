package CRUDFuncionario;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
    public static Connection getConnection() throws SQLException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            return DriverManager.getConnection("jdbc:mysql://localhost/agenda", "root", "senhamysql");
        } catch (ClassNotFoundException e) {
            throw new SQLException(e.getMessage());
        }
    }
}