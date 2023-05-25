package com.mlpz.java.domain;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {

	private static final String DB = "jdbc:mysql://localhost:3306/";
	private static final String TABLE = "fullstack";
	private static final String USER = "mlpz";
	private static final String PASS = "pass2";
	
	public static Connection obtenerConexion() throws SQLException {
		return DriverManager.getConnection(DB + TABLE, USER, PASS);
	}
	
}
