package com.mlpz.java.test;

import java.util.List;

import com.mlpz.java.datos.CursoDatos;
import com.mlpz.java.domain.Curso;

public class TestCurso {

	public static void main(String[] args) {
		CursoDatos cursoDao = new CursoDatos();
		List<Curso> cursos = cursoDao.select();
		cursos.forEach(el -> System.out.println(el));

		//Select
//		Curso curso = cursoDao.select(4);
//		System.out.println(curso);
		
		//Insert
//		Curso curso = new Curso("1 Bachiller Ciencias 2022", 1, 2, 3);
//		cursoDao.insert(curso);

		//Update
//		Curso curso = cursoDao.select(5);
//		curso.setIdA(1,2,3,4,5);
//		cursoDao.update(curso);

		//Delete
//		Curso curso = new Curso(5);
//		cursoDao.delete(curso);
		
		cursos = cursoDao.select();
		cursos.forEach(el -> System.out.println(el));
	}

}
