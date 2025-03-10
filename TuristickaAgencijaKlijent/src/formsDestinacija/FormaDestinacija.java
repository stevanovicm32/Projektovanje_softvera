/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package formsDestinacija;

import controller.KlijentskiKontroler;
import domain.Destinacija;
import forms.MainForma;
import java.awt.Window;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Lenovo
 */
public class FormaDestinacija extends javax.swing.JDialog {
    Destinacija pomocna=null;
    /**
     * Creates new form FormaDestinacija
     */
    public FormaDestinacija(Window parent, boolean modal, Destinacija d, int signal) {
        super(parent, modal ? ModalityType.APPLICATION_MODAL : ModalityType.MODELESS);
        initComponents();
        jComboBoxDrzava.setEnabled(false);
        setLocationRelativeTo(null);
        pomocna=d;
        switch (signal){
            case 0:
                setTitle("Dodavanje destinacije");
                jTextFieldNaziv.setEditable(true);
                jTextFieldOpis.setEditable(true);
                jComboBoxKontinent.setEnabled(true);
                jTextFieldNaziv.setText("");
                jTextFieldOpis.setText("");
                jComboBoxDrzava.removeAllItems();
                jComboBoxDrzava.addItem(pomocna.getDrzava());
                jComboBoxKontinent.removeAll();
                jComboBoxKontinent.addItem(pomocna.getKontinent());
                jButtonIzmeni.setEnabled(false);
                break;
            case 1:
                setTitle("Detalji destinacije");
                jTextFieldNaziv.setEditable(false);
                jTextFieldOpis.setEditable(false);
                jComboBoxKontinent.setEnabled(false);
                jComboBoxDrzava.setEnabled(false);
                jTextFieldNaziv.setText(pomocna.getNazivDestinacije());
                jTextFieldOpis.setText(pomocna.getOpisDestinacije());
                jComboBoxDrzava.removeAllItems();
                jComboBoxDrzava.addItem(pomocna.getDrzava());
                jComboBoxKontinent.removeAll();
                jComboBoxKontinent.addItem(pomocna.getKontinent());
                jButtonIzmeni.setEnabled(false);
                jButtonDodaj.setEnabled(false);
                break;
            case 2:
                setTitle("Izmena destinacije");
                jTextFieldNaziv.setEditable(true);
                jTextFieldOpis.setEditable(true);
                jComboBoxKontinent.setEnabled(false);
                jComboBoxDrzava.setEnabled(false);
                jTextFieldNaziv.setText(pomocna.getNazivDestinacije());
                jTextFieldOpis.setText(pomocna.getOpisDestinacije());
                jComboBoxDrzava.removeAllItems();
                jComboBoxDrzava.addItem(pomocna.getDrzava());
                jComboBoxKontinent.removeAll();
                jComboBoxKontinent.addItem(pomocna.getKontinent());
                jButtonIzmeni.setEnabled(true);
                jButtonDodaj.setEnabled(false);
                break;
            default:
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
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jTextFieldNaziv = new javax.swing.JTextField();
        jTextFieldOpis = new javax.swing.JTextField();
        jComboBoxKontinent = new javax.swing.JComboBox<>();
        jComboBoxDrzava = new javax.swing.JComboBox<>();
        jButtonDodaj = new javax.swing.JButton();
        jButtonOtkazi = new javax.swing.JButton();
        jButtonIzmeni = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setText("Naziv");

        jLabel2.setText("Opis destinacije");

        jLabel3.setText("Drzava");

        jLabel4.setText("Kontinent");

        jComboBoxKontinent.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Evropa", "Azija", "Afrika", "Severna Amerika", "Južna Amerika", "Australija i Okeanija" }));
        jComboBoxKontinent.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxKontinentActionPerformed(evt);
            }
        });

        jComboBoxDrzava.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Država" }));

        jButtonDodaj.setText("Dodaj");
        jButtonDodaj.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonDodajActionPerformed(evt);
            }
        });

        jButtonOtkazi.setText("Otkazi");
        jButtonOtkazi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonOtkaziActionPerformed(evt);
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
                        .addComponent(jTextFieldNaziv, javax.swing.GroupLayout.PREFERRED_SIZE, 269, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 36, Short.MAX_VALUE)
                        .addComponent(jTextFieldOpis, javax.swing.GroupLayout.PREFERRED_SIZE, 269, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jComboBoxDrzava, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jComboBoxKontinent, 0, 269, Short.MAX_VALUE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jButtonOtkazi)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButtonIzmeni)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonDodaj)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldNaziv, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jTextFieldOpis, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jComboBoxKontinent, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jComboBoxDrzava, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonDodaj)
                    .addComponent(jButtonOtkazi)
                    .addComponent(jButtonIzmeni))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jComboBoxKontinentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxKontinentActionPerformed
        jComboBoxDrzava.setEnabled(true);
        String kontinent=(String) jComboBoxKontinent.getSelectedItem();
        if(kontinent.equals("Evropa")){
            this.popuniComboBoxEvropa();
        }else if(kontinent.equals("Azija")){
            this.popuniComboBoxAzija();
        }else if(kontinent.equals("Afrika")){
            this.popuniComboBoxAfrika();
        }else if(kontinent.equals("Severna Amerika")){
            this.popuniComboBoxSeverna();
        }else if(kontinent.equals("Južna Amerika")){
            this.popuniComboBoxJuzna();
        }else if(kontinent.equals("Australija i Okeanija")){
            this.popuniComboBoxAustralija();
        }
    }//GEN-LAST:event_jComboBoxKontinentActionPerformed

    private void jButtonDodajActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonDodajActionPerformed
        try {
            if(jTextFieldNaziv.getText().isEmpty() || jTextFieldOpis.getText().isEmpty()){
                JOptionPane.showMessageDialog(this, "Sva polja moraju biti popunjena!", "Greska!", JOptionPane.ERROR_MESSAGE);
                return;
            }
            
            String naziv=jTextFieldNaziv.getText();
            String opis=jTextFieldOpis.getText();
            String drzava=(String) jComboBoxDrzava.getSelectedItem();
            String kontinent=(String) jComboBoxKontinent.getSelectedItem();
            
            if(naziv.length()>30){
                JOptionPane.showMessageDialog(this, "Naziv mora imati manje od 30 slova!", "Greska!", JOptionPane.ERROR_MESSAGE);
                return;
            }else if(opis.length()>100){
                JOptionPane.showMessageDialog(this, "Opis mora imati manje od 100 slova!", "Greska!", JOptionPane.ERROR_MESSAGE);
                return;
            }
            
            Destinacija d=new Destinacija(null, naziv, opis, drzava, kontinent);
            
            KlijentskiKontroler.getInstance().addDestinacija(d);
            MainForma mf = (MainForma) getParent();
            mf.popuniKlijente();
            JOptionPane.showMessageDialog(this, "Uspesno dodat klijent.", "Obavestenje!", JOptionPane.INFORMATION_MESSAGE);
            this.dispose();
        } catch (Exception ex) {
            Logger.getLogger(FormaDestinacija.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButtonDodajActionPerformed

    private void jButtonOtkaziActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonOtkaziActionPerformed
        this.dispose();
    }//GEN-LAST:event_jButtonOtkaziActionPerformed

    private void jButtonIzmeniActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonIzmeniActionPerformed
        try {
            if(jTextFieldNaziv.getText().isEmpty() || jTextFieldOpis.getText().isEmpty()){
                JOptionPane.showMessageDialog(this, "Sva polja moraju biti popunjena!", "Greska!", JOptionPane.ERROR_MESSAGE);
                return;
            }
            
            String naziv=jTextFieldNaziv.getText();
            String opis=jTextFieldOpis.getText();
            String drzava=(String) jComboBoxDrzava.getSelectedItem();
            String kontinent=(String) jComboBoxKontinent.getSelectedItem();
            
            if(naziv.length()>30){
                JOptionPane.showMessageDialog(this, "Naziv mora imati manje od 30 slova!", "Greska!", JOptionPane.ERROR_MESSAGE);
                return;
            }else if(opis.length()>100){
                JOptionPane.showMessageDialog(this, "Opis mora imati manje od 100 slova!", "Greska!", JOptionPane.ERROR_MESSAGE);
                return;
            }
            
            Destinacija d = new Destinacija(pomocna.getIdDestinacije(), naziv, opis, drzava, kontinent);
            KlijentskiKontroler.getInstance().updateDestinacija(d);
            
            JOptionPane.showMessageDialog(this, "Uspesno izmenjena destinacija.", "Obavestenje!", JOptionPane.INFORMATION_MESSAGE);
            this.dispose();
        } catch (Exception ex) {
            Logger.getLogger(FormaDestinacija.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(this, "Doslo je do greske prilikom izmene destinacije, pokusajte ponovo!", "Greska!", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jButtonIzmeniActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonDodaj;
    private javax.swing.JButton jButtonIzmeni;
    private javax.swing.JButton jButtonOtkazi;
    private javax.swing.JComboBox<String> jComboBoxDrzava;
    private javax.swing.JComboBox<String> jComboBoxKontinent;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JTextField jTextFieldNaziv;
    private javax.swing.JTextField jTextFieldOpis;
    // End of variables declaration//GEN-END:variables

    private void popuniComboBoxEvropa() {
        jComboBoxDrzava.removeAllItems();

        String[] evropskeDrzave = {
            "Albanija", "Andora", "Austrija", "Belgija", "Belorusija", 
            "Bosna i Hercegovina", "Bugarska", "Crna Gora", "Češka", 
            "Danska", "Estonija", "Finska", "Francuska", "Grčka", 
            "Holandija", "Hrvatska", "Irska", "Island", "Italija", 
            "Kipar", "Letonija", "Litvanija", "Luksemburg", "Mađarska", 
            "Malta", "Moldavija", "Monako", "Nemačka", "Norveška", 
            "Poljska", "Portugal", "Rumunija", "San Marino", 
            "Severna Makedonija", "Slovačka", "Slovenija", 
            "Srbija", "Španija", "Švedska", "Švajcarska", "Ukrajina", "Velika Britanija", "Vatikan"
        };

        for (String drzava : evropskeDrzave) {
            jComboBoxDrzava.addItem(drzava);
        }
    }

    private void popuniComboBoxAzija() {
        jComboBoxDrzava.removeAllItems();

        String[] azijskeDrzave = {
            "Afganistan", "Armenija", "Azerbejdžan", "Bahrein", "Bangladeš", 
            "Butan", "Brunej", "Filipini", "Gruzijа", "Indija", "Indonezija", 
            "Iran", "Irač", "Izrael", "Japan", "Jemen", "Jordan", 
            "Kazahstan", "Kina", "Kirgistan", "Kuvajt", "Laos", 
            "Liban", "Malezija", "Maldivi", "Mjanmar (Burma)", "Mongolija", 
            "Nepal", "Oman", "Pakistan", "Palestina", "Saudijska Arabija", 
            "Singapur", "Sirija", "Južna Koreja", "Severna Koreja", 
            "Šri Lanka", "Tadžikistan", "Tajland", "Timor-Leste", 
            "Turkmenistan", "Turska", "Ujedinjeni Arapski Emirati", 
            "Uzbekistan", "Vijetnam"
        };

        for (String drzava : azijskeDrzave) {
            jComboBoxDrzava.addItem(drzava);
        }
    }

    private void popuniComboBoxAfrika() {
        jComboBoxDrzava.removeAllItems();
        
        String[] africkeDrzave = {
            "Alžir", "Angola", "Benin", "Bocvana", "Burkina Faso", 
            "Burundi", "Centralnoafrička Republika", "Čad", "Džibuti", 
            "Eritreja", "Esvatini (Svazilend)", "Etiopija", "Gabon", 
            "Gambija", "Gana", "Gvineja", "Gvineja-Bisau", "Ekvatorijalna Gvineja", 
            "Južni Sudan", "Južnoafrička Republika", "Kamerun", "Kap Verde", 
            "Kenija", "Komori", "Kongo", "Demokratska Republika Kongo", 
            "Lesoto", "Liberija", "Libija", "Madagaskar", "Malavi", 
            "Mali", "Maroko", "Mauricijus", "Mauritanija", "Mozambik", 
            "Namibija", "Niger", "Nigerija", "Ruanda", "Sao Tome i Principe", 
            "Sejšeli", "Senegal", "Sijera Leone", "Somalija", 
            "Sudan", "Tanzanija", "Togo", "Tunis", "Uganda", "Zambija", "Zimbabve"
        };

        for (String drzava : africkeDrzave) {
            jComboBoxDrzava.addItem(drzava);
        }
    }

    private void popuniComboBoxSeverna() {
        jComboBoxDrzava.removeAllItems();

        String[] severnoamerickeDrzave = {
            "Antigva i Barbuda", "Bahami", "Barbados", "Belize", 
            "Kanada", "Kostarika", "Kuba", "Dominika", "Dominikanska Republika", 
            "El Salvador", "Grenada", "Gvatemala", "Haiti", "Honduras", 
            "Jamajka", "Meksiko", "Nikaragva", "Panama", "Sveti Kristofor i Nevis", 
            "Sveti Vinsent i Grenadini", "Sveti Lucija", "Sjedinjene Američke Države", "Trinidad i Tobago"
        };

        for (String drzava : severnoamerickeDrzave) {
            jComboBoxDrzava.addItem(drzava);
        }
    }

    private void popuniComboBoxJuzna() {
        jComboBoxDrzava.removeAllItems();

        String[] juznoamerickeDrzave = {
            "Argentina", "Bolivija", "Brazil", "Čile", "Kolumbija", 
            "Ekvador", "Gvajana", "Paragvaj", "Peru", "Surinam", 
            "Urugvaj", "Venecuela", "Francuska Gvajana (Francuski prekomorski departman)"
        };

        for (String drzava : juznoamerickeDrzave) {
            jComboBoxDrzava.addItem(drzava);
        }
    }

    private void popuniComboBoxAustralija() {
        jComboBoxDrzava.removeAllItems();

        String[] australijaIOkeanija = {
            "Australija", "Fidži", "Kiribati", "Maršalska Ostrva", 
            "Mikronezija", "Nauru", "Novi Zeland", "Palau", 
            "Papua Nova Gvineja", "Samoa", "Solomonska Ostrva", 
            "Tonga", "Tuvalu", "Vanuatu"
        };

        for (String drzava : australijaIOkeanija) {
            jComboBoxDrzava.addItem(drzava);
        }
    }
}
