/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package so.rezervacija;

import database.DBBroker;
import domain.AbstractDomainObject;
import domain.Rezervacija;
import domain.StavkaRezervacije;
import so.AbstractSO;

/**
 *
 * @author Lenovo
 */
public class SOUpdateRezervacija extends AbstractSO{

    @Override 
    protected void validate(AbstractDomainObject ado) throws Exception {
        if(!(ado instanceof Rezervacija))
        {
            throw new Exception("Prosledjeni objekat nije instanca klase Rezervacija");
        }
    }

    @Override
    protected void execute(AbstractDomainObject ado) throws Exception {
        DBBroker.getInstance().update(ado);
    }
    
}
