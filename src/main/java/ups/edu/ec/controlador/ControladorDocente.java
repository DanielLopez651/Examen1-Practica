/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ups.edu.ec.controlador;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import ups.edu.ec.modelo.Curso;
import ups.edu.ec.modelo.Docente;

/**
 *
 * @author user
 */
public class ControladorDocente extends Controlador<Docente> {

    private Docente docente;
   

    public ControladorDocente() {
        try {
            this.setLista(  recibirT());
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        if (this.getLista() == null) {
            this.setLista(new ArrayList()) ;
        }
    }
     public void guardar() throws IOException {
        File f = new File("datos/Docente.dat");
        if (!f.exists()) {
            f.createNewFile();
        }
        try {
            FileOutputStream file = new FileOutputStream(f);
            ObjectOutputStream esc = new ObjectOutputStream(file);
            esc.writeObject(docente);
            esc.close();
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        }
        
    }
     public ArrayList<Docente> recibirT() throws IOException {
        File f = new File("datos/Docente.dat");
        ArrayList<Docente> tick = null;
        if (!f.exists()) {
            f.createNewFile();
        }
        FileInputStream file = null;
        ObjectInputStream l = null;
        try {
            file = new FileInputStream(f);
            l = new ObjectInputStream(file);
            tick = (ArrayList<Docente>) l.readObject();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        } finally {
            if (l != null) {
                l.close();
            }
        }
        return tick;
    }

           public boolean log(String cedula) {
        int i;
        for (i = 0; i < this.getLista().size(); i++) {
            if (this.getLista().get(i).getCedula().equals(cedula)
                    ) {
                return true;

            }

        }
        return false;

    }
//     public void matricidio(int codigo) {
//        for (int i = 0; i < this.getLista().size(); i++) {
//            if(this.getLista().get(i).getCodigoHombre()==codigo){
//                this.getLista().get(i).setEstado("casado");
//            }
//        }
//        try {
//            guardar();
//        } catch (IOException ex) {
//            Logger.getLogger(ControladorNovio.class.getName()).log(Level.SEVERE, null, ex);
//        }
//    } 
           public void asignarCurso(String cedula,String curso){
              for (int i = 0; i < this.getLista().size(); i++) {
                  if(this.getLista().get(i).getCedula().equals(cedula)){
                        this.getLista().get(i).setMaterias(curso);
                  }
              } 
        try {
            guardar();
        } catch (IOException ex) {
            Logger.getLogger(ControladorDocente.class.getName()).log(Level.SEVERE, null, ex);
        }
           }
}
