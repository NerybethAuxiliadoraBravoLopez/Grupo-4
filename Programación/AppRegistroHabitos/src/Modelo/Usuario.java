
package Modelo;

import java.util.ArrayList;
import java.util.List;


public class Usuario {
    
     private int idUsuario;
    private String nombre;
    private String apellido;
    private String email;
    private String contrasena;
    private String tipoUsuario;
    private boolean estado;


    public Usuario iniciarSesion() {
        System.out.println("Validando credenciales para: " + this.email);
        return this;
    }

    public void cerrarSesion() {
        System.out.println("Sesión cerrada correctamente.");
    }

    public boolean cambiarContrasena() {
        System.out.println("Procesando cambio de contraseña...");
        return true;
    }

    public boolean registrarUsuario() {
        System.out.println("Registrando nuevo usuario en el sistema...");
        return true;
    }

    public boolean modificarUsuario() {
        System.out.println("Actualizando datos del usuario...");
        return true;
    }

    public boolean desactivarUsuario() {
        this.estado = false;
        System.out.println("El usuario ha sido desactivado.");
        return true;
    }

    public List<Usuario> listarPorTipo() {
        System.out.println("Filtrando usuarios por tipo: " + this.tipoUsuario);
        return new ArrayList<>();
    }
}

