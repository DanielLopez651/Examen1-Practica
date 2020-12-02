/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ups.edu.ec.modelo;

import java.util.Objects;

/**
 *
 * @author user
 */
public class Rector {

    private String nombre;
    private String cedula;
    private String apellido;
    private String correo;
    private String contraseña;
    private Rector r;

    public Rector() {
    }

    public Rector(String nombre, String cedula, String apellido, String correo, String contraseña) {
        this.setNombre(nombre);
        this.setCedula(cedula);
        this.setApellido(apellido);
        this.setCorreo(correo);
        this.setContraseña(contraseña);
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

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 53 * hash + Objects.hashCode(this.r);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Rector other = (Rector) obj;
        if (!Objects.equals(this.r, other.r)) {
            return false;
        }
        return true;
    }
    

    @Override
    public String toString() {
        return "Rector{" + "nombre=" + nombre + ", cedula=" + cedula + ", apellido=" + apellido + ", correo=" + correo + ", contrase\u00f1a=" + contraseña + '}';
    }
    
}
