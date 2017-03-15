package lab_willian_garcia_miguel_julio;
import java.util.ArrayList;
import lab_willian_garcia_miguel_julio.Models.Mesa;
import lab_willian_garcia_miguel_julio.Models.Mesero;
import lab_willian_garcia_miguel_julio.Views.VMesero;
public class Restaurante {
    ArrayList<Mesa> Mesas= new ArrayList();
    Mesero empleados;
    Mesero femp;
    public Restaurante(int m) {
        empleados=null;
        for (int i = 0; i < m; i++) 
            Mesas.add(new Mesa(i+1));
    }
    public void mesaslibres(){
        for (int i = 0; i < Mesas.size(); i++) {
            if(Mesas.get(i).getMesero().equals(""))
                System.out.println(Mesas.get(i).getId());
        }
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
    
    
    public static void main(String[] args) {
        Restaurante LaPros= new Restaurante(20);
        Mesero wm= new Mesero("Willian Julio");
        LaPros.addMesero(wm);
        //LaPros.takeTable(wm,15);
        LaPros.mesaslibres();
        VMesero v1=new VMesero();
        v1.setVisible(true);   
    }
    
}
