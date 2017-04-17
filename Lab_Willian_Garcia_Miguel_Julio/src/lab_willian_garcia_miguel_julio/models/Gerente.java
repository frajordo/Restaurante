package lab_willian_garcia_miguel_julio.models;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.logging.Level;
import java.util.logging.Logger;
import static lab_willian_garcia_miguel_julio.controls.Lab_Willian_Garcia_Miguel_Julio.LaPros;

public class Gerente {

    public Gerente() {
    }
    
    
    public Mesero mgestion() {
        return LaPros.getEmpleados().mejorgestor();
    }
    public float totalVentas() throws FileNotFoundException {
        float total = 0;
        int x = LaPros.getNumerom();
        for (int i = 0; i < x; i++) {
            try {
             BufferedReader br = new BufferedReader(new FileReader("Archivos\\Mesas\\mesa" + (i + 1) + ".txt"));
             String linea= br.readLine();
                while (linea != null) {
                    if (!linea.equals("")) {
                        StringTokenizer st = new StringTokenizer(linea, ";");
                        st.nextToken();
                            total += Float.parseFloat(st.nextToken()) * Float.parseFloat(st.nextToken());
                    }
                    linea=br.readLine();
                }
                br.close();
            } catch (IOException ex) {
                Logger.getLogger(Gerente.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return total;
    }
}
