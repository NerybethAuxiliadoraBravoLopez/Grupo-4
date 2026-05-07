
package Modelo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


public class Reporte {
    
     private int idReporte;
    private String nombreReporte;
    private String tipoReporte;
    private LocalDate fechaGeneracion;
    private String rutaArchivo;
    private int idUsuario; 
    private String parametros;


    public String generarPDF() {
        System.out.println("Generando PDF...");
        return "Ruta/del/archivo.pdf";
    }

    public boolean generarReporteIndividual() {
        return true;
    }

    public boolean generarReporteGrupal() {
        return true;
    }

    public String generarGrafico() {
        return "ImagenGraficoBase64";
    }

    public String exportarExcel() {
        return "Ruta/del/archivo.xlsx";
    }

    public List listarReportesPorUsuario() {
        return new ArrayList();
    }

    public boolean eliminarReporte() {
        return true;
    }
    
}
