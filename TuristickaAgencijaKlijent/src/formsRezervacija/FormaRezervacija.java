/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package formsRezervacija;

import controller.KlijentskiKontroler;
import domain.Klijent;
import domain.Rezervacija;
import domain.TuristickaAgencija;
import forms.MainForma;
import java.awt.Window;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import session.Session;

/**
 *
 * @author Lenovo
 */
public class FormaRezervacija extends javax.swing.JDialog {
    Rezervacija pomocna=null;
    /**
     * Creates new form FormaRezervacija
     */
    public FormaRezervacija(Window parent, boolean modal, Rezervacija r, int signal) {
        super(parent, modal ? ModalityType.APPLICATION_MODAL : ModalityType.MODELESS);
        initComponents();
        setLocationRelativeTo(null);
        pomocna=r;
        switch (signal) {
            case 0:
                setTitle("Dodavanje rezervacije");
                jTextFieldDatumOd.setText("");
                jTextFieldDatumDo.setText("");
                jTextFieldCena.setText("");
                this.popuniKlijente();
                jTextFieldDatumOd.setEditable(true);
                jTextFieldDatumDo.setEditable(true);
                jTextFieldCena.setEditable(true);
                jComboBoxKlijent.setEnabled(true);
                jButtonIzmeni.setEnabled(false);
                jButtonDodaj.setEnabled(true);
                break;
            case 1:                
                setTitle("Detalji rezervacije");
                jButtonDodaj.setEnabled(false);
                jButtonIzmeni.setEnabled(false);
                SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
                jTextFieldDatumOd.setText(sdf.format(pomocna.getDatum()));
                jTextFieldDatumDo.setText(sdf.format(pomocna.getDatum()));
                jTextFieldCena.setText(pomocna.getCena()+" €");
                this.popuniKlijente();
                jTextFieldDatumOd.setEditable(false);
                jTextFieldDatumDo.setEditable(false);
                jTextFieldCena.setEditable(false);
                jComboBoxKlijent.setEnabled(false);
                break;
            case 2:
                setTitle("Izmena rezervacije");
                jButtonDodaj.setEnabled(false);
                SimpleDateFormat sdf1 = new SimpleDateFormat("dd.MM.yyyy");
                jTextFieldDatumOd.setText(sdf1.format(pomocna.getDatum()));
                jTextFieldDatumDo.setText(sdf1.format(pomocna.getDatum()));
                jTextFieldCena.setText(pomocna.getCena()+" €");
                this.popuniKlijente();
                jTextFieldDatumOd.setEditable(true);
                jTextFieldDatumDo.setEditable(true);
                jTextFieldCena.setEditable(true);
                jComboBoxKlijent.setEnabled(false);
                jButtonIzmeni.setEnabled(true);
                break;
            default:
                break;
        }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jTextFieldDatumOd = new javax.swing.JTextField();
        jComboBoxKlijent = new javax.swing.JComboBox();
        jLabel3 = new javax.swing.JLabel();
        jTextFieldCena = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jTextFieldDatumDo = new javax.swing.JTextField();
        jButtonOtkazi = new javax.swing.JButton();
        jButtonDodaj = new javax.swing.JButton();
        jButtonIzmeni = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setText("Datum od");

        jTextFieldDatumOd.setText("4.7.2003");

        jComboBoxKlijent.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel3.setText("Klijent");

        jTextFieldCena.setText("100");

        jLabel4.setText("Cena");

        jLabel5.setText("Datum do");

        jTextFieldDatumDo.setText("5.8.2003");

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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel5))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jTextFieldDatumDo, javax.swing.GroupLayout.DEFAULT_SIZE, 264, Short.MAX_VALUE)
                            .addComponent(jTextFieldDatumOd)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jTextFieldCena)
                            .addComponent(jComboBoxKlijent, 0, 264, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButtonOtkazi)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 142, Short.MAX_VALUE)
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
                    .addComponent(jTextFieldDatumOd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jTextFieldDatumDo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBoxKlijent, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldCena, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonOtkazi)
                    .addComponent(jButtonDodaj)
                    .addComponent(jButtonIzmeni))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonOtkaziActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonOtkaziActionPerformed
        this.dispose();
    }//GEN-LAST:event_jButtonOtkaziActionPerformed

    private void jButtonDodajActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonDodajActionPerformed
        try {
            if(jTextFieldDatumDo.getText().isEmpty() || jTextFieldDatumOd.getText().isEmpty() || jTextFieldCena.getText().isEmpty()){
                JOptionPane.showMessageDialog(this, "Sva polja moraju biti popunjena!", "Greska!", JOptionPane.ERROR_MESSAGE);
                return;
            }
            
            SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
            Date datumOd = sdf.parse(jTextFieldDatumOd.getText());
            Date datumDo = sdf.parse(jTextFieldDatumDo.getText());
            
            if(datumOd.after(datumDo)){
                JOptionPane.showMessageDialog(this, "Datum zavrsetka mora biti nakon datuma pocetka!", "Greska!", JOptionPane.ERROR_MESSAGE);
                return;
            }
            
            long razlikaUDanima = (datumDo.getTime() - datumOd.getTime()) / (1000 * 60 * 60 * 24);

            if (razlikaUDanima > 60) {
                JOptionPane.showMessageDialog(this, "Putovanje ne može trajati duže od 60 dana!", "Greška!", JOptionPane.ERROR_MESSAGE);
                return;
            }
            
            int cena = Integer.parseInt(jTextFieldCena.getText());
            TuristickaAgencija ulogovana = Session.getInstance().getUlogovana();
            Klijent klijent = (Klijent) jComboBoxKlijent.getSelectedItem();
            
            Rezervacija r = new Rezervacija(null, datumOd, datumDo, ulogovana, klijent, cena);
            KlijentskiKontroler.getInstance().addRezervacija(r);
            JOptionPane.showMessageDialog(this, "Uspesno dodata rezervacija.", "Obavestenje!", JOptionPane.INFORMATION_MESSAGE);
            this.dispose();
            
        } catch (Exception ex) {
            Logger.getLogger(FormaRezervacija.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButtonDodajActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonDodaj;
    private javax.swing.JButton jButtonIzmeni;
    private javax.swing.JButton jButtonOtkazi;
    private javax.swing.JComboBox jComboBoxKlijent;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JTextField jTextFieldCena;
    private javax.swing.JTextField jTextFieldDatumDo;
    private javax.swing.JTextField jTextFieldDatumOd;
    // End of variables declaration//GEN-END:variables
    public void popuniKlijente() {
            try {
                ArrayList<Klijent> klijenti = KlijentskiKontroler.getInstance().getAllKlijent();

                jComboBoxKlijent.removeAllItems();

                for (Klijent klijent : klijenti) {
                    jComboBoxKlijent.addItem(klijent);
                }

            } catch (Exception ex) {
                Logger.getLogger(MainForma.class.getName()).log(Level.SEVERE, null, ex);
            }
    }
}
