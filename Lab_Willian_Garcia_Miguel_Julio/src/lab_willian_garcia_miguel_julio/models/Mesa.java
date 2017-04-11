package lab_willian_garcia_miguel_julio.models;

public class Mesa {

    long cc;
    Plato platos;

    public Mesa() {
    this.cc=0;
    this.platos=null;
    }

    public Mesa(int cc) {
        this.cc = cc;
        platos = null;
    }

    public void setPlatos(Plato platos) {
        this.platos = platos;
    }

    public void setPlatos() {
        this.platos = null;
    }

    public long getCc() {
        return cc;
    }

    public void setCc(long cc) {
        this.cc = cc;
    }

    public void añadirPlatos(Plato platos) {
        Plato pi = new Plato();
        pi = platos;
        while (pi.getLink() != null) {
            pi = pi.getLink();
        }
        pi.setLink(this.platos);
        this.platos = platos;
    }

    public Plato getPlatos() {
        return platos;
    }

public String imprimirPM(Plato platos){
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
    /*
    public void setPtr(Plato Ptr) {
        this.Ptr = Ptr;
    }*/

    public long getcc() {
        return cc;
    }

}
