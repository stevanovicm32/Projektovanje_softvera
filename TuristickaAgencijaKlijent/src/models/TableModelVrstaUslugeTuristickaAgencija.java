/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

import controller.KlijentskiKontroler;
import domain.TAVU;
import domain.VrstaUsluge;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Lenovo
 */
public class TableModelVrstaUslugeTuristickaAgencija extends AbstractTableModel implements Runnable{

    private ArrayList<VrstaUsluge> lista;
    private String[] kolone = {"ID", "Naziv", "Opis"};
    private long parametar = 1L;
    
    public TableModelVrstaUslugeTuristickaAgencija(){
        try {
            lista=KlijentskiKontroler.getInstance().getAllVrstaUsluge();
        } catch (Exception ex) {
            Logger.getLogger(TableModelNacionalnosti.class.getName()).log(Level.SEVERE, null, ex);
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
    public String getColumnName(int column) {
        return kolone[column];
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        VrstaUsluge vu = lista.get(rowIndex);
        
        switch (columnIndex){
            case 0:
                return vu.getIdVrstaUsluge();
            case 1:
                return vu.getNazivUsluge();
            case 2:
                return vu.getOpisUsluge();
            default:
                return null;
        }
    }
    
    public VrstaUsluge getSelectedVrstaUsluge(int row){
        return lista.get(row);
    }


    @Override
    public void run() {
         try {
            while (!Thread.currentThread().isInterrupted()) {
                Thread.sleep(10000);
                refreshTable();
            }
        } catch (InterruptedException ex) {
            Logger.getLogger(TableModelKlijenti.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void setParametar(long parametar){
        this.parametar = parametar;
        refreshTable();
    }

    public void refreshTable() {
        try {
            ArrayList<TAVU> listatavu = KlijentskiKontroler.getInstance().getAllTAVU();
            lista = KlijentskiKontroler.getInstance().getAllVrstaUsluge();
            ArrayList<VrstaUsluge> novaLista = new ArrayList<>();
            for (TAVU tavu : listatavu) {
                if (tavu.getAgencija().getIdAgencije().equals(parametar)) {
                    for (VrstaUsluge vrsta : lista) {
                        if (vrsta.getIdVrstaUsluge().equals(tavu.getUsluga().getIdVrstaUsluge())) {
                            novaLista.add(vrsta);
                        }
                    }
                }
            }
            lista = novaLista;

            fireTableDataChanged();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    
    public ArrayList<VrstaUsluge> getLista(){
        return lista;
    }
}
