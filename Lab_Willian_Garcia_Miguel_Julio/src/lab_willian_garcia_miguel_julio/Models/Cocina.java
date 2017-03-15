package lab_willian_garcia_miguel_julio.Models;

import java.util.ArrayList;

public class Cocina{
    Plato tplatos= new Plato();
    public ArrayList <Plato> punteros=new ArrayList<Plato>();
    public ArrayList <String> punterosd=new ArrayList<String>();
    public  ArrayList identificadores=new ArrayList();
    public Cocina() {
        this.tplatos = null;
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
