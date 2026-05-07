 
package Modelo;

import java.util.ArrayList;
import java.util.List;

public class Sección {
     private int idSeccion;
    private String nombreSeccion;
    private int idGrado; 


    public boolean asignarEstudiante() {
        System.out.println("Asignando estudiante a la sección...");
        return true;
    }

    public List<Estudiante> listarEstudiantes() {
        System.out.println("Obteniendo lista de estudiantes de esta sección...");
        return new ArrayList<>();
    }

    public Grado obtenerGrado() {
        System.out.println("Consultando el grado al que pertenece esta sección...");
        return new Grado(); 
    }

    public boolean modificarSeccion() {
        System.out.println("Actualizando datos de la sección...");
        return true;
    }
}

