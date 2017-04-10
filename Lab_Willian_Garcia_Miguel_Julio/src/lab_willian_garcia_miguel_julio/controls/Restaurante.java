package lab_willian_garcia_miguel_julio.controls;
import javax.swing.JOptionPane;
import lab_willian_garcia_miguel_julio.models.Mesero;

public class Restaurante {
    public static Mesero empleados=null;
    public void addMesero(String name,long cc){
            if (empleados == null) {
                 empleados=new Mesero(name,cc);
            } else {
                empleados.addMesero(name, cc);
            }
    }
    
    public void printemple(){
        if (empleados != null) {
            empleados.printMesero();
            } else {
                System.out.println("no hay meseros registrados");
            }
    }
    public void busCC(long cc){
        if (empleados != null) {
                if(empleados.busM(cc)){
                JOptionPane.showMessageDialog(null, "Acceso exitoso");
                }else{
                JOptionPane.showMessageDialog(null, "Acceso denegado\nUsuario no registrado");
                }
                    
         } else {
                JOptionPane.showMessageDialog(null, "Acceso denegado\nNo hay meseros registrados");
            }
    }
    
}
