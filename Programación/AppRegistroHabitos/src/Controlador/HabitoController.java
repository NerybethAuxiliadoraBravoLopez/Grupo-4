
package Controlador;

import Modelo.Hábito;
import Modelo.HábitoDAO;
import java.util.List;


public class HabitoController {
    
        private HábitoDAO dao = new HábitoDAO();
        
        //lista
         public List<Hábito> listar() {
        return dao.listarHabitos();
    }

         //guardar
             public boolean guardar(String nombre, String tipo, String unidadMedida) {
        Hábito h = new Hábito();
        h.setNombreHabito(nombre);
        h.setTipoHabito(tipo);
        h.setUnidadMedida(unidadMedida);
        h.setEstado("activo");
        return dao.guardarHabito(h);
    }
 //actualizar
                 public boolean actualizar(int id, String nombre, String tipo, String unidad_medida) {
        Hábito h = new Hábito();
        h.setIdHabito(id);
        h.setNombreHabito(nombre);
        h.setTipoHabito(tipo);
        h.setUnidadMedida(unidad_medida);
        return dao.actualizarHabito(h);
    }
    //eliminar
    public void eliminar(int id) {
        if (dao.eliminarHabito(id)) {
            System.out.println("Hábito eliminado.");
        } else {
            System.out.println("Error al eliminar.");
        }
    }
    
    //  buscar
    public Hábito buscar(int id) {
        return dao.buscarHabito(id);
    }

}
