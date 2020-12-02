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
public class Materia {
    private int codigo;
    private String asignatura;

    public Materia() {
    }

    public Materia(int codigo, String asignatura) {
        this.setAsignatura(asignatura);
        this.setCodigo(codigo);
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getAsignatura() {
        return asignatura;
    }

    public void setAsignatura(String asignatura) {
        this.asignatura = asignatura;
    }

    @Override
    public String toString() {
        return "Materia{" + "codigo=" + codigo + ", asignatura=" + asignatura + '}';
    }
    
    
    
}
