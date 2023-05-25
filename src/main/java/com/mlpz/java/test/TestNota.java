package com.mlpz.java.test;

import java.util.Map;

import com.mlpz.java.datos.*;
import com.mlpz.java.domain.*;

public class TestNota {

	public static void main(String[] args) {
		NotaDatos notaDao = new NotaDatos();
		AsignaturaDatos asignaturaDao = new AsignaturaDatos();
		
		Usuario usuario = new Usuario(1);
		Curso curso = new Curso(1);
		
		Map <Integer, Float> notasA1 = notaDao.select(usuario, curso);
		
		for (Integer key : notasA1.keySet()) {
			System.out.println(asignaturaDao.selectName(key) + ": " + notasA1.get(key));
		}
		
	}

}
