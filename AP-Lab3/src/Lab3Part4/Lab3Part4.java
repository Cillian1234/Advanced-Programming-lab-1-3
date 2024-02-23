package Lab3Part4;

import java.sql.*;

public class Lab3Part4 {
        static String urlDB = "jdbc:mysql://localhost:3306/AP_Lab3";
        static String usernameDB = "root";
        static String passwordDB = "Schoolemail101!";
    public static void main(String[] args) {
        Create("test", "id INTEGER", "name VARCHAR(45)");
        read("id", "testing");
        insert("1", "id", "testing");
        read("id", "testing");
        delete("id", "testing", "1");
        read("id", "testing");
    }

    /**
     * This method will create a table in the connected database and populate two attribute columns
     * @param tableName Name of table you wish to create
     * @param firstAttribute In the form of "[Name of attribute] [Attribute type]"
     * @param secondAttribute In the form of "[Name of attribute] [Attribute type]"
     */
    public static void Create(String tableName, String firstAttribute, String secondAttribute) {
        try (Connection con = DriverManager.getConnection(urlDB, usernameDB, passwordDB)){
            Class.forName("com.mysql.cj.jdbc.Driver");
            Statement stmt = con.createStatement();
            String query = "CREATE TABLE " + tableName + " (" + firstAttribute + " not null, " + secondAttribute + ")";
            System.out.println(query);
            stmt.executeUpdate(query);
        } catch (SQLSyntaxErrorException e) {
            System.out.println("Error when creating table" + tableName);
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    /**
     * This method will read from a given table and print the results to the console
     * @param attribute What you would like to read, e.g. "*", "id" etc.
     * @param table what table you would like to read from
     */
    public static void read(String attribute, String table) {
        try {
            Connection con=DriverManager.getConnection(urlDB, usernameDB, passwordDB);
            Class.forName("com.mysql.cj.jdbc.Driver");
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("select " + attribute + " from " + table);
            while (rs.next())
                System.out.println(rs.getInt(1));
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    /**
     * This method will insert a single data point into a given column in a given table
     * @param data What you would like to insert
     * @param column The column to insert into
     * @param table The table to insert into
     */
    public static void insert(String data, String column, String table) {
        try {
            Connection con = DriverManager.getConnection(urlDB, usernameDB, passwordDB);
            Class.forName("com.mysql.cj.jdbc.Driver");
            Statement stmt = con.createStatement();
            String query = "INSERT INTO " + table + " (" + column + ") VALUES (" + data + ")";
            stmt.executeUpdate(query);
            con.close();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    /**
     * This method will delete data from a table with a certain value
     * @param data The data to be deleted
     * @param table The table to delete from
     * @param value The values to delete
     */
    public static void delete(String data, String table, String value) {
        try (Connection con = DriverManager.getConnection(urlDB, usernameDB, passwordDB)) {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Statement stmt = con.createStatement();
            String query = "DELETE FROM " + table + " " + data + " WHERE " + data + "=" + value;
            System.out.println("Attempt update " + query);
            stmt.executeUpdate(query);
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
