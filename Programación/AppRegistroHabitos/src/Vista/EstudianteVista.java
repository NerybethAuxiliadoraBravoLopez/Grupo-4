 
package Vista;

import Controlador.EstudianteController;
import Modelo.Estudiante;
import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;


 
public class EstudianteVista {
     private static EstudianteController controller = new EstudianteController();
    private static Scanner scanner = new Scanner(System.in);
    
     public static void main(String[] args) {
        int opcion;
        
        do {
            mostrarMenu();
            System.out.print("Opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine();
            
            switch (opcion) {
                case 1:
                    listarEstudiantes();
                    break;
                case 2:
                    guardarEstudiante();
                    break;
                case 3:
                    actualizarEstudiante();
                    break;
                case 4:
                    eliminarEstudiante();
                    break;
                case 5:
                    System.out.println("Volviendo al menú principal...");
                    break;
                default:
                    System.out.println("Opción inválida.");
            }
            } while (opcion != 5);
    }
    
    private static void mostrarMenu() {
        System.out.println("\n--- GESTIÓN DE ESTUDIANTES ---");
        System.out.println("1. Listar estudiantes");
        System.out.println("2. Agregar estudiante");
        System.out.println("3. Actualizar estudiante");
        System.out.println("4. Eliminar estudiante");
        System.out.println("5. Volver");
    }
    
    private static void listarEstudiantes() {
        List<Estudiante> estudiantes = controller.listar();
        
        if (estudiantes.isEmpty()) {
            System.out.println("No hay estudiantes registrados.");
            return;
        }
        
        System.out.println("\nID | NOMBRE | APELLIDO | EMAIL | FECHA NAC. | GRADO");
        for (Estudiante e : estudiantes) {
            System.out.println(e.getIdEstudiante() + " | " + e.getNombre() + " | " + e.getApellido() + " | " + e.getEmail() + " | " + e.getFechaNacimiento() + " | " + e.getIdGrado());
        }
    }
    private static void guardarEstudiante() {
        System.out.println("\n--- AGREGAR ESTUDIANTE ---");
        
        System.out.print("Nombre: ");
        String nombre = scanner.nextLine();
        
        System.out.print("Apellido: ");
        String apellido = scanner.nextLine();
        
        System.out.print("Email: ");
        String email = scanner.nextLine();
        
       System.out.print("Fecha nacimiento (AAAA-MM-DD): ");
String fechaTexto = scanner.nextLine(); 
LocalDate fechaNacimiento = LocalDate.parse(fechaTexto);

        System.out.print("ID Grado: ");
        int idGrado = scanner.nextInt();
        scanner.nextLine();
        
        boolean exito = controller.guardar(0, nombre, apellido, email, fechaNacimiento, idGrado);
        
        if (exito) {
            System.out.println("Estudiante guardado con éxito.");
        } else {
            System.out.println("Error al guardar.");
        }
    }
    private static void actualizarEstudiante() {
        System.out.println("\n--- ACTUALIZAR ESTUDIANTE ---");
        
        System.out.print("ID del estudiante: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        
        System.out.print("Nuevo nombre: ");
        String nombre = scanner.nextLine();

        
        System.out.print("Nuevo apellido: ");
        String apellido = scanner.nextLine();
        
        System.out.print("Nuevo email: ");
        String email = scanner.nextLine();
        
        System.out.print("Nueva fecha nacimiento (YYYY-MM-DD): ");
String fechaTexto = scanner.nextLine();
LocalDate fechaNacimiento = LocalDate.parse(fechaTexto);

        System.out.print("Nuevo ID Grado: ");
        int idGrado = scanner.nextInt();
        scanner.nextLine();
        
        controller.actualizar(id, nombre, apellido, email, fechaNacimiento, idGrado);

    }
    private static void eliminarEstudiante() {
        System.out.println("\n--- ELIMINAR ESTUDIANTE ---");
        
        System.out.print("ID del estudiante: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        
        System.out.print("¿Está seguro? (si/no): ");
        String confirma = scanner.nextLine();
        
        if (confirma.equalsIgnoreCase("si")) {
            controller.eliminar(id);
            System.out.println("Estudiante eliminado.");
        } else {
            System.out.println("Cancelado.");
        }
    }

}
