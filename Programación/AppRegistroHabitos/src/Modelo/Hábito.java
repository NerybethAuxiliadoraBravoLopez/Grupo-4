
package Modelo;

import java.util.ArrayList;
import java.util.List;

public class Hábito {
    
    private int idHabito;
    private String nombreHabito;
    private String tipoHabito;
    private String unidadMedida;
    private String estado;


    public boolean crearHabito() {
        System.out.println("Creando nuevo hábito: " + this.nombreHabito);
        return true;
    }

    public boolean editarHabito() {
        System.out.println("Editando el hábito ID: " + this.idHabito);
        return true;
    }

    public boolean desactivarHabito() {
        this.estado = "Inactivo";
        return true;
    }

    public boolean reactivarHabito() {
        this.estado = "Activo";
        return true;
    }

    public Hábito consultarHabito() {
        return this;
    }

    public List<Habito> listarPorTipo() {
        return new ArrayList<>();
    }
}

