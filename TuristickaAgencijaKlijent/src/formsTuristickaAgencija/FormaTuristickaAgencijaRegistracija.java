/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package formsTuristickaAgencija;

import controller.KlijentskiKontroler;
import domain.TuristickaAgencija;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Lenovo
 */
public class FormaTuristickaAgencijaRegistracija extends javax.swing.JDialog {

    /**
     * Creates new form FormaTuristickaAgencijaRegistracija
     */
    public FormaTuristickaAgencijaRegistracija(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        setLocationRelativeTo(null);
        setTitle("Registracija agencije");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jTextFieldNaziv = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jTextFieldAdresa = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jTextFieldUsername = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jPasswordFieldSifraOpet = new javax.swing.JPasswordField();
        jPasswordFieldSifra = new javax.swing.JPasswordField();
        jButtonRegistracija = new javax.swing.JButton();
        jButtonOtkazi = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setText("Naziv agencije");

        jLabel2.setText("Adresa");

        jLabel3.setText("Username");

        jLabel4.setText("Sifra");

        jLabel5.setText("Ponovi sifru");

        jButtonRegistracija.setText("Registruj se!");
        jButtonRegistracija.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonRegistracijaActionPerformed(evt);
            }
        });

        jButtonOtkazi.setText("Otkazi");
        jButtonOtkazi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonOtkaziActionPerformed(evt);
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
                        .addComponent(jButtonOtkazi)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButtonRegistracija))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPasswordFieldSifra)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jPasswordFieldSifraOpet, javax.swing.GroupLayout.DEFAULT_SIZE, 281, Short.MAX_VALUE)
                                    .addComponent(jTextFieldUsername)
                                    .addComponent(jTextFieldAdresa)
                                    .addComponent(jTextFieldNaziv))
                                .addGap(0, 0, Short.MAX_VALUE)))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jTextFieldNaziv, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jTextFieldAdresa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jTextFieldUsername, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jPasswordFieldSifra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jPasswordFieldSifraOpet, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonRegistracija, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonOtkazi))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonOtkaziActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonOtkaziActionPerformed
        this.dispose();
    }//GEN-LAST:event_jButtonOtkaziActionPerformed

    private void jButtonRegistracijaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonRegistracijaActionPerformed
        try {
            String sifra = new String(jPasswordFieldSifra.getPassword());
            String sifra1 = new String(jPasswordFieldSifraOpet.getPassword());
            if(jTextFieldAdresa.getText().isEmpty() || jTextFieldNaziv.getText().isEmpty() || jTextFieldUsername.getText().isEmpty() || new String(jPasswordFieldSifra.getPassword()).isEmpty() || new String(jPasswordFieldSifraOpet.getPassword()).isEmpty()){
                JOptionPane.showMessageDialog(this, "Sva polja moraju biti popunjena!", "Greska!", JOptionPane.ERROR_MESSAGE);
                return;
            }else if(!sifra.equals(sifra1)){
                JOptionPane.showMessageDialog(this, "Sifra mora biti ista!", "Greska!", JOptionPane.ERROR_MESSAGE);
                return;
            }
            
            String adresa = jTextFieldAdresa.getText();
            String naziv = jTextFieldNaziv.getText();
            String username = jTextFieldUsername.getText();
            
            if(naziv.length()>50){
                JOptionPane.showMessageDialog(this, "Naziv mora imati manje od 50 slova!", "Greska!", JOptionPane.ERROR_MESSAGE);
                return;
            }else if(adresa.length()>100){
                JOptionPane.showMessageDialog(this, "Adresa mora imati manje od 100 slova!", "Greska!", JOptionPane.ERROR_MESSAGE);
                return;
            }else if(username.length()>30){
                JOptionPane.showMessageDialog(this, "Username mora imati manje od 30 slova!", "Greska!", JOptionPane.ERROR_MESSAGE);
                return;
            }else if(sifra.length()>30){
                JOptionPane.showMessageDialog(this, "Sifra mora imati manje od 30 slova!", "Greska!", JOptionPane.ERROR_MESSAGE);
                return;
            }
            
            TuristickaAgencija ta = new TuristickaAgencija(null, naziv, adresa, username, sifra);
            KlijentskiKontroler.getInstance().addTuristickaAgencija(ta);
            JOptionPane.showMessageDialog(this, "Uspesno registrovana agencija.", "Obavestenje!", JOptionPane.INFORMATION_MESSAGE);
            this.dispose();
        } catch (Exception ex) {
            Logger.getLogger(FormaTuristickaAgencijaRegistracija.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButtonRegistracijaActionPerformed

    /**
     * @param args the command line arguments
     */
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonOtkazi;
    private javax.swing.JButton jButtonRegistracija;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPasswordField jPasswordFieldSifra;
    private javax.swing.JPasswordField jPasswordFieldSifraOpet;
    private javax.swing.JTextField jTextFieldAdresa;
    private javax.swing.JTextField jTextFieldNaziv;
    private javax.swing.JTextField jTextFieldUsername;
    // End of variables declaration//GEN-END:variables
}
