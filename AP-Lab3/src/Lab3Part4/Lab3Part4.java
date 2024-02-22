package Lab3Part4;

import java.sql.*;

public class Lab3Part4 {
        static String urlDB = "jdbc:mysql://localhost:3306/ap_lab3";
        static String usernameDB = "Cillian";
        static String passwordDB = "Cillian80";
    public static void main(String[] args) {
//        Create("testing", "id INTEGER", "name VARCHAR(45)");
        read("*", "testing");
        insert("1", "id", "testing");
        read("*", "testing");
        delete("id", "testing", "1");
        read("*", "testing");
    }

    public static void Create(String tableName, String firstAttribute, String secondAttribute) {
        try (Connection con = DriverManager.getConnection(urlDB, usernameDB, passwordDB)) {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Statement stmt = con.createStatement();
            String query = "CREATE TABLE " + tableName + " (" + firstAttribute + " not null, " + secondAttribute + ")";
            System.out.println(query);
            stmt.executeUpdate(query);
        } catch (SQLSyntaxErrorException e) {
            System.out.println("Error when creating table" + tableName);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void read(String selector, String table) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con=DriverManager.getConnection(urlDB, usernameDB, passwordDB);
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("select " + selector + " from " + table);
            while (rs.next())
                System.out.println(rs.getInt(1) + " " + rs.getString(2));
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void insert(String data, String column, String table) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con =
                    DriverManager.getConnection(urlDB, usernameDB, passwordDB);
                            Statement stmt = con.createStatement();
            String query = "INSERT INTO " + table + " (" + column + ") VALUES (" + data + ")";
            stmt.executeUpdate(query);
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    public static void delete(String data, String table, String value) {
        try (Connection con = DriverManager.getConnection(urlDB, usernameDB, passwordDB)) {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Statement stmt = con.createStatement();
            String query = "DELETE FROM " + table + " " + data + " WHERE " + data + "=" + value;
            System.out.println("Attempt update " + query);
            stmt.executeUpdate(query);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
