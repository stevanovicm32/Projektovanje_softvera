/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

import controller.KlijentskiKontroler;
import domain.Nacionalnost;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Lenovo
 */
public class TableModelNacionalnosti extends AbstractTableModel implements Runnable  {
    
    private ArrayList<Nacionalnost> lista;
    private String[] kolone = {"ID", "Naziv", "Privilegije"};
    private String parametar = "";
    
    public TableModelNacionalnosti(){
        try {
            lista=KlijentskiKontroler.getInstance().getAllNacionalnost();
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
        Nacionalnost n = lista.get(rowIndex);
        
        switch (columnIndex){
            case 0:
                return n.getIdNacionalnost();
            case 1:
                return n.getNaziv();
            case 2:
                return n.getPrivilegije();
            default:
                return null;
        }
    }
    
    public Nacionalnost getSelectedNacionalnost(int row){
        return lista.get(row);
    }

    @Override
    public void run() {
        try {
            while (!Thread.currentThread().isInterrupted()) {
                Thread.sleep(10000);
                refreshTable();
                refreshTable2();
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
            lista = KlijentskiKontroler.getInstance().getAllNacionalnost();
            if (!parametar.equals("")) {
                ArrayList<Nacionalnost> novaLista = new ArrayList<>();
                for (Nacionalnost n : lista) {
                    if (n.getNaziv().contains(parametar)){
                        novaLista.add(n);
                    }
                }
                lista = novaLista;
            }

            fireTableDataChanged();

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    
    public void setParametar2(String parametar){
        this.parametar = parametar;
        refreshTable2();
    }

    public void refreshTable2() {
        try {
            lista = KlijentskiKontroler.getInstance().getAllNacionalnost();
            if (!parametar.equals("")) {
                ArrayList<Nacionalnost> novaLista = new ArrayList<>();
                for (Nacionalnost n : lista) {
                    if (n.getPrivilegije().contains(parametar)){
                        novaLista.add(n);
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
