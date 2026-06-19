
package Modelo;

import Conexion.Conexion;
import Modelo.Sección;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class SecciónDAO {
    
    //Listar
    public List<Sección> listarSecciones() {
        List<Sección> lista = new ArrayList<>();
        String sql = "SELECT * FROM Seccion ORDER BY id_seccion";
        
        try ( Connection con = Conexion.conectar();
             PreparedStatement ps = con.prepareCall(sql);
             ResultSet rs = ps.executeQuery();) {
            
            while (rs.next()) {
                Sección s = new Sección();
                s.setIdSeccion(rs.getInt("id_seccion"));
                s.setNombreSeccion(rs.getString("nombre_seccion"));
                s.setIdGrado(rs.getInt("id_grado"));
                lista.add(s);
            }
        } catch (Exception e) {
            System.out.println("Error al listar secciones: " + e.getMessage());
        }
        return lista;
    }
    //Guardar 
    public boolean guardarSeccion(Sección s) {
        String sql = "INSERT INTO Seccion (nombre_seccion, id_grado) VALUES (?, ?)";
        
        try {Connection con = Conexion.conectar();
        PreparedStatement ps = con.prepareStatement(sql);
        
            ps.setString(1, s.getNombreSeccion());
            ps.setInt(2, s.getIdGrado());
            return ps.executeUpdate() > 0;
            
        } catch (Exception e) {
            System.out.println("Error al guardar sección: " + e.getMessage());
            return false;
        }
    }
    //Actualizar
    public boolean actualizarSeccion(Sección s) {
        String sql = "UPDATE Seccion SET nombre_seccion = ?, id_grado = ? WHERE id_seccion = ?";
        
        try {Connection con = Conexion.conectar();
        PreparedStatement ps = con.prepareStatement(sql);
        
            ps.setString(1, s.getNombreSeccion());
            ps.setInt(2, s.getIdGrado());
            ps.setInt(3, s.getIdSeccion());
            return ps.executeUpdate() > 0;
        } catch (Exception e) {
            System.out.println("Error al actualizar sección: " + e.getMessage());
            return false;
        }
    }
    //Eliminar
    public boolean eliminarSeccion(int id) {
        String sql = "DELETE FROM Seccion WHERE id_seccion = ?";
        
        try {Connection con = Conexion.conectar();
        PreparedStatement ps = con.prepareStatement(sql);
        
            ps.setInt(1, id);
            return ps.executeUpdate() > 0;
        } catch (Exception e) {
            System.out.println("Error al eliminar sección: " + e.getMessage());
            return false;
        }
    }
}
