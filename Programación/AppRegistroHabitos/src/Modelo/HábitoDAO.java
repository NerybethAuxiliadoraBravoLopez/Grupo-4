
package Modelo;

import Conexion.Conexion;
import Modelo.Hábito;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


public class HábitoDAO {
    //mostrar
     public List<Hábito> listarHabitos() {
        List<Hábito> lista = new ArrayList<>();
        String sql = "SELECT * FROM Habito WHERE estado = 'activo'";
        
        try (Connection con = Conexion.conectar();
                PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery();) {
            
            while (rs.next()) {
                Hábito h = new Hábito();
                h.setIdHabito(rs.getInt("id_habito"));
                h.setNombreHabito(rs.getString("nombre_habito"));
                h.setTipoHabito(rs.getString("tipo_habito"));
                h.setUnidadMedida(rs.getString("unidad_medida"));
                h.setEstado(rs.getString("estado"));
                lista.add(h);
            }
        } catch (Exception e) {
            System.out.println("Error al listar hábitos: " + e.getMessage());
        }
        return lista;
    }
     //guardar
   public boolean guardarHabito(Hábito h) {
    String sql = "INSERT INTO Habito (nombre_habito, tipo_habito, unidad_medida, estado) VALUES (?, ?, ?, ?)";
    
    try (Connection con = Conexion.conectar();
         PreparedStatement pstmt = con.prepareStatement(sql)) {
        
        pstmt.setString(1, h.getNombreHabito());
        pstmt.setString(2, h.getTipoHabito());
        pstmt.setString(3, h.getUnidadMedida());
        pstmt.setString(4, "activo");
        
        return pstmt.executeUpdate() > 0;
        
    } catch (Exception e) {
        System.out.println("Error al guardar hábito: " + e.getMessage());
        return false;
    }
}

    
    //actualizar
    public boolean actualizarHabito(Hábito h) {
        String sql = "UPDATE Habito SET nombre_habito = ?, tipo_habito = ?, unidad_medida = ? WHERE id_habito = ?";
        
try (Connection con = Conexion.conectar();
     PreparedStatement pstmt = con.prepareStatement(sql)) {
            pstmt.setString(1, h.getNombreHabito());
            pstmt.setString(2, h.getTipoHabito());
            pstmt.setString(3, h.getUnidadMedida());
            pstmt.setInt(4, h.getIdHabito());
            
            return pstmt.executeUpdate() > 0;
        } catch (Exception e) {
            System.out.println("Error al actualizar hábito: " + e.getMessage());
            return false;
        }
    }
    //eliminar
 public boolean eliminarHabito(int id) {
        String sql = "UPDATE habito SET estado = 'inactivo' WHERE id_habito = ?";
        
try (Connection con = Conexion.conectar();
     PreparedStatement pstmt = con.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            return pstmt.executeUpdate() > 0;
        } catch (Exception e) {
            System.out.println("Error al eliminar hábito: " + e.getMessage());
            return false;
        }
    }
  //buscar
  public Hábito buscarHabito(int id) {
        String sql = "SELECT * FROM Habito WHERE id_habito = ?";
        
        try (PreparedStatement pstmt = (PreparedStatement) Conexion.conectar()) {
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();
            
            if (rs.next()) {
                Hábito h = new Hábito();
                h.setIdHabito(rs.getInt("idHabito"));
                h.setNombreHabito(rs.getString("nombreHabito"));
                h.setTipoHabito(rs.getString("tipoHabito"));
                h.setUnidadMedida(rs.getString("unidadMedida"));
                h.setEstado(rs.getString("estado"));
                return h;
            }
        } catch (Exception e) {
            System.out.println("Error al buscar hábito: " + e.getMessage());
        }
        return null;
    }
    
}
