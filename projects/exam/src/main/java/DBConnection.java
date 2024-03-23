import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * This class is used to connect to the database.
 */
public class DBConnection {
    Connection conn;

    public DBConnection() throws SQLException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            return;
        }
        conn = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/jee_exam?createDatabaseIfNotExist=true&serverTimezone=UTC", "root",
                "root");
    }

    public Connection getConnection() {
        return conn;
    }
}