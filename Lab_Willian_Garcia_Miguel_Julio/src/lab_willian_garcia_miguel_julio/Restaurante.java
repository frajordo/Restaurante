package lab_willian_garcia_miguel_julio;
import java.util.ArrayList;
import lab_willian_garcia_miguel_julio.Models.Cocina;
import lab_willian_garcia_miguel_julio.Models.JefeCocina;
import lab_willian_garcia_miguel_julio.Models.Mesa;
import lab_willian_garcia_miguel_julio.Models.Mesero;
import lab_willian_garcia_miguel_julio.Views.DCook;
import lab_willian_garcia_miguel_julio.Views.VMesero;
public class Restaurante {
    ArrayList<Mesa> Mesas= new ArrayList();
    Mesero empleados;
    Mesero femp;
    Cocina cocinaP;
    JefeCocina Jefec;
    public static Mesa table;
    public Restaurante(int m) {
        Jefec = new JefeCocina();
        empleados=null;
        cocinaP=new Cocina();
        for (int i = 0; i < m; i++) 
            Mesas.add(new Mesa(i+1));
    }

    public JefeCocina getJefec() {
        return Jefec;
    }
    
    public  Cocina getCocinaP() {
        return cocinaP;
    }
    public Mesa buscarMesa(int id){
        for (int i = 0; i < Mesas.size(); i++) {
            if(Mesas.get(i).getId()==id)return Mesas.get(i);
        }
        return null;
    }
    public String mesaslibres(){
        String str="";
        for (int i = 0; i < Mesas.size(); i++) {
            if(Mesas.get(i).getMesero().equals(""))
                str+=Mesas.get(i).getId()+",";
        }
        return str.substring(0,str.length()-1);
    }
    public void addMesero(Mesero empleado){
            if (empleados == null) {
                this.empleados = empleado;
                femp = empleado;
            } else {
                empleado.setLink(this.empleados);
                this.empleados = empleado;
            }
    }
    public static Restaurante LaPros= new Restaurante(20);
     public static void main(String[] args) {
        Mesero wm= new Mesero("Willian Julio");
        LaPros.addMesero(wm);
        //LaPros.takeTable(wm,15);
        LaPros.mesaslibres();
        VMesero v1=new VMesero(wm,LaPros,table);
        v1.setVisible(true);
        DCook v2=new DCook(LaPros.cocinaP);
        v2.setVisible(true);   
    }
    
}
