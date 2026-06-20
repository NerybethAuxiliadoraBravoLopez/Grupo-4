 
package Modelo;
public class Sección {
     private int idSeccion; //Atributos privados
    private String nombreSeccion;
    private int idGrado; 

    public Sección() {
    }

    public Sección(int idSeccion, String nombreSeccion, int idGrado) {
        this.idSeccion = idSeccion;
        this.nombreSeccion = nombreSeccion;
        this.idGrado = idGrado;
    }
//Getters y Setters publicos
    public int getIdSeccion() {
        return idSeccion;
    }

    public void setIdSeccion(int idSeccion) {
        this.idSeccion = idSeccion;
    }

    public String getNombreSeccion() {
        return nombreSeccion;
    }

    public void setNombreSeccion(String nombreSeccion) {
        this.nombreSeccion = nombreSeccion;
    }

    public int getIdGrado() {
        return idGrado;
    }

    public void setIdGrado(int idGrado) {
        this.idGrado = idGrado;
    }

    

}

