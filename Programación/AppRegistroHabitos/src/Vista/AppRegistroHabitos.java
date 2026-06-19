
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
                    GradoVista.main(null);
                    break;
                    case 3:
                    SecciónVista.main(null);
                    break;
                    case 4:
                        HabitoVista.main(null);
                case 5:
                    System.out.println("Saliendo del sistema...");
                    break;
                default:
                    System.out.println("Opción inválida.");
            }
            
        } while (opcion != 5);
    }
    
    private static void mostrarMenuPrincipal() {
        System.out.println("\n--- SISTEMA DE REGISTRO DE HÁBITOS SALUDABLES ---");
        System.out.println("1. Gestionar Estudiantes");
        System.out.println("2. Gestionar Grados");
        System.out.println("3. Gestionar Secciones");  // ← Nueva
         System.out.println("4. Gestionar Hábitos");
        System.out.println("4. Salir");
    }
    }
    

