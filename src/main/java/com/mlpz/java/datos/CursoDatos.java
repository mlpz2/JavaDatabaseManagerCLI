package com.mlpz.java.datos;

import java.sql.*;
import java.util.*;

import com.mlpz.java.domain.Conexion;
import com.mlpz.java.domain.Curso;

public class CursoDatos {

	private static final String SELECT_SQL = "SELECT * FROM cursos";
	private static final String SELECT_ID_SQL = "SELECT * FROM cursos WHERE id = ?";
	private static final String INSERT_SQL = "INSERT INTO cursos(nombre, id_a1, id_a2, id_a3, id_a4, id_a5, id_a6, id_a7, id_a8, id_a9, id_a10)"
			+ "VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
	private static final String UPDATE_SQL = "UPDATE cursos SET nombre = ?, id_a1 = ?, id_a2 = ?, id_a3 = ?, id_a4 = ?, id_a5 = ?, id_a6 = ?,"
			+ "id_a7 = ?, id_a8 = ?, id_a9 = ?, id_a10 = ? WHERE id = ?";
	private static final String DELETE_SQL = "DELETE FROM cursos WHERE id = ?";
	
	public ArrayList<Curso> select(){
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Curso curso = null;
		ArrayList<Curso> cursos = new ArrayList<>();
		
		try {
			conn = Conexion.obtenerConexion();
			ps = conn.prepareStatement(SELECT_SQL);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				int id = rs.getInt("id");
				String nombre = rs.getString("nombre");
				List<Integer> idA = new ArrayList<>();
				idA.add(rs.getInt("id_a1"));
				idA.add(rs.getInt("id_a2"));
				idA.add(rs.getInt("id_a3"));
				idA.add(rs.getInt("id_a4"));
				idA.add(rs.getInt("id_a5"));
				idA.add(rs.getInt("id_a6"));
				idA.add(rs.getInt("id_a7"));
				idA.add(rs.getInt("id_a8"));
				idA.add(rs.getInt("id_a9"));
				idA.add(rs.getInt("id_a10"));
				
				curso = new Curso(id, nombre, idA);
				cursos.add(curso);
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
		
		return cursos;		
	}

	public Curso select(int id){
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Curso curso = null;
		
		try {
			conn = Conexion.obtenerConexion();
			ps = conn.prepareStatement(SELECT_ID_SQL);
			ps.setInt(1, id);
			rs = ps.executeQuery();
		
			if(rs.next()) {
				String nombre = rs.getString("nombre");
				List<Integer> idA = new ArrayList<>();
				idA.add(rs.getInt("id_a1"));
				idA.add(rs.getInt("id_a2"));
				idA.add(rs.getInt("id_a3"));
				idA.add(rs.getInt("id_a4"));
				idA.add(rs.getInt("id_a5"));
				idA.add(rs.getInt("id_a6"));
				idA.add(rs.getInt("id_a7"));
				idA.add(rs.getInt("id_a8"));
				idA.add(rs.getInt("id_a9"));
				idA.add(rs.getInt("id_a10"));
				
				curso = new Curso(id, nombre, idA);
			} else {
				System.out.println("No existe el curso");				
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
		
		return curso;		
	}
	
	public void insert(Curso curso) {
		Connection conn = null;
		PreparedStatement ps = null;
		
		try {
			conn = Conexion.obtenerConexion();
			ps = conn.prepareStatement(INSERT_SQL);
			ps.setString(1, curso.getNombre());
			
			int cantAsig = curso.getIdA().size();
			
			for(int i = 0; i < cantAsig; i++) {
				ps.setInt(i+2, curso.getIdA().get(i));
			}
			
			if(cantAsig < 10) {
				for (int i = cantAsig + 2; i <= 11; i++) {
					ps.setNull(i, java.sql.Types.INTEGER);
				}
			}
			
			ps.execute();
			System.out.println("Insert Curso Success!");
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Insert Curso Fail!");
		} finally {
			try {
				ps.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	public void update(Curso curso) {
		Connection conn = null;
		PreparedStatement ps = null;
		
		try {
			conn = Conexion.obtenerConexion();
			ps = conn.prepareStatement(UPDATE_SQL);
			ps.setString(1, curso.getNombre());
			
			int cantAsig = curso.getIdA().size();
			
			for(int i = 0; i < cantAsig; i++) {
				ps.setInt(i+2, curso.getIdA().get(i));
			}
			
			if(cantAsig < 10) {
				for (int i = cantAsig + 2; i <= 11; i++) {
					ps.setNull(i, java.sql.Types.INTEGER);
				}
			}
			ps.setInt(12, curso.getId());
			
			ps.execute();
			System.out.println("Update Curso Success!");
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Update Curso Fail!");
		} finally {
			try {
				ps.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public void delete(Curso curso) {
		Connection conn = null;
		PreparedStatement ps = null;
		
		try {
			conn = Conexion.obtenerConexion();
			ps = conn.prepareStatement(DELETE_SQL);
			ps.setInt(1, curso.getId());
			
			ps.execute();
			System.out.println("Delete Curso Success!");
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Delete Curso Fail!");
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
