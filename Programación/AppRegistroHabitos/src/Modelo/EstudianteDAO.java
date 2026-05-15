
package Modelo;


import Modelo.Estudiante;
import java.util.ArrayList;
import java.util.List;


public class EstudianteDAO {
    public boolean agregarEstudiante(Estudiante e) { return true; }
    public boolean modificarEstudiante(Estudiante e) { return true; }
    public boolean eliminarEstudiante(int id) { return true; }
    public Estudiante consultarEstudiante(int id) { return new Estudiante(); }
    public List<Estudiante> listarEstudiantes() { return new ArrayList<>(); }
}
    

