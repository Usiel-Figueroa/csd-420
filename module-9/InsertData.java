/*
 *
 * Professor Darrell Payne
 * Bellevue University
 *
 */
/*
 * Usiel Figueroa
 * April 25, 2025
 * CSD420-A311 Advanced Java Programming
 * M9: Programming Assignment – JDBC Setup Test
 *
 * This program insert data in the databasedb MySQL database to test JDBC connection.
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

public class InsertData {

    Connection con;
    Statement stmt;

    public InsertData() {

        try {
            // Load MySQL JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Correct JDBC URL 
            String url = "jdbc:mysql://localhost:3306/databasedb?serverTimezone=UTC";

            // Correct user credentials
            con = DriverManager.getConnection(url, "student1", "pass");

            stmt = con.createStatement();

        } catch (Exception e) {
            System.out.println("Error connection to database.");
            e.printStackTrace(); // Helpful for debugging
            System.exit(0);
        }

        try {
            // Insert data into the address33 table
            System.out.println(
                stmt.executeUpdate("INSERT INTO address33 VALUES(55, 'Larry', 'Rich', '1111 Redwing Circle888', 'Bellevue', 'NE', '68123')") + " row updated");
            System.out.println(
                stmt.executeUpdate("INSERT INTO address33 VALUES(1, 'Fine', 'Ruth', '1111 Redwing Circle', 'Bellevue', 'NE', '68123')") + " row updated");
            System.out.println(
                stmt.executeUpdate("INSERT INTO address33 VALUES(2, 'Howard', 'Curly', '1000 Galvin Road South', 'Bellevue', 'NE', '68005')") + " row updated");
            System.out.println(
                stmt.executeUpdate("INSERT INTO address33 VALUES(3, 'Howard', 'Will', '2919 Redwing Circle', 'Bellevue', 'NE', '68123')") + " row updated");
            System.out.println(
                stmt.executeUpdate("INSERT INTO address33 VALUES(4, 'Wilson', 'Larry', '1121 Redwing Circle', 'Bellevue', 'NE', '68124')") + " row updated");
            System.out.println(
                stmt.executeUpdate("INSERT INTO address33 VALUES(5, 'Johnson', 'George', '1300 Galvin Road South', 'Bellevue', 'NE', '68006')") + " row updated");
            System.out.println(
                stmt.executeUpdate("INSERT INTO address33 VALUES(6, 'Long', 'Matthew', '2419 Redwing Circle', 'Bellevue', 'NE', '68127')") + " row updated");
            System.out.println(
                stmt.executeUpdate("INSERT INTO address33 VALUES(44, 'Tom', 'Matthew', '1999 Redwing Circle', 'Bellevue', 'NE', '68123')") + " row updated");

            // Commit the transaction
            stmt.executeUpdate("COMMIT");

            System.out.println("Data Inserted");

        } catch (SQLException e) {
            System.out.println(e);
            System.out.println("Insert Data Failed");
        }

        try {
            // Close the statement and connection
            stmt.close();
            con.close();
            System.out.println("Database connections closed");

        } catch (SQLException e) {
            System.out.println("Connection close failed");
        }
    }

    public static void main(String args[]) {
        InsertData insertData = new InsertData();
    }
}
