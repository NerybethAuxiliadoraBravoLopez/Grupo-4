
package Modelo;

import java.util.ArrayList;
import java.util.List;


public class Grado {
     private int idGrado;
    private String nombreGrado;
    private String nivel;


    public boolean agregarGrado() {
        System.out.println("Guardando el grado: " + this.nombreGrado);
        return true; 
    }

    public boolean modificarGrado() {
        System.out.println("Modificando datos del grado ID... " + this.idGrado);
        return true;
    }

    public boolean eliminarGrado(int id) {
        System.out.println("Eliminando grado... " + id);
        return true;
    }

    public Grado consultarGrado(int id) {
        System.out.println("Buscando datos del grado... " + id);
        return this; 
    }

    public List<Grado> listarGrados() {
        System.out.println("Generando lista de grados...");
        List<Grado> lista = new ArrayList<>();
        return lista;
    }
}

