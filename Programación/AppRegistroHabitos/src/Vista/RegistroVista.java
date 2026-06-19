
package Vista;

import Controlador.RegistroController;
import Modelo.Registro;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;


public class RegistroVista {
    
     private static RegistroController controller = new RegistroController();
    private static Scanner scanner = new Scanner(System.in);
    private static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("YYYY-MM-dd");
    
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
        System.out.println("\n--- REGISTRO DE HÁBITOS DIARIOS ---");
        System.out.println("1. Listar registros");
        System.out.println("2. Agregar registro");
        System.out.println("3. Actualizar registro");
        System.out.println("4. Eliminar registro");
        System.out.println("5. Volver");
    }
    
    private static void listar() {
        List<Registro> registros = controller.listar();
        
        if (registros.isEmpty()) {
            System.out.println("No hay registros.");
            return;
        }
        
        System.out.println("\nID | ESTUDIANTE | HÁBITO | FECHA | VALOR | OBSERVACIÓN");
        for (Registro r : registros) {
            System.out.println(r.getIdRegistro() + " | " +
                               r.getIdEstudiante() + " | " +
                               r.getIdHabito() + " | " +
                               r.getFechaRegistro() + " | " +
                               r.getValor() + " | " +
                               r.getObservacion());
        }
    }
    private static void agregar() {
        System.out.println("\n--- AGREGAR REGISTRO ---");
        System.out.print("ID Estudiante: ");
        int idEst = scanner.nextInt();
        System.out.print("ID Hábito: ");
        int idHab = scanner.nextInt();
        System.out.print("Fecha (AAAA-MM-DD): ");
        String fechaStr = scanner.next();
        LocalDate fecha = LocalDate.parse(fechaStr);
        System.out.print("Valor: ");
        float valor = scanner.nextFloat();
        scanner.nextLine();
        System.out.print("Observación: ");
        String obs = scanner.nextLine();
        System.out.print("ID Usuario (1=admin, 2=docente): ");
        int idUser = scanner.nextInt();
        scanner.nextLine();
        
        if (controller.guardar(idEst, idHab, fecha, valor, obs, idUser)) {
            System.out.println("Registro guardado.");
        } else {
            System.out.println("Error al guardar.");
        }
    }
    private static void actualizar() {
        System.out.println("\n--- ACTUALIZAR REGISTRO ---");
        System.out.print("ID del registro: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Nuevo ID Estudiante: ");
        int idEst = scanner.nextInt();
        System.out.print("Nuevo ID Hábito: ");
        int idHab = scanner.nextInt();
        System.out.print("Nueva fecha (YYYY-MM-DD): ");
        String fechaStr = scanner.next();
        LocalDate fecha = LocalDate.parse(fechaStr);
        System.out.print("Nuevo valor: ");
        float valor = scanner.nextFloat();
        scanner.nextLine();
        System.out.print("Nueva observación: ");
        String obs = scanner.nextLine();
        System.out.print("Nuevo ID Usuario: ");
        int idUser = scanner.nextInt();
        scanner.nextLine();
        
        if (controller.actualizar(id, idEst, idHab, fecha, valor, obs, idUser)) {
            System.out.println("Registro actualizado.");
        } else {
            System.out.println("Error al actualizar.");
        }
    }
    
    private static void eliminar() {
        System.out.println("\n--- ELIMINAR REGISTRO ---");
        System.out.print("ID del registro: ");
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
