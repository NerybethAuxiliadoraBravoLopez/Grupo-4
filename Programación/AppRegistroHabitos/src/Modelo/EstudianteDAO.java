
package Modelo;


import Conexion.Conexion;
import java.sql.Connection;
import Modelo.Estudiante;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


public class EstudianteDAO {
    //Listar estudiantes
     public List<Estudiante> listarEstudiantes() {
        List<Estudiante> lista = new ArrayList<>();
        String sql = "SELECT * FROM estudiante";
        
        try (Connection con = Conexion.conectar();
             PreparedStatement ps = con.prepareCall(sql);
             ResultSet rs = ps.executeQuery();) {
            
            while (rs.next()) {
                Estudiante e = new Estudiante();
                e.setIdEstudiante(rs.getInt("id_estudiante"));
                e.setNombre(rs.getString("nombre"));
                e.setApellido(rs.getString("apellido"));
                e.setEmail(rs.getString("email"));
                e.setFechaNacimiento(rs.getDate("fecha_nacimiento").toLocalDate());
                e.setIdGrado(rs.getInt("id_grado"));
                lista.add(e);
            }
        } catch (Exception e) {
            System.out.println("Error al listar estudiantes: " + e.getMessage());
        }
        return lista;
    }
     //Guardar estudiante
     public boolean guardarEstudiante(Estudiante e) {
    String sql = "INSERT INTO estudiante (nombre, apellido, email, fecha_nacimiento, id_grado) VALUES (?, ?, ?, ?, ?)";
    
    try {
        Connection con = Conexion.conectar();
        PreparedStatement ps = con.prepareStatement(sql);
        
        ps.setString(1, e.getNombre());
        ps.setString(2, e.getApellido());
        ps.setString(3, e.getEmail());
        ps.setDate(4, java.sql.Date.valueOf(e.getFechaNacimiento()));
        ps.setInt(5, e.getIdGrado());
        
        int resultado = ps.executeUpdate();
        return resultado > 0;
        
    } catch (Exception ex) {
        System.out.println("Error al guardar: " + ex.getMessage());
        return false;
    }
}
     //eliminar estudiante
public boolean eliminarEstudiante(int id) {
    String sql = "DELETE FROM estudiante WHERE id_estudiante = ?";
    
    try {
        Connection con = Conexion.conectar();
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setInt(1, id);
        
        int resultado = ps.executeUpdate();
        return resultado > 0;
        
    } catch (Exception ex) {
        System.out.println("Error al eliminar estudiante: " + ex.getMessage());
        return false;
    }
}
//Actualizar
public boolean actualizarEstudiante(Estudiante e) {
    String sql = "UPDATE estudiante SET nombre = ?, apellido = ?, email = ?, fecha_nacimiento = ?, id_grado = ? WHERE id_estudiante = ?";
    
    try {
        Connection con = Conexion.conectar();
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, e.getNombre());
        ps.setString(2, e.getApellido());
        ps.setString(3, e.getEmail());
        ps.setDate(4, java.sql.Date.valueOf(e.getFechaNacimiento()));
        ps.setInt(5, e.getIdGrado());
        ps.setInt(6, e.getIdEstudiante());
        
        int resultado = ps.executeUpdate();
        return resultado > 0;
        
    } catch (Exception ex) {
        System.out.println("Error al actualizar estudiante: " + ex.getMessage());
        return false;
    }
}
//Buscar
 public Estudiante buscarEstudiante(int id) {
        String sql = "SELECT * FROM estudiante WHERE id_estudiante = ?";
        
        try {
            Connection con = Conexion.conectar();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            
            if (rs.next()) {
                Estudiante e = new Estudiante();
                e.setIdEstudiante(rs.getInt("id_estudiante"));
                e.setNombre(rs.getString("nombre"));
                e.setApellido(rs.getString("apellido"));
                e.setEmail(rs.getString("email"));
                e.setFechaNacimiento(rs.getDate("fecha_nacimiento").toLocalDate());
                e.setIdGrado(rs.getInt("id_grado"));
                return e;
            }
        } catch (Exception ex) {
            System.out.println("Error al buscar: " + ex.getMessage());
        }
        return null;
 }
}

