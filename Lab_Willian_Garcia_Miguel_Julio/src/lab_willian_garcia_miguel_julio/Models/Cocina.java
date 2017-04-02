package lab_willian_garcia_miguel_julio.Models;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;

public class Cocina{
    Plato tplatos= new Plato();
    public ArrayList <Plato> punteros=new ArrayList<>();
    public ArrayList <String> punterosd=new ArrayList<>();
    public  ArrayList identificadores=new ArrayList();
    public Cocina() {
        this.tplatos = null;
    }
public  int consultarFichero(String q,String w,String r) {
        FileReader fr = null;
        FileWriter fw = null;
       int g=0;
        try {
            File fichero = new File("archivo.txt");
            fr = new FileReader(fichero);
            BufferedReader br = new BufferedReader(fr);
            
            String linea;
          
            linea = br.readLine();
            while (linea != null) {
                if (linea==q) {
                    
                }
 
            System.out.println(linea);
            linea = br.readLine();
 
        }
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                if (fr != null) {
                    fr.close();
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
 return g; 
    }
    public void añadirPlatoI(Plato tplatos,int id) {
        punterosd.add(tplatos.imprimirTexto(tplatos));
        Plato temp= new Plato();
        punteros.add(temp);
        identificadores.add(id);
    }

    public Plato getPlatos() {
        return tplatos;
    }
    
    public void añadirDespues(Plato tplatos,int id) {
        punterosd.add(tplatos.imprimirTexto(tplatos));
        Plato temp= new Plato();
        temp=tplatos;
        punteros.add(tplatos);
        identificadores.add(id); 
        /*Plato pi = new Plato();
                pi=tplatos;
                while(pi.getLink()!=null){
                    pi=pi.getLink();
                }
                pi.setLink(this.tplatos);
                this.tplatos=tplatos;*/
    }
}
