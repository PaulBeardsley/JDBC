package com.qa;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;

public class Read {
	
	static Connection conn;
	static Statement statement;
	
	public static void proceed() {
		String query = "SELECT * FROM exams.results\r\n"
				+ "WHERE maths > 50 AND english < 60";
		ResultSet rs;
		try {
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/exams", "root", "Pa$$w0rd");
			statement = conn.createStatement();
		} catch (SQLException e) {
			System.out.println("Connection failed.");
			e.printStackTrace();
		}
		try {
			rs = statement.executeQuery(query);
			while(rs.next()) {
				System.out.println("ID: " + rs.getInt("id")
				+ "\tName: " + rs.getString("name")
				+ "\tMaths: " + rs.getInt("maths")
				+ "\tEnglish: " + rs.getInt("english"));
			}
		} catch (SQLException e) {
			System.out.println("Bad query.");
			e.printStackTrace();
		}
	}
}
