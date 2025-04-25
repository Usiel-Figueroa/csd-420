/*
 *
 * Professor Darrell Payne
 * Bellevue University
 *
 */

/*
 * Usiel Figueroa
 * April 21, 2025
 * CSD420-A311 Advanced Java Programming
 * M9: Programming Assignment – JDBC Setup Test
 *
 * This program creates a table in the databasedb MySQL database to test JDBC connection.
 */

/** 

Reference 

(n.d.). JDBC - Sample, Example Code. Tutorialspoint. Retrieved April 21, 2025, from https://www.tutorialspoint.com/jdbc/jdbc-sample-code.htm 

(2025, March 24). 5 Steps to Connect Database in Java. Tpointtech. Retrieved April 21, 2025, from https://www.tpointtech.com/steps-to-connect-to-the-database-in-java 

(2025, April 17). Establishing JDBC Connection in Java. Geeksforgeeks. Retrieved April 21, 2025, from https://www.geeksforgeeks.org/establishing-jdbc-connection-in-java/ 

(n.d.). Class DriverManager. ORACLE. Retrieved April 21, 2025, from https://docs.oracle.com/en/java/javase/11/docs/api/java.sql/java/sql/DriverManager.html 

(n.d.). DriverManager Class. Microsoft. Retrieved April 21, 2025, from https://learn.microsoft.com/en-us/dotnet/api/java.sql.drivermanager?view=net-android-35.0 


*/ 

import java.sql.*;

public class CreateTable {

    Connection con;
    Statement stmt;

    public CreateTable() {

        try {
            // Load MySQL JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Updated JDBC URL to match assigned database name
            String url = "jdbc:mysql://localhost:3306/databasedb?serverTimezone=UTC";

            // Updated user credentials
            con = DriverManager.getConnection(url, "student1", "pass");
            stmt = con.createStatement();

        } catch (Exception e) {
            System.out.println("Error connection to database.");
            e.printStackTrace(); // Helpful for debugging!
            System.exit(0);
        }

        try {
            stmt.executeUpdate("DROP TABLE address33");
            System.out.println("Table address Dropped");
        } catch (SQLException e) {
            System.out.println("Table address does not exist");
        }

        try {
            stmt.executeUpdate("CREATE TABLE address33 (" +
                               "ID int PRIMARY KEY, " +
                               "LASTNAME varchar(40), " +
                               "FIRSTNAME varchar(40), " +
                               "STREET varchar(40), " +
                               "CITY varchar(40), " +
                               "STATE varchar(40), " +
                               "ZIP varchar(40))");
            System.out.println("Table address Created");
        } catch (SQLException e) {
            System.out.println("Table address Creation failed");
            e.printStackTrace(); // Helpful for debugging!
        }

        try {
            stmt.close();
            con.close();
            System.out.println("Database connections closed");
        } catch (SQLException e) {
            System.out.println("Connection close failed");
        }
    }

    public static void main(String args[]) {
        CreateTable createTable = new CreateTable();
    }
}
