package lab_willian_garcia_miguel_julio.Models;

import java.util.ArrayList;
public class Mesa {
int id;
String Mesero;
Plato Ptr=null;
    public Mesa(int id,String Mesero) {
        this.id = id;
        if(!Mesero.equals("")) this.Mesero= Mesero;
        else this.Mesero="";
    }
    public Mesa(int id) {
        this.id = id;
        Mesero="";
    }

    public String getMesero() {
        return Mesero;
    }
    public void setMesero(String Mesero) {
        this.Mesero=Mesero;
    }
    public void setPtr(Plato Ptr) {
        this.Ptr = Ptr;
    }
    
    public int getId() {
        return id;
    }
    
}
