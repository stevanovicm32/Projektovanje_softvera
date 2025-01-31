/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package formsNacionalnost;

import controller.KlijentskiKontroler;
import domain.Nacionalnost;
import javax.swing.JOptionPane;
import models.TableModelNacionalnosti;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Lenovo
 */
public class FormaPretragaNacionalnosti extends javax.swing.JDialog {

    /**
     * Creates new form FormaPretragaNacionalnosti
     */
    public FormaPretragaNacionalnosti(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        setLocationRelativeTo(null);
        TableModelNacionalnosti model = new TableModelNacionalnosti();
        Thread th = new Thread(model);
        th.start();
        jTableNacionalnosti.setModel(model);
        setTitle("Pretraga nacionalnosti");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTableNacionalnosti = new javax.swing.JTable();
        jButtonOtkazi = new javax.swing.JButton();
        jButtonDetalji = new javax.swing.JButton();
        jButtonIzmeni = new javax.swing.JButton();
        jButtonObrisi = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jTextFieldNaziv = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jTextFieldPrivilegije = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jTableNacionalnosti.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTableNacionalnosti);

        jButtonOtkazi.setText("Otkazi");
        jButtonOtkazi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonOtkaziActionPerformed(evt);
            }
        });

        jButtonDetalji.setText("Detalji");
        jButtonDetalji.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonDetaljiActionPerformed(evt);
            }
        });

        jButtonIzmeni.setText("Izmeni");
        jButtonIzmeni.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonIzmeniActionPerformed(evt);
            }
        });

        jButtonObrisi.setText("Obrisi");
        jButtonObrisi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonObrisiActionPerformed(evt);
            }
        });

        jLabel1.setText("Naziv");

        jTextFieldNaziv.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextFieldNazivKeyReleased(evt);
            }
        });

        jLabel2.setText("Privilegije");

        jTextFieldPrivilegije.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextFieldPrivilegijeKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 532, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButtonOtkazi)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButtonObrisi)
                        .addGap(18, 18, 18)
                        .addComponent(jButtonIzmeni)
                        .addGap(18, 18, 18)
                        .addComponent(jButtonDetalji))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(jTextFieldNaziv, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addComponent(jTextFieldPrivilegije, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jTextFieldNaziv, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(jTextFieldPrivilegije, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(9, 9, 9)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonOtkazi)
                    .addComponent(jButtonDetalji)
                    .addComponent(jButtonIzmeni)
                    .addComponent(jButtonObrisi))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextFieldNazivKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldNazivKeyReleased
        String param = jTextFieldNaziv.getText();
        ((TableModelNacionalnosti) jTableNacionalnosti.getModel()).setParametar(param);
    }//GEN-LAST:event_jTextFieldNazivKeyReleased

    private void jButtonOtkaziActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonOtkaziActionPerformed
        this.dispose();
    }//GEN-LAST:event_jButtonOtkaziActionPerformed

    private void jButtonObrisiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonObrisiActionPerformed
        int row = jTableNacionalnosti.getSelectedRow();
        
        if(row>=0){
            Nacionalnost n = ((TableModelNacionalnosti) jTableNacionalnosti.getModel()).getSelectedNacionalnost(row);
            int result = JOptionPane.showConfirmDialog(this, "Da li ste sigurni da zelite da "
                    + "obrisete ovu nacionalnost? " + n.toString(), "Konfirmacija", JOptionPane.YES_NO_OPTION);

            if (result == JOptionPane.NO_OPTION) {
                return;
            }

            if (result == JOptionPane.YES_OPTION) {
                try {
                    KlijentskiKontroler.getInstance().deleteNacionalnost(n);
                    this.refreshTable();
                    JOptionPane.showMessageDialog(this, "Uspesno obrisana nacionalnost.");
                } catch (Exception ex) {
                    Logger.getLogger(FormaPretragaNacionalnosti.class.getName()).log(Level.SEVERE, null, ex);
                    JOptionPane.showMessageDialog(this, "Ne mozete obrisati nacionalnost, jer postoji bar jedan klijent sa istom!", "Greska!", JOptionPane.ERROR_MESSAGE);
                }
            }
        }else{
            JOptionPane.showMessageDialog(this, "Morate odabrati nacionalnost!", "Obavestenje!", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jButtonObrisiActionPerformed

    private void jButtonIzmeniActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonIzmeniActionPerformed
        int row = jTableNacionalnosti.getSelectedRow();
        int signal = 2;

        if (row >= 0) {
            Nacionalnost n = ((TableModelNacionalnosti) jTableNacionalnosti.getModel()).getSelectedNacionalnost(row);
            new FormaNacionalnost(this, true, n, signal).setVisible(true);
        }else{
            JOptionPane.showMessageDialog(this, "Morate odabrati nacionalnost!", "Obavestenje!", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jButtonIzmeniActionPerformed

    private void jButtonDetaljiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonDetaljiActionPerformed
        int row = jTableNacionalnosti.getSelectedRow();
        int signal = 2;

        if (row >= 0) {
            Nacionalnost n = ((TableModelNacionalnosti) jTableNacionalnosti.getModel()).getSelectedNacionalnost(row);
            new FormaNacionalnost(this, true, n, signal).setVisible(true);
        }else{
            JOptionPane.showMessageDialog(this, "Morate odabrati nacionalnost!", "Obavestenje!", JOptionPane.ERROR_MESSAGE);
        }   
    }//GEN-LAST:event_jButtonDetaljiActionPerformed

    private void jTextFieldPrivilegijeKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldPrivilegijeKeyReleased
        String param = jTextFieldPrivilegije.getText();
        ((TableModelNacionalnosti) jTableNacionalnosti.getModel()).setParametar2(param);
    }//GEN-LAST:event_jTextFieldPrivilegijeKeyReleased

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonDetalji;
    private javax.swing.JButton jButtonIzmeni;
    private javax.swing.JButton jButtonObrisi;
    private javax.swing.JButton jButtonOtkazi;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableNacionalnosti;
    private javax.swing.JTextField jTextFieldNaziv;
    private javax.swing.JTextField jTextFieldPrivilegije;
    // End of variables declaration//GEN-END:variables
    void refreshTable(){
        TableModelNacionalnosti tm = (TableModelNacionalnosti) jTableNacionalnosti.getModel();
        tm.refreshTable();
    }

}
