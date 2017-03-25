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

    public void setId(int id) {
        for (int i = 0; i < 5; i++) {
            if(this.id[i]==0){
                this.id[i]=id;
                return;
            }
        }
    }
    
    public String getMesas() {
        String str="";
        for (int i = 0; i < 5; i++) {
            if(id[i]!=0)str+=id[i]+",";
        }
        if(str.length()!=0)return str.substring(0,str.length()-1);
        else return "";
    }
    
    public int tMesas() {
        int j=0;
        for (int i = 0; i < 5; i++) {
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
