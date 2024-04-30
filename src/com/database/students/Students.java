package com.database.students;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Students {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub

		StudentDetails student1 = new StudentDetails(7,"mama");
		//insertStudent(student1);
		//updateStudent(5, "babu");
		read();

	}

	public static void insertStudent(StudentDetails student) throws ClassNotFoundException, SQLException {
		Connection connection = JdbcConnection.getConnection();

		String insertQuery = "INSERT INTO student_Details (id, name) VALUES (?, ?)";
		PreparedStatement ps = connection.prepareStatement(insertQuery);
		
		ps.setInt(1, student.getId());
		ps.setString(2, student.getName());
		
		int rows = ps.executeUpdate();
		System.out.println(rows + " rows inserted");
	}

	public static void read() throws ClassNotFoundException, SQLException {
		Connection connection = JdbcConnection.getConnection();
		String selectQuery = "SELECT id, name FROM student_Details";
		PreparedStatement preparedStatement = connection.prepareStatement(selectQuery);
		ResultSet resultSet = preparedStatement.executeQuery();
		System.out.println("Student Records:");
		while (resultSet.next()) {
			System.out.println("Id: " + resultSet.getInt("id") + ", Name: " + resultSet.getString("name"));
		}
	}

	public static void updateStudent(int id, String name) throws ClassNotFoundException, SQLException {
		Connection connection = JdbcConnection.getConnection();
		String updateQuery = "UPDATE student_Details SET name=? where id=?";
		PreparedStatement preparedStatement = connection.prepareStatement(updateQuery);
		
	
		preparedStatement.setString(1, name);
		preparedStatement.setInt(2, id);
		
		int rows = preparedStatement.executeUpdate();
		System.out.println(rows + " rows updated");
	}

	public static void deleteStudent(int id) throws ClassNotFoundException, SQLException {
		Connection connection = JdbcConnection.getConnection();
		String deleteQuery = "DELETE FROM student_Details WHERE id=?";
		PreparedStatement preparedStatement = connection.prepareStatement(deleteQuery);
		preparedStatement.setInt(1, id);
		int rows = preparedStatement.executeUpdate();
		System.out.println(rows + " rows deleted");
	}

}
