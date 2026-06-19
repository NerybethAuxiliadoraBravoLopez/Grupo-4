
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
                        RegistroVista.main(null);
                case 6:
                    System.out.println("Saliendo del sistema...");
                    break;
                default:
                    System.out.println("Opción inválida.");
            }
            
        } while (opcion != 6);
    }
    
    private static void mostrarMenuPrincipal() {
        System.out.println("\n--- SISTEMA DE REGISTRO DE HÁBITOS SALUDABLES ---");
        System.out.println("1. Gestionar Estudiantes");
        System.out.println("2. Gestionar Grados");
        System.out.println("3. Gestionar Secciones");  
         System.out.println("4. Gestionar Hábitos");
         System.out.println("5. Registrar Hábitos");
        System.out.println("6. Salir");
    }
    }
    

