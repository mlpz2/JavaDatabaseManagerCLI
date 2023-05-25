package com.mlpz.java.domain;

public class Alumno extends Usuario{

	private static final int TIPO = 1 ;
	
	public Alumno() {
		super();
	}

	public Alumno(int id) {
		super(id);
	}

	public Alumno(int id, String contrasena) {
		super(id, contrasena);
	}
	
	public Alumno(String dni, String nombre, String apellido, String user, String contrasena, boolean activo) {
		super(dni, nombre, apellido, user, contrasena, TIPO, activo);
	}

	
	public Alumno(int id, String dni, String nombre, String apellido, String user, String contrasena, boolean activo) {
		super(id, dni, nombre, apellido, user, contrasena, TIPO, activo);
	}

	public Alumno(int id, String dni, String nombre, String apellido, String user, String contrasena, String foto,
			String direccion, String telefono, boolean activo) {
		super(id, dni, nombre, apellido, user, contrasena, foto, direccion, telefono, TIPO, activo);
	}

	@Override
	public String toString() {
		return "Alumno " + super.toString();
	}
	
}
