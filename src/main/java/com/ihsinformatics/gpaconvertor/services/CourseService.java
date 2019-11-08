package com.ihsinformatics.gpaconvertor.services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ihsinformatics.gpaconvertor.entities.Course;
import com.ihsinformatics.gpaconvertor.interfaces.ICrudOperations;
import com.ihsinformatics.gpaconvertor.singleton.DBConnection;

public class CourseService implements ICrudOperations<Course> {

	private final String TABLE_NAME = "course";

	@Override
	public boolean save(Course data) {
		// TODO Auto-generated method stub
		Connection con = null;
		PreparedStatement st = null;
		try {
			boolean connected = DBConnection.getInstance().getDBUtility().tryConnection();
			con = DBConnection.getInstance().getConnection();
			if (connected) {
				st = con.prepareStatement("INSERT INTO " + TABLE_NAME + " ( code, name, semester_id) VALUES(?,?,?)");
				st.setInt(1, data.getCourseCode());
				st.setString(2, data.getName());
				st.setInt(3, data.getSemesterId());

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
				st = con.prepareStatement("DELETE FROM " + TABLE_NAME + " WHERE course_id = ?");
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
	public boolean update(Course data) {
		// TODO Auto-generated method stub
		Connection con = null;
		PreparedStatement st = null;
		try {
			boolean connected = DBConnection.getInstance().getDBUtility().tryConnection();
			con = DBConnection.getInstance().getConnection();
			if (connected) {
				st = con.prepareStatement(
						"UPDATE " + TABLE_NAME + " SET code = ?, name = ?, semester_id = ? WHERE course_id = ?");
				st.setInt(1, data.getCourseCode());
				st.setString(2, data.getName());
				st.setInt(3, data.getSemesterId());
				st.setInt(4, data.getCourseId());
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
	public List<Course> getAll() {
		// TODO Auto-generated method stub
		Connection con = null;
		PreparedStatement st = null;
		try {
			boolean connected = DBConnection.getInstance().getDBUtility().tryConnection();
			con = DBConnection.getInstance().getConnection();
			if (connected) {
				st = con.prepareStatement("SELECT * FROM " + TABLE_NAME);
				ResultSet results = st.executeQuery();
				List<Course> course = new ArrayList<>();
				while (results.next()) {
					course.add(new Course(results.getInt("course_id"), results.getInt("code"),
							results.getString("name"), results.getInt("semester_id")));
				}
				if (course != null)
					return course;
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
	public Course getSingle(int id) {
		// TODO Auto-generated method stub

		Course course = null;
		Connection con = null;
		PreparedStatement st = null;
		try {
			boolean connected = DBConnection.getInstance().getDBUtility().tryConnection();
			con = DBConnection.getInstance().getConnection();
			if (connected) {
				st = con.prepareStatement("SELECT * FROM " + TABLE_NAME + " WHERE course_id = ?");
				st.setInt(1, id);
				ResultSet results = st.executeQuery();
				while (results.next()) {
					course = new Course(results.getInt("course_id"), results.getInt("code"), results.getString("name"),
							results.getInt("semester_id"));
				}
				return course;
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

	public List<Course> getCoursesBySemester(int semesterId) {
		Connection con = null;
		PreparedStatement st = null;
		try {
			boolean connected = DBConnection.getInstance().getDBUtility().tryConnection();
			con = DBConnection.getInstance().getConnection();
			if (connected) {
				st = con.prepareStatement("SELECT * FROM " + TABLE_NAME + " WHERE semester_id = ?");
				st.setInt(1, semesterId);
				ResultSet results = st.executeQuery();
				List<Course> course = new ArrayList<>();
				while (results.next()) {
					course.add(new Course(results.getInt("course_id"), results.getInt("code"),
							results.getString("name"), results.getInt("semester_id")));
				}
				if (course != null)
					return course;
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
