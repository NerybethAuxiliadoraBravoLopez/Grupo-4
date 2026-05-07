
package Modelo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


public class Registro {
    private int idRegistro;
    private int idEstudiante;
    private int idHabito;
    private LocalDate fechaRegistro;
    private float valor;
    private String observacion;
    private int idUsuario;
    private LocalDate fechaCreacion;


    public boolean registrarHabito() {
        System.out.println("Registrando actividad para el hábito: " + this.idHabito);
        return true;
    }

    public List<Registro> consultarRegistros() {
        System.out.println("Obteniendo historial de registros...");
        return new ArrayList<>();
    }

    public float calcularPromedio() {
        System.out.println("Calculando promedio del valor...");
        return 0.0f; 
    }

    public float calcularPorcentajeDeCumplimiento() {
        System.out.println("Calculando cumplimiento...");
        return 100.0f;
    }
}
    

