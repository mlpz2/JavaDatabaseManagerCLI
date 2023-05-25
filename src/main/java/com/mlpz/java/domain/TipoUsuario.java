package com.mlpz.java.domain;

public class TipoUsuario {

	private int id;
	private String nombre;
	private String funciones;
	
	public TipoUsuario() {}
	
	public TipoUsuario(int id) {
		this.id = id;
	}
	
	public TipoUsuario(String nombre, String funciones) {
		this.nombre =  nombre;
		this.funciones = funciones;
	}
	
	public TipoUsuario(int id, String nombre, String funciones) {
		this.id = id;
		this.nombre = nombre;
		this.funciones = funciones;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getFunciones() {
		return funciones;
	}

	public void setFunciones(String funciones) {
		this.funciones = funciones;
	}

	@Override
	public String toString() {
		return "TipoUsuario [id=" + id + ", nombre=" + nombre + ", funciones=" + funciones + "]";
	}
	
	
}
