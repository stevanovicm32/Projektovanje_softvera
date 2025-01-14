/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package formsKlijent;

import controller.KlijentskiKontroler;
import domain.Klijent;
import domain.Nacionalnost;
import forms.MainForma;
import java.awt.Window;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Lenovo
 */
public class FormaKlijent extends javax.swing.JDialog {
    Klijent pomocni=null;
    public FormaKlijent(Window parent, boolean modal, Klijent k, int signal) {
        super(parent, modal ? ModalityType.APPLICATION_MODAL : ModalityType.MODELESS);
        initComponents();
        setLocationRelativeTo(null);
        pomocni=k;
        switch (signal) {
            case 0:
                setTitle("Dodavanje klijenta");
                jTextFieldIme.setText("");
                jTextFieldPrezime.setText("");
                jTextFieldTelefon.setText("");
                jTextFieldEmail.setText("");
                jTextFieldAdresa.setText("");
                this.popuniNacionalnost();
                jTextFieldIme.setEditable(true);
                jTextFieldPrezime.setEditable(true);
                jTextFieldTelefon.setEditable(true);
                jTextFieldEmail.setEditable(true);
                jTextFieldAdresa.setEditable(true);
                jComboBoxNacionalnost.setEnabled(true);
                jButtonIzmeni.setEnabled(false);
                break;
            case 1:
                setTitle("Detalji klijenta");
                jTextFieldIme.setText(""+k.getIme());
                jTextFieldPrezime.setText(""+k.getPrezime());
                jTextFieldTelefon.setText(""+k.getTelefon());
                jTextFieldEmail.setText(""+k.getEmail());
                jTextFieldAdresa.setText(""+k.getAdresa());
                this.popuniNacionalnost();
                jComboBoxNacionalnost.setSelectedItem(k.getNacionalnost());
                jTextFieldIme.setEditable(false);
                jTextFieldPrezime.setEditable(false);
                jTextFieldTelefon.setEditable(false);
                jTextFieldEmail.setEditable(false);
                jTextFieldAdresa.setEditable(false);
                jComboBoxNacionalnost.setEnabled(false);
                jButtonDodaj.setEnabled(false);
                jButtonIzmeni.setEnabled(false);
                break;
            case 2:
                setTitle("Izmena klijenta");
                jTextFieldIme.setText(""+k.getIme());
                jTextFieldPrezime.setText(""+k.getPrezime());
                jTextFieldTelefon.setText(""+k.getTelefon());
                jTextFieldEmail.setText(""+k.getEmail());
                jTextFieldAdresa.setText(""+k.getAdresa());
                this.popuniNacionalnost();
                jComboBoxNacionalnost.setSelectedItem(k.getNacionalnost());
                jTextFieldIme.setEditable(false);
                jTextFieldPrezime.setEditable(false);
                jTextFieldTelefon.setEditable(true);
                jTextFieldEmail.setEditable(true);
                jTextFieldAdresa.setEditable(true);
                jComboBoxNacionalnost.setEnabled(false);
                jButtonDodaj.setEnabled(false);
                break;
            default:
                break;
        }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jTextFieldIme = new javax.swing.JTextField();
        jTextFieldPrezime = new javax.swing.JTextField();
        jTextFieldTelefon = new javax.swing.JTextField();
        jTextFieldEmail = new javax.swing.JTextField();
        jTextFieldAdresa = new javax.swing.JTextField();
        jComboBoxNacionalnost = new javax.swing.JComboBox();
        jButtonOtkazi = new javax.swing.JButton();
        jButtonDodaj = new javax.swing.JButton();
        jButtonIzmeni = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setText("Ime");

        jLabel2.setText("Prezime");

        jLabel3.setText("Telefon");

        jLabel4.setText("Email");

        jLabel5.setText("Adresa");

        jLabel6.setText("Nacionalnost");

        jTextFieldIme.setText("Masa");

        jTextFieldPrezime.setText("Stevanovic");

        jTextFieldTelefon.setText("0605881889");

        jTextFieldEmail.setText("stevanovic.masa32@gmail.com");

        jTextFieldAdresa.setText("Omladinskih brigada 7");

        jComboBoxNacionalnost.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jButtonOtkazi.setText("Otkazi");
        jButtonOtkazi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonOtkaziActionPerformed(evt);
            }
        });

        jButtonDodaj.setText("Dodaj");
        jButtonDodaj.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonDodajActionPerformed(evt);
            }
        });

        jButtonIzmeni.setText("Izmeni");
        jButtonIzmeni.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonIzmeniActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jTextFieldIme, javax.swing.GroupLayout.PREFERRED_SIZE, 264, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 34, Short.MAX_VALUE)
                        .addComponent(jTextFieldPrezime, javax.swing.GroupLayout.PREFERRED_SIZE, 264, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jTextFieldTelefon, javax.swing.GroupLayout.PREFERRED_SIZE, 264, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jTextFieldEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 264, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jComboBoxNacionalnost, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jTextFieldAdresa, javax.swing.GroupLayout.DEFAULT_SIZE, 264, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButtonOtkazi)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButtonIzmeni)
                        .addGap(18, 18, 18)
                        .addComponent(jButtonDodaj)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jTextFieldIme, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jTextFieldPrezime, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jTextFieldTelefon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jTextFieldEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jTextFieldAdresa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jComboBoxNacionalnost, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 15, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonOtkazi)
                    .addComponent(jButtonDodaj)
                    .addComponent(jButtonIzmeni))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonOtkaziActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonOtkaziActionPerformed
        this.dispose();
    }//GEN-LAST:event_jButtonOtkaziActionPerformed

    private void jButtonDodajActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonDodajActionPerformed
        try {
            if(jTextFieldIme.getText().isEmpty() || jTextFieldPrezime.getText().isEmpty() || jTextFieldAdresa.getText().isEmpty() || jTextFieldEmail.getText().isEmpty() || jTextFieldTelefon.getText().isEmpty()){
                JOptionPane.showMessageDialog(this, "Sva polja moraju biti popunjena!", "Greska!", JOptionPane.ERROR_MESSAGE);
                return;
            }
                     
            String ime = jTextFieldIme.getText();
            String prezime = jTextFieldPrezime.getText();
            String adresa = jTextFieldAdresa.getText();
            String telefon = jTextFieldTelefon.getText();
            String email = jTextFieldEmail.getText();
            
            Nacionalnost nacionalnost = (Nacionalnost) jComboBoxNacionalnost.getSelectedItem();
            
            Klijent k = new Klijent(null, ime, prezime, adresa, telefon, email, nacionalnost);
            KlijentskiKontroler.getInstance().addKlijent(k);
            MainForma mf = (MainForma) getParent();
            mf.popuniKlijente();
            JOptionPane.showMessageDialog(this, "Uspesno dodat klijent.", "Obavestenje!", JOptionPane.INFORMATION_MESSAGE);
            this.dispose();
        } catch (Exception ex) {
            Logger.getLogger(FormaKlijent.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButtonDodajActionPerformed

    private void jButtonIzmeniActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonIzmeniActionPerformed
        try {
            if(jTextFieldIme.getText().isEmpty() || jTextFieldPrezime.getText().isEmpty() || jTextFieldAdresa.getText().isEmpty() || jTextFieldEmail.getText().isEmpty() || jTextFieldTelefon.getText().isEmpty()){
                JOptionPane.showMessageDialog(this, "Sva polja moraju biti popunjena!", "Greska!", JOptionPane.ERROR_MESSAGE);
                return;
            }
            
            String ime = jTextFieldIme.getText();
            String prezime = jTextFieldPrezime.getText();
            String adresa = jTextFieldAdresa.getText();
            String telefon = jTextFieldTelefon.getText();
            String email = jTextFieldEmail.getText();
            
            Nacionalnost nacionalnost = (Nacionalnost) jComboBoxNacionalnost.getSelectedItem();
            
            Klijent k = new Klijent(pomocni.getIdKlijent(), ime, prezime, telefon, adresa, email, nacionalnost);
            KlijentskiKontroler.getInstance().updateKlijent(k);
            
            MainForma mf = (MainForma) getParent();
            mf.popuniKlijente();
            JOptionPane.showMessageDialog(this, "Uspesno izmenjen klijent.", "Obavestenje!", JOptionPane.INFORMATION_MESSAGE);
            this.dispose();
        } catch (Exception ex) {
            Logger.getLogger(FormaKlijent.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButtonIzmeniActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonDodaj;
    private javax.swing.JButton jButtonIzmeni;
    private javax.swing.JButton jButtonOtkazi;
    private javax.swing.JComboBox jComboBoxNacionalnost;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JTextField jTextFieldAdresa;
    private javax.swing.JTextField jTextFieldEmail;
    private javax.swing.JTextField jTextFieldIme;
    private javax.swing.JTextField jTextFieldPrezime;
    private javax.swing.JTextField jTextFieldTelefon;
    // End of variables declaration//GEN-END:variables
    private void popuniNacionalnost() {
        try {
            ArrayList<Nacionalnost> nacionalnosti = KlijentskiKontroler.getInstance().getAllNacionalnost();

            jComboBoxNacionalnost.removeAllItems();
            
            for (Nacionalnost nacionalnost : nacionalnosti) {
                jComboBoxNacionalnost.addItem(nacionalnost);
            }

        } catch (Exception ex) {
            Logger.getLogger(MainForma.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
