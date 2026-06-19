
package Vista;

import Controlador.SeccionController;
import Modelo.Sección;
import java.util.List;
import java.util.Scanner;


public class SecciónVista {
    
     private static SeccionController controller = new SeccionController();
    private static Scanner scanner = new Scanner(System.in);
    
    public static void main(String[] args) {
        int opcion;
        
        do {
            mostrarMenu();
            System.out.print("Opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine();
            
            switch (opcion) {
                case 1: listar(); break;
                case 2: agregar(); break;
                case 3: actualizar(); break;
                case 4: eliminar(); break;
                case 5: System.out.println("Volviendo..."); break;
                default: System.out.println("Opción inválida.");
            }
        } while (opcion != 5);
    }
     private static void mostrarMenu() {
        System.out.println("\n--- GESTIÓN DE SECCIONES ---");
        System.out.println("1. Listar secciones");
        System.out.println("2. Agregar sección");
        System.out.println("3. Actualizar sección");
        System.out.println("4. Eliminar sección");
        System.out.println("5. Volver");
    }
    
    private static void listar() {
        List<Sección> secciones = controller.listar();
        
        if (secciones.isEmpty()) {
            System.out.println("No hay secciones registradas.");
            return;
        }
        
        System.out.println("\nID | NOMBRE | ID GRADO");
        for (Sección s : secciones) {
            System.out.println(s.getIdSeccion() + " | " + s.getNombreSeccion() + " | " + s.getIdGrado());
        }
    }
    private static void agregar() {
        System.out.println("\n--- AGREGAR SECCIÓN ---");
        System.out.print("Nombre: ");
        String nombre = scanner.nextLine();
        System.out.print("ID Grado: ");
        int idGrado = scanner.nextInt();
        scanner.nextLine();
        
        if (controller.guardar(nombre, idGrado)) {
            System.out.println("Sección guardada con éxito.");
        } else {
            System.out.println("Error al guardar.");
        }
    }
     private static void actualizar() {
        System.out.println("\n--- ACTUALIZAR SECCIÓN ---");
        System.out.print("ID: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Nuevo nombre: ");
        String nombre = scanner.nextLine();
        System.out.print("Nuevo ID Grado: ");
        int idGrado = scanner.nextInt();
        scanner.nextLine();
        
        if (controller.actualizar(id, nombre, idGrado)) {
            System.out.println("Sección actualizada.");
        } else {
            System.out.println("Error al actualizar.");
        }
    }
     private static void eliminar() {
        System.out.println("\n--- ELIMINAR SECCIÓN ---");
        System.out.print("ID: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        System.out.print("¿Seguro? (si/n): ");
        
        if (scanner.nextLine().equalsIgnoreCase("si")) {
            controller.eliminar(id);
        } else {
            System.out.println("Cancelado.");
        }
    }
}
