
package Modelo;

import Modelo.Registro;
import java.util.ArrayList;
import java.util.List;


public class RegistroDAO {
     public boolean registrarHabito(Registro r) { return true; }
    public List<Registro> consultarRegistros() { return new ArrayList<>(); }
    public float calcularPromedio(int idEstudiante, int idHabito) { return 0.0f; }
    public float calcularPorcentajeDeCumplimiento(int idEstudiante, int idHabito) { return 100.0f; }

}
