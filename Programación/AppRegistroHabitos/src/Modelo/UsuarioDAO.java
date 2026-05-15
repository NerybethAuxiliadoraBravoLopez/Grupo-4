
package Modelo;

import Modelo.Usuario;
import java.util.ArrayList;
import java.util.List;


public class UsuarioDAO {
    
    
    public Usuario iniciarSesion(String email, String contrasena) { return new Usuario(); }
    public void cerrarSesion() {}
    public boolean cambiarContrasena(int idUsuario, String nuevaContra) { return true; }
    public boolean registrarUsuario(Usuario u) { return true; }
    public boolean modificarUsuario(Usuario u) { return true; }
    public boolean desactivarUsuario(int id) { return true; }
    public List<Usuario> listarPorTipo(String tipo) { return new ArrayList<>(); }

}
