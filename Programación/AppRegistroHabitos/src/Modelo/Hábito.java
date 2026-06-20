
package Modelo;

public class Hábito {
    
    private int idHabito;
    private String nombreHabito;
    private String tipoHabito;
    private String unidadMedida;
    private String estado;

    public Hábito() {
    }

    public Hábito(int idHabito, String nombreHabito, String tipoHabito, String unidadMedida, String estado) {
        this.idHabito = idHabito;
        this.nombreHabito = nombreHabito;
        this.tipoHabito = tipoHabito;
        this.unidadMedida = unidadMedida;
        this.estado = estado;
    }
//Getters y Setters
    public int getIdHabito() {
        return idHabito;
    }

    public void setIdHabito(int idHabito) {
        this.idHabito = idHabito;
    }

    public String getNombreHabito() {
        return nombreHabito;
    }

    public void setNombreHabito(String nombreHabito) {
        this.nombreHabito = nombreHabito;
    }

    public String getTipoHabito() {
        return tipoHabito;
    }

    public void setTipoHabito(String tipoHabito) {
        this.tipoHabito = tipoHabito;
    }

    public String getUnidadMedida() {
        return unidadMedida;
    }

    public void setUnidadMedida(String unidadMedida) {
        this.unidadMedida = unidadMedida;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
    
}