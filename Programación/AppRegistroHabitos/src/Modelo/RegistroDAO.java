
package Modelo;

import Conexion.Conexion;
import Modelo.Registro;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class RegistroDAO {
      //mostrar
     public List<Registro> listarRegistros() {
        List<Registro> lista = new ArrayList<>();
        String sql = "SELECT * FROM Registro ORDER BY id_registro";
        
        try (Connection con = Conexion.conectar();
             PreparedStatement ps = con.prepareCall(sql);
             ResultSet rs = ps.executeQuery();) {
           
            
            while (rs.next()) {
            Registro r = new Registro();
            r.setIdRegistro(rs.getInt("id_registro"));
            r.setIdEstudiante(rs.getInt("id_estudiante"));
            r.setIdHabito(rs.getInt("id_habito"));
            
            // Validación segura para fecha_registro
            java.sql.Date fRegistro = rs.getDate("fecha_registro");
            r.setFechaRegistro(fRegistro != null ? fRegistro.toLocalDate() : null);
            
            r.setValor(rs.getFloat("valor"));
            r.setObservacion(rs.getString("observacion"));
            r.setIdUsuario(rs.getInt("id_usuario"));
            
            // Validación segura para fecha_creacion
            java.sql.Date fCreacion = rs.getDate("fecha_creacion");
            r.setFechaCreacion(fCreacion != null ? fCreacion.toLocalDate() : null);
            
            lista.add(r);

            }
        } catch (Exception e) {
            System.out.println("Error al listar registros: " + e.getMessage());
        }
        return lista;
    }
     //Guardar
       public boolean guardarRegistro(Registro r) {
        String sql = "INSERT INTO Registro (id_estudiante, id_habito, fecha_registro, valor, observacion, id_usuario) VALUES (?, ?, ?, ?, ?, ?)";
        
        try {Connection con = Conexion.conectar();
        PreparedStatement pstmt = con.prepareStatement(sql);
            pstmt.setInt(1, r.getIdEstudiante());
            pstmt.setInt(2, r.getIdHabito());
            pstmt.setDate(3, java.sql.Date.valueOf(r.getFechaRegistro()));
            pstmt.setFloat(4, r.getValor());
            pstmt.setString(5, r.getObservacion());
            pstmt.setInt(6, r.getIdUsuario());
            return pstmt.executeUpdate() > 0;
        } catch (Exception e) {
            System.out.println("Error al guardar registro: " + e.getMessage());
            return false;
        }
    }
       //actualizar
        public boolean actualizarRegistro(Registro r) {
        String sql = "UPDATE Registro SET id_estudiante = ?, id_habito = ?, fecha_registro = ?, valor = ?, observacion = ?, id_usuario = ? WHERE id_registro = ?";
        
        try {Connection con = Conexion.conectar();
        PreparedStatement pstmt = con.prepareStatement(sql);
            pstmt.setInt(1, r.getIdEstudiante());
            pstmt.setInt(2, r.getIdHabito());
            pstmt.setDate(3, java.sql.Date.valueOf(r.getFechaRegistro()));
            pstmt.setFloat(4, r.getValor());
            pstmt.setString(5, r.getObservacion());
            pstmt.setInt(6, r.getIdUsuario());
            pstmt.setInt(7, r.getIdRegistro());
            return pstmt.executeUpdate() > 0;
        } catch (Exception e) {
            System.out.println("Error al actualizar registro: " + e.getMessage());
            return false;
        }
    }
    //eliminar
         public boolean eliminarRegistro(int id) {
        String sql = "DELETE FROM Registro WHERE id_registro = ?";
        
        try {Connection con = Conexion.conectar();
        PreparedStatement pstmt = con.prepareStatement(sql);
            pstmt.setInt(1, id);
            return pstmt.executeUpdate() > 0;
        } catch (Exception e) {
            System.out.println("Error al eliminar registro: " + e.getMessage());
            return false;
        }
    }
    
    
}
