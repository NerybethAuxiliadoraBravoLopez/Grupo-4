
package Controlador;

import Modelo.Estudiante;
import Modelo.EstudianteDAO;
import java.time.LocalDate;
import java.util.List;


public class EstudianteController {
    
        private EstudianteDAO dao = new EstudianteDAO();

        //Listar
        public List<Estudiante> listar() {
        return dao.listarEstudiantes();
    }
        
        public boolean guardar(int idEstudiante, String nombre, String apellido, String email, LocalDate fechaNacimiento, int idGrado) {
        Estudiante e = new Estudiante(idEstudiante, nombre, apellido, email, fechaNacimiento, idGrado);
        return dao.guardarEstudiante(e);
    }

        public void eliminar(int id) {
        if (dao.eliminarEstudiante(id)) {
            System.out.println("Estudiante eliminado correctamente");
        } else {
            System.out.println("Error al eliminar");
        }
    }
        public void actualizar(int id, String nombre, String apellido, String email, LocalDate fechaNacimiento, int idGrado) {
        Estudiante e = new Estudiante(id, nombre, apellido, email, fechaNacimiento, idGrado);
        
        if (dao.actualizarEstudiante(e)) {
            System.out.println("Datos actualizados con éxito");
        } else {
            System.out.println("ERROR AL ACTUALIZAR");
        }
    }
 
}

