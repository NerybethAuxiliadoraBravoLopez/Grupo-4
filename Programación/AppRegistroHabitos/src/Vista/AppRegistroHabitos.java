
package Vista;

import java.util.Scanner;



public class AppRegistroHabitos {

        private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
int opcion;
        
        do {
            mostrarMenuPrincipal();
            System.out.print("Opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine();
            
            switch (opcion) {
                case 1:
                    EstudianteVista.main(null);
                    break;
               
                case 2:
                    System.out.println("Saliendo del sistema...");
                    break;
                default:
                    System.out.println("Opción inválida.");
            }
            
        } while (opcion != 2);
    }
    
    private static void mostrarMenuPrincipal() {
        System.out.println("\n--- SISTEMA DE REGISTRO DE HÁBITOS SALUDABLES ---");
        System.out.println("1. Gestionar Estudiantes");
        System.out.println("2. Salir");
    }
    }
    

