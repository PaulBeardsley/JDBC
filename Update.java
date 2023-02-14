package com.qa;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
//import java.sql.ResultSet;

public class Update {
	
	static Connection conn;
	static Statement statement;
	
	public static void proceed() {
		try {
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/exams", "root", "Pa$$w0rd");
			statement = conn.createStatement();
		} catch (SQLException e) {
			System.out.println("Connection failed.");
			e.printStackTrace();
		}
		try {
			statement.executeUpdate("UPDATE results SET name='David' WHERE id=2");
			statement.executeUpdate("UPDATE results SET maths=70 WHERE id=4");
			statement.executeUpdate("INSERT INTO results VALUES (8, 'Ursula', 75, 95)");
		} catch (SQLException e) {
			System.out.println("Insertion failed.");
			e.printStackTrace();
		}
	}
}
