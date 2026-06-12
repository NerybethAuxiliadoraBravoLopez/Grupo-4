
package Vista;

import Controlador.HabitoController;
import Modelo.Hábito;
import java.util.List;
import java.util.Scanner;


public class HabitoVista {
    
        private static HabitoController controller = new HabitoController();
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
                    listar();
                    break;
                case 2:
                    agregar();
                    break;
                case 3:
                    actualizar();
                    break;
                case 4:
                    eliminar();
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
        System.out.println("\n--- GESTIÓN DE HÁBITOS ---");
        System.out.println("1. Listar hábitos");
        System.out.println("2. Agregar hábito");
        System.out.println("3. Actualizar hábito");
        System.out.println("4. Eliminar hábito");
        System.out.println("5. Volver");
    }
     //lista
    private static void listar() {
        List<Hábito> habitos = controller.listar();
        
        if (habitos.isEmpty()) {
            System.out.println("No hay hábitos registrados.");
            return;
        }
        
        System.out.println("\nID | NOMBRE | TIPO | UNIDAD | ESTADO");
        for (Hábito h : habitos) {
            System.out.println(h.getIdHabito() + " | " + h.getNombreHabito() + " | " + h.getTipoHabito() + " | " + h.getUnidadMedida() + " | " + h.getEstado());
        }
    }
    
    //agregar
     private static void agregar() {
        System.out.println("\n--- AGREGAR HÁBITO ---");
        
        System.out.print("Nombre: ");
        String nombre = scanner.nextLine();
        
        System.out.print("Tipo: ");
        String tipo = scanner.nextLine();
        
        System.out.print("Unidad de medida: ");
        String unidad = scanner.nextLine();
        
        boolean exito = controller.guardar(nombre, tipo, unidad);
        
        if (exito) {
            System.out.println("Hábito guardado con éxito.");
        } else {
            System.out.println("Error al guardar.");
        }
    }
     //actualizar
     private static void actualizar() {
        System.out.println("\n--- ACTUALIZAR HÁBITO ---");
        
        System.out.print("ID del hábito: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        
        System.out.print("Nuevo nombre: ");
        String nombre = scanner.nextLine();
        
        System.out.print("Nuevo tipo: ");
        String tipo = scanner.nextLine();
        
        System.out.print("Nueva unidad: ");
        String unidad = scanner.nextLine();
        
        boolean exito = controller.actualizar(id, nombre, tipo, unidad);
        
        if (exito) {
            System.out.println("Hábito actualizado con éxito.");
        } else {
            System.out.println("Error al actualizar.");
        }
    }
     
     //eliminar
     private static void eliminar() {
        System.out.println("\n--- ELIMINAR HÁBITO ---");
        
        System.out.print("ID del hábito: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        
        System.out.print("¿Está seguro? (si/no): ");
        String confirmacion = scanner.nextLine();
        
        if (confirmacion.equalsIgnoreCase("si")) {
            controller.eliminar(id);
        } else {
            System.out.println("Cancelado.");
        }
    }

}
