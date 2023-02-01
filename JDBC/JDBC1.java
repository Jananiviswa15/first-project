package JDBC;
//"jdbc:mysql://127.0.0.1:3306/" --> entire connection dbs and tables
//"jdbc:mysql://127.0.0.1:3306/girlsdatabase" --> particular db 
import java.sql.DriverManager;

import java.sql.*;

public class JDBC1 {
	public static void main(String args[]) {
		try {
			String userName = "root";
			String password = "Ragul@123";
			Class.forName("com.mysql.jdbc.Driver");
			Connection connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/dummy", userName, password);
			//write queries , stmts
			Statement stmt = connection.createStatement();
		/*	//dml --> return a int val 
			int noOFRecrdsInserted = stmt.executeUpdate("INSERT INTO person_table(gender, name) values('Female', 'dharshini')");
			System.out.println(noOFRecrdsInserted + "inserted");*/
			/*int noOFRecrdDeleted = stmt.executeUpdate("DELETE FROM person_table WHERE id = 3"); //DML
			System.out.println(noOFRecrdDeleted + "deleted");*/
			ResultSet resultSet = stmt.executeQuery("SELECT * FROM person_table");
			while(resultSet.next()) {
				System.out.println(resultSet.getInt(1) + " " + resultSet.getString(2) + " "+ resultSet.getString(3));
			}
			connection.close();
		}
		catch(Exception obj) {
			System.out.println(obj);
		}
	}

}
