package com.ihsinformatics.gpaconvertor.singleton;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import com.ihsinformatics.util.DatabaseUtil;

public class DBConnection {

	private static DBConnection instance;
	private Connection conn;
	private DatabaseUtil dbUtility;
	private boolean connStatus;

	private DBConnection() {
		Map<String, String> connProp = new HashMap<>();
		connProp = getConnectionInfo(); // DBInitialization.getConnProperties();

		dbUtility = new DatabaseUtil(connProp.get("url"), connProp.get("db-name"), connProp.get("db-driver"),
				connProp.get("db-username"), connProp.get("db-password"));

		connStatus = dbUtility.tryConnection();

		try {
			conn = dbUtility.getConnection();
		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}

	private Map<String, String> getConnectionInfo() {
		File file = new File("D:\\Java Projects\\app-gpa\\connection.properties");
		Map<String, String> connProp = new HashMap<>();
		BufferedReader br;
		try {
			br = new BufferedReader(new FileReader(file));
			String st;

			while ((st = br.readLine()) != null) {
				if (st.startsWith("connection")) {
					String[] rowsCols = st.split("=");
					if (rowsCols[0].equals("connection.url"))
						connProp.put("url", rowsCols[1]);
					else if (rowsCols[0].equals("connection.db-name"))
						connProp.put("db-name", rowsCols[1]);
					else if (rowsCols[0].equals("connection.db-username"))
						connProp.put("db-username", rowsCols[1]);
					else if (rowsCols[0].equals("connection.db-password"))
						connProp.put("db-password", rowsCols[1]);
					else if (rowsCols[0].equals("connection.db-driver"))
						connProp.put("db-driver", rowsCols[1]);
				}
			}

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return connProp;
	}

	public Connection getConnection() {
		return conn;
	}

	public boolean getConnStatus() {
		return connStatus;
	}

	public DatabaseUtil getDBUtility() {
		return dbUtility;
	}

	public static DBConnection getInstance() throws SQLException {
		if (instance == null) {
			instance = new DBConnection();
		} else if (instance.getConnection().isClosed())
			instance = new DBConnection();
		return instance;
	}
}
