package com.mlpz.java.test;

import java.util.*;

import com.mlpz.java.domain.*;
import com.mlpz.java.datos.*;

public class TestTotal {

	public static void main(String[] args) {
		//UsuarioDatos uDAO = new UsuarioDatos();
		addNotas(10);
	}

	public static void obtenerInicio(int idU, int idC) {
		AsignaturaDatos aDAO = new AsignaturaDatos();
		UsuarioDatos uDAO = new UsuarioDatos();
		CursoDatos cDAO = new CursoDatos();
		NotaDatos nDAO = new NotaDatos();
		Usuario u = new Usuario(1);
		Curso c = new Curso(1);
		Map<Integer,Float> notas = nDAO.select(u, c);
		Float promedio = 0f;
		
		Usuario usuario = uDAO.select(idU);
		
		Curso curso = cDAO.select(idC);
		
		System.out.println("");
		System.out.println("+======================================================+");
		System.out.println("Nombre: " + usuario.getNombre() + " " + usuario.getApellido());
		System.out.println("Curso: " + curso.getNombre());
		System.out.println("Asignaturas - Notas");
		
		if(notas.isEmpty()) {
			System.out.println("El alumno no está inscrito en este curso");
		} else {
			for (Integer key : notas.keySet()) {
				System.out.println(aDAO.selectName(key) + ": " + notas.get(key));
				promedio += notas.get(key);
			}
			promedio /= notas.size();
			System.out.println("Su promedio de notas en el curso es: " + promedio);			
		}

	}
	
	public static void obtenerAlumnos(int idC) {
		CursoDatos cDAO = new CursoDatos();
		NotaDatos nDAO = new NotaDatos();
		
		Curso curso = cDAO.select(idC);
		List<Nota> notas = nDAO.select(curso);
		if(notas.isEmpty()) {
			System.out.println("No hay notas registradas");
			return;
		}
		ArrayList<Integer> idAs = new ArrayList<>();
		
		for (int i = 0; i < notas.size(); i++) {
			idAs.add(notas.get(i).getIdAlumno());
		}
		Set<Integer> aux = new HashSet<>(idAs);
		idAs.clear();
		idAs.addAll(aux);		
		
		for (Integer i : aux) {
			obtenerInicio(i, idC);
		}
	}
	
	public static void addNotas(int n) {
		final int CANT_ASIGNATURAS = 11;
		Nota nota;
		NotaDatos nDAO = new NotaDatos();
		Random random = new Random();
		float notita;
		for (int i = 0; i < n; i++) {
			int idA = random.nextInt(CANT_ASIGNATURAS) + 1;
			int idU;
			Usuario user;
			UsuarioDatos uDAO = new UsuarioDatos();
			
			do {
				idU = random.nextInt(300) + 10;
				user = uDAO.select(idU);
			} while (user.getTipo() == 2);
			
			
			int idC = random.nextInt(2) + 1;
			notita = random.nextInt(6) + 5;
			nota = new Nota(idU, idA, idC, notita);
			nDAO.insert(nota);			
		}
	}
	
}
