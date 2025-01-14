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
public class SOUpdateDestinacija extends AbstractSO{

    @Override
    protected void validate(AbstractDomainObject ado) throws Exception {
        if (!(ado instanceof Destinacija)) {
            throw new Exception("Prosledjeni objekat nije instanca klase Destinacija!");
        }

        Destinacija novaDestinacija = (Destinacija) ado;

        ArrayList<Destinacija> destinacije = (ArrayList<Destinacija>) (ArrayList<?>) DBBroker.getInstance().select(ado);

        for (Destinacija destinacija : destinacije) {
            if (destinacija.getNazivDestinacije().equalsIgnoreCase(novaDestinacija.getNazivDestinacije())) {
                throw new Exception("Vec postoji destinacija s tim nazivom!");
            }
        }
    }

    @Override
    protected void execute(AbstractDomainObject ado) throws Exception {
        DBBroker.getInstance().update(ado);
    }
    
}
