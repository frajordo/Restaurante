package lab_willian_garcia_miguel_julio.models;

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
        int i=1;
        while (i<m) {
            temp.setLink(new Mesa((i+1)));
            temp=temp.getLink();
            i++;
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
                str+=temp.getName()+" "+temp.getCant()+"\n";
                temp=temp.getLink();
            }
        }
        return str;

}
}
