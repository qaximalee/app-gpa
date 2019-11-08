package com.ihsinformatics.gpaconvertor.services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ihsinformatics.gpaconvertor.entities.Student;
import com.ihsinformatics.gpaconvertor.interfaces.ICrudOperations;
import com.ihsinformatics.gpaconvertor.singleton.DBConnection;

public class StudentService implements ICrudOperations<Student> {

	private final String TABLE_NAME = "student";

	@Override
	public boolean save(Student data) {
		// TODO Auto-generated method stub
		Connection con = null;
		PreparedStatement st = null;
		try {
			// boolean connected = DBConnection.getInstance().getConnStatus();
			System.out.println(data.getFirstName() + " ================================ " + data.getLastName());
			con = DBConnection.getInstance().getConnection();
			boolean connected = DBConnection.getInstance().getConnStatus();
			if (connected) {
				st = con.prepareStatement(
						"INSERT INTO " + TABLE_NAME + " ( registration_no, first_name, last_name) VALUES(?,?,?)");
				st.setString(1, data.getRegistrationNo());
				st.setString(2, data.getFirstName());
				st.setString(3, data.getLastName());

				st.execute();
				return true;
			} else {
				System.out.println("Problem");
				return false;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean delete(int id) {
		// TODO Auto-generated method stub
		Connection con = null;
		PreparedStatement st = null;
		try {
			boolean connected = DBConnection.getInstance().getDBUtility().tryConnection();
			con = DBConnection.getInstance().getConnection();
			if (connected) {
				st = con.prepareStatement("DELETE FROM " + TABLE_NAME + " WHERE student_id = ?");
				st.setInt(1, id);
				int rowAffected = st.executeUpdate();
				if (rowAffected > 0)
					return true;
			} else {
				System.out.println("Problem");
				return false;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean update(Student data) {
		// TODO Auto-generated method stub
		Connection con = null;
		PreparedStatement st = null;
		try {
			boolean connected = DBConnection.getInstance().getDBUtility().tryConnection();
			con = DBConnection.getInstance().getConnection();
			if (connected) {
				st = con.prepareStatement("UPDATE " + TABLE_NAME
						+ " SET registration_no = ?, first_name = ?, last_name = ? WHERE student_id = ?");
				st.setString(1, data.getRegistrationNo());
				st.setString(2, data.getFirstName());
				st.setString(3, data.getLastName());
				st.setInt(4, data.getStudentId());
				int rowAffected = st.executeUpdate();
				if (rowAffected > 0)
					return true;
			} else {
				System.out.println("Problem");
				return false;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return false;
	}

	@Override
	public List<Student> getAll() {
		// TODO Auto-generated method stub
		Connection con = null;
		PreparedStatement st = null;
		try {
			boolean connected = DBConnection.getInstance().getDBUtility().tryConnection();
			con = DBConnection.getInstance().getConnection();
			if (connected) {
				st = con.prepareStatement("SELECT * FROM " + TABLE_NAME);
				ResultSet results = st.executeQuery();
				List<Student> students = new ArrayList<>();
				while (results.next()) {
					students.add(new Student(results.getInt("student_id"), results.getString("registration_no"),
							results.getString("first_name"), results.getString("last_name")));
				}
				if (students != null)
					return students;
			} else {
				System.out.println("Problem");
				return null;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Student getSingle(int id) {
		// TODO Auto-generated method stub

		Student student = null;
		Connection con = null;
		PreparedStatement st = null;
		try {
			boolean connected = DBConnection.getInstance().getDBUtility().tryConnection();
			con = DBConnection.getInstance().getConnection();
			if (connected) {
				st = con.prepareStatement("SELECT * FROM " + TABLE_NAME + " WHERE student_id = ?");
				st.setInt(1, id);
				ResultSet results = st.executeQuery();
				while (results.next()) {
					student = new Student(results.getInt("student_id"), results.getString("registration_no"),
							results.getString("first_name"), results.getString("last_name"));
				}
				return student;
			} else {
				System.out.println("Problem");
				return null;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;
	}
}
