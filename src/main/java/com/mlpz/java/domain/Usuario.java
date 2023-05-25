package com.mlpz.java.domain;

public class Usuario {

	protected int id;
	protected String dni;
	protected String nombre;
	protected String apellido;
	protected String user;
	protected String contrasena;
	protected String foto;
	protected String direccion;
	protected String telefono;
	protected int tipoUsuario;
	protected boolean activo;
	
	public Usuario() {}

	public Usuario(int id) {
		this.id = id;
	}
	
	public Usuario(int id, String contrasena) {
		this.id = id;
		this.contrasena = contrasena;
	}
	
	public Usuario(String user, String contrasena) {
		this.user = user;
		this.contrasena = contrasena;
	}

	public Usuario(String dni, String nombre, String apellido, String user, String contrasena, int tipo,
			boolean activo) {
		this.dni = dni;
		this.nombre = nombre;
		this.apellido = apellido;
		this.user = user;
		this.contrasena = contrasena;
		this.tipoUsuario = tipo;
		this.activo = activo;
	}

	
	public Usuario(int id, String dni, String nombre, String apellido, String user, String contrasena, int tipo,
			boolean activo) {
		this.id = id;
		this.dni = dni;
		this.nombre = nombre;
		this.apellido = apellido;
		this.user = user;
		this.contrasena = contrasena;
		this.tipoUsuario = tipo;
		this.activo = activo;
	}

	public Usuario(int id, String dni, String nombre, String apellido, String user, String contrasena, String foto,
			String direccion, String telefono, int tipo, boolean activo) {
		this.id = id;
		this.dni = dni;
		this.nombre = nombre;
		this.apellido = apellido;
		this.user = user;
		this.contrasena = contrasena;
		this.foto = foto;
		this.direccion = direccion;
		this.telefono = telefono;
		this.tipoUsuario = tipo;
		this.activo = activo;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getContrasena() {
		return contrasena;
	}

	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}

	public String getFoto() {
		return foto;
	}

	public void setFoto(String foto) {
		this.foto = foto;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public int getTipo() {
		return tipoUsuario;
	}

	public void setTipo(int tipo) {
		this.tipoUsuario = tipo;
	}

	public boolean isActivo() {
		return activo;
	}

	public void setActivo(boolean activo) {
		this.activo = activo;
	}

	@Override
	public String toString() {
		return "[id=" + id + ", dni=" + dni + ", nombre=" + nombre + ", apellido=" + apellido + ", user="
				+ user + ", contrasena=" + contrasena + ", direccion=" + direccion + ", telefono=" + telefono
				+ ", tipo=" + tipoUsuario + ", activo=" + activo + "]";
	}
	
	
}
