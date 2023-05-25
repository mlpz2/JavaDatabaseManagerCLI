package com.mlpz.java.domain;

import java.util.*;

public class Curso {

	private int id;
	private String nombre;
	private List<Integer> idA;
	
	public Curso() {}

	public Curso(int id) {
		this.id = id;
	}

	public Curso(String nombre, List<Integer> idA) {
		this.nombre = nombre;
		this.idA = idA;
	}

	public Curso(String nombre, Integer ...idA) {
		this.nombre = nombre;
		this.idA = Arrays.asList(idA);
	}
	
	
	public Curso(int id, String nombre, List<Integer> idA) {
		this.id = id;
		this.nombre = nombre;
		this.idA = idA;
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

	public List<Integer> getIdA() {
		return idA;
	}

	public void setIdA(List<Integer> idA) {
		this.idA = idA;
	}

	public void setIdA(Integer... idA) {
		this.idA = Arrays.asList(idA);
	}

	
	@Override
	public String toString() {
		return "Curso [id=" + id + ", nombre=" + nombre + ", idA=" + idA + "]";
	}	
	
	
}
