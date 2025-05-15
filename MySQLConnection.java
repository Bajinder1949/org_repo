import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySQLConnection {

    // Database credentials
    private static final String URL = "jdbc:mysql://localhost:3306/your_database_name";
    private static final String USER = "your_username";
    private static final String PASSWORD = "your_password";

    // JDBC Connection method
    public static Connection getConnection() {
        Connection connection = null;

        try {
            // Load MySQL JDBC Driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Establish connection
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("Connection successful!");

        } catch (ClassNotFoundException e) {
            System.err.println("MySQL JDBC Driver not found.");
            e.printStackTrace();
        } catch (SQLException e) {
            System.err.println("Connection failed.");
            e.printStackTrace();
        }

        return connection;
    }

    // For testing the connection
    public static void main(String[] args) {
        Connection conn = getConnection();
        if (conn != null) {
            try {
                conn.close();
                System.out.println("Connection closed.");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
