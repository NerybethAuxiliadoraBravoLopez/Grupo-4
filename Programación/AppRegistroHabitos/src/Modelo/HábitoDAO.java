
package Modelo;

import Modelo.Hábito;
import java.util.ArrayList;
import java.util.List;


public class HábitoDAO {
    public boolean crearHabito(Hábito h) { return true; }
    public boolean editarHabito(Hábito h) { return true; }
    public boolean desactivarHabito(int id) { return true; }
    public boolean reactivarHabito(int id) { return true; }
    public Hábito consultarHabito(int id) { return new Hábito(); }
    public List<Hábito> listarPorTipo(String tipo) { return new ArrayList<>(); }
}
