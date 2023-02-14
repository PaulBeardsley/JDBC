package com.qa;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Create {
	
	static Connection conn;
	static Statement statement;

	
	public static void proceed() {
		String data;
		String newDB;
		String newTable;
		
		try {
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306", "root", "Pa$$w0rd");
			statement = conn.createStatement();
		} catch (SQLException e) {
			System.out.println("Connection 1 failed.");
			e.printStackTrace();
		}
		
		newDB = "CREATE DATABASE exams;";
		try {
			statement.executeUpdate(newDB);
		} catch (SQLException e) {
			System.out.println("Database creation failed.");
			e.printStackTrace();
		}
		try {
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/exams", "root", "Pa$$w0rd");
			statement = conn.createStatement();
		} catch (SQLException e) {
			System.out.println("Connection 2 failed.");
			e.printStackTrace();
		}
		
		newTable = "CREATE TABLE results " +
				"(id INTEGER not NULL, " +
				" Name VARCHAR(255), " +
				" Maths INTEGER, " +
				" English INTEGER, " +
				" PRIMARY KEY ( id ))";
		try {
			statement.executeUpdate(newTable);
		} catch (SQLException e) {
			System.out.println("Table creation failed.");
			e.printStackTrace();
		}
		try {
			data = "INSERT INTO results VALUES (1, 'Sam', 67, 82)";
			statement.executeUpdate(data);
			data = "INSERT INTO results VALUES (2, 'Dave', 91, 51)";
			statement.executeUpdate(data);
			data = "INSERT INTO results VALUES (3, 'Marjorie', 41, 60)";
			statement.executeUpdate(data);
			data = "INSERT INTO results VALUES (4, 'Chris', 60, 86)";
			statement.executeUpdate(data);
			data = "INSERT INTO results VALUES (5, 'Lupin', 78, 58)";
			statement.executeUpdate(data);
			data = "INSERT INTO results VALUES (6, 'Russ', 59, 58)";
			statement.executeUpdate(data);
			data = "INSERT INTO results VALUES (7, 'Susan', 70, 72)";
			statement.executeUpdate(data);
		} catch (SQLException e) {
			System.out.println("Insertion failed.");
			e.printStackTrace();
		}
		
		
	}
}
