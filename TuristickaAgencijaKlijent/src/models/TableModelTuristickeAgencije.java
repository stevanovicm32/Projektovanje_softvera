/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

import controller.KlijentskiKontroler;
import domain.TuristickaAgencija;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Lenovo
 */
public class TableModelTuristickeAgencije extends AbstractTableModel implements Runnable{
    
    private ArrayList<TuristickaAgencija> lista;
    private String[] kolone = {"ID", "naziv", "adresa", "username"};
    private String parametar = "";
    
        public TableModelTuristickeAgencije(){
        try {
            lista=KlijentskiKontroler.getInstance().getAllTuristickaAgencija();
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
    public Object getValueAt(int rowIndex, int columnIndex) {
        TuristickaAgencija ta = lista.get(rowIndex);
        
        switch (columnIndex) {
            case 0:
                return ta.getIdAgencije();
            case 1:
                return ta.getNaziv();
            case 2:
                return ta.getAdresa();
            case 3:
                return ta.getUsername();
                
            default:
                return null;
        }      
    }
    
    public TuristickaAgencija getSelectedTuristickaAgencija(int row){
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
            lista = KlijentskiKontroler.getInstance().getAllTuristickaAgencija();
            if(!parametar.equals("")){
                ArrayList<TuristickaAgencija> novaLista = new ArrayList<>();
                for (TuristickaAgencija agencija : lista) {
                    if(agencija.getNaziv().contains(parametar)){
                        novaLista.add(agencija);
                    }
                }
                lista = novaLista;
            }
            
            fireTableDataChanged();
            
        } catch (Exception ex) {
            Logger.getLogger(TableModelRezervacije.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
}
