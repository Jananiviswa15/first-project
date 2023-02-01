package JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class JDBC3 {
	public static void main(String args[]) {
		try {
			String userName = "root";
			String password = "Ragul@123";
			Class.forName("com.mysql.jdbc.Driver");
			Connection connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/dummy", userName, password);
			//prepARED STMT - DDL, DML
			
			/*PreparedStatement pstmt = connection.prepareStatement("INSERT INTO person_table(gender,name) VALUES (?, ?)");
			//scanner obj = new SCanner(Sytem.in);
			//sysout enter ur name
			//naem = obj.next();
			//sysout enter ur gender
			//gender = obj.next();
			pstmt.setString(1, "male");
			pstmt.setString(2, "ram");
			//int insert = pstmt.executeUpdate();*/
			PreparedStatement deletePstmt = connection.prepareStatement("DELETE FROM person_table WHERE id = ? ");
			Scanner obj = new Scanner(System.in);
			int deleteId = obj.nextInt();
			deletePstmt.setInt(1, deleteId);
			int insertRecrd = deletePstmt.executeUpdate();
			System.out.println(insertRecrd);
			connection.close();
		}
		catch(Exception obj) {
			System.out.println(obj);
		}
}
}
