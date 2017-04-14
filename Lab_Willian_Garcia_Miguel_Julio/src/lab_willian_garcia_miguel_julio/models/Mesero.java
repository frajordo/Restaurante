package lab_willian_garcia_miguel_julio.models;

import javax.swing.JOptionPane;

public class Mesero {

    private final String Nombre;
    private final long cc;
    private int[] mesas = new int[5];
    private int nmesas = 0;
    private Mesero link = null;

    public Mesero(String Nombre, long cc) {
        this.Nombre = Nombre;
        this.cc = cc;
    }

    public void setLink(Mesero link) {
        this.link = link;
    }

    public Mesero getLink() {
        return link;
    }

    public void addMesero(String name, long cc) {
        Mesero node = this;
        while (node.getLink() != null) {
            if (node.getCc() == cc) {
                JOptionPane.showMessageDialog(null, "El numero de CC ya se encuentra registrado");
                return;
            }
            node = node.getLink();
        }
        if (node.getCc() == cc) {
            JOptionPane.showMessageDialog(null, "El numero de CC ya se encuentra registrado");
            return;
        }
        node.setLink(new Mesero(name, cc));
        JOptionPane.showMessageDialog(null, "Registro Exitoso");
    }

    public boolean busC(long cc) {
        Mesero node = this;
        while (node != null) {
            if (cc == node.getCc()) {
                return true;
            }
            node = node.getLink();
        }
        return false;
    }
    
    public Mesero busM(long cc) {
        Mesero node = this;
        while (node != null) {
            if (cc == node.getCc()) {
                return node;
            }
            node = node.getLink();
        }
        return null;
    }

    public void printMesero() {
        Mesero node = this;
        while (node != null) {
            System.out.print(node.getCc() + " " + node.getNombre() + "\n");
            node = node.getLink();
        }
    }

    public void setM(int id) {
        if (nmesas < 5) {
            mesas[nmesas] = id;
            nmesas++;
        }
    }

    public void delM(int id) {
        int i = 0;
        boolean x = true;
        while (i < nmesas && x) {
            if (mesas[i] == id) {
                x = !x;
                for (int j = i; j < nmesas - 1; j++) {
                    mesas[j] = mesas[j + 1];
                }
                nmesas--;
            }
            i++;
        }

    }

    public String getMesas() {
        if (nmesas != 0) {
            String str = "";
            for (int i = 0; i < nmesas; i++) {
                str += mesas[i] + ",";
            }
            return str.substring(0, str.length() - 1);
        } else {
            return "";
        }
    }

    public int getNmesas() {
        return nmesas;
    }

    public long getCc() {
        return cc;
    }

    public String getNombre() {
        return Nombre;
    }
}
