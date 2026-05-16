
package Modelo;

import java.time.LocalDate;

public class Registro {
    private int idRegistro;
    private int idEstudiante;
    private int idHabito;
    private LocalDate fechaRegistro;
    private float valor;
    private String observacion;
    private int idUsuario;
    private LocalDate fechaCreacion;

    public Registro() {
    }

    public Registro(int idRegistro, int idEstudiante, int idHabito, LocalDate fechaRegistro, float valor, String observacion, 
            int idUsuario, LocalDate fechaCreacion) {
        this.idRegistro = idRegistro;
        this.idEstudiante = idEstudiante;
        this.idHabito = idHabito;
        this.fechaRegistro = fechaRegistro;
        this.valor = valor;
        this.observacion = observacion;
        this.idUsuario = idUsuario;
        this.fechaCreacion = fechaCreacion;
    }

    public int getIdRegistro() {
        return idRegistro;
    }

    public void setIdRegistro(int idRegistro) {
        this.idRegistro = idRegistro;
    }

    public int getIdEstudiante() {
        return idEstudiante;
    }

    public void setIdEstudiante(int idEstudiante) {
        this.idEstudiante = idEstudiante;
    }

    public int getIdHabito() {
        return idHabito;
    }

    public void setIdHabito(int idHabito) {
        this.idHabito = idHabito;
    }

    public LocalDate getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(LocalDate fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public float getValor() {
        return valor;
    }

    public void setValor(float valor) {
        this.valor = valor;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public LocalDate getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(LocalDate fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }


   
}
    

