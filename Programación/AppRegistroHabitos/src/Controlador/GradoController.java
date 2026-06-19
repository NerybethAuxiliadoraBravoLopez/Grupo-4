
package Controlador;

import Modelo.Grado;
import Modelo.GradoDAO;
import java.util.List;

 
public class GradoController {
    
    private GradoDAO dao = new GradoDAO();
    
    public List<Grado> listar() {
        return dao.listarGrados();
    }
    
    public boolean guardar(String nombre, String nivel) {
        Grado g = new Grado();
        g.setNombreGrado(nombre);
        g.setNivel(nivel);
        return dao.guardarGrado(g);
    }
    
    public boolean actualizar(int id, String nombre, String nivel) {
        Grado g = new Grado();
        g.setIdGrado(id);
        g.setNombreGrado(nombre);
        g.setNivel(nivel);
        return dao.actualizarGrado(g);
    }

    public void eliminar(int id) {
        if (dao.eliminarGrado(id)) {
            System.out.println("Grado eliminado.");
        } else {
            System.out.println("Error al eliminar.");
        }
    }
    
}
