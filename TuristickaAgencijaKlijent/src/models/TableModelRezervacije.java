/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

import controller.KlijentskiKontroler;
import domain.Rezervacija;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Lenovo
 */
public class TableModelRezervacije extends AbstractTableModel implements Runnable{
    private ArrayList<Rezervacija> lista;
    private String[] kolone = {"ID", "Datum od", "Datum do", "Agencija", "Klijent", "Cena"};
    private String parametar = "";
    
    public TableModelRezervacije(){
        try {
            lista=KlijentskiKontroler.getInstance().getAllRezervacija();
        } catch (Exception ex) {
            Logger.getLogger(TableModelRezervacije.class.getName()).log(Level.SEVERE, null, ex);
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
    Object obj = lista.get(row);
    if (obj instanceof Rezervacija) {
        Rezervacija r = (Rezervacija) obj;
        SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
        switch (column) {
            case 0:
                return r.getIdRezervacije();
            case 1:
                return sdf.format(r.getDatum());
            case 2:
                return sdf.format(r.getDatumDo());
            case 3:
                return r.getAgencija().toString();
            case 4:
                return r.getKlijent().toString();
            case 5:
                return r.getCena() + " €";
            default:
                return null;
        }
    } else {
        throw new ClassCastException("Objekat u listi nije tipa Rezervacija: " + obj.toString());
    }
}

    public Rezervacija getSelectedRezervacija(int row){
        return lista.get(row);
    }
    
    @Override
    public void run() {
            try {
                while(!Thread.currentThread().isInterrupted()){
                Thread.sleep(10000);
                refreshTable();
                }
            } catch (InterruptedException ex) {
                Logger.getLogger(TableModelRezervacije.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    
    public void setParametar(String parametar){
        this.parametar = parametar;
        refreshTable();
    }

    public void refreshTable() {
        try {
            lista = KlijentskiKontroler.getInstance().getAllRezervacija();
            if(!parametar.equals("")){
                ArrayList<Rezervacija> novaLista = new ArrayList<>();
                String ime = "";
                String prezime = "";
                for (Rezervacija rezervacija : lista) {
                    ime=rezervacija.getKlijent().getIme().toLowerCase();
                    prezime=rezervacija.getKlijent().getPrezime().toLowerCase();
                    if(ime.contains(parametar.toLowerCase()) || prezime.contains(parametar.toLowerCase())){
                        novaLista.add(rezervacija);
                    }
                }
                lista = novaLista;
            }
            
            fireTableDataChanged();
            
        } catch (Exception ex) {
            Logger.getLogger(TableModelRezervacije.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void setParametar1(String parametar){
        this.parametar = parametar;
        refreshTable1();
    }

    public void refreshTable1() {
        try {
            lista = KlijentskiKontroler.getInstance().getAllRezervacija();
            ArrayList<Rezervacija> novaLista = new ArrayList<>();
            for (Rezervacija rezervacija : lista) {
                if(rezervacija.getAgencija().getNaziv().equals(parametar)){
                    novaLista.add(rezervacija);
                }
            }
            lista = novaLista;
            fireTableDataChanged();
            
        } catch (Exception ex) {
            Logger.getLogger(TableModelRezervacije.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
