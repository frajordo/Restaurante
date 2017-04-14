package lab_willian_garcia_miguel_julio.controls;
import lab_willian_garcia_miguel_julio.models.Mesa;
import lab_willian_garcia_miguel_julio.models.Mesero;
import lab_willian_garcia_miguel_julio.models.Orden;

public class Restaurante {
    public static Mesero empleados=null;    
    public static Mesa mesas=new Mesa();
    public static Orden ordenes=null;
    public Restaurante(int m) {
        mesas.crearmesas(m);
    }
    
    public void addMesero(String name,long cc){
            if (empleados == null)  empleados=new Mesero(name,cc);
             else empleados.addMesero(name, cc);
    }
    public String getML(){
        String msg=mesas.busML();
        if(!msg.equals(""))return msg.substring(0, msg.length()-1);
        else return "";
    }

    public  Mesa getMesas() {
        return mesas;
    }
    
    public void printemple(){
        if (empleados != null) empleados.printMesero();
        else System.out.println("no hay meseros registrados");
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
