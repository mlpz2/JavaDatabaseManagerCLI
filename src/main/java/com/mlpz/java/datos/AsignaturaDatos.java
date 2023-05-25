package com.mlpz.java.datos;

import java.sql.*;
import java.util.*;

import com.mlpz.java.domain.Asignatura;
import com.mlpz.java.domain.Conexion;

public class AsignaturaDatos {

	private static final String SELECT_SQL = "SELECT * FROM asignaturas";
	private static final String SELECT_ID_SQL = "SELECT * FROM asignaturas WHERE id = ?";
	private static final String SELECT_NAME_SQL = "SELECT nombre FROM asignaturas WHERE id = ?";
	private static final String INSERT_SQL = "INSERT INTO asignaturas (`nombre`, `id_profesor1`, `id_profesor2`) VALUES (?, ?, ?);";
	private static final String UPDATE_SQL = "UPDATE asignaturas SET `nombre` = ?, `id_profesor1` = ?, `id_profesor2` = ? WHERE id = ?";
	private static final String DELETE_SQL = "DELETE FROM asignaturas WHERE id = ?";
	
	public List<Asignatura> select(){
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Asignatura asignatura = null;
		List<Asignatura> asignaturas = new ArrayList<>();
		
		try {
			conn = Conexion.obtenerConexion();
			ps = conn.prepareStatement(SELECT_SQL);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				int id = rs.getInt("id");
				String nombre = rs.getString("nombre");
				int idp1 = rs.getInt("id_profesor1");
				int idp2 = rs.getInt("id_profesor2");
				
				asignatura = new Asignatura(id, nombre, idp1, idp2);
				asignaturas.add(asignatura);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				ps.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		}
		return asignaturas;
	}

	public Asignatura select(int id){
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Asignatura asignatura = null;
		
		try {
			conn = Conexion.obtenerConexion();
			ps = conn.prepareStatement(SELECT_ID_SQL);
			ps.setInt(1, id);
			rs = ps.executeQuery();
			
			if(rs.next()) {
				String nombre = rs.getString("nombre");
				int idp1 = rs.getInt("id_profesor1");
				int idp2 = rs.getInt("id_profesor2");
				
				asignatura = new Asignatura(id, nombre, idp1, idp2);
			} else {
				System.out.println("Asignatura no encontrada!");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				ps.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		}
		return asignatura;
	}

	public String selectName(int id){
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String nombre = "";
		
		try {
			conn = Conexion.obtenerConexion();
			ps = conn.prepareStatement(SELECT_NAME_SQL);
			ps.setInt(1, id);
			rs = ps.executeQuery();
			
			if(rs.next()) {
				nombre = rs.getString("nombre");	
			} else {
				System.out.println("Asignatura no encontrada!");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				ps.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		}
		return nombre;
	}
	
	
	public void insert(Asignatura asignatura) {
		Connection conn = null;
		PreparedStatement ps = null;
		
		try {
			conn = Conexion.obtenerConexion();
			ps = conn.prepareStatement(INSERT_SQL);
			ps.setString(1, asignatura.getNombre());
			ps.setInt(2, asignatura.getIdProfesor1());
			if(asignatura.getIdProfesor2() == 0) {
				ps.setNull(3, java.sql.Types.INTEGER);
			} else {
				ps.setInt(3, asignatura.getIdProfesor2());				
			}
			
			ps.execute();
			System.out.println("Insert Asignatura Success!");
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Insert Asignatura Fail!");
		} finally {
			try {
				ps.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		}
	}

	public void update(Asignatura asignatura) {
		Connection conn = null;
		PreparedStatement ps = null;
		
		try {
			conn = Conexion.obtenerConexion();
			ps = conn.prepareStatement(UPDATE_SQL);
			ps.setString(1, asignatura.getNombre());
			ps.setInt(2, asignatura.getIdProfesor1());
			if(asignatura.getIdProfesor2() == 0) {
				ps.setNull(3, java.sql.Types.INTEGER);
			} else {
				ps.setInt(3, asignatura.getIdProfesor2());				
			}
			ps.setInt(4, asignatura.getId());
			
			ps.execute();
			System.out.println("Update Success!");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				ps.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		}
	}
	
	public void delete(Asignatura asignatura) {
		Connection conn = null;
		PreparedStatement ps = null;
		
		try {
			conn = Conexion.obtenerConexion();
			ps = conn.prepareStatement(DELETE_SQL);
			ps.setInt(1, asignatura.getId());
			
			ps.execute();
			System.out.println("Delete Success!");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				ps.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		}
	}

	
}
