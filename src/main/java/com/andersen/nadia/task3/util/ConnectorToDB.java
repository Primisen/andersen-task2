package com.andersen.nadia.task3.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectorToDB {

	private static final String URL = "jdbc:postgresql://192.168.31.71/application"; // эти данные закинуть бы в ресурсы
	private static final String USERNAME = "nadia";
	private static final String PASSWORD = "111";

	private ConnectorToDB() {
	}

	public static Connection getConnection() {

		Connection connection = null;

		try {
			Class.forName("org.postgresql.Driver");
			connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);

		} catch (Exception e) {

			//
			e.printStackTrace();
		}

		return connection;
	}

}
