/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

import controller.KlijentskiKontroler;
import domain.Destinacija;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Lenovo
 */
public class TableModelDestinacija extends AbstractTableModel implements Runnable{
    
    private ArrayList<Destinacija> lista;
    private String[] kolone = {"ID", "Naziv", "Opis", "Država", "Kontinent"};
    private String parametar = "";
    
    public TableModelDestinacija(){
        try {
            lista = KlijentskiKontroler.getInstance().getAllDestinacija();
        } catch (Exception ex) {
            Logger.getLogger(TableModelDestinacija.class.getName()).log(Level.SEVERE, null, ex);
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
        Destinacija d = lista.get(rowIndex);
        
        switch (columnIndex){
            case 0:
                return d.getIdDestinacije();
            case 1:
                return d.getNazivDestinacije();
            case 2:
                return d.getOpisDestinacije();
            case 3:
                return d.getDrzava();
            case 4:
                return d.getKontinent();
                
            default:
                return null;
        }
    }
    
    public Destinacija getSelectedDestinacija(int row){
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
    
    public void setParametar(String parametar){
        this.parametar = parametar;
        refreshTable();
    }
    
    public void refreshTable(){
        try {
            lista=KlijentskiKontroler.getInstance().getAllDestinacija();
            if(!parametar.equals("")){
                ArrayList<Destinacija> novaLista = new ArrayList<>();
                for (Destinacija destinacija : lista) {
                    if(destinacija.getNazivDestinacije().toLowerCase().contains(parametar.toLowerCase())){
                        novaLista.add(destinacija);
                    }               
                }
                lista=novaLista;
            }
            
            fireTableDataChanged();
        } catch (Exception ex) {
            Logger.getLogger(TableModelDestinacija.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void setParametar2(String parametar){
        this.parametar = parametar;
        refreshTable2();
    }
    
    public void refreshTable2(){
        try {
            lista=KlijentskiKontroler.getInstance().getAllDestinacija();
            if(!parametar.equals("")){
                ArrayList<Destinacija> novaLista = new ArrayList<>();
                for (Destinacija destinacija : lista) {
                    if(destinacija.getKontinent().equalsIgnoreCase(parametar)){
                        novaLista.add(destinacija);
                    }               
                }
                lista=novaLista;
            }
            
            fireTableDataChanged();
        } catch (Exception ex) {
            Logger.getLogger(TableModelDestinacija.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void setParametar3(String parametar){
        if(parametar!=null){
            this.parametar = parametar;
            refreshTable3();
        }
    }
    
    public void refreshTable3(){
        try {
            lista=KlijentskiKontroler.getInstance().getAllDestinacija();
            if(!parametar.equals("")){
                ArrayList<Destinacija> novaLista = new ArrayList<>();
                for (Destinacija destinacija : lista) {
                    if(destinacija.getDrzava().equalsIgnoreCase(parametar)){
                        novaLista.add(destinacija);
                    }               
                }
                lista=novaLista;
            }
            
            fireTableDataChanged();
        } catch (Exception ex) {
            Logger.getLogger(TableModelDestinacija.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
