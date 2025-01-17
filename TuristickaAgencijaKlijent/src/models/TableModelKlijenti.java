/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import controller.KlijentskiKontroler;
import domain.Klijent;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.AbstractTableModel;

public class TableModelKlijenti extends AbstractTableModel implements Runnable {

    private ArrayList<Klijent> lista;
    private String[] kolone = {"ID", "Ime", "Prezime", "Telefon", "Email", "Adresa", "Nacionalnost"};
    private String parametar = "";

    public TableModelKlijenti() {
        try {
            lista = KlijentskiKontroler.getInstance().getAllKlijent();
        } catch (Exception ex) {
            Logger.getLogger(TableModelKlijenti.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public int getRowCount() {
        return lista.size();
    }

    @Override
    public int getColumnCount() {
        return kolone.length;
    }

    @Override
    public String getColumnName(int i) {
        return kolone[i];
    }

    @Override
    public Object getValueAt(int row, int column) {
        Klijent k = lista.get(row);

        switch (column) {
            case 0:
                return k.getIdKlijent();
            case 1:
                return k.getIme();
            case 2:
                return k.getPrezime();
            case 3:
                return k.getTelefon();
            case 4:
                return k.getEmail();
            case 5:
                return k.getAdresa();
            case 6:
                return k.getNacionalnost().getNaziv();

            default:
                return null;
        }
    }

    public Klijent getSelectedKlijent(int row) {
        return lista.get(row);
    }

    @Override
    public void run() {
        try {
            while (!Thread.currentThread().isInterrupted()) {
                Thread.sleep(10000);
                refreshTable();
                refreshTable2();
                refreshTable3();
            }
        } catch (InterruptedException ex) {
            Logger.getLogger(TableModelKlijenti.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void setParametar(String parametar) {
        this.parametar = parametar;
        refreshTable();
    }

    public void refreshTable() {
        try {
            lista = KlijentskiKontroler.getInstance().getAllKlijent();
            if (!parametar.equals("")) {
                ArrayList<Klijent> novaLista = new ArrayList<>();
                for (Klijent k : lista) {
                    if (k.getIme().toLowerCase().contains(parametar.toLowerCase())
                            || k.getPrezime().toLowerCase().contains(parametar.toLowerCase())) {
                        novaLista.add(k);
                    }
                }
                lista = novaLista;
            }

            fireTableDataChanged();

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void setParametar2(String parametar) {
        this.parametar = parametar;
        refreshTable2();
    }

    public void refreshTable2() {
        try {
            lista = KlijentskiKontroler.getInstance().getAllKlijent();
            if (!parametar.equals("")) {
                ArrayList<Klijent> novaLista = new ArrayList<>();
                for (Klijent k : lista) {
                    if (k.getNacionalnost().getNaziv().equalsIgnoreCase(parametar)) {
                        novaLista.add(k);
                    }
                }
                lista = novaLista;
            }

            fireTableDataChanged();

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    
    public void setParametar3(String parametar) {
        this.parametar = parametar;
        refreshTable3();
    }

    public void refreshTable3() {
        try {
            lista = KlijentskiKontroler.getInstance().getAllKlijent();
            if (!parametar.equals("")) {
                ArrayList<Klijent> novaLista = new ArrayList<>();
                for (Klijent k : lista) {
                    if (k.getEmail().contains(parametar)) {
                        novaLista.add(k);
                    }
                }
                lista = novaLista;
            }

            fireTableDataChanged();

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
