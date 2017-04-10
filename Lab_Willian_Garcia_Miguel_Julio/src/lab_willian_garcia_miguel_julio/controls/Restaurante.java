package lab_willian_garcia_miguel_julio.controls;
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
    
    public String busCC(long cc){
        if (empleados != null) {
                if(empleados.busC(cc)){
                return "Acceso exitoso";
                }else{
                return "Acceso denegado\nUsuario no registrado";
                }
         } else {
                return "Acceso denegado\nNo hay meseros registrados";
            }
    }
    
    
    public Mesero busM(long cc){
            return empleados.busM(cc);
    }
    
}
