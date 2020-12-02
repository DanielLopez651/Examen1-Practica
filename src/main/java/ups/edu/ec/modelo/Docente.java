/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ups.edu.ec.modelo;

/**
 *
 * @author user
 */
public class Docente {
    
    private String nombre;
    private String cedula;
    private String apellido;
    
    private String materias;

    public Docente() {
    }

    public Docente(String nombre, String cedula, String apellido) {
         this.setNombre(nombre);
        this.setCedula(cedula);
        this.setApellido(apellido);
       
    }

    public Docente(String nombre, String cedula, String apellido, String materias) {
        this.setNombre(nombre);
        this.setCedula(cedula);
        this.setApellido(apellido);
        this.setMaterias(materias);
        
    }

    public String getMaterias() {
        return materias;
    }

    public void setMaterias(String materias) {
        this.materias = materias;
    }

    
    
    

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    @Override
    public String toString() {
        return "Docente{" + "nombre=" + nombre + ", cedula=" + cedula + ", apellido=" + apellido + ", materias=" + materias + '}';
    }

    

   
}
