/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package net.micedre.bingo.ihm;

import com.itextpdf.text.BadElementException;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Image;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;

/**
 *
 * @author micedre
 */
public class BingoGeneratorFrame extends javax.swing.JFrame {

    /**
     * Creates new form BingoGeneratorFrame
     */
    public BingoGeneratorFrame() {
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

        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        buttonGroup3 = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        companyNameField = new javax.swing.JTextField();
        ColorComboBox = new javax.swing.JComboBox();
        ImageTextField = new javax.swing.JTextField();
        ImageButton = new javax.swing.JButton();
        nbPageTextField = new javax.swing.JTextField();
        beginSerialTextField = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        outputFolderTxtField = new javax.swing.JTextField(System.getProperty("user.home"));
        outputFolderButton = new javax.swing.JButton();
        genererButton = new javax.swing.JButton();
        testNbGrilleParPage = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        emptyColorComboBox = new javax.swing.JComboBox();
        jLabel9 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Générateur de grilles de Bingo");

        jLabel1.setText("Nom de l'entreprise ");

        jLabel2.setText("Couleur de la bordure");

        jLabel3.setText("Image pour les cases blanches (laisser vide pour une case blanche)");

        jLabel4.setText("Nombres de séries à générer");
        jLabel4.setToolTipText("(une page contient 6 grilles)");

        jLabel5.setText("à partir du n° de série ");

        companyNameField.setText("V.I.E.");
        companyNameField.setToolTipText("Ce nom apparaitra entre chaque grille");

        ColorComboBox.setModel(new javax.swing.DefaultComboBoxModel(BingoBorderColor.values()));
        ColorComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ColorComboBoxActionPerformed(evt);
            }
        });

        ImageTextField.setText("<pas d'image>");
        ImageTextField.setEnabled(false);

        ImageButton.setText("Parcourir");
        ImageButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ImageButtonActionPerformed(evt);
            }
        });

        nbPageTextField.setText("50");

        beginSerialTextField.setText("1");

        jLabel6.setText("Dossier de sortie du PDF");

        outputFolderTxtField.setEnabled(false);

        outputFolderButton.setText("...");
        outputFolderButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                outputFolderButtonActionPerformed(evt);
            }
        });

        genererButton.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        genererButton.setText("Générer le fichier");
        genererButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                genererButtonActionPerformed(evt);
            }
        });

        testNbGrilleParPage.setText("6");

        jLabel7.setText("Nombre de grilles par pages");

        jLabel8.setText("(Entre 1 et 6)");

        emptyColorComboBox.setModel(new javax.swing.DefaultComboBoxModel(BingoBorderColor.values()));
        emptyColorComboBox.getModel().setSelectedItem(BingoBorderColor.WHITE);
        emptyColorComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                emptyColorComboBoxActionPerformed(evt);
            }
        });

        jLabel9.setText("Couleur des cases vides");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(ImageTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 299, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(ImageButton))
                    .addComponent(jLabel3)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2)
                            .addComponent(jLabel9))
                        .addGap(71, 71, 71)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(companyNameField, javax.swing.GroupLayout.DEFAULT_SIZE, 312, Short.MAX_VALUE)
                            .addComponent(ColorComboBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(emptyColorComboBox, 0, 312, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel5)
                            .addComponent(jLabel4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(nbPageTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 213, Short.MAX_VALUE)
                            .addComponent(beginSerialTextField)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(genererButton)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(outputFolderTxtField, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(testNbGrilleParPage, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel8)))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(outputFolderButton, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(companyNameField, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(ColorComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(1, 1, 1)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(emptyColorComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(ImageButton)
                    .addComponent(ImageTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(nbPageTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(beginSerialTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(testNbGrilleParPage, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7)
                    .addComponent(jLabel8))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(outputFolderTxtField, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(outputFolderButton, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(genererButton, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void ColorComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ColorComboBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ColorComboBoxActionPerformed

    private void ImageButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ImageButtonActionPerformed
        JFileChooser jfc = new JFileChooser(new File(System.getProperty("user.home")));
        jfc.setFileSelectionMode(JFileChooser.FILES_ONLY);
        int choice = jfc.showSaveDialog(this);
        if (choice == JFileChooser.APPROVE_OPTION) {
            ImageTextField.setText(jfc.getSelectedFile().getAbsolutePath());
        }
    }//GEN-LAST:event_ImageButtonActionPerformed

    private void genererButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_genererButtonActionPerformed
        if (this.validateFields()) {
            final CreationProgessDialog cpd = new CreationProgessDialog(companyNameField.getText(), color, serialStart, nbPages, outputFolder, image, BingoGeneratorFrame.this, "Génération...",nbGrilleParPages,emptyColor);
            cpd.setVisible(true);
        }
    }//GEN-LAST:event_genererButtonActionPerformed

    private void outputFolderButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_outputFolderButtonActionPerformed
        JFileChooser jfc = new JFileChooser(new File(System.getProperty("user.home")));
        jfc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        int choice = jfc.showSaveDialog(this);
        if (choice == JFileChooser.APPROVE_OPTION) {
            outputFolderTxtField.setText(jfc.getSelectedFile().getAbsolutePath());
        }
    }//GEN-LAST:event_outputFolderButtonActionPerformed

    private void emptyColorComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_emptyColorComboBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_emptyColorComboBoxActionPerformed

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
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());

        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(BingoGeneratorFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(BingoGeneratorFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(BingoGeneratorFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(BingoGeneratorFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /*
         * Create and display the form
         */
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new BingoGeneratorFrame().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox ColorComboBox;
    private javax.swing.JButton ImageButton;
    private javax.swing.JTextField ImageTextField;
    private javax.swing.JTextField beginSerialTextField;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.ButtonGroup buttonGroup3;
    private javax.swing.JTextField companyNameField;
    private javax.swing.JComboBox emptyColorComboBox;
    private javax.swing.JButton genererButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JTextField nbPageTextField;
    private javax.swing.JButton outputFolderButton;
    private javax.swing.JTextField outputFolderTxtField;
    private javax.swing.JTextField testNbGrilleParPage;
    // End of variables declaration//GEN-END:variables
    private Image image;
    private int nbPages;
    private int serialStart;
    private File outputFolder;
    private BaseColor color;
    private BaseColor emptyColor;
    private int nbGrilleParPages;
    private boolean validateFields() {
        if (!ImageTextField.getText().equalsIgnoreCase("<pas d'image>")) {
            try {

                image = Image.getInstance(ImageTextField.getText());
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "L'image de remplissage n'a pas pu être chargée", "Erreur", JOptionPane.ERROR_MESSAGE);
                return false;
            }
        }
        try{
            nbGrilleParPages = Integer.parseInt(testNbGrilleParPage.getText());
            if(nbGrilleParPages>6 || nbGrilleParPages<1){
                 JOptionPane.showMessageDialog(this, "Le nombre de grille par page doit être compris entre 1 et 6", "Erreur", JOptionPane.ERROR_MESSAGE);
            return false;
            }
        }  catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Le nombre de grille par page doit être un nombre", "Erreur", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        try {
            nbPages = Integer.parseInt(nbPageTextField.getText());
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Le nombre de page doit être un nombre", "Erreur", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        try {
            serialStart = Integer.parseInt(beginSerialTextField.getText());
            
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Le numéro de série de début doit être un nombre", "Erreur", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        color = ((BingoBorderColor) ColorComboBox.getSelectedItem()).getColor();
        emptyColor = ((BingoBorderColor) emptyColorComboBox.getSelectedItem()).getColor();
        outputFolder = new File(outputFolderTxtField.getText());
        if (!outputFolder.isDirectory()) {
            JOptionPane.showMessageDialog(this, "Le dossier de destination doit être un répertoire", "Erreur", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        
        return true;

    }
}
