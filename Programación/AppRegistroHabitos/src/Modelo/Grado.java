
package Modelo;
public class Grado {
     private int idGrado;
    private String nombreGrado;
    private String nivel;

    public Grado() {}
    
    public Grado(int idGrado, String nombreGrado, String nivel) {
        this.idGrado = idGrado;
        this.nombreGrado = nombreGrado;
        this.nivel = nivel;
    }
    
    //Getters y Setters
    public int getIdGrado() {
        return idGrado;
    }

    public void setIdGrado(int idGrado) {
        this.idGrado = idGrado;
    }

    public String getNombreGrado() {
        return nombreGrado;
    }

    public void setNombreGrado(String nombreGrado) {
        this.nombreGrado = nombreGrado;
    }

    public String getNivel() {
        return nivel;
    }

    public void setNivel(String nivel) {
        this.nivel = nivel;
    }  
}