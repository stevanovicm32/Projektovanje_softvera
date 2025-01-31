/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

import controller.KlijentskiKontroler;
import domain.VrstaUsluge;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Lenovo
 */
public class TableModelVrsteUsluge extends AbstractTableModel implements Runnable{

    private ArrayList<VrstaUsluge> lista;
    private String[] kolone = {"ID", "Naziv", "Opis"};
    private String parametar = "";
    
    public TableModelVrsteUsluge(){
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
    
    public void setParametar(String parametar){
        this.parametar = parametar;
        refreshTable();
    }

    public void refreshTable() {
        try {
            lista = KlijentskiKontroler.getInstance().getAllVrstaUsluge();
            if (!parametar.equals("")) {
                ArrayList<VrstaUsluge> novaLista = new ArrayList<>();
                for (VrstaUsluge vrsta : lista) {
                    if (vrsta.getNazivUsluge().contains(parametar)){
                        novaLista.add(vrsta);
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
