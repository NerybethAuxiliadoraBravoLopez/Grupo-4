package Modelo;

import java.util.ArrayList;
import java.util.List;


public class Grado {
    
    private int idgrado;
    private String nombreGrado;
    private String nivel;
    
     public boolean agregarGrado() {
        System.out.println("Guardando el grado: " + this.nombreGrado);
        // Aquí iría la lógica para insertar en la base de datos
        return true; 
    }

    // Para modificar, se asume que los atributos de esta clase ya tienen los cambios
    public boolean modificarGrado() {
        System.out.println("Modificando datos del grado ID: " + this.idgrado);
        return true;
    }

    // Para eliminar, podrías pedir el ID por parámetro
    public boolean eliminarGrado(int id) {
        System.out.println("Eliminando grado con ID: " + id);
        return true;
    }

    // Devuelve un objeto tipo Grado con la información encontrada
    public Grado consultarGrado(int id) {
        System.out.println("Buscando datos del grado " + id);
        // Aquí buscarías en tu lista o BD y devolverías el objeto
        return this; 
    }

    // Devuelve una lista con todos los grados registrados
    public List<Grado> listarGrados() {
        System.out.println("Generando lista de grados...");
        List<Grado> lista = new ArrayList<>();
        return lista;
    }
}

