/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package steganography.pkg01;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import java.awt.image.BufferedImage;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;

import javax.imageio.ImageIO;
/**
 *
 * @author Millennium
 */
public class MainFrame extends javax.swing.JFrame {
 
    EncryptionManager encryptionManager = new EncryptionManager(); 
    DecryptionManager decryptionManager = new DecryptionManager();
    public MainFrame() {
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

        FilePath = new java.awt.TextField();
        TextButton = new javax.swing.JButton();
        EncryptButton = new javax.swing.JButton();
        DecryptButton = new javax.swing.JButton();
        ImgButton = new javax.swing.JButton();
        ImgPath = new java.awt.TextField();
        ImageDisplay = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        FilePath.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        FilePath.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                FilePathActionPerformed(evt);
            }
        });

        TextButton.setText("Choose Text File");
        TextButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TextButtonActionPerformed(evt);
            }
        });

        EncryptButton.setText("Encrypt");
        EncryptButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EncryptButtonActionPerformed(evt);
            }
        });

        DecryptButton.setText("Decrypt");
        DecryptButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DecryptButtonActionPerformed(evt);
            }
        });

        ImgButton.setText("Choose Image");
        ImgButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ImgButtonActionPerformed(evt);
            }
        });

        ImgPath.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ImgPathActionPerformed(evt);
            }
        });

        ImageDisplay.setLayout(null);
        ImageDisplay.add(jLabel1);
        jLabel1.setBounds(1, 6, 540, 260);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(ImgPath, javax.swing.GroupLayout.DEFAULT_SIZE, 925, Short.MAX_VALUE)
                            .addComponent(FilePath, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(ImgButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(TextButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(166, 166, 166))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(EncryptButton)
                        .addGap(175, 175, 175)
                        .addComponent(DecryptButton))
                    .addComponent(ImageDisplay, javax.swing.GroupLayout.PREFERRED_SIZE, 573, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(64, 64, 64)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(TextButton)
                    .addComponent(FilePath, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(ImgButton)
                    .addComponent(ImgPath, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ImageDisplay, javax.swing.GroupLayout.DEFAULT_SIZE, 269, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(EncryptButton)
                    .addComponent(DecryptButton))
                .addGap(225, 225, 225))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void TextButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TextButtonActionPerformed
                 JFileChooser chooser= new JFileChooser();
                 chooser.showOpenDialog(null);
                 File file = chooser.getSelectedFile();
                 FilePath.setText(file.getAbsolutePath());
    }//GEN-LAST:event_TextButtonActionPerformed

    private void FilePathActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FilePathActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_FilePathActionPerformed

    private void EncryptButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EncryptButtonActionPerformed
        try {
            encryptionManager.Encrypt(FilePath.getText(), ImgPath.getText());
        } catch (IOException ex) {
            Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
        
         JFileChooser chooser= new JFileChooser();
         chooser.showOpenDialog(null);
         File file = chooser.getSelectedFile();
        try {
            ImageIO.write(encryptionManager.GetEncryptedImage(), "png", file);
        } catch (IOException ex) {
            Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_EncryptButtonActionPerformed

    private void ImgButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ImgButtonActionPerformed
                 JFileChooser chooser= new JFileChooser();
                 chooser.showOpenDialog(null);
                 File file = chooser.getSelectedFile();
                 ImgPath.setText(file.getAbsolutePath());
                 ImageIcon imageIcon = new ImageIcon(ImgPath.getText());
                 jLabel1.setIcon(imageIcon);
    }//GEN-LAST:event_ImgButtonActionPerformed

    private void ImgPathActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ImgPathActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ImgPathActionPerformed

    private void DecryptButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DecryptButtonActionPerformed
        // TODO add your handling code here:
          try {
            decryptionManager.Decrypt(ImgPath.getText());
            
        } catch (IOException ex) {
            Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
          System.out.println(decryptionManager.outputText);
        /*
         JFileChooser chooser= new JFileChooser();
         chooser.showOpenDialog(null);
         File file = chooser.getSelectedFile();
         */
    }//GEN-LAST:event_DecryptButtonActionPerformed

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
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton DecryptButton;
    private javax.swing.JButton EncryptButton;
    private java.awt.TextField FilePath;
    private javax.swing.JPanel ImageDisplay;
    private javax.swing.JButton ImgButton;
    private java.awt.TextField ImgPath;
    private javax.swing.JButton TextButton;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
}
