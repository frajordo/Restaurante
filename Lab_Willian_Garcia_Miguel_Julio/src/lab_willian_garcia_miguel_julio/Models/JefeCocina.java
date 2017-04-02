package lab_willian_garcia_miguel_julio.Models;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class JefeCocina {

    public String verificar(String plato, String categoria, int cantidad) {
        try {
            //Se colocan las opciones en el combobox
            FileInputStream fstream = new FileInputStream("Archivos\\Ingredientes\\I" + categoria.toUpperCase() + ".txt");
            DataInputStream in = new DataInputStream(fstream);
            BufferedReader br = new BufferedReader(new InputStreamReader(in));
            String strLine,CN="";
            while ((strLine = br.readLine()) != null) {
                if (!strLine.equals("")) {
                    StringTokenizer st1 = new StringTokenizer(strLine, ";");
                    String temp = st1.nextToken();
                    if (temp.equals(plato)) {
                        while (st1.hasMoreTokens()) {
                            StringTokenizer st2 = new StringTokenizer(st1.nextToken(), ",");
                                String temp1=st2.nextToken();
                                if(!temp1.equals("*"))CN+=Double.parseDouble(temp1)*cantidad+","+st2.nextToken()+";";
                        }
                        break;
                    }
                }
            }
            in.close();
          if(CN.equals("")) return "No encontrado";
          else{
              StringTokenizer st1 = new StringTokenizer(CN, ";");
              while (st1.hasMoreTokens()) {
                            StringTokenizer st2 = new StringTokenizer(st1.nextToken(), ",");
                            String temp1=st2.nextToken();
                            FileInputStream fs = new FileInputStream("Archivos\\Provisiones\\Pro.txt");
                            DataInputStream inn = new DataInputStream(fs);
                            BufferedReader brr = new BufferedReader(new InputStreamReader(inn));
                            //Falta verficicar las cantidades de productos
                            brr.close();
                        }
          }
          return "OK";
        } catch (Exception e) {
            return "Error: " + e.getMessage();
        }
    }
}
