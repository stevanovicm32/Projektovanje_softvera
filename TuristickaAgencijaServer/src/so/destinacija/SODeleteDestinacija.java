/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package so.destinacija;

import database.DBBroker;
import domain.AbstractDomainObject;
import domain.Destinacija;
import so.AbstractSO;

/**
 *
 * @author Lenovo
 */
public class SODeleteDestinacija extends AbstractSO{

    @Override
    protected void validate(AbstractDomainObject ado) throws Exception {
        if (!(ado instanceof Destinacija)) {
            throw new Exception("Prosledjeni objekat nije instanca klase Destinacija!");
        }
    }

    @Override
    protected void execute(AbstractDomainObject ado) throws Exception {
        DBBroker.getInstance().delete(ado);
    }
    
}
