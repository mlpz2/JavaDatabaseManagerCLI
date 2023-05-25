package com.mlpz.java;
import com.mlpz.java.datos.*;
import com.mlpz.java.domain.*;
import com.mlpz.java.test.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class Main {

    private static Map<String, String> profesores = new HashMap<>();
    private static Map<String, String> alumnos = new HashMap<>();
    private static Map<String, String> cursos = new HashMap<>();
    private static Map<String, Map<String, String>> notas = new HashMap<>();

    public static void main(String[] args) throws InterruptedException {
        Scanner scanner = new Scanner(System.in);
        String opcion;

        do {
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            mostrarMenuPrincipal();
            opcion = scanner.nextLine();

            switch (opcion) {
                case "1":
                    insertarProfesor(scanner);
                    break;
                case "2":
                    insercionMasiva();
                    break;
                case "3":
                    obtenerProfesor(scanner);
                    break;
                case "4":
                    obtenerTodosProfesores();
                    break;
                case "5":
                    actualizarProfesor(scanner);
                    break;
                case "6":
                    eliminarProfesor(scanner);
                    break;
                case "7":
                    insertarAlumno(scanner);
                    break;
                case "8":
                    obtenerAlumno(scanner);
                    break;
                case "9":
                    obtenerTodosAlumnos();
                    break;
                case "10":
                    actualizarAlumno(scanner);
                    break;
                case "11":
                    eliminarAlumno(scanner);
                    break;
                case "12":
                    obtenerNotaCurso(scanner);
                    break;
                case "13":
                    obtenerTodasNotasCursos();
                    break;
                case "14":
                    crearNotaCurso(scanner);
                    break;
                case "15":
                    obtenerCurso(scanner);
                    break;
                case "16":
                    obtenerTodosCursos();
                    break;
                case "17":
                    crearCurso(scanner);
                    break;
                case "18":
                    iniciarSesionRegistro();
                    break;
                case "19":
                    enviarCurso(scanner);
                    break;
                case "20":
                    enviarNotaCurso(scanner);
                    break;
                case "0":
                    System.out.println("¡Hasta luego!");
                    break;
                default:
                    System.out.println("Opción inválida. Por favor, ingrese un número del menú.");
                    break;
            }
        } while (!opcion.equals("0"));

        scanner.close();
    }

    private static void mostrarMenuPrincipal() {
        System.out.println("\n\n=== MENÚ PRINCIPAL ===");
        System.out.println("1. Inserción de un profesor");
        System.out.println("2. Inserción masiva de profesores y alumnos con datos aleatorios");
        System.out.println("3. Obtención de un profesor");
        System.out.println("4. Obtención de todos los profesores");
        System.out.println("5. Actualización de un profesor");
        System.out.println("6. Eliminación de un profesor");
        System.out.println("7. Inserción de un alumno");
        System.out.println("8. Obtención de un alumno");
        System.out.println("9. Obtención de todos los alumnos");
        System.out.println("10. Actualización de un alumno");
        System.out.println("11. Eliminación de un alumno");
        System.out.println("12. Obtención de una nota de un curso");
        System.out.println("13. Obtención de todas las notas de todos los cursos");
        System.out.println("14. Creación de una nota para un curso");
        System.out.println("15. Obtención de un curso");
        System.out.println("16. Obtención de todos los cursos");
        System.out.println("17. Creación de un curso");
        System.out.println("18. Iniciar sesión y registro");
        System.out.println("19. Envío de un curso");
        System.out.println("20. Envío de una nota de un curso");
        System.out.println("0. Salir");
        System.out.print("Ingrese una opción: ");
    }

    private static void insertarProfesor(Scanner scanner) {
        System.out.print("Ingrese el ID del profesor: ");
        String profesorId = scanner.nextLine();
        System.out.print("Ingrese el nombre del profesor: ");
        String nombre = scanner.nextLine();
        profesores.put(profesorId, nombre);
        System.out.println("Profesor insertado con éxito!");
    }

    private static void insercionMasiva() {
        System.out.print("Ingrese la cantidad de profesores y alumnos a insertar: ");
        Scanner scanner = new Scanner(System.in);
        int cantidad = scanner.nextInt();
        scanner.nextLine();

        for (int i = 0; i < cantidad; i++) {
            String nombre = "Profesor" + (i + 1);
            String profesorId = "P" + (i + 1);
            profesores.put(profesorId, nombre);
            String alumnoId = "A" + (i + 1);
            String alumnoNombre = "Alumno" + (i + 1);
            alumnos.put(alumnoId, alumnoNombre);
        }

        System.out.println("Inserción masiva realizada con éxito!");
    }

    private static void obtenerProfesor(Scanner scanner) {
        System.out.print("Ingrese el ID del profesor a obtener: ");
        String profesorId = scanner.nextLine();
        if (profesores.containsKey(profesorId)) {
            System.out.println("Nombre del profesor: " + profesores.get(profesorId));
        } else {
            System.out.println("No se encontró ningún profesor con ese ID.");
        }
    }

    private static void obtenerTodosProfesores() {
        System.out.println("=== LISTA DE PROFESORES ===");
        for (Map.Entry<String, String> entry : profesores.entrySet()) {
            System.out.println("ID: " + entry.getKey() + " | Nombre: " + entry.getValue());
        }
    }

    private static void actualizarProfesor(Scanner scanner) {
        System.out.print("Ingrese el ID del profesor a actualizar: ");
        String profesorId = scanner.nextLine();
        if (profesores.containsKey(profesorId)) {
            System.out.print("Ingrese el nuevo nombre del profesor: ");
            String nuevoNombre = scanner.nextLine();
            profesores.put(profesorId, nuevoNombre);
            System.out.println("Profesor actualizado con éxito!");
        } else {
            System.out.println("No se encontró ningún profesor con ese ID.");
        }
    }

    private static void eliminarProfesor(Scanner scanner) {
        System.out.print("Ingrese el ID del profesor a eliminar: ");
        String profesorId = scanner.nextLine();
        if (profesores.containsKey(profesorId)) {
            profesores.remove(profesorId);
            System.out.println("Profesor eliminado con éxito!");
        } else {
            System.out.println("No se encontró ningún profesor con ese ID.");
        }
    }

    private static void insertarAlumno(Scanner scanner) {
        System.out.print("Ingrese el ID del alumno: ");
        String alumnoId = scanner.nextLine();
        System.out.print("Ingrese el nombre del alumno: ");
        String nombre = scanner.nextLine();
        alumnos.put(alumnoId, nombre);
        System.out.println("Alumno insertado con éxito!");
    }

    private static void obtenerAlumno(Scanner scanner) {
        System.out.print("Ingrese el ID del alumno a obtener: ");
        String alumnoId = scanner.nextLine();
        if (alumnos.containsKey(alumnoId)) {
            System.out.println("Nombre del alumno: " + alumnos.get(alumnoId));
        } else {
            System.out.println("No se encontró ningún alumno con ese ID.");
        }
    }

    private static void obtenerTodosAlumnos() {
        System.out.println("=== LISTA DE ALUMNOS ===");
        for (Map.Entry<String, String> entry : alumnos.entrySet()) {
            System.out.println("ID: " + entry.getKey() + " | Nombre: " + entry.getValue());
        }
    }

    private static void actualizarAlumno(Scanner scanner) {
        System.out.print("Ingrese el ID del alumno a actualizar: ");
        String alumnoId = scanner.nextLine();
        if (alumnos.containsKey(alumnoId)) {
            System.out.print("Ingrese el nuevo nombre del alumno: ");
            String nuevoNombre = scanner.nextLine();
            alumnos.put(alumnoId, nuevoNombre);
            System.out.println("Alumno actualizado con éxito!");
        } else {
            System.out.println("No se encontró ningún alumno con ese ID.");
        }
    }

    private static void eliminarAlumno(Scanner scanner) {
        System.out.print("Ingrese el ID del alumno a eliminar: ");
        String alumnoId = scanner.nextLine();
        if (alumnos.containsKey(alumnoId)) {
            alumnos.remove(alumnoId);
            System.out.println("Alumno eliminado con éxito!");
        } else {
            System.out.println("No se encontró ningún alumno con ese ID.");
        }
    }

    private static void obtenerNotaCurso(Scanner scanner) {
        System.out.print("Ingrese el ID del curso: ");
        String cursoId = scanner.nextLine();
        if (notas.containsKey(cursoId)) {
            System.out.println("Notas del curso " + cursoId + ":");
            Map<String, String> notasCurso = notas.get(cursoId);
            for (Map.Entry<String, String> entry : notasCurso.entrySet()) {
                System.out.println("Alumno: " + entry.getKey() + " | Nota: " + entry.getValue());
            }
        } else {
            System.out.println("No se encontró ningún curso con ese ID.");
        }
    }

    private static void obtenerTodasNotasCursos() {
        System.out.println("=== LISTA DE NOTAS DE LOS CURSOS ===");
        for (Map.Entry<String, Map<String, String>> cursoEntry : notas.entrySet()) {
            System.out.println("Curso ID: " + cursoEntry.getKey());
            Map<String, String> notasCurso = cursoEntry.getValue();
            for (Map.Entry<String, String> notaEntry : notasCurso.entrySet()) {
                System.out.println("Alumno: " + notaEntry.getKey() + " | Nota: " + notaEntry.getValue());
            }
            System.out.println();
        }
    }

    private static void crearNotaCurso(Scanner scanner) {
        System.out.print("Ingrese el ID del curso: ");
        String cursoId = scanner.nextLine();
        if (cursos.containsKey(cursoId)) {
            System.out.print("Ingrese el ID del alumno: ");
            String alumnoId = scanner.nextLine();
            if (alumnos.containsKey(alumnoId)) {
                System.out.print("Ingrese la nota del alumno: ");
                String nota = scanner.nextLine();
                if (!notas.containsKey(cursoId)) {
                    notas.put(cursoId, new HashMap<>());
                }
                Map<String, String> notasCurso = notas.get(cursoId);
                notasCurso.put(alumnoId, nota);
                System.out.println("Nota creada con éxito!");
            } else {
                System.out.println("No se encontró ningún alumno con ese ID.");
            }
        } else {
            System.out.println("No se encontró ningún curso con ese ID.");
        }
    }

    private static void obtenerCurso(Scanner scanner) {
        System.out.print("Ingrese el ID del curso a obtener: ");
        String cursoId = scanner.nextLine();
        if (cursos.containsKey(cursoId)) {
            System.out.println("Nombre del curso: " + cursos.get(cursoId));
        } else {
            System.out.println("No se encontró ningún curso con ese ID.");
        }
    }

    private static void obtenerTodosCursos() {
        System.out.println("=== LISTA DE CURSOS ===");
        for (Map.Entry<String, String> entry : cursos.entrySet()) {
            System.out.println("ID: " + entry.getKey() + " | Nombre: " + entry.getValue());
        }
    }

    private static void crearCurso(Scanner scanner) {
        System.out.print("Ingrese el ID del curso: ");
        String cursoId = scanner.nextLine();
        System.out.print("Ingrese el nombre del curso: ");
        String nombre = scanner.nextLine();
        cursos.put(cursoId, nombre);
        System.out.println("Curso creado con éxito!");
    }

    private static void iniciarSesionRegistro() {
        // Implementa tu lógica de inicio de sesión y registro aquí
        System.out.println("Función de inicio de sesión y registro.");
    }

    private static void enviarCurso(Scanner scanner) {
        System.out.print("Ingrese el ID del curso a enviar: ");
        String cursoId = scanner.nextLine();
        if (cursos.containsKey(cursoId)) {
            System.out.println("El curso " + cursos.get(cursoId) + " ha sido enviado.");
        } else {
            System.out.println("No se encontró ningún curso con ese ID.");
        }
    }

    private static void enviarNotaCurso(Scanner scanner) {
        System.out.print("Ingrese el ID del curso: ");
        String cursoId = scanner.nextLine();
        if (notas.containsKey(cursoId)) {
            System.out.print("Ingrese el ID del alumno: ");
            String alumnoId = scanner.nextLine();
            Map<String, String> notasCurso = notas.get(cursoId);
            if (notasCurso.containsKey(alumnoId)) {
                System.out.print("Ingrese la nueva nota del alumno: ");
                String nota = scanner.nextLine();
                notasCurso.put(alumnoId, nota);
                System.out.println("Nota enviada con éxito!");
            } else {
                System.out.println("No se encontró ninguna nota para ese alumno en el curso.");
            }
        } else {
            System.out.println("No se encontró ningún curso con ese ID.");
        }
    }
}