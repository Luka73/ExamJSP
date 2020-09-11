package com.mcit.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
	
	private static Connection connection = null;
	public static final String URL = "jdbc:oracle:thin:@localhost:1521:XE";
	public static final String USER = "hr";
	public static final String PASS = "root";
	    
	 public static Connection getConnection() {

		try {
			
			Class.forName("oracle.jdbc.driver.OracleDriver"); //força o carregamento do drive
			connection = DriverManager.getConnection(URL, USER, PASS);
			System.out.println("Conectado com sucesso!");
			return connection;
			
		} catch (SQLException e) {
			throw new RuntimeException("Error connecting to the database", e);
		} catch(ClassNotFoundException e) {
			throw new RuntimeException("Drive oracle não encontrado", e);
		}
	 }

	 public void closeConnection() throws SQLException {
		if (connection != null) {
		    connection.close();
		}
	 }
}
