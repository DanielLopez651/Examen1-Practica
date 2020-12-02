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
import ups.edu.ec.modelo.Rector;

/**
 *
 * @author user
 */
public class ControladorRector extends Controlador<Rector> {

    private Rector rector;

    public ControladorRector() {
        try {
            this.setLista(recibirT());
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        if (this.getLista() == null) {
            this.setLista(new ArrayList());
        }
    }

    public void guardar() throws IOException {
        File f = new File("datos/Rector.dat");
        if (!f.exists()) {
            f.createNewFile();
        }
        try {
            FileOutputStream file = new FileOutputStream(f);
            ObjectOutputStream esc = new ObjectOutputStream(file);
            esc.writeObject(rector);
            esc.close();
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        }

    }

    public ArrayList<Rector> recibirT() throws IOException {
        File f = new File("datos/Rector.dat");
        ArrayList<Rector> tick = null;
        if (!f.exists()) {
            f.createNewFile();
        }
        FileInputStream file = null;
        ObjectInputStream l = null;
        try {
            file = new FileInputStream(f);
            l = new ObjectInputStream(file);
            tick = (ArrayList<Rector>) l.readObject();
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
//            public boolean login(String correo,String contraseña) {
//        int i;
//         for ( i = 0; i < this.getLista().size(); i++) {
//           if(this.getLista().get(i).getCorreo().equals(correo)&&
//                   this.getLista().get(i).getContraseña().equals(contraseña)){
//               break;
//           }
//         }
//        return this.getLista().get(i);
//      
//    }

//    public boolean iniciarSesion(String correo, String contraseña) {
//        List<Rector> lista = getLista();
//
//        for (Rector usuario1 : lista) {
//
//            if (usuario1.getCorreo().trim()
//                    .equals(correo) && usuario1.getContraseña().trim().equals(contraseña)) {
//                return true;
//            }
//        }
//
//        return false;
//    }

    public boolean log(String correo, String contraseña) {
        int i;
        for (i = 0; i < this.getLista().size(); i++) {
            if (this.getLista().get(i).getCorreo().equals(correo)
                    && this.getLista().get(i).getContraseña().equals(contraseña)) {
                return true;

            }

        }
        return false;

    }

}
