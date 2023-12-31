package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnDB {
	private final static String dbUser = "root";
	private final static String dbPass = "";
	private final static String dbAddress = "localhost";
	private final static String dbPort = "3306";
	private final static String dbDatabase = "monitoria_poo";

	private Connection conn;

	public Connection getConnection() {
		try {
			//		Iniciando a conexão com o banco.		//
			this.conn = DriverManager.getConnection("jdbc:mysql://" + dbAddress + ":" + dbPort + "/" + dbDatabase, dbUser, dbPass);
			return this.conn;
		} catch (SQLException e) {
			System.out.println("Houve um erro ao se conectar com o banco de dados!");
			return null;
		}
	}

	public void closeConnection() {
		if (this.conn != null) {
			try {
				//		Fechando a conexão com o banco.		// 
				this.conn.close();
			} catch (SQLException e) {
				System.out.println("Houve um erro ao fechar fechar a conexão com o banco de dados!");
			}
		}
	}
}
