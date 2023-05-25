package com.mlpz.java.domain;

public class Asignatura {

	private int id;
	private String nombre;
	private int idProfesor1;
	private int idProfesor2;
	
	public Asignatura(){}

	public Asignatura(int id) {
		this.id = id;
	}

	public Asignatura(String nombre, int idProfesor1) {
		this.nombre = nombre;
		this.idProfesor1 = idProfesor1;
	}

	public Asignatura(String nombre, int idProfesor1, int idProfesor2) {
		this.nombre = nombre;
		this.idProfesor1 = idProfesor1;
		this.idProfesor2 = idProfesor2;
	}

	public Asignatura(int id, String nombre, int idProfesor1, int idProfesor2) {
		this.id = id;
		this.nombre = nombre;
		this.idProfesor1 = idProfesor1;
		this.idProfesor2 = idProfesor2;
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

	public int getIdProfesor1() {
		return this.idProfesor1;
	}

	public void setIdProfesor1(int idProfesor1) {
		this.idProfesor1 = idProfesor1;
	}

	public int getIdProfesor2() {
		return this.idProfesor2;
	}

	public void setIdProfesor2(int idProfesor2) {
		this.idProfesor2 = idProfesor2;
	}

	@Override
	public String toString() {
		return "Asignatura [id=" + id + ", nombre=" + nombre + ", idProfesor1=" + idProfesor1 + ", idProfesor2="
				+ idProfesor2 + "]";
	}
	
}
