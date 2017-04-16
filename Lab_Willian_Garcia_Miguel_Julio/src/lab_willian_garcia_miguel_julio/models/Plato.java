/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab_willian_garcia_miguel_julio.models;

public class Plato implements Cloneable {
    
    private String name;
    private int cant;
    private float prec;
    private float time;
    private String cat;
    private Plato link;

    public Plato(String name, int cant, float prec, float time,String cat) {
        this.name = name;
        this.cant = cant;
        this.time = time;
        this.prec = prec;
        this.cat=cat;
        this.link = null;
    }

    public Plato() {
        this.name = "";
        this.cant = 0;
        this.time = 0;
        this.prec = 0;
        this.cat="";
        this.link = null;
    }

    public String getCat() {
        return cat;
    }
    
    public void setLink(Plato link) {
        this.link = link;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCant(int cant) {
        this.cant = cant;
    }

    public void setPrec(float prec) {
        this.prec = prec;
    }

    public void setTime(float time) {
        this.time = time;
    }
    
    public String getName() {
        return name;
    }

    public int getCant() {
        return cant;
    }

    public float getPrec() {
        return prec;
    }

    public float getTime() {
        return time;
    }

    public Plato getLink() {
        return link;
    }

    public void imprimir() {
        Plato link=this;
        if (link == null) {
            System.out.println("Lista Vacia");
        } else {
            Plato temp = new Plato();
            temp = link;
            while (temp != null) {
                System.out.println(temp.getName()+" "+temp.getCant()+" "+temp.getLink());
                temp=temp.getLink();
            }
        }
    }
     public String imprimirTexto(Plato link) {
         String str="";
        if (link == null) {
            return "Lista Vacia";
        } else {
            Plato temp = new Plato();
            temp = link;
            while (temp != null) {
                str+=temp.getName()+" "+temp.getCant()+"\n";
                temp=temp.getLink();
            }
        }
        return str;
    }
     @Override
     public Plato clone(){
        Plato copia=new Plato();
        copia.setName(this.getName());
        copia.setCant(this.getCant());
        copia.setPrec(this.getPrec());
        copia.setTime(this.getTime());
        copia.setLink(this.getLink());
        return copia;
     }
}
