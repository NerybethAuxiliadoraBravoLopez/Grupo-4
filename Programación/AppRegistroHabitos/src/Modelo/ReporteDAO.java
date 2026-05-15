
package Modelo;

import Modelo.Reporte;
import java.util.ArrayList;
import java.util.List;


public class ReporteDAO {
    public String generarPDF(Reporte r) { return "Ruta/archivo.pdf"; }
    public boolean generarReporteIndividual() { return true; }
    public boolean generarReporteGrupal() { return true; }
    public String generarGrafico() { return "GraficoBase64"; }
    public String exportarExcel(Reporte r) { return "Ruta/archivo.xlsx"; }
    public List<Reporte> listarReportesPorUsuario(int idUsuario) { return new ArrayList<>(); }
    public boolean eliminarReporte(int idReporte) { return true; }
}
