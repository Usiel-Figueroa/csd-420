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
 * This program select in the databasedb MySQL database to test JDBC connection.
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

public class Select5 {

  public static void main(String args[]) {

    try {

      Connection con;

      // Load the MySQL JDBC driver
      Class.forName("com.mysql.cj.jdbc.Driver");

      // Updated database URL 
      String url = "jdbc:mysql://localhost:3306/databasedb?";

      // Connect using the correct credentials
      con = DriverManager.getConnection(url + "user=student1&password=pass");

      System.out.println("Connection established - now executing a select");

      // Create a statement to execute queries
      Statement stmt = con.createStatement();

      // Execute query to get all rows from address33
      ResultSet rs = stmt.executeQuery("SELECT * FROM address33");

      System.out.println("Received Results:");

      int columnCount = rs.getMetaData().getColumnCount();

      // Display each row
      while (rs.next()) {
        for (int i = 1; i <= columnCount; ++i) {
          System.out.println(rs.getString(i));
        }
        System.out.println(); // Blank line between rows
      }

      stmt.close();
      con.close();
    } catch (Exception ex) {
      ex.printStackTrace();
    }
  }
}
