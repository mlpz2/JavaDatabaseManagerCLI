package com.mlpz.java.test;

import java.util.List;

import com.mlpz.java.datos.AsignaturaDatos;
import com.mlpz.java.domain.Asignatura;

public class TestAsignatura {

	public static void main(String[] args) {
		AsignaturaDatos asignaturaDao = new AsignaturaDatos();
		List<Asignatura> asignaturas = asignaturaDao.select();		
		asignaturas.forEach(el -> System.out.println(el));

		//Insert
//		Asignatura asignatura = new Asignatura("Educación Física", 49);
//		asignaturaDao.insert(asignatura);

		//Update
//		Asignatura asignatura = asignaturaDao.select(18);
//		asignatura.setIdProfesor1(399);
//		asignaturaDao.update(asignatura);

		//Delete
//		Asignatura asignatura = new Asignatura(17);
//		asignaturaDao.delete(asignatura);
		
		//Select
//		asignaturas = asignaturaDao.select();
//		asignaturas.forEach(el -> System.out.println(el));
		
		
	}

}
