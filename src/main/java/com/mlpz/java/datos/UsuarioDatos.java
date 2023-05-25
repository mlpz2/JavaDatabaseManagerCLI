package com.mlpz.java.datos;

import java.sql.*;
import java.util.*;

import com.mlpz.java.domain.Conexion;
import com.mlpz.java.domain.Usuario;

public class UsuarioDatos {

	private static final String SELECT_SQL = "SELECT * FROM usuarios";
	private static final String SELECT_PASS = "SELECT contrasena FROM usuarios WHERE usuario = ?";
	private static final String SELECT_ID_SQL = "SELECT * FROM usuarios WHERE id = ?";
	private static final String SELECT_USER = "SELECT * FROM usuarios WHERE usuario = ?";
	private static final String INSERT_SQL = "INSERT INTO usuarios (`dni`, `nombre`, `apellido`, `usuario`, `contrasena`, `tipo`, `activo`) VALUES (?, ?, ?, ?, ?, ?, ?);";
	private static final String UPDATE_SQL = "UPDATE usuarios SET dni = ?, nombre = ?, apellido = ?, usuario = ?, contrasena = ?, tipo = ?, activo = ? WHERE id = ?";
	private static final String UPDATE_PASS_SQL = "UPDATE usuarios SET `contrasena` = ? WHERE (`id` = ?);";
	private static final String UPDATE_USER_SQL = "UPDATE usuarios SET `usuario` = ? WHERE (`id` = ?);";
	private static final String DELETE_SQL = "DELETE FROM usuarios WHERE (`id` = ?);";
	
	
	public List<Usuario> select(){
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Usuario usuario = null;
		List<Usuario> usuarios = new ArrayList<Usuario>();
		
		try {
			conn = Conexion.obtenerConexion();
			ps = conn.prepareStatement(SELECT_SQL);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				int id = rs.getInt("id");
				String dni = rs.getString("dni");
				String nombre = rs.getString("nombre");
				String apellido = rs.getString("apellido");
				String user = rs.getString("usuario");
				String contrasena = rs.getString("contrasena");
				int tipo = rs.getInt("tipo");
				boolean activo = rs.getBoolean("activo");
				
				usuario = new Usuario(id, dni, nombre, apellido, user, contrasena, tipo, activo);
				usuarios.add(usuario);
			}
			
			System.out.println("+====================Lista de usuarios====================+");
			
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
		
		return usuarios;
	}

	public Usuario select(int id){
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Usuario usuario = null;
		
		try {
			conn = Conexion.obtenerConexion();
			ps = conn.prepareStatement(SELECT_ID_SQL);
			ps.setInt(1, id);
			rs = ps.executeQuery();
			
			if(rs.next()) {
				String dni = rs.getString("dni");
				String nombre = rs.getString("nombre");
				String apellido = rs.getString("apellido");
				String user = rs.getString("usuario");
				String contrasena = rs.getString("contrasena");
				int tipo = rs.getInt("tipo");
				boolean activo = rs.getBoolean("activo");
				
				usuario = new Usuario(id, dni, nombre, apellido, user, contrasena, tipo, activo);
//				System.out.println(usuario);
			} else {
				System.out.println("No se encontró usuario");
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
		
		return usuario;
	}
	
	public Usuario select(String username){
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Usuario usuario = null;
		
		try {
			conn = Conexion.obtenerConexion();
			ps = conn.prepareStatement(SELECT_USER);
			ps.setString(1, username);
			rs = ps.executeQuery();
			
			if(rs.next()) {
				int id = rs.getInt("id");
				String dni = rs.getString("dni");
				String nombre = rs.getString("nombre");
				String apellido = rs.getString("apellido");
				String contrasena = rs.getString("contrasena");
				String foto = rs.getString("foto");
				String direccion = rs.getString("direccion");
				String telefono = rs.getString("telefono");
				int tipo = rs.getInt("tipo");
				boolean activo = rs.getBoolean("activo");
				
				usuario = new Usuario(id, dni, nombre, apellido, username, contrasena, foto, direccion, telefono, tipo, activo);
//				System.out.println(usuario);
			} else {
				System.out.println("No se encontró usuario");
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
		
		return usuario;
	}
	

	
	public boolean loginUser(Usuario user) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		boolean isReal = false;
		
		try {
			conn = Conexion.obtenerConexion();
			ps = conn.prepareStatement(SELECT_PASS);
			ps.setString(1, user.getUser());
			
			rs = ps.executeQuery();
			
			if(rs.next()) {
				String pass = rs.getString("contrasena");
				isReal = pass.equals(user.getContrasena());
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
		
		return isReal;
	}
	
	
	public void insert(Usuario usuario) {
		Connection conn = null;
		PreparedStatement ps = null;
		
		try {
			conn = Conexion.obtenerConexion();
			ps = conn.prepareStatement(INSERT_SQL);
			ps.setString(1, usuario.getDni());
			ps.setString(2, usuario.getNombre());
			ps.setString(3, usuario.getApellido());
			ps.setString(4, usuario.getUser());
			ps.setString(5, usuario.getContrasena());
			ps.setInt(6, usuario.getTipo());
			ps.setBoolean(7, usuario.isActivo());

			ps.execute();			
			System.out.println("Insert Success!");
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

	public void update(Usuario usuario) {
		Connection conn = null;
		PreparedStatement ps = null;
		
		try {
			conn = Conexion.obtenerConexion();
			ps = conn.prepareStatement(UPDATE_SQL);
			ps.setString(1, usuario.getDni());
			ps.setString(2, usuario.getNombre());
			ps.setString(3, usuario.getApellido());
			ps.setString(4, usuario.getUser());
			ps.setString(5, usuario.getContrasena());
			ps.setInt(6, usuario.getTipo());
			ps.setBoolean(7, usuario.isActivo());
			ps.setInt(8, usuario.getId());
			
			ps.execute();
			System.out.println("Update Usuario Success!");			
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
	
	
	public void updatePassword(Usuario usuario) {
		Connection conn = null;
		PreparedStatement ps = null;
		
		try {
			conn = Conexion.obtenerConexion();
			ps = conn.prepareStatement(UPDATE_PASS_SQL);
			ps.setString(1, usuario.getContrasena());
			ps.setInt(2, usuario.getId());
			
			ps.execute();
			System.out.println("Update Password Success!");			
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

	public void updateUsername(Usuario usuario) {
		Connection conn = null;
		PreparedStatement ps = null;
		
		try {
			conn = Conexion.obtenerConexion();
			ps = conn.prepareStatement(UPDATE_USER_SQL);
			ps.setString(1, usuario.getUser());
			ps.setInt(2, usuario.getId());
			
			ps.execute();
			System.out.println("Update Username Success!");			
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
	
	
	public void delete(Usuario usuario) {
		Connection conn = null;
		PreparedStatement ps = null;
		
		try {
			conn = Conexion.obtenerConexion();
			ps = conn.prepareStatement(DELETE_SQL);
			ps.setInt(1, usuario.getId());
			
			ps.execute();
			System.out.println("Delete User Success!");
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
