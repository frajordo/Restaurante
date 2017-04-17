/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab_willian_garcia_miguel_julio.views;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.StringTokenizer;
import javax.swing.table.DefaultTableModel;
import static lab_willian_garcia_miguel_julio.controls.Lab_Willian_Garcia_Miguel_Julio.LaPros;
import static lab_willian_garcia_miguel_julio.controls.Restaurante.ordenes;
import lab_willian_garcia_miguel_julio.models.Mesa;
import lab_willian_garcia_miguel_julio.models.Orden;
import lab_willian_garcia_miguel_julio.models.Plato;
import static lab_willian_garcia_miguel_julio.views.WMenu.Jcocina;
import static lab_willian_garcia_miguel_julio.views.WMesero.cc;

/**
 *
 * @author Administrador
 */
public class WInter extends javax.swing.JFrame {

    public static Plato plato = null, plato2 = null;
    public static Mesa mesas;
    public static Plato platos;
    public static Orden temp = null;
    public static String msg = "";

    public WInter() {
        initComponents();
        this.setSize(625, 480);
        this.setResizable(false);
        update();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Ventana Interactiva");
        setBackground(new java.awt.Color(251, 248, 198));
        getContentPane().setLayout(null);

        jPanel1.setLayout(null);

        jTable1.setBackground(new java.awt.Color(251, 248, 198));
        jTable1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
            },
            new String [] {
                "N° Orden", "Mesa","Mesero"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        jPanel1.add(jScrollPane1);
        jScrollPane1.setBounds(0, 0, 452, 402);

        jButton1.setText("<html>Terminar<br/>Orden</html>");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1);
        jButton1.setBounds(470, 22, 99, 42);

        jButton2.setText("<html>Mostar<br/>Orden</html>");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2);
        jButton2.setBounds(470, 121, 99, 65);

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Fondo.png"))); // NOI18N
        jPanel1.add(jLabel2);
        jLabel2.setBounds(-410, -170, 1220, 650);

        getContentPane().add(jPanel1);
        jPanel1.setBounds(0, 0, 660, 480);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
if(ordenes!=null){
        DefaultTableModel modelo = (DefaultTableModel) jTable1.getModel();
            int n = 0;
            Orden temp = ordenes;
            int i = 0,mesa=Integer.parseInt(modelo.getValueAt(0, 1).toString());
            while (i != n) {
                temp = temp.getLink();
                i++;
            }
            Mesa m = LaPros.busMes(Integer.parseInt(jTable1.getValueAt(n, 1).toString()));
            if (m.getPlatos() == null) {
                m.setPlatos(temp.getPedido());
            } else {
                m.añadirPlatos(temp.getPedido());
            }
            ordenes = ordenes.getLink();
            String c="";
           // Jcocina.borrarExistencias(c, msg,c);
            update();
            ingresarFichero(mesa);
}
    }//GEN-LAST:event_jButton1ActionPerformed
   
            
    public static void escribirFichero(PrintWriter pw,String msg) throws Exception {
        Scanner teclado = new Scanner(System.in);
        if(!msg.equals("")){
        pw.print(msg);
        pw.println();
        }
    }

    public static void ingresarFichero(int mesa) {
        FileWriter fw = null;
        try {
            fw =new FileWriter("Archivos\\Facturas\\Factura"+mesa+".txt", false);
            PrintWriter pw = new PrintWriter(fw);
            Plato temp=LaPros.busMes(mesa).getPlatos();
            while (temp!= null) {
                escribirFichero(pw,temp.getName()+";"+temp.getCant()+";"+temp.getPrec()+";"+temp.getCat()+";"+cc);
                temp = temp.getLink();
            }
            
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

    
    public void update() {
        DefaultTableModel modelo = (DefaultTableModel) jTable1.getModel();
        for (int i = modelo.getRowCount() - 1; i >= 0; i--) {
            modelo.removeRow(i);
        }
        temp = ordenes;
        int i = 1;
        msg = "";
        while (temp != null) {
            Plato temp2 = null;
            temp2 = temp.getPedido();
            while (temp2 != null) {
                msg += temp2.getName() + "," + temp2.getCant() + ","+temp2.getCat()+",";
                temp2 = temp2.getLink();
            }
            msg += ";";
            modelo.addRow(new Object[]{i, temp.getMesa(), temp.getMesero()});
            i++;
            temp = temp.getLink();
        }
    }
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        if (jTable1.getSelectedRow() != -1) {
            WOrden v1 = new WOrden(this, msg, jTable1.getSelectedRow());
            v1.setVisible(true);
            this.setVisible(false);
        } else {
            System.out.println("No ha seleccionado una orden");
        }

    }//GEN-LAST:event_jButton2ActionPerformed

    /**
     * @param args the command line arguments
     */

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(WInter.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(WInter.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(WInter.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(WInter.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new WInter().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
