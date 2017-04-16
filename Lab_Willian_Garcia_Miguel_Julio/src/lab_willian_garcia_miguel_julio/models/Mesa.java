package lab_willian_garcia_miguel_julio.models;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import static lab_willian_garcia_miguel_julio.views.WInter.escribirFichero;

public class Mesa {
    private int id;
    private  long cc;
    private Plato platos;
    private Mesa link;
    public Mesa(int id) {
        this.id=id;
        cc=0;
        platos=null;
        link=null;
    }
    public Mesa() {
        this.id=0;
        cc=0;
        platos=null;
        link=null;
    }
    
    public Mesa(long cc) {
        this.cc = cc;
        platos = null;
        link=null;
    }
    public void crearmesas(int m){
        Mesa temp=this;
        this.setId(1);
        crearA(1,true);
        crearA(1,false);
        int i=1;
        while (i<m) {
            temp.setLink(new Mesa((i+1)));
            crearA(i+1,true);
            crearA(i+1,false);
            temp=temp.getLink();
            i++;
        }
        crearC("Platos");
        crearC("Categorias");
    }
    public void crearA(int i,boolean c){
            FileWriter fw = null;
            try {
            File archivo = (c)?new File("Archivos\\Facturas\\Factura"+i+".txt"):new File("Archivos\\Mesas\\mesa"+i+".txt");
            fw = new FileWriter(archivo, false);
            PrintWriter pw = new PrintWriter(fw);
            escribirFichero(pw,"");
            } catch (Exception e) {
                System.out.println(e.getMessage());
            } finally {
                try {
                    if (fw != null) {
                        fw.close();
                    }
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
            }
    }
    
     public void crearC(String msg){
            FileWriter fw = null;
            try {
            File archivo = new File("Archivos\\Consolidados\\"+msg+".txt");
            fw = new FileWriter(archivo, false);
            PrintWriter pw = new PrintWriter(fw);
            escribirFichero(pw,"");
            } catch (Exception e) {
                System.out.println(e.getMessage());
            } finally {
                try {
                    if (fw != null) {
                        fw.close();
                    }
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
            }
    }
    public Mesa getLink() {
        return link;
    }

    public void setLink(Mesa link) {
        this.link = link;
    }
    
     public String getmsgPlatos() {
        Plato pi = new Plato();
        pi = this.platos;
        String msg="";
        while (pi!= null) {
            msg+=pi.getName()+",";
            pi=pi.getLink();
        }
        if(!msg.equals(""))return msg.substring(0, msg.length()-1);
        else return "";
    }

    public Plato getPlatos() {
        return platos;
    }

    public void setPlatos(Plato platos) {
        this.platos = platos;
    }

    public long getCc() {
        return cc;
    }
    public void setCc(long cc) {
        this.cc = cc;
    }

    public int getId() {
        return id;
    }
    
    public void setId(int id) {
        this.id = id;
    }   
    public Mesa busMxid(int id) {
        Mesa pi = new Mesa();
        pi = this;
        while (pi!= null) {
            if(pi.getId()==id)return pi;
            else pi=pi.getLink();
        }
        return null;
    }
     public String busML() {
        Mesa pi = new Mesa();
        pi = this;
        String msg="";
        while (pi!= null) {
            if(pi.getCc()==0)msg+=pi.getId()+",";
            pi=pi.getLink();
        }
        if(!msg.equals(""))return msg;
        else return "";
    }
      public long busMxcc(long cc) {
        Mesa pi = new Mesa(0);
        pi = this;
        while (pi!= null) {
            if(pi.getCc()==id)return pi.getId();
        }
        return 0;
    }
    public void añadirPlatos(Plato platos) {
        Plato pi = new Plato();
        pi = this.platos;
        while (pi.getLink() != null) {
            pi = pi.getLink();
        }
        pi.setLink(platos);
    }

   
public String imprimirPM(){
    Plato platos=this.getPlatos();
    String str="";
        if (platos== null) {
            return "Lista Vacia";
        } else {
            Plato temp = new Plato();
            temp = platos;
            str+=temp.getName()+" "+temp.getCant()+"\n";
            temp = platos.getLink();
            while (temp != null) {
                System.out.println(temp.getName()+" "+temp.getCant()+temp.getLink());
                str+=temp.getName()+" "+temp.getCant()+"\n";
                temp=temp.getLink();
            }
        }
        return str;

}
}
