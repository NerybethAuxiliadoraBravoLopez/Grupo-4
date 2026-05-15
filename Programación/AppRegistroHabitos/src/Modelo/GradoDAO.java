
package Modelo;

import Modelo.Grado;
import java.util.ArrayList;
import java.util.List;


public class GradoDAO {
    
    public boolean agregarGrado(Grado g) { return true; }
    public boolean modificarGrado(Grado g) { return true; }
    public boolean eliminarGrado(int id) { return true; }
    public Grado consultarGrado(int id) { return new Grado(); }
    public List<Grado> listarGrados() { return new ArrayList<>(); }
}
