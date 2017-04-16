package lab_willian_garcia_miguel_julio.models;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.OutputStreamWriter;
import java.util.Random;
import java.util.StringTokenizer;

public class JefeCocina {

    private JefeCocina JCocina;

    public JefeCocina(JefeCocina JCocina) {
        this.JCocina = JCocina;
    }

    public boolean VerificarIngredientes(String lineaBuscar, String varaible) {
        int yyy = 0;
        int uu = 0;
        File archivo = null;
        FileReader fr = null;
        BufferedReader br = null;

        try {
// Apertura del fichero y creacion de BufferedReader para poder
// hacer una lectura comoda (disponer del metodo readLine()).
            archivo = new File("Archivos\\Ingredientes\\I" + varaible + ".txt");
            fr = new FileReader(archivo);
            br = new BufferedReader(fr);
        // Lectura del fichero linea a linea
            String linea;
            boolean encontrado = false;
            String lineaEncontrada = null;
            while ((linea = br.readLine()) != null && !encontrado) {// buscar la cadena palabra en la linea leida
                if (linea.contains(lineaBuscar)) {
                    encontrado = true;
                    lineaEncontrada = linea;
                    StringTokenizer st = new StringTokenizer(lineaEncontrada, ";");
                    String g = st.nextToken();
                    StringTokenizer st2 = new StringTokenizer(g, ",");
                    int i = 0;
                    String temp = "";
                    String temp2;
                    yyy = st2.countTokens();
                    temp = st2.nextToken();
                    while (i < yyy - 1) {
                        temp2 = temp;
                        temp = st2.nextToken();
                        if (i % 2 != 0) {
                            boolean encontrado2 = false;
                            File archivo2 = new File("Archivos\\Provisiones\\Pro.txt");
                            String lineaEncontrada2 = null;

                            FileReader fr2 = new FileReader(archivo2);
                            BufferedReader br2 = new BufferedReader(fr2);
                            String linea2;
                            linea2 = br2.readLine();
                            while ((linea2 = br2.readLine()) != null && encontrado2 != true) {
                            // buscar la cadena palabra en la linea leida
                                if (linea2.contains(temp)) {
                                    lineaEncontrada2 = linea2;
                                    StringTokenizer st3 = new StringTokenizer(lineaEncontrada2, ";");
                                    st3.nextToken();
                                    String h = st3.nextToken();
                                    double V = Double.parseDouble(h);
                                    double w = Double.parseDouble(temp2);
                                    if (V > w) {
                                        uu = uu + 1;
                                    }else{
                                        return false;
                                    }
                                    encontrado2 = true;
                                }
                            }
                            try {
                                if (null != fr2) {
                                    fr2.close();
                                }
                                if (br2 != null) {
                                    br2.close();
                                }
                            } catch (Exception e2) {
                                e2.printStackTrace();
                            }
                        }
                        i++;
                    }
                }
                }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
// En el finally cerrar el fichero, para asegurarse
// que se cierra tanto si todo va bien como si salta una excepcion.
            try {
                if (null != fr) {
                    fr.close();
                }
                if (br != null) {
                    br.close();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }

        } // fin finally

        if (((yyy + 1) / 2) == uu || (yyy / 2) == uu) {
            return true;
        } else {
            return false;
        }

    }

    public void ModificarFichero(File FficheroAntiguo, String Satigualinea, String Snuevalinea) {
        /*Obtengo un numero aleatorio*/
        Random numaleatorio = new Random(3816L);
        /*Creo un nombre para el nuevo fichero apartir del
         *numero aleatorio*/
        String SnombFichNuev = FficheroAntiguo.getParent() + "/auxiliar" + String.valueOf(Math.abs(numaleatorio.nextInt())) + ".txt";
        /*Crea un objeto File para el fichero nuevo*/
        File FficheroNuevo = new File(SnombFichNuev);
        try {
            /*Si existe el fichero inical*/
            if (FficheroAntiguo.exists()) {
                /*Abro un flujo de lectura*/
                BufferedReader Flee = new BufferedReader(new FileReader(FficheroAntiguo));
                String Slinea;
                /*Recorro el fichero de texto linea a linea*/
                while ((Slinea = Flee.readLine()) != null) {
                    /*Si la lia obtenida es igual al la bucada
                     *para modificar*/
                    if (Slinea.toUpperCase().trim().equals(Satigualinea.toUpperCase().trim())) {
                        /*Escribo la nueva linea en vez de la que tenia*/
                        EcribirFichero(FficheroNuevo, Snuevalinea);
                    } else {
                        /*Escribo la linea antigua*/
                        EcribirFichero(FficheroNuevo, Slinea);
                    }
                }
                /*Obtengo el nombre del fichero inicial*/
                String SnomAntiguo = FficheroAntiguo.getName();
                /*Borro el fichero inicial*/
                BorrarFichero(FficheroAntiguo);
                /*renombro el nuevo fichero con el nombre del 
                *fichero inicial*/
                FficheroNuevo.renameTo(FficheroAntiguo);
                /*Cierro el flujo de lectura*/
                Flee.close();
            } else {
                System.out.println("Fichero No Existe");
            }
        } catch (Exception ex) {
            /*Captura un posible error y le imprime en pantalla*/
            System.out.println(ex.getMessage());
        }
    }

    public void EcribirFichero(File Ffichero, String SCadena) {
        try {
            //Si no Existe el fichero lo crea
            if (!Ffichero.exists()) {
                Ffichero.createNewFile();
            }
            /*Abre un Flujo de escritura,sobre el fichero con codificacion utf-8. 
           *Además  en el pedazo de sentencia "FileOutputStream(Ffichero,true)",
           *true es por si existe el fichero seguir añadiendo texto y no borrar lo que tenia*/
            BufferedWriter Fescribe = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(Ffichero, true), "utf-8"));
            /*Escribe en el fichero la cadena que recibe la función. 
           *el string "\r\n" significa salto de linea*/
            Fescribe.write(SCadena + "\r\n");
            //Cierra el flujo de escritura
            Fescribe.close();
        } catch (Exception ex) {
            //Captura un posible error le imprime en pantalla 
            System.out.println(ex.getMessage());
        }
    }

    public void BorrarFichero(File Ffichero) {
        try {
            /*Si existe el fichero*/
            if (Ffichero.exists()) {
                /*Borra el fichero*/
                Ffichero.delete();
                System.out.println("Fichero Borrado con Exito");
            }
        } catch (Exception ex) {
            /*Captura un posible error y le imprime en pantalla*/
            System.out.println(ex.getMessage());
        }
    }

    public void borrarExistencias(String variable, String lineaBuscar) {
        String ww="";
        int yyy = 0;
        int uu = 0;
        File archivo = null;
        FileReader fr = null;
        BufferedReader br = null;

        try {
// Apertura del fichero y creacion de BufferedReader para poder
// hacer una lectura comoda (disponer del metodo readLine()).
            archivo = new File("Archivos\\Ingredientes\\I" + variable + ".txt");
            fr = new FileReader(archivo);
            br = new BufferedReader(fr);
// Lectura del fichero linea a linea
            String linea;
            boolean encontrado = false;
            String lineaEncontrada = null;

            while ((linea = br.readLine()) != null && !encontrado) {
// buscar la cadena palabra en la linea leida
                if (linea.contains(lineaBuscar)) {
                    encontrado = true;
                    lineaEncontrada = linea;
                    StringTokenizer st = new StringTokenizer(lineaEncontrada, ";");
                    String g = st.nextToken();
                    StringTokenizer st2 = new StringTokenizer(g, ",");
                    int i = 0;
                    String temp = "";
                    String temp2;
                    yyy = st2.countTokens();
                    temp = st2.nextToken();
                    while (i < yyy - 1) {
                        temp2 = temp;
                        temp = st2.nextToken();
                        if (i % 2 != 0) {
                            //temp2 = st2.nextToken();
                            boolean encontrado2 = false;
                            File archivo2 = new File("Archivos\\Provisiones\\Pro.txt");
                            String lineaEncontrada2 = null;
                            FileReader fr2 = new FileReader(archivo2);
                            BufferedReader br2 = new BufferedReader(fr2);
                            String linea2;
                            linea2 = br2.readLine();
                            while ((linea2 = br2.readLine()) != null && encontrado2 != true) {
// buscar la cadena palabra en la linea leida
                                System.out.println(temp);
                                if (linea2.contains(temp)) {
                                    System.out.println(temp);
                                    lineaEncontrada2 = linea2;
                                    StringTokenizer st3 = new StringTokenizer(lineaEncontrada2, ";");
                                   ww= st3.nextToken();
                                    String h = st3.nextToken();
                                    ww=ww+";"+h+";"+st3.nextToken();
                                    double V = Integer.parseInt(h);
                                    double w = Integer.parseInt(temp2);
                                    System.out.println(V);
                                    System.out.println(w);
                                    if (V > w) {
                                        ModificarFichero(archivo2, linea2,ww );
                                    }
                                    encontrado2 = true;
                                    System.out.println(temp2 +" "+temp);
                                } 
                            }
                            try {
                                if (null != fr2) {
                                    fr2.close();
                                }
                                if (br2 != null) {
                                    br2.close();
                                }
                            } catch (Exception e2) {
                                e2.printStackTrace();
                            }
                        }
                        i++;
                    }
                } else {
                    System.out.println("no existe");
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
// En el finally cerrar el fichero, para asegurarse
// que se cierra tanto si todo va bien como si salta una excepcion.
            try {
                if (null != fr) {
                    fr.close();
                }
                if (br != null) {
                    br.close();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }

        } // fin finally

    }

}
