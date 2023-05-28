EXPERIMENT 8: -write a database applicatioon that uses jdbc driver
Program: -
  
  
Databasecreation.java
package DB;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
public class Databasecreation {
 static final String DB_URL = "jdbc:mysql://localhost:3306/";
 static final String USER = "root";
 static final String PASS = "MySQL";
 public static void main(String[] args) throws ClassNotFoundException {
 // Open a connection
 try
 {
 Class.forName("com.mysql.jdbc.Driver");
 Connection conn=DriverManager.getConnection(
 DB_URL, USER, PASS);
 Statement stmt=conn.createStatement();
 String sql = "CREATE DATABASE STUDENTS2";
 stmt.executeUpdate(sql);
 System.out.println("Database created successfully...");
 } catch (SQLException e) {
 e.printStackTrace();
 }
 }
}


Tablecreation.java


package DB;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
public class Tablecreation {
 static final String DB_URL = "jdbc:mysql://localhost:3306/STUDENTS2";
 static final String USER = "root";
 static final String PASS = "MySQL";
 public static void main(String[] args) throws ClassNotFoundException {
 // Open a connection
 try
 { Class.forName("com.mysql.jdbc.Driver");
 Connection conn=DriverManager.getConnection(
 DB_URL, USER, PASS);
 Statement stmt=conn.createStatement();
 String sql = "CREATE TABLE REG " +
 "(id INTEGER not NULL, " +
 " first VARCHAR(255), " +
 " last VARCHAR(255), " +
 " age INTEGER, " +
 " PRIMARY KEY ( id ))";
 stmt.executeUpdate(sql);
 System.out.println("Created table in given database...");
 } catch (SQLException e) {
 e.printStackTrace();
 } }}


Insertingdata.java


package DB;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
public class Insertingdata {
 static final String DB_URL = "jdbc:mysql://localhost:3306/STUDENTS2";
 static final String USER = "root";
 static final String PASS = "MySQL";
 public static void main(String[] args) throws ClassNotFoundException {
 // Open a connection
try
 {
 Class.forName("com.mysql.jdbc.Driver");
 Connection conn=DriverManager.getConnection(
 DB_URL, USER, PASS);
 Statement stmt=conn.createStatement();
 // Execute a query
 System.out.println("Inserting records into the table...");
 String sql = "INSERT INTO REG VALUES (100, 'Zara', 'Ali', 18)";
 stmt.executeUpdate(sql);
 sql = "INSERT INTO REG VALUES (101, 'Mahnaz', 'Fatma', 25)";
 stmt.executeUpdate(sql);
 sql = "INSERT INTO REG VALUES (102, 'Zaid', 'Khan', 30)";
 stmt.executeUpdate(sql);
 sql = "INSERT INTO REG VALUES(103, 'Sumit', 'Mittal', 28)";
 stmt.executeUpdate(sql);
 System.out.println("Inserted records into the table...");
 } catch (SQLException e) {
 e.printStackTrace();
 } }}


Displaydata.java


package DB;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
public class Displaydata {
 static final String DB_URL = "jdbc:mysql://localhost:3306/STUDENTS2";
 static final String USER = "root";
 static final String PASS = "MySQL";
 static final String QUERY = "SELECT id, first, last, age FROM REG";
 public static void main(String[] args) throws ClassNotFoundException {
 // Open a connection
 try
 {
 Class.forName("com.mysql.jdbc.Driver");
 Connection conn=DriverManager.getConnection(
 DB_URL, USER, PASS);
 Statement stmt=conn.createStatement();
 ResultSet rs = stmt.executeQuery(QUERY);
 while(rs.next()){
 System.out.print("ID: " + rs.getInt("id"));
 System.out.print(", Age: " + rs.getInt("age"));
 System.out.print(", First: " + rs.getString("first"));
 System.out.println(", Last: " + rs.getString("last"));
 }
 } catch (SQLException e) {
 e.printStackTrace();
 }}} 
