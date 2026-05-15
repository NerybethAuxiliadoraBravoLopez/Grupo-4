
package Modelo;

import java.time.LocalDate;


public class Reporte {
    
     private int idReporte;
    private String nombreReporte;
    private String tipoReporte;
    private LocalDate fechaGeneracion;
    private String rutaArchivo;
    private int idUsuario; 
    private String parametros;

    public Reporte() {
    }

    public Reporte(int idReporte, String nombreReporte, String tipoReporte, LocalDate fechaGeneracion, String rutaArchivo,
            int idUsuario, String parametros) {
        this.idReporte = idReporte;
        this.nombreReporte = nombreReporte;
        this.tipoReporte = tipoReporte;
        this.fechaGeneracion = fechaGeneracion;
        this.rutaArchivo = rutaArchivo;
        this.idUsuario = idUsuario;
        this.parametros = parametros;
    }

    public int getIdReporte() {
        return idReporte;
    }

    public void setIdReporte(int idReporte) {
        this.idReporte = idReporte;
    }

    public String getNombreReporte() {
        return nombreReporte;
    }

    public void setNombreReporte(String nombreReporte) {
        this.nombreReporte = nombreReporte;
    }

    public String getTipoReporte() {
        return tipoReporte;
    }

    public void setTipoReporte(String tipoReporte) {
        this.tipoReporte = tipoReporte;
    }

    public LocalDate getFechaGeneracion() {
        return fechaGeneracion;
    }

    public void setFechaGeneracion(LocalDate fechaGeneracion) {
        this.fechaGeneracion = fechaGeneracion;
    }

    public String getRutaArchivo() {
        return rutaArchivo;
    }

    public void setRutaArchivo(String rutaArchivo) {
        this.rutaArchivo = rutaArchivo;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getParametros() {
        return parametros;
    }

    public void setParametros(String parametros) {
        this.parametros = parametros;
    }


    
    
    
}
