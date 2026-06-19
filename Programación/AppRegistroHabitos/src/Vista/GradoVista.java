
package Vista;

import Controlador.GradoController;
import Modelo.Grado;
import java.util.List;
import java.util.Scanner;


 
public class GradoVista {
    
    private static GradoController controller = new GradoController();
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
        System.out.println("\n--- GESTIÓN DE GRADOS ---");
        System.out.println("1. Listar grados");
        System.out.println("2. Agregar grado");
        System.out.println("3. Actualizar grado");
        System.out.println("4. Eliminar grado");
        System.out.println("5. Volver");
    }
    
    private static void listar() {
        List<Grado> grados = controller.listar();
        
        if (grados.isEmpty()) {
            System.out.println("No hay grados registrados.");
            return;
        }
         System.out.println("\nID | NOMBRE | NIVEL");
        for (Grado g : grados) {
            System.out.println(g.getIdGrado() + " | " + g.getNombreGrado() + " | " + g.getNivel());
        }
    }
     private static void agregar() {
        System.out.println("\n--- AGREGAR GRADO ---");
        System.out.print("Nombre: ");
        String nombre = scanner.nextLine();
        System.out.print("Nivel: ");
        String nivel = scanner.nextLine();
        
        if (controller.guardar(nombre, nivel)) {
            System.out.println("Grado guardado con éxito.");
        } else {
            System.out.println("Error al guardar.");
        }
    }
      private static void actualizar() {
        System.out.println("\n--- ACTUALIZAR GRADO ---");
        System.out.print("ID: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Nuevo nombre: ");
        String nombre = scanner.nextLine();
        System.out.print("Nuevo nivel: ");
        String nivel = scanner.nextLine();
        
        if (controller.actualizar(id, nombre, nivel)) {
            System.out.println("Grado actualizado.");
        } else {
            System.out.println("Error al actualizar.");
        }
    }
     private static void eliminar() {
        System.out.println("\n--- ELIMINAR GRADO ---");
        System.out.print("ID: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        System.out.print("¿Seguro? (si/no): ");
        
        if (scanner.nextLine().equalsIgnoreCase("si")) {
            controller.eliminar(id);
        } else {
            System.out.println("Cancelado.");
        }
    }
}

