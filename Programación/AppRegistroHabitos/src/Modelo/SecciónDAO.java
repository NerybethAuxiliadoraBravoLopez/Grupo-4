
package Modelo;

import Modelo.Sección;
import java.util.ArrayList;
import java.util.List;

public class SecciónDAO {
    
    public boolean asignarEstudiante(int idEstudiante, int idSeccion) { return true; }
    public List<Estudiante> listarEstudiantes(int idSeccion) { return new ArrayList<>(); }
    public Grado obtenerGrado(int idSeccion) { return new Grado(); }
    public boolean modificarSeccion(Sección s) { return true; }
}
