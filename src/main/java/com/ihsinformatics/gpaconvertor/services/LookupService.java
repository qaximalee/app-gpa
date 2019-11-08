package com.ihsinformatics.gpaconvertor.services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ihsinformatics.gpaconvertor.entities.Lookup;
import com.ihsinformatics.gpaconvertor.interfaces.ICrudOperations;
import com.ihsinformatics.gpaconvertor.singleton.DBConnection;

public class LookupService implements ICrudOperations<Lookup> {

	private final String TABLE_NAME = "lookup";

	@Override
	public boolean save(Lookup data) {
		// TODO Auto-generated method stub
		Connection con = null;
		PreparedStatement st = null;
		try {
			boolean connected = DBConnection.getInstance().getDBUtility().tryConnection();
			con = DBConnection.getInstance().getConnection();
			if (connected) {
				st = con.prepareStatement("INSERT INTO " + TABLE_NAME
						+ " (grade, start_percentage, end_percentage, gpa) VALUES (?,?,?,?)");
				st.setString(1, data.getGrade());
				st.setDouble(2, data.getStartParcentage());
				st.setDouble(3, data.getEndPercentage());
				st.setDouble(4, data.getGpa());
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
				st = con.prepareStatement("DELETE FROM " + TABLE_NAME + " WHERE lookup_id = ?");
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
	public boolean update(Lookup data) {
		// TODO Auto-generated method stub
		Connection con = null;
		PreparedStatement st = null;
		try {
			boolean connected = DBConnection.getInstance().getDBUtility().tryConnection();
			con = DBConnection.getInstance().getConnection();
			if (connected) {
				st = con.prepareStatement("UPDATE " + TABLE_NAME
						+ " SET grade = ?, start_percentage = ?, end_percentage = ?, gpa = ? WHERE lookup_id = ?");
				st.setString(1, data.getGrade());
				st.setDouble(2, data.getStartParcentage());
				st.setDouble(3, data.getEndPercentage());
				st.setDouble(4, data.getGpa());
				st.setInt(5, data.getLookupId());
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
	public List<Lookup> getAll() {
		// TODO Auto-generated method stub
		Connection con = null;
		PreparedStatement st = null;
		try {
			boolean connected = DBConnection.getInstance().getDBUtility().tryConnection();
			con = DBConnection.getInstance().getConnection();
			if (connected) {
				st = con.prepareStatement("SELECT * FROM " + TABLE_NAME);
				ResultSet results = st.executeQuery();
				List<Lookup> lookup = new ArrayList<>();
				while (results.next()) {
					lookup.add(new Lookup(results.getInt("lookup_id"), results.getString("grade"),
							results.getDouble("start_percentage"), results.getDouble("end_percentage"),
							results.getDouble("gpa")));
				}
				if (lookup != null)
					return lookup;
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
	public Lookup getSingle(int id) {
		// TODO Auto-generated method stub
		Lookup lookup = null;
		Connection con = null;
		PreparedStatement st = null;
		try {
			boolean connected = DBConnection.getInstance().getDBUtility().tryConnection();
			con = DBConnection.getInstance().getConnection();
			if (connected) {
				st = con.prepareStatement("SELECT * FROM " + TABLE_NAME + " WHERE lookup_id = ?");
				st.setInt(1, id);
				ResultSet results = st.executeQuery();
				while (results.next()) {
					lookup = new Lookup(results.getInt("lookup_id"), results.getString("grade"),
							results.getDouble("start_percentage"), results.getDouble("end_percentage"),
							results.getDouble("gpa"));
				}
				return lookup;
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
