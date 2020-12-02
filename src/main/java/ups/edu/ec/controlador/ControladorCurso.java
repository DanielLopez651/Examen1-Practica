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
import java.util.HashSet;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import ups.edu.ec.modelo.Alumno;
import ups.edu.ec.modelo.Curso;

/**
 *
 * @author user
 */
public class ControladorCurso extends Controlador<Curso>{
    private Curso curso;
    private Matcher corpus;
    private Pattern patron;
    public ControladorCurso() {
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
        File f = new File("datos/Curso.dat");
        if (!f.exists()) {
            f.createNewFile();
        }
        try {
            FileOutputStream file = new FileOutputStream(f);
            ObjectOutputStream esc = new ObjectOutputStream(file);
            esc.writeObject(curso);
            esc.close();
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        }

    }

    public ArrayList<Curso> recibirT() throws IOException {
        File f = new File("datos/Curso.dat");
        ArrayList<Curso> tick = null;
        if (!f.exists()) {
            f.createNewFile();
        }
        FileInputStream file = null;
        ObjectInputStream l = null;
        try {
            file = new FileInputStream(f);
            l = new ObjectInputStream(file);
            tick = (ArrayList<Curso>) l.readObject();
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
    public boolean crearA(String clase,String texto){
        corpus=patron.matcher(texto);
        return corpus.find();
    }
    public void ingreesarRegex(String regex){
        patron=Pattern.compile(regex);
    }
    public Set<String> obtenerURLGoogle(String s){
        Set<String> r=new HashSet();
        corpus=patron.matcher(s);
        while(corpus.find()){
            for (int i = 0; i < corpus.groupCount(); i++) {
                r.add(corpus.group(i));
            }
        }
        return r;
    }

    public Matcher getCorpus() {
        return corpus;
    }

    public void setCorpus(Matcher corpus) {
        this.corpus = corpus;
    }

    public Pattern getPatron() {
        return patron;
    }

    public void setPatron(Pattern patron) {
        this.patron = patron;
    }
    
}
