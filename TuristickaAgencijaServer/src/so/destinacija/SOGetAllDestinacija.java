/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package so.destinacija;

import database.DBBroker;
import domain.AbstractDomainObject;
import domain.Destinacija;
import java.util.ArrayList;
import so.AbstractSO;

/**
 *
 * @author Lenovo
 */
public class SOGetAllDestinacija extends AbstractSO{

    private ArrayList<Destinacija> lista;
    
    @Override
    protected void validate(AbstractDomainObject ado) throws Exception {
        if (!(ado instanceof Destinacija)) {
            throw new Exception("Prosledjeni objekat nije instanca klase Destinacija");
        }
    }

    @Override
    protected void execute(AbstractDomainObject ado) throws Exception {
        ArrayList<AbstractDomainObject> destinacije = DBBroker.getInstance().select(ado);
        lista = (ArrayList<Destinacija>) (ArrayList<?>) destinacije;
    }
    
    public ArrayList<Destinacija> getLista(){
        return lista;
    }
}
