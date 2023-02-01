package JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class JDBC4 {
	public static void main(String args[]) {
	try {
		String userName = "root";
		String password = "Ragul@123";
		Class.forName("com.mysql.jdbc.Driver");
		Connection connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/dummy", userName, password);
		Statement stmt = connection.createStatement();
		ResultSet resultSet = stmt.executeQuery("SELECT * FROM person_table");
		
		System.out.println(resultSet.getMetaData().getColumnCount());
		System.out.println(resultSet.getMetaData().getColumnName(1));
		System.out.println(resultSet.getMetaData().getColumnType(1));
		connection.close();
		
	}
	catch(Exception obj) {
		System.out.println(obj);
	}
}

}
