package Modelo;

import java.time.LocalDate;
import java.time.LocalDateTime;


public class Estudiante {
    
    private int id;
    private String nombres;
    private String apellidos;
    private LocalDate fechanacimiento;
    private String direccion;
    private String telefono;
    private String emaill;
    private int idgrado;
    private String estado;
    private LocalDateTime fechainscripcion;

    public Estudiante(int id, String nombres, String apellidos, LocalDate fechanacimiento, String direccion, String telefono, String emaill, int idgrado, String estado, LocalDateTime fechainscripcion) {
        this.id = id;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.fechanacimiento = fechanacimiento;
        this.direccion = direccion;
        this.telefono = telefono;
        this.emaill = emaill;
        this.idgrado = idgrado;
        this.estado = estado;
        this.fechainscripcion = fechainscripcion;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public LocalDate getFechanacimiento() {
        return fechanacimiento;
    }

    public void setFechanacimiento(LocalDate fechanacimiento) {
        this.fechanacimiento = fechanacimiento;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEmaill() {
        return emaill;
    }

    public void setEmaill(String emaill) {
        this.emaill = emaill;
    }

    public int getIdgrado() {
        return idgrado;
    }

    public void setIdgrado(int idgrado) {
        this.idgrado = idgrado;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public LocalDateTime getFechainscripcion() {
        return fechainscripcion;
    }

    public void setFechainscripcion(LocalDateTime fechainscripcion) {
        this.fechainscripcion = fechainscripcion;
    }
    
    
    
    
}
