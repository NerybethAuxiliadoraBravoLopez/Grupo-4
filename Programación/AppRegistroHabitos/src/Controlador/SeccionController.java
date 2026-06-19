
package Controlador;

import Modelo.Sección;
import Modelo.SecciónDAO;
import java.util.List;


public class SeccionController {
    
     private SecciónDAO dao = new SecciónDAO();
    
    public List<Sección> listar() {
        return dao.listarSecciones();
    }
    
    public boolean guardar(String nombre, int idGrado) {
        Sección s = new Sección();
        s.setNombreSeccion(nombre);
        s.setIdGrado(idGrado);
        return dao.guardarSeccion(s);
    }
    
    public boolean actualizar(int id, String nombre, int idGrado) {
        Sección s = new Sección();
        s.setIdSeccion(id);
        s.setNombreSeccion(nombre);
        s.setIdGrado(idGrado);
        return dao.actualizarSeccion(s);
    }
        public void eliminar(int id) {
        if (dao.eliminarSeccion(id)) {
            System.out.println("Sección eliminada.");
        } else {
            System.out.println("Error al eliminar.");
        }
    }

}
