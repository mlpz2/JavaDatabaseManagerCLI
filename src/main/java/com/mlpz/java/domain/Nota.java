package com.mlpz.java.domain;

public class Nota {

	private int id;
	private int idAlumno;
	private int idAsignatura;
	private int idCurso;
	private float nota;
	
	public Nota() {}

	public Nota(int id) {
		this.id = id;
	}

	public Nota(int idAlumno, int idAsignatura, int idCurso) {
		this.idAlumno = idAlumno;
		this.idAsignatura = idAsignatura;
		this.idCurso = idCurso;
	}
	
	
	public Nota(int idAlumno, int idAsignatura, int idCurso, float nota) {
		this.idAlumno = idAlumno;
		this.idAsignatura = idAsignatura;
		this.idCurso = idCurso;
		this.nota = nota;
	}

	public Nota(int id, int idAlumno, int idAsignatura, int idCurso, float nota) {
		this.id = id;
		this.idAlumno = idAlumno;
		this.idAsignatura = idAsignatura;
		this.idCurso = idCurso;
		this.nota = nota;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getIdAlumno() {
		return idAlumno;
	}

	public void setIdAlumno(int idAlumno) {
		this.idAlumno = idAlumno;
	}

	public int getIdAsignatura() {
		return idAsignatura;
	}

	public void setIdAsignatura(int idAsignatura) {
		this.idAsignatura = idAsignatura;
	}

	public int getIdCurso() {
		return idCurso;
	}

	public void setIdCurso(int idCurso) {
		this.idCurso = idCurso;
	}

	public float getNota() {
		return nota;
	}

	public void setNota(float nota) {
		this.nota = nota;
	}

	@Override
	public String toString() {
		return "Nota [id=" + id + ", idAlumno=" + idAlumno + ", idAsignatura=" + idAsignatura + ", idCurso=" + idCurso
				+ ", nota=" + nota + "]";
	}
	
	
	
}
