
package Modelo;

import Modelo.Grado;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


public class GradoDAO {
    
    private Connection conexion;  
     public GradoDAO(Connection conexion) {
        this.conexion = conexion;}
    
    
     public boolean agregarGrado(Grado g) {  String sql = "INSERT INTO Grado (nombre_grado, nivel) VALUES";
        try (PreparedStatement pstmt = conexion.prepareStatement(sql)) {
            pstmt.setString(1, g.getNombreGrado());
            pstmt.setString(2, g.getNivel());
            return pstmt.executeUpdate() > 0;
        } catch (SQLException e) {
            System.out.println("Error al agregar: " + e.getMessage());
            return false;
        }}
    public boolean modificarGrado(Grado g) { String sql = "UPDATE Grado SET nombre_grado = ?, nivel = ? WHERE id_grado = ?";
        
        try (PreparedStatement pstmt = conexion.prepareStatement(sql)) {
            pstmt.setString(1, g.getNombreGrado());
            pstmt.setString(2, g.getNivel());
            pstmt.setInt(3, g.getIdGrado());
            return pstmt.executeUpdate() > 0;
        } catch (SQLException e) {
            System.out.println("Error al modificar: " + e.getMessage());
            return false;
        } }
    public boolean eliminarGrado(int id) {  String sql = "DELETE FROM Grado WHERE id_grado = ?";
        
        try (PreparedStatement pstmt = conexion.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            return pstmt.executeUpdate() > 0;
        } catch (SQLException e) {
            System.out.println("Error al eliminar: " + e.getMessage());
            return false;
        }}
    public Grado consultarGrado(int id) { String sql = "SELECT * FROM Grado WHERE id_grado = ?";
        
        try (PreparedStatement pstmt = conexion.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();
            
            if (rs.next()) {
                Grado g = new Grado();
                g.setIdGrado(rs.getInt("id_grado"));
                g.setNombreGrado(rs.getString("nombre_grado"));
                g.setNivel(rs.getString("nivel"));
                return g;
            }
        } catch (SQLException e) {
            System.out.println("Error al consultar: " + e.getMessage());
        }
        return null;
    } 
public List<Grado> listarGrados() {
    List<Grado> lista = new ArrayList<>();  // ← Declarar la lista
    String sql = "SELECT * FROM Grado ORDER BY id_grado";
    
    try (Statement stmt = conexion.createStatement()) {
        ResultSet rs = stmt.executeQuery(sql);
        
        while (rs.next()) {
            Grado g = new Grado();
            g.setIdGrado(rs.getInt("id_grado"));        // ← Usar getInt (no getString)
            g.setNombreGrado(rs.getString("nombre_grado"));
            g.setNivel(rs.getString("nivel"));
            lista.add(g);
        }
    } catch (SQLException e) {
        System.out.println("Error al listar: " + e.getMessage());
    }
    return lista;
}
}
    
   

