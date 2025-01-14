/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package so.rezervacija;

import database.DBBroker;
import domain.AbstractDomainObject;
import domain.Rezervacija;
import java.util.ArrayList;
import so.AbstractSO;

/**
 *
 * @author Lenovo
 */
public class SOGetAllRezervacija extends AbstractSO{
    
    ArrayList<Rezervacija> lista;

    @Override
    protected void validate(AbstractDomainObject ado) throws Exception {
        if(!(ado instanceof Rezervacija))
        {
            throw new Exception("Prosledjeni objekat nije instanca klase Rezervacija");
        }
    }

    @Override
    protected void execute(AbstractDomainObject ado) throws Exception {
    ArrayList<AbstractDomainObject> rezervacije = DBBroker.getInstance().select(ado);
    lista = new ArrayList<>();

    for (AbstractDomainObject obj : rezervacije) {
        if (obj instanceof Rezervacija) {
            lista.add((Rezervacija) obj);
        } else {
            System.err.println("Nepodržan tip objekta: " + obj.getClass().getName());
        }
    }
}
    
    public ArrayList<Rezervacija> getLista(){
        return lista;
    }
}
