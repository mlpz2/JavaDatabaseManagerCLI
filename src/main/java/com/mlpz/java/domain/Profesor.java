package com.mlpz.java.domain;

public class Profesor extends Usuario {

	private static final int TIPO = 2;
	
	public Profesor() {
		super();
	}

	public Profesor(int id) {
		super(id);
	}

	public Profesor(int id, String contrasena) {
		super(id, contrasena);
	}

	
	public Profesor(String dni, String nombre, String apellido, String user, String contrasena, boolean activo) {
		super(dni, nombre, apellido, user, contrasena, TIPO, activo);
	}

	
	public Profesor(int id, String dni, String nombre, String apellido, String user, String contrasena, boolean activo) {
		super(id, dni, nombre, apellido, user, contrasena, TIPO, activo);
	}

	public Profesor(int id, String dni, String nombre, String apellido, String user, String contrasena, String foto,
			String direccion, String telefono, boolean activo) {
		super(id, dni, nombre, apellido, user, contrasena, foto, direccion, telefono, TIPO, activo);
	}

	@Override
	public String toString() {
		return "Profesor " + super.toString();
	}
	
}
