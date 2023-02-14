package com.qa;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
//import java.sql.ResultSet;

public class Delete {
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
			statement.executeUpdate("DELETE FROM results WHERE name='Lupin'");
		} catch (SQLException e) {
			System.out.println("Insertion failed.");
			e.printStackTrace();
		}
	}
}
