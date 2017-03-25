package lab_willian_garcia_miguel_julio.Models;
public class Mesa {
int id;
String Mesero;
Plato platos;
//Plato Ptr=null;
    public Mesa(int id,String Mesero) {
        this.id = id;
        if(!Mesero.equals("")) this.Mesero= Mesero;
        else this.Mesero="";
        platos=null;
    }
    public Mesa(int id) {
        this.id = id;
        Mesero="";
    }

    public void setPlatos(Plato platos) {
        this.platos = platos;
    }
    public void setPlatos() {
        this.platos = null;
    }
     public void añadirPlatos(Plato platos) {
                Plato pi = new Plato();
                pi=platos;
                while(pi.getLink()!=null){
                    pi=pi.getLink();
                }
                pi.setLink(this.platos);
                this.platos=platos;
    }

    public Plato getPlatos() {
        return platos;
    }
    
    public String getMesero() {
        return Mesero;
    }
    public void setMesero(String Mesero) {
        this.Mesero=Mesero;
    }
    /*
    public void setPtr(Plato Ptr) {
        this.Ptr = Ptr;
    }*/
    
    public int getId() {
        return id;
    }
    
}
