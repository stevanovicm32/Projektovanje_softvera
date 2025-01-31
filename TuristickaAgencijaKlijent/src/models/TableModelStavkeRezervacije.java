/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

import controller.KlijentskiKontroler;
import domain.Rezervacija;
import domain.StavkaRezervacije;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Lenovo
 */
public class TableModelStavkeRezervacije extends AbstractTableModel implements Runnable{
    
    Rezervacija r = null;
    private ArrayList<StavkaRezervacije> lista;
    private String[] kolone = {"ID", "Naziv", "Opis", "Destinacija", "Cena"};
    
    public TableModelStavkeRezervacije(Rezervacija r){
        try {
            this.r=r;
            lista=KlijentskiKontroler.getInstance().getAllStavkaRezervacije();
        } catch (Exception ex) {
            Logger.getLogger(TableModelStavkeRezervacije.class.getName()).log(Level.SEVERE, null, ex);
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
    public Object getValueAt(int rowIndex, int columnIndex) {
        StavkaRezervacije sr = lista.get(rowIndex);
        
        switch (columnIndex){
            case 0:
                return sr.getIdStavke();
            case 1:
                return sr.getNazivStavke();
            case 2:
                return sr.getOpisStavke();
            case 3:
                return sr.getDestinacija().getNazivDestinacije();
            case 4:
                return sr.getCena() + " €";
            
            default:
                return null;
        }
    }

    @Override
    public void run() {
        try {
                while(!Thread.currentThread().isInterrupted()){
                Thread.sleep(10000);
                refreshTable();
                }
            } catch (InterruptedException ex) {
                Logger.getLogger(TableModelStavkeRezervacije.class.getName()).log(Level.SEVERE, null, ex);
            }
    }
    
    public void refreshTable() {
        try {
            lista = KlijentskiKontroler.getInstance().getAllStavkaRezervacije();
            ArrayList<StavkaRezervacije> novaLista = new ArrayList<>();
            for (StavkaRezervacije s : lista) {
                if (s.getRezervacija().getIdRezervacije().equals(r.getIdRezervacije())) {
                    novaLista.add(s);
                }
            }
            lista = novaLista;
            fireTableDataChanged();
            
        } catch (Exception ex) {
            Logger.getLogger(TableModelStavkeRezervacije.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public StavkaRezervacije getSelectedStavkaRezervacije(int row){
        return lista.get(row);
    }
    
    public ArrayList<StavkaRezervacije> getLista(){
        return lista;
    }
}
