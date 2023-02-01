package JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class JDBC2 {

	public static void main(String args[]) {
		try {
		String userName = "root";
		String password = "Ragul@123";
		Class.forName("com.mysql.jdbc.Driver");
		Connection connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/dummy", userName, password);
		Statement stmt = connection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
		ResultSet resultSet = stmt.executeQuery("SELECT * FROM person_table");
		//previous, first
		resultSet.absolute(2); //2 --> row number in reslut not primary key / id
		System.out.println(resultSet.getInt(1) + " " + resultSet.getString(2) + " "+ resultSet.getString(3));
		resultSet.first();
		System.out.println(resultSet.getInt(1) + " " + resultSet.getString(2) + " "+ resultSet.getString(3));
		resultSet.last();
		System.out.println(resultSet.getInt(1) + " " + resultSet.getString(2) + " "+ resultSet.getString(3));
		resultSet.previous();
		System.out.println(resultSet.getInt(1) + " " + resultSet.getString(2) + " "+ resultSet.getString(3));
		
		connection.close();/* connection is c;losed so cant perform any operastions after it
		resultSet.first();
		System.out.println(resultSet.getInt(1) + " " + resultSet.getString(2) + " "+ resultSet.getString(3));*/
		
		
		}
		catch(Exception obj) {
			System.out.println(obj);
		}

	}
}
