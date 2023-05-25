package com.mlpz.java.test;

import java.util.*;

import com.mlpz.java.domain.*;
import com.mlpz.java.datos.UsuarioDatos;

public class TestUsuario {

	public static void main(String[] args) {
//		UsuarioDatos usuarioDao = new UsuarioDatos();
//		
//		List<Usuario> usuarios = usuarioDao.select();
//		
//		usuarios.forEach(el -> System.out.println(el));
//		
		//usuariosAleatorios(200);
		
//		Usuario alumno = new Alumno("0012381S", "Maria", "Ramos", "mariar12", "a1b2c3", false);
//		Usuario profesor = new Profesor("Y8180092G", "Pedro", "Estevez", "pedroes", "pGsg20$5", true);
		
		//Insert
//		usuarioDao.insert(alumno);
//		usuarioDao.insert(profesor);
		
		//Update
//		Usuario proferor = new Profesor(4, "otracontra123");
//		usuarioDao.updatePassword(proferor);

		//Delete
//		Usuario usuario = new Usuario(4);
//		usuarioDao.delete(usuario);
		
		//Select
//		usuarios = usuarioDao.select();		
//		usuarios.forEach( el -> System.out.println(el));
	}

	public static void usuariosAleatorios(int n) {
		Random random = new Random();
		Usuario usuario = null;
		UsuarioDatos usuarioDao = new UsuarioDatos();

		for (int i = 0; i < n; i++) {
			String dni = generarDNI();
			String nombre = generarNombre();
			String apellido = generarNombre();
			String username = nombre.toLowerCase().charAt(0) + apellido.toLowerCase();
			
			String password = generarPassword();
			int tipo = random.nextInt(2) + 1;
			boolean activo = random.nextBoolean();
			
			usuario = new Usuario(dni, nombre, apellido, username, password, tipo, activo);
			usuarioDao.insert(usuario);
		}
		
	}
	/*
	 * Generador de nombres aleatorios de entre tres y siete caracteres
	 */
	public static String generarNombre() {
		String vocales = "aeiou";
		String consonantes = "bcdfghjklmnpqrstvwxyz";
        Random random = new Random();
        StringBuilder sb = new StringBuilder();
        int longitud = random.nextInt(5) + 3;
        boolean isVocal = random.nextBoolean();
        
		for(int i = 0; i < longitud; i++) {
			if(i==0) {
				if(isVocal) {
					sb.append(Character.toUpperCase(vocales.charAt(random.nextInt(vocales.length()))));									
				} else {
					sb.append(Character.toUpperCase(consonantes.charAt(random.nextInt(vocales.length()))));
				}
			} else {
				if(isVocal) {
					sb.append(vocales.charAt(random.nextInt(vocales.length())));
				} else {
					sb.append(consonantes.charAt(random.nextInt(consonantes.length())));
				}				
			}
			isVocal = !isVocal;
		}
		return sb.toString();
	}
	
	public static String generarDNI() {
		String letras = "TRWAGMYFPDXBNJZSQVHLCKE";
		Random random = new Random();
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < 8; i++) {
			sb.append(random.nextInt(10));
		}
		char letra = letras.charAt(random.nextInt(letras.length()));
		return sb.toString() + letra;
	}
	
	public static String generarPassword() {
		String caracteres = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!#$%&()*+,-./:;<=>?@[\\]^`{|}~";
		Random random = new Random();
		StringBuilder sb = new StringBuilder();
		int longitud = random.nextInt(16) + 8;
		for(int i = 0; i < longitud; i++) {
			sb.append(caracteres.charAt(random.nextInt(caracteres.length())));
		}
		
		return sb.toString();
	}
	
}
