/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab_willian_garcia_miguel_julio.models;

public class Plato {
    
    private String name;
    private int cant;
    private float prec;
    private float time;
    private Plato link;

    public Plato(String name, int cant, float prec, float time) {
        this.name = name;
        this.cant = cant;
        this.time = time;
        this.prec = prec;
        this.link = null;
    }

    public Plato() {
        this.name = "";
        this.cant = 0;
        this.time = 0;
        this.prec = 0;
        this.link = null;
    }

    public void setLink(Plato link) {
        this.link = link;
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

    public void imprimir(Plato link) {
        if (link == null) {
            System.out.println("Lista Vacia");
        } else {
            Plato temp = new Plato();
            temp = link;
            while (temp != null) {
                System.out.println(temp.getName()+" "+temp.getCant());
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
}
