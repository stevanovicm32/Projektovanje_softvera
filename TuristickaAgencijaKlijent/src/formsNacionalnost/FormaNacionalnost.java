/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package formsNacionalnost;

import controller.KlijentskiKontroler;
import domain.Nacionalnost;
import java.awt.Window;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Lenovo
 */
public class FormaNacionalnost extends javax.swing.JDialog {
    Nacionalnost pomocna=null;
    /**
     * Creates new form FormaNacionalnost
     */
    public FormaNacionalnost(Window parent, boolean modal, Nacionalnost n, int signal) {
        super(parent, modal ? ModalityType.APPLICATION_MODAL : ModalityType.MODELESS);
        initComponents();
        setLocationRelativeTo(null);
        pomocna=n;
        switch (signal){
            case 0:
                setTitle("Dodavanje nacionalnosti");
                jTextFieldNaziv.setEditable(true);
                jTextFieldPrivilegije.setEditable(true);
                jButtonDodaj.setEnabled(true);
                jButtonIzmeni.setEnabled(false);
                break;
            case 1:
                setTitle("Detalji nacionalnosti");
                jTextFieldNaziv.setEditable(false);
                jTextFieldPrivilegije.setEditable(false);
                jTextFieldNaziv.setText(pomocna.getNaziv());
                jTextFieldPrivilegije.setText(pomocna.getPrivilegije());
                jButtonDodaj.setEnabled(false);
                jButtonIzmeni.setEnabled(false);
                break;
            case 2:
                setTitle("Izmena nacionalnosti");
                jTextFieldNaziv.setEditable(false);
                jTextFieldPrivilegije.setEditable(true);
                jTextFieldNaziv.setText(pomocna.getNaziv());
                jTextFieldPrivilegije.setText(pomocna.getPrivilegije());
                jButtonDodaj.setEnabled(false);
                jButtonIzmeni.setEnabled(true);
                break;
        }
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
        jLabel2 = new javax.swing.JLabel();
        jTextFieldNaziv = new javax.swing.JTextField();
        jTextFieldPrivilegije = new javax.swing.JTextField();
        jButtonDodaj = new javax.swing.JButton();
        jButtonIzmeni = new javax.swing.JButton();
        jButtonOtkazi = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setText("Naziv");

        jLabel2.setText("Privilegije");

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
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jTextFieldPrivilegije, javax.swing.GroupLayout.DEFAULT_SIZE, 211, Short.MAX_VALUE)
                            .addComponent(jTextFieldNaziv)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButtonOtkazi)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 56, Short.MAX_VALUE)
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
                    .addComponent(jTextFieldNaziv, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jTextFieldPrivilegije, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonOtkazi)
                    .addComponent(jButtonDodaj)
                    .addComponent(jButtonIzmeni))
                .addContainerGap(7, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonDodajActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonDodajActionPerformed
        try {
            if(jTextFieldNaziv.getText().isEmpty() || jTextFieldPrivilegije.getText().isEmpty()){
                JOptionPane.showMessageDialog(this, "Sva polja moraju biti popunjena!", "Greska!", JOptionPane.ERROR_MESSAGE);
                return;
            }

            String naziv = jTextFieldNaziv.getText();
            String privilegije = jTextFieldPrivilegije.getText();
            
            if(naziv.length()>50){
                JOptionPane.showMessageDialog(this, "Naziv mora imati manje od 50 slova!", "Greska!", JOptionPane.ERROR_MESSAGE);
                return;
            }else if(privilegije.length()>100){
                JOptionPane.showMessageDialog(this, "Privilegije moraju imati manje od 100 slova!", "Greska!", JOptionPane.ERROR_MESSAGE);
                return;
            }

            Nacionalnost n = new Nacionalnost(null, privilegije, naziv);

            KlijentskiKontroler.getInstance().addNacionalnost(n);
            JOptionPane.showMessageDialog(this, "Uspesno dodata nacionalnost.", "Obavestenje!", JOptionPane.INFORMATION_MESSAGE);
            this.dispose();
        } catch (Exception ex) {
            Logger.getLogger(FormaNacionalnost.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Greska!", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jButtonDodajActionPerformed

    private void jButtonIzmeniActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonIzmeniActionPerformed
        try {
            if(jTextFieldNaziv.getText().isEmpty() || jTextFieldPrivilegije.getText().isEmpty()){
                JOptionPane.showMessageDialog(this, "Sva polja moraju biti popunjena!", "Greska!", JOptionPane.ERROR_MESSAGE);
                return;
            }

            String naziv = jTextFieldNaziv.getText();
            String privilegije = jTextFieldPrivilegije.getText();
            
            if(naziv.length()>50){
                JOptionPane.showMessageDialog(this, "Naziv mora imati manje od 50 slova!", "Greska!", JOptionPane.ERROR_MESSAGE);
                return;
            }else if(privilegije.length()>100){
                JOptionPane.showMessageDialog(this, "Privilegije moraju imati manje od 100 slova!", "Greska!", JOptionPane.ERROR_MESSAGE);
                return;
            }

            Nacionalnost n = new Nacionalnost(pomocna.getIdNacionalnost(), privilegije, naziv);
            KlijentskiKontroler.getInstance().updateNacionalnost(n);

            JOptionPane.showMessageDialog(this, "Uspesno izmenjena nacionalnost.", "Obavestenje!", JOptionPane.INFORMATION_MESSAGE);
            this.dispose();
        } catch (Exception ex) {
            Logger.getLogger(FormaNacionalnost.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Greska!", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jButtonIzmeniActionPerformed

    private void jButtonOtkaziActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonOtkaziActionPerformed
        this.dispose();
    }//GEN-LAST:event_jButtonOtkaziActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonDodaj;
    private javax.swing.JButton jButtonIzmeni;
    private javax.swing.JButton jButtonOtkazi;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JTextField jTextFieldNaziv;
    private javax.swing.JTextField jTextFieldPrivilegije;
    // End of variables declaration//GEN-END:variables
}
