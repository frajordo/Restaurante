package lab_willian_garcia_miguel_julio.Models;
public class Mesero {
String Nombre;
Mesero link;
int[] id=new int [5];//pensamos cambiarlo
    public Mesero(String Nombre) {
        this.Nombre = Nombre;
        this.link =null;
    }

    public void setLink(Mesero link) {
        this.link = link;
    }

    public int tMesas() {
        int j=0;
        for (int i = 0; i < 10; i++) {
            if(id[i]!=0)j++;
        }
        return j;
    }
    public String ids() {
        String j="";
        for (int i = 0; i < 10; i++) {
            j+=id[i];
        }
        return j;
    }
    
    public String getNombre() {
        return Nombre;
    }
}
