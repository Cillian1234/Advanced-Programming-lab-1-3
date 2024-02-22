package Lab3Part4;

import java.sql.*;

public class Lab3Part4 {
    public static void main(String[] args) {
        String urlDB = "jdbc:mysql://localhost:3306";
        String usernameDB = "Cillian";
        String passwordDB = "Cillian80";
        try (Connection con = DriverManager.getConnection(urlDB, usernameDB, passwordDB)) {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Statement stmt = con.createStatement();
            String query = "CREATE TABLE STUDENT" + "(id INTEGER not NULL, " + " first VARCHAR(255), " + " last VARCHAR(255), " + " PRIMARY KEY ( id ))";
            stmt.executeUpdate(query);

        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
