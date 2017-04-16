package lab_willian_garcia_miguel_julio.controls;
import java.util.logging.Level;
import java.util.logging.Logger;
import lab_willian_garcia_miguel_julio.views.WGerente;
import lab_willian_garcia_miguel_julio.views.WInter;
import lab_willian_garcia_miguel_julio.views.WMesero;

public class Lab_Willian_Garcia_Miguel_Julio {
public static Restaurante LaPros= new Restaurante(20);
    public static WInter v2=new WInter();
    public static WGerente v3=new WGerente();
    public static void main(String[] args) {
    try {
        Thread.sleep(3000);
        
    } catch (InterruptedException ex) {
        Logger.getLogger(Lab_Willian_Garcia_Miguel_Julio.class.getName()).log(Level.SEVERE, null, ex);
    }
        WMesero v1 =new WMesero();
        v1.setLocationRelativeTo(null);
        v1.setResizable(false);
        v1.setVisible(true);
        v2.setLocation(v1.getX()+v1.getWidth()+100, v1.getY());
        v2.setVisible(true);
        v3.setVisible(true);
    }
    public static void updateWInter(){
        v2.update();
    }
}
