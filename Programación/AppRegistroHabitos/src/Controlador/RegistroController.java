
package Controlador;

import Modelo.Registro;
import Modelo.RegistroDAO;
import java.time.LocalDate;
import java.util.List;


 
public class RegistroController {
    
        private RegistroDAO dao = new RegistroDAO();
    
    public List<Registro> listar() {
        return dao.listarRegistros();
    }
    
    public boolean guardar(int idEstudiante, int idHabito, LocalDate fecha, float valor, String observacion, int idUsuario) {
        Registro r = new Registro();
        r.setIdEstudiante(idEstudiante);
        r.setIdHabito(idHabito);
        r.setFechaRegistro(fecha);
        r.setValor(valor);
        r.setObservacion(observacion);
        r.setIdUsuario(idUsuario);
        return dao.guardarRegistro(r);
    }
    
    public boolean actualizar(int id, int idEstudiante, int idHabito, LocalDate fecha, float valor, String observacion, int idUsuario) {
        Registro r = new Registro();
        r.setIdRegistro(id);
        r.setIdEstudiante(idEstudiante);
        r.setIdHabito(idHabito);
        r.setFechaRegistro(fecha);
        r.setValor(valor);
        r.setObservacion(observacion);
        r.setIdUsuario(idUsuario);
        return dao.actualizarRegistro(r);
    }

    public void eliminar(int id) {
        if (dao.eliminarRegistro(id)) {
            System.out.println("Registro eliminado.");
        } else {
            System.out.println("Error al eliminar.");
        }
    }
}
