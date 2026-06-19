
package Modelo;

import Conexion.Conexion;
import Modelo.Grado;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


public class GradoDAO {
    
    //Mostrar Grados
    public List<Grado> listarGrados() {
        List<Grado> lista = new ArrayList<>();
        String sql = "SELECT * FROM Grado ORDER BY id_grado";
        
        try ( Connection con = Conexion.conectar();
             PreparedStatement ps = con.prepareCall(sql);
             ResultSet rs = ps.executeQuery();) {
            
            while (rs.next()) {
                Grado g = new Grado();
                g.setIdGrado(rs.getInt("id_grado"));
                g.setNombreGrado(rs.getString("nombre_grado"));
                g.setNivel(rs.getString("nivel"));
                lista.add(g);
            }
        } catch (Exception e) {
            System.out.println("Error al listar grados: " + e.getMessage());
        }
        return lista;
    }
    
    //Guardar 
    public boolean guardarGrado(Grado g) {
    String sql = "INSERT INTO Grado (nombre_grado, nivel) VALUES (?, ?)";

    try (Connection con = Conexion.conectar();
         PreparedStatement ps = con.prepareStatement(sql)) { 

        ps.setString(1, g.getNombreGrado());
        ps.setString(2, g.getNivel());
        
        return ps.executeUpdate() > 0;

    } catch (Exception e) {
        System.out.println("Error al guardar grado: " + e.getMessage());
        return false;
    }
}
 //Actualizar
     public boolean actualizarGrado(Grado g) {
        String sql = "UPDATE Grado SET nombre_grado = ?, nivel = ? WHERE id_grado = ?";
        
        try (Connection con = Conexion.conectar();
         PreparedStatement ps = con.prepareStatement(sql)) { 

            ps.setString(1, g.getNombreGrado());
            ps.setString(2, g.getNivel());
            ps.setInt(3, g.getIdGrado());
            return ps.executeUpdate() > 0;
        } catch (Exception e) {
            System.out.println("Error al actualizar grado: " + e.getMessage());
            return false;
        }
    }
    //Eliminar
      public boolean eliminarGrado(int id) {
        String sql = "DELETE FROM Grado WHERE id_grado = ?";
        
        try (Connection con = Conexion.conectar();
         PreparedStatement ps = con.prepareStatement(sql)) { 

            ps.setInt(1, id);
            return ps.executeUpdate() > 0;
        } catch (Exception e) {
            System.out.println("Error al eliminar grado: " + e.getMessage());
            return false;
        }
    }
    
     
    
}
