/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package net.micedre.bingo.ihm;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Image;
import java.awt.Frame;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import net.micedre.bingo.BingoStrip;
import net.micedre.bingo.pdf.BingoPdf;

/**
 *
 * @author micedre
 */
public class CreationProgessDialog extends javax.swing.JDialog implements Observer {

    private String companyName;
    private BaseColor color;
    private int serialStart;
    private int nbPage;
    private File outputFolder;
    private Image imageUrl;
    private String filename;
    private int nbGrilleParPage;
    private BaseColor emptyColor;
    
    public CreationProgessDialog(String companyName, BaseColor color, int serialStart, int nbPage, File outputFolder, Image imageUrl, Frame owner, String title, int nbGrilleParPage, BaseColor emptyColor) {
        super(owner, title);
        this.companyName = companyName;
        this.color = color;
        this.serialStart = serialStart;
        this.nbPage = nbPage;
        this.outputFolder = outputFolder;
        this.imageUrl = imageUrl;
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        this.filename = companyName+"-grilleBingo-" + sdf.format(new Date()) + ".pdf";
        this.nbGrilleParPage=nbGrilleParPage;
        this.emptyColor = emptyColor;
        initComponents();
        creationProgressBar.setMaximum(nbPage);
        launchGeneration();


    }

    private void launchGeneration(){
       new Thread(new Runnable() {

            public void run() {
                System.out.println("Here");

                List<BingoStrip> strips = new ArrayList<BingoStrip>();
                jLabel1.setText("Génération des grilles...");
                for (int i = serialStart; i < nbPage + serialStart; i++) {
                    strips.add(new BingoStrip(i));
                    System.out.println(i - serialStart);
                    creationProgressBar.setValue(i - serialStart);
                    CreationProgessDialog.this.pack();
                }
                SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
                jLabel1.setText("Génération du pdf...");
                BingoPdf b = new BingoPdf(outputFolder, filename, companyName, color, imageUrl,emptyColor);
                b.addObserver(CreationProgessDialog.this);
                try {
                    b.build(strips,nbGrilleParPage);
               } catch (Exception ex) {
                        JOptionPane.showMessageDialog(CreationProgessDialog.this, ex, "Erreur", JOptionPane.ERROR_MESSAGE);

                    }
                jLabel1.setText("Réussi !! Le fichier a été généré dans le dossier "+outputFolder);
                okButton.setEnabled(true);
             
                
            }
            
        }).start();

    }

    /**
     * Creates new form CreationProgessDialog
     *
     * @param parent
     * @param modal
     */
    public CreationProgessDialog(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        creationProgressBar = new javax.swing.JProgressBar();
        okButton = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        okButton.setText("OK");
        okButton.setEnabled(false);
        okButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                okButtonActionPerformed(evt);
            }
        });

        jLabel1.setText("Génération des grilles en cours...");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(creationProgressBar, javax.swing.GroupLayout.PREFERRED_SIZE, 316, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(okButton)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(creationProgressBar, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(okButton)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void okButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_okButtonActionPerformed
        this.dispose();
    }//GEN-LAST:event_okButtonActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /*
         * Set the Nimbus look and feel
         */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /*
         * If Nimbus (introduced in Java SE 6) is not available, stay with the
         * default look and feel. For details see
         * http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(CreationProgessDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CreationProgessDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CreationProgessDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CreationProgessDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /*
         * Create and display the dialog
         */
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                CreationProgessDialog dialog = new CreationProgessDialog(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {

                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JProgressBar creationProgressBar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JButton okButton;
    // End of variables declaration//GEN-END:variables

    public void update(Observable arg0, Object arg1) {
        System.out.println("Progress"+(Integer) arg1);
        this.creationProgressBar.setValue((Integer) arg1);
        this.creationProgressBar.repaint();
    }
}