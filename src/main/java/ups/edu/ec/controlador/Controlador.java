/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ups.edu.ec.controlador;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author user
 */
public abstract class Controlador<E> {

    private List<E> lista;

    public Controlador() {
        lista = new ArrayList();
    }

    public boolean create(E objeto) {
        return lista.add(objeto);

    }

    public List<E> getLista() {
        return lista;
    }

    public void setLista(List<E> lista) {
        this.lista = lista;
    }

}
