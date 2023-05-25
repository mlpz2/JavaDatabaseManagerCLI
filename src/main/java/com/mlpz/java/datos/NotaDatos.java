package com.mlpz.java.datos;

import java.sql.*;
import java.util.*;

import com.mlpz.java.domain.*;

public class NotaDatos {

	private static final String SQL_SELECT_ONE = "SELECT nota FROM notas WHERE id_alumno = ? AND id_asignatura = ? AND id_curso = ?";
	private static final String SQL_SELECT_AC = "SELECT id_asignatura, nota FROM notas WHERE id_alumno = ? AND id_curso = ?;";
	private static final String SQL_SELECT_CA = "SELECT id_alumno, nota FROM notas WHERE id_curso = ? AND id_asignatura = ?;";
	private static final String SQL_SELECT_AA = "SELECT id_curso, nota FROM notas WHERE id_alumno = ? AND id_asignatura = ?;";
	private static final String SQL_SELECT_C = "SELECT id_alumno, id_asignatura, nota FROM notas WHERE id_curso = ?;";
	private static final String SQL_INSERT = "INSERT INTO notas(id_alumno, id_asignatura, id_curso, nota) VALUES(?, ?, ?, ?);";
	private static final String SQL_UPDATE = "UPDATE notas SET id_alumno = ?, id_asignatura = ?, id_curso = ?, nota = ? WHERE id = ?;";
	private static final String SQL_DELETE = "DELETE FROM notas WHERE id = ?";
	
	public Map<Integer, Float> select(Usuario usuario, Curso curso) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Map<Integer, Float> lista = new HashMap<Integer, Float>();
		
		try {
			conn = Conexion.obtenerConexion();
			ps = conn.prepareStatement(SQL_SELECT_AC);
			ps.setInt(1, usuario.getId());
			ps.setInt(2, curso.getId());

			rs = ps.executeQuery();
			
			while(rs.next()) {
				int idA = rs.getInt("id_asignatura");
				float nota = rs.getFloat("nota");
				lista.put(idA, nota);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}  finally {
			try {
				rs.close();
				ps.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return lista;
	}
	
	public Map<Integer, Float> select(Usuario usuario, Asignatura asignatura) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Map<Integer, Float> lista = new HashMap<Integer, Float>();
		
		try {
			conn = Conexion.obtenerConexion();
			ps = conn.prepareStatement(SQL_SELECT_AA);
			ps.setInt(1, usuario.getId());
			ps.setInt(2, asignatura.getId());

			rs = ps.executeQuery();
			
			while(rs.next()) {
				int idA = rs.getInt("id_asignatura");
				float nota = rs.getFloat("nota");
				lista.put(idA, nota);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}  finally {
			try {
				rs.close();
				ps.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return lista;
	}
	
	public Map<Integer, Float> select(Curso curso, Asignatura asignatura) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Map<Integer, Float> lista = new HashMap<Integer, Float>();
		
		try {
			conn = Conexion.obtenerConexion();
			ps = conn.prepareStatement(SQL_SELECT_CA);
			ps.setInt(1, curso.getId());
			ps.setInt(2, asignatura.getId());

			rs = ps.executeQuery();
			
			while(rs.next()) {
				int idA = rs.getInt("id_asignatura");
				float nota = rs.getFloat("nota");
				lista.put(idA, nota);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}  finally {
			try {
				rs.close();
				ps.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return lista;
	}
	
	
	public float select(Nota n) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		float nota = 0f;
		
		try {
			conn = Conexion.obtenerConexion();
			ps = conn.prepareStatement(SQL_SELECT_ONE);
			ps.setInt(1, n.getIdAlumno());
			ps.setInt(2, n.getIdAsignatura());
			ps.setInt(3, n.getIdCurso());

			rs = ps.executeQuery();
			
			if(rs.next()) {
				nota = rs.getFloat("nota");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}  finally {
			try {
				rs.close();
				ps.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return nota;
	}

	public List<Nota> select(Curso curso) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<Nota> notas = new ArrayList<>();
		Nota nota = null;
		
		try {
			conn = Conexion.obtenerConexion();
			ps = conn.prepareStatement(SQL_SELECT_C);
			ps.setInt(1, curso.getId());

			rs = ps.executeQuery();
			
			while(rs.next()) {
				int idU = rs.getInt("id_alumno");
				int idA = rs.getInt("id_asignatura");
				float n = rs.getFloat("nota");
				nota = new Nota(idU, idA, curso.getId(), n);
				
				notas.add(nota);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}  finally {
			try {
				rs.close();
				ps.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return notas;
	}
	
	
	public void insert(Nota nota) {
		Connection conn = null;
		PreparedStatement ps = null;
		
		try {
			conn = Conexion.obtenerConexion();
			ps = conn.prepareStatement(SQL_INSERT);
			ps.setInt(1, nota.getIdAlumno());
			ps.setInt(2, nota.getIdAsignatura());
			ps.setInt(3, nota.getIdCurso());
			ps.setFloat(4, nota.getNota());
			
			ps.execute();
			System.out.println("Insert Nota Success!");
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Insert Nota Fail!");
		} finally {
			try {
				ps.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
	}

	public void update(Nota nota) {
		Connection conn = null;
		PreparedStatement ps = null;
		
		try {
			conn = Conexion.obtenerConexion();
			ps = conn.prepareStatement(SQL_UPDATE);
			ps.setInt(1, nota.getIdAlumno());
			ps.setInt(2, nota.getIdAsignatura());
			ps.setInt(3, nota.getIdCurso());
			ps.setFloat(4, nota.getNota());
			ps.setInt(5, nota.getId());
			
			ps.execute();
			System.out.println("Update Nota Success!");
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Update Nota Fail!");
		} finally {
			try {
				ps.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
	}

	public void delete(Nota nota) {
		Connection conn = null;
		PreparedStatement ps = null;
		
		try {
			conn = Conexion.obtenerConexion();
			ps = conn.prepareStatement(SQL_DELETE);
			ps.setInt(1, nota.getId());
			
			ps.execute();
			System.out.println("Delete Nota Success!");
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Delete Nota Fail!");
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
