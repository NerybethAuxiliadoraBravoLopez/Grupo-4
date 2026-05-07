package Modelo;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;


public class Estudiante {
    
     private int idEstudiante;
    private String nombre;
    private String apellido;
    private String email;
    private LocalDate fechaNacimiento;
    private int idGrado; 

    public Estudiante(int idEstudiante, String nombre, String apellido, String email, LocalDate fechaNacimiento, int idGrado) {
        this.idEstudiante = idEstudiante;
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.fechaNacimiento = fechaNacimiento;
        this.idGrado = idGrado;
    }

    public int getIdEstudiante() {
        return idEstudiante;
    }

    public void setIdEstudiante(int idEstudiante) {
        this.idEstudiante = idEstudiante;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public int getIdGrado() {
        return idGrado;
    }

    public void setIdGrado(int idGrado) {
        this.idGrado = idGrado;
    }
    
    

    public int calcularEdad() {
        if (this.fechaNacimiento != null) {
            return Period.between(this.fechaNacimiento, LocalDate.now()).getYears();
        }
        return 0;
    }

    public boolean agregarEstudiante() {
        System.out.println("Agregando a: " + this.nombre);
        return true;
    }

    public boolean modificarEstudiante() {
        System.out.println("Modificando estudiante ID: " + this.idEstudiante);
        return true;
    }

    public boolean eliminarEstudiante(int id) {
        System.out.println("Eliminando estudiante con ID: " + id);
        return true;
    }

    public Estudiante consultarEstudiante(int id) {
        System.out.println("Buscando estudiante " + id);
        return this;
    }

    public List<Estudiante> listarEstudiantes() {
        return new ArrayList<>();
    }
}

